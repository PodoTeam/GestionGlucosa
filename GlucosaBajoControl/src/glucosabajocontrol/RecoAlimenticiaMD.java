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
public class RecoAlimenticiaMD {

    ReadProperties rp = new ReadProperties();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet result;
    String cadena;
    String raiz = System.getProperty("user.dir");

    public boolean insertarRecomendacion(String ID_PAC, String NOM_ALIM, Date FECHA_REC) throws IOException, SQLException {

        final String cadena = "insert into ALIMENTOS_POR_PACIENTE (ID_PAC, NOM_ALIM, FECHA_REC) values (?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, ID_PAC);
        preparedStatement.setString(2, NOM_ALIM);
        preparedStatement.setDate(3, FECHA_REC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public ArrayList<String> consultarRecomendacion(Date FECHA_REC) throws IOException, SQLException {

        ArrayList<String> resultado = new ArrayList<>();
        
        final String cadena = "SELECT * FROM PACIENTE WHERE FECHA_REC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setDate(1, FECHA_REC);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            resultado.add(resultSet.getString(2));            
        }

        preparedStatement.close();

        return resultado;
    }

    public boolean eliminarRecomendacion(Date FECHA_REC) throws IOException, SQLException {

        final String cadena = "DELETE * FROM CUENTA WHERE FECHA_REC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setDate(1, FECHA_REC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
}
