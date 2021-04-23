package SpaceInvaders.src.enemigos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta clase crea al jefe de los enemigos
 * @author grupo 4
 * @version 1.0
 */
public class Jefe implements IEnemigos {
    private double _hitPoints;
    private int _velocidad;
    private double _resistencia;
    private String _nombre;
    private int _X;
    private int _Y;

    /**
     * Método constructor
     * @param velocidad determina la velocidad
     * @param resistencia determina la resistencia
     * @param nombre determina el nombre
     */
    public Jefe(int velocidad, double resistencia, String nombre) {
        double hitPointsTemp = Math.ceil(Math.random() * 5);
        
        while(hitPointsTemp < 2 && hitPointsTemp > 5){
            hitPointsTemp = Math.ceil(Math.random() * 5);
        }
        
        _hitPoints = hitPointsTemp;
        _velocidad = velocidad;
        _resistencia = resistencia;
        _nombre = nombre;
    }
    /**
     * Método que retorna los golpes dados al jefe
     * @return retorna los golpes
     */
    @Override
    public double hitPoints() {
       return _hitPoints;
    }
    /**
     * Método que retorna la velocidad del jefe
     * @return retorna la velocidad
     */
    @Override
    public int velocidad() {
        return _velocidad;
    }
    /**
     * Método que retorna la resistencia del jefe
     * @return retorna la resistencia
     */
    @Override
    public double resistencia() {
        return _resistencia;
    }
    /**
     * Método que disminuye la vida del jefe
     * @return retorna los golpes
     */
    @Override
    public double bajarVida() {
        _hitPoints -= 1;
        return _hitPoints;
    }
    /**
     * Método que retorna el nombre
     * @return retorna el nombre
     */
    @Override
    public String nombre() {
        return _nombre;
    }

    /**
     * Método que retorna la posición en x del jefe
     * @return retorna el valor de x
     */

	public int X() {
		// TODO Auto-generated method stub
		return _X;
	}
    /**
     * Método que retorna la posición en y del jefe
     * @return retorna el valor de x
     */
	public int Y() {
		// TODO Auto-generated method stub
		return _Y;
	}
    /**
     * Método que permite colocar las coordenadas
     * @param x valor de x
     * @param y valor de y
     */
	public void setCoordenadas(int x, int y)
	{
		_X = x;
		_Y = y;
	} 
}
     
