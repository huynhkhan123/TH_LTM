/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Administrator
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
