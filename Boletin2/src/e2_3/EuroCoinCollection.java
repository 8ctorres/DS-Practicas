/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
public class EuroCoinCollection implements Iterable<EuroCoin>{

    protected final List<EuroCoin> collection = new LinkedList<>();
    private Countries pais_iter = null;

    public boolean insertCoin(EuroCoin coin) {
        return collection.add(coin);
    }

    public boolean hasCoin(EuroCoin coin) {
        return collection.contains(coin);
    }

    public int value() {
        int sum = 0;
        for (EuroCoin e : collection) {
            sum += ((EuroCoin) e).getValor();
        }
        return sum;
    }

    public int numCoins() {
        return collection.size();
    }

    public boolean removeCoin(EuroCoin coin) {
        return collection.remove(coin);
    }
    
    public void setIterationCountry(Countries a) {
        this.pais_iter = a;
    }
    
    //Método de la interfaz Iterable<T> que devuelve un iterador sobre esa coleccion
    public void sort(Comparator<EuroCoin> c) {
        collection.sort(c);
    }
    
    @Override
    public Iterator<EuroCoin> iterator() {
        return new IteradorMoneda(this, pais_iter);
    }
}
