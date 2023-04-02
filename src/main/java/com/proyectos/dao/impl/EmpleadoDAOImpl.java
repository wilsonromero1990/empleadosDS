package com.proyectos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.proyectos.dao.EmpleadoDAO;
import com.proyectos.entity.Empleado;


@Stateless
public class EmpleadoDAOImpl extends GenericoImplDAO<Empleado> implements EmpleadoDAO {

	public EmpleadoDAOImpl() {
		super(Empleado.class);
	}

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(Empleado.class.getName());

	public Empleado findPorIdentificacion(String identificacion) {

		Empleado empleado = new Empleado();
		List<Empleado> lista = new ArrayList<>();
		lista = this.getEntityManager()
				.createQuery("Select e from Empleado e where e.numeroIdentificacion = :videntificacion")
				.setParameter("videntificacion", identificacion).getResultList();
		if (lista.size() > 0 && lista != null) {
			if (lista.size() == 1) {
				empleado = lista.get(0);
			} else {
				LOGGER.info("ERROR AL RECUPERAR : Hay mas de un registro asociado al codigo");
				empleado = null;
			}
		} else {
			LOGGER.info("ERROR AL RECUPERAR : La consulta no devolvio datos");
			empleado = null;
		}
		return empleado;
	}



}
