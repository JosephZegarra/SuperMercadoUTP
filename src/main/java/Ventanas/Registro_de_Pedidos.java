/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;
import ListaEnlazadaGenerica.*;
import Datos.Detalles_Pedidos;
import Datos.Pedidos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.LinkedList;

/*
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDRectangle;
*/
/**
 *
 * @author ROBSKY
 */
public class Registro_de_Pedidos extends javax.swing.JFrame {
    //almacenar los datos
    
     
   DefaultTableModel tablaDetalles;
   //mostrar un diálogo de selección de archivos
   JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
    
   ListaInterfaceGenerica<Detalles_Pedidos> ListaDetallePedidos= new ListaEnlasadaGenericaImpl<Detalles_Pedidos>();
    private void cargarDetallePedidos()
    { 
        try {
            String texto = "";
            //Creación de un arreglo de objetos llamado cabeceras
            Object cabeceras[] = {"Id. de pedido","Producto","Precio por unidad","Cantidad","Descuento"};
            // columnas definidas
            tablaDetalles = new DefaultTableModel(cabeceras,0);
            //Muestra el diálogo de selección de archivos
            archivo.showOpenDialog(this);
            File abrir = archivo.getSelectedFile();
            
            if (abrir != null)
            {
                //abrir el archivo seleccionado
                FileReader fichero = new FileReader(abrir);
                //leer el archivo 
                BufferedReader leer = new BufferedReader(fichero);
                
                while ((texto=leer.readLine()) != null)
                {   
                    Detalles_Pedidos objDetallePedido= new Detalles_Pedidos();
                    // Divide la línea de texto en campos
                    String registro[] = texto.split(";");
                    
                    objDetallePedido.setIdPedido(registro[0]);
                    objDetallePedido.setProducto(registro[1]);
                    objDetallePedido.setPrecioUnidad(registro[2]);
                    objDetallePedido.setCantidad(registro[3]);
                    objDetallePedido.setDescuento(registro[4]);
                    
                    
                    NodoGenerico<Detalles_Pedidos> nuevoNodo = new NodoGenerico<>(objDetallePedido);
                    
                    ListaDetallePedidos.insertarFinal(nuevoNodo);
                    
                    
                    
                    
                }
                
            }
            TablaModeloLinkedListDetallePedido(ListaDetallePedidos);
        } catch (IOException e) 
        {   System.out.println("Error" + e);
        }
                   
    }
    
    public ListaInterfaceGenerica<Detalles_Pedidos> GetListaDetallePedidos()
    {
        return ListaDetallePedidos;
    }
    
    
    
    
    
    
     ListaInterfaceGenerica<Pedidos> ListaPedidos= new ListaEnlasadaGenericaImpl<Pedidos>();
    
    
    private void cargarDatosPedidos()
    {
        
        try {
            String texto = "";
            Object cabeceras[] = {"Id. de pedido","Cliente","Fecha de pedido","Fecha de entrega","Fecha de envío","Forma de envío","Cargo"};
            tablaDetalles = new DefaultTableModel(cabeceras,0);
            archivo.showOpenDialog(this);
            File abrir = archivo.getSelectedFile();
            
            if (abrir != null)
            {
                FileReader fichero = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(fichero);
                
                
                while ((texto=leer.readLine()) != null)
                {
                    String registro[] = texto.split(";");
                    
                    Pedidos ObjPedido= new Pedidos();
                    
                    ObjPedido.setIdPedido(registro[0]);
                    ObjPedido.setCliente(registro[1]);
                    ObjPedido.setFechaPedido(registro[2]);
                    ObjPedido.setFechaEntrega(registro[3]);
                    ObjPedido.setFechaEnvio(registro[4]);
                    ObjPedido.setFormaEnvio(registro[5]);
                    ObjPedido.setCargo(registro[6]);
                    
                    NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(ObjPedido);
                    
                    ListaPedidos.insertarFinal(nuevoNodo);
                    
                    //tablaDetalles.addRow(registro);
                    
                }
                //jTablePedido.setModel(tablaDetalles);
            }
            TablaModeloLinkedListPedidos(ListaPedidos);
        } catch (IOException e) 
        {   System.out.println("Error" + e);
        }
                   
    }
    
