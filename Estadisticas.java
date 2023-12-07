package Ventanas;

import Datos.*;
import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.text.html.HTML;


public class Estadisticas extends javax.swing.JFrame 
{
    DefaultTableModel tablaDetalles;
    private DefaultTableModel modeloTabla;
    
    public Estadisticas () {
        initComponents();

        this.setTitle("Formulario de Estadisticas");
        this.setLocationRelativeTo(this);

        // Inicializar el modelo de la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ITEM 1");
        modeloTabla.addColumn("ITEM 2");
        modeloTabla.addColumn("ITEM 3");

        jTable1.setModel(modeloTabla);
    } 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMnuItemPrincipal = new javax.swing.JMenuItem();
        jMenuTipoEstadistica = new javax.swing.JMenu();
        jMnuItemA = new javax.swing.JMenuItem();
        jMnuItemB = new javax.swing.JMenuItem();
        jMnuItemC = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnExportar.setText("Exportar");
        jBtnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExportarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Resultados de la filtración de datos");

        jMenuArchivo.setText("Archivo");

        jMnuItemPrincipal.setText("Menu Principal");
        jMnuItemPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemPrincipalActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMnuItemPrincipal);

        jMenuBar1.add(jMenuArchivo);

        jMenuTipoEstadistica.setText("Tipo de Estadistica");

        jMnuItemA.setText("Cantidad de pedidos agrupados por pais y por Proveedores");
        jMnuItemA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemAActionPerformed(evt);
            }
        });
        jMenuTipoEstadistica.add(jMnuItemA);

        jMnuItemB.setText("Cantidades y montos de Pedidos agrupados por proveedor, Año, Mes.");
        jMnuItemB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemBActionPerformed(evt);
            }
        });
        jMenuTipoEstadistica.add(jMnuItemB);

        jMnuItemC.setText("Montos totales de Productos por mes(Pedidos)");
        jMnuItemC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuItemCActionPerformed(evt);
            }
        });
        jMenuTipoEstadistica.add(jMnuItemC);

        jMenuBar1.add(jMenuTipoEstadistica);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jBtnExportar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jBtnExportar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnuItemPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemPrincipalActionPerformed
    Ventana_Principal principal = new Ventana_Principal();
    principal.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jMnuItemPrincipalActionPerformed

    private void jMnuItemAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemAActionPerformed
     //CANTIDAD POR PEDIDO, PROVEEDOR Y PAIS
      modeloTabla.setColumnIdentifiers(new Object[]{"CANTIDAD POR PEDIDO", "PROVEEDOR", "PAIS"});
       
       String csvFile = "Proveedores.csv";  // Reemplaza con la ruta correcta de tu archivo CSV
       String csvDelimitador = ",";  // Reemplaza con el delimitador correcto de tu archivo CSV

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
            String line;
            int numFilas = ImportadorCSV.contarFilasEnCSV(csvFile);
            Proveedores[] listaobjetos = new Proveedores[numFilas];
            int indice = 0;

        while ((line = br.readLine()) != null) 
        {
            String[] partes = line.split(csvDelimitador);
            Proveedores objeto=new Proveedores();
                            objeto.setIdProveedor(partes[0]);
                            objeto.setNombreCompania(partes[1]);
                            objeto.setNombreContacto(partes[2]);
                            objeto.setCargoContacto(partes[3]);
                            objeto.setDireccion(partes[4]);
                            objeto.setCiudad(partes[5]);
                            objeto.setRegion(partes[6]);
                            objeto.setCodigoPostal(partes[7]);
                            objeto.setPais(partes[8]);
                            objeto.setTelefono(partes[9]);
                            objeto.setFax(partes[10]);
            listaobjetos[indice] = objeto;
            indice++;
        }
        // Agregar los objetos al modelo de la tabla
        for (Proveedores objeto : listaobjetos) 
        {
            modeloTabla.addRow(new Object[]{});
        }

    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
    
    }//GEN-LAST:event_jMnuItemAActionPerformed
    
    private void jMnuItemBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemBActionPerformed
     //CANTIDAD POR MONTO DE PEDIDOS Y AGRUPADOS POR PROVEEDOR, AÑO Y MES QUE SE VISUALIZEN POR PANTALLA
     modeloTabla.setColumnIdentifiers(new Object[]{"MONTO DE PEDIDO", "PROVEEDOR", "AÑO", "MES"});
      
        
                   
    
     
    }//GEN-LAST:event_jMnuItemBActionPerformed

    private void jMnuItemCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuItemCActionPerformed
       // MONTOS TOTALES DE PRODUCTOS POR MES Importando el archivo csv productos y QUE SE VISUALIZEN POR PANTALLA 
        modeloTabla.setColumnIdentifiers(new Object[]{"PRODUCTOS", "TOTAL"});
        
    
    }//GEN-LAST:event_jMnuItemCActionPerformed

    private void jBtnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExportarActionPerformed
        // EXPORTAR LOS DATOS DE PANTALLA EN ARCHIVO CSV
        exportarDatosCSV("Resultados_Obtenidos.csv");
    } 

    private void exportarDatosCSV(String archivoSalida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(archivoSalida)))) {
            // Escribir encabezados
            for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
                writer.write(modeloTabla.getColumnName(i));
                if (i < modeloTabla.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();

            // Escribir datos
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                    writer.write(modeloTabla.getValueAt(i, j).toString());
                    if (j < modeloTabla.getColumnCount() - 1) {
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
    }//GEN-LAST:event_jBtnExportarActionPerformed
    
   
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
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estadisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuTipoEstadistica;
    private javax.swing.JMenuItem jMnuItemA;
    private javax.swing.JMenuItem jMnuItemB;
    private javax.swing.JMenuItem jMnuItemC;
    private javax.swing.JMenuItem jMnuItemPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
