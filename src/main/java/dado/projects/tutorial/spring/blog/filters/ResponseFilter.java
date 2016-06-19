package dado.projects.tutorial.spring.blog.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dado on 6/19/2016.
 */
public class ResponseFilter  implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(
          ServletRequest request,
          ServletResponse response,
          FilterChain chain) throws IOException, ServletException {

    if (StringUtils.isEmpty((String) request.getAttribute("prospectZoneId"))) {
      request.setAttribute("prospectZoneId", "12345");
      //request.getRequestDispatcher("/home")
      //        .forward(request, response);
    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}