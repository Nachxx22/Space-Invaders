package enemigos;

/**
 * Esta clase define las caracteristicas del jugador.
 * @author Grupo 4
 * @version 1.0
 *
 */
public class Player extends Character {
    public boolean moveRight;
    public boolean moveLeft;

    public Player(int x, int y , int s){
        /** Este metodo define las variables para controlar la nave.
         *
         *
         */
        super(x,y,s);
        moveLeft=false;
        moveRight=false;

    }
}
