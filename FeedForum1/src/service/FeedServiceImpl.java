package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Comment;
import entity.Feed;
import repo.FeedRepo;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedRepo repo;

	@Override
	public void askQuestion(Feed feed) {

		feed.setFeedDate(new Date());
		repo.askQuestion(feed);
	}

	@Override
	public List<Feed> getMyFeed(String userId) {
		return repo.getMyFeed(userId);
	}

	@Override
	public List<Feed> searchFeeds(String keyword) {
		return repo.searchFeeds(keyword);
	}

	@Override
	public Feed getQuestion(int fid) {
		return repo.getQuestion(fid);
	}

	@Override
	public Feed submitComment(Comment comment) {
		comment.setCommentDate(new Date());
		return repo.submitComment(comment);
	}

}
