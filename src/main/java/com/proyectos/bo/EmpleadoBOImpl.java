package com.proyectos.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.proyectos.dao.EmpleadoDAO;
import com.proyectos.entity.Empleado;

/**
 * 
 * @author
 *
 */
@Stateless
public class EmpleadoBOImpl implements EmpleadoBO {

	@Inject
	private EmpleadoDAO empleadoDAO;

	/**
	 * 
	 */
	@Override
	public List<Empleado> findAll() {
		return empleadoDAO.findAll();
	}

	/**
	 * 
	 */
	@Override
	public Empleado findById(Long id) {
		return empleadoDAO.findById(id);
	}

	@Override
	public List<Empleado> findAllActive() {
		return empleadoDAO.findAllActive();
	}

	@Override
	public Boolean guardar(Empleado estudiante) throws Exception {
		Boolean exito = false;
		try {
			empleadoDAO.create(estudiante);
			exito = true;
		} catch (Exception e) {
			throw new Exception(e);

		}
		return exito;
	}

	@Override
	public Boolean actualizar(Empleado estudiante) throws Exception {
		Boolean exito = false;
		try {

			empleadoDAO.edit(estudiante);
			exito = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return exito;
	}

	@Override
	public Empleado buscarPorIdentificacion(String identificacion) {
		return empleadoDAO.findPorIdentificacion(identificacion);

	}


}
