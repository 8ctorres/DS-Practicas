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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MercadoTest {
    private Mercado merc;
    private Cliente c1,c2,c3,c4,c5;
    private Dependiente dep1, dep2, dep3, dep4, dep5;
    private Reponedor r1,r2,r3,r4,r5;
    
    @Before
    public void setUp(){
        merc = new Mercado();
        c1 = new Cliente("Cliente 1", "Informático 1", "00000001A", "Facultad de Informática", 981167001, 1, 0);
        c2 = new Cliente("Cliente 2", "Abogado 2", "00000002B", "Facultad de Derecho", 981167002, 2, 10001);
        c3 = new Cliente("Cliente 3", "Economista 3", "00000003C", "Facultad de Económicas", 981167003, 3, 100);
        c4 = new Cliente("Cliente 4", "Arquitecto 4", "00000004D", "Facultad de Arquitectura", 981167004, 4, 200);
        c5 = new Cliente("Cliente 5", "Químico 5", "00000005E", "Facultad de Ciencias", 981167005, 5, 500);
        
        dep1 = new Dependiente("Dependiente 1", "ap1 ap2", "10000001A", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        dep2 = new Dependiente("Dependiente 2", "ap1 ap2", "10000002B", "Ourense", 981812201, 150000000002l, 1200, Turnos.TARDE, Especialidad.CARNICERIA);
        dep3 = new Dependiente("Dependiente 3", "ap1 ap2", "10000003C", "Lugo", 981812201, 150000000003l, 1800, Turnos.NOCHE, Especialidad.CHARCUTERIA);
        dep4 = new Dependiente("Dependiente 4", "ap1 ap2", "10000004D", "Vigo", 981812201, 150000000004l, 2100, Turnos.TARDE, Especialidad.FRUTERIA);
        dep5 = new Dependiente("Dependiente 5", "ap1 ap2", "10000005E", "Pontevedra", 981812201, 150000000005l, 900, Turnos.MAÑANA, Especialidad.PANADERIA);

        r1 = new Reponedor("Reponedor 1", "ap1 ap2", "20000001A", "Monforte", 981871001, 160000000001l, 1000, Turnos.MAÑANA, "Reponedores SL");
        r2 = new Reponedor("Reponedor 2", "ap1 ap2", "20000002B", "Ribeira", 981871002, 160000000002l, 900, Turnos.TARDE, "Reponedores 2 SL");
        r3 = new Reponedor("Reponedor 3", "ap1 ap2", "20000003C", "Puebla", 981871003, 160000000003l, 1000, Turnos.MAÑANA, "Reponedores 3 SL");
        r4 = new Reponedor("Reponedor 4", "ap1 ap2", "20000004D", "Boiro", 981871004, 160000000004l, 750, Turnos.TARDE, "Reponedores 4 SL");
        r5 = new Reponedor("Reponedor 5", "ap1 ap2", "20000005E", "Rianxo", 981871005, 160000000005l, 1100, Turnos.MAÑANA, "Reponedores 5 SL");

        merc.agregarCliente(c1);
        merc.agregarCliente(c2);
        merc.agregarEmpleado(dep1);
        merc.agregarEmpleado(dep2);
        merc.agregarEmpleado(r1);
        merc.agregarEmpleado(r2);
        merc.agregarEmpleado(r2);
    }
    
    
    
    @Test
    public void testSalario() {
        assertEquals(1150,dep1.getSalario());
        assertEquals(1950,dep3.getSalario());
        assertEquals(2100,dep4.getSalario());
        assertEquals(1000,r1.getSalario());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testTurno() {
        r1.setTurno(Turnos.NOCHE);
    }

    @Test
    public void testDescuentos() {
        assertEquals(0,c1.obtenerDescuento());
        assertEquals(100,c2.obtenerDescuento());
        assertEquals(5,c5.obtenerDescuento());
    }

    @Test
    public void hashSetComparison() {
        merc.agregarCliente(c3);
        HashSet<Persona> test = new HashSet<>();
        test.add(c1);
        test.add(c2);
        test.add(c3);  
        test.add(dep1);
        test.add(dep2);
        test.add(r1);
        test.add(r2); 
        test.add(r2);     
        assertEquals(test,merc.personasMercado());
    }

    @Test
    public void allSalary() {
        assertEquals(4250,merc.salariosMercado());
    }


    @Test
    public void testAdds(){
        HashSet<Empleado> tpemp = new HashSet();
        Empleado te1 = new Dependiente("Dependiente 10", "ap1 ap2", "10000001A", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        Dependiente te2 = new Dependiente("Dependiente 20", "ap1 ap2", "10000001B", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        tpemp.add(te1);
        tpemp.add(te2);
        merc.agregarEmpleados(tpemp);
        //
        HashSet<Dependiente> tpdep = new HashSet();
        Dependiente td1 = new Dependiente("Dependiente 30", "ap1 ap2", "10000001D", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);        
        tpdep.add(td1);
        merc.agregarEmpleados(tpdep);
        //
        HashSet<Reponedor> tprep = new HashSet();
        Reponedor tr1 = new Reponedor("Dependiente 40", "ap1 ap2", "10000001D", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA,"RG S.A.");
        tprep.add(tr1);
        merc.agregarEmpleados(tprep);
        //
        HashSet<Cliente> tpcli = new HashSet();
        Cliente tc1 = new Cliente("Cliente X", "Desempleado", "00000001J", "Facultad de Informática", 981167001, 10, 0);
        tpcli.add(tc1);
        merc.agregarClientes(tpcli);
        //
        assertFalse(merc.agregarCliente(tc1));
        Collection<Persona> HSP = merc.personasMercado();
        assertTrue(HSP.contains(te1) && HSP.contains(td1) && HSP.contains(tc1));
    }
    
    @Test
    public void testToString() {
        Collection<? super Persona> HSP = merc.personasMercado();
        HashSet<String> HSS = new HashSet();
        for (Iterator<? super Persona> it = HSP.iterator(); it.hasNext();) {
            HSS.add(it.next().toString());
        }
        assertTrue(HSS.contains(c1.toString()) && HSS.contains(r1.toString()) && HSS.contains(dep1.toString()));     
    }
    
    @Test
    public void containsAndEqualTest() {
        Collection<? super Persona> HSP = merc.personasMercado();
        Cliente cx = new Cliente("Cliente X", "Desempleado", "30300501J", "Facultad de Informática", 981167001, 30, 0);
        Object o = new Object();
        assertFalse(HSP.contains(null));
        assertFalse(HSP.contains(o));
        assertFalse(HSP.contains(cx));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void nightShift() {
        new Reponedor("N","A","00011122J","WP",666666666, 150000000001l, 1150, Turnos.NOCHE,"E");
    }
    
    @Test
    public void gettersAndSetters(){        
        assertEquals(Especialidad.CAJA, dep1.getEspecialidad());
        dep1.setEspecialidad(Especialidad.PESCADERIA);
        assertEquals(Especialidad.PESCADERIA, dep1.getEspecialidad());
        assertEquals(r1.getNumss(),160000000001l);
        r1.setNumss(170000000001l);
        assertEquals(r1.getNumss(),170000000001l);
        r2.setTurno(Turnos.MAÑANA);
        assertEquals(Turnos.MAÑANA, r2.getTurno());
        r3.setSalario(4987);
        assertEquals(4987,r3.getSalario());
        dep2.setDireccion("Ronda de Outeiro, 123");
        assertEquals("Ronda de Outeiro, 123", dep2.getDireccion());
        r4.setEmpresa("Inditex");
        assertEquals("Inditex", r4.getEmpresa());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void illegalTlf(){
        dep3.setTelefono(24);
        dep3.setTelefono(1999999999);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void illegalTlf2(){
        dep3.setTelefono(1999999999);
    }

}
