
package glucosabajocontrol;

public class MedicamentoDP {
    
    String nombre;
    float dosis;
    String indicaciones;
    Boolean estado; 
    
    public MedicamentoDP(String nombre, float dosis, String indicaciones, Boolean estado)
    {
        this.nombre = nombre;
        this.dosis =dosis;
        this.indicaciones =indicaciones;
        this.estado = estado;
    }
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
    public void cargarMedicamentos(){
        
    }
    
}
    
    
