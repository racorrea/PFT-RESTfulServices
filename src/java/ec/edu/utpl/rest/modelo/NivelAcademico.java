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
@Table(name = "pft_nivel_academico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAcademico.findAll", query = "SELECT n FROM NivelAcademico n"),
    @NamedQuery(name = "NivelAcademico.findByNacId", query = "SELECT n FROM NivelAcademico n WHERE n.nacId = :nacId"),
    @NamedQuery(name = "NivelAcademico.findByNacNombre", query = "SELECT n FROM NivelAcademico n WHERE n.nacNombre = :nacNombre"),
    @NamedQuery(name = "NivelAcademico.findByNacDescripcion", query = "SELECT n FROM NivelAcademico n WHERE n.nacDescripcion = :nacDescripcion"),
    @NamedQuery(name = "NivelAcademico.findByNacCodigo", query = "SELECT n FROM NivelAcademico n WHERE n.nacCodigo = :nacCodigo")})
public class NivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAC_ID")
    private Integer nacId;
    @Size(max = 45)
    @Column(name = "NAC_NOMBRE")
    private String nacNombre;
    @Size(max = 45)
    @Column(name = "NAC_DESCRIPCION")
    private String nacDescripcion;
    @Size(max = 45)
    @Column(name = "NAC_CODIGO")
    private String nacCodigo;
    @OneToMany(mappedBy = "nacId")
    private List<Programa> programaList;

    public NivelAcademico() {
    }

    public NivelAcademico(Integer nacId) {
        this.nacId = nacId;
    }

    public Integer getNacId() {
        return nacId;
    }

    public void setNacId(Integer nacId) {
        this.nacId = nacId;
    }

    public String getNacNombre() {
        return nacNombre;
    }

    public void setNacNombre(String nacNombre) {
        this.nacNombre = nacNombre;
    }

    public String getNacDescripcion() {
        return nacDescripcion;
    }

    public void setNacDescripcion(String nacDescripcion) {
        this.nacDescripcion = nacDescripcion;
    }

    public String getNacCodigo() {
        return nacCodigo;
    }

    public void setNacCodigo(String nacCodigo) {
        this.nacCodigo = nacCodigo;
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
        hash += (nacId != null ? nacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademico)) {
            return false;
        }
        NivelAcademico other = (NivelAcademico) object;
        if ((this.nacId == null && other.nacId != null) || (this.nacId != null && !this.nacId.equals(other.nacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.NivelAcademico[ nacId=" + nacId + " ]";
    }
    
}
