package service;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;

public interface UserService {
	User authenticate(LoginBean login);

	boolean validate(ForgetBean forget);

	boolean changePassword(LoginBean change);

	boolean persist(User user);
}
