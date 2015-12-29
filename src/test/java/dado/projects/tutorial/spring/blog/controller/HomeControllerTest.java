package dado.projects.tutorial.spring.blog.controller;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dado.projects.tutorial.spring.blog.config.RootConfig;
import dado.projects.tutorial.spring.blog.controller.HomeController;

/**
 * JUnit test for the {@link HomeController}.
 * 
 * @author vstojov
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class HomeControllerTest {
	
	@Autowired
	private HomeController controller;

	@Test
	public void testHomePage() throws Exception {
		assertEquals(controller.home(), "home");
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
}
