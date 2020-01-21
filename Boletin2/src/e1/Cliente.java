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
public class Cliente extends Persona{
    private final int idCliente;
    private int n_compras;
    
    public Cliente(String nombre, String apellidos, String DNI, String direccion, int telefono, int idCliente, int n_compras){
        super(nombre,apellidos,DNI,direccion,telefono);
        
        if (idCliente>0)
            this.idCliente = idCliente;
        else
            throw new IllegalArgumentException("id Cliente");

        this.n_compras = n_compras;
    }

    public int getNcompras() {
        return n_compras;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
    public void incrementarCompras(int compras){
        if (compras>0) {
            this.n_compras += compras;
        }
        else throw new IllegalArgumentException("incrementar compras");
    }


    public int obtenerDescuento() {
        return this.n_compras <= 10000 ? this.n_compras / 100 : 100;
    }

    @Override
    public int hashCode() {
        return idCliente;
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
        final Cliente other = (Cliente) obj;
        return this.idCliente == other.idCliente;
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
        sb.append("Número de compras: ");
        sb.append(this.getNcompras());
        sb.append('\n');
        sb.append("ID Cliente: ");
        sb.append(this.getIdCliente());
        sb.append('\n');
        return new String(sb);
    }
    
    
}
