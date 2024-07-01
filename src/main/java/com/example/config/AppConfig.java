package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring MVC configuration class
 * Configures components to work with the web-interface, including scanning components, configuring view controllers and "ViewResolvers".
 */
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * Configures view controllers.
     *
     * @param registry view controller registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * Defines a "ViewResolver" to resolve view names into actual JSP-files.
     *
     * @return объект InternalResourceViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");

        return bean;
    }
}
