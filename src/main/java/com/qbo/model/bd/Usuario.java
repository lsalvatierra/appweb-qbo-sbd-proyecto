package com.qbo.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	
	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "nomusuario")	
	private String nomusuario;
	
	@Column(name = "passusuario")	
	private String passusuario;
	
	
}
