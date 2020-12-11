/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rennovatelook.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IVETH CASTELBLANCO
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Size(max = 20)
    @Column(name = "forma_de_pago_venta")
    private String formaDePagoVenta;
    @Column(name = "cantidad_venta")
    private Integer cantidadVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total_venta")
    private Float valorTotalVenta;
    @JoinColumn(name = "id_fk_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes idFkCliente;
    @JoinColumn(name = "id_fk_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idFkEmpleado;
    @JoinColumn(name = "id_fk_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos idFkProducto;

    public Ventas() {
    }

    public Ventas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Ventas(int i, Date fecha, String forma, int cantidad, float valorTotal, Clientes cli, Empleados emp, Productos pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getFormaDePagoVenta() {
        return formaDePagoVenta;
    }

    public void setFormaDePagoVenta(String formaDePagoVenta) {
        this.formaDePagoVenta = formaDePagoVenta;
    }

    public Integer getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(Integer cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public Float getValorTotalVenta() {
        return valorTotalVenta;
    }

    public void setValorTotalVenta(Float valorTotalVenta) {
        this.valorTotalVenta = valorTotalVenta;
    }

    public Clientes getIdFkCliente() {
        return idFkCliente;
    }

    public void setIdFkCliente(Clientes idFkCliente) {
        this.idFkCliente = idFkCliente;
    }

    public Empleados getIdFkEmpleado() {
        return idFkEmpleado;
    }

    public void setIdFkEmpleado(Empleados idFkEmpleado) {
        this.idFkEmpleado = idFkEmpleado;
    }

    public Productos getIdFkProducto() {
        return idFkProducto;
    }

    public void setIdFkProducto(Productos idFkProducto) {
        this.idFkProducto = idFkProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.rennovatelook.entity.Ventas[ idVenta=" + idVenta + " ]";
    }
    
}
