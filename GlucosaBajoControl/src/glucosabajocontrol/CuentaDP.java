/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

/**
 *
 * @author Martin Guerra
 */
public class CuentaDP {
    
    String usuario;
    String clave;
    
    public CuentaDP(String usuario, String clave)
    {
        this.usuario = usuario;
        this.clave = clave;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public String getUsuario(){
        return usuario;
    }
    public String getClave(){
        return clave;
    }
    public void verificar(){
        
    }
    public void grabar(){
        
    }
    public void eliminar(){
        
    }
}
