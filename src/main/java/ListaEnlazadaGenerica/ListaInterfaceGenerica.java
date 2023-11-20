package ListaEnlazadaGenerica;

import ListaEnlasada.*; 

public interface ListaInterfaceGenerica<T> 
{
    //METODOS PUBLICOS
    public void insertarFinal(NodoGenerico<T> nuevoNodo);//
    public void insertarInicio(NodoGenerico<T> nuevoNodo);
    public T retirarInicio();//
    public T retirarFinal();
    public void insertarDentro(NodoGenerico<T> nuevoNodo, int indice);////resuelto 
    public T RetirarDentro(int indice);
    public String imprimirLista();
    public int TamanioLista();
    public int buscar(T valor);
    public void Ordenamiento_ShellSort();
    
    //metodos para copiar de un Arreglo a Lista Enlazada
    public NodoGenerico<T> buscarIteradorIndice(int indice);
    
}
