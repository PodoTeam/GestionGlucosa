/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class AlimentoDP {

    String nombreAlimento;
    double grasaAlimento;
    double azucarAlimento;
    PacienteDP Paciente;//revisar las inicializaciones de los objetos
    GlucosaDP Glucosa;

    public AlimentoDP(String nombreAlimento, double grasaAlimento, double azucarAlimento) {
        this.nombreAlimento = nombreAlimento;
        this.grasaAlimento = grasaAlimento;
        this.azucarAlimento = azucarAlimento;
    }
     public AlimentoDP(String nombreAlimento, double grasaAlimento, double azucarAlimento, PacienteDP Paciente, GlucosaDP Glucosa) {
        this.nombreAlimento = nombreAlimento;
        this.grasaAlimento = grasaAlimento;
        this.azucarAlimento = azucarAlimento;
    }
     public AlimentoDP()
     {}
    public float getPeso() {
        return Paciente.getPeso();
    }

    public float getGlucosa() {
        return Glucosa.getConcentracionAzucar();
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String NombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public double getGrasaAlimento() {
        return grasaAlimento;
    }

    public void setGrasaAlimento(float GrasaAlimento) {
        this.grasaAlimento = grasaAlimento;
    }

    public double getAzucarAlimento() {
        return azucarAlimento;
    }

    public void setAzucarAlimento(float azucarAlimento) {
        this.azucarAlimento = azucarAlimento;
    }  
     public ArrayList<AlimentoDP> getAlimentos(double  peso, double ims) throws IOException, SQLException {
        ArrayList<AlimentoDP> arr = new ArrayList<AlimentoDP>();
        AlimentoMD alimd = new AlimentoMD();
        if (ims < 16)
        {
            //persona con falta de peso
            // 100 personas flacas   
            arr = alimd.consultarRecomendacion(100,">");
        }
        else if (ims >= 27)
        { 
            // menor a 100 personas gordas
            // persona con sobre peso
            arr = alimd.consultarRecomendacion(100,"<");
            
        }
        return arr;
        
    }
    

}
