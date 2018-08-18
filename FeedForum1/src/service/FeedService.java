package service;

import java.util.List;

import entity.Comment;
import entity.Feed;

public interface FeedService {
	void askQuestion(Feed feed);

	List<Feed> getMyFeed(String userId);

	List<Feed> searchFeeds(String keyword);

	Feed submitComment(Comment comment);

	Feed getQuestion(int fid);

}
