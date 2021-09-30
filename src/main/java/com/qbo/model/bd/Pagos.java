package com.qbo.model.bd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.qbo.model.bd.pk.PagosId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(PagosId.class)
@Table(name="pagos")
public class Pagos {

	@Id
	private String idalumno;
	@Id
	private String ciclo;
	@Id
	private Integer ncouta;
	
	@Column(name = "monto")
	private Double monto;
	
	@Column(name = "fecha")
	private Date fecha;
	
}
