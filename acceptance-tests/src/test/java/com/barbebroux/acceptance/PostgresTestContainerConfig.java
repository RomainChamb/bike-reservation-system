package com.barbebroux.acceptance;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@TestConfiguration
public class PostgresTestContainerConfig {

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        private static final PostgreSQLContainer<?> postgres =
                new PostgreSQLContainer<>("postgres:15-alpine")
                        .withDatabaseName("acceptance")
                        .withUsername("test")
                        .withPassword("test");

        static {
            postgres.start();
        }

        @Override
        public void initialize(ConfigurableApplicationContext context) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgres.getJdbcUrl(),
                    "spring.datasource.username=" + postgres.getUsername(),
                    "spring.datasource.password=" + postgres.getPassword()
            ).applyTo(context.getEnvironment());
        }
    }
}
