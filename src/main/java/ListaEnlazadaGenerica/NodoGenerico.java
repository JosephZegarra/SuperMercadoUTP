package ListaEnlazadaGenerica;

public class NodoGenerico<T>
{
    //ATRIBUTOS    
    T elemento; //Elemento / Contenido
    NodoGenerico<T> siguiente; //puntero al siguiente elemento
    
    //CONSTRUCTORES
    
    //Nodo Solo, no tiene enlace al siguiente 
    public NodoGenerico(T obj) 
    {
        this.elemento = obj;
        this.siguiente = null;
    }
    
    //Nodo con puntero a siguiente elemento
    public  NodoGenerico(T obj, NodoGenerico n)
    {
        this.elemento = obj;
        this.siguiente = n ;
    }
    
    //METODOS GETTER AND SETTER
    public T getElemento() 
    {
        return elemento;
    }

    public void setElemento(T elemento) 
    {
        this.elemento = elemento;
    }

    public NodoGenerico<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGenerico<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
 }
