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
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author roddycorrea 
 */
@Entity
@Table(name = "pft_nivel_academico")
@XmlRootElement
//@XmlType(propOrder={"Id", "Nombre", "Descripcion", "Codigo"})
@NamedNativeQueries({
    @NamedNativeQuery(name = "NivelAcademico.ListarNivelAcademico", 
            query="call listar_nivel_academico();",
            resultClass = NivelAcademico.class)
})
public class NivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAC_ID")
    private Integer Id;
    @Size(max = 45)
    @Column(name = "NAC_NOMBRE")
    private String Nombre;
    @Size(max = 45)
    @Column(name = "NAC_DESCRIPCION")
    private String Descripcion;
    @Size(max = 45)
    @Column(name = "NAC_CODIGO")
    private String Codigo;
    @OneToMany(mappedBy = "nacId")
    private List<Programa> programaList;

    public NivelAcademico() {
    }

    public NivelAcademico(Integer nacId) {
        this.Id = nacId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
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
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcademico)) {
            return false;
        }
        NivelAcademico other = (NivelAcademico) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.NivelAcademico[ nacId=" + Id + " ]";
    }
    
}
