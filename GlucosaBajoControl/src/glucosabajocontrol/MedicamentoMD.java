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

/**
 *
 * @author bryan
 */
public class MedicamentoMD {

    ReadProperties rp = new ReadProperties();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet result;
    String cadena;
    String raiz = System.getProperty("user.dir");

    public boolean insertarMedicamento(String NOM_MEDI, float DOSIS_MEDI, String INDICA_MEDI, boolean ESTADO_MEDI) throws IOException, SQLException {

        final String cadena = "insert into MEDICAMENTO (NOM_MEDI, DOSIS_MEDI, INDICA_MEDI, ESTADO_MEDI) values (?,?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, NOM_MEDI);
        preparedStatement.setFloat(2, DOSIS_MEDI);
        preparedStatement.setString(3, INDICA_MEDI);
        preparedStatement.setBoolean(4, ESTADO_MEDI);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public ArrayList<MedicamentoDP> consultarMedicamento() throws IOException, SQLException {

        ArrayList<MedicamentoDP> medicamentos = new ArrayList<>();

        final String cadena = "SELECT * FROM MEDICAMENTO";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String nom = resultSet.getString(1);
            float dosis = resultSet.getInt(2);
            String indica = resultSet.getString(3);
            boolean esta = resultSet.getBoolean(4);

            medicamentos.add(new MedicamentoDP(nom, dosis, indica, esta));
        }
        preparedStatement.close();
        return medicamentos;
    }

    public boolean modificarMedicamento(String NOM_MEDI, float DOSIS_MEDI, String INDICA_MEDI, boolean ESTADO_MEDI) throws IOException, SQLException {

        final String cadena = "UPDATE MEDICAMENTO SET DOSIS_MEDI = ?, INDICA_MEDI = ?, ESTADO_MEDI = ? WHERE NOM_MEDI = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(4, NOM_MEDI);
        preparedStatement.setFloat(1, DOSIS_MEDI);
        preparedStatement.setString(2, INDICA_MEDI);
        preparedStatement.setBoolean(3, ESTADO_MEDI);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }
}
