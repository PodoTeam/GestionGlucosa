/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

/**
 *
 * @author bryan
 */
public class AlimentoDP {

    String nombreAlimento;
    float grasaAlimento;
    float azucarAlimento;
    PacienteDP Paciente;//revisar las inicializaciones de los objetos
    GlucosaDP Glucosa;

    public AlimentoDP(String nombreAlimento, float grasaAlimento, float azucarAlimento) {
        this.nombreAlimento = nombreAlimento;
        this.grasaAlimento = grasaAlimento;
        this.azucarAlimento = azucarAlimento;
    }
     public AlimentoDP(String nombreAlimento, float grasaAlimento, float azucarAlimento, PacienteDP Paciente, GlucosaDP Glucosa) {
        this.nombreAlimento = nombreAlimento;
        this.grasaAlimento = grasaAlimento;
        this.azucarAlimento = azucarAlimento;
    }
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

    public float getGrasaAlimento() {
        return grasaAlimento;
    }

    public void setGrasaAlimento(float GrasaAlimento) {
        this.grasaAlimento = grasaAlimento;
    }

    public float getAzucarAlimento() {
        return azucarAlimento;
    }

    public void setAzucarAlimento(float azucarAlimento) {
        this.azucarAlimento = azucarAlimento;
    }

}
