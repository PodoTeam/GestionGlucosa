/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;
import java.time.LocalDateTime;
// import java.sql.Date;




/**
 *
 * @author W10USER
 */
public class GlucosaDP {
    LocalDateTime fechaGlucosa;
    String momentoMedicion;
    int concentracionAzucar;
    String comentario;
    HBA1C hba1c;
    public GlucosaDP(LocalDateTime fechaGlucosa,String momentoMedicion,
            int concentracionAzucar, String comentario, HBA1C hba1ic) 
    {
        this.fechaGlucosa = fechaGlucosa;
        this.momentoMedicion = momentoMedicion;
        this.concentracionAzucar = concentracionAzucar;
        this.comentario = comentario;
        this.hba1c = hba1ic;
    }

    public void setFechaGlucosa(LocalDateTime fechaGlucosa) {
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

    public void setHba1c(HBA1C hba1c) {
        this.hba1c = hba1c;
    }

    public LocalDateTime getFechaGlucosa() {
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

    public HBA1C getHba1c() {
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
