/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
/**
 *
 * @author alysson
 */
public class BusinessThread extends Thread{
    
    private ServerSocket server;
    
    private Socket connection;
    
    private ObjectInputStream input;

    private int tableLine;
    
    private JTable table;

    public BusinessThread(Socket c, JTable table, int tableLine) {
        connection = c;
        this.table = table;
        this.tableLine = tableLine;
    }
    
    @Override
    public void run() {
         try {
             
            this.table.setValueAt("Connected", this.tableLine, 1);
             
            while(true) {
                
                input = new ObjectInputStream(connection.getInputStream());
             
                Client client = (Client) input.readObject();
                
                if("HtI9AnsN&brq".equals(client.getMessage())) {
                    this.table.setValueAt("Disconnected", this.tableLine, 1);
                    this.table.setValueAt("End", this.tableLine, 2);
                   
                    break;
                }
                
                this.table.setValueAt(client.getName(), this.tableLine, 0);
                this.table.setValueAt(client.getMessage(), this.tableLine, 2);
            } 
            
            this.connection.close();

         } catch (IOException | ClassNotFoundException ex) {
             Logger.getLogger(BusinessThread.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
}
