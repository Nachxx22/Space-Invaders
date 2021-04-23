package SpaceInvaders.src.listas;

import SpaceInvaders.src.enemigos.*;
/**
 * Esta clase crea la lista circular nesesaria para los enemigos
 * @author: grupo 4
 * @version:1.0
 */
public class LCircular {
    private Node cabeza = null;
    private Node cola = null;
    /**
     * Este método se utiliza para insertar un dato a la lista
     * @param lista
     * @param dato
     */
    public static LCircular insertarDato (LCircular lista, IEnemigos dato){
        Node nuevo = new Node(dato);

        if (lista.cabeza == null){
            lista.cabeza = lista.cola = nuevo;
        }
        else {
            lista.cola.nextNode = nuevo;
            nuevo.prevNode = lista.cola;
            lista.cola = lista.cola.nextNode;
            lista.cola.nextNode = lista.cabeza;
            lista.cabeza.prevNode = lista.cola;
        }

        return lista;
    }
    /**
     * Este método se utiliza para insertar una cadena a la lista
     *
     * @param lista
     * @param cadena
     */
    public static LCircular insertarCadena (LCircular lista, String cadena){
        Node nuevo = new Node(cadena);

        if (lista.cabeza == null){
            lista.cabeza = lista.cola = nuevo;
        }
        else {
            lista.cola.nextNode = nuevo;
            nuevo.prevNode = lista.cola;
            lista.cola = lista.cola.nextNode;
            lista.cola.nextNode = lista.cabeza;
            lista.cabeza.prevNode = lista.cola;
        }

        return lista;
    }
    /**
     * Este método se utiliza para buscar un dato en la lista
     * @param lista
     * @param dato
     */
    private static Node buscarDato (LCircular lista, IEnemigos dato){
        Node temp = lista.cabeza;

        if (lista.cabeza == null) {
            return null;
        }
        else{
            do {
                if (temp.enemigo.nombre() == dato.nombre()){
                    return temp;
                }
                temp = temp.nextNode;
            }while(temp != lista.cabeza);

            return null;
        }
    }
    /**
     * Este método se utiliza para buscar una cadena en la lista
     *
     * @param lista
     * @param cadena
     */
    private static Node buscarCadena (LCircular lista, String cadena){
        Node temp = lista.cabeza;

        if (lista.cabeza == null) {
            return null;
        }
        else{
            do {
                if (temp.cadena == cadena){
                    return temp;
                }
                temp = temp.nextNode;
            }while(temp != lista.cabeza);

            return null;
        }
    }
    /**
     * Este método se utiliza para obtener el largo de la lista
     *
     * @param lista
     */
    public static int largo (LCircular lista){
        Node temp = lista.cabeza;
        int i = 0;

        do{
            i += 1;
            temp = temp.nextNode;
        } while (temp != lista.cabeza);

        return i;
    }
    /**
     * Este método se utiliza para buscar la posición de un elemento
     *
     * @param lista
     * @param pos
     */
    public static Node buscarPos (LCircular lista, int pos){
        Node temp = lista.cabeza;
        int i = 0;

        if (pos < 0) {
            return null;
        }
        else if (pos >= largo (lista)){
            return null;
        }
        else{
            do{
                if (i == pos){
                    return temp;
                }

                i += 1;
                temp = temp.nextNode;
            }while (temp != lista.cabeza);
        }

        return null;
    }
    /**
     * Este método se utiliza para borrar una posición de un elemento
     *
     * @param lista
     * @param pos
     */
    public static LCircular borrarPos (LCircular lista, int pos){
        Node temp = buscarPos(lista, pos);

        if (lista.cabeza == lista.cola) {
            lista.cabeza = lista.cola = null;
            return null;
        }
        else if (temp == null){
            return lista;
        }
        else {

            if (temp == lista.cola) {
                lista.cola = temp.prevNode;
            }
            else if (temp == lista.cabeza){
                lista.cabeza= temp.nextNode;
            }
            temp.nextNode.prevNode = temp.prevNode;
            temp.prevNode.nextNode = temp.nextNode;
            temp.nextNode = null;
            temp.prevNode = null;

            return lista;
        }
    }
    /**
     * Este método se utiliza para imprimir la lista
     *
     * @param lista
     */
    public static void printLista (LCircular lista){
        Node temp = lista.cabeza;

        System.out.println("Lista circular: ");

        do{
            if (temp.cadena != null) {
                System.out.println(temp.cadena + " ");
            } else {
                System.out.println(temp.dato + " ");
            }

            temp = temp.nextNode;
        } while (temp != lista.cabeza);
    }
    /**
     * Este método se utiliza para obtener el largo de la lista
     */
    public int lenght() {
        int cantidad = 0;
        Node temp = cabeza;
        if (cabeza == null) {
            return 0;
        } else {
            do {
                cantidad++;
                temp = temp.getSig();
            } while (temp != cabeza);
            return cantidad;
        }
    }
}

