package ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Comment;
import entity.Feed;
import entity.User;
import service.FeedService;

@Controller
public class FeedController {

	@Autowired
	private FeedService service;

	@RequestMapping(value = "query.do", method = { RequestMethod.POST }) // more characters cannot be sent with get
																			// method
	public String askQuestion(@RequestParam("query") String query, HttpSession session, Map model) {
		Feed feed = new Feed();
		feed.setQuery(query);
		// feed belongs to user and set the feed to it
		User user = (User) session.getAttribute("User");
		feed.setUser(user);
		// going to ask question in service
		service.askQuestion(feed);

		model.put("Feeds", service.getMyFeed(user.getUserId()));
		return "feeds";
	}

	@RequestMapping("feeds.do")
	public String showFeeds(Map model, HttpSession session) {
		User user = (User) session.getAttribute("User");
		model.put("Feeds", service.getMyFeed(user.getUserId()));
		return "feeds";

	}

	@RequestMapping("question.do")
	public String showQuestion(@RequestParam("id") int fid, HttpSession session) {
		Feed feed = service.getQuestion(fid);
		session.setAttribute("Question", feed);
		return "response";

	}

	@RequestMapping(value = "comment.do", method = RequestMethod.POST)
	public String submitComment(@RequestParam("response") String response, HttpSession session) {
		Comment comment = new Comment();
		comment.setResponse(response);
		comment.setFeed((Feed) session.getAttribute("Question"));
		comment.setUser((User) session.getAttribute("User"));

		Feed feed = service.submitComment(comment);
		session.setAttribute("Question", feed);
		return "response";
	}

	@RequestMapping("search.do")
	public String searchFeed(@RequestParam("keyword") String keyword, Map model) {
		model.put("Feeds", service.searchFeeds(keyword));
		return "feeds";
	}
}
