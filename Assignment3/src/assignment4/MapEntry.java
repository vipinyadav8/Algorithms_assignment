/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author Vipin
 */
public class MapEntry<K, V> {
    private K key;
    private V value;
    
    public MapEntry(K k, V v){
        key = k;
        value = v;
    }
    
    //update methods
    /**returns the key*/
    public K getKey(){
        return key;
    }
    
    /**returns the value*/
    public V getValue(){
        return value;
    }
    
    /**updates the key*/
    public void setKey(K k){
        key = k;
    }
    
    /**updates the value*/
    public void setValue(V v){
        value = v;
    }
    
}
