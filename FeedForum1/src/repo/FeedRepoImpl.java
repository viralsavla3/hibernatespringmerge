package repo;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Comment;
import entity.Feed;
import entity.User;

@Repository
public class FeedRepoImpl implements FeedRepo {
	@Autowired
	private SessionFactory factory;

	@Override
	public void askQuestion(Feed feed) {

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(feed);
		txn.commit();
	}

	@Override
	public List<Feed> getMyFeed(String userId) {
		Session session = factory.openSession();
		String hql = "from Feed where userId=:uid order by FeedDate";
		return session.createQuery(hql).setParameter("uid", userId).list();
	}

	@Override
	public List<Feed> searchFeeds(String keyword) {
		String[] keywords = keyword.split(" ");
		Session session = factory.openSession();
		String hql = "from Feed where lower(query) like '% " + keywords[0].toLowerCase() + "%'";
		for (int i = 1; i < keywords.length; i++)
			hql += "or lower(query) like '%" + keywords[i].toLowerCase() + "%'";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public Feed submitComment(Comment comment) {

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(comment);
		txn.commit();

		return comment.getFeed();
	}

	@Override
	public Feed getQuestion(int fid) {
		Session session = factory.openSession();

		Feed feed = (Feed) session.get(Feed.class, fid);
		return feed;
	}

}
