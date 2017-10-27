package vn.its.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping({"/admin","/admin/home"})
	public ModelAndView home(ModelAndView model) {
		model.setViewName("admin/home");
		return model;
	}
	
	@GetMapping("/admin/error404")
	public ModelAndView error404(ModelAndView model) {
		model.setViewName("admin/error404");
		return model;
	}
	
	@GetMapping("/admin/error500")
	public ModelAndView error500(ModelAndView model) {
		model.setViewName("admin/error500");
		return model;
	}

}
