/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author alysson
 */
public class ServerThread extends Thread {
    
    private ServerSocket server = null;
    private Socket connection = null;
    private JTable table;

    public ServerThread(int port, JTable table) throws IOException {
        this.server = new ServerSocket(port);
        this.table = table;
    }

    @Override
    public void run() {
        
        int counter = 0;
        
        while(true){
            try {
                
                this.connection = server.accept();
                
                BusinessThread businessThread = new BusinessThread(this.connection, this.table, counter);
                
                businessThread.start();
                counter++;
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
