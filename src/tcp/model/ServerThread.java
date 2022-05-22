/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
    
    private ArrayList<Thread> threadList = new ArrayList<>();
    
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
                
                BusinessThread thread = new BusinessThread(this.connection);
                
                thread.start();
                thread.join();

                this.threadList.add(thread);
                
                this.table.setValueAt(thread.getClient().getName(), counter, 0);
                
                counter++;
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
