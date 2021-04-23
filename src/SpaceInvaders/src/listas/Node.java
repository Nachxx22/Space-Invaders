package SpaceInvaders.src.listas;

import SpaceInvaders.src.enemigos.*;
/**
 * Esta clase se utiliza para crear el nodo de las listas enlazadas
 * @author grupo 4
 * @version 1.0
 */
public class Node {
    int dato;
    String cadena;
    IEnemigos enemigo;
    Node nextNode = null;
    Node prevNode = null;

    public Node(int valor){
        this.dato = valor;
    }

    public Node (String cadena){
        this.cadena = cadena;
    }
    
    public Node(IEnemigos enemigo){
        this.enemigo = enemigo;
    }

    public Node getSig() {
        return nextNode;
    }
}