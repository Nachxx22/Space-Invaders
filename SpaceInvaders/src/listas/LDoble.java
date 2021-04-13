package listas;

public class LDoble {
    private Node cabeza = null;
    private Node cola = null;

    public static LDoble insertarInicioDato (LDoble lista, int dato){
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

    public static LDoble insertarFinalDato (LDoble lista, int dato){
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

    public static int largo (LDoble lista){
        Node temp = lista.cabeza;
        int i = 0;

        while (temp != null){
            i += 1;
            temp = temp.nextNode;
        }

        return i;
    }

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
}
