/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.servicio;

import ec.edu.utpl.rest.controladores.AbstractFacade;
import ec.edu.utpl.rest.controladores.Util;

import ec.edu.utpl.rest.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author roddycorrea
 */
@Stateless
@Path("persona")
public class PersonaFacadeREST extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "PFTRestWSPU")
    private EntityManager em;

    public PersonaFacadeREST() {
        super(Persona.class);
    }

    @GET
    @Path("listar")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarPersonas() {
        return super.ListarPersonas();
    }
    
    @GET
    @Path("{cedula}/proyecto")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarPersonaConProyectoPorCedula(@PathParam("cedula") String cedula) {
        
        return super.ListarPersonaProyectoPorCedula(cedula);
    }
    
    @GET
    @Path("proyecto")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarTodasPersonaConProyecto() {
        return super.ListarTodosPersonasConProyecto();
    }
    
    @GET
    @Path("{rol}/{cedula}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarPersonaProyectoPorCedulaYRol(@PathParam("rol") String rol,@PathParam("cedula") String cedula){
        return super.ListarPersonaConProyectoPorCedulaYRol(rol, cedula);
    }
    
    @GET
    @Path("{cedula}/seccion")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarPersonaSeccionPorCedula(@PathParam("cedula") String cedula) {
        return super.ListarPersonaSeccionPorCedula(cedula);
    }
    
    @GET
    @Path("programa/nivelacademico/modalidad")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarPersonasTipoNivelAcademicoModalidad() {
        return super.ListarPersonasTipoNivelAcademicoModalidad();
    }
    
    @GET
    @Path("{cedula}/programa/nivelacademico/modalidad")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Persona> listarPersonasTipoNivelAcademicoModalidadPorCedula(@PathParam("cedula") String cedula) {
        return super.ListarPersonasTipoNivelAcademicoModalidadPorCedula(cedula);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
