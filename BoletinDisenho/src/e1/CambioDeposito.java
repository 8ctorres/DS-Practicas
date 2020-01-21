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
public class CambioDeposito implements TiposDeCambio{

    @Override
    public List<EuroCoin> devolverCambio(int pago,List<EuroCoin> deposito, List<EuroCoin> listausuario) {
        deposito.addAll(listausuario);
        deposito.sort(null);
        listausuario.removeAll(listausuario);
        List<EuroCoin> listaux = new LinkedList<>();
        for (Iterator<EuroCoin> it = deposito.iterator(); pago > 0  && it.hasNext();) {
            EuroCoin temp = it.next();
            if (temp.getValor()<=pago){
                pago -= temp.getValor();
                listaux.add(temp);
                it.remove();
            }
        }
        return listaux; //returns a list of every coin that is given back (those coins are eliminated from the deposit)
    }
    
}
