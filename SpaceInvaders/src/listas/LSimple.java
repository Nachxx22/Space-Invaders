package listas;

public class LSimple {
    private Node cabeza = null;
    private Node cola = null;

    public static LSimple insertarInicioDato(LSimple lista, int dato){
        Node nuevo = new Node(dato);

        if (lista.cabeza == null){
            lista.cabeza = nuevo;
        }
        else{
            nuevo.nextNode = lista.cabeza;
            lista.cabeza = nuevo;
        }

        return lista;
    }

    public static LSimple insertarInicioCadena (LSimple lista, String cadena){
        Node nuevo = new Node(cadena);

        if (lista.cabeza == null){
            lista.cabeza = nuevo;
        }
        else{
            nuevo.nextNode = lista.cabeza;
            lista.cabeza = nuevo;
        }

        return lista;
    }

    public static LSimple insertarFinalDato (LSimple lista, int dato){
        Node nuevo = new Node(dato);

        if (lista.cabeza == null){
            lista.cabeza = nuevo;
        }
        else{
            Node ultimo = lista.cabeza;
            while (ultimo.nextNode != null){
                ultimo = ultimo.nextNode;
            }

            ultimo.nextNode = nuevo;
        }

        return lista;
    }

    public static LSimple insertarFinalCadena (LSimple lista, String cadena){
        Node nuevo = new Node(cadena);

        if (lista.cabeza == null){
            lista.cabeza = nuevo;
        }

        else{
            Node ultimo = lista.cabeza;
            while (ultimo.nextNode != null){
                ultimo = ultimo.nextNode;
            }

            ultimo.nextNode = nuevo;
        }

        return lista;
    }

    public static LSimple borrarInicio (LSimple lista){
        if (lista.cabeza == null){
            return null;
        }
        else{
            Node borrador = lista.cabeza;
            lista.cabeza = lista.cabeza.nextNode;
            borrador.nextNode = null;
        }

        return lista;
    }

    public static LSimple borrarFinal (LSimple lista){
        if (lista.cabeza == null){
            return null;
        }
        else if (lista.cabeza == lista.cola){
            lista.cabeza = lista.cola = null;
            return lista;
        }
        else{
            Node ultimo = lista.cabeza;
            while (ultimo.nextNode.nextNode != null){
                ultimo = ultimo.nextNode;
            }

            lista.cola = ultimo;
            ultimo = ultimo.nextNode;
            lista.cola.nextNode = null;

            return lista;
        }
    }

    public static void printLista (LSimple lista){
        Node temp = lista.cabeza;

        System.out.println("Lista simple: ");

        while (temp != null){
            if (temp.cadena != null){
                System.out.println(temp.cadena + " ");
            }
            else {
                System.out.println(temp.dato + " ");
            }

            temp = temp.nextNode;
        }
    }

}
