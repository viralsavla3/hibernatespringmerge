package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "feeders")
public class User {
	@Id
	@Column(length=30)
	private String userId;
	@Column(length=65)
	private String password;
	@Column(length=50)
	private String email;
	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL , fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Feed> feeds;// OneToMany

	@Formula("(select count(*) from feeds1 f where f.userId=userId)")
	private int totalFeeds;
	
	
	public Set<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(Set<Feed> feeds) {
		this.feeds = feeds;
	}

	public int getTotalFeeds() {
		return totalFeeds;
	}

	public void setTotalFeeds(int totalFeeds) {
		this.totalFeeds = totalFeeds;
	}

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Feed> getFeed() {
		return feeds;
	}

	public void setFeed(Set<Feed> feeds) {
		this.feeds = feeds;
	}

}
