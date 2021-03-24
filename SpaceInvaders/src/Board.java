import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Board extends JPanel implements  Runnable, MouseListener {
    boolean ingame=true;
    private Dimension d;
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    int x=0;
    BufferedImage img;
    String message="Click Board to Start";
    private Thread animator;

    public Board(){
        addKeyListener(new Tdapter());
        addMouseListener(this);
        setFocusable(true);
        d=new Dimension(BOARD_WIDTH,BOARD_HEIGHT);
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
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println( e.getKeyCode());
             message = "Key Pressed: " + e.getKeyCode();
            int key=e.getKeyCode();
            if(key==39){

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
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        int animationDelay = 500;
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
