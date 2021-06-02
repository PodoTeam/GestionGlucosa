
package glucosabajocontrol;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicamentoDP {
    
    String nombre;
    float dosis;
    String indicaciones;
    Boolean estado; 
    MedicamentoMD medi;
    public MedicamentoDP(String nombre, float dosis, String indicaciones, Boolean estado)
    {
        this.nombre = nombre;
        this.dosis =dosis;
        this.indicaciones =indicaciones;
        this.estado = estado;
        medi = new MedicamentoMD();
    }
    public MedicamentoDP()
    {medi = new MedicamentoMD(); }
    public void setMedicamento(String nombre) {
        this.nombre = nombre;
    }
    public void setDosis(float dosis) {
        this.dosis = dosis;
    }
     public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
     // La eliminacion se realiza mediate el cambio del estado
     public void eliminarMedicamento(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDosis() {
        return dosis;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public Boolean getEstado() {
        return estado;
    }
    public ArrayList<MedicamentoDP> cargarMedicamentos(String user) throws IOException, SQLException{
        
        ArrayList<MedicamentoDP> medica = new ArrayList<MedicamentoDP>();
        medica = medi.consultarMedicamento(user);
        return medica;
    }
    public boolean ingreso(String user) throws IOException, SQLException{
        
        PacienteDP pa = null;
        boolean result = medi.insertarMedicamento(nombre,user,dosis, indicaciones, true);
        return result;
    }
    
    public boolean  modificar(String nombre, float dosis,String indicaciones,Boolean estado ) throws IOException, SQLException{
        
        MedicamentoMD memd = new MedicamentoMD();
        boolean result = memd.modificarMedicamento(nombre, dosis, indicaciones, estado);
        return result;
    }
    
}
      
