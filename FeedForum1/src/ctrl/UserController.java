package ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("login.do")
	public String checkLogin(LoginBean login, Map model, HttpSession session) {
		// On login successful we return user obj, we have to keep inside a session
		User user = service.authenticate(login);
		if (user != null) {
			session.setAttribute("User", user);
			return "feeds";
		} else {
			model.put("Prompt", "User Id/Password is Incorrect");
			return "home";
		}
	}

	@RequestMapping("forget.do")
	public String forgetPass(ForgetBean forget, Map model) {
		if (service.validate(forget)) {
			model.put("Id", forget.getUserId());
			return "change";
		} else {
			model.put("Invalid", "User Id & Email Id does not match");
			return "forget";
		}

	}

	@RequestMapping("change.do")
	public String changePass(LoginBean change, Map model) {
		if (service.changePassword(change)) {
			model.put("Prompt", "Password successfully changed");
			return "home";
		} else {
			model.put("Invalid", "Password does not match");
			return "change";
		}
	}

	@RequestMapping("register.do")
	public String persist(User user, Map model) {
		if (service.persist(user)) {
			model.put("Prompt", "Thank you for registration");
			return "home";
		} else {
			model.put("Invalid", "User Id already exist");
			return "register";
		}
	}

}
