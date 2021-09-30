package com.qbo.model.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="especialidad")
public class Especialidad {
	
	@Id
	private String idesp;
	
	@Column(name = "nomesp")
	private String nomesp;
	
	@Column(name = "costo")
	private Double costo;
	
	@JsonManagedReference	
	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alumno> listalumno = new ArrayList<Alumno>();
	

}
