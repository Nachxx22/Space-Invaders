package UI;

import javax.swing.*;
/**
 * Clase para correr el proyecto
 * @author grupo 4
 * @version 1.0
 */

public class Starter extends JFrame {
    public Starter(){
        add(new Board());
        setTitle("SpaceInvaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }
    /**
     * Método principal
     * @param args args
     */
    public static void main(String[] args) {
        new Starter();
    }
}
