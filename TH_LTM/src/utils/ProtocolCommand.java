/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package utils;

/**
 *
 * @author huynh
 */
public enum ProtocolCommand {
    NO_COMMAND(0),
    LOGIN(1),
    LOGIN_FAILED(0),
    LOGIN_SUCCESS(1),
    UPLOAD(3),
    DOWNLOAD(4),
    EXIT(2);
    
    private final int code;

    private ProtocolCommand(int code) {
        this.code = code;
    }
    
    public int getCode(){
        return code;
    }
    
}
