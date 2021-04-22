package SpaceInvaders.src.listas;

import SpaceInvaders.src.enemigos.*;

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
        enemigo = enemigo;
    }

    public Node getSig() {
        return nextNode;
    }
}