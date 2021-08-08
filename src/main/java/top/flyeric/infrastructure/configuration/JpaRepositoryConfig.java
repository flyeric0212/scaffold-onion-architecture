package top.flyeric.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import top.flyeric.base.jpa.BaseJpaRepositoryImpl;

@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class,
        basePackages = {"top.flyeric.infrastructure.persistence.repository",
                "top.flyeric.domain"})
@Configuration
public class JpaRepositoryConfig {
}
