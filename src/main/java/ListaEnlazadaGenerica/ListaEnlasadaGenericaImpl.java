
package ListaEnlazadaGenerica;

public class ListaEnlasadaGenericaImpl<T> implements ListaInterfaceGenerica<T>
{
    private NodoGenerico<T> cabecera;

    public ListaEnlasadaGenericaImpl() 
    {
        this.cabecera = new NodoGenerico<T>(null);
    }
    
    public boolean estaVacia()
    {
        if (this.cabecera.elemento==null)
            return true;
        else 
            return false;
    }
    
    private NodoGenerico<T> buscarUltimoNodo()
    {
        NodoGenerico<T> iterador = this.cabecera;
        while (iterador.siguiente !=null)
            iterador = iterador.siguiente;
        
        return iterador;
    }
    
    
    
    @Override
    public void insertarFinal(NodoGenerico<T> nuevoNodo)
    {
        if (this.estaVacia())
            this.cabecera = nuevoNodo;
        else
        {
            NodoGenerico<T> nodoUltimo = buscarUltimoNodo();
            nodoUltimo = buscarUltimoNodo();
            nodoUltimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente=null;
        }
    }
    
    @Override
    public void insertarInicio(NodoGenerico<T> nuevoNodo)
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
    
    
    
    public NodoGenerico<T> buscarIteradorIndice(int indice)
    {
        if (indice < 1) {
        // Índice inválido, retorna null
        return null;
        }

        NodoGenerico<T> iterador = this.cabecera;
        int contador = 1;

        while (iterador != null && contador < indice) {
            iterador = iterador.siguiente;
            contador++;
        }

        return iterador;

 
    }
    
   

    
   
   
 
    
    @Override
    public T retirarInicio()
    {
        NodoGenerico<T> iterador = this.cabecera;
        NodoGenerico<T> nodoEliminar = null;
        
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
        return nodoEliminar.elemento;
    }
    
    
    @Override
    public T retirarFinal()
    {
        NodoGenerico<T> iterador = this.cabecera;
        NodoGenerico<T> nodoEliminar = null;
        
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
        return nodoEliminar.elemento;
    }
    
     @Override
    public void insertarDentro(NodoGenerico<T> nuevoNodo,int indice)
    {   
        NodoGenerico<T> nodoAnterior = buscarIteradorIndice(indice - 1);

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
    
    public T RetirarDentro(int indice)
    {  
        NodoGenerico<T> nodoEliminar = null;

        if (this.estaVacia()) {
            return null;
        }

        if (indice == 1) {
            nodoEliminar = this.cabecera;
            this.cabecera = this.cabecera.siguiente;
        } else {
            NodoGenerico<T> nodoAnterior = buscarIteradorIndice(indice - 1);
            if (nodoAnterior != null && nodoAnterior.siguiente != null) {
                nodoEliminar = nodoAnterior.siguiente;
                nodoAnterior.siguiente = nodoAnterior.siguiente.siguiente;
            } else {
                System.out.println("Posición no válida para eliminar");
                return null;
            }
        }

        return nodoEliminar.elemento;

    }
    
   
    @Override
    public String imprimirLista()
    {
        String cadena ="";
        NodoGenerico<T> iterador = this.cabecera;
        
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
        NodoGenerico<T> iterador = this.cabecera;
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
    public int buscar(T valor) 
    {
        Boolean encontrado = false;
        NodoGenerico<T> Iterador = cabecera;
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
    
    
    
    
    /*
    
    //eliminar luego deexperimentar
    
    @Override
    public Nodo buscarObjetoFiltrar(int Object) 
    {
        Boolean encontrado = false;
        Nodo Iterador = cabecera;
        int contador = 1; // Inicializamos el contador en 1 para la primera posición.

        while (Iterador != null) 
        {   
            if (Iterador.elemento.equals(Object)) 
            {
                encontrado = true;
                //creo una lista enlazada y guardo los nodos
                
            } 
            else 
            {
                Iterador = Iterador.siguiente;
                contador++;
            }
        }

        return contador;
        

    }
    
    */
 
  
    
    
    
    
    
    
    
    
  
       // analizando e implementando

    @Override
    public void Ordenamiento_ShellSort() 
    {
        
        int n = TamanioLista();
        int incremento = n;

        do {
            incremento = incremento / 2;
            for (int i = incremento; i <= n; i++) {
                NodoGenerico<T> nodoActual = buscarIteradorIndice(i);
                if (nodoActual != null) {
                    T valorActual = nodoActual.elemento;

                    int j = i;
                    while (j >= incremento) {
                        NodoGenerico<T> nodoAnterior = buscarIteradorIndice(j - incremento);
                        if (nodoAnterior != null) {
                            T valorAnterior = nodoAnterior.elemento;
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

    public boolean compararAmenorQueB(T a, T b) 
    {
        if (a instanceof Comparable<?> && b instanceof Comparable<?>) 
        {
            Comparable<T> comparableA = (Comparable<T>) a;
            return comparableA.compareTo(b) < 0;
        } else 
        {
            throw new IllegalArgumentException("Los objetos no son comparables");
        }
    }
    
    
    /*
    //orden descendente
    public boolean compararAmenorQueB(T a, T b) 
    {
        if (a instanceof Comparable<?> && b instanceof Comparable<?>) 
        {
            Comparable<T> comparableA = (Comparable<T>) a;
            return comparableA.compareTo(b) > 0; // Cambio en la comparación
        } else 
        {
            throw new IllegalArgumentException("Los objetos no son comparables");
        }
    }
    */
    
    
}
    
    
    
    


 


