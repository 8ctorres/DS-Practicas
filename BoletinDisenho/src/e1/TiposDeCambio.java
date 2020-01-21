/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.List;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
interface TiposDeCambio {
    List<EuroCoin> devolverCambio(int pago,List<EuroCoin> deposito,List<EuroCoin> listausuario);
}
