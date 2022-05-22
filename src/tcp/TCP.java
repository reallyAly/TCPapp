/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp;

import tcp.view.ServerView;
import tcp.view.ClientConnectView;

/**
 *
 * @author alysson
 */
public class TCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ServerView().setVisible(true);
        new ClientConnectView().setVisible(true);
    }
    
}
