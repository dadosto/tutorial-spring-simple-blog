package dado.projects.tutorial.spring.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dado.projects.tutorial.spring.blog.model.BlogPost;
import dado.projects.tutorial.spring.blog.repository.BlogRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * Simple Controller for our Blog app.
 * 
 * @author vstojov
 */
@Controller
@RequestMapping("/posts")
public class BlogController {

  @Autowired
  private BlogRepository blogRepository;

  @RequestMapping(method = RequestMethod.GET)
  public String blogPosts(
      Model model,
      @RequestParam(value = "max", defaultValue = Long.MAX_VALUE + "") long max,
      @RequestParam(value = "count", defaultValue = "20") int count) {
    model.addAttribute("blogPosts", blogRepository.findBlogPosts(max, count));
    return "blogPosts";
  }
  
  @RequestMapping(value = "/{blogPostId}", method = RequestMethod.GET)
  public String showBlogPost(
          HttpServletRequest request,
          @PathVariable("blogPostId") long blogPostId,
          Model model) {

    String loggedInAttributeName = "logged-in";
    model.addAttribute(loggedInAttributeName, "Active user: None");
    String prospectZoneId = "prospectZoneId";

    BlogPost blogPostById = blogRepository.getBlogPostById(blogPostId);
    if ("12345".equals(request.getAttribute(prospectZoneId))) {
      model.addAttribute(loggedInAttributeName, "Active user: " + request.getAttribute(prospectZoneId));
      blogPostById.setLoggedIn((String) request.getAttribute(prospectZoneId));
    }
    model.addAttribute("blogPost", blogPostById);

    return "blogPost";
  }



  /*@RequestMapping(value = "/showBlogPost", method = RequestMethod.GET)
  public String showBlogPost(Model model,
      @RequestParam("blogPostId") long blogPostId) {
    model.addAttribute("blogPost", blogRepository.getBlogPostById(blogPostId));
    return "blogPost";
  }*/

  /*@RequestMapping(method = RequestMethod.GET)
  public String posts(Model model) {
    model.addAttribute("blogPosts", blogRepository.findBlogPosts(Long.MAX_VALUE, 20));
    return "blogPosts";
  }*/
  
}