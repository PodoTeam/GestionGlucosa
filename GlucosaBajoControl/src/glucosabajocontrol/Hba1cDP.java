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
public class Hba1cDP {

    String codigo;
    Date fechaCalculo;
    float valor;

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

    public void guardarDP() {

    }

    public void consultarDP() throws IOException, SQLException {
        
    }
}
