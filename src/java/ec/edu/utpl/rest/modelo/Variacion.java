/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.utpl.rest.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roddycorrea
 */
@Entity
@Table(name = "pft_variacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variacion.findAll", query = "SELECT v FROM Variacion v"),
    @NamedQuery(name = "Variacion.findByEcvId", query = "SELECT v FROM Variacion v WHERE v.ecvId = :ecvId"),
    @NamedQuery(name = "Variacion.findByEcvNombre", query = "SELECT v FROM Variacion v WHERE v.ecvNombre = :ecvNombre"),
    @NamedQuery(name = "Variacion.findByEcvTotalCreditos", query = "SELECT v FROM Variacion v WHERE v.ecvTotalCreditos = :ecvTotalCreditos")})
public class Variacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ECV_ID")
    private Integer ecvId;
    @Size(max = 200)
    @Column(name = "ECV_NOMBRE")
    private String ecvNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "ECV_DESCRIPCION")
    private String ecvDescripcion;
    @Column(name = "ECV_TOTAL_CREDITOS")
    private Integer ecvTotalCreditos;
    @JoinColumn(name = "PRA_ID", referencedColumnName = "PRA_ID")
    @ManyToOne
    private Programa praId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ecvId")
    private List<Persona> personaList;

    public Variacion() {
    }

    public Variacion(Integer ecvId) {
        this.ecvId = ecvId;
    }

    public Integer getEcvId() {
        return ecvId;
    }

    public void setEcvId(Integer ecvId) {
        this.ecvId = ecvId;
    }

    public String getEcvNombre() {
        return ecvNombre;
    }

    public void setEcvNombre(String ecvNombre) {
        this.ecvNombre = ecvNombre;
    }

    public String getEcvDescripcion() {
        return ecvDescripcion;
    }

    public void setEcvDescripcion(String ecvDescripcion) {
        this.ecvDescripcion = ecvDescripcion;
    }

    public Integer getEcvTotalCreditos() {
        return ecvTotalCreditos;
    }

    public void setEcvTotalCreditos(Integer ecvTotalCreditos) {
        this.ecvTotalCreditos = ecvTotalCreditos;
    }

    public Programa getPraId() {
        return praId;
    }

    public void setPraId(Programa praId) {
        this.praId = praId;
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
        hash += (ecvId != null ? ecvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variacion)) {
            return false;
        }
        Variacion other = (Variacion) object;
        if ((this.ecvId == null && other.ecvId != null) || (this.ecvId != null && !this.ecvId.equals(other.ecvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.Variacion[ ecvId=" + ecvId + " ]";
    }
    
}
