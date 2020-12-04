package controlador;

import dao.EmpleadosJpaController;
import dao.exceptions.IllegalOrphanException;
import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Empleados;

@ManagedBean
@RequestScoped
public class UsuariosControlador implements Serializable{

    Empleados emp = new Empleados();
    EmpleadosJpaController empleadoDAO;
    List<Empleados> listaEmp;

    public UsuariosControlador() {
    }

    @PostConstruct
    public void buscarInven() {
        empleadoDAO = new EmpleadosJpaController();
        listaEmp = empleadoDAO.findEmpleadosEntities();
    }
    
    public void crearProducto() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            empleadoDAO = new EmpleadosJpaController();
            empleadoDAO.create(emp);
            context.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Producto creado exitosamente",
                            "EXITO!!!!"));
        } catch (Exception ex) {
            context.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "No se pudo crear el producto",
                            "Si el problema sigue consulte con el administrador"));
        }
    }
    
    public void borrarUsuario(Empleados emp) {
        try {
            empleadoDAO = new EmpleadosJpaController();
            empleadoDAO.destroy(emp.getIdEmpleado());
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            Logger.getLogger(UsuariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarUsuario(Empleados empl) {
        emp = empl;
    }
    
    public void editarUsuario() {
        try {
            empleadoDAO = new EmpleadosJpaController();
            empleadoDAO.edit(emp);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleados getEmp() {
        return emp;
    }

    public void setEmp(Empleados emp) {
        this.emp = emp;
    }

    public List<Empleados> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<Empleados> listaEmp) {
        this.listaEmp = listaEmp;
    }

}
