/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import glucosabajocontrol.GlucosaDP;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author W10USER
 */
public class Hba1cJInternalFrame1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form GlucosaJInternalFrame
     */
    glucosabajocontrol.GlucosaDP glucosa = new GlucosaDP();
    String id = "";

    public Hba1cJInternalFrame1(String id) {
        initComponents();
        this.id = id;
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setClosable(true);
        setIconifiable(true);
        setTitle("Datos glucosa");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("HbAC1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Medicion", "Momento Medición", "HbA1C"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            modificarDatos();
        } catch (IOException ex) {
            Logger.getLogger(Hba1cJInternalFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Hba1cJInternalFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        //clases a consultar        
        ArrayList<Hba1cDP> hbs = new ArrayList<>();

        try {
            //consulta de trabajadores en el grupo
            glucosas = glucosa.consultarDP(id);
            if (glucosas.size() > 0) {
                for (GlucosaDP medicion : glucosas) {
                    model.insertRow(model.getRowCount(), new Object[]{medicion.getFechaGlucosa(), medicion.getMomentoMedicion(), medicion.getConcentracionAzucar(), medicion.getComentario(), true});
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existen Mediciones de glucosa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hba1cJInternalFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hba1cJInternalFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarDatos() throws IOException, SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 4).equals(true)) {
                glucosa.setCodigoGlucosa(model.getValueAt(i, 0) + "" + model.getValueAt(i, 1));
                glucosa.setFechaGlucosa((java.sql.Date) model.getValueAt(i, 0));
                glucosa.setMomentoMedicion(model.getValueAt(i, 1).toString());
                glucosa.setConcentracionAzucar((int) model.getValueAt(i, 2));
                glucosa.setComentario(model.getValueAt(i, 3).toString());
                glucosa.modificarDP();
                cargarDatos();

            } else {
                glucosa.setCodigoGlucosa(model.getValueAt(i, 0) + "" + model.getValueAt(i, 1));
                glucosa.eliminarDP();
                cargarDatos();
            }
        }
    }
}
