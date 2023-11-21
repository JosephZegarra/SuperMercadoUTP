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

/*
public class ArticuloTableModel 
{
    private final LinkedList<Articulo> articulos;
    private final String[] columnNames = {"Nombre", "Precio"};

    public ArticuloTableModel(LinkedList<Articulo> articulos) {
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
        Articulo articulo = articulos.get(row);
        switch (column) {
            case 0:
                return articulo.getNombre();
            case 1:
                return articulo.getPrecio();
            // Agregar más casos según sea necesario para otras columnas
            default:
                return null;
        }
    }
    
    
    public class ListaEnlazadaToJTableExample {
    public static void main(String[] args) {
        
        ListaInterfaceGenerica<Articulos> listaArticulos= new ListaEnlasadaGenericaImpl<Articulos>();
        
        
        // Crear una lista enlazada con algunos datos de ejemplo
        Consulta_de_Articulos ArticulosVista = new Consulta_de_Articulos();
        listaArticulos=ArticulosVista.GetListaArticulos();
        

        // Crear el modelo de tabla con la lista enlazada
        ArticuloTableModel tableModel = new ArticuloTableModel(listaArticulos.convertirALista());

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

*/