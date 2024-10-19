/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huynhvanchikhan_server.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author huynh
 */
public class PasswordUtils {
    public static String hashPassword(String password){
        try {
            return BCrypt.hashpw(password, BCrypt.gensalt());
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static boolean checkPassword(String password, String hashed){
        return BCrypt.checkpw(password, hashed);
    }
}
