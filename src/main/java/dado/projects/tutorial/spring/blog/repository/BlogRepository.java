package dado.projects.tutorial.spring.blog.repository;

import java.util.List;

import dado.projects.tutorial.spring.blog.model.BlogPost;

/**
 * Blog Repository interface. To be implemented by specific DAO.
 * 
 * @author vstojov
 */
public interface BlogRepository {
	
	/**
	 * Returns a list of BlogPosts.
	 * @param max - the maximum id of a BlogPost (the bigger, the more recent)
	 * @param count - how many BlogPosts to be fetched from the repository
	 * @return the result list of BlogPosts
	 */
  List<BlogPost> findBlogPosts(long max, int count);
  
  /**
   * Returns a blog post by its id.
   * @param id - the id of the blog post
   * @return - a BlogPost object with the specified id
   */
  BlogPost getBlogPostById(Long id);
}
