package dado.projects.tutorial.spring.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Root Configuration class, common for the whole application.
 * 
 * @author vstojov
 */
@Configuration
@Import({WebConfig.class})
public class RootConfig {
	
}
