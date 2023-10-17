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
public class Pedidos 
{
    
    protected String IdPedido;
    protected String Cliente;
    protected String FechaPedido;
    protected String FechaEntrega;
    protected String FechaEnvio;
    protected String FormaEnvio;
    protected String Cargo;
    
    protected String csvFile;
    protected int numFilas;
    
    public Pedidos() 
    {

    }

    public Pedidos(String IdPedido, String Cliente, String FechaPedido, String FechaEntrega, String FechaEnvio, String FormaEnvio, String Cargo) 
    {
        this.IdPedido = IdPedido;
        this.Cliente = Cliente;
        this.FechaPedido = FechaPedido;
        this.FechaEntrega = FechaEntrega;
        this.FechaEnvio = FechaEnvio;
        this.FormaEnvio = FormaEnvio;
        this.Cargo = Cargo;
    }

    
    
    // Getters y setters para los atributos

    public String getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(String IdPedido) {
        this.IdPedido = IdPedido;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(String FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public String getFechaEnvio() {
        return FechaEnvio;
    }

    public void setFechaEnvio(String FechaEnvio) {
        this.FechaEnvio = FechaEnvio;
    }

    public String getFormaEnvio() {
        return FormaEnvio;
    }

    public void setFormaEnvio(String FormaEnvio) {
        this.FormaEnvio = FormaEnvio;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
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
        return IdPedido + "; " + Cliente + "; " + FechaPedido + "; " + FechaEntrega + "; " + FechaEnvio + "; " + FormaEnvio + "; " + Cargo;
    }
    
    Pedidos[] ListaArregloCopia= new Pedidos[numFilas];
    
    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    
    
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        Pedidos[] listaobjetos = new Pedidos[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            Pedidos objeto=new Pedidos();
                            objeto.setIdPedido(partes[0]);
                            objeto.setCliente(partes[1]);
                            objeto.setFechaPedido(partes[2]);
                            objeto.setFechaEntrega(partes[3]);
                            objeto.setFechaEnvio(partes[4]);
                            objeto.setFormaEnvio(partes[5]);
                            objeto.setCargo(partes[6]);

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
            for (Pedidos objeto : listaobjetos) 
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
            Pedidos pedidos = ListaArregloCopia[i]; // Obtener la categoría del arreglo

            // Crear un nuevo nodo con la categoría y enlazarlo al siguiente nodo (si existe)
            Nodo nuevoNodo = new Nodo(pedidos);
            listaEnlazadaCategorias.insertarFinal(nuevoNodo);
            c++;
        }

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
