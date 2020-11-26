package app.controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juan_
 */
@ManagedBean(name = "controllerManagedBean")
@SessionScoped

public class ControllerManagedBean {
    
    public void procesarObligatorio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("MyLogin.java");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validarObligatorio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void procesarLongitud() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Videojuegos_Buscar.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validarLongitud() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ControllerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
