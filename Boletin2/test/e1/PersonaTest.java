/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
public class PersonaTest {
    
    @Test
    public void equalsCli() {
        Cliente cref = new Cliente("Cliente 1", "Informático 1", "00000001A", "Facultad de Informática", 981167001, 1, 0);
        Cliente cnull = null;
        Cliente cide = cref;
        Persona ncli = new Dependiente("Dependiente 1", "ap1 ap2", "10000001A", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        Cliente cequ = new Cliente("Cliente 1", "Informático 1", "00000001A", "Facultad de Informática", 981167001, 1, 0);
        Cliente cneq = new Cliente("Cliente 2", "Informático 2", "00000002B", "Facultad de Informática", 981167001, 2, 0);
        assertTrue(cref.equals(cequ));
        assertTrue(cref.equals(cide));
        assertFalse(cref.equals(cnull));
        assertFalse(cref.equals(ncli));
        assertFalse(cref.equals(cneq));
    }
    
    @Test
    public void equalsDep() {
        Dependiente dref = new Dependiente("Dependiente 1", "ap1 ap2", "10000001A", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        Dependiente dnull = null;
        Dependiente dide = dref;
        Persona ndep = new Cliente("Cliente 2", "Informático 2", "00000002B", "Facultad de Informática", 981167001, 2, 0);
        Dependiente dequ = new Dependiente("Dependiente 1", "ap1 ap2", "10000001A", "Santiago", 981812201, 150000000001l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        Dependiente dneq = new Dependiente("Dependiente 2", "ap1 ap2", "10000001A", "Santiago", 981812201, 150000000002l, 1150, Turnos.MAÑANA, Especialidad.CAJA);
        Persona nss1 = new Reponedor("Reponedor 1", "ap1 ap2", "20000001A", "Monforte", 981871001, 150000000001l, 1000, Turnos.MAÑANA, "Reponedores SL");
        Persona nss2 = dref;
        assertTrue(dref.equals(dequ));
        assertTrue(dref.equals(dide));
        assertFalse(dref.equals(dnull));
        assertFalse(dref.equals(ndep));
        assertFalse(dref.equals(dneq));
        assertFalse(nss2.equals(nss1)); //Lig. Din.
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void idClienteNeg(){
        new Cliente("Cliente 1", "Informático 1", "00000001A", "Facultad de Informática", 981167001, -534, 0);
    }
    
    @Test
    public void testnCompras(){
        Cliente c1 = new Cliente("Cliente 1", "Informático 1", "00000001A", "Facultad de Informática", 981167001, 534, 0);
        c1.incrementarCompras(84);
        assertEquals(c1.getNcompras(),84);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testnComprasIllegal(){
        Cliente c1 = new Cliente("Cliente 1", "Informático 1", "00000001A", "Facultad de Informática", 981167001, 534, 0);
        c1.incrementarCompras(-84);
    }

}
