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
import ListaEnlazadaArticulo.*;
import ListaEnlazadaGenerica.*;
import Datos.Articulos;
import java.util.LinkedList;
import javax.management.modelmbean.ModelMBean;
import javax.swing.text.JTextComponent;
/**
 *
 * @author ROBSKY
 */


public class Consulta_de_Articulos extends javax.swing.JFrame {
    DefaultTableModel tablaDetalles;
    //buscador de archivo para exportar
   JFileChooser archivo = new JFileChooser(System.getProperty("user.dir"));
   
   
   
    
  
   
      //instanciacion de lista enlazada
    ListaInterfaceGenerica<Articulos> ListaArticulos= new ListaEnlasadaGenericaImpl<Articulos>();
    
     private void cargarArticulosListaEnlazada() {
        try {
            String texto = "";
            Object cabeceras[] = {"Id. de producto","Nombre de producto","PROVEEDORES","Categoría","Cantidad por unidad","Precio por unidad","Unidades en existencia","Unidades pedidas","Suspendido"};
            tablaDetalles = new DefaultTableModel(cabeceras,0);
            archivo.showOpenDialog(this);
            File abrir = archivo.getSelectedFile();
            Object[] elemento = new Object[9];
            if (abrir != null){
                
                FileReader fichero = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(fichero);
                //se crea la lista enlazada
                

                while ((texto = leer.readLine()) != null) {
                    String registro[] = texto.split(";");

                    Articulos articulo = new Articulos();
                    
                    articulo.setIdProducto(registro[0]);
                    articulo.setNombreProducto(registro[1]);
                    articulo.setProveedores(registro[2]);
                    articulo.setCategoria(registro[3]);
                    articulo.setCantidadPorUnidad(registro[4]);
                    articulo.setPrecioPorUnidad(registro[5]);
                    articulo.setUnidadesExistentes(registro[6]);
                    articulo.setUnidadesPedidas(registro[7]);
                    articulo.setSuspendido(registro[8]);
                    
                    NodoGenerico<Articulos> nuevoNodo = new NodoGenerico<Articulos>(articulo);
                    
                    ListaArticulos.insertarFinal(nuevoNodo); //se debe crear una lista enlazada para guardar objetos tipo clase Articulos
                    
                    //tablaDetalles.addRow(registro);
                }
                TablaModeloLinkedList(ListaArticulos);

                //jTableAticulos.setModel(tablaDetalles);
            }

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
     
     public ListaInterfaceGenerica<Articulos> GetListaArticulos()
    {
        return ListaArticulos;
    }
     
   
    
     
    
    
     
             
             
  
     
  public void FiltroCategoriaPrueba (String NombreCategoria) 
  {
     ListaInterfaceGenerica<Articulos> ListaFiltroCategoria = new ListaEnlasadaGenericaImpl<>();
    for (int i = 1; i <= ListaArticulos.TamanioLista(); i++) 
      {
              if(ListaArticulos.buscarIteradorIndice(i).getElemento().getCategoria().equalsIgnoreCase(NombreCategoria))
              {
                  NodoGenerico<Articulos> NuevoNodo = null;
                  NuevoNodo.setElemento(ListaArticulos.buscarIteradorIndice(i).getElemento());
                  ListaFiltroCategoria.insertarFinal(NuevoNodo);
                  System.out.print("Filtrado con exito");
               }
              else{
                  System.out.print("Sin coincidencia");
              }

      }

    
    
  }
  
  
  public void FiltroCategoria(String NombreCategoria) {
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


  
  /*
     
     
     ListaInterfaceArticulo ListaFiltroCategoriaArticulo = new ListaEnlasadaArticuloImpl();
     
     
     public void  FiltroCategoriaArticulo()
     {
        int tamanio=ListaArticulos.TamanioLista();
        
        ListaFiltroCategoriaArticulo.insertarFinal(ListaArti.buscarIteradorIndice(1));
        
        int tamanioFiltro=ListaFiltroCategoriaArticulo.TamanioLista();
        for(int i=1; i<=tamanio; i++ )
        {
            Articulos objArticulo = ListaArticulos.buscarIteradorIndice(i).getElemento();
            
            
            boolean Encontrado=false;
            for(int j=1; j<=tamanioFiltro; j++ )
            {
              Articulos ObjArticuloFiltroCategoria=ListaFiltroCategoriaArticulo.buscarIteradorIndice(j).getElemento();
              if(objArticulo.getCategoria() == ObjArticuloFiltroCategoria.getCategoria()) //si el objeto existe en la lista enlazada de filtro no agregar nada y si no existe entonces agregar
              {
                  Encontrado=true;
                  break;
              }
                
            }
            
            Nodo nuevoNodo = null;
            
            if(Encontrado==false)
            {   
                nuevoNodo.setElemento(objArticulo);
                ListaFiltroCategoriaArticulo.insertarFinal(nuevoNodo);
            }
            
            
                    
        }
        
     }
     
     
    public ListaInterfaceArticulo GetListaArticulos()
    {
        return ListaArticulos;
    }
     
    public ListaInterfaceArticulo GetFiltroCategoriaArticulo()
    {
        return ListaFiltroCategoriaArticulo;
    }
     
 */    
    
    
    
    
    Articulos valorActual =new Articulos();
    
    public void Ordenamiento_ShellSort_Nombre(String Tipo) 
    {
        
        int n = ListaArticulos.TamanioLista();
        int incremento = n;

        do {
            incremento = incremento / 2;
            for (int i = incremento; i <= n; i++) {
                NodoGenerico<Articulos> nodoActual = ListaArticulos.buscarIteradorIndice(i);
                if (nodoActual != null) {
                    Articulos valorActual = nodoActual.getElemento();

                    int j = i;
                    while (j >= incremento) {
                        NodoGenerico<Articulos> nodoAnterior = ListaArticulos.buscarIteradorIndice(j - incremento);
                        if (nodoAnterior != null) {
                            Articulos valorAnterior = nodoAnterior.getElemento();
                            
                            if(Tipo.equalsIgnoreCase("Ascendente"))
                            {
                                if (compararAmenorQueBTipo01(valorActual.getNombreProducto(), valorAnterior.getNombreProducto()) ) {
                                        ListaArticulos.buscarIteradorIndice(j).setElemento(valorAnterior);
                                        System.out.print("Valor intercambiado correctamente");
                                        j -= incremento;
                                    } else {
                                        break;  
                                    }
                            }else
                            {
                                if (compararAmenorQueBTipo02(valorActual.getNombreProducto(), valorAnterior.getNombreProducto()) ) {
                                        ListaArticulos.buscarIteradorIndice(j).setElemento(valorAnterior);
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

                    ListaArticulos.buscarIteradorIndice(j).setElemento(valorActual);
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
     public void TablaModeloLinkedList(ListaInterfaceGenerica<Articulos> Lista)
     {
         LinkedList<Articulos> list =new LinkedList<>();
         
         
         //pasando los valores de l¡nuestra lista enlazada a la linkedList
         for (int i = 1; i <= Lista.TamanioLista(); i++) 
            {
                
               list.add(Lista.buscarIteradorIndice(i).getElemento());
                
            }
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTableAticulos.getModel();
         
         
         
          Object[] row;
            for (int i = 0; i < list.size(); i++) {
                row = new Object[8];
                row[0] = list.get(i).getIdProducto();
                row[1] = list.get(i).getNombreProducto();
                row[2] = list.get(i).getProveedores();
                row[3] = list.get(i).getCategoria();
                row[4] = list.get(i).getCantidadPorUnidad();
                row[5] = list.get(i).getPrecioPorUnidad();
                row[6] = list.get(i).getUnidadesExistentes();
                row[7] = list.get(i).getSuspendido();
                modeloEnlazada.addRow(row);
                
            }
         
         
         
     }
     
    public void TablaModeloLinkedListReinicio()
     {
         DefaultTableModel modeloEnlazada = (DefaultTableModel) jTableAticulos.getModel();
         
         modeloEnlazada.setRowCount(0);
         
     }
     
   

    
    
    public Consulta_de_Articulos() {
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
        jTextField1 = new javax.swing.JTextField();
        jTextCategoria = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBoxOrdenamiento = new javax.swing.JComboBox<>();
        jButtonOrdenar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnuItemPrincipal = new javax.swing.JMenuItem();
        jMenuArticulos = new javax.swing.JMenu();
        jMnuArticulos = new javax.swing.JMenuItem();
        jMnuItemCategorias = new javax.swing.JMenuItem();
        jMnuItemProveedores = new javax.swing.JMenuItem();

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

        jBtnFiltrarArticulosCategoria.setText("Filtrar");
        jBtnFiltrarArticulosCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFiltrarArticulosCategoriaActionPerformed(evt);
            }
        });

        jTextCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCategoriaActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
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

        jMnuItemCategorias.setText("Categorias");
        jMnuItemCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemCategoriasActionPerformed(evt);
            }
        });
        jMenuArticulos.add(jMnuItemCategorias);

        jMnuItemProveedores.setText("Proveedores");
        jMnuItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemProveedoresActionPerformed(evt);
            }
        });
        jMenuArticulos.add(jMnuItemProveedores);

        jMenuBar1.add(jMenuArticulos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 311, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnFiltrarArticulosCategoria)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonOrdenar)
                                    .addComponent(jComboBoxOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButtonOrdenar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnFiltrarArticulosCategoria)
                    .addComponent(jComboBoxOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnuItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMnuItemProveedoresActionPerformed

    private void jMnuItemPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemPrincipalActionPerformed
        Ventana_Principal principal = new Ventana_Principal();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMnuItemPrincipalActionPerformed

    private void jMnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuArticulosActionPerformed
        //cargarArticulos();
        cargarArticulosListaEnlazada();
    }//GEN-LAST:event_jMnuArticulosActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBoxOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrdenamientoActionPerformed

    private void jButtonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarActionPerformed
        // TODO add your handling code here:
        
        String Opcion= jComboBoxOrdenamiento.getSelectedItem().toString();
        Ordenamiento_ShellSort_Nombre(Opcion);
        TablaModeloLinkedListReinicio();   
        TablaModeloLinkedList(ListaArticulos);
        
        
        
    }//GEN-LAST:event_jButtonOrdenarActionPerformed

    private void jMnuItemCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemCategoriasActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jMnuItemCategoriasActionPerformed

    private void jTextCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCategoriaActionPerformed

    private void jBtnFiltrarArticulosCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFiltrarArticulosCategoriaActionPerformed
        // TODO add your handling code here:
        
        
       
        TablaModeloLinkedListReinicio();
        FiltroCategoria(jTextCategoria.getText());
        
    }//GEN-LAST:event_jBtnFiltrarArticulosCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta_de_Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
         //Consulta_de_Articulos consultaVista= new Consulta_de_Articulos();
        
         
         
         
         
         
         
        
         
         
         
        
        
        

        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_de_Articulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFiltrarArticulosCategoria;
    private javax.swing.JButton jButtonOrdenar;
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
    private javax.swing.JMenuItem jMnuItemCategorias;
    private javax.swing.JMenuItem jMnuItemPrincipal;
    private javax.swing.JMenuItem jMnuItemProveedores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAticulos;
    private javax.swing.JTextField jTextCategoria;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
