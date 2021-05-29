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

    public ArrayList<AlimentoDP> consultarRecomendacion(float GRASA_ALIM) throws IOException, SQLException {

        ArrayList<AlimentoDP> resultado = new ArrayList<>();
        
        final String cadena = "SELECT * FROM PACIENTE WHERE GRASA_ALIM = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setFloat(1, GRASA_ALIM);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            String nom = resultSet.getString(1);
            Float azuc = resultSet.getFloat(3);
            resultado.add(new AlimentoDP(nom, GRASA_ALIM, azuc));            
        }

        preparedStatement.close();

        return resultado;
    }
}
