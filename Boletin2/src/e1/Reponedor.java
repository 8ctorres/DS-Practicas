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
public class Reponedor extends Empleado{
    private String empresa;

    public Reponedor(String nombre, String apellidos, String DNI, String direccion, int telefono, long numss, int salario, Turnos turno, String empresa) {
        super(nombre, apellidos, DNI, direccion, telefono, numss, salario, turno);
        if (turno == Turnos.NOCHE){
            throw new IllegalArgumentException("Reponedor can not have night shift");
        }
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    @Override
    public void setTurno(Turnos t){
        if (t==Turnos.NOCHE){
            throw new IllegalArgumentException("Reponedor can not have night shift");
        }
        super.setTurno(t);
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
        sb.append("Empresa: ");
        sb.append(this.getEmpresa());
        sb.append('\n');        
        return new String(sb);
    }
}
