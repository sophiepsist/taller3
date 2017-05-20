/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controladora.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
        

/**
 *
 * @author invitado
 */
public class ConsultarLibro extends javax.swing.JInternalFrame {
    private Controladora miControl;
    /**
     * Creates new form Consultal
     */
    public ConsultarLibro(Controladora c) {
        initComponents();
        this.miControl = c;
        this.refrescarLibros();
        this.refrescarLibrosAcademicos();
        this.refrescarLibrosRomance();
        this.refrescarLibrosOtros();
        this.refrescarLibrosFilosofia();
        this.refrescarLibrosSuspenso();
        this.refrescarLibrosJuveniles();
        this.refrescarLibrosClasicos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jRadioButton3 = new javax.swing.JRadioButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton4 = new javax.swing.JRadioButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jRadioButton5 = new javax.swing.JRadioButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jRadioButton6 = new javax.swing.JRadioButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        jRadioButton7 = new javax.swing.JRadioButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar");

        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });

        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea2.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar", jPanel1);

        jRadioButton1.setText("Académicos");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setEnabled(false);

        jRadioButton2.setText("Clásicos");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setEnabled(false);

        jRadioButton3.setText("Juveniles");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setEnabled(false);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Romance");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jComboBox4.setEnabled(false);

        jRadioButton5.setText("Suspenso");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jComboBox5.setEnabled(false);

        jRadioButton6.setText("Filosofía");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jComboBox6.setEnabled(false);

        jRadioButton7.setText("Otros");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jComboBox7.setEnabled(false);

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 0, 153));
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jRadioButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jRadioButton5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton5)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton6)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton7)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Categorías", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(false);
            this.jRadioButton5.setSelected(false);
            this.jRadioButton6.setSelected(false);
            this.jRadioButton7.setSelected(false);
            this.jComboBox1.setEnabled(true);
            this.jComboBox6.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            this.jComboBox4.setEnabled(false);
            this.jComboBox5.setEnabled(false);
            this.jComboBox7.setEnabled(false);
        }else{
            this.jComboBox1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton1.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(false);
            this.jRadioButton5.setSelected(false);
            this.jRadioButton6.setSelected(false);
            this.jRadioButton7.setSelected(false);
            this.jComboBox2.setEnabled(true);
            this.jComboBox1.setEnabled(false);
            this.jComboBox6.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            this.jComboBox4.setEnabled(false);
            this.jComboBox5.setEnabled(false);
            this.jComboBox7.setEnabled(false);
        }else{
            this.jComboBox2.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton2.setSelected(false);
            this.jRadioButton1.setSelected(false);
            this.jRadioButton4.setSelected(false);
            this.jRadioButton5.setSelected(false);
            this.jRadioButton6.setSelected(false);
            this.jRadioButton7.setSelected(false);
            this.jComboBox3.setEnabled(true);
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox6.setEnabled(false);
            this.jComboBox4.setEnabled(false);
            this.jComboBox5.setEnabled(false);
            this.jComboBox7.setEnabled(false);
        }else{
            this.jComboBox3.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton1.setSelected(false);
            this.jRadioButton5.setSelected(false);
            this.jRadioButton6.setSelected(false);
            this.jRadioButton7.setSelected(false);
            this.jComboBox4.setEnabled(true);
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            this.jComboBox6.setEnabled(false);
            this.jComboBox5.setEnabled(false);
            this.jComboBox7.setEnabled(false);
        }else{
            this.jComboBox4.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(false);
            this.jRadioButton1.setSelected(false);
            this.jRadioButton6.setSelected(false);
            this.jRadioButton7.setSelected(false);
            this.jComboBox5.setEnabled(true);
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            this.jComboBox4.setEnabled(false);
            this.jComboBox6.setEnabled(false);
            this.jComboBox7.setEnabled(false);
        }else{
            this.jComboBox5.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(false);
            this.jRadioButton5.setSelected(false);
            this.jRadioButton1.setSelected(false);
            this.jRadioButton7.setSelected(false);
            this.jComboBox6.setEnabled(true);
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            this.jComboBox4.setEnabled(false);
            this.jComboBox5.setEnabled(false);
            this.jComboBox7.setEnabled(false);
        }else{
            this.jComboBox6.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        if(this.isSelected()){
            this.jRadioButton2.setSelected(false);
            this.jRadioButton3.setSelected(false);
            this.jRadioButton4.setSelected(false);
            this.jRadioButton5.setSelected(false);
            this.jRadioButton6.setSelected(false);
            this.jRadioButton1.setSelected(false);
            this.jComboBox7.setEnabled(true);
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            this.jComboBox4.setEnabled(false);
            this.jComboBox5.setEnabled(false);
            this.jComboBox6.setEnabled(false);
        }else{
            this.jComboBox7.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList conexion = new ArrayList(2);
        ArrayList respuesta = new ArrayList(2);
        conexion.add("consultarInfoLibros");
        conexion.add(this.jComboBox8.getSelectedItem().toString().split(";")[1]);
        respuesta = this.miControl.conectar(conexion);      
       this.jTextArea2.setText((String)respuesta.get(0));
       this.jLabel2.setIcon((ImageIcon)respuesta.get(1));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String isbn = "";
        if(this.jComboBox1.isEnabled() && this.jComboBox1.getSelectedItem().toString().contains(";")){ 
            isbn = this.jComboBox1.getSelectedItem().toString().split(";")[1];
            mostrarConsultarCategoria(isbn);
        }else if(this.jComboBox2.isEnabled() && this.jComboBox2.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox2.getSelectedItem().toString().split(";")[1]; 
            mostrarConsultarCategoria(isbn);
        }else if(this.jComboBox3.isEnabled() && this.jComboBox3.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox3.getSelectedItem().toString().split(";")[1];
            mostrarConsultarCategoria(isbn);
        }else if(this.jComboBox4.isEnabled() && this.jComboBox4.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox4.getSelectedItem().toString().split(";")[1];
            mostrarConsultarCategoria(isbn);
        }else if(this.jComboBox5.isEnabled() && this.jComboBox5.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox5.getSelectedItem().toString().split(";")[1];
            mostrarConsultarCategoria(isbn);
        }else if(this.jComboBox6.isEnabled() && this.jComboBox6.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox6.getSelectedItem().toString().split(";")[1];
            mostrarConsultarCategoria(isbn);
        }else if(this.jComboBox7.isEnabled() && this.jComboBox7.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox7.getSelectedItem().toString().split(";")[1];
            mostrarConsultarCategoria(isbn);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione uno de los libros disponibles");
        }                
    }//GEN-LAST:event_jButton1ActionPerformed
    private void mostrarConsultarCategoria(String isbn){
        ArrayList conexion = new ArrayList(2);
        ArrayList respuesta = new ArrayList(2);
        conexion.add("consultarInfoLibros");
        conexion.add(isbn);
        
        respuesta = this.miControl.conectar(conexion);
        this.jTextArea1.setText((String)respuesta.get(0));
        this.jLabel1.setIcon((ImageIcon)respuesta.get(1));
    }
    
    private void refrescarLibros(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibros");
        ArrayList libros = this.miControl.conectar(conexion);        
        for(Object libro : libros){
            this.jComboBox8.addItem((String)libro);
        }        
    }
    
    private void refrescarLibrosAcademicos(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosAcademicos");
        ArrayList librosAcademicos = this.miControl.conectar(conexion);       
        for(Object libroAcademicos : librosAcademicos){
            this.jComboBox1.addItem((String)libroAcademicos);
        }
    }
    
    private void refrescarLibrosClasicos(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosClasicos");
        ArrayList librosClasicos = this.miControl.conectar(conexion);
        for(Object libroClasicos : librosClasicos){
            this.jComboBox2.addItem((String)libroClasicos);
        }
    }
    
    private void refrescarLibrosJuveniles(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosJuveniles");
        ArrayList librosJuveniles = this.miControl.conectar(conexion);
        for(Object libroJuveniles : librosJuveniles){
            this.jComboBox3.addItem((String)libroJuveniles);            
        }
    }
        
    private void refrescarLibrosRomance(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosRomance");
        ArrayList librosRomance = this.miControl.conectar(conexion);
        for(Object libroRomance : librosRomance){
            this.jComboBox4.addItem((String)libroRomance);
        }        
    }
    
    
    private void refrescarLibrosSuspenso(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosSuspenso");
        ArrayList librosSuspenso = this.miControl.conectar(conexion);
        for(Object libroSuspenso : librosSuspenso){
            this.jComboBox5.addItem((String)libroSuspenso);
        }        
    }
    
    
    private void refrescarLibrosFilosofia(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosFilosofia");
        ArrayList librosFilosofia = this.miControl.conectar(conexion);
        for(Object libroFilosofia : librosFilosofia){
            this.jComboBox6.addItem((String)libroFilosofia);
        }        
    }
    
    private void refrescarLibrosOtros(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosOtros");
        ArrayList librosOtros = this.miControl.conectar(conexion);
        for(Object libroOtros : librosOtros){
            this.jComboBox7.addItem((String)libroOtros);
        }        
    }
   
    
    
        
        
    
    
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}