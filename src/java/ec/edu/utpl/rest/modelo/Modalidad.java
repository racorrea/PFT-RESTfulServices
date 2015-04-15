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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
@Table(name = "pft_modalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidad.findAll", query = "SELECT m FROM Modalidad m"),
    @NamedQuery(name = "Modalidad.findByModId", query = "SELECT m FROM Modalidad m WHERE m.modId = :modId"),
    @NamedQuery(name = "Modalidad.findByModCodigo", query = "SELECT m FROM Modalidad m WHERE m.modCodigo = :modCodigo"),
    @NamedQuery(name = "Modalidad.findByModNombre", query = "SELECT m FROM Modalidad m WHERE m.modNombre = :modNombre")})

@NamedNativeQueries({
    @NamedNativeQuery(name = "Modalidad.ListarModalidades", 
            query="call pft_db.listar_modalidades();",
            resultClass = Modalidad.class)
})

public class Modalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_ID")
    private Integer modId;
    @Size(max = 50)
    @Column(name = "MOD_CODIGO")
    private String modCodigo;
    @Size(max = 200)
    @Column(name = "MOD_NOMBRE")
    private String modNombre;
    @OneToMany(mappedBy = "modId")
    private List<Programa> programaList;

    public Modalidad() {
    }

    public Modalidad(Integer modId) {
        this.modId = modId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(String modCodigo) {
        this.modCodigo = modCodigo;
    }

    public String getModNombre() {
        return modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidad)) {
            return false;
        }
        Modalidad other = (Modalidad) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.Modalidad[ modId=" + modId + " ]";
    }
    
}
