package vn.its.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountUserController {
	
	@GetMapping("/dang-nhap")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("user/login");
		return model;
	}
	
	@GetMapping("/dang-ky")
	public ModelAndView register(ModelAndView model) {
		model.setViewName("user/register");
		return model;
	}

}
