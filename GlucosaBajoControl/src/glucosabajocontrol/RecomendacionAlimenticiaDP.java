/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

/**
 *
 * @author W10USER
 */
public class RecomendacionAlimenticiaDP {
    String nombreAlimento;
    float grasaAlimento;
    float azucarAlimento;
    PacienteDP Paciente;
    GlucosaDP Glucosa;
    public RecomendacionAlimenticiaDP(String nombreAlimento,
    float grasaAlimento,
    float azucarAlimento,
    PacienteDP Paciente,
    GlucosaDP Glucosa)
    {
        this.nombreAlimento = nombreAlimento;
        this.grasaAlimento = grasaAlimento;
        this.azucarAlimento = azucarAlimento;
        this.Paciente =    Paciente;
        this.Glucosa  =  Glucosa;
    }
    public float getPeso() {
        return Paciente.getPeso();
    }
    public float getGlucosa() {
        return Glucosa.getConcentracionAzucar();
    }
    public void RecomendacionAlimenticia()
    {
        
    }
    public void Guardar()
    {
        
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public float getGrasaAlimento() {
        return grasaAlimento;
    }

    public float getAzucarAlimento() {
        return azucarAlimento;
    }

}
