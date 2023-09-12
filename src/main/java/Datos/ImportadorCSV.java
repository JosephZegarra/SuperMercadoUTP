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
            
        int NumFormulario = consola.nextInt();
        //ingreso de tipo de formulario al contarFilasEnCSV     
        int numFilas = contarFilasEnCSV(NumFormulario);//1: tipo de formulario que se va a contar
        ObjetoCSV[] objetos = new ObjetoCSV[numFilas]; 
        
        
        

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
            int indice = 0;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes usando el delimitador
                String[] partes = line.split(csvDelimiter);

                // Crear un objeto y asignar valores a sus atributos
                ObjetoCSV objeto = new ObjetoCSV();
                objeto.setIdCategoria(partes[0]);
                objeto.setNombreCategoria(partes[1]);
                objeto.setDescripcionCategoria(partes[2]);
                

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
    
    
    
    //metodos para contar filas de un archivo
    
    public static int contarFilasEnCSV(int numDatosFormulario) 
    {
        int contador = 0;
        String CaseDirectorio="";
        
        switch (numDatosFormulario) {
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
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Detalles Pedidos.csv";
                break;
            case 7:
                CaseDirectorio="C:\\Users\\Home\\Downloads\\Compañias Envíos.csv";
                break;
            default:
                System.out.println("no coincide con ninguno de los casos anteriores");
                break;
        }
        

       
        try (BufferedReader br = new BufferedReader(new FileReader(CaseDirectorio))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        return contador;
    }
  
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



class DatosCSVDetallesPedido {
    private String IdPedido;
    private String Producto;
    private String PrecioUnidad;
    private String Cantidad;
    private String Descuento;

    public DatosCSVDetallesPedido() {

    }

    // Getters y setters para los atributos

    public String getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(String IdPedido) {
        this.IdPedido = IdPedido;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

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
        return IdPedido + "; " + Producto + "; " + PrecioUnidad + "; " + Cantidad + "; " + Descuento;
    }
}





    