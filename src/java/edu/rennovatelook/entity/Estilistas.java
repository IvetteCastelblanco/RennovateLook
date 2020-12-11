/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rennovatelook.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author IVETH CASTELBLANCO
 */
@Entity
@Table(name = "estilistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estilistas.findAll", query = "SELECT e FROM Estilistas e")})
public class Estilistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estilista")
    private Integer idEstilista;
    @Size(max = 30)
    @Column(name = "nombres_estilista")
    private String nombresEstilista;
    @Size(max = 30)
    @Column(name = "apellidos_estilista")
    private String apellidosEstilista;
    @Column(name = "telefono_estilista")
    private Integer telefonoEstilista;
    @Size(max = 40)
    @Column(name = "direccion_estilista")
    private String direccionEstilista;
    @Size(max = 30)
    @Column(name = "email_estilista")
    private String emailEstilista;
    @Size(max = 10)
    @Column(name = "clave_estilista")
    private String claveEstilista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFkEstilista", fetch = FetchType.LAZY)
    private Collection<Horarios> horariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFkEstilista", fetch = FetchType.LAZY)
    private Collection<Citas> citasCollection;

    public Estilistas() {
    }

    public Estilistas(Integer idEstilista) {
        this.idEstilista = idEstilista;
    }

    public Integer getIdEstilista() {
        return idEstilista;
    }

    public void setIdEstilista(Integer idEstilista) {
        this.idEstilista = idEstilista;
    }

    public String getNombresEstilista() {
        return nombresEstilista;
    }

    public void setNombresEstilista(String nombresEstilista) {
        this.nombresEstilista = nombresEstilista;
    }

    public String getApellidosEstilista() {
        return apellidosEstilista;
    }

    public void setApellidosEstilista(String apellidosEstilista) {
        this.apellidosEstilista = apellidosEstilista;
    }

    public Integer getTelefonoEstilista() {
        return telefonoEstilista;
    }

    public void setTelefonoEstilista(Integer telefonoEstilista) {
        this.telefonoEstilista = telefonoEstilista;
    }

    public String getDireccionEstilista() {
        return direccionEstilista;
    }

    public void setDireccionEstilista(String direccionEstilista) {
        this.direccionEstilista = direccionEstilista;
    }

    public String getEmailEstilista() {
        return emailEstilista;
    }

    public void setEmailEstilista(String emailEstilista) {
        this.emailEstilista = emailEstilista;
    }

    public String getClaveEstilista() {
        return claveEstilista;
    }

    public void setClaveEstilista(String claveEstilista) {
        this.claveEstilista = claveEstilista;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstilista != null ? idEstilista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estilistas)) {
            return false;
        }
        Estilistas other = (Estilistas) object;
        if ((this.idEstilista == null && other.idEstilista != null) || (this.idEstilista != null && !this.idEstilista.equals(other.idEstilista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.rennovatelook.entity.Estilistas[ idEstilista=" + idEstilista + " ]";
    }
    
}
