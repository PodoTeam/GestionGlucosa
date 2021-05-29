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
public class PacienteMD {

    ReadProperties rp = new ReadProperties();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet result;
    String cadena;
    String raiz = System.getProperty("user.dir");

    public boolean insertarPaciente(String ID_PAC, String NOM_PAC, String APEL_PAC, int EDAD_PAC, float ALTURA_PAC, float PESO_PAC, String TIPOSAN_PAC, int TIPODIAB_PAC) throws IOException, SQLException {

        final String cadena = "insert into PACIENTE (ID_PAC, NOM_PAC, APEL_PAC, EDAD_PAC, ALTURA_PAC, PESO_PAC, TIPOSAN_PAC, TIPODIAB_PAC) values (?,?,?,?,?,?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, ID_PAC);
        preparedStatement.setString(2, NOM_PAC);
        preparedStatement.setString(3, APEL_PAC);
        preparedStatement.setInt(4, EDAD_PAC);
        preparedStatement.setFloat(5, ALTURA_PAC);
        preparedStatement.setFloat(6, PESO_PAC);
        preparedStatement.setString(7, TIPOSAN_PAC);
        preparedStatement.setInt(8, TIPODIAB_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public PacienteDP consultarPaciente(String ID_PAC) throws IOException, SQLException {

        final String cadena = "SELECT * FROM PACIENTE WHERE ID_PAC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, ID_PAC);

        ResultSet resultSet = preparedStatement.executeQuery();

        String nom = resultSet.getString(1);
        String apel = resultSet.getString(2);
        int edad = resultSet.getInt(3);
        float altura = resultSet.getFloat(4);
        float peso = resultSet.getFloat(5);
        String tipoSan = resultSet.getString(6);
        int tipoDiab = resultSet.getInt(7);

        preparedStatement.close();

        return new PacienteDP(ID_PAC, nom, apel, edad, altura, peso, tipoSan, tipoDiab);
    }

    public boolean modificarPaciente(String ID_PAC, String NOM_PAC, String APEL_PAC, int EDAD_PAC, float ALTURA_PAC, float PESO_PAC, String TIPOSAN_PAC, int TIPODIAB_PAC) throws IOException, SQLException {

        final String cadena = "UPDATE PACIENTE SET NOM_PAC = ?, APEL_PAC = ?, EDAD_PAC = ?, ALTURA_PAC = ?, PESO_PAC = ?, TIPOSAN_PAC = ?, TIPODIAB_PAC = ? WHERE ID_PAC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(8, ID_PAC);
        preparedStatement.setString(1, NOM_PAC);
        preparedStatement.setString(2, APEL_PAC);
        preparedStatement.setInt(3, EDAD_PAC);
        preparedStatement.setFloat(4, ALTURA_PAC);
        preparedStatement.setFloat(5, PESO_PAC);
        preparedStatement.setString(6, TIPOSAN_PAC);
        preparedStatement.setInt(7, TIPODIAB_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }

    public boolean eliminarPaciente(String ID_PAC) throws IOException, SQLException {

        final String cadena = "DELETE FROM PACIENTE WHERE COD_HB = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, ID_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
}