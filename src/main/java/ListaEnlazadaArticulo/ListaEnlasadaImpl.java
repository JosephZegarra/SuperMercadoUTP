
package ListaEnlazadaArticulo;

import ListaEnlasada.*;


public class ListaEnlasadaImpl implements ListaInterface
{
    private Nodo cabecera;

    public ListaEnlasadaImpl() 
    {
        this.cabecera = new Nodo(null);
    }
    
    public boolean estaVacia()
    {
        if (this.cabecera.elemento==null)
            return true;
        else 
            return false;
    }
    
    private Nodo buscarUltimoNodo()
    {
        Nodo iterador = this.cabecera;
        while (iterador.siguiente !=null)
            iterador = iterador.siguiente;
        
        return iterador;
    }
    
    
    
    @Override
    public void insertarFinal(Nodo nuevoNodo)
    {
        if (this.estaVacia())
            this.cabecera = nuevoNodo;
        else
        {
            Nodo nodoUltimo = buscarUltimoNodo();
            nodoUltimo = buscarUltimoNodo();
            nodoUltimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente=null;
        }
    }
    
    @Override
    public void insertarInicio(Nodo nuevoNodo)
    {
        if(this.estaVacia())
        {
            this.cabecera = nuevoNodo;
            nuevoNodo.siguiente=null;
        }
        else
        {
            nuevoNodo.siguiente = this.cabecera;
            this.cabecera=nuevoNodo;
        }
    }
    
    
    
    public Nodo buscarIteradorIndice(int indice)
    {
        if (indice < 1) {
        // Índice inválido, retorna null
        return null;
        }

        Nodo iterador = this.cabecera;
        int contador = 1;

        while (iterador != null && contador < indice) {
            iterador = iterador.siguiente;
            contador++;
        }

        return iterador;

 
    }
    
   

    
   
   
 
    
    @Override
    public String retirarInicio()
    {
        Nodo iterador = this.cabecera;
        Nodo nodoEliminar = null;
        
        if (this.estaVacia())
        {
            nodoEliminar=this.cabecera;
            this.cabecera.elemento = null;
        }
        else 
        {
            nodoEliminar = iterador;
            this.cabecera = iterador.siguiente;
        }
        return String.valueOf(nodoEliminar.elemento);
    }
    
    
    @Override
    public String retirarFinal()
    {
        Nodo iterador = this.cabecera;
        Nodo nodoEliminar = null;
        
        if (this.estaVacia())
            return null;
        
        if(iterador.siguiente==null)
        {
            nodoEliminar = this.cabecera;
            this.cabecera.elemento = null;
        }
        else 
        {
            while(iterador.siguiente.siguiente !=null)
                iterador = iterador.siguiente;
                
            nodoEliminar = iterador.siguiente;
            iterador.siguiente = null;
        }
        return String.valueOf(nodoEliminar.elemento);
    }
    
     @Override
    public void insertarDentro(Nodo nuevoNodo,int indice)
    {   
        Nodo nodoAnterior = buscarIteradorIndice(indice - 1);

        if (nodoAnterior != null) {
            nuevoNodo.siguiente = nodoAnterior.siguiente;
            nodoAnterior.siguiente = nuevoNodo;
        } else if (indice == 1) {
            nuevoNodo.siguiente = this.cabecera;
            this.cabecera = nuevoNodo;
        } else {
            System.out.println("Posición no válida para insertar");
        }
    
      

    }
    @Override
    
    public String RetirarDentro(int indice)
    {  
        Nodo nodoEliminar = null;

        if (this.estaVacia()) {
            return null;
        }

        if (indice == 1) {
            nodoEliminar = this.cabecera;
            this.cabecera = this.cabecera.siguiente;
        } else {
            Nodo nodoAnterior = buscarIteradorIndice(indice - 1);
            if (nodoAnterior != null && nodoAnterior.siguiente != null) {
                nodoEliminar = nodoAnterior.siguiente;
                nodoAnterior.siguiente = nodoAnterior.siguiente.siguiente;
            } else {
                System.out.println("Posición no válida para eliminar");
                return null;
            }
        }

        return String.valueOf(nodoEliminar.elemento);

    }
    
   
    @Override
    public String imprimirLista()
    {
        String cadena ="";
        Nodo iterador = this.cabecera;
        
        while(iterador!=null)
        {
            if(iterador.elemento!=null)
                cadena += String.valueOf(iterador.elemento) + " => ";
            iterador = iterador.siguiente;
        }
        return cadena;
    }
    
    @Override
    public int TamanioLista()
    {
        String cadena ="";
        Nodo iterador = this.cabecera;
        int contador=0;
        
        while(iterador!=null)
        {
            if(iterador.elemento!=null)
                cadena += String.valueOf(iterador.elemento) + " => ";
            iterador = iterador.siguiente;
            contador++;
        }
        return contador;
    }
    
    @Override
    public int buscar(int valor) 
    {
        Boolean encontrado = false;
        Nodo Iterador = cabecera;
        int contador = 1; // Inicializamos el contador en 1 para la primera posición.

        while (Iterador != null && !encontrado) 
        {   
            if (Iterador.elemento.equals(valor)) 
            {
                encontrado = true;
            } 
            else 
            {
                Iterador = Iterador.siguiente;
                contador++;
            }
        }

        // Si llegamos al final de la lista y no encontramos el valor, ajustamos el contador.
        if (!encontrado) 
        {
            contador = -1; // Indicar que el valor no se encontró en la lista.
        }

        return contador;
        

    }
    
    
   
 
  
    
    
    
    
    
    
    
    
  
       // analizando e implementando

    @Override
    public void Ordenamiento_ShellSort() 
    {
        
        int n = TamanioLista();
        int incremento = n;

        do {
            incremento = incremento / 2;
            for (int i = incremento; i <= n; i++) {
                Nodo nodoActual = buscarIteradorIndice(i);
                if (nodoActual != null) {
                    Object valorActual = nodoActual.elemento;

                    int j = i;
                    while (j >= incremento) {
                        Nodo nodoAnterior = buscarIteradorIndice(j - incremento);
                        if (nodoAnterior != null) {
                            Object valorAnterior = nodoAnterior.elemento;
                            if (compararAmenorQueB(valorActual, valorAnterior)) {
                                buscarIteradorIndice(j).elemento = valorAnterior;
                                j -= incremento;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }

                    buscarIteradorIndice(j).elemento = valorActual;
                }
            }
        } while (incremento > 1);
        
        
        
        
    }    
    
    //orden ascendente

    public boolean compararAmenorQueB(Object a, Object b) 
    {
        if (a instanceof Comparable<?> && b instanceof Comparable<?>) 
        {
            Comparable<Object> comparableA = (Comparable<Object>) a;
            return comparableA.compareTo(b) < 0;
        } else 
        {
            throw new IllegalArgumentException("Los objetos no son comparables");
        }
    }
    
    
    /*
    //orden descendente
    public boolean compararAmenorQueB(Object a, Object b) 
    {
        if (a instanceof Comparable<?> && b instanceof Comparable<?>) 
        {
            Comparable<Object> comparableA = (Comparable<Object>) a;
            return comparableA.compareTo(b) > 0; // Cambio en la comparación
        } else 
        {
            throw new IllegalArgumentException("Los objetos no son comparables");
        }
    }
    */
    
    
}
    
    
    
    


 


