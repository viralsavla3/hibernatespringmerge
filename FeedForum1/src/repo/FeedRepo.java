package repo;

import java.util.List;

import entity.Comment;
import entity.Feed;

public interface FeedRepo {

	void askQuestion(Feed feed);

	List<Feed> getMyFeed(String userId);

	List<Feed> searchFeeds(String keyword);

	Feed submitComment(Comment comment);

	Feed getQuestion(int fid);
}
