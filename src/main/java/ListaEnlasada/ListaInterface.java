package ListaEnlasada;

public interface ListaInterface 
{
    //METODOS PUBLICOS
    public void insertarFinal(Nodo nuevoNodo);//
    public void insertarInicio(Nodo nuevoNodo);
    public String retirarInicio();//
    public String retirarFinal();
    public void insertarDentro(Nodo nuevoNodo, int indice);////resuelto 
    public String RetirarDentro(int indice);
    public String imprimirLista();
    public int TamanioLista();
    public int buscar(int valor);
    public void Ordenamiento_ShellSort();
    //metodos para copiar de un Arreglo a Lista Enlazada
    
    public Nodo buscarIteradorIndice(int indice);
    
}
