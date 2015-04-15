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
import javax.persistence.Lob;
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
@Table(name = "pft_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByDeptId", query = "SELECT d FROM Departamento d WHERE d.deptId = :deptId"),
    @NamedQuery(name = "Departamento.findByDeptNombre", query = "SELECT d FROM Departamento d WHERE d.deptNombre = :deptNombre")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dept_id")
    private Integer deptId;
    @Size(max = 100)
    @Column(name = "dept_nombre")
    private String deptNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "dept_descripcion")
    private String deptDescripcion;
    @OneToMany(mappedBy = "perIdDepartamento")
    private List<Persona> personaList;
    @OneToMany(mappedBy = "secIdDepartamento")
    private List<Seccion> seccionList;

    public Departamento() {
    }

    public Departamento(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptNombre() {
        return deptNombre;
    }

    public void setDeptNombre(String deptNombre) {
        this.deptNombre = deptNombre;
    }

    public String getDeptDescripcion() {
        return deptDescripcion;
    }

    public void setDeptDescripcion(String deptDescripcion) {
        this.deptDescripcion = deptDescripcion;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Seccion> getSeccionList() {
        return seccionList;
    }

    public void setSeccionList(List<Seccion> seccionList) {
        this.seccionList = seccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.Departamento[ deptId=" + deptId + " ]";
    }
    
}
