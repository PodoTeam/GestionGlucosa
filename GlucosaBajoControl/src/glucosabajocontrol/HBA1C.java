/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

import java.time.LocalDateTime;

/**
 *
 * @author W10USER
 */
public class HBA1C {
    LocalDateTime fechaGlucosa;
    float valor;
    
    public HBA1C(LocalDateTime fechaGlucosa,float valor)
    {
        this.fechaGlucosa =fechaGlucosa;
        this.valor = valor;
        
    }

    public void setFechaGlucosa(LocalDateTime fechaGlucosa) {
        this.fechaGlucosa = fechaGlucosa;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDateTime getFechaGlucosa() {
        return fechaGlucosa;
    }

    public float getValor() {
        return valor;
    }
    public void modificar(){
        
    }
    public void eliminar(){
        
    }
    
    public void crear(){
        
    }
    
    
}
