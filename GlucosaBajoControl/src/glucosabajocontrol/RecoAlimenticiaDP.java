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
public class RecoAlimenticiaDP {
    
    PacienteDP Paciente;
    AlimentoDP Alimento;
    Date fechaReco;
    
    public RecoAlimenticiaDP(PacienteDP Paciente, AlimentoDP alimento, Date fechaReco)
    {
        this.Paciente = Paciente;
        this.Alimento = Alimento;
        this.fechaReco = fechaReco;
        
    }
   
    public void RecomendacionAlimenticia()
    {
        
    }
    public void Guardar()
    {
        
    }

    

}
