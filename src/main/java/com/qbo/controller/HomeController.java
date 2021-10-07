package com.qbo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qbo.model.bd.Usuario;

@Controller
public class HomeController {

	
	@GetMapping("/home")
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Home");
		Usuario objUsuario = (Usuario)request.getSession().getAttribute("sesionusuario");
		model.addAttribute("mensaje", objUsuario.getNombres());
		return "home";
	}
	

	@PostMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
}
