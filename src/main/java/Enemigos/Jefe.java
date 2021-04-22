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
    
    public Jefe(int velocidad, double resistencia, String nombre) {
        double hitPointsTemp = Math.round(Math.random() * 5);
        
        while(hitPointsTemp<2 && hitPointsTemp>5){
            hitPointsTemp = Math.round(Math.random() * 5);
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
        return null;
    }
}
