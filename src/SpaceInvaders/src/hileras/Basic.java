/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders.src.hileras; 

import SpaceInvaders.src.listas.*; 
import SpaceInvaders.src.hileras.*;
import SpaceInvaders.src.enemigos.*;

/**
 * Esta clase almacena la hilera básica
 * @author grupo 4
 * @version 1.0
 */
public class Basic {
    LSimple lista;
    public Basic()
    {
        lista = Builder.BuildBasic(1, 0);
    }
}



