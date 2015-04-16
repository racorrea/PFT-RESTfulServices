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
import javax.persistence.Lob;
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
@Table(name = "pft_proyecto")
@XmlRootElement

@NamedNativeQueries({
    @NamedNativeQuery(name = "Proyecto.ListarProyectos", 
            query="call listar_proyectos();",
            resultClass = Proyecto.class),
    @NamedNativeQuery(name = "Proyecto.ListarProyectosPorNombre", 
            query="call listar_proyecto_estado_por_nombre_proyecto(?);",
            resultClass = Proyecto.class),
    @NamedNativeQuery(name = "Proyecto.ListarProyectosPorEstado", 
            query="call listar_proyecto_estado_por_estado(?);",
            resultClass = Proyecto.class)
    
})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Size(max = 300)
    @Column(name = "pro_titulo")
    private String proTitulo;
    @Size(max = 100)
    @Column(name = "pro_duracion")
    private String proDuracion;
    @Lob
    @Size(max = 65535)
    @Column(name = "pro_descripcion")
    private String proDescripcion;
    @Size(max = 45)
    @Column(name = "pro_componente_teorico")
    private String proComponenteTeorico;
    @Size(max = 45)
    @Column(name = "pro_componente_practico")
    private String proComponentePractico;
    @Lob
    @Size(max = 65535)
    @Column(name = "pro_proposito")
    private String proProposito;
    @JoinColumn(name = "pro_id_persona", referencedColumnName = "ENT_ID")
    @ManyToOne(optional = false)
    private Persona proIdPersona;
    @OneToMany(mappedBy = "aproIdProyecto")
    private List<Aprobacion> aprobacionList;

    public Proyecto() {
    }

    public Proyecto(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProTitulo() {
        return proTitulo;
    }

    public void setProTitulo(String proTitulo) {
        this.proTitulo = proTitulo;
    }

    public String getProDuracion() {
        return proDuracion;
    }

    public void setProDuracion(String proDuracion) {
        this.proDuracion = proDuracion;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public String getProComponenteTeorico() {
        return proComponenteTeorico;
    }

    public void setProComponenteTeorico(String proComponenteTeorico) {
        this.proComponenteTeorico = proComponenteTeorico;
    }

    public String getProComponentePractico() {
        return proComponentePractico;
    }

    public void setProComponentePractico(String proComponentePractico) {
        this.proComponentePractico = proComponentePractico;
    }

    public String getProProposito() {
        return proProposito;
    }

    public void setProProposito(String proProposito) {
        this.proProposito = proProposito;
    }

    public Persona getProIdPersona() {
        return proIdPersona;
    }

    public void setProIdPersona(Persona proIdPersona) {
        this.proIdPersona = proIdPersona;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.utpl.rest.modelo.Proyecto[ proId=" + proId + " ]";
    }
    
}
