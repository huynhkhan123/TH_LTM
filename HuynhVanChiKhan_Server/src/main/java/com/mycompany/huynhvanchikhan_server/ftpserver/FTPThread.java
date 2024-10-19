package com.mycompany.huynhvanchikhan_server.ftpserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mycompany.huynhvanchikhan_server.db.DBAccess;
import com.mycompany.huynhvanchikhan_server.entities.User;
import com.mycompany.huynhvanchikhan_server.utils.PasswordUtils;
import com.mycompany.huynhvanchikhan_server.utils.ProtocolCommand;

public class FTPThread implements Runnable {

    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;
    // String path = "1";

    public FTPThread(Socket socket, String name) throws IOException {
        this.socket = socket;
        this.name = name;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start();
    }

    public static int isCommand(String cmd) {
        switch (cmd) {
            case "LOGIN":
                return ProtocolCommand.LOGIN.getCode();
            case "UPLOAD":
                return ProtocolCommand.UPLOAD.getCode();
            case "DOWNLOAD":
                return ProtocolCommand.DOWNLOAD.getCode();
            case "REGISTER":
                return ProtocolCommand.REGISTER.getCode();
            default:
                return ProtocolCommand.NO_COMMAND.getCode();
        }
    }

    public void returnClientDirectory(String path, PrintWriter out) {
        try {
            File dir = new File(path);
            System.out.println("path: " + path);
            File[] files;
            System.out.println("File reading");
            try {
                files = dir.listFiles();
                System.out.println("List file retrieved");
                out.println(files.length);
                System.out.println("length: " + files.length);
                for (File file : files) {
                    out.println(file.getName());
                }
                out.flush();
                System.out.println("Client sent");
            } catch (Exception e) {
                System.out.println("error read: " + e);
            }
        } catch (Exception e) {
            System.out.println("error reada: " + e);
        }
    }

    @Override
    public void run() {
        try {

            while (true) {
                boolean isLoop = true;

                while (isLoop) {

                    String cmd = in.nextLine();
                    System.out.println("cmd: " + cmd);

                    switch (isCommand(cmd)) {
                        case 1:
                            String username_input = in.nextLine();
                            String password = in.nextLine();
                            String password_hashed = "";
                            User user = null;
                            PrintWriter pw = new PrintWriter(socket.getOutputStream());
                            try {
                                DBAccess acc = new DBAccess();
                                String query = "SELECT * FROM `users` WHERE username = '" + username_input + "'";
                                System.out.println("query: " + query);
                                ResultSet resultSet = acc.getUser(query);
                                while (resultSet.next()) {
                                    int id = resultSet.getInt("id");
                                    String username = resultSet.getString("username");
                                    String repath = resultSet.getString("path");
                                    String password_hash = resultSet.getString("password_hash");
                                    int per = resultSet.getInt("per");
                                    user = new User(id, username, password_hash, per, repath);
                                    // path = user.getPath();
                                    password_hashed = password_hash;
                                }

                                System.out.println("User login: " + user.toString());
                                if (PasswordUtils.checkPassword(password, password_hashed)) {
                                    String request = user.getId() + "@" + user.getUsername() + "@" + user.getPer() + "@"
                                            + user.getPath() + "@" + user.getPassword_hash();
                                    pw.println(ProtocolCommand.LOGIN_SUCCESS.getCode());
                                    pw.flush();
                                    pw.println(request);
                                    pw.flush();
                                    File dir = new File(user.getPath());
                                    File[] files = dir.listFiles();
                                    System.out.println("file length: " + files.length);
                                    if (files == null) {
                                        pw.println(0);
                                        pw.flush();
                                    } else {
                                        pw.println(files.length);
                                        pw.flush();
                                        for (File file : files) {
                                            pw.println(file.getName());
                                            pw.flush();
                                        }
                                    }
                                } else {
                                    pw.println(ProtocolCommand.LOGIN_FAILED.getCode());
                                    pw.flush();
                                }
                            } catch (SQLException e) {

                            }
                            pw.close();
                            break;

                        case 3:
                            System.out.println("Entered update command");
                            String path = in.nextLine();
                            String fileName = in.nextLine();
                            System.out.println("File name retrieved: " + fileName);
                            try {
                                String path2;
                                if (path.lastIndexOf("/") >= path.length() - 1)
                                    path2 = path + fileName;
                                else
                                    path2 = path + "/" + fileName;
                                System.out.println("path current: " + path);
                                System.out.println("path new: " + path2);
                                FileOutputStream fos = new FileOutputStream(new File(path2));
                                BufferedOutputStream bos = new BufferedOutputStream(fos);
                                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                                byte[] buf = new byte[bis.available()];
                                bos.write(bis.read(buf));
                                bos.flush();
                                bos.close();
                                PrintWriter pw1 = new PrintWriter(socket.getOutputStream());
                                pw1.println("RECEIVED");
                                pw1.flush();
                                returnClientDirectory(path, pw1);
                                pw1.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            System.out.println("Downloading");
                            String path1 = in.nextLine();
                            String fileNameD = in.nextLine();
                            System.out.println("File name: " + fileNameD);
                            try {
                                String cpath;
                                if (path1.lastIndexOf("/") >= path1.length() - 1) {
                                    cpath = path1 + fileNameD;
                                } else {
                                    cpath = path1 + "/" + fileNameD;
                                }

                                System.out.println("cpath: " + cpath);
                                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(cpath));
                                byte[] buf = new byte[bis.available()];
                                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

                                bos.write(bis.read(buf));
                                System.out.println("send data to client");
                                bos.flush();
                                Scanner scReq = new Scanner(socket.getInputStream());
                                String cmdReq = scReq.nextLine();
                                if (cmdReq.equals("RECEIVED")) {
                                    System.out.println("data sent to client successfully");
                                } else {
                                    System.out.println("data sent to client fail");
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 5:
                            PrintWriter pw2 = new PrintWriter(socket.getOutputStream());
                            // Scanner sc = new Scanner(socket.getInputStream());
                            try {
                                DBAccess acc = new DBAccess();
                                String username = in.nextLine();
                                String password_hash = in.nextLine();
                                String path_reg = in.nextLine();
                                int control = in.nextInt();
                                String query = "INSERT INTO `users`( `username`, `path`, `per`, `password_hash`) VALUES ('"
                                        + username + "','" + path_reg + "','" + control + "','" + password_hash + "')";
                                System.out.println("query: " + query);
                                int res = acc.Update(query);
                                pw2.println(res);
                                pw2.flush();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            System.out.println("Waiting for command....");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
    }
}
