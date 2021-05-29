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
public class GlucosaMD {
     ReadProperties rp = new ReadProperties();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet result;
    String cadena;
    String raiz = System.getProperty("user.dir");

    public boolean insertarGlucosa(Date FECHA_GLUC, String MOMEN_GLUC, int AZU_GLUC, String COMEN_GLUC) throws IOException, SQLException {

        final String cadena = "insert into GLUCOSA (FECHA_GLUC, MOMEN_GLUC, AZU_GLUC, COMEN_GLUC) values (?,?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setDate(1, FECHA_GLUC);
        preparedStatement.setString(2, MOMEN_GLUC);
        preparedStatement.setInt(3, AZU_GLUC);
        preparedStatement.setString(4, COMEN_GLUC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public ArrayList<GlucosaDP> consultarGlucosa() throws IOException, SQLException {

        ArrayList<GlucosaDP> glucosa = new ArrayList<>();

        final String cadena = "SELECT * FROM GLUCOSA";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Date fecha = resultSet.getDate(1);
            String momen = resultSet.getString(2);
            int azu = resultSet.getInt(3);
            String comen = resultSet.getString(4);

            glucosa.add(new GlucosaDP(fecha, momen, azu, comen));
        }
        preparedStatement.close();
        return glucosa;
    }

    public boolean modificarGlucosa(Date FECHA_GLUC, String MOMEN_GLUC, int AZU_GLUC, String COMEN_GLUC) throws IOException, SQLException {

        final String cadena = "UPDATE GLUCOSA SET MOMEN_GLUC = ?, AZU_GLUC = ?, COMEN_GLUC = ? WHERE FECHA_GLUC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setDate(4, FECHA_GLUC);
        preparedStatement.setString(1, MOMEN_GLUC);
        preparedStatement.setInt(2, AZU_GLUC);
        preparedStatement.setString(3, COMEN_GLUC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
    
    public boolean eliminarGlucosa(Date FECHA_GLUC) throws IOException, SQLException {

        final String cadena = "DELETE FROM GLUCOSA WHERE FECHA_GLUC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setDate(1, FECHA_GLUC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
    
}
