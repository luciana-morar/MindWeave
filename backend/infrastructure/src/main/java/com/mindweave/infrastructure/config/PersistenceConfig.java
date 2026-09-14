package com.mindweave.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EntityScan(basePackages = "com.mindweave.infrastructure")
@EnableJpaRepositories(basePackages = "com.mindweave.infrastructure")
@EnableNeo4jRepositories(basePackages = "com.mindweave.infrastructure")
public class PersistenceConfig {
}