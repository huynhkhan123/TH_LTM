package com.mycompany.huynhvanchikhan_server.tcp_02;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huynh
 */
public class ServerThread implements Runnable{
    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;

    public ServerThread(Socket socket, String name) throws IOException{
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
                Scanner sc = new Scanner(message);
                sc.useDelimiter("@");
                int number_a = sc.nextInt();
                String operation = sc.next();
                int number_b = sc.nextInt();
                
                switch(operation){
                    case "+" -> out.println(number_a + number_b);
                    case "-" -> out.println(number_a - number_b);
                    case "*" -> out.println(number_a * number_b);
                    case "/" -> out.println((double)number_a / number_b);
                    default -> out.println("Calculated error!");
                }
            }
        } catch (Exception e) {
            System.out.println(name + " has departed");
        }finally{
            try {
                socket.close();
            } catch (Exception e) {
                
            }
        }
    }
}
