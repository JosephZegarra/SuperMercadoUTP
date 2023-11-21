
package Pruebas;

import Ventanas.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;
import Datos.*;

/**
 *
 * @author ROBSKY
 */
public class Registro_de_Pedidos extends javax.swing.JFrame {
    //almacenar los datos
    
   //COMETARIOOOOOO SEBAS
   DefaultTableModel tablaDetalles;
   
    ListaInterfaceGenerica<Pedidos> listaPedidos = new ListaEnlazadaGenerica<Pedidos>();
    ListaInterfaceGenerica<Detalles_Pedidos> detallePedidos = new ListaEnlazadaGenerica<Detalles_Pedidos>();
    
   //mostrar un diálogo de selección de archivos
   JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
    
   private void cargarDetallePedidos() {
    try {
        String texto = "";
        Object cabeceras[] = {"Id. de pedido","Producto","Precio por unidad","Cantidad","Descuento"};
        tablaDetalles = new DefaultTableModel(cabeceras, 0);

        archivo.showOpenDialog(this);
        File abrir = archivo.getSelectedFile();

        if (abrir != null) {
            FileReader fichero = new FileReader(abrir);
            BufferedReader leer = new BufferedReader(fichero);

            while ((texto = leer.readLine()) != null) {
                String registro[] = texto.split(";");
                Detalles_Pedidos detalleP = new Detalles_Pedidos(registro[0], registro[1], registro[2], registro[3], registro[4]);

                // Crear un nuevo nodo con el pedido
                NodoGenerico<Detalles_Pedidos> nuevoNodo = new NodoGenerico<>(detalleP);

                // Insertar el nodo en la lista enlazada
                detallePedidos.insertarFinal(nuevoNodo);

                // Agregar una nueva fila a la tabla
                
                registro[0] = detalleP.getIdPedido();
                registro[1] = detalleP.getProducto();
                registro[2] = detalleP.getPrecioUnidad();
                registro[3] = detalleP.getCantidad();
                registro[4] = detalleP.getDescuento(); 

                tablaDetalles.addRow(registro);
            }
            jTableDetalPedido.setModel(tablaDetalles);
        }
    } catch (IOException e) {
        System.out.println("Error: " + e);
    }
}
   
   
    /*private void cargarDetallePedidos()
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
            Object[] elemento = new Object[5];
            if (abrir != null)
            {
                //abrir el archivo seleccionado
                FileReader fichero = new FileReader(abrir);
                //leer el archivo 
                BufferedReader leer = new BufferedReader(fichero);
                
                while ((texto=leer.readLine()) != null)
                {
                    // Divide la línea de texto en campos
                    String registro[] = texto.split(";");
                    elemento[0] = registro[0];
                    elemento[1] = registro[1];
                    elemento[2] = registro[2];
                    elemento[3] = registro[3];
                    elemento[4] = registro[4];
                    tablaDetalles.addRow(elemento);
                    
                }
                jTableDetalPedido.setModel(tablaDetalles);
            }
        } catch (IOException e) 
        {   System.out.println("Error" + e);
        }
                   
    }*/
    
    
    
    private void cargarDatosPedidos() {
    try {
        String texto = "";
        Object cabeceras[] = {"Id. de pedido", "Cliente", "Fecha de pedido", "Fecha de entrega", "Fecha de envío", "Forma de envío", "Cargo"};
        tablaDetalles = new DefaultTableModel(cabeceras, 0);

        archivo.showOpenDialog(this);
        File abrir = archivo.getSelectedFile();

        if (abrir != null) {
            FileReader fichero = new FileReader(abrir);
            BufferedReader leer = new BufferedReader(fichero);

            while ((texto = leer.readLine()) != null) {
                String registro[] = texto.split(";");
                Pedidos pedido = new Pedidos(registro[0], registro[1], registro[2], registro[3], registro[4], registro[5], registro[6]);

                // Crear un nuevo nodo con el pedido
                NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<>(pedido);

                // Insertar el nodo en la lista enlazada
                listaPedidos.insertarFinal(nuevoNodo);

                // Agregar una nueva fila a la tabla
                
                registro[0] = pedido.getIdPedido();
                registro[1] = pedido.getCliente();
                registro[2] = pedido.getFechaPedido();
                registro[3] = pedido.getFechaEntrega();
                registro[4] = pedido.getFechaEnvio();
                registro[5] = pedido.getFormaEnvio();
                registro[6] = pedido.getCargo();

                tablaDetalles.addRow(registro);
            }
            jTablePedido.setModel(tablaDetalles);
        }
    } catch (IOException e) {
        System.out.println("Error: " + e);
    }
}
       
