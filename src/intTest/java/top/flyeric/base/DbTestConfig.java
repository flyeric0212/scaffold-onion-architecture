package top.flyeric.base;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import groovy.util.logging.Slf4j;

@Slf4j
@TestConfiguration
public class DbTestConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbTestConfig.class);

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean configBean = new DatabaseConfigBean();
        configBean.setEscapePattern("`?`");
        configBean.setAllowEmptyFields(true);
        configBean.setDatatypeFactory(new MySqlDataTypeFactory());
        return configBean;
    }

    @Bean(name = "dbUnitDatabaseConnection")
    public DatabaseDataSourceConnection dbUnitDatabaseConnection(DataSource dataSource,
                                                                 DatabaseConfigBean configBean) {
        DatabaseDataSourceConnectionFactoryBean factoryBean =
                new DatabaseDataSourceConnectionFactoryBean(dataSource);
        configBean.setMetadataHandler(new MySqlMetadataHandler());
        configBean.setCaseSensitiveTableNames(true);
        factoryBean.setDatabaseConfig(configBean);
        // ##<ChangeMe>
        factoryBean.setSchema("example");
        try {
            return factoryBean.getObject();
        } catch (Exception exception) {
            LOGGER.error("Failed to create database connection due to exception", exception);
            throw new RuntimeException(exception);
        }
    }
}
