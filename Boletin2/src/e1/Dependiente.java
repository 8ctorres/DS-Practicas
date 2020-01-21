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
public class Dependiente extends Empleado{
    private Especialidad especialidad;

    public Dependiente(String nombre, String apellidos, String DNI, String direccion, int telefono, long numss, int salario, Turnos turno, Especialidad especialidad) {
        super(nombre, apellidos, DNI, direccion, telefono, numss, salario, turno);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public int getSalario(){
        if (this.getTurno()==Turnos.NOCHE){
            return super.getSalario()+150;
        }
        else return super.getSalario();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Nombre: ");
        sb.append(this.getNombre());
        sb.append('\n');
        sb.append("Apellidos: ");
        sb.append(this.getApellidos());
        sb.append('\n');
        sb.append("DNI: ");
        sb.append(this.getDNI());
        sb.append('\n');
        sb.append("Dirección: ");
        sb.append(this.getDireccion());
        sb.append('\n');
        sb.append("Teléfono: ");
        sb.append(this.getTelefono());
        sb.append('\n');
        sb.append("Número SS: ");
        sb.append(this.getNumss());
        sb.append('\n');
        sb.append("Salario: ");
        sb.append(this.getSalario());
        sb.append('\n');
        sb.append("Turno: ");
        sb.append(this.getTurno());
        sb.append('\n');
        return new String(sb);
    }
    
    
}
