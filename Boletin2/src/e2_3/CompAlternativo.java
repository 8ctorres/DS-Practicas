/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_3;

import java.util.Comparator;

/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class CompAlternativo implements Comparator<EuroCoin> {

   @Override
   public int compare(EuroCoin mo1, EuroCoin mo2) {
        int temp;
        temp = mo1.getPais().toString().compareTo(mo2.getPais().toString());
        if (temp!=0) return temp;
        temp = mo2.getValor() - mo1.getValor();
        if (temp!=0) return temp;
        temp = mo1.getAño() - mo2.getAño();
        return temp;
    }
}
