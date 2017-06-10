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
public class LibrosBestSeller extends javax.swing.JInternalFrame {
    private Controladora miControl;
    /**
     * Creates new form LibrosBestSeller
     */
    public LibrosBestSeller(Controladora c) {
        initComponents();
        this.miControl = c;
        this.refrescarLibrosBestSeller();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        star5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("BEST SELLER");

        jLabel1.setText("Libro:");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 0, 153));
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star.gif"))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(star1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(star2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(star3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(star4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(star5, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jScrollPane1))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
        ArrayList conexion = new ArrayList();
        conexion.add("comprarlibrosUL");
        String isbn;
        if(this.jComboBox1.getSelectedItem().toString().contains(";")){
            isbn = this.jComboBox1.getSelectedItem().toString().split(";")[1];
            conexion.add(isbn);
            JOptionPane.showMessageDialog(this, miControl.conectar(conexion).get(0));
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione un libro");
        }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Por favor seleccione un libro");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
//        ArrayList conexion = new ArrayList(2);
//        ArrayList respuesta = new ArrayList(3);
//        conexion.add("consultarInfoLibros");
//        conexion.add(this.jComboBox1.getSelectedItem().toString().split(";")[1]);
//        respuesta = this.miControl.conectar(conexion);      
//        this.jTextArea1.setText((String)respuesta.get(0));
//        this.jLabel2.setIcon((ImageIcon)respuesta.get(1));
//        switch((int)respuesta.get(2)){
//            case 1:
//               this.star1.setVisible(true);
//               break;
//            case 2:
//               this.star1.setVisible(true);
//               this.star2.setVisible(true);
//               break;
//            case 3:
//               this.star1.setVisible(true);
//               this.star2.setVisible(true);
//               this.star3.setVisible(true);
//               break;
//            case 4:
//               this.star1.setVisible(true);
//               this.star2.setVisible(true);
//               this.star3.setVisible(true);
//               this.star4.setVisible(true);
//               break;
//            case 5:
//               this.star1.setVisible(true);
//               this.star2.setVisible(true);
//               this.star3.setVisible(true);
//               this.star4.setVisible(true);
//               this.star5.setVisible(true);
//       }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        ArrayList conexion = new ArrayList(2);
        ArrayList respuesta = new ArrayList(3);
        conexion.add("consultarInfoLibros");
        conexion.add(this.jComboBox1.getSelectedItem().toString().split(";")[1]);
        respuesta = this.miControl.conectar(conexion);      
        this.jTextArea1.setText((String)respuesta.get(0));
        this.jLabel2.setIcon((ImageIcon)respuesta.get(1));
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
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    
    
    public void refrescarLibrosBestSeller(){
        try{
            ArrayList conexion = new ArrayList(1);
            conexion.add("refrescarBestSellers");
            ArrayList librosBestSeller = this.miControl.conectar(conexion);   
            if(librosBestSeller == null){
                JOptionPane.showMessageDialog(this, "No hay libros best seller");
            }else{
                for(Object libroBestSeller : librosBestSeller){
                    this.jComboBox1.addItem((String)libroBestSeller);
                    }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "No hay libros best seller");
        }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JLabel star5;
    // End of variables declaration//GEN-END:variables
}
