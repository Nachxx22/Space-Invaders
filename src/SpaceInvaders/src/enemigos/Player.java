package SpaceInvaders.src.enemigos;

public class Player extends  Character{
    public boolean moveRight;
    public boolean moveLeft;

    public Player(int x, int y , int s){
        super(x,y,s);
        moveLeft=false;
        moveRight=false;

    }
}
