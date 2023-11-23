/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.LinkedList;
import Datos.Articulos;
import ListaEnlazadaGenerica.*;
import Ventanas.Consulta_de_Articulos;
/**
 *
 * @author Home
 */


public class ArticuloTableModel  extends AbstractTableModel 
{    
    
    private final LinkedList<Articulos> articulos;
    
    private final String[] columnNames = {"Id. de producto","Nombre de producto","PROVEEDORES","Categoría","Cantidad por unidad","Precio por unidad","Unidades en existencia","Unidades pedidas","Suspendido"};

    public ArticuloTableModel(LinkedList<Articulos> articulos) {
        this.articulos = articulos;
    }

    @Override
    public int getRowCount() {
        return articulos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Articulos articulo = articulos.get(row);
        switch (column) {
            case 0:
                return articulo.getIdProducto();
            case 1:
                return articulo.getNombreProducto();
            case 2:
                return articulo.getProveedores();
            case 3:
                return articulo.getCategoria();
            case 4:
                return articulo.getCantidadPorUnidad();
            case 5:
                return articulo.getPrecioPorUnidad();
            case 6:
                return articulo.getUnidadesExistentes();
            case 7:
                return articulo.getUnidadesPedidas(); 
            case 8:
                return articulo.getSuspendido(); 
                
  
            default:
                return null;
        }
    }
    
    
    public class ListaEnlazadaToJTableExample 
    {
        public static void main(String[] args) {
             ListaInterfaceGenerica<Articulos> listaArticulos= new ListaEnlasadaGenericaImpl<Articulos>();
            
            Consulta_de_Articulos ArticulosVista = new Consulta_de_Articulos();
            listaArticulos=ArticulosVista.GetListaArticulos();

            // Paso 1: Crear una instancia de LinkedList
            LinkedList<Articulos> linkedListArticulos = new LinkedList<>();

            // Recorrer y copiar elementos
            NodoGenerico<Articulos> nodoActual = listaArticulos.buscarIteradorIndice(1);
            while (nodoActual != null) {
                linkedListArticulos.add(nodoActual.getElemento());
                //nodoActual = nodoActual.getElemento();
            }
            

           

            // Crear una lista enlazada con algunos datos de ejemplo
            


            // Crear el modelo de tabla con la lista enlazada
            ArticuloTableModel tableModel = new ArticuloTableModel(articulos);

            // Crear el JTable con el modelo
            JTable table = new JTable(tableModel);

            // Mostrar el JFrame con el JTable
            JFrame frame = new JFrame("ListaEnlazadaGenerica to JTable Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    
    
    
    }

}