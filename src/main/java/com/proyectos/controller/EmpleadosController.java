package com.proyectos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.proyectos.bo.EmpleadoBO;
import com.proyectos.entity.Empleado;



@ManagedBean(name = "empleadosController")
@ViewScoped
public class EmpleadosController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(EmpleadosController.class.getName());

	@EJB
	private EmpleadoBO empleadoServicio;

	private Empleado empleadoActual;

	private List<Empleado> empleadoLista;
	
	@PostConstruct
	public void initi() {

		limpiar();
	}

	public void guardar() {
		try {
				if(empleadoServicio.guardar(this.empleadoActual)) {
					System.out.println("se a guardado correctamnete");
				}else {
					System.out.println("error al guardar");
				}
							
		} catch (Exception e) {
			log.error("Error en guardar empleado: " + e);
		}
		//this.empleadoLista = empleadoServicio.findAll();
		
	}

	public Empleado getempleadoActual() {
		return empleadoActual;
	}

	public void setempleadoActual(Empleado empleadoActual) {
		this.empleadoActual = empleadoActual;
	}

	public List<Empleado> getempleadoLista() {
		return empleadoLista;
	}

	public void setempleadoLista(List<Empleado> empleadoLista) {
		this.empleadoLista = empleadoLista;
	}

	public void limpiar() {
		this.empleadoActual = new Empleado();
		
	}

	


}
