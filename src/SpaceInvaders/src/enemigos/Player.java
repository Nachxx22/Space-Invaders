package SpaceInvaders.src.enemigos;

/**
 * Esta clase define las caracteristicas del jugador.
 * @author Grupo 4
 * @version 1.0
 *
 */
public class Player extends  Character{
    public boolean moveRight;
    public boolean moveLeft;
    /**
     * Método constructor
     * @param x posicion
     * @param y posicion
     * @param s velocidad
     */
    public Player(int x, int y , int s){
        super(x,y,s);
        moveLeft=false;
        moveRight=false;

    }
}
