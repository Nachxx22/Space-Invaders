package listas;

import enemigos.IEnemigos;

public interface ILista { 
	
    public abstract ILista insertarInicioDato(ILista lista, IEnemigos dato); 
    public IEnemigos seleccionarEnemigoEnPosicion(int posicion);
    public abstract ILista insertarInicioCadena (ILista lista, String cadena);
    public abstract ILista insertarFinalDato (ILista lista, IEnemigos dato); 
    public abstract ILista insertarFinalCadena (ILista lista, String cadena); 
    public abstract ILista borrarInicio (ILista lista);
    public abstract ILista borrarFinal (ILista lista);  
}
