/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laura
 */
public class AlmacenadoFuncion extends javax.swing.JFrame {

    /**
     * Creates new form AlmacenadoFuncion
     */
    public AlmacenadoFuncion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabla_Transacciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Funcion_Almacenado = new javax.swing.JTable();
        btn_ProcedimientoA_ = new javax.swing.JButton();
        btn_Menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla_Transacciones.setBackground(new java.awt.Color(153, 153, 255));

        Tabla_Funcion_Almacenado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Función", "ProcedimientoA"
            }
        ));
        Tabla_Funcion_Almacenado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tabla_Funcion_AlmacenadoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Funcion_Almacenado);

        btn_ProcedimientoA_.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_ProcedimientoA_.setForeground(new java.awt.Color(153, 102, 255));
        btn_ProcedimientoA_.setText("Función Y Procedimineto");
        btn_ProcedimientoA_.setToolTipText("");
        btn_ProcedimientoA_.setActionCommand("Funcion");
        btn_ProcedimientoA_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProcedimientoA_ActionPerformed(evt);
            }
        });

        btn_Menu.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        btn_Menu.setForeground(new java.awt.Color(153, 102, 255));
        btn_Menu.setText("Menú");
        btn_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tabla_TransaccionesLayout = new javax.swing.GroupLayout(Tabla_Transacciones);
        Tabla_Transacciones.setLayout(Tabla_TransaccionesLayout);
        Tabla_TransaccionesLayout.setHorizontalGroup(
            Tabla_TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tabla_TransaccionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tabla_TransaccionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btn_ProcedimientoA_)
                .addGap(48, 48, 48))
        );
        Tabla_TransaccionesLayout.setVerticalGroup(
            Tabla_TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tabla_TransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tabla_TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ProcedimientoA_)
                    .addComponent(btn_Menu))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabla_Transacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabla_Transacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla_Funcion_AlmacenadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_Funcion_AlmacenadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_Funcion_AlmacenadoKeyPressed

    private void btn_ProcedimientoA_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProcedimientoA_ActionPerformed
        // TODO add your handling code here:
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Univeersidaad", "laura", "laura");
        CallableStatement stmt = conn.prepareCall("{CALL ObtenerDatosVista()}");

        ResultSet rs = stmt.executeQuery();

        DefaultTableModel model = (DefaultTableModel) Tabla_Funcion_Almacenado.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de mostrar nuevos datos

        while (rs.next()) {
            Object[] fila = {
                rs.getInt("ID_donador"),
                rs.getDouble("CantidadGarantizada"),
                rs.getDate("FechaTransacciones")
            };
            model.addRow(fila);
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btn_ProcedimientoA_ActionPerformed

    private void btn_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuActionPerformed
        // TODO add your handling code here:
        Menu ventanaMenu = new Menu();

        // Mostrar la ventana Menu
        ventanaMenu.setVisible(true);

        // Cerrar la ventana actual (Tabla_Universidad)
        this.dispose();

    }//GEN-LAST:event_btn_MenuActionPerformed
private void btn_Funcion_ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Univeersidaad", "laura", "laura");
            CallableStatement stmt = conn.prepareCall("{? = CALL ObtenerTotalDonadores()}");

            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.execute();

            int total = stmt.getInt(1);
            System.out.println("Total de donadores: " + total);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(AlmacenadoFuncion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlmacenadoFuncion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlmacenadoFuncion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlmacenadoFuncion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlmacenadoFuncion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Funcion_Almacenado;
    private javax.swing.JPanel Tabla_Transacciones;
    private javax.swing.JButton btn_Menu;
    private javax.swing.JButton btn_ProcedimientoA_;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
