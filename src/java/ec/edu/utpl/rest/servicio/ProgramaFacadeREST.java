/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.servicio;

import ec.edu.utpl.rest.controladores.AbstractFacade;
import ec.edu.utpl.rest.modelo.Programa;
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
@Path("programa")
public class ProgramaFacadeREST extends AbstractFacade<Programa> {
    @PersistenceContext(unitName = "PFTRestWSPU")
    private EntityManager em;

    public ProgramaFacadeREST() {
        super(Programa.class);
    }

    @GET
    @Path("listar")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Programa> listarProgramas() {
        return super.ListarProgramas();
    }
    
    @GET
    @Path("{modalidad}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Programa> ListarProgramasPorModalidad(@PathParam("modalidad") String modalidad) {
        return super.ListarProgramasPorModalidad(modalidad);
    }
    @GET
    @Path("{modalidad}/{nivelacademico}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Programa> ListarProgramasPorModalidadYNivelAcademico(@PathParam("modalidad") String modalidad, @PathParam("nivelacademico") String nivelAcademico) {
        return super.ListarProgramasPorModalidadYNivelAcademico(modalidad, nivelAcademico);
    }
    @GET
    @Path("nivel/{nivelacademico}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Programa> ListarProgramasPorNivelAcademico(@PathParam("nivelacademico") String nivelAcademico) {
        return super.ListarProgramasPorNivelAcademico(nivelAcademico);
    }
    @GET
    @Path("pornombre/{nombrePrograma}")
    @Produces({"application/json"+ ";charset=utf-8"})
    public List<Programa> ListarProgramasPorNombre(@PathParam("nombrePrograma") String nombrePrograma) {
        return super.ListarProgramasPorNombre("%"+nombrePrograma+"%");
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
