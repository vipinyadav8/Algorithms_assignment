/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.util.LinkedList;
/**
 *
 * @author Vipin
 */
public class MyHashMap {
    private MapEntry<String, Integer>[] table;
    int capacity = 65537;
    int size;
    LinkedList<MapEntry<String, Integer>> list;
    MapEntry<String, Integer> DEFUNCT;
    
    
    public MyHashMap() {
        table = (MapEntry<String, Integer>[]) new MapEntry[capacity];
        list = new LinkedList<>();
        DEFUNCT = new MapEntry<>(null, null);
    }
    
    /**returns the hash code*/
    public int hashCode(String s){
        int length = s.length();
        int h = 0;
        for(int i = 0; i < length; i++){
            h = h + ((int)s.indexOf(i))*(37^(length - 1));
        }
        return h;
    }
    
    /**returns the hash function */
    public int hashFunction(String s){
        int hashcode = hashCode(s);
        int index = hashcode % capacity;
        return index;
    }
    
    /**insert a MapEntry*/
    public  void put(String s, Integer i){
        int b=1;
        int c = hashFunction(s);
        if(table[c] == null || table[c] == DEFUNCT){
            table[c] = new MapEntry(s, i);
        }      
        else{
            while((table[(c + (b*b)) % capacity] != null) && (table[(c + (b*b)) % capacity] != DEFUNCT) ){
                b++;
            }            
            table[(c + (b*b)) % capacity] = new MapEntry(s, i);
        }
        size++;
        list.addLast(new MapEntry(s, i));
    }
    
    /**return linked list of key value pairs */
    public LinkedList<MapEntry<String, Integer>> entrySet(){
        return this.list;
    }
    
    /**return a value corresponding to entry with key s */
    public  int get(String s){
        int b = 1;
        int l = hashFunction(s);
        if(table[l].getKey().equals(s)){
            return table[l].getValue();
        }
        else{
            while(table[(l + (b*b)) % capacity] != null){
                if(table[l].getKey().equals(s)){
                    break;
                }
                else{
                    b++;
                }                
            }
            if(table[l].getKey().equals(s)){
                return table[l].getValue();
            }
            else{
                return 0;
            }
        }
    }
    
    /**returns the index of the*/
    public  int getIndex(String s){
        int b = 1;
        int l = hashFunction(s);
        if(table[l].getKey().equals(s)){
            return l;
        }
        else{
            while(table[l + b*b] != null){
                if(table[l].getKey().equals(s)){
                    break;
                }
                else{
                    b++;
                }                
            }
            if(table[l].getKey().equals(s)){
                return l;
            }
            else{
                return 0;
            }
        }
    }
    
    /**deletes an map entry*/
    public  void delete(String s){
        int x = getIndex(s);
        if(x != 0){
            table[x] = DEFUNCT;
        }
    }
    
    /**checks whether the dictionary contains a key or not*/
    public  boolean containsKey(String s){
        return this.get(s) != 0;
    }
    
    
}    