     public ListaInterfaceGenerica<Pedidos> GetListaPedidos()
    {
        return ListaPedidos;
    }
     
     
     // EXPORTAR LOS DATOS DE PANTALLA EN ARCHIVO CSV
        
    

    private void exportarDatosPedidosCSV(String archivoSalida) 
    {
    
        TablaModeloLinkedListReinicioPedidos();
        LinkedList<Pedidos> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 2; i <= ListaPedidos.TamanioLista(); i++) 
            {
                
               list.add(ListaPedidos.buscarIteradorIndice(i).getElemento());
                
            }
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTablePedido.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[7];
                row[0] = list.get(i).getIdPedido();
                row[1] = list.get(i).getCliente();
                row[2] = list.get(i).getFechaPedido();
                row[3] = list.get(i).getFechaEntrega();
                row[4] = list.get(i).getFechaEnvio();
                row[5] = list.get(i).getFormaEnvio();
                row[6] = list.get(i).getCargo();
                
                modeloEnlazada.addRow(row);
                
            }
            
            
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(archivoSalida)))) {
            // Escribir encabezados
            for (int i = 0; i < modeloEnlazada.getColumnCount(); i++) {
                writer.write(modeloEnlazada.getColumnName(i));
                if (i < modeloEnlazada.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();

            // Escribir datos
            for (int i = 0; i < modeloEnlazada.getRowCount(); i++) {
                for (int j = 0; j < modeloEnlazada.getColumnCount(); j++) {
                    writer.write(modeloEnlazada.getValueAt(i, j).toString());
                    if (j < modeloEnlazada.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }

            System.out.println("DATOS EXPORTADOS EXITOSAMENTE " + archivoSalida);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    
    }
     
     
     
    
  /*  
    private void exportarDatosPedidosPDF(String archivoSalida) 
    {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Configuración de la tabla
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
            float yPosition = yStart;
            float tableHeight = 300f;
            float rowHeight = 20f;
            float tableBottomMargin = 70f;
            float cellMargin = 5f;

            // Número de columnas
            int cols = 7;
            float colWidth = tableWidth / (float) cols;

            // Crear la tabla
            float yPositionReset = yPosition;
            LinkedList<Pedidos> list = new LinkedList<>();

            // Pasando los valores de nuestra lista enlazada a la LinkedList
            for (int i = 2; i <= ListaPedidos.TamanioLista(); i++) {
                list.add(ListaPedidos.buscarIteradorIndice(i).getElemento());
            }

            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < cols; j++) {
                    String text = "";
                    switch (j) {
                        case 0:
                            text = list.get(i).getIdPedido();
                            break;
                        case 1:
                            text = list.get(i).getCliente();
                            break;
                        case 2:
                            text = list.get(i).getFechaPedido();
                            break;
                        case 3:
                            text = list.get(i).getFechaEntrega();
                            break;
                        case 4:
                            text = list.get(i).getFechaEnvio();
                            break;
                        case 5:
                            text = list.get(i).getFormaEnvio();
                            break;
                        case 6:
                            text = list.get(i).getCargo();
                            break;
                    }
                    contentStream.beginText();
                    contentStream.newLineAtOffset((j * colWidth) + cellMargin, yPosition);
                    contentStream.showText(text);
                    contentStream.endText();
                }
                yPosition -= rowHeight;
                if (yPosition - tableBottomMargin <= 0) {
                    document.addPage(page);
                    contentStream.close();
                    contentStream = new PDPageContentStream(document, page);
                    yPosition = yStart;
                }
            }

            contentStream.close();

            document.save(archivoSalida);
            document.close();

            System.out.println("DATOS EXPORTADOS EXITOSAMENTE a " + archivoSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */
     
   public Registro_de_Pedidos() {
        initComponents();
        
        this.setTitle("Registro de Pedidos");
        this.setLocationRelativeTo(this);
         //getContentPane().setBackground(Color.BLUE);
        
        //String ids [] ={"Id Pedido","Producto","Cantidad","Precio Unidad","Descuento"};
        //tablaDetalles.setColumnIdentifiers(ids);
        //jTableDetalPedido.setModel(tablaDetalles);
        
        
        Pedidos ObjPedido= new Pedidos();
        /*
        ObjPedido.setIdPedido(registro[0]);
        ObjPedido.setCliente(registro[1]);
        ObjPedido.setFechaPedido(registro[2]);
        ObjPedido.setFechaEntrega(registro[3]);
        ObjPedido.setFechaEnvio(registro[4]);
        ObjPedido.setFormaEnvio(registro[5]);
        ObjPedido.setCargo(registro[6]);
        
        NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(ObjPedido);
                    
        ListaPedidos.insertarFinal(nuevoNodo);
        */
        
    }
   
   
   
    
     //-------Implementacion filtro Proveedores-------------------------------------------------------------------
     public void CargandoComboBoxNombreProveedores()
     {
        ListaInterfaceGenerica<Pedidos> listaPedidos = ListarNombresProveedores();

    // Lógica adicional usando la lista de categorías
        for (int i = 1; i <= listaPedidos.TamanioLista(); i++) 
        {
            jCBNombreProveedor.addItem(listaPedidos.buscarIteradorIndice(i).getElemento().getCliente());
            // Tu lógica aquí usando la categoría
            System.out.println("Nombre de Proveedor agregado: " + listaPedidos.buscarIteradorIndice(i).getElemento().getCliente());
        } 
    }  
    
     
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Pedidos> ListarNombresProveedores() {
        ListaInterfaceGenerica<Pedidos> ListaCliente = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaPedidos.TamanioLista(); i++) {
            Pedidos Objarticulo = ListaPedidos.buscarIteradorIndice(i).getElemento();
            String NombreCliente = Objarticulo.getCliente();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(NombreCliente)) {
                System.out.println("No se copió un tipo de categoría");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Pedidos> NodoNuevo = new NodoGenerico<>(Objarticulo);
                ListaCliente.insertarFinal(NodoNuevo);
                categoriasUnicas.add(NombreCliente);
                System.out.println("Se copió un tipo de categoría: " + NombreCliente);
            }
        }

        return ListaCliente;
    }
   //-----------------------------------------------------------------------
   
    //-------Implementacion filtro Proveedores-------------------------------------------------------------------
     public void CargandoComboBoxFormaEnvio()
     {
        ListaInterfaceGenerica<Pedidos> listaPedidos = ListarFormaEnvio();

    // Lógica adicional usando la lista de categorías
        for (int i = 1; i <= listaPedidos.TamanioLista(); i++) 
        {
            jCBFormaEnvio.addItem(listaPedidos.buscarIteradorIndice(i).getElemento().getFormaEnvio());
            // Tu lógica aquí usando la categoría
            System.out.println("Nombre de Proveedor agregado: " + listaPedidos.buscarIteradorIndice(i).getElemento().getCliente());
        } 
    }  
    
     
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Pedidos> ListarFormaEnvio() {
        ListaInterfaceGenerica<Pedidos> ListaFormaEnvio = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaPedidos.TamanioLista(); i++) {
            Pedidos ObjPedido = ListaPedidos.buscarIteradorIndice(i).getElemento();
            String NombreFormaEnvio = ObjPedido.getFormaEnvio();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(NombreFormaEnvio)) {
                System.out.println("No se copió un tipo de FormaEnvio");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Pedidos> NodoNuevo = new NodoGenerico<>(ObjPedido);
                ListaFormaEnvio.insertarFinal(NodoNuevo);
                categoriasUnicas.add(NombreFormaEnvio);
                System.out.println("Se copió un tipo de FormaEnvio: " + NombreFormaEnvio);
            }
        }

        return ListaFormaEnvio;
    }
   //-----------------------------------------------------------------------
   
   //-------------REGISTRO DE PEDIDO NUEVO----------------------------------
   public void RegistrarNuevoPedido()
   {
       Pedidos NuevoObjPedido = new Pedidos();
       //Obteniendo datos de Ventana
        NuevoObjPedido.setIdPedido(jTextIdPedido.getText());
        NuevoObjPedido.setCliente(jCBNombreProveedor.getSelectedItem().toString());
        NuevoObjPedido.setFechaPedido(jTextFechPedido.getText());
        NuevoObjPedido.setFechaEntrega(jTextFechEntrega.getText());
        NuevoObjPedido.setFechaEnvio(jTextFechEnvio.getText());
        NuevoObjPedido.setFormaEnvio(jCBFormaEnvio.getSelectedItem().toString());
        NuevoObjPedido.setCargo(jTextCargo.getText());        
        
        NodoGenerico<Pedidos> NodoNuevo = new NodoGenerico<>(NuevoObjPedido);
        ListaPedidos.insertarFinal(NodoNuevo);
        TablaModeloLinkedListReinicioPedidos();
        TablaModeloLinkedListPedidos(ListaPedidos);
              
             
                    
   }
   //-----------------------------------------------------------------------------------
   
   
   
   
   
   
   
   
   
   
   
   
   //-------Implementacion filtro Detalles Pedidos-------------------------------------------------------------------
   
   
   
     public void CargandoComboBoxNombreProducto()
     {
        ListaInterfaceGenerica<Detalles_Pedidos> listaDetalle = ListarNombresProducto();

    // Lógica adicional usando la lista de categorías
        for (int i = 1; i <= listaDetalle.TamanioLista(); i++) 
        {
            jCBNombreProveedor.addItem(listaDetalle.buscarIteradorIndice(i).getElemento().getProducto());
            // Tu lógica aquí usando la categoría
            System.out.println("Nombre de Proveedor agregado: " + listaDetalle.buscarIteradorIndice(i).getElemento().getProducto());
        } 
    }  
    
     
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Detalles_Pedidos> ListarNombresProducto() {
        ListaInterfaceGenerica<Detalles_Pedidos> ListaCliente = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaDetallePedidos.TamanioLista(); i++) {
            Detalles_Pedidos Objarticulo = ListaDetallePedidos.buscarIteradorIndice(i).getElemento();
            String NombreProducto = Objarticulo.getProducto();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(NombreProducto)) {
                System.out.println("No se copió el producto");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Detalles_Pedidos> NodoNuevo = new NodoGenerico<>(Objarticulo);
                ListaCliente.insertarFinal(NodoNuevo);
                categoriasUnicas.add(NombreProducto);
                System.out.println("Se copió el producto: " + NombreProducto);
            }
        }

        return ListaCliente;
    }
   //-----------------------------------------------------------------------
   
   
   
   
   
   
   
   
   
   
   
   //------------------------------------------------------------------
     public void TablaModeloLinkedListDetallePedido(ListaInterfaceGenerica<Detalles_Pedidos> Lista)
     {
         LinkedList<Detalles_Pedidos> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 1; i <= Lista.TamanioLista(); i++) 
            {
                
               list.add(Lista.buscarIteradorIndice(i).getElemento());
                
            }
         DefaultTableModel modeloEnlazadaDetalle = (DefaultTableModel) jTableDetalPedido.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[5];
                row[0] = list.get(i).getIdPedido();
                row[1] = list.get(i).getProducto();
                row[2] = list.get(i).getPrecioUnidad();
                row[3] = list.get(i).getCantidad();
                row[4] = list.get(i).getDescuento();

                modeloEnlazadaDetalle.addRow(row);
                
            }
         
     }
     
    public void TablaModeloLinkedListReinicioDetallePedido()
     {
         DefaultTableModel modeloEnlazadaDetalle = (DefaultTableModel) jTableDetalPedido.getModel();
         
         modeloEnlazadaDetalle.setRowCount(0);
         
     }
   
   
   
   
   //------------------------------------------------------------------
     public void TablaModeloLinkedListPedidos(ListaInterfaceGenerica<Pedidos> Lista)
     {
         LinkedList<Pedidos> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 1; i <= Lista.TamanioLista(); i++) 
            {
                
               list.add(Lista.buscarIteradorIndice(i).getElemento());
                
            }
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTablePedido.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[7];
                row[0] = list.get(i).getIdPedido();
                row[1] = list.get(i).getCliente();
                row[2] = list.get(i).getFechaPedido();
                row[3] = list.get(i).getFechaEntrega();
                row[4] = list.get(i).getFechaEnvio();
                row[5] = list.get(i).getFormaEnvio();
                row[6] = list.get(i).getCargo();
                
                modeloEnlazada.addRow(row);
                
            }
         
     }
     
    public void TablaModeloLinkedListReinicioPedidos()
     {
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTablePedido.getModel();
         
         modeloEnlazada.setRowCount(0);
         
     }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextIdPedido = new javax.swing.JTextField();
        jTextFechPedido = new javax.swing.JTextField();
        jTextFechEntrega = new javax.swing.JTextField();
        jTextFechEnvio = new javax.swing.JTextField();
        jTextCargo = new javax.swing.JTextField();
        jBtnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalPedido = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        jCBNombreProveedor = new javax.swing.JComboBox<>();
        jCBFormaEnvio = new javax.swing.JComboBox<>();
        jBtnGuardar1 = new javax.swing.JButton();
        jTextDetPrecio = new javax.swing.JTextField();
        jTextDetId = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jBtnAgregarDetalle = new javax.swing.JButton();
        jBtnGuardar2 = new javax.swing.JButton();
        jTextDetDescuento = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jCBProducto = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextDetCantidad = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPrincipal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuPedidos = new javax.swing.JMenuItem();
        jMenuImportar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PEDIDOS.png"))); // NOI18N
        jLabel1.setText("Datos del Pedido");

        jLabel2.setText("Id Pedido :");

        jLabel3.setText("Proveerdor:");

        jLabel4.setText("Fecha de pedido:");

        jLabel5.setText("Fecha de entrega:");

        jLabel6.setText("Fecha de envio:");

        jLabel7.setText("Forma de envio:");

        jLabel20.setText("Cargo:");

        jTextIdPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdPedidoActionPerformed(evt);
            }
        });

        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        jBtnGuardar.setText("Guardar Pedido");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jTableDetalPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Producto", "Producto", "Cantidad", "Precio por unidad", "Descuento"
            }
        ));
        jScrollPane1.setViewportView(jTableDetalPedido);

        jTablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pedido", "Proveedor", "Fecha pedido", "Fecha de entrega", "Fecha de envio", "Forma de envio", "Cargo"
            }
        ));
        jScrollPane2.setViewportView(jTablePedido);

        jCBNombreProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNombreProveedorActionPerformed(evt);
            }
        });

        jBtnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Registrar.png"))); // NOI18N
        jBtnGuardar1.setText("Registrar Pedido");
        jBtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardar1ActionPerformed(evt);
            }
        });

        jLabel28.setText("Id Pedido :");

        jLabel31.setText("Precio por unidad:");

        jBtnAgregarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar-archivo.png"))); // NOI18N
        jBtnAgregarDetalle.setText("Agregar Detalle");
        jBtnAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarDetalleActionPerformed(evt);
            }
        });

        jBtnGuardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        jBtnGuardar2.setText("Guardar Detalle");
        jBtnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardar2ActionPerformed(evt);
            }
        });

        jLabel29.setText("Producto:");

        jLabel32.setText("Descuento:");

        jCBProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProductoActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DETALLE PEDIDO.png"))); // NOI18N
        jLabel27.setText("Detalles del pedido");

        jLabel30.setText("Cantidad:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jButton2.setText("Filtrar");

        jLabel13.setText("ID Pedido :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jButton3.setText("Filtrar");

        jMenuBar1.setBackground(new java.awt.Color(255, 153, 153));

        jMenu1.setText("Archivo");

        jMenuPrincipal.setText("Menu Principal");
        jMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPrincipal);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Importar");

        jMenuPedidos.setText("Importar Pedidos");
        jMenuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPedidosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuPedidos);

        jMenuImportar.setText("Importar Detalle de Pedidos");
        jMenuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImportarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuImportar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFechEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jBtnGuardar1)
                                .addGap(111, 111, 111)
                                .addComponent(jBtnGuardar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFechEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFechPedido)
                                    .addComponent(jCBFormaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextDetId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextDetPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCBProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jTextDetDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextDetCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jBtnAgregarDetalle)
                                .addGap(71, 71, 71)
                                .addComponent(jBtnGuardar2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(405, 405, 405)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(405, 405, 405)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)))
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jTextIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jTextFechEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCBNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFechEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextFechPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jCBFormaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBtnGuardar)
                                    .addComponent(jBtnGuardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addGap(155, 155, 155)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jTextDetId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)
                                    .addComponent(jTextDetCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jTextDetPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCBProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(jTextDetDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnGuardar2)
                            .addComponent(jBtnAgregarDetalle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3))
                                .addGap(72, 72, 72))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipalActionPerformed
        Ventana_Principal principal = new Ventana_Principal();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuPrincipalActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
       /* jTextIdPedido.setText("");
        //jTextProveedor.setText("");
        jTextFechPedido.setText("");
        jTextFechEntrega.setText("");
        jTextFechEnvio.setText("");
        //jTextEnvio.setText("");
        jTextCargo.setText("");
    
    jTextDetId.setText(jTextIdPedido.getText());
    */
       exportarDatosPedidosCSV("PedidosExportado.pdf");
        
    
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jMenuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImportarActionPerformed
        cargarDetallePedidos();
        
        CargandoComboBoxNombreProducto();
        
    }//GEN-LAST:event_jMenuImportarActionPerformed

    private void jBtnAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarDetalleActionPerformed
        tablaDetalles.addRow(new Object[]{jTextDetId.getText(),
            //jTextDetProducto.getText(),
            jTextDetCantidad.getText(),
            jTextDetPrecio.getText(),
            jTextDetDescuento.getText()});
    }//GEN-LAST:event_jBtnAgregarDetalleActionPerformed

    private void jMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPedidosActionPerformed
        cargarDatosPedidos();
        //------Cargando ComboBoxs----------
        CargandoComboBoxNombreProveedores();
        CargandoComboBoxFormaEnvio();
        
    }//GEN-LAST:event_jMenuPedidosActionPerformed

    private void jBtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardar1ActionPerformed
        // TODO add your handling code here:
        RegistrarNuevoPedido();
        
        
    }//GEN-LAST:event_jBtnGuardar1ActionPerformed

    private void jBtnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardar2ActionPerformed

    private void jTextIdPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdPedidoActionPerformed

    private void jCBNombreProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNombreProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBNombreProveedorActionPerformed

    private void jCBProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro_de_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_de_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_de_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_de_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_de_Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregarDetalle;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnGuardar1;
    private javax.swing.JButton jBtnGuardar2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBFormaEnvio;
    private javax.swing.JComboBox<String> jCBNombreProveedor;
    private javax.swing.JComboBox<String> jCBProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuImportar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuPedidos;
    private javax.swing.JMenuItem jMenuPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDetalPedido;
    private javax.swing.JTable jTablePedido;
    private javax.swing.JTextField jTextCargo;
    private javax.swing.JTextField jTextDetCantidad;
    private javax.swing.JTextField jTextDetDescuento;
    private javax.swing.JTextField jTextDetId;
    private javax.swing.JTextField jTextDetPrecio;
    private javax.swing.JTextField jTextFechEntrega;
    private javax.swing.JTextField jTextFechEnvio;
    private javax.swing.JTextField jTextFechPedido;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextIdPedido;
    // End of variables declaration//GEN-END:variables
}
