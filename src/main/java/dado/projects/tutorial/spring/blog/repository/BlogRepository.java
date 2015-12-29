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
	List<BlogPost> findBlogs(long max, int count);
}
