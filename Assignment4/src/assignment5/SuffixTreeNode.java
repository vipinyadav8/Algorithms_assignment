/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.LinkedList;

/**
 *
 * @author Vipin
 */
public class SuffixTreeNode {
    
    private SuffixTreeNode parent;
    private SuffixTreeNode rightSibling;
    private SuffixTreeNode leftChild;
    private int startIndex;
    private int endIndex;
    
    public SuffixTreeNode(SuffixTreeNode p, SuffixTreeNode r, SuffixTreeNode l, int s, int e){
        parent = p;
        rightSibling = r;
        leftChild = l;
        startIndex = s;
        endIndex = e;
    }
    
    /**returns the parent of the node*/
    public SuffixTreeNode getParent(){
        return parent;
    }
    
    /**returns the right sibling of the node*/
    public SuffixTreeNode getRightSibling(){
        return rightSibling;
    }
    
    /**returns the left most child of the node*/
    public SuffixTreeNode getLeftChild(){
        return leftChild;
    }
    
    /**returns the start index stored*/
    public int getStartIndex(){
        return startIndex;
    }
    
    /**returns the end index*/
    public int getEndIndex(){
        return endIndex;
    }
    
    /**Return an iterable collection of children nodes*/
    public Iterable<SuffixTreeNode> children() {
        LinkedList<SuffixTreeNode> childList = new LinkedList<>();
        
        if (this.leftChild != null) {
            SuffixTreeNode current = this.leftChild;
            while (current != null) {
                childList.add(current);
                current = current.getRightSibling();
            }
        }
        
        return childList;
    }
    
    //update methods
    /**updates the parent of the node*/
    public void setParent(SuffixTreeNode p){
        parent = p;
    }
    
    /**updates the parent of the node*/
    public void setRightSibling(SuffixTreeNode r){
        rightSibling = r;
    }
    
    /**updates the parent of the node*/
    public void setLeftChild(SuffixTreeNode l){
        leftChild = l;
    }
    
    /**updates the parent of the node*/
    public void setStartIndex(int s){
        startIndex = s;
    }
    
    /**updates the parent of the node*/
    public void setEndIndex(int e){
        endIndex = e;
    }
    
    public String toString() {
        return "[" + this.getStartIndex() + ", " + this.getEndIndex() + "]";
    }
}
