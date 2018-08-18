package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "feeds1")
@SequenceGenerator(name = "sf", sequenceName = "seq_feed")
public class Feed {
	@Id
	@GeneratedValue(generator = "sf") // sequence is used to generate automatic value
	private int feedId;
	private String query;
	@Temporal(TemporalType.TIMESTAMP) // date or time or timestamp which needs to be specified
	private Date feedDate;
	@OneToMany(mappedBy = "feed", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Comment> comments;// OneToMany
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user; // ManytoOne

	@Formula("(select count(*) from comments c where c.feedId=feedId)")
	private int totalCmnts;
	
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public int getTotalCmnts() {
		return totalCmnts;
	}

	public void setTotalCmnts(int totalCmnts) {
		this.totalCmnts = totalCmnts;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Date getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(Date feedDate) {
		this.feedDate = feedDate;
	}

	public Set<Comment> getComment() {
		return comments;
	}

	public void setComment(Set<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
