package tcp.controller;

import java.io.IOException;
import javax.swing.JTable;
import tcp.model.ServerThread;

/**
 *
 * @author alysson
 */
public class ServerController {
    
    public void startServer(int port, JTable table) throws IOException {
        new Thread(new ServerThread(port, table)).start();
    }
    
}
