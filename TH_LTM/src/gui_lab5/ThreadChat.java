/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_lab5;

import com.sun.tools.jdeprscan.scan.Scan;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author huynh
 */
public class ThreadChat implements Runnable{
    private static final int PORT = 1234;
    private Scanner in = null;
    private Socket socket = null;
    public frmTCPClient03 chat = null;
    private ServerSocket server = null;
    
    public ThreadChat(){
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }
    
    @Override
    public void run(){
        try {
            while(true){
                while((socket = server.accept()) != null){
                    this.in = new Scanner(this.socket.getInputStream());
                    String message = in.nextLine().trim();
                    chat.Display(message + "\n");
                }
            }
        } catch (Exception e) {
        }finally{
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
