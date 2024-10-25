/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author ADMIN
 */
public class UDPServer {
    static final int PORT = 1234;
    private DatagramSocket socket = null;
    public UDPServer() throws SocketException{
        socket = new DatagramSocket(PORT);
    }
    public void action() throws IOException{
        InetAddress host = null;
        int port;
        String chuoi = "";
        System.out.println("Server is listening");
        while(true){
            DatagramPacket packet = receive();
            host = packet.getAddress();
            port = packet.getPort();
            chuoi = new String(packet.getData()).trim();
            
            chuoi = chuoi.toUpperCase();
            if(!chuoi.equals("")){
                send(chuoi, host, port);
            }
        }
    }
    private void send(String chuoi, InetAddress host, int port) throws IOException{
        byte[] buffer = chuoi.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, host,port);
        socket.send(packet);
    }
    private DatagramPacket receive() throws IOException{
        byte[] buffer = new byte[65507];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet;
    }
    public static void main(String[] args) throws SocketException, IOException {
        new UDPServer().action();
    }
}
