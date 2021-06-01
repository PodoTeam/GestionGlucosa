/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

import glucosabajocontrol.ReadProperties;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
/**
 *
 * @author bryan
 */
public class AlimentoMD {
    
    ReadProperties rp = new ReadProperties();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet result;
    String cadena;
    String raiz = System.getProperty("user.dir");

    public ArrayList<AlimentoDP> consultarRecomendacion(float GRASA_ALIM, String signo) throws IOException, SQLException {

        ArrayList<AlimentoDP> resultado = new ArrayList<>();
        
        final String cadena = "SELECT * FROM ALIMENTOS WHERE GRASA_ALIM "+signo+" ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setFloat(1, GRASA_ALIM);
        result = preparedStatement.executeQuery();

        while(result.next())
        {
            String nom = result.getString(1);
            double grasa = result.getDouble(2);
            Float azuc = result.getFloat(3);
            resultado.add(new AlimentoDP(nom, grasa, azuc));            
        }

        preparedStatement.close();

        return resultado;
    }
}
