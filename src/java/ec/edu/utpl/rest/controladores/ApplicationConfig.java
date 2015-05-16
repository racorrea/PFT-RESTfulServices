/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.controladores;

import ec.edu.utpl.rest.servicio.*;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author roddycorrea
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    /**
     *
     * @return
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.utpl.rest.servicio.PersonaFacadeREST.class);
        resources.add(ec.edu.utpl.rest.servicio.ProgramaFacadeREST.class);
        resources.add(ec.edu.utpl.rest.servicio.ProyectoFacadeREST.class);
        
    }
    
}
