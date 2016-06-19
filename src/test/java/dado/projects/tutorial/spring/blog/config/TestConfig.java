package dado.projects.tutorial.spring.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dado.projects.tutorial.spring.blog.controller.ControllersPackage;

/**
 * 
 * @author vstojov
 */
@Configuration
@Import(WebConfig.class)
public class TestConfig {
}
