package ListaEnlasada;

public class Nodo 
{
    //ATRIBUTOS
    Object elemento; //Elemento / Contenido
    Nodo siguiente; //puntero al siguiente elemento
    
    //CONSTRUCTORES
    
    //Nodo Solo, no tiene enlace al siguiente 
    public Nodo(Object obj) 
    {
        this.elemento = obj;
        this.siguiente = null;
    }
    
    //Nodo con puntero a siguiente elemento
    public  Nodo(Object obj, Nodo n)
    {
        this.elemento = obj;
        this.siguiente = n ;
    }
    
    //METODOS GETTER AND SETTER
    public Object getElemento() 
    {
        return elemento;
    }

    public void setElemento(Object elemento) 
    {
        this.elemento = elemento;
    }
 }
