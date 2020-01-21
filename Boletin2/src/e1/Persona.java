/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
public abstract class Persona {
    private final String nombre;
    private final String apellidos;
    private final int DNI;
    private String direccion;
    private int telefono;

    public Persona(String nombre, String apellidos, String DNI, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        setCTelefono(telefono);
        
//        if (DNI.length()!=9) throw new IllegalArgumentException("DNI no válido");
//        int dnin = new Integer((DNI.substring(0, 8)));
//        char dnil = DNI.charAt(8);
        
        this.DNI = new Integer((DNI.substring(0, 8)));
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getDNI() {
        return DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    private void setCTelefono(int telefono){
        setTelefono(telefono);
    }

    public void setTelefono(int telefono) {
        if ((telefono>=600000000) && (telefono<=999999999)){
        this.telefono = telefono;
        }
        else throw new IllegalArgumentException("telefono");
    }
    
    @Override
    public abstract String toString();
}
