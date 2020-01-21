/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class IteradorMoneda implements Iterator<EuroCoin> {
    
    private final Iterator<EuroCoin> it;
    private final Countries pais;
    private EuroCoin nextelem;
    private boolean checked, prev;
    
    IteradorMoneda (EuroCoinCollection ecol, Countries pais) {
        this.it = ecol.collection.iterator();
        this.pais = pais;
    }
    
    @Override
    public boolean hasNext() {
        if (pais == null) return it.hasNext();
        if (checked == false) {
            checked = true;
        }
        else return prev;
        while (it.hasNext()){
            nextelem = it.next();
            if (nextelem.getPais() == this.pais)
                return (prev = true);
        }
        return (prev = false);
    }

    @Override
    public EuroCoin next() {
        if (pais == null) return it.next();
        if (!checked) hasNext();
        if (!prev) throw new NoSuchElementException();
        checked = false;
        return nextelem;
    }

    @Override
    public void remove() {
        it.remove();
    }
    
}
