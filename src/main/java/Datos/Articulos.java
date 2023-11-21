package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import ListaEnlasada.*;


public class Articulos 
{
    protected String IdProducto;
    protected String NombreProducto;
    protected String Proveedores;
    protected String Categoria;
    protected String CantidadPorUnidad;
    protected String PrecioPorUnidad;
    protected String UnidadesExistentes;
    protected String UnidadesPedidas;
    protected String Suspendido;
    
    protected String csvFile;
    protected int numFilas;
    
    public Articulos() {

    }

    public Articulos(String IdProducto, String NombreProducto, String Proveedores, String Categoria,
                     String CantidadPorUnidad, String PrecioPorUnidad, String UnidadesExistentes, String UnidadesPedidas,
                     String Suspendido) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.Proveedores = Proveedores;
        this.Categoria = Categoria;
        this.CantidadPorUnidad = CantidadPorUnidad;
        this.PrecioPorUnidad = PrecioPorUnidad;
        this.UnidadesExistentes = UnidadesExistentes;
        this.UnidadesPedidas = UnidadesPedidas;
        this.Suspendido = Suspendido;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getProveedores() {
        return Proveedores;
    }

    public void setProveedores(String Proveedores) {
        this.Proveedores = Proveedores;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCantidadPorUnidad() {
        return CantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String CantidadPorUnidad) {
        this.CantidadPorUnidad = CantidadPorUnidad;
    }

    public String getPrecioPorUnidad() {
        return PrecioPorUnidad;
    }

    public void setPrecioPorUnidad(String PrecioPorUnidad) {
        this.PrecioPorUnidad = PrecioPorUnidad;
    }

    public String getUnidadesExistentes() {
        return UnidadesExistentes;
    }

    public void setUnidadesExistentes(String UnidadesExistentes) {
        this.UnidadesExistentes = UnidadesExistentes;
    }

    public String getUnidadesPedidas() {
        return UnidadesPedidas;
    }

    public void setUnidadesPedidas(String UnidadesPedidas) {
        this.UnidadesPedidas = UnidadesPedidas;
    }

    public String getSuspendido() {
        return Suspendido;
    }

    public void setSuspendido(String Suspendido) {
        this.Suspendido = Suspendido;
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }
    
    @Override
    public String toString() 
    {
        return IdProducto + "; " + NombreProducto + "; " + Proveedores + "; " + Categoria + "; " + CantidadPorUnidad
                + "; " + PrecioPorUnidad + "; " + UnidadesExistentes + "; " + UnidadesPedidas + "; " + Suspendido;
    }
    
    Articulos[] ListaArregloCopia= new Articulos[numFilas];
    
    
    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        Articulos[] listaobjetos = new Articulos[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            Articulos objeto=new Articulos();
                            
                            /*
                            objeto.setIdProducto(partes[0]);
                            objeto.setNombreProducto(partes[1]);
                            objeto.setProveedores(partes[2]);
                            objeto.setCategoria(partes[3]);
                            objeto.setCantidadPorUnidad(partes[4]);
                            objeto.setPrecioPorUnidad(partes[5]);
                            objeto.setUnidadesExistentes(partes[6]);
                            objeto.setUnidadesPedidas(partes[7]);
                            objeto.setSuspendido(partes[8]);
                            */
                            
                                if (partes.length == 9) {
                                    objeto.setIdProducto(partes[0]);
                                    objeto.setNombreProducto(partes[1]);
                                    objeto.setProveedores(partes[2]);
                                    objeto.setCategoria(partes[3]);
                                    objeto.setCantidadPorUnidad(partes[4]);
                                    objeto.setPrecioPorUnidad(partes[5]);
                                    objeto.setUnidadesExistentes(partes[6]);
                                    objeto.setUnidadesPedidas(partes[7]);
                                    objeto.setSuspendido(partes[8]);
                                } 
                                else 
                                {
                                    // Manejar el caso en el que la línea no tiene suficientes elementos
                                    System.err.println("La línea no tiene suficientes elementos: " + line);
                                }

                    // Agregar el objeto al arreglo
                    listaobjetos[indice] = objeto;
                    indice++;
                }
                
                ListaArregloCopia=listaobjetos.clone();
                
            } 
                catch (IOException e) {
                e.printStackTrace();
            }

            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (Articulos objeto : listaobjetos) 
            {
                System.out.println(objeto);
            }
    }
    
    ListaInterface listaEnlazadaCategorias = new ListaEnlasadaImpl();
    
    public void copiarArregloAListaEnlazada() 
    {
        int dimensionArreglo = numFilas;
        int c = 1;

        for (int i = 0; i < dimensionArreglo; i++) 
        {
            Articulos articulos = ListaArregloCopia[i]; // Obtener la categoría del arreglo

            // Crear un nuevo nodo con la categoría y enlazarlo al siguiente nodo (si existe)
            Nodo nuevoNodo = new Nodo(articulos);
            listaEnlazadaCategorias.insertarFinal(nuevoNodo);
            c++;
        }

    }
   
    public void imprimir()
    {
       System.out.println(listaEnlazadaCategorias.imprimirLista());   
    } 
    
    //FILTRAR POR NOMBRE 
    public ListaInterface filtrarPorNombre(String nombre) 
    {
        ListaInterface listaFiltrada = new ListaEnlasadaImpl();
        for (Articulos articulo : ListaArregloCopia) {
            if (articulo.getNombreProducto().equalsIgnoreCase(nombre)) 
            {
            Nodo nuevoNodo = new Nodo(articulo);
            listaFiltrada.insertarFinal(nuevoNodo);
            }
    }
    return listaFiltrada;
    
    }
    
    
    
    ///////////////////////////MODIFICACION SEBAS////////////////////////////////////////////////////////
    public void FiltrarDatosPorNombres ()
    {
        String archivoCSV = "Articulos.csv";
        int numeroFilas = 1;  // Reemplazar con el número correcto de filas

        // Crear una instancia de la clase Articulos
        Articulos articulos = new Articulos();

        // Realizar la copia del contenido e impresión desde el archivo CSV
        articulos.CopiarContenidoEImpresion(archivoCSV, numeroFilas);

        // Filtrar por nombre (por ejemplo, buscar productos con el nombre "Té Dharamsala")
        String nombreBuscado = "Té Dharamsala";
        ListaInterface listaFiltrada = articulos.filtrarPorNombre(nombreBuscado);

        // Imprimir la lista filtrada
        System.out.println("Resultados de la búsqueda por nombre '" + nombreBuscado + "':");
        System.out.println(listaFiltrada.imprimirLista());
    }
    
    
    
    
    
    
    
    
    
  
    
    
   
    
    
    
    
    
    
    
    
    
    
}

