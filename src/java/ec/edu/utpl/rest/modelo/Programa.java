/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roddycorrea
 */
@Entity
@Table(name = "pft_programa")
@XmlRootElement

@NamedNativeQueries({
    @NamedNativeQuery(name = "Programa.ListarProgramas", 
            query="call listar_programas();",
            resultClass = Programa.class),
    @NamedNativeQuery(name = "Programa.ListarProgramasPorModalidad", 
            query="call listar_programas_por_modalidad(?);",
            resultClass = Programa.class),
    @NamedNativeQuery(name = "Programa.ListarProgramasPorModalidadYNivelAcademico", 
            query="call listar_programas_por_modalidad_y_nivelacademico(?, ?);",
            resultClass = Programa.class),
    @NamedNativeQuery(name = "Programa.ListarProgramasPorNivelAcademico", 
            query="call listar_programas_por_nivel_academico(?);",
            resultClass = Programa.class),
    @NamedNativeQuery(name = "Programa.ListarProgramasPorNombre", 
            query="call listar_programas_por_nombre(?);",
            resultClass = Programa.class),
})



public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRA_ID")
    private Integer praId;
    @Size(max = 50)
    @Column(name = "PRA_CODIGO")
    private String praCodigo;
    @Size(max = 200)
    @Column(name = "PRA_NOMBRE")
    private String praNombre;
    @OneToMany(mappedBy = "praId")
    private List<Variacion> variacionList;
    @JoinColumn(name = "MOD_ID", referencedColumnName = "MOD_ID")
    @ManyToOne
    private Modalidad modId;
    @JoinColumn(name = "NAC_ID", referencedColumnName = "NAC_ID")
    @ManyToOne
    private NivelAcademico nacId;
    @OneToMany(mappedBy = "praId")
    private List<Persona> personaList;

    public Programa() {
    }

    public Programa(Integer praId) {
        this.praId = praId;
    }

    public Integer getPraId() {
        return praId;
    }

    public void setPraId(Integer praId) {
        this.praId = praId;
    }

    public String getPraCodigo() {
        return praCodigo;
    }

    public void setPraCodigo(String praCodigo) {
        this.praCodigo = praCodigo;
    }

    public String getPraNombre() {
        return praNombre;
    }

    public void setPraNombre(String praNombre) {
        this.praNombre = praNombre;
    }

    @XmlTransient
    public List<Variacion> getVariacionList() {
        return variacionList;
    }

    public void setVariacionList(List<Variacion> variacionList) {
        this.variacionList = variacionList;
    }

    public Modalidad getModId() {
        return modId;
    }

    public void setModId(Modalidad modId) {
        this.modId = modId;
    }

    public NivelAcademico getNacId() {
        return nacId;
    }

    public void setNacId(NivelAcademico nacId) {
        this.nacId = nacId;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (praId != null ? praId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.praId == null && other.praId != null) || (this.praId != null && !this.praId.equals(other.praId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.Programa[ praId=" + praId + " ]";
    }
    
}
