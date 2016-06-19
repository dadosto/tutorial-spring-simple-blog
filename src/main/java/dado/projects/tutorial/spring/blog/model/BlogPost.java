package dado.projects.tutorial.spring.blog.model;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Data bean model class that represents a single blog post.
 * 
 * @author vstojov
 */
public class BlogPost {

  private final Long id;
  private final String title;
  private final String content;
  private final Date dateTime;
  private Double latitude;
  private Double longitude;
  private String loggedIn;

  public BlogPost(Long id, String title, String content, Date dateTime, Double latitude, Double longitude) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.dateTime = dateTime;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public boolean equals(Object that) {
    return EqualsBuilder.reflectionEquals(this, that, "id", "time");
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, "id", "time");
  }

  public String getLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(String loggedIn) {
    this.loggedIn = loggedIn;
  }
}
