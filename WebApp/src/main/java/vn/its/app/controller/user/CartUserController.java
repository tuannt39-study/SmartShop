package vn.its.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartUserController {
	
	@GetMapping("/gio-hang")
	public ModelAndView cart(ModelAndView model) {
		model.setViewName("user/cart");
		return model;
	}
	
	@GetMapping("/dat-hang")
	public ModelAndView checkout(ModelAndView model) {
		model.setViewName("user/checkout");
		return model;
	}

}
