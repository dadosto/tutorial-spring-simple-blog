package dado.projects.tutorial.spring.blog.config;

import dado.projects.tutorial.spring.blog.filters.ErrorHandlingFilter;
import dado.projects.tutorial.spring.blog.filters.ResponseFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Web app initializer.
 * 
 * @author vstojov
 */
public class BlogWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[]{new ErrorHandlingFilter(), new ResponseFilter()};
  }

}
