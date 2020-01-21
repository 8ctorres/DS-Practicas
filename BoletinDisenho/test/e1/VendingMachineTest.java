package e1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class VendingMachineTest {
    VendingMachine vm = new VendingMachine();
    EuroCoin mon2e = new EuroCoin(200);        
    EuroCoin mon1e = new EuroCoin(100);
    EuroCoin mon50c = new EuroCoin(50);      
    EuroCoin mon20c = new EuroCoin(20);
    EuroCoin mon10c = new EuroCoin(10);
    EuroCoin mon5c = new EuroCoin(5);
    EuroCoin mon2c = new EuroCoin(2);
    EuroCoin mon1c = new EuroCoin(1);
    
    @Before
    public void init() {
        vm.insertProduct("Chocolate", 150);
        vm.insertProduct("Pipas",100);
        vm.insertProduct("Donut", 63);
        vm.insertProduct("Helicoptero de combate de Xiaomi", 1350000);
        vm.insertProduct("Zumo",122);
    }
    
    @Test
    public void simpleCompra1() {
        vm.insertCoin(mon1e);
        vm.insertCoin(mon1e);

        List<EuroCoin> l1 = vm.buy("Chocolate");
        List<EuroCoin> l2 = new LinkedList<>();

        assertEquals(l2,l1);
    }
    
    @Test
    public void simpleCompra2() {
        System.out.println("SCompra2");
        vm.insertCoin(mon1c);
        vm.insertCoin(mon1c);
        vm.insertCoin(mon2c);
        vm.insertCoin(mon50c);
        vm.insertCoin(mon10c);
        System.out.println(vm.listaUsuario.toString());
        List<EuroCoin> l1 = vm.buy("Donut");
        List<EuroCoin> l2 = new LinkedList<>();
        System.out.println(l1.toString());
        l2.add(mon1c);
        assertEquals(l2,l1);     
    }
    
    @Test
    public void simpleCompra3() {
        vm.insertCoin(mon2e);
        vm.insertCoin(mon1e);
        List<EuroCoin> l2 = new LinkedList<>();
        l2.add(mon2e); l2.add(mon1e);
        List<EuroCoin> l1 = vm.buy("Helicoptero de combate");
        assertEquals(l1,l2);
    }
    
    @Test
    public void noHay() {
        vm.insertCoin(mon2e);
        List<EuroCoin> l = new LinkedList<>();
        l.add(mon2e);
        assertEquals(vm.buy("Precioso adosado en Marbella 1200m2 con vistas a la playa"),l);
    }
    
    @Test
    public void depoCompra1() {
        System.out.println("DCompra1");
        vm.setCambio(new CambioDeposito());
        vm.insertCoin(mon2e);
        System.out.println(vm.listaUsuario.toString());
        List<EuroCoin> cambio = vm.buy("Zumo");
        List<EuroCoin> l = new LinkedList<>();
        System.out.println(cambio.toString());
        l.add(mon1c);
        l.add(mon2c);
        l.add(mon5c);
        l.add(mon20c);
        l.add(mon50c);
        l.sort(null);
        assertEquals(l,cambio);
    }
    
    @Test
    public void noMoney(){
        System.out.println("Test noMoney");
        vm.setCambio(new CambioDeposito());
        vm.insertCoin(mon2e);
        vm.insertCoin(mon2e);
        vm.insertCoin(mon1e);
        vm.insertCoin(mon50c);
        List<EuroCoin> vuelta = vm.buy("Helicoptero de combate de Xiaomi");
        List<EuroCoin> expected = new ArrayList<>();
        expected.add(mon2e);
        expected.add(mon2e);
        expected.add(mon1e);
        expected.add(mon50c);
        assertEquals(expected, vuelta);
    }
    
}
