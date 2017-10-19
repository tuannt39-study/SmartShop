package vn.its.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/index")
	public ModelAndView index(ModelAndView model) {
		model.setViewName("user/index");
		return model;
	}

	@GetMapping("/home")
	public ModelAndView home(ModelAndView model) {
		model.setViewName("admin/home");
		return model;
	}

}
