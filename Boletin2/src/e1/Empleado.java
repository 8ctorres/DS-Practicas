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
public abstract class Empleado extends Persona{
    private long numss;
    private int salario; //salario en euros
    private Turnos turno;

    public Empleado(String nombre, String apellidos, String DNI, String direccion, int telefono, long numss, int salario, Turnos turno) {
        super(nombre, apellidos, DNI, direccion, telefono);
        this.numss = numss;
        this.salario = salario;
        this.turno= turno;
    }

    public long getNumss() {
        return numss;
    }

    public void setNumss(long numss) {
        this.numss = numss;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Turnos getTurno() {
        return turno;
    }

    public void setTurno(Turnos turno) {
        this.turno = turno;
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public int hashCode(){
        return Long.hashCode(this.numss);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.numss != other.numss) {
            return false;
        }
        return true;
    }
}