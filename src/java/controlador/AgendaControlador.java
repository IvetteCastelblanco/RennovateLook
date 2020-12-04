package controlador;

import dao.CitasJpaController;
import dao.ClientesJpaController;
import dao.EmpleadosJpaController;
import dao.EstilistasJpaController;
import dao.ProductosJpaController;
import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Citas;
import modelo.Clientes;
import modelo.Empleados;
import modelo.Estilistas;
import modelo.Productos;

@ManagedBean
@ViewScoped
public class AgendaControlador implements Serializable {

    Citas ci = new Citas();
    String cliente;
    String producto;
    String estilis;
    String empl;

    CitasJpaController citaDAO;
    List<Citas> listaCita;

    ClientesJpaController clienteDAO;
    List<Clientes> listaCliente;

    EstilistasJpaController estilisDAO;
    List<Estilistas> listaEstilis;

    ProductosJpaController producDAO;
    List<Productos> listaProduct;

    EmpleadosJpaController empleDAO;
    List<Empleados> listaEmpl;

    public AgendaControlador() {
    }

    @PostConstruct
    public void buscarCitas() {
        citaDAO = new CitasJpaController();
        listaCita = citaDAO.findCitasEntities();

        clienteDAO = new ClientesJpaController();
        listaCliente = clienteDAO.findClientesEntities();

        estilisDAO = new EstilistasJpaController();
        listaEstilis = estilisDAO.findEstilistasEntities();

        producDAO = new ProductosJpaController();
        listaProduct = producDAO.findProductosEntities();

        empleDAO = new EmpleadosJpaController();
        listaEmpl = empleDAO.findEmpleadosEntities();
    }

    public void crearAgenda() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Clientes c = new Clientes();
            Estilistas e = new Estilistas();
            Productos p = new Productos();
            Empleados em = new Empleados();
            citaDAO = new CitasJpaController();
            for (int i = 0; i < listaCliente.size(); i++) {
                if (Integer.parseInt(cliente) == listaCliente.get(i).getIdCliente()) {
                    c = listaCliente.get(i);
                    i = listaCliente.size();
                }
            }
            for (int i = 0; i < listaEstilis.size(); i++) {
                if (Integer.parseInt(estilis) == listaEstilis.get(i).getIdEstilista()) {
                    e = listaEstilis.get(i);
                    i = listaEstilis.size();
                }
            }
            for (int i = 0; i < listaProduct.size(); i++) {
                if (Integer.parseInt(producto) == listaProduct.get(i).getIdProducto()) {
                    p = listaProduct.get(i);
                    i = listaProduct.size();
                }
            }
            for (int i = 0; i < listaEmpl.size(); i++) {
                if (Integer.parseInt(empl) == listaEmpl.get(i).getIdEmpleado()) {
                    em = listaEmpl.get(i);
                    i = listaEmpl.size();
                }
            }
            ci.setIdFkCliente(c);
            ci.setIdFkEmpleado(em);
            ci.setIdFkEstilista(e);
            ci.setIdFkProducto(p);
            citaDAO.create(ci);
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

    public void borrarCita(Citas c) {
        try {
            citaDAO = new CitasJpaController();
            citaDAO.destroy(c.getIdCita());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AgendaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarCita(Citas c) {
        ci = c;
    }

    public void editarCita() {
        try {
            citaDAO = new CitasJpaController();
            citaDAO.edit(ci);
        } catch (Exception ex) {
            Logger.getLogger(AgendaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Citas getCi() {
        return ci;
    }

    public void setCi(Citas ci) {
        this.ci = ci;
    }

    public List<Clientes> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Clientes> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<Estilistas> getListaEstilis() {
        return listaEstilis;
    }

    public void setListaEstilis(List<Estilistas> listaEstilis) {
        this.listaEstilis = listaEstilis;
    }

    public List<Productos> getListaProduct() {
        return listaProduct;
    }

    public void setListaProduct(List<Productos> listaProduct) {
        this.listaProduct = listaProduct;
    }

    public List<Empleados> getListaEmpl() {
        return listaEmpl;
    }

    public void setListaEmpl(List<Empleados> listaEmpl) {
        this.listaEmpl = listaEmpl;
    }

    public List<Citas> getListaCita() {
        return listaCita;
    }

    public void setListaCita(List<Citas> listaCita) {
        this.listaCita = listaCita;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEstilis() {
        return estilis;
    }

    public void setEstilis(String estilis) {
        this.estilis = estilis;
    }

    public String getEmpl() {
        return empl;
    }

    public void setEmpl(String empl) {
        this.empl = empl;
    }

}
