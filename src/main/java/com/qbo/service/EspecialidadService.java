package com.qbo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.bd.Alumno;
import com.qbo.model.bd.Especialidad;
import com.qbo.repository.EspecialidadRepository;

@Service
public class EspecialidadService {

	
	@Autowired
	private EspecialidadRepository especialidadRepository;

	public List<Especialidad> listarEspecialidades(){
		return especialidadRepository.findAll();
	}
	
	public List<Alumno> listarAlumnosxEspecialidad(String idesp){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		especialidadRepository.findById(idesp).get().getListalumno().forEach(alumnos::add);
		return alumnos;
	}
}
