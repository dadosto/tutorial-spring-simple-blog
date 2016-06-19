package dado.projects.tutorial.spring.blog.controller;

import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import dado.projects.tutorial.spring.blog.config.RootConfig;
import dado.projects.tutorial.spring.blog.model.BlogPost;
import dado.projects.tutorial.spring.blog.repository.BlogRepository;

/**
 * JUnit test for the {@link BlogController}.
 * 
 * @author vstojov
 *
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class BlogControllerTest {

  @InjectMocks
  private BlogController controller = new BlogController();

  @Mock
  private BlogRepository blogRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  private List<BlogPost> createBlogPosts(int count) {
    String content = "content";
    Date dateTime = new Date();
    Double latitude = 1.24;
    Double longitude = 2.48;
    List<BlogPost> posts = LongStream.rangeClosed(1, count)
        .mapToObj(value -> new BlogPost(value, "title " + value, content, dateTime, latitude, longitude)).collect(Collectors.toList());
    return posts;
  }

  @Test
  public void shouldShowRecentBlogPosts() throws Exception {

    // Given
    List<BlogPost> posts = createBlogPosts(50);
    Mockito.when(blogRepository.findBlogPosts(Mockito.anyLong(), Mockito.anyInt())).thenReturn(posts);
    MockMvc mockMvc = standaloneSetup(controller)
        .setSingleView(new InternalResourceView("/WEB-INF/views/blogPosts.jsp")).build();

    // When & Then
    mockMvc.perform(get("/posts?max=238900&count=50")).andExpect(view().name("blogPosts"))
        .andExpect(model().attributeExists("blogPosts"))
        .andExpect(model().attribute("blogPosts", hasItems(posts.toArray())));

  }

  @Test
  public void shouldShowSpecifiedBlogPost() throws Exception {

    // Given
    BlogPost blogPost = new BlogPost(1l, "Title", "Content", new Date(), 0.0, 0.0);
    Mockito.when(blogRepository.getBlogPostById(Mockito.anyLong())).thenReturn(blogPost);
    MockMvc mockMvc = standaloneSetup(controller)
        .setSingleView(new InternalResourceView("/WEB-INF/views/blogPosts.jsp")).build();

    // When & Then
    mockMvc.perform(get("/posts/238900")).andExpect(view().name("blogPost"))
        .andExpect(model().attributeExists("blogPost"));
    
    // With query params
    //mockMvc.perform(get("/showBlogPost?blogPostId=238900")).andExpect(view().name("blogPost"))
    //.andExpect(model().attributeExists("blogPost"));

  }

}