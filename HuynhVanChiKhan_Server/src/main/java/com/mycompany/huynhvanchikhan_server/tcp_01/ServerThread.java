/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huynhvanchikhan_server.tcp_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author huynh
 */
public class ServerThread implements Runnable{
    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;

    public ServerThread(Socket socket, String name)  throws IOException{
        this.socket = socket;
        this.name = name;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start();
    }
    
    @Override
    public void run(){
        try {
            while(true){
                String message = in.nextLine().trim();
                message = message.toUpperCase();
                out.println(message);
            }
        } catch (Exception e) {
            System.out.println(name + " has departed");
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                
            }
        }
    }
    
}
