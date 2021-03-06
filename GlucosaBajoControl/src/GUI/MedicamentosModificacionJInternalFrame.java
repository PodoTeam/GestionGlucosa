/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultDocument;
import glucosabajocontrol.MedicamentoDP;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author W10USER
 */
public class MedicamentosModificacionJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form MedicamentosModificacionJInternalFrame
     */

    ArrayList<MedicamentoDP> medica = new ArrayList<MedicamentoDP>();
    static String user;
     DefaultTableModel modelo;
    public MedicamentosModificacionJInternalFrame(String user) throws IOException, SQLException {
        initComponents();
         modelo = (DefaultTableModel) jTable1.getModel();
        this.user = user;
        cargar(this.user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));
        setClosable(true);
        setIconifiable(true);
        setTitle("Modificación Medicamentos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dosis", "Indicaciones", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Medicamentos...");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    float dosis;
    Boolean estado;
    int fila;
    int columna;
    ArrayList<Integer> rows = new ArrayList<Integer>();
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        fila = jTable1.rowAtPoint(evt.getPoint());
        columna = jTable1.columnAtPoint(evt.getPoint());
        if(columna == 1 || columna == 3 | columna ==2)
        {
            // LISTA
            rows.add(fila);       
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int i;
        for (i = 0; i < rows.size(); i++) {
            // Obtener los datos que se van a modificar.
            String nombre = (String) jTable1.getValueAt(rows.get(i), 0);
            float dosis = (float) jTable1.getValueAt(rows.get(i), 1);
            String indicaciones = (String) jTable1.getValueAt(rows.get(i), 2);
            Boolean estado = (Boolean) jTable1.getValueAt(rows.get(i), 3);
            MedicamentoDP me = new MedicamentoDP();

                System.out.println(estado);
                System.out.println(dosis);
            
             try {
                boolean result = me.modificar(nombre, dosis, indicaciones, estado);
                if(!result)
                {JOptionPane.showMessageDialog(null, "Error en la modificaion");}
                
            } catch (IOException ex) {
                Logger.getLogger(MedicamentosModificacionJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MedicamentosModificacionJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
        }
        if(i == rows.size())
        {
            int a = jTable1.getRowCount();
            System.out.println(a);
            for (int j = a; j != 0; j--) {
                modelo.removeRow(0);
            } 
            try {
                cargar(user);
            } catch (IOException ex) {
                Logger.getLogger(MedicamentosModificacionJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MedicamentosModificacionJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void cargar(String user) throws IOException, SQLException {
        Object datos[] = new Object[4];
        MedicamentoDP me = new MedicamentoDP();
        medica = me.cargarMedicamentos(user);
        for (int i = 0; i < medica.size(); i++) {
            datos[0] = medica.get(i).getNombre();
            datos[1] = medica.get(i).getDosis();
            datos[2] = medica.get(i).getIndicaciones();
            if(medica.get(i).getEstado())
            {
                datos[3] = medica.get(i).getEstado();
                modelo.addRow(datos);
            }
            
        }
        jTable1.setModel(modelo);
    }
}
