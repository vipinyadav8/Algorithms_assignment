/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Vipin
 */
public class LzwDecompress {
    
    private static ProbeHashMap<Integer, String> dict = new ProbeHashMap<>(65537);
    private static int i = 0;
    static int count;
    
    
    public static void main(String[] args) throws IOException {      
        String compressedFilename = args[0];
        String decompressedFilename = args[1];
        
        dictionary();
        
        FileWriter outputStream = new FileWriter(decompressedFilename);
        Scanner s = new Scanner(new FileReader(compressedFilename));
        
        int a = Integer.parseInt(s.next());
        String p = dict.get(a);
        
        while(s.hasNext()){
            outputStream.write(p);
            
            int b = Integer.parseInt(s.next());
            
            if(dict.get(b) != null){
                String q = dict.get(b);
                dict.put(count++, p + q.charAt(0));                
            }
            else{
                dict.put(count++, p + p.charAt(0));
            }
            a = b;
            p = dict.get(a);
        }
        outputStream.write(p);
        try {
            if (s != null) {
                s.close();
            }
            
            if (outputStream != null){
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static void dictionary() {
        count = 1;
        while(count <128){
            char y = (char)count;
            dict.put(count++, Character.toString(y));
        }
    }
}
