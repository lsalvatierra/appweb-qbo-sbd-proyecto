package com.qbo.model.bd;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.qbo.model.bd.pk.NotasId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="notas")
public class Notas {
	
	@EmbeddedId
	private NotasId notasid;
	@Column(name = "exaparcial")
	private Double exaparcial;	
	@Column(name = "exafinal")
	private Double exafinal;

}
