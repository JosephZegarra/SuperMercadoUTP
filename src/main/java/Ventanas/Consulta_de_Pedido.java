/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import ListaEnlazadaGenerica.*;
import Datos.Pedidos;
import java.util.LinkedList;
import javax.management.modelmbean.ModelMBean;
import javax.swing.text.JTextComponent;
import java.util.HashSet;
import javax.swing.text.TableView;
/**
 *
 * @author ROBSKY
 */


public class Consulta_de_Pedido extends javax.swing.JFrame {
    DefaultTableModel tablaDetalles;
    //buscador de archivo para exportar
   JFileChooser archivo = new JFileChooser(System.getProperty("user.dire"));
   
   
   
    
  
   
     //instanciacion de lista enlazada
    ListaInterfaceGenerica<Pedidos> ListaPedidos= new ListaEnlasadaGenericaImpl<Pedidos>();
    
     private void cargarArticulosListaEnlazada() {
        try {
            String texto = "";
            Object cabeceras[] = {"Id. de pedido","Cliente/Proveedor","Fecha de pedido","Fecha de entrega","Fecha de envio","Forma de envio","Cargo"};
            tablaDetalles = new DefaultTableModel(cabeceras,0);
            archivo.showOpenDialog(this);
            File abrir = archivo.getSelectedFile();
            Object[] elemento = new Object[7];
            if (abrir != null){
                
                FileReader fichero = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(fichero);
                //se crea la lista enlazada
                

                while ((texto = leer.readLine()) != null) {
                    String registro[] = texto.split(";");

                    Pedidos articulo = new Pedidos();
                    
                    articulo.setIdPedido(registro[0]);
                    articulo.setCliente(registro[1]);
                    articulo.setFechaPedido(registro[2]);
                    articulo.setFechaEntrega(registro[3]);
                    articulo.setFechaEnvio(registro[4]);
                    articulo.setFormaEnvio(registro[5]);
                    articulo.setCargo(registro[6]);
   
                    NodoGenerico<Pedidos> nuevoNodo = new NodoGenerico<Pedidos>(articulo);
                    
                    ListaPedidos.insertarFinal(nuevoNodo); //se debe crear una lista enlazada para guardar objetos tipo clase Articulos
                    
                    //tablaDetalles.addRow(registro);
                }
                TablaModeloLinkedList(ListaPedidos);

                //jTableAticulos.setModel(tablaDetalles);
            }

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
     
     public ListaInterfaceGenerica<Pedidos> GetListaArticulos()
    {
        return ListaPedidos;
    }
     
     
     
     /*
     
     public void CargandoListaFiltroCategoria()
     {
        ListaInterfaceGenerica<Articulos> listaCategorias = ListarNombresCategoria();

    // Lógica adicional usando la lista de categorías
        for (int i = 1; i <= listaCategorias.TamanioLista(); i++) 
        {
            jCBNombreCategoria.addItem(listaCategorias.buscarIteradorIndice(i).getElemento().getCategoria());
            // Tu lógica aquí usando la categoría
            System.out.println("Categoría añadida: " + listaCategorias.buscarIteradorIndice(i).getElemento().getCategoria());
        } 
    }  
    
     public void CargandoBusquedaBinariaNombres()
     {
         TablaModeloLinkedList(AsignacionObjBusquedaBinariaAListaEnlazada());
       
     }
     
     
    
  
  //Busqueda binaria por nombre y asignacion de objeto a lista enlazada
    public ListaInterfaceGenerica AsignacionObjBusquedaBinariaAListaEnlazada()
    {
       ListaInterfaceGenerica<Articulos> ListaBusquedaBinariaNombreProducto = new ListaEnlasadaGenericaImpl<>();
        NodoGenerico<Articulos> NodoBusquedaProducto = new NodoGenerico<Articulos>(busquedaBinaria(jTextNombreArticulo.getText()));
        ListaBusquedaBinariaNombreProducto.insertarFinal(NodoBusquedaProducto);
        return ListaBusquedaBinariaNombreProducto;
    }
     
    
    
    public Articulos busquedaBinaria(String nombreProducto) 
    {
        Ordenamiento_ShellSort_Nombre("Ascendente");
        int inicio = 1;
        int fin = ListaArticulos.TamanioLista() ;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            NodoGenerico<Articulos> nodoMedio = ListaArticulos.buscarIteradorIndice(medio + 1); // Sumamos 1 para ajustarnos al índice de la lista

            Articulos articuloMedio = nodoMedio.getElemento();
            String nombreMedio = articuloMedio.getNombreProducto();

            int comparacion = nombreMedio.compareToIgnoreCase(nombreProducto);

            if (comparacion == 0) {
                return articuloMedio; // Se encontró el artículo
            } else if (comparacion < 0) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }

        return null; // No se encontró el artículo
        
    }
   
    
   
    
    
    
    
    
  
  public void FiltroCategoria(String NombreCategoria) 
  {
    ListaInterfaceGenerica<Articulos> ListaFiltroCategoria = new ListaEnlasadaGenericaImpl<>();
    for (int i = 1; i <= ListaArticulos.TamanioLista(); i++) {
        Articulos articulo = ListaArticulos.buscarIteradorIndice(i).getElemento();

        if (articulo.getCategoria().equalsIgnoreCase(NombreCategoria)) {
            NodoGenerico<Articulos> nuevoNodo = new NodoGenerico<>(articulo);
            ListaFiltroCategoria.insertarFinal(nuevoNodo);
            System.out.println("Filtrado con éxito: " + articulo.getNombreProducto());
        } else {
            System.out.println("Sin coincidencia: " + articulo.getNombreProducto());
        }
        
    }
    TablaModeloLinkedList(ListaFiltroCategoria);
    
}
  
 */ 


  
  
    
    Pedidos valorActual =new Pedidos();
    
    public void Ordenamiento_ShellSort_Nombre(String Tipo) 
    {
        
        int n = ListaPedidos.TamanioLista();
        int incremento = n;

        do {
            incremento = incremento / 2;
            for (int i = incremento; i <= n; i++) {
                NodoGenerico<Pedidos> nodoActual = ListaPedidos.buscarIteradorIndice(i);
                if (nodoActual != null) {
                    Pedidos valorActual = nodoActual.getElemento();

                    int j = i;
                    while (j >= incremento) {
                        NodoGenerico<Pedidos> nodoAnterior = ListaPedidos.buscarIteradorIndice(j - incremento);
                        if (nodoAnterior != null) {
                            Pedidos valorAnterior = nodoAnterior.getElemento();
                           
                            if(Tipo.equalsIgnoreCase("Ascendente"))
                            {
                                if (compararAmenorQueBTipo01(valorActual.getCliente(), valorAnterior.getCliente()) ) {
                                        ListaPedidos.buscarIteradorIndice(j).setElemento(valorAnterior);
                                        System.out.print("Valor intercambiado correctamente");
                                        j -= incremento;
                                    } else {
                                        break;  
                                    }
                            }else
                            {
                                if (compararAmenorQueBTipo02(valorActual.getCliente(), valorAnterior.getCliente()) ) {
                                        ListaPedidos.buscarIteradorIndice(j).setElemento(valorAnterior);
                                        System.out.print("Valor intercambiado correctamente");
                                        j -= incremento;
                                    } else {
                                        break;  
                                    }
                            }
                           
                           
                              
                                    
                            
                        } else {
                            break;
                        }
                    }

                    ListaPedidos.buscarIteradorIndice(j).setElemento(valorActual);
                }
            }
        } while (incremento > 1);
        
        
        
        
    }    
    
    //orden ascendente

   public boolean compararAmenorQueBTipo01(String a, String b) 
   {
    // Comparar los Strings directamente
    return a.compareTo(b) < 0;
    }
   public boolean compararAmenorQueBTipo02(String a, String b) 
   {
    // Comparar los Strings directamente
    return a.compareTo(b) > 0;
    }
     
   
   
 
     //------------------------------------------------------------------
     public void TablaModeloLinkedList(ListaInterfaceGenerica<Pedidos> Lista)
     {
         LinkedList<Pedidos> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 1; i <= Lista.TamanioLista(); i++) 
            {
                
               list.add(Lista.buscarIteradorIndice(i).getElemento());
                
            }
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTableAticulos.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[8];
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
     
    public void TablaModeloLinkedListReinicio()
     {
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTableAticulos.getModel();
         
         modeloEnlazada.setRowCount(0);
         
     }
     
    
    
    /*
    //Filtrando Categorias de Articulo sin repetir el mismo nombre de Categorias a una lista enlazada  ListaCategoria
    public ListaInterfaceGenerica<Articulos> ListarNombresCategoria() {
        ListaInterfaceGenerica<Articulos> ListaCategoria = new ListaEnlasadaGenericaImpl<>();
        HashSet<String> categoriasUnicas = new HashSet<>();

        for (int i = 1; i <= ListaArticulos.TamanioLista(); i++) {
            Articulos Objarticulo = ListaArticulos.buscarIteradorIndice(i).getElemento();
            String categoriaActual = Objarticulo.getCategoria();

            // Verificar si la categoría ya está en el conjunto
            if (categoriasUnicas.contains(categoriaActual)) {
                System.out.println("No se copió un tipo de categoría");
            } else {
                // Agregar el objeto a ListaCategoria y actualizar el conjunto
                NodoGenerico<Articulos> NodoNuevo = new NodoGenerico<>(Objarticulo);
                ListaCategoria.insertarFinal(NodoNuevo);
                categoriasUnicas.add(categoriaActual);
                System.out.println("Se copió un tipo de categoría: " + categoriaActual);
            }
        }

        return ListaCategoria;
    }

   
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    public Consulta_de_Pedido() {
        initComponents();
        this.setTitle(" Consulta de Artículos");
        this.setLocationRelativeTo(this);
         
    }
    
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAticulos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jBtnFiltrarArticulosCategoria = new javax.swing.JButton();
        jTextNombreArticulo = new javax.swing.JTextField();
        jTextCategoria = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBoxOrdenamiento = new javax.swing.JComboBox<>();
        jButtonOrdenar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCBNombreCategoria = new javax.swing.JComboBox<>();
        jCBProveedores = new javax.swing.JComboBox<>();
        jCBEstado = new javax.swing.JComboBox<>();
        jBotonBuscarNombreArticulo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnuItemPrincipal = new javax.swing.JMenuItem();
        jMenuArticulos = new javax.swing.JMenu();
        jMnuArticulos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Multiconsulta de Articulos");

        jLabel7.setText("Nombre del Articulo:");

        jTableAticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. de producto", "Articulo de producto", "Proveedores", "Categoria", "Cantidad por unidad", "Precio unitario", "Unidades en existencia", "Unidades pedidas", "Suspendido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAticulos);

        jLabel8.setText("Precio del Artículo:");

        jLabel9.setText("Nombre del Proveedor");

        jLabel10.setText("Nombre de la Categoria:");

        jBtnFiltrarArticulosCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jBtnFiltrarArticulosCategoria.setText("Filtro Categoria");
        jBtnFiltrarArticulosCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFiltrarArticulosCategoriaActionPerformed(evt);
            }
        });

        jTextNombreArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreArticuloActionPerformed(evt);
            }
        });

        jTextCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCategoriaActionPerformed(evt);
            }
        });

        jComboBoxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        jComboBoxOrdenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenamientoActionPerformed(evt);
            }
        });

        jButtonOrdenar.setText("Ordenar");
        jButtonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jButton1.setText("Filtro Proveedores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filtrar.png"))); // NOI18N
        jButton2.setText("Filtro Estado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCBNombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNombreCategoriaActionPerformed(evt);
            }
        });

        jBotonBuscarNombreArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LupaDeBuscador.png"))); // NOI18N
        jBotonBuscarNombreArticulo.setText("Buscar Nombre");
        jBotonBuscarNombreArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonBuscarNombreArticuloActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMnuItemPrincipal.setText("Menu Principal");
        jMnuItemPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuItemPrincipal);

        jMenuBar1.add(jMenu1);

        jMenuArticulos.setText("Importar");

        jMnuArticulos.setText("Articulos");
        jMnuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuArticulosActionPerformed(evt);
            }
        });
        jMenuArticulos.add(jMnuArticulos);

        jMenuBar1.add(jMenuArticulos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBotonBuscarNombreArticulo))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonOrdenar)
                                    .addComponent(jComboBoxOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jBtnFiltrarArticulosCategoria))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jCBNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCBEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBotonBuscarNombreArticulo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnFiltrarArticulosCategoria)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnuItemPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemPrincipalActionPerformed
        Ventana_Principal principal = new Ventana_Principal();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMnuItemPrincipalActionPerformed

    private void jMnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuArticulosActionPerformed
        //cargarArticulos();
        cargarArticulosListaEnlazada();
        
        //cargando lista de Filtros en combobox
       // CargandoListaFiltroCategoria();
        
        
    }//GEN-LAST:event_jMnuArticulosActionPerformed

    private void jComboBoxOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrdenamientoActionPerformed

    private void jButtonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarActionPerformed
        // TODO add your handling code here:
        
        String Opcion= jComboBoxOrdenamiento.getSelectedItem().toString();
        Ordenamiento_ShellSort_Nombre(Opcion);
        TablaModeloLinkedListReinicio();   
        TablaModeloLinkedList(ListaPedidos);
        
        
        
    }//GEN-LAST:event_jButtonOrdenarActionPerformed

    private void jTextCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCategoriaActionPerformed

    private void jBtnFiltrarArticulosCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFiltrarArticulosCategoriaActionPerformed
        // TODO add your handling code here:
        
        
       
        TablaModeloLinkedListReinicio();
        
        //FiltroCategoria(jTextCategoria.getText());
       // FiltroCategoria(jCBNombreCategoria.getSelectedItem().toString());
        
    }//GEN-LAST:event_jBtnFiltrarArticulosCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCBNombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNombreCategoriaActionPerformed
        // TODO add your handling code here:
        //forma para adquirir la lista enlazada que devuelve ListarNombresCategoria();
      
        
        
    }//GEN-LAST:event_jCBNombreCategoriaActionPerformed

    private void jTextNombreArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreArticuloActionPerformed

    private void jBotonBuscarNombreArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonBuscarNombreArticuloActionPerformed
        // TODO add your handling code here:
     TablaModeloLinkedListReinicio();
     //CargandoBusquedaBinariaNombres();
    }//GEN-LAST:event_jBotonBuscarNombreArticuloActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
         //Consulta_de_Articulos consultaVista= new Consulta_de_Articulos();
        //</editor-fold>
        //</editor-fold>
        
         //Consulta_de_Articulos consultaVista= new Consulta_de_Articulos();
        
         
         
         
         
         
         
        
         
         
         
        
        
        

        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_de_Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonBuscarNombreArticulo;
    private javax.swing.JButton jBtnFiltrarArticulosCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonOrdenar;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JComboBox<String> jCBNombreCategoria;
    private javax.swing.JComboBox<String> jCBProveedores;
    private javax.swing.JComboBox<String> jComboBoxOrdenamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuArticulos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnuArticulos;
    private javax.swing.JMenuItem jMnuItemPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAticulos;
    private javax.swing.JTextField jTextCategoria;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextNombreArticulo;
    // End of variables declaration//GEN-END:variables
}
