/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.servicio;

import ec.edu.utpl.rest.controladores.AbstractFacade;
import ec.edu.utpl.rest.modelo.NivelAcademico;
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
@Path("nivelacademico")
public class NivelAcademicoFacadeREST extends AbstractFacade<NivelAcademico> {
    @PersistenceContext(unitName = "PFTRestWSPU")
    private EntityManager em;

    public NivelAcademicoFacadeREST() {
        super(NivelAcademico.class);
    }

    @GET
    @Path("listar")
    @Produces({"application/json"})
    public List<NivelAcademico> listarNivelAcademico() {
        return super.ListarNivelAcademico();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
