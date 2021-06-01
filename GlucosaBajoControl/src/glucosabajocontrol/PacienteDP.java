/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Martin Guerra
 */
public class PacienteDP {
    
    String cedula;
    String nombre;
    String apellido;
    int edad;
    float altura;
    float peso;
    String tipoSanguineo;
    int tipoDiabetes;
    String clave;
    //CuentaDP Cuenta;
    
    public PacienteDP(String cedula, String nombre, String apellido, int edad, float altura, float peso, String tipoSanguineo, int tipoDiabetes, String clave)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.tipoSanguineo = tipoSanguineo;
        this.tipoDiabetes = tipoDiabetes;
        this.clave = clave;
    }

    public PacienteDP(String user) {
        this.clave = user;
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
    public void setClave(String clave){
        this.clave = clave;
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
    public String getClave(){
        return clave;
    }
    public PacienteDP consultarPaciente() throws IOException, SQLException{
       PacienteMD pamd = new  PacienteMD();
       PacienteDP pad = pamd.consultarPaciente(this.clave);
       return pad;
    }
    public boolean modificar() throws IOException, SQLException{
       PacienteMD paci = new PacienteMD();
       return paci.modificarPaciente(cedula, nombre, apellido, edad, altura, peso, tipoSanguineo, tipoDiabetes, clave);
    }
    public boolean eliminar() throws IOException, SQLException{
       PacienteMD paci = new PacienteMD();
       return paci.eliminarPaciente(cedula);
    }
    public boolean agregar() throws IOException, SQLException{
        
       PacienteMD paci = new PacienteMD();
       System.out.println(cedula);
       System.out.println(nombre);
       System.out.println(apellido);
       System.out.println(edad);
       System.out.println(altura);
       System.out.println(peso);
       System.out.println(tipoSanguineo);
       System.out.println(tipoDiabetes);
       boolean resultado = paci.insertarPaciente(cedula,nombre,apellido,edad,altura,peso,tipoSanguineo,tipoDiabetes);
       return resultado;
    }
   
}
