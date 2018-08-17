package entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comments")
@SequenceGenerator(name="sc", sequenceName="seq_cmnt")
public class Comment {
	@Id
	@GeneratedValue(generator="sc")
	private int commentId;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP) // date or time or timestamp which needs to be specified
	private Date commentDate;
	@ManyToOne
	@JoinColumn(name = "feedId")
	private Feed feed; // ManytoOne
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user; // OnetoMany Unidirectional

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	
	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
