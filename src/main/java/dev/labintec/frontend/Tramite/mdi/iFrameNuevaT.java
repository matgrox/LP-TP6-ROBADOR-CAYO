/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package dev.labintec.frontend.Tramite.mdi;

import dev.labintec.frontend.Tramite.cliente.ClienteRequestTransaction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Ventana interna para crear nuevas transacciones. Permite interactuar con el
 * frame padre para actualizar los datos.
 *
 * @author matgr
 */

public class iFrameNuevaT extends javax.swing.JInternalFrame {

    private JDialog contenedor;
    private iFTablaTramite padre;

    /**
     * Constructor de la ventana interna iFrameNuevaT. Recibe una referencia al
     * contenedor (JDialog) y al frame padre (iFTablaTramite) para poder
     * interactuar con la interfaz principal desde esta ventana auxiliar.
     *
     * @param contenedor El contenedor JDialog que aloja este JInternalFrame.
     * @param padre Referencia al iFTablaTramite que lo invoca; permite
     * actualizar datos o comunicarse.
     * @author matgr
     */
    public iFrameNuevaT(JDialog contenedor, iFTablaTramite padre) {
        this.contenedor = contenedor;
        this.padre = padre;
        initComponents();
    }

    public void mostrar() {
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTipo = new javax.swing.JLabel();
        jTextTipo = new javax.swing.JTextField();
        jLabelEstatus = new javax.swing.JLabel();
        jTextEstatus = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        jLabelTipo.setText("Tipo: (*)");

        jTextTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTipoKeyReleased(evt);
            }
        });

        jLabelEstatus.setText("Estado: (*)");

        jTextEstatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextEstatusKeyReleased(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setEnabled(false);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipo)
                    .addComponent(jLabelEstatus))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipo)
                    .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstatus)
                    .addComponent(jTextEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTipoKeyReleased
        habilitar();
    }//GEN-LAST:event_jTextTipoKeyReleased

    private void jTextEstatusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEstatusKeyReleased
        habilitar();
    }//GEN-LAST:event_jTextEstatusKeyReleased
    /**
     * Maneja el evento de clic en el botón "Agregar". Captura los datos
     * ingresados en los campos de texto, los empaqueta como JSON y los envía al
     * backend mediante una solicitud POST para crear un nuevo trámite. Muestra
     * un mensaje de éxito si la creación fue exitosa, o un mensaje de error si
     * el servicio está inactivo.
     *
     * @param evt El evento de acción generado por el clic en el botón.
     */
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String tipo = jTextTipo.getText();
        String estatus = jTextEstatus.getText();
        String json = "{ \"tipo\": \"" + tipo + "\", \"estado\": \"" + estatus + "\" }";
        try {
            String response = ClienteRequestTransaction.requestTransactionPostNuevo(json);
            if (response != null) {
                JOptionPane.showMessageDialog(rootPane, "Tramite Creado Exitosamente", "Tramite Creado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "❌ No se pudo crear el usuario.\nLa base de datos no está activa o no se pudo conectar.", "Error al crear usuario", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
                           JOptionPane.showMessageDialog(null, "❌ No se pudo conectar al servicio.\nVerifique que esté levantado.", "Error de conexión", JOptionPane.ERROR_MESSAGE); }
        contenedor.dispose();
        padre.inicio();
    }//GEN-LAST:event_jButtonAgregarActionPerformed
    /**
     * Maneja el evento de clic en el botón "Cancelar". Cierra esta ventana
     * interna y también el contenedor padre (JDialog).
     *
     * @param evt El evento de acción generado por el clic en el botón.
     */
    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
        contenedor.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed
    /**
     * Habilita o deshabilita el botón "Agregar" según el contenido de los
     * campos de entrada. Si ambos campos (`estatus` y `tipo`) contienen texto,
     * se habilita el botón. Si alguno está vacío, se deshabilita para evitar
     * envíos incompletos.
     */

    private void habilitar() {
        String username = jTextEstatus.getText();
        String email = jTextTipo.getText();
        if (!username.isEmpty() && !email.isEmpty()) {
            jButtonAgregar.setEnabled(true);
        } else {
            jButtonAgregar.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JLabel jLabelEstatus;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JTextField jTextEstatus;
    private javax.swing.JTextField jTextTipo;
    // End of variables declaration//GEN-END:variables
}
