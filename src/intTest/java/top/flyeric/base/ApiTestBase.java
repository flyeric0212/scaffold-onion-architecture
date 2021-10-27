package top.flyeric.base;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import top.flyeric.base.webmvc.JacksonConfiguration;
import top.flyeric.util.YamlDataSetLoader;

@Import({DbTestConfig.class, SecurityConfig.class, MockConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection", dataSetLoader = YamlDataSetLoader.class)
@TestExecutionListeners(
        value = {TransactionDbUnitTestExecutionListener.class, MockitoTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ApiTestBase {

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        initAssured(port);
    }

    private void initAssured(int port) {

        RestAssured.basePath = "/";
        RestAssured.port = port;

        RestAssured.requestSpecification =
                new RequestSpecBuilder().setContentType("application/json").build();

        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(
                ObjectMapperConfig.objectMapperConfig()
                        .jackson2ObjectMapperFactory((type, s) -> new JacksonConfiguration().objectMapper()));
    }

}
