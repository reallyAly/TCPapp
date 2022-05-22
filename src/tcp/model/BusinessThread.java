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
/**
 *
 * @author alysson
 */
public class BusinessThread extends Thread{
    
    private static ServerSocket server;
    private static Socket connection;
    
    private static ObjectInputStream input;
    private Client client;

    public BusinessThread(Socket c) {
        connection = c;
    }
    
    public Client getClient() {
        return this.client;
    }

    @Override
    public void run() {
         try {
             
             input = new ObjectInputStream(connection.getInputStream());
             
             this.client = (Client) input.readObject();
             
         } catch (IOException | ClassNotFoundException ex) {
             Logger.getLogger(BusinessThread.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
}
