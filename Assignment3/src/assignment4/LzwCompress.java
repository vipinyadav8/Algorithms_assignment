/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.HashMap;
import java.io.*;
/**
 *
 * @author Vipin
 */
public class LzwCompress {
    
    private static ProbeHashMap<String, Integer> dict = new ProbeHashMap<String, Integer>(65537);
    private static int count;
    
    
    
    public static void main(String[] args) throws IOException {
//        String originalFilename = args[0];
//        String compressedFilename = args[1];
       
        dictionary();

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("test_case2.txt");
            outputStream = new FileWriter("output_compressed.txt");
            
            int q;
            String p = Character.toString((char)inputStream.read());
            
            while((q = inputStream.read()) != -1) {
                
                String c = Character.toString((char)q);
                
                if(dict.containsKey(p+c)){
                    p = p + c;                    
                } 
                else{
                    outputStream.write((dict.get(p)) + " ");
                    dict.put(p+c, count++);
                    p = c;
                }
            }
            outputStream.write((dict.get(p)) + "");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    /**initiates a dictionary*/
    public static void dictionary() {
        count = 1;
        while(count <128){
            char y = (char)count;
            dict.put(Character.toString(y), count++);
        }
    }
    
    /**inputs a key and changes its value to 16 bit number*/
    public static byte[] intToByte(int n){
        byte[] code = new byte[2];
        int n1 = n / 256;
        int n2 = n % 256;
        if(n1 <= 127){
            code[0] = (byte) n1;
        }
        else{
            code[0] = (byte) (-256 + n1);
        }
        if(n2 <= 127){
            code[1] = (byte) n2;
        }
        else{
            code[1] = (byte) (-256 + n2);
        }
        return code;
    }
}
