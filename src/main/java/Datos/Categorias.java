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

public class Categorias 
{
    protected String IdCategoria;
    protected String NombreCategoria;
    protected String Descripcion;

    public Categorias() {

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

    @Override
    public String toString() {
        return IdCategoria + "; " + NombreCategoria + "; " + Descripcion;
    }
    
    

    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    
    
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        Categorias[] listaobjetos = new Categorias[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
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
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (Categorias objeto : listaobjetos) 
            {
                System.out.println(objeto);
            }
    }
    
    
    
    
    
    
    
    
}
