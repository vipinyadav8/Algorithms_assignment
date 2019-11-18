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
public class Decompress {
    
    private static ProbeHashMap<Integer, String> dict = new ProbeHashMap<>(65537);
    private static int i = 0;
    static int count;
    
    
    public static void main(String[] args) throws IOException {      
        String compressedFilename = args[0];
        String decompressedFilename = args[1];
        
        dictionary();
        
        FileWriter outputStream = new FileWriter(decompressedFilename);
        Scanner s = new Scanner(new FileReader(compressedFilename));
        
        //byte e = (byte)Integer.parseInt(s.next());
        //byte r = (byte)Integer.parseInt(s.next());
        //int a = byteToInt(e, r);
        int a = Integer.parseInt(s.next());
        String p = dict.get(a);
        
        while(s.hasNext()){
            outputStream.write(p);
            //byte z = (byte)Integer.parseInt(s.next());
            //byte w = (byte)Integer.parseInt(s.next());
            //int b = byteToInt(z, w);
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
    
    /**initiates a dictionary*/
    public static void dictionary() {
        count = 1;
        while(count <128){
            char y = (char)count;
            dict.put(count++, Character.toString(y));
        }
    }
    
    /**converts a byte to integer*/
    public static int byteToInt(byte a, byte b){
        int n1;
        int n2;
        int[] first = new int[1000];
        int[] last = new int[1000];
        if(a > 0){
            n1 = a;
        }
        else{
            n1 = a + 256;
        }
        if(a > 0){
            n2 = b;
        }
        else{
            n2 = b + 256;
        }
        first = intToBinary(n1);
        last = intToBinary(n2);
        for(int j = 0; j <8; j++){
            first[7 + j] = last[j];
        }
        int t = binaryToInt(first);
        return t;
    }
    
    /**converts an integer to binary*/
    public static int[] intToBinary(int n){
        int[] binaryNum = new int[1000];
        int[] binaryNum1 = new int[1000];
        int i = 0;
        while(n > 0){
            binaryNum[i] = n % 2;
            n = n/ 2;
            i++;
        }
        while(i<8){
            binaryNum[i] = 0;
            i++;
        }
        for(int j = i - 1; j>=0; j--){
            binaryNum1[8-j] = binaryNum[j];
        }
        return binaryNum1;
    }
    
    /**converts integer to binary*/
    public static int binaryToInt(int[] a){
        int t =0;
        for(int i = 0;i < 16;i++){
            if(a[i] == 1){
                t = t+(2^(15-i));
            }
        }
        return t;
    }
}
