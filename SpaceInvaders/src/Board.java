import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import static javax.imageio.ImageIO.read;


public class Board extends JPanel implements  Runnable, MouseListener, MouseMotionListener {


    int coord =0, counter= 0, shooter =0;
    public java.util.List<Integer> Shot; // Shot list
    public java.util.List<Integer> xS; // Coord x (Shot)
    public List<Integer> yS; // Coor y (Shot)
    boolean ingame=true;
    private Dimension d;
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    int x=0;
    BufferedImage img;
    String message="SpaceInvaders";
    String timermessage="Tiempo:";
    String points="Puntaje:";
    int Score=0;
    int Time=0;

    private Thread animator;
    Player p;
    public Image nave;
    public Image enemigos;
    public Image bala;

// Timer

    Timer timer= new Timer(1000,new ActionListener(){
        @Override
    public void actionPerformed(ActionEvent e){
            Time++;
        }
});




    public Board(){
        //Para el movimiento del mouse
        //Board.addMouseMotionListener(this);
        addMouseMotionListener(this);

        //Images
        try {
            nave = ImageIO.read(new File("NAVE.jpeg"));
            bala = ImageIO.read(new File("balas.png"));
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
        if (Shot.size()>0) {
            for (int i = 0; i < Shot.size(); i++) {
                //Just one shoot
                if (Shot.size()>1){
                    if (xS.get(0) == xS.get(i)){
                        xS.remove(i);
                        yS.remove(i);
                        Shot.remove(i);
                    }
                }
                //Speed
                yS.set(i, yS.get(i) - 4);
                //In board
                if (yS.get(i) > -20) {
                    g.drawImage(bala, xS.get(i), yS.get(i), 20, 40, this);

                    //Help Prints
                    System.out.println("XS" + xS.get(i));
                    System.out.println("YS" + yS.get(i));
                    System.out.println("Bala" + p.x);
                }
            }
        }

        Font small = new Font("Helvetica",Font.BOLD,14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(message,10,20);
        g.drawString(timermessage,10,40);g.drawString(String.valueOf(Time)+"s",10,60);
        g.drawString(points,400,20); g.drawString(String.valueOf(Score),400,40);


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
        Shot=new ArrayList<>();
        xS = new ArrayList<>();
        yS = new ArrayList<>();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        Shot.add(counter);
        counter +=1;
        xS.add(p.x);
        yS.add(p.y);

        //Help prints
        System.out.println("XS"+xS.get(0));
        System.out.println("YS"+yS.get(0));
        System.out.println(Shot.size());
        System.out.println(Shot);
        Score++;
        timer.start();
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

