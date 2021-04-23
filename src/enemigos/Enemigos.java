package enemigos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *La clase Enemigo hereda de la clase IEnemigos
 * Aqui se definen objetos enteros, double y strings, para dar caracteristicas a las naves enemigas.
 * @author Grupo 4
 */
public class Enemigos implements IEnemigos {
    private double _hitPoints;
    private int _velocidad;
    private double _resistencia;
    private String _nombre;
    private int _X;
    private int _Y;
    /**
     * Método constructor
     * @param velocidad valor de la velocidad
     * @param resistencia valor de la resistencia
     */
    public Enemigos(int velocidad, double resistencia) {
        _hitPoints = 1;
        _velocidad = velocidad;
        _resistencia = resistencia;
        _X = _Y = 0;
    }
    /**
     * Método constructor
     * @param velocidad valor de la velocidad
     * @param resistencia valor de la resistencia
     * @param nombre valor del nombre
     */
    public Enemigos(int velocidad, double resistencia, String nombre) {
        _hitPoints = 1;
        _velocidad = velocidad;
        _resistencia = resistencia;
        _nombre = nombre;
    }
    /**
     * Método que retorna los golpes dados a los enemigos
     * @return retorna los golpes
     */
    @Override
    public double hitPoints() {
       return _hitPoints;
    }
    /**
     * Método que retorna la velocidad de los enemigos
     * @return retorna la velocidad
     */
    @Override
    public int velocidad() {
        return _velocidad;
    }
    /**
     * Método que retorna la resistencia de los enemigos
     * @return retorna la resistencia
     */
    @Override
    public double resistencia() {
        return _resistencia;
    }
    /**
     * Método que disminuye la vida del enemigo
     * @return retorna los golpes
     */
    @Override
    public double bajarVida() {
        _hitPoints -= 1;
        return _hitPoints;
    }
    /**
     * Método que retorna el nombre del enemigo
     * @return retorna el nombre
     */
    @Override
    public String nombre() {
        return _nombre;
    }
    /**
     * Método que retorna la pasición en x
     * @return retorna el valor de x
     */
	public int X() {
		// TODO Auto-generated method stub
		return _X;
	}
    /**
     * Método que retorna la posición en Y
     * @return retorna el valor de y
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
