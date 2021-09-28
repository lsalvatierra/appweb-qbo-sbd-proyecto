package com.qbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.bd.Curso;
import com.qbo.repository.CursoRepository;



@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	public void registrarCurso(Curso curso) {
		if(curso.getIdcurso() == null) {
			cursoRepository.registrarCurso(curso.getNomcurso(), 
					curso.getCredito());
		}else {
			cursoRepository.save(curso);
		}		
	}
	

	public void eliminarCurso(Curso curso) {
		cursoRepository.deleteById(curso.getIdcurso());
	}
	
}
