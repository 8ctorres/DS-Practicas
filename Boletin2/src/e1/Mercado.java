/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 * 
 */
public class Mercado {

    private final Collection<Empleado> SetEmpleados = new HashSet<>();
    private final Collection<Cliente> SetClientes = new HashSet<>();

    public boolean agregarCliente(Cliente cl){
        return SetClientes.add(cl);
    }
    
    public boolean agregarEmpleado(Empleado emp){
        return SetEmpleados.add(emp);
    }
    
    public boolean agregarClientes(Collection<Cliente> clientes){
        return SetClientes.addAll(clientes);
    }
    
    public boolean agregarEmpleados(Collection<? extends Empleado> emps){
        return SetEmpleados.addAll(emps);
    }
    
    public int salariosMercado(){
        int sum = 0;
        for (Empleado e : SetEmpleados){
            sum+=e.getSalario();
        }
        return sum;
    }
    
    public Collection<Persona> personasMercado(){
        Collection<Persona> set = new HashSet<>();
        set.addAll(this.SetClientes);
        set.addAll(this.SetEmpleados);
        return set;
    }
    
}
