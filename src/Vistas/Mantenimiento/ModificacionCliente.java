/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Mantenimiento;

import DAO.DAOCliente;
import Entidades.Cliente;

/**
 *
 * @author reant
 */
public class ModificacionCliente extends javax.swing.JFrame {

    private int id;
    private String Nom_inicial;
    private String Ape_inicial;
    private String Tel_inicial;

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNom_inicial(String Nom_inicial) {
        this.Nom_inicial = Nom_inicial;
        load();
    }

    public void setApe_inicial(String Ape_inicial) {
        this.Ape_inicial = Ape_inicial;
        load();
    }

    public void setTel_inicial(String Tel_inicial) {
        this.Tel_inicial = Tel_inicial;
        load();
    }

    
    /**
     * Creates new form ModificacionCliente
     */
    public ModificacionCliente() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNnombre = new javax.swing.JTextField();
        txtNapellido = new javax.swing.JTextField();
        txtNtelefono = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.9F);

        jLabel1.setText("Ingresando los nuevos datos:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Telefono:");

        txtNnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNnombreKeyTyped(evt);
            }
        });

        txtNapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNapellidoKeyTyped(evt);
            }
        });

        txtNtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNtelefonoKeyTyped(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtNapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c < ' ' || c > ' ')){
            evt.consume();
        }
    }//GEN-LAST:event_txtNnombreKeyTyped

    private void txtNapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNapellidoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c < ' ' || c > ' ')){
            evt.consume();
        }
    }//GEN-LAST:event_txtNapellidoKeyTyped

    private void txtNtelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNtelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')&&(c !='+')){
            evt.consume();
        }
    }//GEN-LAST:event_txtNtelefonoKeyTyped

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        actualizar();
        this.setVisible(false);
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void load(){
        this.txtNnombre.setText(Nom_inicial);
        this.txtNapellido.setText(Ape_inicial);
        this.txtNtelefono.setText(Tel_inicial);
    }
    private void actualizar(){
        DAOCliente dao = new DAOCliente();
        String nombre = txtNnombre.getText();
        String apellido=txtNapellido.getText();
        String Telefono=txtNtelefono.getText();
        if(Telefono.length()>9) Telefono=Telefono.substring(0,9);
        
        Cliente actu = new Cliente(id,nombre,apellido,Telefono);
        dao.Editar(actu);
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
            java.util.logging.Logger.getLogger(ModificacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNapellido;
    private javax.swing.JTextField txtNnombre;
    private javax.swing.JTextField txtNtelefono;
    // End of variables declaration//GEN-END:variables
}
