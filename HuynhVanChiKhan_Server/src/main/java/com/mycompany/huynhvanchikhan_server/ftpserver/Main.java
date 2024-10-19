/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huynhvanchikhan_server.ftpserver;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author huynh
 */
public class Main {

    public static final int PORT = 10000;
    private ServerSocket server = null;

    public Main() {
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void action() {
        Socket socket = null;
        int i = 0;
        System.out.println("Server listening...");
        try {
            while ((socket = server.accept()) != null) {
                new FTPThread(socket, "client " + i);
                System.out.printf("Thread for client %d generating...%n", i++);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
