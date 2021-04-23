
package SpaceInvaders.src.hileras;

import SpaceInvaders.src.enemigos.Enemigos;
import SpaceInvaders.src.enemigos.Jefe;
import SpaceInvaders.src.listas.LCircular;
import SpaceInvaders.src.listas.LDoble;
import SpaceInvaders.src.listas.LSimple;
/**
 * Esta clase se utiliza para construir las distintas hileras de enemigos
 * @author grupo 4
 * @version 1.0
 */
public class Builder {
    /**
     * Este método construye la hilera tipo básica
     * @param velocidad valor de la velocidad
     * @param resistencia valor de la resistencia
     * @return retorna la lista
     */
    public static LSimple BuildBasic(int velocidad, double resistencia)
    {
        Integer cantidadEnemigos = 6;
        
        LSimple resultado = new LSimple();
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            String _nombre = "Enemigo Normal " + i;
            Enemigos nuevoEnemigo = new Enemigos(velocidad, resistencia, _nombre);
            resultado.insertarFinalDato(resultado, nuevoEnemigo);
        }
        
        return resultado;
    }
    /**
     * Este método construye la hilera tipo claseA
     * @param velocidad valor de la velocidad
     * @param resistencia valor de la resistencia
     * @return retorna la lista
     */
    public static LSimple BuildClaseA(int velocidad, double resistencia)
    {
        Integer cantidadEnemigos = 7;
        int indiceJefe = (int) Math.round(Math.random() * cantidadEnemigos);
        
        LSimple resultado = new LSimple();
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            String _nombre = "Enemigo Normal " + i; 
            
            if (i == indiceJefe) 
            {
                _nombre = "Jefe";
                Jefe nuevoEnemigo = new Jefe(velocidad, resistencia, _nombre);
                resultado.insertarFinalDato(resultado, nuevoEnemigo);
            }
            else  
            {
                Enemigos nuevoEnemigo = new Enemigos(velocidad, resistencia, _nombre);
                resultado.insertarFinalDato(resultado, nuevoEnemigo);
            }   
        }
        
        return resultado;
    }
    /**
     * Este método construye la hilera tipo claseB
     * @param velocidad valor de la velocidad
     * @param resistencia valor de la resistencia
     * @return retorna la lista
     */
    public static LDoble BuildClaseB(int velocidad, double resistencia)
    {
        Integer cantidadEnemigos = 7;
        int indiceJefe = (int) Math.round(Math.random() * cantidadEnemigos);
        
        LDoble resultado = new LDoble();
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            String _nombre = "Enemigo Normal " + i; 
            
            if (i == indiceJefe) 
            {                
                _nombre = "Jefe";
                Jefe nuevoEnemigo = new Jefe(velocidad, resistencia, _nombre);
                resultado.insertarFinalDato(resultado, nuevoEnemigo);
            }
            else  
            {
                Enemigos nuevoEnemigo = new Enemigos(velocidad, resistencia, _nombre);
                resultado.insertarFinalDato(resultado, nuevoEnemigo);
            }   
        }
        
        return resultado;
    }
    /**
     * Este método construye la hilera tipo claseC
     * @param velocidad valor de la velocidad
     * @param resistencia valor de la resistencia
     * @return retorna la lista
     */
    public static LCircular BuildClaseC(int velocidad, double resistencia)
    {
        Integer cantidadEnemigos = 7;
        int indiceJefe = (int) Math.round(Math.random() * cantidadEnemigos);
        
        LCircular resultado = new LCircular();
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            String _nombre = "Enemigo Normal " + i; 
            
            if (i == indiceJefe) 
            {                
                _nombre = "Jefe";
                Jefe nuevoEnemigo = new Jefe(velocidad, resistencia, _nombre);
                resultado.insertarDato(resultado, nuevoEnemigo);
            }
            else  
            {
                Enemigos nuevoEnemigo = new Enemigos(velocidad, resistencia, _nombre);
                resultado.insertarDato(resultado, nuevoEnemigo);
            }   
        }
        
        return resultado;
    }
    /**
     * Este método ordena la hilera con algoritmo bubble sort
     * @param arr valor Array
     */
    public static void bubbleSort(double arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    /**
     * Este método construye la hilera tipo claseD
     * @param velocidad valor de la velocidad
     * @return retorna la lista
     */
    public static LCircular BuildClaseD(int velocidad)
    {
        Integer cantidadEnemigos = 7;
        int indiceJefe = (int) Math.round(Math.random() * cantidadEnemigos);
        
        double[] resistencias = new double[cantidadEnemigos];        
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            resistencias[i] = Math.random();
        }
        
        bubbleSort(resistencias);
        
        LCircular resultado = new LCircular();
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            String _nombre = "Enemigo Normal " + i; 
            
            if (i == indiceJefe) 
            {    
                _nombre = "Jefe";
                Jefe nuevoEnemigo = new Jefe(velocidad, resistencias[i], _nombre);
                resultado.insertarDato(resultado, nuevoEnemigo);
            }
            else  
            {
                Enemigos nuevoEnemigo = new Enemigos(velocidad, resistencias[i], _nombre);
                resultado.insertarDato(resultado, nuevoEnemigo);
            }   
        }
        
        return resultado;
    }
    /**
     * Este método construye la hilera tipo claseE
     * @param velocidad valor de la velocidad
     * @return retorna la lista
     */
    public static LCircular BuildClaseE(int velocidad)
    {
        Integer cantidadEnemigos = 7;
        int indiceJefe = (int) Math.round(Math.random() * cantidadEnemigos);
        
        double[] resistencias = new double[cantidadEnemigos];        
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            resistencias[i] = Math.random();
        }
        
        bubbleSort(resistencias);
        
        LCircular resultado = new LCircular();
        
        for (int i = 0; i < cantidadEnemigos; i++) {
            String _nombre = "Enemigo Normal " + i; 
            
            if (i == indiceJefe) 
            {    
                _nombre = "Jefe";
                Jefe nuevoEnemigo = new Jefe(velocidad, resistencias[i], _nombre);
                resultado.insertarDato(resultado, nuevoEnemigo);
            }
            else  
            {
                Enemigos nuevoEnemigo = new Enemigos(velocidad, resistencias[i], _nombre);
                resultado.insertarDato(resultado, nuevoEnemigo);
            }   
        }
        
        return resultado;
    }
}
