package ctrl;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.ForgetBean;
import bean.LoginBean;

@Controller
public class LoginController {

	@RequestMapping("login.do")
	public String checkLogin(LoginBean login, Map model) {
		return "home";
	}

	@RequestMapping("forget.do")
	public String forgetPass(ForgetBean forget, Map model) {
		return "forget";
	}

	@RequestMapping("change.do")
	public String changePass(LoginBean change, Map model) {
		return "change";
	}
}
