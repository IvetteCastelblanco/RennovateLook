package controlador;

import dao.ProductosJpaController;
import dao.ProveedoresJpaController;
import dao.exceptions.IllegalOrphanException;
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
import modelo.Productos;
import modelo.Proveedores;

@ManagedBean
@ViewScoped
public class InventarioControlador implements Serializable {

    String Proveedores;
    Productos pro = new Productos();

    ProductosJpaController productoDAO;
    List<Productos> listaPro;

    ProveedoresJpaController provDAO;
    List<Proveedores> listaProv;

    public InventarioControlador() {
    }

    @PostConstruct
    public void buscarInven() {
        productoDAO = new ProductosJpaController();
        listaPro = productoDAO.findProductosEntities();

        provDAO = new ProveedoresJpaController();
        listaProv = provDAO.findProveedoresEntities();
    }

    public void crearProducto() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Proveedores p = new Proveedores();
            productoDAO = new ProductosJpaController();
            for (int i = 0; i < listaProv.size(); i++) {
                if (Integer.parseInt(Proveedores) == listaProv.get(i).getIdProveedor()) {
                    p = listaProv.get(i);
                    i = listaProv.size();
                }
            }
            pro.setIdFkProveedor(p);
            productoDAO.create(pro);
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
    
    public void borrarProducto(Productos p) {
        try {
            productoDAO = new ProductosJpaController();
            productoDAO.destroy(p.getIdProducto());
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            Logger.getLogger(InventarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void guardarProducto(Productos p) {
        pro = p;
    }

    public void editarProducto() {
        try {
            productoDAO = new ProductosJpaController();
            productoDAO.edit(pro);
        } catch (Exception ex) {
            Logger.getLogger(InventarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getProveedores() {
        return Proveedores;
    }

    public void setProveedores(String Proveedores) {
        this.Proveedores = Proveedores;
    }

    public Productos getPro() {
        return pro;
    }

    public void setPro(Productos pro) {
        this.pro = pro;
    }

    public List<Productos> getListaPro() {
        return listaPro;
    }

    public void setListaPro(List<Productos> listaPro) {
        this.listaPro = listaPro;
    }

    public List<Proveedores> getListaProv() {
        return listaProv;
    }

    public void setListaProv(List<Proveedores> listaProv) {
        this.listaProv = listaProv;
    }

}
