/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 */
public class BinIdNode {
    
    private BinNode parent;
    private BinNode leftChild;
    private BinNode rightChild;
    private int binId;
    private int binCapacity;
    private LinkedList<ObjectNode> objList = new LinkedList<>();
    
    public BinIdNode(BinNode p, BinNode l, BinNode r, int i, int c, LinkedList<ObjectNode> o){
        parent = p;
        leftChild = l;
        rightChild = r;
        binId = i;
        binCapacity = c;
        objList = o;
    }
    
    //accessor methods 
    /*returns the parent node*/
    public BinNode getParent(){
        return parent;
    }
    
    /*returns the left child node*/
    public BinNode getLeftChild(){
        return leftChild;
    }
    
    /*returns the right child node*/
    public BinNode getRightChild(){
        return rightChild;
    }
    
    /*returns the bin id stored in the node*/
    public int getBinId(){
        return binId;
    }
    
    /*returns the capacity of bin stored in the node*/
    public int getBinCapacity(){
        return binCapacity;
    }
    
    public LinkedList getObjectList(){
        return objList;
    }
    
        
    //update methods
    /*updates the value of parent node*/
    public void setParent(BinNode p){
        parent = p;
    }
    
    /*updates the value of left child node*/
    public void setLeftChild(BinNode l){
        leftChild = l;
    }
    
    /*updates the value of right child node*/
    public void setRightChild(BinNode r){
        rightChild = r;
    }
    
    /*updates the bin id stored in the node*/
    public void setBinId(int b){
        binId = b;
    }
    
    /*updates the bin capacity stored in the node*/
    public void setBinCapacity(int c){
        binCapacity = c;
    } 
    
    /**return the string representation of node*/
    public String toString() {
        return ("<BinNode> : " + this.getBinCapacity());
    }
    
    /**stores object id and size in the linked list*/
    public void storeObjectList(ObjectNode o){
        this.getObjectList().addLast(o);        
    }
    
    /**deletes object id and size from the linked list*/
    public void deleteObjectList(ObjectNode o){
        this.getObjectList().remove(o);
    }
    
    /**prints the list of the objects stored in the list*/
//    public void printList(){
//        this.getObjectList().printList();
//    }
}
