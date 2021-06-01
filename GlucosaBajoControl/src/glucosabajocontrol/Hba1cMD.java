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

     public boolean insertarHba1c(String COD_HB, String ID_PAC, String MOMENT_HB, Date FECHA_HB, float CAL_HB) throws IOException, SQLException {

         final String cadena = "insert into HBA1C (COD_HB, ID_PAC, MOMENT_HB, FECHA_HB, CAL_HB) values (?,?,?,?,?)";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, COD_HB);
        preparedStatement.setString(2, ID_PAC);
         preparedStatement.setString(3, MOMENT_HB);
        preparedStatement.setDate(4, FECHA_HB);
        preparedStatement.setFloat(5, CAL_HB);
        
        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;

    }

    public ArrayList<Hba1cDP> consultarHba1c(String ID_PAC) throws IOException, SQLException {

        ArrayList<Hba1cDP> hba1c = new ArrayList<>();

         final String cadena = "SELECT COD_HB, FECHA_HB, MOMENT_HB, CAL_HB FROM HBA1C WHERE ID_PAC = ?";

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
            String codigo = resultSet.getString(1);
            Date fecha = resultSet.getDate(2);
            String moment = resultSet.getString(3);
            float valor = resultSet.getFloat(4);

            hba1c.add(new Hba1cDP(codigo, moment, fecha, valor));
        }
        preparedStatement.close();
        return hba1c;
    }

    public boolean modificarHba1c(String COD_HB, String ID_PAC, Date FECHA_HB, float CAL_HB) throws IOException, SQLException {

        final String cadena = "UPDATE HBA1C SET FECHA_HB = ?, CAL_HB = ? WHERE COD_HB = ? AND ID_PAC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(3, COD_HB);
        preparedStatement.setString(4, ID_PAC);
        preparedStatement.setDate(1, FECHA_HB);
        preparedStatement.setFloat(2, CAL_HB);

        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }

    public boolean eliminarHba1c(String COD_HB, String ID_PAC) throws IOException, SQLException {

        final String cadena = "DELETE * FROM HBA1C WHERE COD_HB = ? AND ID_PAC = ?";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(rp.obtenerURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicamentoMD.class.getName()).log(Level.SEVERE, null, ex);
        }

        preparedStatement = con.prepareStatement(cadena);
        preparedStatement.setString(1, COD_HB);
         preparedStatement.setString(2, ID_PAC);

        
        boolean resultado = preparedStatement.executeUpdate() == 1 ? true : false;
        preparedStatement.close();
        return resultado;
    }
}
