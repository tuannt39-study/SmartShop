package vn.its.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderAdminController {
	
	@GetMapping("/admin/oder")
	public ModelAndView oder(ModelAndView model) {
		model.setViewName("admin/order");
		return model;
	}
	
	@GetMapping("/admin/oder/form")
	public ModelAndView bill(ModelAndView model) {
		model.setViewName("admin/bill");
		return model;
	}

}
