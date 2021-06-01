/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glucosabajocontrol;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
/**
 *
 * @author W10USER
 */
public class RecoAlimenticiaDP {
    
    String Paciente;
    String Alimento;
    Date fechaReco;
    
    public RecoAlimenticiaDP(String Paciente, String alimento, Date fechaReco)
    {
        this.Paciente = Paciente;
        this.Alimento = Alimento;
        this.fechaReco = fechaReco;
        
    }
   
    public void RecomendacionAlimenticia()
    {
        
    }
    public boolean Guardar() throws IOException, SQLException
    {
        boolean var = false;
        RecoAlimenticiaMD reco = new RecoAlimenticiaMD();
        var = reco.insertarRecomendacion(Paciente,Alimento,fechaReco);
        return var;
    }

    

}
