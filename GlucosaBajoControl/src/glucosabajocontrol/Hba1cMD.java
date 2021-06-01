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
public class Hba1cMD {

    ReadProperties rp = new ReadProperties();
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet result;
    String cadena;
    String raiz = System.getProperty("user.dir");

    public boolean insertarHba1c(String COD_HB, Date FECHA_HB, float CAL_HB) throws IOException, SQLException {

        final String cadena = "insert into HBA1C (COD_HB, FECHA_HB, CAL_HB) values (?,?,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, COD_HB);
        preparedStatement.setDate(2, FECHA_HB);
        preparedStatement.setFloat(3, CAL_HB);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public ArrayList<Hba1cDP> consultarHba1c() throws IOException, SQLException {

        ArrayList<Hba1cDP> hba1c = new ArrayList<>();

        final String cadena = "SELECT * FROM HBA1C";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String codigo = resultSet.getString(2);
            Date fecha = resultSet.getDate(1);
            float valor = resultSet.getInt(3);

            hba1c.add(new Hba1cDP(codigo, fecha, valor));
        }
        preparedStatement.close();
        return hba1c;
    }

    public boolean modificarHba1c(String COD_HB, Date FECHA_HB, float CAL_HB) throws IOException, SQLException {

        final String cadena = "UPDATE HBA1C SET FECHA_HB = ?, CAL_HB = ? WHERE COD_HB = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(3, COD_HB);
        preparedStatement.setDate(1, FECHA_HB);
        preparedStatement.setFloat(2, CAL_HB);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }

    public boolean eliminarHba1c(String COD_HB) throws IOException, SQLException {

        final String cadena = "DELETE FROM HBA1C WHERE COD_HB = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, COD_HB);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
}
