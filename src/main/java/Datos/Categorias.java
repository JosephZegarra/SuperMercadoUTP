/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ListaEnlasada.*;


public class Categorias 
{
    protected String IdCategoria;
    protected String NombreCategoria;
    protected String Descripcion;
    
    //datos importados de main
    protected String csvFile;//direccion del archivo a importar
    protected int numFilas; //numero de filas del archivo

    public Categorias() 
    {

    }

    public Categorias(String IdCategoria, String NombreCategoria, String Descripcion) {
        this.IdCategoria = IdCategoria;
        this.NombreCategoria = NombreCategoria;
        this.Descripcion = Descripcion;
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
// importados de main
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

    
    
    
    
    
    //
    @Override
    public String toString() {
        return IdCategoria + "; " + NombreCategoria + "; " + Descripcion;
    }
  
    //Lista Copiada de metodo CopiarContenidoEImpresion
    Categorias[] ListaArregloCopia= new Categorias[numFilas];
    

    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    
    
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)//importa el archivo .csv a un arreglo de 
                                                                        //objetos tipo Categoria
    {  
        Categorias[] listaobjetos = new Categorias[numFilas];                         //Buffer para leer el archivo e interactua
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) //File para abrir el archivo csv 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            Categorias objeto=new Categorias();
                            objeto.setIdCategoria(partes[0]);
                            objeto.setNombreCategoria(partes[1]);
                            objeto.setDescripcion(partes[2]);
                            

                    // Agregar el objeto al arreglo
                    
                    listaobjetos[indice] = objeto;
                    
                    indice++;
                }
                //copia de  listaobjetos a  ListaArregloCopia
                ListaArregloCopia=listaobjetos.clone();
                
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (Categorias objeto : listaobjetos) 
            {
                System.out.println(objeto);
            }
    }
    
    
    ListaInterface listaEnlazadaCategorias = new ListaEnlasadaImpl();
    
    
    public void copiarArregloAListaEnlazada() 
    {
        int dimensionArreglo = numFilas;
        

        for (int i = 0; i < dimensionArreglo; i++) 
        {
            Categorias categoria = ListaArregloCopia[i]; // Obtener la categoría del arreglo

            // Crear un nuevo nodo con la categoría y enlazarlo al siguiente nodo (si existe)
            Nodo nuevoNodo = new Nodo(categoria);
            listaEnlazadaCategorias.insertarFinal(nuevoNodo);
            
        }
    }
    
    
    public void imprimir()
    {
       System.out.println(listaEnlazadaCategorias.imprimirLista());
        
    }
    
    
    
    
    
    
}
