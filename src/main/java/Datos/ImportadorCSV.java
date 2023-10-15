/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Datos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import Datos.*;
import ListaEnlasada.*;

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
        
            
        
        
        String line;
        String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
        

        Scanner consola = new Scanner(System.in);
        
        
      //interface
        System.out.println("Seleccione una opción:");
            System.out.println("1. Categoría");
            System.out.println("2. Artículos");
            System.out.println("3. Proveedores");
            System.out.println("4. Clientes");
            System.out.println("5. Pedidos");
            System.out.println("6. Detalles Pedidos");
            System.out.println("7. Compañías Envíos");
            
        int numDirectorio = consola.nextInt();
        String csvFile =SeleccionDirectorio(numDirectorio);  // Reemplaza con la ruta de tu archivo CSV
        //ingreso de tipo de formulario al contarFilasEnCSV     
        int numFilas = contarFilasEnCSV(csvFile);//1: tipo de formulario que se va a contar
        
        
        switch(numDirectorio) 
        {
            case 1: 
                Categorias objCategoria= new Categorias();
                objCategoria.setNumFilas(numFilas);
                objCategoria.setCsvFile(csvFile);
                
                objCategoria.CopiarContenidoEImpresion(csvFile, numFilas);
                objCategoria.copiarArregloAListaEnlazada();
                objCategoria.imprimir();
                
                break;
            case 2:
                Articulos objArticulos= new Articulos();
                objArticulos.CopiarContenidoEImpresion(csvFile, numFilas);
                
                break;
            case 3:
                
            case 4:
                Clientes objClientes= new Clientes();
                objClientes.CopiarContenidoEImpresion(csvFile, numFilas);
                break;
            case 5:
                
                //Pedidos objPedidos= new Pedidos();
                //objPedidos.CopiarContenidoEImpresion(csvFile, numFilas);
                break;
            case 6:
                Detalles_Pedidos objDetalles_Pedidos= new Detalles_Pedidos();
                objDetalles_Pedidos.CopiarContenidoEImpresion(csvFile, numFilas);
                
               
                break;
            case 7:
                //Compania_Envios objCompania= new Compania_Envios();
                //objCompania.CopiarContenidoEImpresion(csvFile, numFilas);
                break;
            default:
                System.out.println("no coincide con ninguno de los casos anteriores");
                break;
        }
        
        
        //getter 
        
        

        
        
    }
    
    //Metodo para elegir Directorio del archivo
    public static String SeleccionDirectorio(int numDirectorio)
    {   String CaseDirectorio="";
        switch(numDirectorio) 
        {
            case 1:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Categorias.csv";
                break;
            case 2:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Articulos.csv";
                break;
            case 3:
               CaseDirectorio="C:\\Users\\Home\\Downloads\\Proveedores.csv";
                break;
            case 4:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Clientes.csv";
                break;
            case 5:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Pedidos.csv";
                break;
            case 6:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Detalles_Pedidos.csv";
                break;
            case 7:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Compañias Envíos.csv";
                break;
            default:
                System.out.println("no coincide con ninguno de los casos anteriores");
                break;
        }
        
                
        return CaseDirectorio;
    }
    
    
    
    
    
    
    
    //metodos para contar filas de un archivo
    
    public static int contarFilasEnCSV(String csvFile) 
    {
        int contador = 0;

       
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
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
        
        public void getDescripcionCategoria(String DescripcionCategoria) {
            this.DescripcionCategoria = DescripcionCategoria;
        }
        
        
        
        
        
        
        
        
        @Override
        public String toString() {
        return idCategoria + "; " + NombreCategoria + "; " + DescripcionCategoria;
        }
    
      
    }






    