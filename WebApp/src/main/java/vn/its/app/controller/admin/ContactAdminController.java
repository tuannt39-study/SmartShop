package vn.its.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactAdminController {
	
	@GetMapping("/admin/contact")
	public ModelAndView contact(ModelAndView model) {
		model.setViewName("admin/contact");
		return model;
	}
	
	@GetMapping("/admin/contact/form")
	public ModelAndView contact_form(ModelAndView model) {
		model.setViewName("admin/contact_form");
		return model;
	}
	
	@GetMapping("/admin/feedback")
	public ModelAndView feedback(ModelAndView model) {
		model.setViewName("admin/feedback");
		return model;
	}

}
