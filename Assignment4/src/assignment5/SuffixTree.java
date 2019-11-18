/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author Vipin
 */
public class SuffixTree {
    
    public static void main(String[] args){
        String filename = "test.txt";
        String output = "output.txt";
        BufferedReader br = null;
        String p;
        Tree tree;
        Tree1 tree1;
        String s = "#";
        String T;
        int n;
        try{
            br = new BufferedReader(new FileReader(filename));
            p = br.readLine();
            T = p + s;
            tree = new Tree(T);
            for(int i = 0; i < T.length()-1; i++){
                tree.insert(i, T.length()-1);
            }
            //System.out.println("------tree------------");
            //tree.print();
            //System.out.println(tree.root.getLeftChild().getRightSibling().getRightSibling().getRightSibling());
            n = Integer.parseInt(br.readLine());
            for(int i =0; i < n; i++){
                String query = br.readLine();
                //System.out.println(query);
                boolean a = query.contains("*");
                if(a == true){
                    
                }
                else{
                    tree.search(query);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
//        String A = "indian institute of technology india";
//        T = A + s;
//        tree1 = new Tree1(T);
//        for(int i = 0; i < T.length()-1; i++){
//            tree1.insert(i, T.length()-1);
//        }
//        tree1.search("i");
        //System.out.println("print tree");
        //tree.print();
        
    }
    
}
