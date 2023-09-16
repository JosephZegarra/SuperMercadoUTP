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

public class Articulos 
{
    protected String IdProducto;
    protected String NombreProducto;
    protected String Proveedores;
    protected String Categoria;
    protected String CantidadPorUnidad;
    protected String PrecioPorUnidad;
    protected String UnidadesExistentes;
    protected String UnidadesPedidas;
    protected String Suspendido;
    
    
    public Articulos() {

    }

    public Articulos(String IdProducto, String NombreProducto, String Proveedores, String Categoria,
                     String CantidadPorUnidad, String PrecioPorUnidad, String UnidadesExistentes, String UnidadesPedidas,
                     String Suspendido) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.Proveedores = Proveedores;
        this.Categoria = Categoria;
        this.CantidadPorUnidad = CantidadPorUnidad;
        this.PrecioPorUnidad = PrecioPorUnidad;
        this.UnidadesExistentes = UnidadesExistentes;
        this.UnidadesPedidas = UnidadesPedidas;
        this.Suspendido = Suspendido;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getProveedores() {
        return Proveedores;
    }

    public void setProveedores(String Proveedores) {
        this.Proveedores = Proveedores;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCantidadPorUnidad() {
        return CantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String CantidadPorUnidad) {
        this.CantidadPorUnidad = CantidadPorUnidad;
    }

    public String getPrecioPorUnidad() {
        return PrecioPorUnidad;
    }

    public void setPrecioPorUnidad(String PrecioPorUnidad) {
        this.PrecioPorUnidad = PrecioPorUnidad;
    }

    public String getUnidadesExistentes() {
        return UnidadesExistentes;
    }

    public void setUnidadesExistentes(String UnidadesExistentes) {
        this.UnidadesExistentes = UnidadesExistentes;
    }

    public String getUnidadesPedidas() {
        return UnidadesPedidas;
    }

    public void setUnidadesPedidas(String UnidadesPedidas) {
        this.UnidadesPedidas = UnidadesPedidas;
    }

    public String getSuspendido() {
        return Suspendido;
    }

    public void setSuspendido(String Suspendido) {
        this.Suspendido = Suspendido;
    }

    @Override
    public String toString() 
    {
        return IdProducto + "; " + NombreProducto + "; " + Proveedores + "; " + Categoria + "; " + CantidadPorUnidad
                + "; " + PrecioPorUnidad + "; " + UnidadesExistentes + "; " + UnidadesPedidas + "; " + Suspendido;
    }
    
    
    String line;
    String csvDelimitador = ";"; // El delimitador que separa los valores en el CSV
    public void CopiarContenidoEImpresion(String csvFile, int numFilas)
    {  
        Articulos[] listaobjetos = new Articulos[numFilas];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
            {
                int indice = 0;
                
                while ((line = br.readLine()) != null) {
                    // Dividir la línea en partes usando el delimitador
                    String[] partes = line.split(csvDelimitador);

                            Articulos objeto=new Articulos();
                            objeto.setIdProducto(partes[0]);
                            objeto.setNombreProducto(partes[1]);
                            objeto.setProveedores(partes[2]);
                            objeto.setCategoria(partes[3]);
                            objeto.setCantidadPorUnidad(partes[4]);
                            objeto.setPrecioPorUnidad(partes[5]);
                            objeto.setUnidadesExistentes(partes[6]);
                            objeto.setUnidadesPedidas(partes[7]);
                            objeto.setSuspendido(partes[8]);
                            

                    // Agregar el objeto al arreglo
                    listaobjetos[indice] = objeto;
                    indice++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Ahora, objetos contiene todos los objetos creados a partir del archivo CSV
            for (Articulos objeto : listaobjetos) 
            {
                System.out.println(objeto);
            }
    }
    
    
    
    
}
