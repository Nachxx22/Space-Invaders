package SpaceInvaders.src.enemigos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 50684
 */
public class Jefe implements IEnemigos {
    private double _hitPoints;
    private int _velocidad;
    private double _resistencia;
    private String _nombre;
    private int _X;
    private int _Y;
    
    
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

    @Override
    public double hitPoints() {
       return _hitPoints;
    }

    @Override
    public int velocidad() {
        return _velocidad;
    }

    @Override
    public double resistencia() {
        return _resistencia;
    }

    @Override
    public double bajarVida() {
        _hitPoints -= 1;
        return _hitPoints;
    }

    @Override
    public String nombre() {
        return _nombre;
    }
    

	public int X() {
		// TODO Auto-generated method stub
		return _X;
	}

	public int Y() {
		// TODO Auto-generated method stub
		return _Y;
	}
	
	public void setCoordenadas(int x, int y)
	{
		_X = x;
		_Y = y;
	} 
}
     
