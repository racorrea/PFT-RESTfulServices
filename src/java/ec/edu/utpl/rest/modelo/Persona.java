/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author roddycorrea
 */
@Entity
@Table(name = "pft_persona")
@XmlRootElement

@NamedNativeQueries({
    @NamedNativeQuery(name = "Persona.ListarPersonas", 
            query="call listar_personas();",
            resultClass = Persona.class),
    @NamedNativeQuery(name = "Persona.ListarPersonaProyectoPorCedula", 
            query="call listar_persona_con_proyecto_por_cedula(?);",
            resultClass = Persona.class),
    @NamedNativeQuery(name = "Persona.ListarTodasPersonasConProyectos", 
            query="call listar_personas_con_proyectos();",
            resultClass = Persona.class),
    @NamedNativeQuery(name = "Persona.ListarPersonaConProyectoPorCedulaYRol", 
            query="call listar_personas_por_rol_y_cedula(?, ?);",
            resultClass = Persona.class),
    @NamedNativeQuery(name = "Persona.ListarSeccionPorCedula", 
            query="call listar_personas_seccion_por_cedula(?);",
            resultClass = Persona.class),
    @NamedNativeQuery(name = "Persona.ListarPersonasTipoNivelAcademicoModalidad", 
            query="call listar_personas_tipo_nivelacademico_modalidad();",
            resultClass = Persona.class),
    @NamedNativeQuery(name = "Persona.ListarPersonasTipoNivelAcademicoModalidadPorCedula", 
            query="call listar_personas_tipo_nivelacademico_modalidad_por_cedula(?);",
            resultClass = Persona.class)
        
})


public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ENT_ID")
    private Integer entId;
    @Size(max = 15)
    @Column(name = "ENT_IDENTIFICACION")
    private String entIdentificacion;
    @Size(max = 100)
    @Column(name = "PER_GENERO_ID")
    private String perGeneroId;
    @Size(max = 200)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Size(max = 100)
    @Column(name = "PER_PRIMER_NOMBRE")
    private String perPrimerNombre;
    @Size(max = 100)
    @Column(name = "PER_SEGUNDO_NOMBRE")
    private String perSegundoNombre;
    @Size(max = 100)
    @Column(name = "PER_PRIMER_APELLIDO")
    private String perPrimerApellido;
    @Size(max = 100)
    @Column(name = "PER_SEGUNDO_APELLIDO")
    private String perSegundoApellido;
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Size(max = 45)
    @Column(name = "PER_USUARIO")
    private String perUsuario;
    @Size(max = 45)
    @Column(name = "PER_CLAVE")
    private String perClave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proIdPersona")
    private List<Proyecto> proyectoList;
    @JoinColumn(name = "per_id_departamento", referencedColumnName = "dept_id")
    @ManyToOne
    private Departamento perIdDepartamento;
    @JoinColumn(name = "PRA_ID", referencedColumnName = "PRA_ID")
    @ManyToOne
    private Programa praId;
    @JoinColumn(name = "per_id_rol", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol perIdRol;
    @JoinColumn(name = "ECV_ID", referencedColumnName = "ECV_ID")
    @ManyToOne(optional = false)
    private Variacion ecvId;
    @JoinColumn(name = "per_id_seccion", referencedColumnName = "sec_id")
    @ManyToOne(optional = false)
    private Seccion perIdSeccion;
    @OneToMany(mappedBy = "aproIdPersona")
    private List<Aprobacion> aprobacionList;

    public Persona() {
    }

    public Persona(Integer entId) {
        this.entId = entId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntIdentificacion() {
        return entIdentificacion;
    }

    public void setEntIdentificacion(String entIdentificacion) {
        this.entIdentificacion = entIdentificacion;
    }

    public String getPerGeneroId() {
        return perGeneroId;
    }

    public void setPerGeneroId(String perGeneroId) {
        this.perGeneroId = perGeneroId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerPrimerNombre() {
        return perPrimerNombre;
    }

    public void setPerPrimerNombre(String perPrimerNombre) {
        this.perPrimerNombre = perPrimerNombre;
    }

    public String getPerSegundoNombre() {
        return perSegundoNombre;
    }

    public void setPerSegundoNombre(String perSegundoNombre) {
        this.perSegundoNombre = perSegundoNombre;
    }

    public String getPerPrimerApellido() {
        return perPrimerApellido;
    }

    public void setPerPrimerApellido(String perPrimerApellido) {
        this.perPrimerApellido = perPrimerApellido;
    }

    public String getPerSegundoApellido() {
        return perSegundoApellido;
    }

    public void setPerSegundoApellido(String perSegundoApellido) {
        this.perSegundoApellido = perSegundoApellido;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(String perUsuario) {
        this.perUsuario = perUsuario;
    }

    public String getPerClave() {
        return perClave;
    }

    public void setPerClave(String perClave) {
        this.perClave = perClave;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public Departamento getPerIdDepartamento() {
        return perIdDepartamento;
    }

    public void setPerIdDepartamento(Departamento perIdDepartamento) {
        this.perIdDepartamento = perIdDepartamento;
    }

    public Programa getPraId() {
        return praId;
    }

    public void setPraId(Programa praId) {
        this.praId = praId;
    }

    public Rol getPerIdRol() {
        return perIdRol;
    }

    public void setPerIdRol(Rol perIdRol) {
        this.perIdRol = perIdRol;
    }

    public Variacion getEcvId() {
        return ecvId;
    }

    public void setEcvId(Variacion ecvId) {
        this.ecvId = ecvId;
    }

    public Seccion getPerIdSeccion() {
        return perIdSeccion;
    }

    public void setPerIdSeccion(Seccion perIdSeccion) {
        this.perIdSeccion = perIdSeccion;
    }

    @XmlTransient
    public List<Aprobacion> getAprobacionList() {
        return aprobacionList;
    }

    public void setAprobacionList(List<Aprobacion> aprobacionList) {
        this.aprobacionList = aprobacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.Persona[ entId=" + entId + " ]";
    }
    
}
