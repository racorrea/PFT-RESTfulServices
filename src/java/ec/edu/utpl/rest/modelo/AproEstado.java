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
import javax.persistence.Id;
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
@Table(name = "pft_apro_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AproEstado.findAll", query = "SELECT a FROM AproEstado a"),
    @NamedQuery(name = "AproEstado.findByEstId", query = "SELECT a FROM AproEstado a WHERE a.estId = :estId"),
    @NamedQuery(name = "AproEstado.findByEstEstado", query = "SELECT a FROM AproEstado a WHERE a.estEstado = :estEstado")})
public class AproEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_id")
    private Integer estId;
    @Size(max = 100)
    @Column(name = "est_estado")
    private String estEstado;
    @OneToMany(mappedBy = "aproIdEstado")
    private List<Aprobacion> aprobacionList;

    public AproEstado() {
    }

    public AproEstado(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(String estEstado) {
        this.estEstado = estEstado;
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
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AproEstado)) {
            return false;
        }
        AproEstado other = (AproEstado) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.AproEstado[ estId=" + estId + " ]";
    }
    
}
