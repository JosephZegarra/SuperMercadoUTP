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
/**
 *
 * @author Home
 */
public class Detalles_Pedidos 
        
{
    
    protected String PrecioUnidad;
    protected String Cantidad;
    protected String Descuento;
    
    
     //datos importados de main
    protected String csvFile;
    protected int numFilas;
    
    public Detalles_Pedidos() 
    {

    }

    public Detalles_Pedidos(String PrecioUnidad, String Cantidad, String Descuento) 
    {
        this.PrecioUnidad = PrecioUnidad;
        this.Cantidad = Cantidad;
        this.Descuento = Descuento;
    }
    
    

    // Getters y setters para los atributos

    public String getPrecioUnidad() {
        return PrecioUnidad;
    }

    public void setPrecioUnidad(String PrecioUnidad) {
        this.PrecioUnidad = PrecioUnidad;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getDescuento() {
        return Descuento;
    }

    public void setDescuento(String Descuento) {
        this.Descuento = Descuento;
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
    public String toString() {
        return PrecioUnidad + "; " + Cantidad + "; " + Descuento;
    }
    
     //Lista Copiada de metodo CopiarContenidoEImpresion
    Detalles_Pedidos[] ListaArregloCopia= new Detalles_Pedidos[numFilas];
    
    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    
    
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        Detalles_Pedidos[] listaobjetos = new Detalles_Pedidos[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            Detalles_Pedidos objeto=new Detalles_Pedidos();
                            objeto.setPrecioUnidad(partes[0]);
                            objeto.setCantidad(partes[1]);
                            objeto.setDescuento(partes[2]);
                            

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
            for (Detalles_Pedidos objeto : listaobjetos) 
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
            Detalles_Pedidos detalles_pedidos = ListaArregloCopia[i]; // Obtener la categoría del arreglo

            // Crear un nuevo nodo con la categoría y enlazarlo al siguiente nodo (si existe)
            Nodo nuevoNodo = new Nodo(detalles_pedidos);
            listaEnlazadaCategorias.insertarFinal(nuevoNodo);
            c++;
        }
         //verificando copiado
        listaEnlazadaCategorias.imprimirLista(); // Imprimir la lista enlazada
        System.out.println("el valorrrr es" + (listaEnlazadaCategorias.buscarIteradorIndice(2)).getElemento() );
    }
    
    
    public void imprimir()
    {
       System.out.println(listaEnlazadaCategorias.imprimirLista());
        
    }
    
    
    
    
     public void exportarContenidoAArchivo(String rutaArchivo, Detalles_Pedidos[] listaobjetos) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                for (Detalles_Pedidos objeto : listaobjetos) {
                    bw.write(objeto.toString());
                    bw.newLine();
                }
                System.out.println("Contenido exportado exitosamente al archivo " + rutaArchivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
     
}
