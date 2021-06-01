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

    public boolean insertarGlucosa(String COD_GLUC, String ID_PAC, String COD_HB, Date FECHA_GLUC, String MOMEN_GLUC, int AZU_GLUC, String COMEN_GLUC) throws IOException, SQLException {

        final String cadena = "insert into GLUCOSA (COD_GLUC, ID_PAC, COD_HB, FECHA_GLUC, MOMEN_GLUC, AZU_GLUC, COMEN_GLUC) values (?,?,?,?,?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, COD_GLUC);
        preparedStatement.setString(2, ID_PAC);
        preparedStatement.setString(3, COD_HB);
        preparedStatement.setDate(4, FECHA_GLUC);
        preparedStatement.setString(5, MOMEN_GLUC);
        preparedStatement.setInt(6, AZU_GLUC);
        preparedStatement.setString(7, COMEN_GLUC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public ArrayList<GlucosaDP> consultarGlucosa(String ID_PAC) throws IOException, SQLException {

        ArrayList<GlucosaDP> glucosa = new ArrayList<>();

        final String cadena = "SELECT * FROM GLUCOSA WHERE ID_PAC = ? ORDER BY FECHA_GLUC ASC";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, ID_PAC);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String cod = resultSet.getString(1);
            String hb = resultSet.getString(3);
            Date fecha = resultSet.getDate(4);
            String momen = resultSet.getString(5);
            int azu = resultSet.getInt(6);
            String comen = resultSet.getString(7);

            glucosa.add(new GlucosaDP(cod, hb, fecha, momen, azu, comen));
        }
        preparedStatement.close();
        return glucosa;
    }

    public boolean modificarGlucosa(String COD_GLUC, String ID_PAC, Date FECHA_GLUC, String MOMEN_GLUC, int AZU_GLUC, String COMEN_GLUC) throws IOException, SQLException {

        final String cadena = "UPDATE GLUCOSA SET FECHA_GLUC = ?, MOMEN_GLUC = ?, AZU_GLUC = ?, COMEN_GLUC = ? WHERE COD_GLUC = ? AND ID_PAC = ?";
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
        preparedStatement.setString(5, COD_GLUC);
        preparedStatement.setString(6, ID_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }

    public boolean eliminarGlucosa(String COD_GLUC, String ID_PAC) throws IOException, SQLException {

        final String cadena = "DELETE FROM GLUCOSA WHERE COD_GLUC = ? AND ID_PAC = ?";
                
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, COD_GLUC);
        preparedStatement.setString(2, ID_PAC);
        
        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }

}
