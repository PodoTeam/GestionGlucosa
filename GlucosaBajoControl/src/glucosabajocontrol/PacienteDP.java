/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

/**
 *
 * @author Martin Guerra
 */
public class PacienteDP {
    
    String cedula;
    String nombre;
    String apellido;
    int edad;
    String correo;
    float altura;
    float peso;
    String tipoSanguineo;
    int tipoDiabetes;
    CuentaDP Cuenta;
    
    public PacienteDP(String cedula, String nombre, String apellido, int edad, String correo, float altura, float peso, String tipoSanguineo, int tipoDiabetes)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.altura = altura;
        this.peso = peso;
        this.tipoSanguineo = tipoSanguineo;
        this.tipoDiabetes = tipoDiabetes;
    }
    public void setId(String cedula){
        this.cedula = cedula;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setAltura(float altura){
        this.altura = altura;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public void setTipoSanguineo(String tipoSanguineo){
        this.tipoSanguineo = tipoSanguineo;
    }
    public void setTipoDiabetes(int tipoDiabetes){
        this.tipoDiabetes = tipoDiabetes;
    }
    
    public String getCedula(){
        return cedula;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
    public String getCorreo(){
        return correo;
    }
    public float getAltura(){
        return altura;
    }
    public float getPeso(){
        return peso;
    }
    public String getTipoSanguineo(){
        return tipoSanguineo;
    }
    public int getTipoDiabetes(){
        return tipoDiabetes;
    }
    public void consultarPaciente(){
        
    }
    public void modificar(){
        
    }
    public void eliminar(){
        
    }
    public void agregar(){
        
    }
   
}
