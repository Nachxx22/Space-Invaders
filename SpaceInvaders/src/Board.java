import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Board extends JPanel implements  Runnable, MouseListener, MouseMotionListener {


    int primer=0;
    boolean ingame=true;
    private Dimension d;
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    int x=0;
    BufferedImage img;
    String message="Click Board to Start";
    private Thread animator;
    Player p;

    public Board(){
        //Para el movimiento del mouse
        //Board.addMouseMotionListener(this);
        addMouseMotionListener(this);





        //
        addKeyListener(new Tdapter());
        addMouseListener(this);
        setFocusable(true);
        d=new Dimension(BOARD_WIDTH,BOARD_HEIGHT);
        p=new Player(BOARD_WIDTH/2,BOARD_HEIGHT-60,5);
        setBackground(Color.black);
        if (animator== null || !ingame){
            animator=new Thread(this);
            animator.start();
        }
        setDoubleBuffered(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(0,0,d.width,d.height);

        //represent Player
        g.setColor(Color.red);
        g.fillRect(p.x,p.y,20,20);
        if(p.moveRight==true) {
            p.x=primer;
            System.out.println(primer);
        }
        if(p.moveLeft==true) {
            p.x=primer;
        }
        if(primer<465){
            p.x=primer;
        }


        //


        Font small = new Font("Helvetica",Font.BOLD,14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(message,10,d.height-60);
        if(ingame){
             g.drawImage(img,0,0,200,200 ,null);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    private class Tdapter extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            int key=e.getKeyCode();
            p.moveRight=false;
            p.moveLeft=false;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println( e.getKeyCode());
            // message = "Key Pressed: " + e.getKeyCode();
            int key=e.getKeyCode();

            if(key==39){
                p.moveRight=true;

            }
            if(key==37){
                p.moveLeft=true;
            }
        }
    }








    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    int x= e.getX();
    int y = e.getY();
        System.out.println("click");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("dentro del escenario");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("fuera del escenario");
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x= e.getX();
        int y = e.getY();
        primer=x;






        //System.out.println("moviento");
        //System.out.println(y);
        //System.out.println(x);
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        int animationDelay = 5;
        long time =
                System.currentTimeMillis();
        while (true) {//infinite loop
            //spriteManager.update();
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0,time -
                        System.currentTimeMillis()));
            }catch (InterruptedException e) {
                System.out.println(e);
            }//end catch
        }//end while loop
    }
}
