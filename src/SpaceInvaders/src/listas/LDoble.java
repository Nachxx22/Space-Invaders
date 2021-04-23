package SpaceInvaders.src.listas;

import SpaceInvaders.src.enemigos.*;
/**
 * Esta clase crea una lista doble
 * @author grupo 4
 * @version 1.0
 */
public class LDoble {
    private Node cabeza = null;
    private Node cola = null;
    /**
     * Este método inserta un dato al inicio de la lista
     * @param lista
     * @param dato
     * @return
     */
    public static LDoble insertarInicioDato (LDoble lista, IEnemigos dato){
        Node nuevo = new Node(dato);

        if (lista.cabeza == null){
            lista.cabeza = lista.cola = nuevo;
        }
        else {
            lista.cabeza.prevNode = nuevo;
            nuevo.nextNode = lista.cabeza;
            lista.cabeza = lista.cabeza.prevNode;
        }

        return lista;
    }
    /**
     * Este método inserta una cadena al inicio de la lista
     * @param lista
     * @param cadena
     * @return
     */
    public static LDoble insertarInicioCadena (LDoble lista, String cadena){
        Node nuevo = new Node(cadena);

        if (lista.cabeza == null){
            lista.cabeza = lista.cola = nuevo;
        }
        else {
            lista.cabeza.prevNode = nuevo;
            nuevo.nextNode = lista.cabeza;
            lista.cabeza = lista.cabeza.prevNode;
        }

        return lista;
    }
    /**
     * Este método inserta un dato al final de la lista
     * @param lista
     * @param dato
     * @return
     */
    public static LDoble insertarFinalDato (LDoble lista, IEnemigos dato){
        Node nuevo = new Node(dato);

        if (lista.cabeza == null){
            lista.cabeza = lista.cola = nuevo;
        }
        else{
            lista.cola.nextNode = nuevo;
            nuevo.prevNode = lista.cola;
            lista.cola = lista.cola.nextNode;
        }

        return lista;
    }
    /**
     * Este método inserta una cadena al final de la lista
     * @param lista
     * @param cadena
     * @return
     */
    public static LDoble insertarFinalCadena (LDoble lista, String cadena){
        Node nuevo = new Node(cadena);

        if (lista.cabeza == null){
            lista.cabeza = lista.cola = nuevo;
        }
        else{
            lista.cola.nextNode = nuevo;
            nuevo.prevNode = lista.cola;
            lista.cola = lista.cola.nextNode;
        }

        return lista;
    }
    /**
     * Este método devuelve el largo de la lista
     * @param lista
     * @return
     */
    public static int largo (LDoble lista){
        Node temp = lista.cabeza;
        int i = 0;

        while (temp != null){
            i += 1;
            temp = temp.nextNode;
        }

        return i;
    }
    /**
     * Este método busca un posición en la lista
     * @param lista
     * @param pos
     * @return
     */
    private static Node buscarPos (LDoble lista, int pos){
        Node temp = lista.cabeza;
        int i = 0;

        if (pos < 0){
            return null;
        }
        else if (pos >= largo(lista)){
            return null;
        }
        else{
            while (temp != null){
                if (i == pos){
                    return temp;
                }

                i += 1;
                temp = temp.nextNode;
            }
        }

        return null;
    }
    /**
     * Este método inserta un dato en una posición
     * @param lista
     * @param pos
     * @param dato
     * @return
     */
    public static LDoble insertarPosicionDato (LDoble lista, int pos, int dato) {
        Node temp = buscarPos(lista, pos);
        if (temp != null){
            Node nuevo = new Node(dato);
            nuevo.nextNode = temp;
            nuevo.prevNode = temp.prevNode;
            temp.prevNode.nextNode = nuevo;
            temp.prevNode = nuevo;

            return lista;
        }
        else{
            return null;
        }
    }
    /**
     * Este método inserta una cadena en una posición
     * @param lista
     * @param pos
     * @param cadena
     * @return
     */
    public static LDoble insertarPosicionCadena (LDoble lista, int pos, String cadena) {
        Node temp = buscarPos(lista, pos);
        if (temp != null){
            Node nuevo = new Node(cadena);
            nuevo.nextNode = temp;
            nuevo.prevNode = temp.prevNode;
            temp.prevNode.nextNode = nuevo;
            temp.prevNode = nuevo;

            return lista;
        }
        else{
            return null;
        }
    }
    /**
     * Este método busca un dato en la lista
     * @param lista
     * @param dato
     * @return
     */
    private static Node buscarDato (LDoble lista, int dato) {
        Node temp = lista.cabeza;
        while (temp != null){
            if (temp.dato == dato){
                return temp;
            }
            temp = temp.nextNode;
        }

        return null;
    }
    /**
     * Este método busca una cadena en la lista
     * @param lista
     * @param cadena
     * @return
     */
    private static Node buscarCadena (LDoble lista, String cadena) {
        Node temp = lista.cabeza;
        while (temp != null){
            if (temp.cadena == cadena){
                return temp;
            }
            temp = temp.nextNode;
        }

        return null;
    }
    /**
     * Este método borra un dato al inicio de la lista
     * @param lista
     * @return
     */
    public static LDoble borrarInicio (LDoble lista){
        if (lista.cabeza == null){
            return null;
        }
        else{
            Node borrador = lista.cabeza;
            borrador.nextNode.prevNode = null;
            lista.cabeza = borrador.nextNode;
            borrador.nextNode = null;

            return lista;
        }
    }
    /**
     * Este método borra un dato al final de la lista
     * @param lista
     * @return
     */
    public static LDoble borrarFinal (LDoble lista){
        if (lista.cabeza == null){
            return null;
        }
        else if (lista.cabeza == lista.cola){
            lista.cabeza = lista.cola = null;
            return lista;
        }
        else{
            Node borrador = lista.cola.prevNode;

            borrador.nextNode.prevNode = null;
            lista.cola = borrador;
            borrador.nextNode = null;

            return lista;
        }
    }
    /**
     * Este método elimina un método en una posición
     * @param lista
     * @param pos
     * @return
     */
    public static LDoble borrarPos (LDoble lista, int pos){
        if (pos == 0){
            return borrarInicio(lista);
        }
        else if (pos >= largo (lista)){
            return borrarFinal(lista);
        }
        else{
            Node borrador = buscarPos(lista, pos);

            borrador.prevNode.nextNode = borrador.nextNode;
            borrador.nextNode.prevNode = borrador.prevNode;
            borrador.nextNode = null;
            borrador.prevNode = null;

            return lista;
        }
    }
    /**
     * Este método imprime la lista
     * @param lista
     */
    public static void printLista (LDoble lista){
        Node temp = lista.cabeza;

        System.out.println("Lista doble: ");

        while (temp != null) {
            if (temp.cadena != null) {
                System.out.println(temp.cadena + " ");
            } else {
                System.out.println(temp.dato + " ");
            }

            temp = temp.nextNode;
        }
    }
    /**
     * Este método devuelve el largo de la lista
     * @return
     */
    public int lenght(){
        int cont = 0;
        for(Node temp = cabeza; temp != null; temp = temp.getSig()){
            cont ++;
        }
        return cont;
    }
}
