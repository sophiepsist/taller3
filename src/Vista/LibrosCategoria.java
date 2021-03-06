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
 * @author Valeria
 */
public class LibrosCategoria extends javax.swing.JInternalFrame {
    private Controladora miControl;
    private String isbn;
    /** Creates new form LibrosCategoria */
    public LibrosCategoria(Controladora c) {
        initComponents();
        this.miControl =c;
        this.refrescarLibrosAcademicos();
        this.refrescarLibrosRomance();
        this.refrescarLibrosOtros();
        this.refrescarLibrosFilosofia();
        this.refrescarLibrosSuspenso();
        this.refrescarLibrosJuveniles();
        this.refrescarLibrosClasicos();
        this.star1.setVisible(false);
        this.star2.setVisible(false);
        this.star3.setVisible(false);
        this.star4.setVisible(false);
        this.star5.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton3 = new javax.swing.JRadioButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jRadioButton4 = new javax.swing.JRadioButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jRadioButton5 = new javax.swing.JRadioButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jRadioButton6 = new javax.swing.JRadioButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        jRadioButton7 = new javax.swing.JRadioButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        star5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LIBROS POR CATEGORÍA");

        jRadioButton1.setText("Académicos");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setEnabled(false);

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

        jRadioButton2.setText("Clásicos");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setEnabled(false);

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

        jLabel1.setBackground(new java.awt.Color(51, 0, 153));
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        jButton2.setText("Comprar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton2))
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButton5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jRadioButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox6, 0, 180, Short.MAX_VALUE)
                                        .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(star1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(star5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton5))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton6)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton7)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(star1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star5, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList conexion = new ArrayList();
        conexion.add("comprarlibrosUL");
        conexion.add(isbn);
        
        JOptionPane.showMessageDialog(this, miControl.conectar(conexion).get(0));
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void mostrarConsultarCategoria(String isbn){
        this.isbn = isbn;
        ArrayList conexion = new ArrayList(2);
        ArrayList respuesta = new ArrayList(3);
        conexion.add("consultarInfoLibros");
        conexion.add(isbn);
        
        respuesta = this.miControl.conectar(conexion);
        this.jLabel1.setIcon((ImageIcon)respuesta.get(1));
        
        switch((int)respuesta.get(2)){
               case 1:
                   this.star1.setVisible(true);
                   break;
               case 2:
                   this.star1.setVisible(true);
                   this.star2.setVisible(true);
                   break;
               case 3:
                   this.star1.setVisible(true);
                   this.star2.setVisible(true);
                   this.star3.setVisible(true);
                   break;
               case 4:
                   this.star1.setVisible(true);
                   this.star2.setVisible(true);
                   this.star3.setVisible(true);
                   this.star4.setVisible(true);
                   break;
               case 5:
                   this.star1.setVisible(true);
                   this.star2.setVisible(true);
                   this.star3.setVisible(true);
                   this.star4.setVisible(true);
                   this.star5.setVisible(true);
           }
    }
    
    
    public void refrescarLibrosAcademicos(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosAcademicos");
        ArrayList librosAcademicos = this.miControl.conectar(conexion);       
        for(Object libroAcademicos : librosAcademicos){
            this.jComboBox1.addItem((String)libroAcademicos);
        }
    }
    
    public void refrescarLibrosClasicos(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosClasicos");
        ArrayList librosClasicos = this.miControl.conectar(conexion);
        for(Object libroClasicos : librosClasicos){
            this.jComboBox2.addItem((String)libroClasicos);
        }
    }
    
    public void refrescarLibrosJuveniles(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosJuveniles");
        ArrayList librosJuveniles = this.miControl.conectar(conexion);
        for(Object libroJuveniles : librosJuveniles){
            this.jComboBox3.addItem((String)libroJuveniles);            
        }
    }
        
    public void refrescarLibrosRomance(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosRomance");
        ArrayList librosRomance = this.miControl.conectar(conexion);
        for(Object libroRomance : librosRomance){
            this.jComboBox4.addItem((String)libroRomance);
        }        
    }
    
    
    public void refrescarLibrosSuspenso(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosSuspenso");
        ArrayList librosSuspenso = this.miControl.conectar(conexion);
        for(Object libroSuspenso : librosSuspenso){
            this.jComboBox5.addItem((String)libroSuspenso);
        }        
    }
    
    
    public void refrescarLibrosFilosofia(){
        ArrayList conexion = new ArrayList(1);
        conexion.add("refrescarLibrosFilosofia");
        ArrayList librosFilosofia = this.miControl.conectar(conexion);
        for(Object libroFilosofia : librosFilosofia){
            this.jComboBox6.addItem((String)libroFilosofia);
        }        
    }
    
    public void refrescarLibrosOtros(){
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JLabel star5;
    // End of variables declaration//GEN-END:variables

}
