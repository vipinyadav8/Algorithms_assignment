/*
 * To change this license header, choose License Header in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Vipin Yadav
 */
public class MySearchTree {
    //-----Nested Node Class-------
    static class Node {
        private MyTree.Node<String> origNode;       //pointer to node in original tree
        private Node parent;             //pointer to the parent node
        private Node left;          //pointer to the left child
        private Node right;       //pointer to the right child
        
        /**Constructs a new node object for tree*/
        public Node(MyTree.Node<String> n, Node p, Node l, Node r) {
            this.origNode = n;
            this.parent = p;
            this.left = l;
            this.right = r;
        }
        
        //overloaded constructor
        /**constructs a new node with parent, left and right all set to null*/
        public Node(MyTree.Node<String> n) {
            this(n, null, null, null);
        }
        
        /**returns true if node has left child*/
        public boolean hasLeftChild() {
            return this.left != null;
        }
        /**returns true if node n has right sibling*/
        public boolean hasRightChild() {
            return this.right != null;
        }
    
        //query methods
        public Node getParent() {return this.parent;}
        
        public Node getLeftChild() {return this.left;}
        
        public Node getRightChild() {return right;}
        
        public String getKey() {
            return this.origNode.getKey();
        }
        
        public MyTree.Node<String> getNode() {return origNode;}
        
        public void setOrigNode(MyTree.Node<String> n) {
             this.origNode = n;
        }
        
        public void setParent(Node p) {
            this.parent = p;
        }
        
        public void setLeftChild(Node l) {
            this.left = l;
        }
        
        public void setRightChild(Node r) {
            this.right = r;
        }
        
        /**return the string representation of node*/
        public String toString() {
            return this.origNode.toString();
        }
    }
    //---end of Nested node class----
    
    Node root;
    
    /**Constructs a new binary search tree*/
    public MySearchTree() {
      
    }
    
    /**returns the node with key k stored in subtree with root x*/
    public Node treeSearch(Node x, String k) {
        //System.out.println("----tree search is called() with x = " + x + ", key = " + k);
        if (x != null && k.compareTo(x.getKey()) != 0) {
            //System.out.println("----------------k.compareTo(x.getKey()) != 0------");
            if (k.compareTo(x.getKey()) > 0) {               
                return treeSearch(x.getRightChild(), k);                
            }            
            else {                
                return treeSearch(x.getLeftChild(), k);
            } 
        }
        else
            return x;
        
    }
    
    /**returns the node with key k if present, else return null*/
    public Node treeSearch(String k) {
        return this.treeSearch(root, k);
    }
    
    /**returns the node with minimum key stored in subtree with root x*/
    public Node treeMinimum(Node x) {
        while (x.getLeftChild() != null) {
            x = x.getLeftChild();
        }
        return x;
    }
    
    /**returns the node with maximum key stored in subtree with root x*/
    public Node treeMaximum(Node x) {
        while (x.getRightChild() != null) {
            x = x.getRightChild();
        }
        return x;
    }
    
    /**returns the successor node i.e. the node with minimum key greater than key[x]*/
    public Node successor(Node x) {
        if (x.getRightChild() != null) {
            return treeMinimum(x);
        }
        Node y = x.getParent();
        while (y != null && x == y.getRightChild()) {
            x = y;
            y = y.getParent();
        }
        return y;
    }
    
    /**insert a new node z to the tree
     * z is Node of MySearchTree
     */
    public void treeInsert(Node z) {
        if (this.root == null) {
            root = z;
        } else {
            Node x = this.root;
            Node y = x.getParent();
            
            while (x != null) {
                y = x;
                if (z.getKey().compareTo(x.getKey()) >= 0) {
                    x = x.getRightChild();
                } else {
                    x = x.getLeftChild();
                }
            }
            if (z.getKey().compareTo(y.getKey()) >= 0) {
                y.setRightChild(z);
            } else {
                y.setLeftChild(z);
            }
            z.setParent(y);
        }
    }
    
    
    /**insert a new node x to the tree
     * x is node of MyTree class
     */
    public void treeInsert(MyTree.Node<String> x) {
        Node n = new Node(x, null, null, null);
        this.treeInsert(n);
    }
    /**deletes the node z from tree*/
    public void treeDeletion(Node z) {
        
            
    }
}
