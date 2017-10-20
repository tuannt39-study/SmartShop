package vn.its.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductAdminController {

	@GetMapping("/admin/product")
	public ModelAndView product(ModelAndView model) {
		model.setViewName("admin/product");
		return model;
	}
	
	@GetMapping("/admin/product/form")
	public ModelAndView product_form(ModelAndView model) {
		model.setViewName("admin/product_form");
		return model;
	}

	@GetMapping("/admin/product-category")
	public ModelAndView product_category(ModelAndView model) {
		model.setViewName("admin/product_category");
		return model;
	}
	
	@GetMapping("/admin/product-category/form")
	public ModelAndView product_category_form(ModelAndView model) {
		model.setViewName("admin/product_category_form");
		return model;
	}
}
