package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * The main "Spring" configuration class for the application.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.example")
public class AppConfig {
}
