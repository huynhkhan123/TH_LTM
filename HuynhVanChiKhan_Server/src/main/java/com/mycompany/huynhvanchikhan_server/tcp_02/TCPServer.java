/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huynhvanchikhan_server.tcp_02;

import com.mycompany.huynhvanchikhan_server.tcp_02.ServerThread;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author huynh
 */
public class TCPServer {
    private static final int PORT = 1234;
    private ServerSocket server = null;

    public TCPServer() {
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action(){
        Socket socket = null;
        int i = 0;
        System.out.println("Server listening...");
        try {
            while((socket = server.accept()) != null){
                new ServerThread(socket, "Client #" + i);
                System.out.printf("Thread for Client #%d generating...%n", i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new TCPServer().action();
    }
}
