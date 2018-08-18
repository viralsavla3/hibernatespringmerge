package repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;
import sun.print.resources.serviceui;

@Repository
public class UserRepoImpl implements UserRepo {
	@Autowired
	private SessionFactory sessionfactory; // repo is used to communicate with databse

	@Override
	public User authenticate(LoginBean login) {
		Session session = sessionfactory.openSession();
		User user = (User) session.get(User.class, login.getUserId());
		session.save(login);
		if (user != null && user.getPassword().equals(login.getpassword()))
			return user;
		else
			return null;
	}

	@Override
	public boolean validate(ForgetBean forget) {
		Session session = sessionfactory.openSession();
		User user = (User) session.get(User.class, forget.getEmail());
		if (user != null && user.getEmail().equals(forget.getEmail()))
			return true;
		else
			return false;
	}

	@Override
	public boolean changePassword(LoginBean change) {
		Session session = sessionfactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, change.getUserId());
			user.setPassword(change.getpassword());
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}

	@Override
	public boolean persist(User user) {
		Session session = sessionfactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(user);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
			return false;
		}
	}

}