    /*private void cargarDatosPedidos()
    {
        
        try {
            String texto = "";
            Object cabeceras[] = {"Id. de pedido","Cliente","Fecha de pedido","Fecha de entrega","Fecha de envío","Forma de envío","Cargo"};
            tablaDetalles = new DefaultTableModel(cabeceras,0);
            archivo.showOpenDialog(this);
            File abrir = archivo.getSelectedFile();
            Object[] elemento = new Object[7];
            if (abrir != null)
            {
                FileReader fichero = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(fichero);
                
                
                while ((texto=leer.readLine()) != null)
                {
                    String registro[] = texto.split(";");
                    elemento[0] = registro[0];
                    elemento[1] = registro[1];
                    elemento[2] = registro[2];
                    elemento[3] = registro[3];
                    elemento[4] = registro[4];
                    elemento[5] = registro[5];
                    elemento[6] = registro[6];
                    
                    tablaDetalles.addRow(elemento);
                    
                }
                jTablePedido.setModel(tablaDetalles);
            }
        } catch (IOException e) 
        {   System.out.println("Error" + e);
        }
                   
    }*/
   public Registro_de_Pedidos() {
        initComponents();
        
        this.setTitle("Registro de Pedidos");
        this.setLocationRelativeTo(this);
         //getContentPane().setBackground(Color.BLUE);
        
        //String ids [] ={"Id Pedido","Producto","Cantidad","Precio Unidad","Descuento"};
        //tablaDetalles.setColumnIdentifiers(ids);
        //jTableDetalPedido.setModel(tablaDetalles);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
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
        jComboProveedor = new javax.swing.JComboBox<>();
        jComboEnvio = new javax.swing.JComboBox<>();
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
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextDetCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Pedido", "Proveedor", "Fecha pedido", "Fecha de entrega", "Fecha de envio", "Forma de envio", "Cargo"
            }
        ));
        jScrollPane2.setViewportView(jTablePedido);

        jComboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboEnvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBtnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Registrar.png"))); // NOI18N
        jBtnGuardar1.setText("Registrar Pedido");
        jBtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardar1ActionPerformed(evt);
            }
        });

        jTextDetId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDetIdActionPerformed(evt);
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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DETALLE PEDIDO.png"))); // NOI18N
        jLabel27.setText("Detalles del pedido");

        jLabel30.setText("Cantidad:");

        jLabel9.setText("Fecha de pedido :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jButton1.setText("Filtrar");

        jLabel12.setText("ID Pedido :");

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
                                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFechEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton2))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
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
                                    .addComponent(jComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFechEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFechPedido)
                                    .addComponent(jComboEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(405, 405, 405)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jBtnAgregarDetalle)
                                .addGap(71, 71, 71)
                                .addComponent(jBtnGuardar2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(405, 405, 405)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)))
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
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jTextFechEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFechEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextFechPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jComboEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jTextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBtnGuardar)
                                    .addComponent(jBtnGuardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addGap(17, 17, 17)
                                .addComponent(jLabel9)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(77, 77, 77)))
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
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(jTextDetDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jMenuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImportarActionPerformed
        cargarDetallePedidos();
    
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
    }//GEN-LAST:event_jMenuPedidosActionPerformed

    private void jBtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardar1ActionPerformed
        
        
        
        
        
        
        jTextDetId.setText(jTextId.getText());
        
        jTextId.setText("");
        jComboProveedor.setSelectedItem("" );
        jTextFechPedido.setText("");
        jTextFechEntrega.setText("");
        jTextFechEnvio.setText("");
        jComboEnvio.setSelectedItem("");
        jTextCargo.setText("");   
    }//GEN-LAST:event_jBtnGuardar1ActionPerformed

    private void jBtnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardar2ActionPerformed

    private void jTextDetIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDetIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDetIdActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboEnvio;
    private javax.swing.JComboBox<String> jComboProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuImportar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuPedidos;
    private javax.swing.JMenuItem jMenuPrincipal;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextId;
    // End of variables declaration//GEN-END:variables
}
