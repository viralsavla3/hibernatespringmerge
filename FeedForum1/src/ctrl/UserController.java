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

@Controller // identifies the controller
public class UserController {
	@Autowired
	private UserService service; // service injected using autowired

	@RequestMapping("login.do")
	public String checkLogin(LoginBean login, Map model, HttpSession session) {
		// On login successful we return user obj, we have to keep inside a session
		User user = service.authenticate(login);
		if (user != null) { // Check whether user object is null
			session.setAttribute("User", user); // sets the attributes of user object to match the login
			return "dashboard";
		} else { // in case of invalid login
			model.put("Prompt", "User Id/Password is Incorrect");
			return "home";
		}
	}

	@RequestMapping("forget.do") // onsubmit it is redirected
	public String forgetPass(ForgetBean forget, Map model, HttpSession session) {
		if (service.validate(forget)) { // calling the service validate method and passing forget obj
			session.setAttribute("Id", forget.getUserId());// setting Id to userid & getting the userid
			return "change";
		} else {
			model.put("Invalid", "User Id & Email Id does not match"); // invalid userid and email
			return "forget";
		}

	}

	@RequestMapping("change.do") // onsubmit it is redirected
	public String changePass(LoginBean change, Map model, HttpSession session) {
		change.setUserId((String) session.getAttribute("Id")); // session is created, Id is carried forward
		if (service.changePassword(change)) {// overwriting the changed password
			model.put("Prompt", "Password successfully changed"); // Prompt passed carrying the message
			return "home";
		} else {
			model.put("Invalid", "Password does not match");
			return "change";
		}
	}

	@RequestMapping("register.do") // onsubmit it is redirected
	public String persist(User user, Map model) {
		if (service.persist(user)) { // adds user entities to DB
			model.put("Prompt", "Thank you for registration");
			return "home";
		} else {
			model.put("Invalid", "User Id already exist"); // UserId primary key
			return "register";
		}
	}

	@RequestMapping("logout.do") // onsubmit it is redirected
	public String logout(Map model, HttpSession session) {
		session.invalidate(); // Invalidates the container
		model.put("Prompt", "Logout Succesfully");
		return "home";

	}

}
