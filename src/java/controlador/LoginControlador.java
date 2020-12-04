/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EmpleadosJpaController;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Empleados;

/**
 *
 * @author usuario
 */
@ManagedBean
@RequestScoped
public class LoginControlador implements Serializable {
    
    EmpleadosJpaController empleadoDAO;
    private int idEmpleado;
    private String claveEmpleado;
    private String emailEmpleado;
    private int telefonoEmpleado;
    private Empleados emp;

    public LoginControlador() {
    }

    public String validarEmpleado() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            empleadoDAO = new EmpleadosJpaController();
            emp = empleadoDAO.findEmpleados(idEmpleado);
            if (emp.getClaveEmpleado().equals(claveEmpleado)) {
                return "menu";
            } else {
                context.addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Su identificacion o clave son incorrectas",
                                "Por favor intendelo de nuevo!"));
                return "login";

            }
        } catch (Exception ex) {
            return "login";
        }
    }

    public String crearEmpleado() {
        FacesContext context = FacesContext.getCurrentInstance();

        empleadoDAO = new EmpleadosJpaController();
        emp = new Empleados(idEmpleado, telefonoEmpleado, emailEmpleado, claveEmpleado);
        try {
            empleadoDAO.create(emp);
            context.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Empleado registrado con exito!", "Intente ingresar al sistema"));
            return "login";
        } catch (Exception ex) {
            context.addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Empleado ya registrado con exito!",
                            "Por favor intentelo de nuevo!"));
            return "login";
        }
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public int getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(int telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }
    
}
