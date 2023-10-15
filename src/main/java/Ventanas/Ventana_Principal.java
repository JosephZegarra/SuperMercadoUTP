/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

/**
 *
 * @author ROBSKY
 */
public class Ventana_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Venatana_Principal
     */
    public Ventana_Principal() {
        initComponents();
        
        this.setTitle("Menu Principal");
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

        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuFormularios = new javax.swing.JMenu();
        jMenuRegPedidos = new javax.swing.JMenuItem();
        jMenuConsulPedidos = new javax.swing.JMenuItem();
        jMenuConsulArticulos = new javax.swing.JMenuItem();
        jMenuEstadisticas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuArchivo.setText("Archivo");

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuFormularios.setText("Formularios");

        jMenuRegPedidos.setText("Registro de Pedidos");
        jMenuRegPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegPedidosActionPerformed(evt);
            }
        });
        jMenuFormularios.add(jMenuRegPedidos);

        jMenuConsulPedidos.setText("Consulta de Pedidos");
        jMenuConsulPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsulPedidosActionPerformed(evt);
            }
        });
        jMenuFormularios.add(jMenuConsulPedidos);

        jMenuConsulArticulos.setText("Consulta de Articulos");
        jMenuConsulArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsulArticulosActionPerformed(evt);
            }
        });
        jMenuFormularios.add(jMenuConsulArticulos);

        jMenuEstadisticas.setText("Estadisticas");
        jMenuEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEstadisticasActionPerformed(evt);
            }
        });
        jMenuFormularios.add(jMenuEstadisticas);

        jMenuBar1.add(jMenuFormularios);

        jMenu3.setText("Ayuda");

        jMenuAcerca.setText("Acerca de...");
        jMenuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAcercaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuAcerca);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcercaActionPerformed
        Acerca acerca = new Acerca(this, rootPaneCheckingEnabled);
        acerca.setVisible(true);
    }//GEN-LAST:event_jMenuAcercaActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuRegPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegPedidosActionPerformed
        Registro_de_Pedidos rPedidos = new Registro_de_Pedidos();
        rPedidos.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jMenuRegPedidosActionPerformed

    private void jMenuConsulPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsulPedidosActionPerformed
        Consulta_de_Pedidos cPedidos = new Consulta_de_Pedidos();
        cPedidos.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jMenuConsulPedidosActionPerformed

    private void jMenuConsulArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsulArticulosActionPerformed
        Consulta_de_Articulos cArticulos = new Consulta_de_Articulos();
        cArticulos.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jMenuConsulArticulosActionPerformed

    private void jMenuEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEstadisticasActionPerformed
        Estadisticas estadisticas = new Estadisticas();
        estadisticas.setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_jMenuEstadisticasActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuAcerca;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConsulArticulos;
    private javax.swing.JMenuItem jMenuConsulPedidos;
    private javax.swing.JMenuItem jMenuEstadisticas;
    private javax.swing.JMenu jMenuFormularios;
    private javax.swing.JMenuItem jMenuRegPedidos;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
