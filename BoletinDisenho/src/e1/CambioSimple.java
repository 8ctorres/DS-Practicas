/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author d.s.vega
 * @author carlos.torres
 */
public class CambioSimple implements TiposDeCambio {

    @Override
    public List<EuroCoin> devolverCambio(int pago,List<EuroCoin> deposito, List<EuroCoin> listausuario) {
        List<EuroCoin> listaux = new LinkedList<>();
        for (Iterator<EuroCoin> it = listausuario.iterator(); pago > 0  && it.hasNext();) {
            EuroCoin temp = it.next();
            if (temp.getValor()<=pago) {
                pago -= temp.getValor();
                listaux.add(temp);
                it.remove();
            }
        }
        deposito.addAll(listausuario);
        deposito.sort(null);
        listausuario.removeAll(listausuario); //empties the listausuario
        return listaux; //returns every coin that will be given back to the user
    }
    
}
