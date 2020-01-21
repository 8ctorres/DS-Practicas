/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

import java.util.HashSet;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
public class EuroCoinCollection {

    private HashSet<EuroCoin> collection = new HashSet<EuroCoin>();

    public boolean insertCoin(EuroCoin coin) {
        return collection.add(coin);
    }

    public boolean hasCoin(EuroCoin coin) {
        return collection.contains(coin);
    }

    public int value() {
        int sum = 0;
        for (Object e : collection) {
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

}
