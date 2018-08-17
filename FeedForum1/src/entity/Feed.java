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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "feeds")
@SequenceGenerator(name="sf",sequenceName="seq_feed")
public class Feed {
	@Id
	@GeneratedValue(generator="sf") //sequence is used to generate automatic value
	private int feedId;
	private String question;
	@Temporal(TemporalType.TIMESTAMP) // date or time or timestamp which needs to be specified
	private Date feedDate;
	@OneToMany(mappedBy = "feed", cascade =  CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Comment> comments;// OneToMany
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user; // ManytoOne

	
	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
