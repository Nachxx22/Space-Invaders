package enemigos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface
 * @author grupo 4
 * @version 1.0
 */
public interface IEnemigos {
    public double hitPoints();
    public int velocidad();
    public double resistencia();
    public double bajarVida();
    public String nombre();
    
    public int X();
    public int Y();
	public void setCoordenadas(int distanceX, int floor);
}
