/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author W10USER
 */
public class GlucosaDP {

    String codigoGlucosa;
    String codHb;
    Date fechaGlucosa;
    String momentoMedicion;
    int concentracionAzucar;
    String comentario;
    Hba1cDP hba1c;
    GlucosaMD glucosaMD;

    public GlucosaDP()
    {
        
    }
    
    public GlucosaDP(String codigoGlucosa, Date fechaGlucosa, String momentoMedicion,
            int concentracionAzucar, String comentario, Hba1cDP hba1ic) {

        this.codigoGlucosa = codigoGlucosa;
        this.fechaGlucosa = fechaGlucosa;
        this.momentoMedicion = momentoMedicion;
        this.concentracionAzucar = concentracionAzucar;
        this.comentario = comentario;
        this.hba1c = hba1ic;
    }

    public GlucosaDP(String codigoGlucosa, String codHb, Date fechaGlucosa, String momentoMedicion,
            int concentracionAzucar, String comentario) {

        this.codigoGlucosa = codigoGlucosa;
        this.codHb = codHb;
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

    public boolean guardarDP(String id) throws IOException, SQLException {
        hba1c.guardarDP();
        return glucosaMD.insertarGlucosa(codigoGlucosa, id, codHb, fechaGlucosa, momentoMedicion, concentracionAzucar, comentario);
    }

    public ArrayList<GlucosaDP> consultarDP(String id) throws IOException, SQLException {
        return glucosaMD.consultarGlucosa(id);
    }

    public boolean eliminarDP() throws IOException, SQLException {
        hba1c.eliminarDP();
        return glucosaMD.eliminarGlucosa(codigoGlucosa);
    }

    public boolean modificarDP() throws IOException, SQLException {
        hba1c.modificarDP();
        return glucosaMD.modificarGlucosa(codHb, fechaGlucosa, momentoMedicion, concentracionAzucar, comentario);
    }

}
