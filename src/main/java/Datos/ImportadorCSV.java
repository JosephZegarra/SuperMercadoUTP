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

/**5
 * 
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
                objArticulos.setNumFilas(numFilas);
                objArticulos.setCsvFile(csvFile);
                
                objArticulos.CopiarContenidoEImpresion(csvFile, numFilas);
                objArticulos.copiarArregloAListaEnlazada();
                objArticulos.imprimir();
                break;
            case 3://..
                 Proveedores objProveedores= new Proveedores();
                 objProveedores.CopiarContenidoEImpresion(csvFile, numFilas);
                
            case 4:
                Clientes objClientes= new Clientes();
                objClientes.CopiarContenidoEImpresion(csvFile, numFilas);
                break;
            case 5:
                
                Pedidos objPedidos= new Pedidos();
                
                objPedidos.setNumFilas(numFilas);
                objPedidos.setCsvFile(csvFile);
                
                objPedidos.CopiarContenidoEImpresion(csvFile, numFilas);
                objPedidos.copiarArregloAListaEnlazada();
                objPedidos.imprimir();
                break;
            case 6:
                Detalles_Pedidos objDetalles_Pedidos= new Detalles_Pedidos();
                objDetalles_Pedidos.setNumFilas(numFilas);
                objDetalles_Pedidos.setCsvFile(csvFile);
                
                objDetalles_Pedidos.CopiarContenidoEImpresion(csvFile, numFilas);
                objDetalles_Pedidos.copiarArregloAListaEnlazada();
                objDetalles_Pedidos.imprimir();
                
               
                break;
            case 7:
                CompaniasEnvios objCompania= new CompaniasEnvios();
                objCompania.CopiarContenidoEImpresion(csvFile, numFilas);
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
                CaseDirectorio="D:\\Categorias.csv";
                break;
            case 2:
                CaseDirectorio="D:\\Articulos.csv";
                break;
            case 3:
               CaseDirectorio="D:\\Proveedores.csv";
                break;
            case 4:
                CaseDirectorio="D:\\Clientes.csv";
                break;
            case 5:
                CaseDirectorio="D:\\Pedidos.csv";
                break;
            case 6:
                CaseDirectorio="D:\\Detalles_Pedidos.csv";
                break;
            case 7:
                CaseDirectorio="D:\\CompaniasEnvios.csv";
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