package controlador;

import dao.ClientesJpaController;
import dao.EmpleadosJpaController;
import dao.ProductosJpaController;
import dao.VentasJpaController;
import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Clientes;
import modelo.Empleados;
import modelo.Productos;
import modelo.Ventas;

@ManagedBean(name = "VentaControlador")
@SessionScoped
public class VentaControlador implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    VentasJpaController ventaDAO;
    Ventas venta;
    int Codigo;
    int cantidad;
    int idCliente;
    float valorTotal;
    String forma;
    Date fecha = new Date();

    List<Ventas> listVentas;

    public VentaControlador() {
    }

    public void crearVenta() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ventaDAO = new VentasJpaController();
            Clientes cli = buscarCliente(idCliente);
            Productos pro = buscarProducto(Codigo);
            Empleados emp = buscarEmpleado(1010236598);
            venta = new Ventas(ventaDAO.getVentasCount() + 1, fecha, forma, cantidad, valorTotal, cli, emp, pro);
            ventaDAO.create(venta);
            context.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Venta creada exitosamente",
                            "EXITO!!!!"));
        } catch (Exception ex) {
            context.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se pudo realizar la venta",
                            "Si el problema sigue consulte con el administrador"));
        }
    }

    @PostConstruct
    public void buscarVentas() {
        ventaDAO = new VentasJpaController();
        listVentas = ventaDAO.findVentasEntities();
    }

    public Clientes buscarCliente(int id) {
        ClientesJpaController c = new ClientesJpaController();
        return c.findClientes(id);
    }

    public Productos buscarProducto(int id) {
        ProductosJpaController c = new ProductosJpaController();
        return c.findProductos(id);
    }

    public Empleados buscarEmpleado(int id) {
        EmpleadosJpaController c = new EmpleadosJpaController();
        return c.findEmpleados(id);
    }

    public void borrarVenta(Ventas venta) {
        try {
            ventaDAO = new VentasJpaController();
            ventaDAO.destroy(venta.getIdVenta());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarVenta(Ventas ventas) {
        venta = ventas;
    }

    public void editarVenta() {
        try {
            ventaDAO = new VentasJpaController();
            ventaDAO.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ventas> getListVentas() {
        return listVentas;
    }

    public void setListVentas(List<Ventas> listVentas) {
        this.listVentas = listVentas;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
