package ListaEnlazadaArticulo;

import Datos.Articulos; 


public class Nodo 
{
    
    //ATRIBUTOS
    Articulos elemento; //Elemento / Contenido
    Nodo siguiente; //puntero al siguiente elemento
    
    //CONSTRUCTORES
    
    //Nodo Solo, no tiene enlace al siguiente 
    public Nodo(Articulos obj) 
    {
        this.elemento = obj;
        this.siguiente = null;
    }
    
    //Nodo con puntero a siguiente elemento
    public  Nodo(Articulos obj, Nodo n)
    {
        this.elemento = obj;
        this.siguiente = n ;
    }
    
    //METODOS GETTER AND SETTER
    public Articulos getElemento() 
    {
        return elemento;
    }

    public void setElemento(Articulos elemento) 
    {
        this.elemento = elemento;
    }
 }
