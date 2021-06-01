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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author W10USER
 */
public class Hba1cDP {

    String codigo;
    String momentoMedicion;
    Date fechaCalculo;
    float valor;

    Hba1cMD hba1cMD = new Hba1cMD();

    public Hba1cDP() {
    }

    public Hba1cDP(String codigo, String momentoMedicion, Date fechaGlucosa, float valor) {
        this.codigo = codigo;
        this.momentoMedicion = momentoMedicion;
        this.fechaCalculo = fechaGlucosa;
        this.valor = valor;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String setCodigo() {
        return codigo;
    }

    public void setMomentoMedicion(String momentoMedicion) {
        this.momentoMedicion = momentoMedicion;
    }

    public void setFechaGlucosa(Date fechaGlucosa) {
        this.fechaCalculo = fechaGlucosa;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFechaGlucosa() {
        return fechaCalculo;
    }

    public float getValor() {
        return valor;
    }

    public String getMomentoMedicion() {
        return momentoMedicion;
    }

      public boolean modificarDP(int conAzucar, String id) throws IOException, SQLException {
        valor = (conAzucar + 46.7f) / 28.7f;
        return hba1cMD.modificarHba1c(codigo, id, fechaCalculo, valor);
    }

    public boolean eliminarDP(String id) throws IOException, SQLException {
        return hba1cMD.eliminarHba1c(codigo, id);
    }

    public boolean guardarDP(int conAzucar, String ID_PAC) throws IOException, SQLException {
        valor = (conAzucar + 46.7f) / 28.7f;
       return hba1cMD.insertarHba1c(codigo, ID_PAC, momentoMedicion, fechaCalculo, valor);
    }

    public ArrayList<Hba1cDP> consultarDP(String ID_PAC) throws IOException, SQLException {
        return hba1cMD.consultarHba1c(ID_PAC);
    }
}
