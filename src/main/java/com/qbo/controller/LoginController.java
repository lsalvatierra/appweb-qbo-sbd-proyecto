package com.qbo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.qbo.model.bd.Usuario;
import com.qbo.service.UsuarioService;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("visualizar", false);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario")Usuario objUsuario,
			Model model, HttpServletRequest request) {
		Usuario usuario =usuarioService.autenticarUsuario(objUsuario); 
		if(usuario != null) {
			//model.addAttribute("mensaje", "Bienvenido "+ usuario.getNombres());
			request.getSession().setAttribute("sesionusuario", usuario);
			return "redirect:/home";
		}
		model.addAttribute("visualizar", true);
		model.addAttribute("mensajeerror", "Usuario o password incorrecto");
		return "login";
	}	
}
