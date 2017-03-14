package br.com.stefanini.progress.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.stefanini.progress.model.User;
import br.com.stefanini.progress.service.LoginService;

@Controller
public class RegisterController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/register", method = {RequestMethod.GET})
	public ModelAndView register(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("login", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value={"/register"}, method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		User userExists = loginService.findUserByUsername(user.getNickname());
		if (userExists != null) {
			bindingResult
							.rejectValue("username", "error.user",
											"O usuário inserido não pode ser cadastrado pois o mesmo já foi registrado");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else {
			loginService.saveLogin(user);;
			modelAndView.addObject("sucessMessage", "Seu usuário foi cadastrado com sucesso");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}
}
