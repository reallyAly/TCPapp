package tcp.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.Socket;
import tcp.model.Client;

/**
 *
 * @author alysson
 */
public class ClientController {
    
    private Socket connection;
    
    private ObjectOutputStream output;

    private Client client = null;
    
    

    public Socket getConnection() {
        return connection;
    }

    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Socket connectWithServer(Client clientData, String address, int port) throws IOException {
        
        if(clientData == null){
           throw new IOException("Client cannot be null");
        }
        
        this.client = clientData;
        
        this.connection = new Socket(address, port); 
        
        this.sentMessage();
        
        return this.connection;
    }
    
    public void closeConnection() throws IOException {
        this.connection.close();
    }
    
    public void sentMessage() throws IOException {
        output = new ObjectOutputStream(this.connection.getOutputStream());
        output.writeObject(client);
    }
}
