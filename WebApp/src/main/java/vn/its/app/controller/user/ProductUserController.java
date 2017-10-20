package vn.its.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductUserController {

	@GetMapping("/san-pham")
	public ModelAndView products(ModelAndView model) {
		model.setViewName("user/products");
		return model;
	}
	
	@GetMapping("/san-pham/id")
	public ModelAndView products_detail(ModelAndView model) {
		model.setViewName("user/products_detail");
		return model;
	}

}
