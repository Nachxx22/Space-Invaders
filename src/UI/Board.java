package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import listas.*;
import hileras.*;
import enemigos.*;

import static javax.imageio.ImageIO.read;

/**
 * La clase board define toda la interfaz
 * @author Grupo 4
 * @version 3.0
 */
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
    int round = 1;int dificultad=0;
    int cantidadDeEnemigos;
    
    BufferedImage img;
    String message="SpaceInvaders";
    String timermessage="Tiempo:";
    String points="Puntaje:";
    int Score=0;
    int Time=0;int minutos=0;
    double HileraY = 0;

    private Thread animator;
    Player p;
    public Image naveImage;
    public Image enemigosImage;
    public Image jefeImage;
    public Image balaImage;

    LSimple listaTemporal = Builder.BuildBasic(1,0);
    LSimple listaTemporal2 = Builder.BuildClaseA(1,0);
    LDoble listaTemporal3 = Builder.BuildClaseB(1,0);
    LCircular listaTemporal4 = Builder.BuildClaseC(1,0);
    LCircular listaTemporal5 = Builder.BuildClaseD(1);
    LCircular listaTemporal6 = Builder.BuildClaseE(1);

    LSimple listaBasic = Builder.BuildBasic(1,0);

    // Timer
    /**
     *
     *  Cuando este metodo se inicia se empieza a contar cada 1s y se suma como segundos, con el nombre de time
     *  Cuando el time es mayor, time regresa a valer 0 para comenzar desde cero la cuenta y se suma 1 a los minutos
     *
     * */
    Timer timer= new Timer(1000,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if (Time<60){
                Time++;
            }
            if(Time==60){
                Time = 0;
                minutos++;
            } }});

    public Board(){
        /**
         * En este metodo se definen las imagenes
         */

        //Para el movimiento del mouse
        //Board.addMouseMotionListener(this);
        addMouseMotionListener(this);

        //Images
        try 
        {
            naveImage = ImageIO.read(new File("NAVE.jpeg"));
            balaImage = ImageIO.read(new File("balas.png"));
            enemigosImage = ImageIO.read(new File("alien.png"));
            jefeImage = ImageIO.read(new File("Boss.png"));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        //
        addKeyListener(new Tdapter());
        addMouseListener(this);
        setFocusable(true);
        
        d = new Dimension(BOARD_WIDTH,BOARD_HEIGHT);
        p = new Player(BOARD_WIDTH/2,BOARD_HEIGHT-60,5);
        setBackground(Color.black);
        
        if (animator== null || !ingame){
            animator = new Thread(this);
            animator.start();
        }
        
        setDoubleBuffered(true);
    }

    Integer currentShoty = 0, currentShotX = 0;
    boolean golpeoEnemigo = false;

    /**
     * El metodo paint se encarga de dibujar en la interfaz
     * @param g graficas
     */
    public void paint(Graphics g){
        super.paint(g);
        
        g = (Graphics2D)g;
        g.setColor(Color.white);
        g.fillRect(0,0,d.width,d.height);

        //represent Player
        g.drawImage(naveImage, p.x-20, p.y-30, 60, 60, this);
        
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
 
        int cantidadDeEnemigos = 0;
        int distanceX = 125;

        if (round == 0 || round == 1) {
        	for (int i = 0; i < listaTemporal.lenght(); i++) 
            {
            	IEnemigos enemigoX = listaTemporal.seleccionarEnemigoEnPosicion(i);
       
                enemigoX.setCoordenadas(distanceX, (int)Math.floor(HileraY)); 
                
                Image imageToUse = enemigoX.nombre().contains("Jefe") ? jefeImage : enemigosImage;
                
                int eX = enemigoX.X();
                int eY = enemigoX.Y();
                
                if(currentShotX > (eX - 15) && currentShotX < (eX + 15) && 
        		   currentShoty > (eY - 15) && currentShoty < (eY + 15))
                { 
                	if(!golpeoEnemigo)
                	{ 
                        Score++;
                    	enemigoX.bajarVida(); 

                        if(enemigoX.nombre().contains("Jefe") && enemigoX.hitPoints() == 0)
                        {
                        	cantidadDeEnemigos = 0;
                        	for (int x = 0; x < listaTemporal.lenght(); x++) 
                            { 
                            	IEnemigos enemigo2 = listaTemporal.seleccionarEnemigoEnPosicion(x);    
                            	enemigo2.bajarVida();
                            }
                        }
                    	
                	}
                	
                	golpeoEnemigo = true;
                }
                else { 
                    PrintBala(g); 
                }
            	
                if (enemigoX.nombre().contains("Jefe")) {
                	System.out.println("BossHP " + enemigoX.hitPoints());
    			}
                
                if(enemigoX.hitPoints() > 0)
                {
                	cantidadDeEnemigos ++;
                    g.drawImage(
                    		imageToUse,
                    		distanceX,
                    		(int)Math.floor(HileraY) + enemigoX.velocidad(),
                    		30,
                    		30,
                    		this);
                }
                distanceX += 40;
                 
            }
     
            HileraY += 0.1;
            
            if(cantidadDeEnemigos == 0)
            {
                listaTemporal=Builder.BuildClaseA(1,0);
                listaTemporal2 = Builder.BuildClaseA(1,0);
                listaTemporal3 = Builder.BuildClaseB(1,0);
                 listaTemporal4 = Builder.BuildClaseC(1,0);
                HileraY = 0;
                round=(int) (Math.random()*6);;
            }
		}

        ///////////////////////////////////////////

        if(round == 2)
        {
    		int posJefe = (int)Math.ceil((Math.random() * 7));
    		int posJefeNormal = 0;
        	IEnemigos[] enemigosArr = new IEnemigos[7];
    		 
        	for (int i = 0; i < listaTemporal.lenght(); i++)
            {
            	IEnemigos enemigoX = listaTemporal.seleccionarEnemigoEnPosicion(i);
				enemigosArr[i] = enemigoX;
				
				if(enemigoX.nombre().contains("Jefe"))
				{
					posJefeNormal = i;
				}
            }

        	IEnemigos NTemp = enemigosArr[posJefe];
        	IEnemigos JTemp = enemigosArr[posJefeNormal];

    		enemigosArr[posJefe] = JTemp;
    		enemigosArr[posJefeNormal] = NTemp;
        	
    		
        	for (int i = 0; i < listaTemporal.lenght(); i++)
            {  	  
            	IEnemigos enemigoX = enemigosArr[i];
       
                enemigoX.setCoordenadas(distanceX, (int)Math.floor(HileraY)); 
                
                Image imageToUse = enemigoX.nombre().contains("Jefe") ? jefeImage : enemigosImage;
                
                int eX = enemigoX.X();
                int eY = enemigoX.Y();
                
                if(currentShotX > (eX - 15) && currentShotX < (eX + 15) && 
        		   currentShoty > (eY - 15) && currentShoty < (eY + 15))
                { 
                	if(!golpeoEnemigo)
                	{ 
                        Score++;
                    	enemigoX.bajarVida(); 

                        if(enemigoX.nombre().contains("Jefe") && enemigoX.hitPoints() == 0)
                        {
                        	cantidadDeEnemigos = 0;
                        	for (int x = 0; x < listaTemporal.lenght(); x++) 
                            { 
                            	IEnemigos enemigo2 = listaTemporal.seleccionarEnemigoEnPosicion(x);    
                            	enemigo2.bajarVida();
                            }
                        }
                	}
                	
                	golpeoEnemigo = true;
                }
                else { 
                    PrintBala(g); 
                }
            	
                if (enemigoX.nombre().contains("Jefe")) {
                	System.out.println("BossHP " + enemigoX.hitPoints());
    			}
                
                if(enemigoX.hitPoints() > 0)
                {
                	cantidadDeEnemigos ++;
                    g.drawImage(
                    		imageToUse,
                    		distanceX,
                    		(int)Math.floor(HileraY) + enemigoX.velocidad(),
                    		30,
                    		30,
                    		this);
                    
                }

                distanceX += 40;
            }
     
            HileraY += 0.1;
            
            if(cantidadDeEnemigos == 0)
            {
                listaTemporal=Builder.BuildClaseA(1,0);
                listaTemporal2 = Builder.BuildClaseA(1,0);
                listaTemporal3 = Builder.BuildClaseB(1,0);
                listaTemporal4 = Builder.BuildClaseC(1,0);
            	HileraY = 0;  
            	round=(int) (Math.random()*6);;
            }
        }
        if(round==3){
            int posJefe = (int)Math.ceil((Math.random() * 7));
            int posJefeNormal = 0;
            IEnemigos[] enemigosArr = new IEnemigos[7];

            for (int i = 0; i < listaTemporal2.lenght(); i++)
            {
                IEnemigos enemigoX = listaTemporal2.seleccionarEnemigoEnPosicion(i);
                enemigosArr[i] = enemigoX;

                if(enemigoX.nombre().contains("Jefe"))
                {
                    posJefeNormal = i;
                }
            }

            IEnemigos NTemp = enemigosArr[posJefe];
            IEnemigos JTemp = enemigosArr[posJefeNormal];

            enemigosArr[posJefe] = JTemp;
            enemigosArr[posJefeNormal] = NTemp;


            for (int i = 0; i < listaTemporal2.lenght(); i++)
            {
                IEnemigos enemigoX = enemigosArr[i];

                enemigoX.setCoordenadas(distanceX, (int)Math.floor(HileraY));

                Image imageToUse = enemigoX.nombre().contains("Jefe") ? jefeImage : enemigosImage;

                int eX = enemigoX.X();
                int eY = enemigoX.Y();

                if(currentShotX > (eX - 15) && currentShotX < (eX + 15) &&
                        currentShoty > (eY - 15) && currentShoty < (eY + 15))
                {
                    if(!golpeoEnemigo)
                    {
                        Score++;
                        enemigoX.bajarVida();

                        if(enemigoX.nombre().contains("Jefe") && enemigoX.hitPoints() == 0)
                        {
                            cantidadDeEnemigos = 0;
                            for (int x = 0; x < listaTemporal2.lenght(); x++)
                            {
                                IEnemigos enemigo2 = listaTemporal2.seleccionarEnemigoEnPosicion(x);
                                enemigo2.bajarVida();
                            }
                        }
                    }

                    golpeoEnemigo = true;
                }
                else {
                    PrintBala(g);
                }

                if (enemigoX.nombre().contains("Jefe")) {
                    System.out.println("BossHP " + enemigoX.hitPoints());
                }

                if(enemigoX.hitPoints() > 0)
                {
                    cantidadDeEnemigos ++;
                    g.drawImage(
                            imageToUse,
                            distanceX,
                            (int)Math.floor(HileraY) + enemigoX.velocidad(),
                            30,
                            30,
                            this);

                }

                distanceX += 40;
            }

            HileraY += 0.1;

            if(cantidadDeEnemigos == 0)
            {
                listaTemporal=Builder.BuildClaseA(1,0);
                listaTemporal2 = Builder.BuildClaseA(1,0);
                listaTemporal3 = Builder.BuildClaseB(1,0);
                listaTemporal4 = Builder.BuildClaseC(1,0);
                HileraY = 0;
                round=(int) (Math.random()*6);;
            }
        }
        if(round==4){
            int posJefe = (int)Math.ceil((Math.random() * 7));
            int posJefeNormal = 0;
            IEnemigos[] enemigosArr = new IEnemigos[7];

            for (int i = 0; i < listaTemporal3.lenght(); i++)
            {
                IEnemigos enemigoX = listaTemporal3.seleccionarEnemigoEnPosicion(i);
                enemigosArr[i] = enemigoX;

                if(enemigoX.nombre().contains("Jefe"))
                {
                    posJefeNormal = i;
                }
            }

            IEnemigos NTemp = enemigosArr[posJefe];
            IEnemigos JTemp = enemigosArr[posJefeNormal];

            enemigosArr[posJefe] = JTemp;
            enemigosArr[posJefeNormal] = NTemp;


            for (int i = 0; i < listaTemporal3.lenght(); i++)
            {
                IEnemigos enemigoX = enemigosArr[i];

                enemigoX.setCoordenadas(distanceX, (int)Math.floor(HileraY));

                Image imageToUse = enemigoX.nombre().contains("Jefe") ? jefeImage : enemigosImage;

                int eX = enemigoX.X();
                int eY = enemigoX.Y();

                if(currentShotX > (eX - 15) && currentShotX < (eX + 15) &&
                        currentShoty > (eY - 15) && currentShoty < (eY + 15))
                {
                    if(!golpeoEnemigo)
                    {
                        Score++;
                        enemigoX.bajarVida();

                        if(enemigoX.nombre().contains("Jefe") && enemigoX.hitPoints() == 0)
                        {
                            cantidadDeEnemigos = 0;
                            for (int x = 0; x < listaTemporal3.lenght(); x++)
                            {
                                IEnemigos enemigo2 = listaTemporal3.seleccionarEnemigoEnPosicion(x);
                                enemigo2.bajarVida();
                            }
                        }
                    }

                    golpeoEnemigo = true;
                }
                else {
                    PrintBala(g);
                }

                if (enemigoX.nombre().contains("Jefe")) {
                    System.out.println("BossHP " + enemigoX.hitPoints());
                }

                if(enemigoX.hitPoints() > 0)
                {
                    cantidadDeEnemigos ++;
                    g.drawImage(
                            imageToUse,
                            distanceX,
                            (int)Math.floor(HileraY) + enemigoX.velocidad(),
                            30,
                            30,
                            this);

                }

                distanceX += 40;
            }

            HileraY += 0.1;

            if(cantidadDeEnemigos == 0)
            {
                listaTemporal=Builder.BuildClaseA(1,0);
                listaTemporal2 = Builder.BuildClaseA(1,0);
                listaTemporal3 = Builder.BuildClaseB(1,0);
                listaTemporal4 = Builder.BuildClaseC(1,0);
                HileraY = 0;
                round=(int) (Math.random()*6);;
            }
        }
        if(round==5){
            int posJefe = (int)Math.ceil((Math.random() * 7));
            int posJefeNormal = 0;
            IEnemigos[] enemigosArr = new IEnemigos[7];

            for (int i = 0; i < listaTemporal4.lenght(); i++)
            {
                IEnemigos enemigoX = listaTemporal4.seleccionarEnemigoEnPosicion(i);
                enemigosArr[i] = enemigoX;

                if(enemigoX.nombre().contains("Jefe"))
                {
                    posJefeNormal = i;
                }
            }

            IEnemigos NTemp = enemigosArr[posJefe];
            IEnemigos JTemp = enemigosArr[posJefeNormal];

            enemigosArr[posJefe] = JTemp;
            enemigosArr[posJefeNormal] = NTemp;


            for (int i = 0; i < listaTemporal4.lenght(); i++)
            {
                IEnemigos enemigoX = enemigosArr[i];

                enemigoX.setCoordenadas(distanceX, (int)Math.floor(HileraY));

                Image imageToUse = enemigoX.nombre().contains("Jefe") ? jefeImage : enemigosImage;

                int eX = enemigoX.X();
                int eY = enemigoX.Y();

                if(currentShotX > (eX - 15) && currentShotX < (eX + 15) &&
                        currentShoty > (eY - 15) && currentShoty < (eY + 15))
                {
                    if(!golpeoEnemigo)
                    {
                        Score++;
                        enemigoX.bajarVida();

                        if(enemigoX.nombre().contains("Jefe") && enemigoX.hitPoints() == 0)
                        {
                            cantidadDeEnemigos = 0;
                            for (int x = 0; x < listaTemporal4.lenght(); x++)
                            {
                                IEnemigos enemigo2 = listaTemporal4.seleccionarEnemigoEnPosicion(x);
                                enemigo2.bajarVida();
                            }
                        }
                    }

                    golpeoEnemigo = true;
                }
                else {
                    PrintBala(g);
                }

                if (enemigoX.nombre().contains("Jefe")) {
                    System.out.println("BossHP " + enemigoX.hitPoints());
                }

                if(enemigoX.hitPoints() > 0)
                {
                    cantidadDeEnemigos ++;
                    g.drawImage(
                            imageToUse,
                            distanceX,
                            (int)Math.floor(HileraY) + enemigoX.velocidad(),
                            30,
                            30,
                            this);

                }

                distanceX += 40;
            }

            HileraY += 0.1;

            if(cantidadDeEnemigos == 0)
            {
                listaTemporal=Builder.BuildClaseA(1,0);
                listaTemporal2 = Builder.BuildClaseA(1,0);
                listaTemporal3 = Builder.BuildClaseB(1,0);
                listaTemporal4 = Builder.BuildClaseC(1,0);
                HileraY = 0;
                round=(int) (Math.random()*6);;
            }

        }

        
        
        if (HileraY >= BOARD_HEIGHT) {
        	ingame = false;
			JOptionPane.showMessageDialog(null, "Game Over");
			System.exit(0);
		}
        
        Font small = new Font("Helvetica",Font.BOLD,14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(message,10,20);
        g.drawString(timermessage,10,40);g.drawString(String.valueOf(minutos)+":"+String.valueOf(Time)+"s",10,60);
        g.drawString("Dificultad",400,70);g.drawString(String.valueOf(round),400,100);
        g.drawString(points,400,20); g.drawString(String.valueOf(Score),400,40);


        if(ingame){
             g.drawImage(img,0,0,200,200 ,null);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    /**
     * printBala, se utiliza para dibujar las balas disparadas y
     * detectar colisiones.
     * @param g
     */
	private void PrintBala(Graphics g) {

		//represent shot
		if (Shot.size()>0 && !golpeoEnemigo) {
		    for (int index = 0; index < Shot.size(); index++) {
		        //Just one shoot
		        if (Shot.size() > 1){
		            if (xS.get(0) == xS.get(index)){
		                xS.remove(index);
		                yS.remove(index);
		                Shot.remove(index);
		            }
		        }
		        //Speed
		        yS.set(index, yS.get(index) - 4);
		        //In board
		        if (yS.get(index) > -20) {
		            g.drawImage(balaImage, xS.get(index), yS.get(index), 20, 40, this);
		            currentShotX =  xS.get(index);
		            currentShoty =  yS.get(index);
		            //Help Prints
		            System.out.println("XS" + xS.get(index));
		            System.out.println("YS" + yS.get(index));
		            System.out.println("Bala" + p.x);
		        }
		    }
		}
	}

    /**
     * Se utiliza para detectar eventos de teclado
     */
    private class Tdapter extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            p.moveRight = false;
            p.moveLeft = false;
        }

        /**
         * keyPressed se utiliza para saber cuando se selecciona alguna tecla.
         * @param e accion del teclado
         */
        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println( e.getKeyCode());
            // message = "Key Pressed: " + e.getKeyCode();
            int key=e.getKeyCode();

            if(key==39){
                HileraY=0;
                round=(int) (Math.random()*6);

            }
            if(key==37){
                HileraY=0;
                round=(int) (Math.random()*6);
            }
            if(key==32){
                 cantidadDeEnemigos = 0;
            }

        }
    }

    public void IniShoot (){
        /**
         * Este metodo se utiliza para inicializar los arrays (usados por las balas.)
         *
         */
        Shot = new ArrayList<Integer>();
        xS = new ArrayList<Integer>();
        yS = new ArrayList<Integer>();
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        /**
         * El metodo MouseClicked se utiliza para detectar alguna interaccion de click, con el mouse.
         * Ayuda a iniciar con el cronometro y a cuantificafr los disparos con sus posiciones.
         */
        Shot.add(counter);
        xS.add(p.x);
        yS.add(p.y);
        golpeoEnemigo = false;
        counter += 1;
        //Help prints
        System.out.println("XS"+xS.get(0));
        System.out.println("YS"+yS.get(0));
        System.out.println(Shot.size());
        System.out.println(Shot); 
        timer.start();
    }


    @Override
    public void mousePressed (MouseEvent e) {
        /**
         * mousePressed, metodo utlizado para obtener las posiciones "x"/ "y" del mouse al
         * momento de interaccion y asi otorgarlas a la nave.
         *
         */
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
    /**
     * Se utiliza para obtener las coordenadas en las que el mouse se esta moviendo.
     * @param e accion del mouse.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        int x= e.getX();
        int y = e.getY();
        coord =x;
    }

    @Override
    public void run() {
        /**
         * Run, inicializa
         */
        IniShoot();
        long beforeTime, timeDiff, sleep;
    	ingame = true;
        beforeTime = System.currentTimeMillis();
        boardLoop();
    }

    long time = System.currentTimeMillis();
    /**
     * Bucle para el funcionamiento del juego
     */
    public void boardLoop()
    { 
        int animationDelay = 5;
        while (ingame) 
        {//infinite loop
            //spriteManager.update();
            repaint();
            try 
            {
                time += animationDelay;
                Thread.sleep(Math.max(0,time -
                        System.currentTimeMillis()));
            }catch (InterruptedException e) 
            {
                System.out.println(e);
            }//end catch
        }//end while loop
    }
}

