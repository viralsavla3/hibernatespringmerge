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

@Repository // identifies the repository
public class UserRepoImpl implements UserRepo {
	@Autowired
	private SessionFactory sessionfactory; // repo is used to communicate with databse

	@Override
	public User authenticate(LoginBean login) {
		Session session = sessionfactory.openSession();
		User user = (User) session.get(User.class, login.getUserId());
		// fetches the userid of current session for login & passes to session which is
		// typecasted
		// to user obj
		if (user != null && (user.getPassword().equals(login.getpassword()))) // compared the current session password
																				// with the DB password
			return user;
		else
			return null;
	}

	@Override
	public boolean validate(ForgetBean forget) {
		Session session = sessionfactory.openSession();
		User user = (User) session.get(User.class, forget.getUserId());
		// fetches the userid of current session for forget &
		// passes to session which is typecasted
		// to user obj
		if (user != null && user.getEmail().equals(forget.getEmail())) // compared the current sessions email with the
																		// DB email
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
			// fetches the userid of current session for change &
			// passes to session which is typecasted
			// to user obj
			user.setPassword(change.getpassword()); // gets the new password from the current session and sets it
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback(); // if any exception occurred then it is rolled-back
			return false;
		}
	}

	@Override
	public boolean persist(User user) {
		Session session = sessionfactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(user); // saves the users session
			txn.commit(); // commits the user session
			return true;
		} catch (Exception e) {
			txn.rollback(); // if any exception occurred then it is rolled-back
			e.printStackTrace();
			return false;
		}
	}

}
