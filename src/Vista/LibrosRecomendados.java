/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;
import Controladora.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Valeria
 */
public class LibrosRecomendados extends javax.swing.JInternalFrame {
    private Controladora miControl;
    private int cont;
    /** Creates new form LibrosRecomendados */
    public LibrosRecomendados(Controladora c) {
        initComponents();
        this.miControl =c;
        this.cont = 0;
        recomendarLibros();
    }
    public void recomendarLibros(){
        
        ArrayList mensaje = new ArrayList();
        ArrayList respuesta = new ArrayList();
        ArrayList mensaje2 = new ArrayList();
        ArrayList mensaje3 = new ArrayList();
        ArrayList mensaje4 = new ArrayList();
        ArrayList mensaje5 = new ArrayList();
        ArrayList mensaje6 = new ArrayList();
        ArrayList mensaje7 = new ArrayList();
        ArrayList respuesta2 = new ArrayList();
        ArrayList respuesta3 = new ArrayList();
        ArrayList respuesta4 = new ArrayList();
        ArrayList respuesta5 = new ArrayList();
        ArrayList respuesta6 = new ArrayList();
        ArrayList respuesta7 = new ArrayList();
        String libro1 = "";
        String libro2 = "";
        String libro3 = "";
        String libro4 = "";
        String libro5 = "";
        String libro6 = "";
        mensaje.add("recomendarLibros");
        respuesta = miControl.conectar(mensaje);
        try{
        libro1 = (String) respuesta.get(cont);
        mensaje2.add("consultarInfoLibros");
        mensaje2.add(libro1.split(";")[1]);
        respuesta2 = miControl.conectar(mensaje2);
        jLabel1.setIcon((Icon) respuesta2.get(1));
        jLabel7.setText((String) respuesta2.get(0));
        }catch(IndexOutOfBoundsException e){
            jLabel1.setText("No hay mas libros a recomendar");
        }
        try{
        libro2 = (String) respuesta.get(cont + 1);
        mensaje3.add("consultarInfoLibros");
        mensaje3.add(libro2.split(";")[1]);
        respuesta3 = miControl.conectar(mensaje3);
        jLabel2.setIcon((Icon) respuesta3.get(1));
        jLabel8.setText((String) respuesta3.get(0));
        }catch(IndexOutOfBoundsException e){
            jLabel2.setText("No hay mas libros a recomendar");
        }
        try{
        libro3 = (String) respuesta.get(cont + 2);
        mensaje4.add("consultarInfoLibros");
        mensaje4.add(libro3.split(";")[1]);
        respuesta4 = miControl.conectar(mensaje4);
        jLabel3.setIcon((Icon) respuesta4.get(1));
        jLabel9.setText((String) respuesta4.get(0));
        }catch(IndexOutOfBoundsException e){
            jLabel3.setText("No hay mas libros a recomendar");
        }
        try{
        libro4 = (String) respuesta.get(cont + 3);
        mensaje5.add("consultarInfoLibros");
        mensaje5.add(libro2.split(";")[1]);
        respuesta5 = miControl.conectar(mensaje5);
        jLabel4.setIcon((Icon) respuesta5.get(1));
        jLabel10.setText((String) respuesta5.get(0));
        }catch(IndexOutOfBoundsException e){
            jLabel2.setText("No hay mas libros a recomendar");
        }
        try{
        libro5 = (String) respuesta.get(cont + 4);
        mensaje6.add("consultarInfoLibros");
        mensaje6.add(libro2.split(";")[1]);
        respuesta3 = miControl.conectar(mensaje6);
        jLabel5.setIcon((Icon) respuesta3.get(1));
        jLabel11.setText((String) respuesta3.get(0));
        }catch(IndexOutOfBoundsException e){
            jLabel2.setText("No hay mas libros a recomendar");
        }
        try{
        libro6 = (String) respuesta.get(cont + 5);
        mensaje7.add("consultarInfoLibros");
        mensaje7.add(libro2.split(";")[1]);
        respuesta3 = miControl.conectar(mensaje7);
        jLabel6.setIcon((Icon) respuesta3.get(1));
        jLabel12.setText((String) respuesta3.get(0));
        }catch(IndexOutOfBoundsException e){
            jLabel2.setText("No hay mas libros a recomendar");
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LIBROS RECOMENDADOS");

        jLabel7.setText("No hay libros a recomendar");

        jLabel8.setText("No hay libros a recomendar");

        jLabel9.setText("No hay libros a recomendar");

        jLabel10.setText("No hay libros a recomendar");

        jLabel11.setText("No hay libros a recomendar");

        jLabel12.setText("No hay libros a recomendar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
