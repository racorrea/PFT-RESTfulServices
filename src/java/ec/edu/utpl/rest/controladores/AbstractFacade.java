/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.controladores;
import ec.edu.utpl.rest.controladores.Util;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;

/**
 *
 * @author roddycorrea
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    
    Util u = new Util();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    /*
    public List<T> proyectoPersona(Object cedula) {
        Query q = getEntityManager().createNamedQuery("PftPersonaProyecto.ProyectoDePersona");
        q.setParameter(1, cedula);
        System.out.println("\n-----------------------------\n");
        System.out.println(cedula);
        System.out.println(q.getResultList());
        System.out.println("\n-----------------------------\n\n");
        return q.getResultList();
    }
    
    public List<T> mostrarPersonas() {
        Query q = getEntityManager().createNamedQuery("PftPersona.Personas");
        System.out.println("\n-----------------------------\n");
        System.out.println(q);
        System.out.println("\n-----------------------------\n\n");
        return q.getResultList();
    }
    
    listar las modalidades
    listar niveles academicos
    listar proyecto de una persona por cedula
    listar todos los proyectos con personas
    listar personas filtradas por cedula y rol
    listar a que seccion pertenece una persona
    listar las personas con su programa, nivel academico y modalidad
    listar progrmas con su nivel academico, modalidad, filtrado por modalidad
    listar programas filtrado por nivel academico y modalidad
    listar programas por nivel academico
    listar programas por nombre LIKE
    listar proyectos con su estado de aprobacion
    listar proyectos con su estado por titulo de proyecto
    */
    
    public List<T> ListarPersonas (){
        Query q = getEntityManager().createNamedQuery("Persona.ListarPersonas");
        return q.getResultList();
    }
    public List<T> ListarModalidades (){
        Query q = getEntityManager().createNamedQuery("Modalidad.ListarModalidades");
        return q.getResultList();
    }
    public List<T> ListarNivelAcademico (){
        Query q = getEntityManager().createNamedQuery("NivelAcademico.ListarNivelAcademico");
        return q.getResultList();
    }
    public List<T> ListarPersonaProyectoPorCedula (Object cedula){
        String parametro = u.limpiarXSS(cedula.toString());
        System.out.println(parametro);
        Query q = getEntityManager().createNamedQuery("Persona.ListarPersonaProyectoPorCedula");
        q.setParameter(1, parametro);
        return q.getResultList();
    }
    public List<T> ListarTodosPersonasConProyecto(){
        Query q = getEntityManager().createNamedQuery("Persona.ListarTodasPersonasConProyectos");
        return q.getResultList();
    }
    public List<T> ListarPersonaConProyectoPorCedulaYRol(Object rol, Object cedula){
        Query q = getEntityManager().createNamedQuery("Persona.ListarPersonaConProyectoPorCedulaYRol");
        q.setParameter(1, rol);
        q.setParameter(2, cedula);
        return q.getResultList();
    }
    public List<T> ListarPersonaSeccionPorCedula (Object cedula){
        Query q = getEntityManager().createNamedQuery("Persona.ListarSeccionPorCedula");
        q.setParameter(1, cedula);
        return q.getResultList();
    }
    public List<T> ListarPersonasTipoNivelAcademicoModalidad (){
        Query q = getEntityManager().createNamedQuery("Persona.ListarPersonasTipoNivelAcademicoModalidad");
        return q.getResultList();
    }
    public List<T> ListarPersonasTipoNivelAcademicoModalidadPorCedula (Object cedula){
        Query q = getEntityManager().createNamedQuery("Persona.ListarPersonasTipoNivelAcademicoModalidadPorCedula");
        q.setParameter(1, cedula);
        return q.getResultList();
    }
    public List<T> ListarProgramas(){
        Query q = getEntityManager().createNamedQuery("Programa.ListarProgramas");
        return q.getResultList();
    }
    public List<T> ListarProgramasPorModalidad(Object modalidad){
        Query q = getEntityManager().createNamedQuery("Programa.ListarProgramasPorModalidad");
        q.setParameter(1, modalidad);
        return q.getResultList();
    }
    public List<T> ListarProgramasPorModalidadYNivelAcademico(Object modalidad, Object nivelAcademico){
        Query q = getEntityManager().createNamedQuery("Programa.ListarProgramasPorModalidadYNivelAcademico");
        q.setParameter(1, modalidad);
        q.setParameter(2, nivelAcademico);
        return q.getResultList();
    }
    public List<T> ListarProgramasPorNivelAcademico(Object nivelAcademico){
        Query q = getEntityManager().createNamedQuery("Programa.ListarProgramasPorNivelAcademico");
        q.setParameter(1, nivelAcademico);
        return q.getResultList();
    }
    public List<T> ListarProgramasPorNombre(Object nombrePrograma){
        Query q = getEntityManager().createNamedQuery("Programa.ListarProgramasPorNombre");
        q.setParameter(1, nombrePrograma);
        return q.getResultList();
    }
    
    public List<T> ListarProyectos(){
        Query q = getEntityManager().createNamedQuery("Proyecto.ListarProyectos");
        System.out.println("\n-----------------------------\n");
        System.out.println(q);
        System.out.println("\n-----------------------------\n\n");
        return q.getResultList();
    }
    public List<T> ListarProyectosPorNombre(Object nombreProyecto){
        Query q = getEntityManager().createNamedQuery("Proyecto.ListarProyectosPorNombre");
        q.setParameter(1, nombreProyecto);
        return q.getResultList();
    }
    public List<T> ListarProyectosPorEstado(Object estado){
        Query q = getEntityManager().createNamedQuery("Proyecto.ListarProyectosPorEstado");
        q.setParameter(1, estado);
        return q.getResultList();
    }
    
    
    
    
}
