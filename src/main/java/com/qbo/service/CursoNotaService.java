package com.qbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.sp.CursoNota;
import com.qbo.repository.CursoNotaRepository;



@Service
public class CursoNotaService {
	@Autowired
	private CursoNotaRepository repository;
	
	public List<CursoNota> listarCursoNotaxAlumno(String idAlumno){
		return repository.listarCursoNotaxAlumno(idAlumno);
	}
}
