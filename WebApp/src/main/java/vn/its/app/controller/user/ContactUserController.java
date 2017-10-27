package vn.its.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactUserController {
	
	@GetMapping("/lien-he")
	public ModelAndView contact(ModelAndView model) {
		model.setViewName("user/contact");
		return model;
	}

}
