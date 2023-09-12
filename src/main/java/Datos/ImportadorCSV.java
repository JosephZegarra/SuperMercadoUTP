/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Home
 */
public class ImportadorCSV 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String csvFile = "C:\\Users\\Home\\Downloads\\Categorias.csv"; // Reemplaza con la ruta de tu archivo CSV
        String line;
        String csvDelimiter = ";"; // El delimitador que separa los valores en el CSV
        int numFilas = contarFilasEnCSV(csvFile);
        ObjetoCSV[] objetos = new ObjetoCSV[numFilas];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int indice = 0;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes usando el delimitador
                String[] partes = line.split(csvDelimiter);

                // Crear un objeto y asignar valores a sus atributos
                ObjetoCSV objeto = new ObjetoCSV();
                objeto.setIdCategoria(partes[0]);
                objeto.setNombreCategoria(partes[1]);
                objeto.setDescripcionCategoria(partes[2]);
                // ... Agregar más atributos según sea necesario

                // Agregar el objeto al arreglo
                objetos[indice] = objeto;
                indice++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
        for (ObjetoCSV objeto : objetos) {
            System.out.println(objeto);
        }
    }
    
    
    
    public static int contarFilasEnCSV(String archivoCSV) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Home\\Downloads\\Categorias.csv"))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }
  
}




class ObjetoCSV 
    {
    private String idCategoria;
    private String NombreCategoria;
    private String DescripcionCategoria;
    
    
    public ObjetoCSV() 
    {
    
    }

  
    // Getters y setters para los atributos

        public String getIdCategoria() {
            return idCategoria;
        }

        public void setIdCategoria(String idCategoria) {
            this.idCategoria = idCategoria;
        }

        public String getNombreCategoria() {
            return NombreCategoria;
        }

        public void setNombreCategoria(String NombreCategoria) {
            this.NombreCategoria = NombreCategoria;
        }

        public String getDescripcionCategoria() {
            return DescripcionCategoria;
        }

        public void setDescripcionCategoria(String DescripcionCategoria) {
            this.DescripcionCategoria = DescripcionCategoria;
        }
        
        
        @Override
        public String toString() {
        return idCategoria + "; " + NombreCategoria + "; " + DescripcionCategoria;
        }
    
    
    }





    