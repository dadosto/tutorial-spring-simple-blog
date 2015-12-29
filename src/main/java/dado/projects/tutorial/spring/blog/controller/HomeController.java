package dado.projects.tutorial.spring.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple Controller for our Blog app.
 * 
 * @author vstojov
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
	
	/**
	 * Whenever an HTTP GET request comes in for /, the home() method will be called.
	 * - request path "/"
	 * - type of (HTTP) request method "GET"
	 * 
	 * @return the name of the view that should be rendered.
	 * The dispatcher servlet will ask the view resolver to resolve this logical view
	 * name into an actual view.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}
}
