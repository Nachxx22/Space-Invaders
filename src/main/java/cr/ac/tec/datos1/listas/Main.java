package cr.ac.tec.datos1.listas;

public class Main {
    public static void main(String[] args) {
        /*

        LSimple ejemplo = new LSimple();

        ejemplo = LSimple.insertarFinalCadena(ejemplo, "hola");
        ejemplo = LSimple.insertarFinalCadena(ejemplo, "como esta?");
        ejemplo = LSimple.insertarFinalDato(ejemplo, 2);

        ejemplo = LSimple.insertarInicioDato(ejemplo, 23);
        ejemplo = LSimple.insertarInicioCadena(ejemplo, "diay");

        ejemplo = LSimple.borrarInicio(ejemplo);
        ejemplo = LSimple.borrarFinal(ejemplo);

        ejemplo.printLista(ejemplo);

        LDoble eje2 = new LDoble();

        eje2 = LDoble.insertarFinalDato(eje2,66);
        eje2 = LDoble.insertarFinalCadena(eje2, "what's up");
        eje2 = LDoble.insertarFinalDato(eje2, 1234);
        eje2 = LDoble.insertarFinalCadena(eje2, "gday");

        eje2 = LDoble.insertarInicioDato(eje2,33);
        eje2 = LDoble.insertarInicioCadena(eje2,"howdy?");
        eje2 = LDoble.insertarInicioDato(eje2,4321);
        eje2 = LDoble.insertarInicioCadena(eje2,"good morning");

        eje2 = LDoble.insertarPosicionCadena(eje2,3,"suction");

        eje2 = LDoble.borrarInicio(eje2);
        eje2 = LDoble.borrarFinal(eje2);
        eje2 = LDoble.borrarPos(eje2, 2);

        //Node prueba = LDoble.buscarDato(eje2,66);

        eje2.printLista(eje2);

        //System.out.println(prueba);

        int largo = LDoble.largo(eje2);

        System.out.println(largo);


         */

        LCircular circ = new LCircular();

        circ = LCircular.insertarCadena(circ, "bonjour");
        circ = LCircular.insertarDato(circ, 1799);
        circ = LCircular.insertarCadena(circ, "bon soir");
        circ = LCircular.insertarDato(circ, 1984);
        circ = LCircular.insertarDato(circ, 1812);
        circ = LCircular.insertarCadena(circ, "ca ira");

        circ = LCircular.borrarPos(circ,5);


        circ.printLista(circ);

        //Node prueba = LCircular.buscarDato(circ,1788);
        //System.out.println(prueba);

        //Node prueba = LCircular.buscarPos(circ, 1);
        //System.out.println(prueba.dato);

    }
}
