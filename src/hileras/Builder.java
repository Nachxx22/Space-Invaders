
package hileras;

import enemigos.Enemigos;
import enemigos.Jefe;
import listas.LCircular;
import listas.LDoble;
import listas.LSimple;

public class Builder {
    
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
