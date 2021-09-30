package com.qbo.model.bd;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="alumno")
public class Alumno {

	@Id
	private String idalumno;
	@Column(name ="apealumno")
	private String apealumno;
	@Column(name ="nomalumno")
	private String nomalumno;
	@Column(name ="proce")
	private String proce;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idesp")
	private Especialidad especialidad;
	
}
