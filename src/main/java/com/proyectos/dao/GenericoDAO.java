package com.proyectos.dao;

import java.util.List;

/**
 * 
 * @author
 *
 * @param <T>
 */
public interface GenericoDAO <T> {
	/**
	 * 
	 * @param entity
	 */
	// Crea un objecto de la entidad
    public void create(T entity);
    
    /**
     * 
     * @param entity
     */
    // Actualiza o refresca el objeto de la entidad 
    public void edit(T entity);

    /**
     * 
     * @param entity
     */
    // Elimina
    public void remove(T entity);

    /**
     * 
     * @param entity
     */
    // Refresca la nuevamente la persistencia de una entidad
    public void refresh(T entity);

    /**
     * 
     */
    // Refresca la nuevamente la persistencia de una entidad
    public void flush();

    /**
     * 
     * @param id
     * @return
     */
    public T findById(Object id);

    /**
     * 
     * @return
     */
    public List<T> findAll();
    
    
    public List<T> findAllActive();

    /**
     * 
     * @param range
     * @return
     */
    public List<T> findRange(int[] range);

    /**
     * 
     * @return
     */
    public int count();
    
    
    public void crear(T entity) throws Exception ;
    public void editar(T entity) throws Exception ;
    public List<T> listarTodos() throws Exception ;
    public List<T> listarOrdenada(String ventidad, String vcampoOrd, String vforma) throws Exception ;
    public T buscarPorCampo(String ventidad, String vcampo1, Object vvalor1) throws Exception ;
    public List<T> listarPorCampoOrdenada(String ventidad, String vcampo1, Object vvalor1, String vcampoOrd, String vforma) throws Exception;    
}
