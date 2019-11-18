/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 */
public class ObjectNode {
    
    private ObjectNode parent;
    private ObjectNode leftChild;
    private ObjectNode rightChild;
    private int objectId;
    private int objectSize;
    private BinNode binNode;
    
    public ObjectNode(ObjectNode p, ObjectNode l, ObjectNode r, int i, int c, BinNode b){
        parent = p;
        leftChild = l;
        rightChild = r;
        objectId = i;
        objectSize = c;
        binNode = b;
    }
    
    
    //accessor methods 
    /*returns the parent node*/
    public ObjectNode getParent(){
        return parent;
    }
    
    /*returns the left child node*/
    public ObjectNode getLeftChild(){
        return leftChild;
    }
    
    /*returns the right child node*/
    public ObjectNode getRightChild(){
        return rightChild;
    }
    
    /*returns the object's id stored in the node*/
    public int getObjectId(){
        return objectId;
    }
    
    /*returns the object's size stored in the node*/
    public int getObjectSize(){
        return objectSize;
    }
    
    /**returns the bin node stored in the object node*/
    public BinNode getBinNode(){
        return binNode;
    }
        
    //update methods
    /*updates the value of parent node*/
    public void setParent(ObjectNode p){
        parent = p;
    }
    
    /*updates the value of left child node*/
    public void setLeftChild(ObjectNode l){
        leftChild = l;
    }
    
    /*updates the value of right child node*/
    public void setRightChild(ObjectNode r){
        rightChild = r;
    }
    
    /*updates the bin id stored in the node*/
    public void setObjectId(int b){
        objectId = b;
    }
    
    /*updates the bin capacity stored in the node*/
    public void setObjectSize(int c){
        objectSize = c;
    }
    
    /**updates the value of bin node stored in the object node*/
    public void setBinNode(BinNode b){
        binNode = b;
    }
    
    /**return the string representation of node*/
    public String toString() {
        return (this.getObjectId() + " " + this.getObjectSize());
    }
    
}
