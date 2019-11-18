/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 */
public class LinkedNode<E> {
    
    private E value;                        // value (or data) stored in the node object
    private LinkedNode<E> prev;                  // reference of the previous node object
    private LinkedNode<E> next;                  // reference of the next node object
    
    /*Constructs a new node object*/
    public LinkedNode(E v, LinkedNode<E> p, LinkedNode<E> n){
        value = v;
        prev = p;
        next = n;
    }
    
    /*returns the value of the element*/
    public E getElement(){
        return value;
    }
    
    /*returns the refernce of the previous node*/
    public LinkedNode<E> getPrev(){
        return prev;
    }
    
    /*returns the refernce of the next node*/
    public LinkedNode<E> getNext(){
        return next;
    }
    
    /**returns the previous element*/
    public E getPrevElement(){
        return this.getPrev().getElement();
    }
    
    /**returns the next element*/
    public E getNextElement(){
        return this.getNext().getElement();
    }
    
    /*update value stored in node object*/
    public void setValue(E v){
        value = v;
    }
    
    /*updates refernce stored in next*/
    public void setNext(LinkedNode<E> n){
        next = n;
    }
    
    /*updates reference stored in prev*/
    public void setPrev(LinkedNode<E> p){
        prev = p;
    }
}
