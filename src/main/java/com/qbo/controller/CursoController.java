package com.qbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qbo.model.bd.Curso;
import com.qbo.model.response.ResultadoResponse;
import com.qbo.service.CursoService;





@Controller
@RequestMapping("/Curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/frmMantCurso")
	public String frmListarCurso(Model model) {
		model.addAttribute("listcursos", cursoService.listarCursos());
		model.addAttribute("title", "Listado de cursos");
		return "Curso/frmMantCurso";
	}


	
	@PostMapping("/registrarCurso")
	@ResponseBody
	public ResultadoResponse registrarCurso(@RequestBody Curso objCurso) {
		String mensaje = "Curso registrado correctamente.";
		Boolean respuesta = true;
		try {
			cursoService.registrarCurso(objCurso);
		}catch(Exception ex) {
			mensaje = "Curso no registrado.";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarCursos")
	@ResponseBody
	public List<Curso> listarCursos(){
		return cursoService.listarCursos();
	}
	
	@DeleteMapping("/eliminarCurso")
	@ResponseBody
	public ResultadoResponse eliminarCurso(@RequestBody Curso objCurso) {
		String mensaje = "Curso eliminado correctamente.";
		Boolean respuesta = true;
		try {
			cursoService.eliminarCurso(objCurso);
		}catch(Exception ex) {
			mensaje = "El curso no fue eliminado.";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
}
