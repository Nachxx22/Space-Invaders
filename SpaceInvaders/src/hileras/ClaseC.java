/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.tec.datos1.hileras;

import cr.ac.tec.datos1.listas.LCircular;
import cr.ac.tec.datos1.listas.LDoble;

/**
 *
 * @author 50684
 */
public class ClaseC {
    LCircular lista;

    public ClaseC()
    {
        lista = Builder.BuildClaseC(1, 0);
    }
}