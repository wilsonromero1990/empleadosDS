package com.proyectos.dao;


import javax.ejb.Local;

import com.proyectos.entity.Empleado;


@Local
public interface EmpleadoDAO extends GenericoDAO<Empleado>{

	public Empleado findPorIdentificacion(String identificacion);
	

}
