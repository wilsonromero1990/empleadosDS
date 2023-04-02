package com.proyectos.bo;

import java.util.List;

import javax.ejb.Local;

import com.proyectos.entity.Empleado;



/**
 * @author
 */
@Local
public interface EmpleadoBO {

	public List<Empleado> findAll();

	public Empleado findById(Long id);

	public List<Empleado> findAllActive();

	public Boolean guardar(Empleado empleado) throws Exception;

	public Boolean actualizar(Empleado empleado) throws Exception;

	public Empleado buscarPorIdentificacion(String identificacion);


}
