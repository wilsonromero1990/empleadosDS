package com.proyectos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.proyectos.dao.GenericoDAO;

/**
 * 
 * @author 
 *
 * @param <T>
 */
public abstract class GenericoImplDAO<T> implements GenericoDAO<T> {
	@PersistenceContext(unitName = "primary")
	protected EntityManager em;

	private final Class<T> entityClass;

	public GenericoImplDAO(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Metodoq que asigna Entity Manager
	 * 
	 * @param em
	 */
	public void setEm(final EntityManager em) {
		this.em = em;
	}

	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public void edit(T entity) {
		em.merge(entity);
	}

	@Override
	public void remove(T entity) {
		em.remove(em.merge(entity));
	}

	@Override
	public void refresh(T entity) {
		this.em.refresh(this.em.merge(entity));
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public T findById(Object id) {
		return em.find(entityClass, id);
	}

	/*
	 * @Override public List<T> findAll() { CriteriaBuilder cb =
	 * getEntityManager().getCriteriaBuilder(); CriteriaQuery<T> cq =
	 * em.getCriteriaBuilder().createQuery(entityClass);
	 * cq.select(cq.from(entityClass)); return em.createQuery(cq).getResultList(); }
	 */

	@Override
	public List<T> findAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> entidad = cq.from(entityClass);
		cq.select(entidad);
		return em.createQuery(cq).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllActive() {
		return getEntityManager()
				.createQuery("select o from " + entityClass.getCanonicalName() + " o where o.estado = 1")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findRange(int[] range) {
		javax.persistence.criteria.CriteriaQuery<T> createQuery = (javax.persistence.criteria.CriteriaQuery<T>) em
				.getCriteriaBuilder().createQuery();
		javax.persistence.criteria.CriteriaQuery<T> cq = createQuery;
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = em.createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int count() {
		@SuppressWarnings("rawtypes")
		javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(em.getCriteriaBuilder().count(rt));
		javax.persistence.Query q = em.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

	@Override
	public List<T> listarOrdenada(String ventidad, String vcampoOrd, String vforma) throws Exception {
		String sql = "select e from " + ventidad + " e order by e." + vcampoOrd + " " + vforma;
		Query q = getEntityManager().createQuery(sql);
		return q.getResultList();

	}

	@Override
	public T buscarPorCampo(String ventidad, String vcampo1, Object vvalor1) throws Exception {
		String sql = "select e from " + ventidad + " e where e." + vcampo1 + "=:vvalor1";
		Query q = getEntityManager().createQuery(sql);
		q.setParameter("vvalor1", vvalor1);
		List<T> resultado = q.getResultList();
		if (resultado.size() > 0) {
			return (T) resultado.get(0);
		} else {
			return null;
		}
	}

	public T buscar(Object id) throws Exception {

		return getEntityManager().find(entityClass, id);
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public void crear(T entity) throws Exception {
		getEntityManager().persist(entity);
	}

	@Override
	public List<T> listarTodos() throws Exception {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void editar(T entity) throws Exception {
		getEntityManager().merge(entity);
	}

	@Override
	public List<T> listarPorCampoOrdenada(String ventidad, String vcampo1, Object vvalor1, String vcampoOrd,
			String vforma) throws Exception {
		String sql = "select e from " + ventidad + " e where e." + vcampo1 + " =:vvalor1 order by e." + vcampoOrd + " "
				+ vforma;
		Query q = getEntityManager().createQuery(sql);
		q.setParameter("vvalor1", vvalor1);
		return q.getResultList();

	}

}
