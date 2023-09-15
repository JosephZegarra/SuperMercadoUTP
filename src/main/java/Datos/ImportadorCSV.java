/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import Datos.*;
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
            case 1: //Instancia del primer objeto
                
                
                break;
            case 2:
                
                break;
            case 3:
               
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                Detalles_Pedidos objDetalles_Pedidos= new Detalles_Pedidos();
                objDetalles_Pedidos.CopiarContenidoEImpresion(csvFile, numFilas);
                break;
            case 7:
                
                break;
            default:
                System.out.println("no coincide con ninguno de los casos anteriores");
                break;
        }
        
        
        
        
       // ObjetoCSV[] objetos = new ObjetoCSV[numFilas]; //en este arreglo de objetos se guardaran los objetos(fila de datos)que se lean del archivo csv 
        
        
        
        
        
        
        
/*
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
            int indice = 0;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes usando el delimitador
                String[] partes = line.split(csvDelimitador);
                

                // Crear un objeto y asignar valores a sus atributos
               /* 

                ObjetoCSV objeto = new ObjetoCSV();
                objeto.setIdCategoria(partes[0]);
                objeto.setNombreCategoria(partes[1]);
                objeto.setDescripcionCategoria(partes[2]); 
                
               
                //case
                switch (numDirectorio) 
                {
                    case 1:
                        ObjetoCSV objeto = new ObjetoCSV();
                        objeto.setIdCategoria(partes[0]);
                        objeto.setNombreCategoria(partes[1]);
                        objeto.setDescripcionCategoria(partes[2]);
                        break;
                    case 2:

                        DatosCSVDetallesPedido objeto=new DatosCSVDetallesPedido();
                        objeto.setIdPedido(partes[0]);
                        objeto.setProducto(partes[1]);
                        objeto.setPrecioUnidad(partes[2]);
                        objeto.setCantidad(partes[3]);
                        objeto.setDescuento(partes[4]);

                    case 3:
                        // Código para la opción 3
                        break;
                    case 4:
                        // Código para la opción 4
                        break;
                    case 5:
                        // Código para la opción 5
                        break;
                    case 6:
                        // Código para la opción 6
                        break;
                    case 7:
                        // Código para la opción 7
                        break;
                    default:
                        // Código para el caso por defecto (si no coincide con ninguno de los casos anteriores)
                        break;
                }
        

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
 */       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
        
        /*
        String CaseDirectorio="";
        
        switch (numDatosFormulario) {
            case 1:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Categorias.csv";
                break;
            case 2:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Detalles_Pedidos.csv";
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
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Detalles Pedidos.csv";
                break;
            case 7:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Compañias Envíos.csv";
                break;
            default:
                System.out.println("no coincide con ninguno de los casos anteriores");
                break;
        }
        

        */
        
       
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        return contador;
        
    }
    
    
    /*
    //metodo que cree objetos segun el directorio seleccionado
    public static objeto CreadorDeObjetosVarios(int numDirectorio, String[] partes)
    {   
        
        switch(numDirectorio) 
        {
            case 1:
                        ObjetoCSV objeto = new ObjetoCSV();
                        objeto.setIdCategoria(partes[0]);
                        objeto.setNombreCategoria(partes[1]);
                        objeto.setDescripcionCategoria(partes[2]);
                        return objeto;
                        break;
                    case 2:

                        DatosCSVDetallesPedido objeto=new DatosCSVDetallesPedido();
                        objeto.setIdPedido(partes[0]);
                        objeto.setProducto(partes[1]);
                        objeto.setPrecioUnidad(partes[2]);
                        objeto.setCantidad(partes[3]);
                        objeto.setDescuento(partes[4]);
                        return objeto;
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
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Detalles Pedidos.csv";
                break;
            case 7:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Compañias Envíos.csv";
                break;
            default:
                System.out.println("no coincide con ninguno de los casos anteriores");
                break;
        }
        
                
        
    }
    
    */
  
    /*
    public static int contarFilasEnCSV(String archivoCSV) {
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
    */
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






    