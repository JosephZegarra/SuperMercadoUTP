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

/**
 *
 * @author Home
 */
public class Detalles_Pedidos 
        
{
    
    protected String PrecioUnidad;
    protected String Cantidad;
    protected String Descuento;

    public Detalles_Pedidos() 
    {

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

   

    @Override
    public String toString() {
        return PrecioUnidad + "; " + Cantidad + "; " + Descuento;
    }
    
    
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
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (Detalles_Pedidos objeto : listaobjetos) 
            {
                System.out.println(objeto);
            }
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
