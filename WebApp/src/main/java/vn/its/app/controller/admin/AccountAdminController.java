package vn.its.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountAdminController {
	
	@GetMapping("/admin/account")
	public ModelAndView account(ModelAndView model) {
		model.setViewName("admin/account");
		return model;
	}
	
	@GetMapping("/admin/account/form")
	public ModelAndView account_form(ModelAndView model) {
		model.setViewName("admin/account_form");
		return model;
	}
	
	@GetMapping("/admin/login-log")
	public ModelAndView login_log(ModelAndView model) {
		model.setViewName("admin/login_log");
		return model;
	}

}
