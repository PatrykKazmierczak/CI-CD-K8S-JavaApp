package com.javafee.sapp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.javafee.sapp.model")
public class PostgreSQLDatabaseConfiguration {
}
