package com.qbo.model.sp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CursoNota {

	@Id
	private String idcurso;
	
	@Column(name = "nomcurso")
	private String nomcurso;
	@Column(name = "credito")
	private Integer credito;
	@Column(name = "exaparcial")
	private Double exaparcial;
	@Column(name = "exafinal")
	private Double exafinal;
}
