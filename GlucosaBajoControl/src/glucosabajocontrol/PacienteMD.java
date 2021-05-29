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

    public boolean insertarPaciente(String CED_PAC, String NOM_PAC, String APEL_PAC, int EDAD_PAC, String CORRE_PAC, float ALTURA_PAC, float PESO_PAC, String TIPOSAN_PAC, int TIPODIAB_PAC) throws IOException, SQLException {

        final String cadena = "insert into PACIENTE (CED_PAC, NOM_PAC, APEL_PAC, EDAD_PAC, CORRE_PAC, ALTURA_PAC, PESO_PAC, TIPOSAN_PAC, TIPODIAB_PAC) values (?,?,?,?,?,?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, CED_PAC);
        preparedStatement.setString(2, NOM_PAC);
        preparedStatement.setString(3, APEL_PAC);
        preparedStatement.setInt(4, EDAD_PAC);
        preparedStatement.setString(5, CORRE_PAC);
        preparedStatement.setFloat(6, ALTURA_PAC);
        preparedStatement.setFloat(7, PESO_PAC);
        preparedStatement.setString(8, TIPOSAN_PAC);
        preparedStatement.setInt(9, TIPODIAB_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public PacienteDP consultarPaciente(String CED_PAC) throws IOException, SQLException {

        final String cadena = "SELECT * FROM PACIENTE WHERE CED_PAC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, CED_PAC);

        ResultSet resultSet = preparedStatement.executeQuery();

        String nom = resultSet.getString(1);
        String apel = resultSet.getString(2);
        int edad = resultSet.getInt(3);
        String correo = resultSet.getString(4);
        float altura = resultSet.getFloat(5);
        float peso = resultSet.getFloat(6);
        String tipoSan = resultSet.getString(7);
        int tipoDiab = resultSet.getInt(8);

        preparedStatement.close();

        return new PacienteDP(CED_PAC, nom, apel, edad, correo, altura, peso, tipoSan, tipoDiab);
    }

    public boolean modificarPaciente(String CED_PAC, String NOM_PAC, String APEL_PAC, int EDAD_PAC, String CORRE_PAC, float ALTURA_PAC, float PESO_PAC, String TIPOSAN_PAC, int TIPODIAB_PAC) throws IOException, SQLException {

        final String cadena = "UPDATE PACIENTE SET NOM_PAC = ?, APEL_PAC = ?, EDAD_PAC = ?, CORRE_PAC = ?, ALTURA_PAC = ?, PESO_PAC = ?, TIPOSAN_PAC = ?, TIPODIAB_PAC = ? WHERE ID_PAC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(9, CED_PAC);
        preparedStatement.setString(1, NOM_PAC);
        preparedStatement.setString(2, APEL_PAC);
        preparedStatement.setInt(3, EDAD_PAC);
        preparedStatement.setString(4, CORRE_PAC);
        preparedStatement.setFloat(5, ALTURA_PAC);
        preparedStatement.setFloat(6, PESO_PAC);
        preparedStatement.setString(7, TIPOSAN_PAC);
        preparedStatement.setInt(8, TIPODIAB_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }

    public boolean eliminarPaciente(String CED_PAC) throws IOException, SQLException {

        final String cadena = "DELETE FROM PACIENTE WHERE COD_HB = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, CED_PAC);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
}
