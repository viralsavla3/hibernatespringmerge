package service;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;
import repo.UserRepo;

@Service // identifies the service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;// repo inject using autowired

	@Override
	public User authenticate(LoginBean login) {

		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(login.getpassword().getBytes());
		login.setpassword(encoded);
		return repo.authenticate(login); // encoding password
	}

	@Override
	public boolean validate(ForgetBean forget) {
		// Email is not encoded
		return repo.validate(forget);
	}

	@Override
	public boolean changePassword(LoginBean change) {
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(change.getpassword().getBytes());
		change.setpassword(encoded);

		return repo.changePassword(change); // encoding password
	}

	@Override
	public boolean persist(User user) {
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(user.getPassword().getBytes());
		user.setPassword(encoded);
		return repo.persist(user); // encoding password
	}

}
