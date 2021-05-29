/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;
import java.sql.Date;

/**
 *
 * @author W10USER
 */
public class GlucosaDP {
    Date fechaGlucosa;
    String momentoMedicion;
    int concentracionAzucar;
    String comentario;
    Hba1cDP hba1c;
    public GlucosaDP(Date fechaGlucosa,String momentoMedicion,
            int concentracionAzucar, String comentario, Hba1cDP hba1ic) 
    {
        this.fechaGlucosa = fechaGlucosa;
        this.momentoMedicion = momentoMedicion;
        this.concentracionAzucar = concentracionAzucar;
        this.comentario = comentario;
        this.hba1c = hba1ic;
    }
     public GlucosaDP(Date fechaGlucosa,String momentoMedicion,
            int concentracionAzucar, String comentario) 
    {
        this.fechaGlucosa = fechaGlucosa;
        this.momentoMedicion = momentoMedicion;
        this.concentracionAzucar = concentracionAzucar;
        this.comentario = comentario;
    }

    public void setFechaGlucosa(Date fechaGlucosa) {
        this.fechaGlucosa = fechaGlucosa;
    }

    public void setMomentoMedicion(String momentoMedicion) {
        this.momentoMedicion = momentoMedicion;
    }

    public void setConcentracionAzucar(int concentracionAzucar) {
        this.concentracionAzucar = concentracionAzucar;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setHba1c(Hba1cDP hba1c) {
        this.hba1c = hba1c;
    }

    public Date getFechaGlucosa() {
        return fechaGlucosa;
    }

    public String getMomentoMedicion() {
        return momentoMedicion;
    }

    public int getConcentracionAzucar() {
        return concentracionAzucar;
    }

    public String getComentario() {
        return comentario;
    }

    public Hba1cDP getHba1c() {
        return hba1c;
    }
    public void guardarDP(){
        
    }
    public void consultarDP(){
        
    }
    public void eliminarDP(){
        
    }
    public void modificarDP(){
        
    }
    
}
