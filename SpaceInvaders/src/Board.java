import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;


public class Board extends JPanel implements  Runnable, MouseListener, MouseMotionListener {


    int coord =0, counter= 0, shooter =0;
    public int [] xS = new int [100];
    public int [] yS = new int [100];
    boolean ingame=true;
    private Dimension d;
    public Ellipse2D [] shot  = new Ellipse2D[100];
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    int x=0;
    BufferedImage img;
    String message="SpaceInvaders";
    private Thread animator;
    Player p;
    public Image nave;
    public Image enemigos;

    public Board(){
        //Para el movimiento del mouse
        //Board.addMouseMotionListener(this);
        addMouseMotionListener(this);

        //Images
        try {
            nave = ImageIO.read(new File("NAVE.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        g = (Graphics2D)g;
        g.setColor(Color.white);
        g.fillRect(0,0,d.width,d.height);

        //represent Player
        g.drawImage(nave,p.x-20,p.y-30,60,60,this);
        //g.setColor(Color.red);
        //g.fillRect(p.x,p.y,20,20);
        if(p.moveRight==true) {
            p.x= coord;
            System.out.println(coord);
        }
        if(p.moveLeft==true) {
            p.x= coord;
        }
        if(coord <465){
            p.x= coord;
        }
        //represent shot
        for(int i =0 ; i< shooter; i++) {
            if (yS[i] >= -14) {
                yS[i] -= 1;
            }
        }
        for (int i = 0; i < shooter; i++){
            shot[i] = new Ellipse2D.Double(xS[i],yS[i],10,15);
            g.setColor(Color.BLACK);
            ((Graphics2D) g).fill(shot[i]);
        }

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


    public void IniShoot (){
        for(int i = 0; i < 100; i++){
            yS[i]= p.y;
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (counter<100){
            xS [shooter] = (int) p.x;
            shooter++;
        }
    }


    @Override
    public void mousePressed (MouseEvent e) {
    int x= e.getX();
    int y = e.getY();
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
        coord =x;






        //System.out.println("moviento");
        //System.out.println(y);
        //System.out.println(x);
    }

    @Override
    public void run() {
        IniShoot();
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

