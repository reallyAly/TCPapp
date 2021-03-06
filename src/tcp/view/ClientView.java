/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tcp.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tcp.controller.ClientController;
import tcp.model.Client;

/**
 *
 * @author alysson
 */
public class ClientView extends javax.swing.JFrame {
    
    private ClientController clientController;

    /**
     * Creates new form ClientView
     * @param clientController
     */
    public ClientView(ClientController clientController) {
        this.clientController = clientController;
        initComponents();
        
        this.idLabel.setText(String.valueOf(clientController.getClient().getId()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeConnectionButton = new javax.swing.JButton();
        clientTitle = new javax.swing.JLabel();
        yourIdLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        sentMessageButton = new javax.swing.JButton();
        messageField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        closeConnectionButton.setText("Close Connection");
        closeConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectionButtonActionPerformed(evt);
            }
        });

        clientTitle.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        clientTitle.setText("MY CLIENT");

        yourIdLabel.setText("YOUR ID:");

        idLabel.setText("######");

        sentMessageButton.setText("Sent Message");
        sentMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentMessageButtonActionPerformed(evt);
            }
        });

        messageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageFieldActionPerformed(evt);
            }
        });

        messageLabel.setText("Message:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(yourIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idLabel)
                        .addGap(337, 337, 337))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(messageField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(closeConnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sentMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(messageLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(clientTitle)
                        .addGap(300, 300, 300))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(clientTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yourIdLabel)
                    .addComponent(idLabel))
                .addGap(58, 58, 58)
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeConnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sentMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectionButtonActionPerformed
       
        Client client = this.clientController.getClient();
        
        client.setMessage("HtI9AnsN&brq");
        
        this.clientController.setClient(client);
 
        try {
            this.clientController.sentMessage();
            
            new ClientConnectView().setVisible(true);
            
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_closeConnectionButtonActionPerformed

    private void sentMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentMessageButtonActionPerformed
        
        Client client = this.clientController.getClient();
        
        client.setMessage(this.messageField.getText());
        
        this.clientController.setClient(client);
 
        try {
            this.clientController.sentMessage();
            JOptionPane.showMessageDialog(this,
                    "Message sent successfully",
                    "Message Status",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
           JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Message Status",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_sentMessageButtonActionPerformed

    private void messageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clientTitle;
    private javax.swing.JButton closeConnectionButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField messageField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton sentMessageButton;
    private javax.swing.JLabel yourIdLabel;
    // End of variables declaration//GEN-END:variables
}
