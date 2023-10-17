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
public class CompaniasEnvios 
{
    protected String IdCompaniaEnvios;
    protected String NombreCompania;
    protected String Telefono;
  
    
    public CompaniasEnvios() 
    {

    }

    public CompaniasEnvios(String IdCompaniaEnvios, String NombreCompania, String Telefono) 
    {
        this.IdCompaniaEnvios = IdCompaniaEnvios;
        this.NombreCompania = NombreCompania;
        this.Telefono = Telefono;
    }
    
    

    // Getters y setters para los atributos

    public String getIdCompaniaEnvios() {
        return IdCompaniaEnvios;
    }

    public void setIdCompaniaEnvios(String IdCompaniaEnvios) {
        this.IdCompaniaEnvios = IdCompaniaEnvios;
    }

    public String getNombreCompania() {
        return NombreCompania;
    }

    public void setNombreCompania(String NombreCompania) {
        this.NombreCompania = NombreCompania;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    
    

   

    @Override
    public String toString() {
        return IdCompaniaEnvios + "; " + NombreCompania + "; " + Telefono;
    }
    
    
    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    
    
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        CompaniasEnvios[] listaobjetos = new CompaniasEnvios[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            CompaniasEnvios objeto=new CompaniasEnvios();
                            objeto.setIdCompaniaEnvios(partes[0]);
                            objeto.setNombreCompania(partes[1]);
                            objeto.setTelefono(partes[2]);
                            

                    // Agregar el objeto al arreglo
                    listaobjetos[indice] = objeto;
                    indice++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (CompaniasEnvios objeto : listaobjetos) 
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
