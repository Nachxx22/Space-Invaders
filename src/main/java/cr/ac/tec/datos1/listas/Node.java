package cr.ac.tec.datos1.listas;


public class Node {
    int dato;
    String cadena;
    Node nextNode = null;
    Node prevNode = null;

    public Node(int valor){
        this.dato = valor;
    }

    public Node (String cadena){
        this.cadena = cadena;
    }
}