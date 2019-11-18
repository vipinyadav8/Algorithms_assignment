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
public class HashMapDecompress {
    private MapEntry<String, Integer>[] table;
    int capacity = 65537;
    int size;
    LinkedList<MapEntry<String, Integer>> list;
    MapEntry<String, Integer> DEFUNCT;
    
    public HashMapDecompress() {
        table = (MapEntry<String, Integer>[]) new MapEntry[capacity];
        list = new LinkedList<>();
        DEFUNCT = new MapEntry<>(null, null);
    }
    
    
    /**returns the hash function */
    public int hashFunction(int i){        
        int index = i % capacity;
        return index;
    }
    
    /**insert a MapEntry*/
    public  void put(String s, Integer i){
        int b=1;
        int c = hashFunction(i);
        if(table[c] == null || table[c] == DEFUNCT){
            table[c] = new MapEntry(s, i);
        }      
        else{
            while( (table[(c + (b*b)) % capacity] != null) && (table[(c + (b*b)) % capacity] != DEFUNCT) ){
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
    public  String get(int i){
        int b = 1;
        int q = hashFunction(i);
        if(table[q].getValue() == i){
            return table[q].getKey();
        }
        else{
            while(table[(q + (b*b)) % capacity] != null){
                if(table[q].getValue() == i){
                    break;
                }
                else{
                    b++;
                }                
            }
            if(table[q].getValue() == i){
                return table[q].getKey();
            }
            else{
                return null;
            }
        }
    }
    
    /**returns the index of the*/
    public  int getIndex(int i){
        int b = 1;
        int l = hashFunction(i);
        if(table[l].getValue() == i){
            return l;
        }
        else{
            while(table[(l + (b*b)) % capacity] != null){
                if(table[l].getValue() == i){
                    break;
                }
                else{
                    b++;
                }                
            }
            if(table[l].getValue() == i){
                return l;
            }
            else{
                return 0;
            }
        }
    }
    
    /**deletes an map entry*/
    public  void delete(int i){
        int x = getIndex(i);
        if(x != 0){
            table[x] = DEFUNCT;
        }
    }
    
    /**resizes the array if load factor is > 0.5*/
    public  void reSize(){
        table = (MapEntry<String, Integer>[]) new MapEntry[capacity];
        
        for (MapEntry<String, Integer> e : entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }
    
}
