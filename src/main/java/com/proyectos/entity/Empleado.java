package com.proyectos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "empleado", schema = "public")
public class Empleado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EMPLEADO_ID_GENERATOR", sequenceName = "empleado_id_empleado_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLEADO_ID_GENERATOR")
	@Column(name = "id_empleado", unique = true, nullable = false)
	private Long idEmpleado;

	

	@Column(name = "nombre", nullable = false, length = 20)
	private String nombreUno;

	@Column(name = "apellido", nullable = false, length = 20)
	private String apellidoUno;

	@Column(name = "numero_identificacion", nullable = false, length = 15)
	private String numeroIdentificacion;




	public Empleado() {
	}



	public Long getIdEmpleado() {
		return idEmpleado;
	}



	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}



	public String getNombreUno() {
		return this.nombreUno;
	}

	public void setNombreUno(String nombreUno) {
		this.nombreUno = nombreUno;
	}



	public String getApellidoUno() {
		return this.apellidoUno;
	}

	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = apellidoUno;
	}

	
	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	


}
