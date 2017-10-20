package vn.its.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsUserController {

	@GetMapping("/tin-tuc")
	public ModelAndView news_home(ModelAndView model) {
		model.setViewName("user/news_home");
		return model;
	}
	
	@GetMapping("/tin-tuc/id")
	public ModelAndView news_detail(ModelAndView model) {
		model.setViewName("user/news_detail");
		return model;
	}

}
