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
    Date fechaCalculo;
    float valor;

    Hba1cMD hba1cMD = new Hba1cMD();

    public Hba1cDP() {
    }

    public Hba1cDP(String codigo, Date fechaGlucosa, float valor) {
        this.codigo = codigo;
        this.fechaCalculo = fechaGlucosa;
        this.valor = valor;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String setCodigo() {
        return codigo;
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

    public void modificarDP() {

    }

    public void eliminarDP() {

    }

    public void guardarDP(int conAzucar) {
        valor = (conAzucar + 46.7f) / 28.7f;
        try {
            hba1cMD.insertarHba1c(codigo, fechaCalculo, valor);
        } catch (IOException ex) {
            Logger.getLogger(Hba1cDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Hba1cDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Hba1cDP> consultarDP() throws IOException, SQLException {
        return hba1cMD.consultarHba1c();
    }
}
