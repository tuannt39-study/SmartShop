package vn.its.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsAdminController {
	
	@GetMapping("/admin/news")
	public ModelAndView news(ModelAndView model) {
		model.setViewName("admin/news");
		return model;
	}
	
	@GetMapping("/admin/news/form")
	public ModelAndView news_form(ModelAndView model) {
		model.setViewName("admin/news_form");
		return model;
	}

	@GetMapping("/admin/news-category")
	public ModelAndView news_category(ModelAndView model) {
		model.setViewName("admin/news_category");
		return model;
	}
	
	@GetMapping("/admin/news-category/form")
	public ModelAndView news_category_form(ModelAndView model) {
		model.setViewName("admin/news_category_form");
		return model;
	}
}
