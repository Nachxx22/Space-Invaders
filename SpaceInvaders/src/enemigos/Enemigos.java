package enemigos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 50684
 */
public class Enemigos implements IEnemigos {
    private double _hitPoints;
    private int _velocidad;
    private double _resistencia;
    
    public Enemigos(int velocidad, double resistencia) {
        _hitPoints = 1;
        _velocidad = velocidad;
        _resistencia = resistencia;
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
}
