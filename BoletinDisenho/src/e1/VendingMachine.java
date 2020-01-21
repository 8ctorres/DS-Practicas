/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 * 
 */
public class VendingMachine {
    List<EuroCoin> listaUsuario = new LinkedList<>();
    List<EuroCoin> deposito = new LinkedList<>();
    Map<String, Integer> mapaProd = new HashMap<>();
    TiposDeCambio cambio = new CambioSimple();
    
    public VendingMachine(){
        //empieza con 50 monedas de cada tipo en el deposito para suponer que siempre hay cambio
        for(int i = 0; i<50; i++){
            deposito.add(new EuroCoin(200));
            deposito.add(new EuroCoin(100));
            deposito.add(new EuroCoin(50));
            deposito.add(new EuroCoin(20));
            deposito.add(new EuroCoin(10));
            deposito.add(new EuroCoin(5));
            deposito.add(new EuroCoin(2));
            deposito.add(new EuroCoin(1));
        }
        deposito.sort(null);
    }
    
    void setCambio(TiposDeCambio cambio) {
        this.cambio = cambio;
    }
        
    void insertProduct(String product, int price){
        mapaProd.put(product, price);
    }
    
    void insertCoin(EuroCoin e){
        listaUsuario.add(e);
        listaUsuario.sort(null);
    }
    
    List<EuroCoin> cancel(){
        List<EuroCoin> listaux = new LinkedList<>(listaUsuario);
        listaUsuario.removeAll(listaUsuario);
        return listaux;
    }
    
    //Cambios UML: Buy returns lista // Faltan listas auxiliares //CambioSimple
    List<EuroCoin>  buy(String product){
        if (mapaProd.containsKey(product)){
            int precio = mapaProd.get(product);
            int credito = 0;
            for(EuroCoin e: listaUsuario){
                credito += e.getValor();
            }
            if (credito>=precio) {
                List<EuroCoin> c = cambio.devolverCambio(credito - precio,deposito,listaUsuario);
                deposito.sort(null);
                return c;
            }
            else{
                System.out.println("Not enough credit");
                return cancel();
            }     
        }
        else{
            System.out.println("Product not in stock");
            return cancel();
        }
    }

}
