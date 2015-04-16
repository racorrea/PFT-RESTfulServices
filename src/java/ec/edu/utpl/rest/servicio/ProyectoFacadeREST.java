/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.servicio;

import ec.edu.utpl.rest.controladores.AbstractFacade;
import ec.edu.utpl.rest.modelo.Proyecto;
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
@Path("proyecto")
public class ProyectoFacadeREST extends AbstractFacade<Proyecto> {
    @PersistenceContext(unitName = "PFTRestWSPU")
    private EntityManager em;

    public ProyectoFacadeREST() {
        super(Proyecto.class);
    }

    @GET
    @Path("listar")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Proyecto> ListarProyectos() {
        return super.ListarProyectos();
    }
    @GET
    @Path("nombre/{nombreProyecto}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Proyecto> ListarProyectosPorNombre(@PathParam("nombreProyecto") String nombreProyecto) {
        return super.ListarProyectosPorNombre("%"+nombreProyecto+"%");
    }
    @GET
    @Path("estado/{estado}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Proyecto> ListarProyectosPorEstado(@PathParam("estado") String estado) {
        return super.ListarProyectosPorEstado(estado);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
