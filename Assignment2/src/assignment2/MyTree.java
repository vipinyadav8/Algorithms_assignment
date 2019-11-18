/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * An implementation of left child - right sibling tree
 * @author Vipin Yadav
 */
public class MyTree<E> implements Iterable<E>{
    //-----Nested Node Class-------
    static class Node<X> {
        private X key;                      //key/data of the node
        private Node<X> parent;             //pointer to the parent node
        private Node<X> leftChild;          //pointer to the left child
        private Node<X> rightSibling;       //pointer to the right sibling
        
        /**Constructs a new node object for tree*/
        public Node(X k, Node<X> p, Node<X> lc, Node<X> rs) {
            this.key = k;
            this.parent = p;
            this.leftChild = lc;
            this.rightSibling = rs;
        }
        
        //overloaded constructor
        /**constructs a new node with parent, leftChild and rightSibling all set to null*/
        public Node(X k) {
            this(k, null, null, null);
        }
        
        /**returns true if node has left child*/
        public boolean hasLeftChild() {
            return this.leftChild != null;
        }
        /**returns true if node n has right sibling*/
        public boolean hasRightSibling() {
            return this.getRightSibling() != null;
        }
    
        //query methods
        public X getKey() {return this.key;}
        
        public Node<X> getParent() {return this.parent;}
        
        public Node<X> getLeftChild() {return this.leftChild;}
        
        public Node<X> getRightSibling() {return rightSibling;}
        
        /**adds a new child c to the current node*/
        public void addChild(Node<X> c) {
            if (this.leftChild != null) {
                Node<X> current = this.leftChild;
                while (current.hasRightSibling()) {
                    current = current.getRightSibling();
                }
                current.setRightSibling(c);
            } else {
                this.leftChild = c;
                
            }
            c.setParent(this);
        }
        
            /**Returns the number of children of current node*/
        public int numChildren() {
            int count = 0;

            if (this.leftChild != null) {
                Node<X> current = this.leftChild;
                while (current != null) {
                    count++;
                    current = current.getRightSibling();
                }
            }
            return count;
        }
    
    /**Return an iterable collection of children nodes*/
    public Iterable<Node<X>> children() {
        LinkedList<Node<X>> childList = new LinkedList<>();
        
        if (this.leftChild != null) {
            Node<X> current = this.leftChild;
            while (current != null) {
                childList.add(current);
                current = current.getRightSibling();
            }
        } else {
            return null;
        }
        
        return childList;
    }

        //update methods
        public void setKey(X k) {
            this.key = k;
        }
        
        public void setParent(Node<X> p) {
            this.parent = p;
        }
        
        public void setLeftChild(Node<X> lc) {
            this.leftChild = lc;
        }
        
        public void setRightSibling(Node<X> rs) {
            this.rightSibling = rs;
        }
        
        /*returns the level of the node*/
        public int depth(){
            Node<X> current = this;
            int d= 0;
            while(current.getParent() != null){
                current = current.getParent();
                d++;
            }
            return d;
        }
        
        /**return the string representation of node*/
        public String toString() {
            return this.key.toString();
        }
        
        
    }
    //---end of Nested node class----
    
    //instance variables of a tree object
    private Node<E> root;       //root of tree
    private int size;           //size of/number of nodes in tree 
    
    /**constructs a new tree object with key stored in root*/
    public MyTree(E key) {
        root = new Node<>(key);
    }
    
    public int size() {return this.size;}
    
    public Node<E> root() {return this.root;}
    
    public boolean isEmpty() {return this.root == null;}
    
    /**returns true if node n is a leaf*/
    public boolean isExternal(Node<E> n) {
        if (n == null) {
            throw new IllegalArgumentException("node n is null");
        }
        return n.getLeftChild() == null;
    }
    
    
    /**add a new key data as a child node to parent node p*/
    public void addChild(Node<E> c, Node<E> p) {
        if (c.getParent() != p) {
            c.setParent(p);
        }
        p.addChild(c);
        size++;
    }
    
    /**remove the subtree with root as node x from the whole tree
     * and adds all children of node x as children to node y
     */
    public void remove(Node<E> x, Node<E> y) {
//        System.out.println("MyTree.remove() is called --------with x = " + x + " , y = " + y);
        if (x != null) {
            Node<E> p = x.getParent();
            if (p.getLeftChild() == x) {
                p.setLeftChild(x.getRightSibling());
            } else {
                Node<E> current = p.getLeftChild();
                while (current.getRightSibling() != x) {
                    current = current.getRightSibling();
                }
                current.setRightSibling(x.getRightSibling());
            }
            x.setRightSibling(null);
            
//            System.out.println("p[x] = " + x.getParent());
//            System.out.println("p[x].children() = " + x.getParent().children());
            x.setParent(null);
            
//            System.out.println("--------x has been removed--------");
//            System.out.println("x = " + x);
//            System.out.println("children Of x = " + x.children());
            
            Node<E> current = x.getLeftChild();
     
            while (current != null) {
                
                current.setParent(y);
                current = current.getRightSibling();
            }
            /*changing the right sibling */
            if (x.hasLeftChild()) {
                y.addChild(x.getLeftChild());
            }
        size--;   
        }
        
    }
    
    
    /**Returns the number of children of current node*/
    public int numChildren(Node<E> n) {
        return n.numChildren();
    }
    
    /**Return an iterable collection of children nodes*/
    public Iterable<Node<E>> children(Node<E> n) {
        return n.children();
    }
    
    /**prints all the element/data of the tree*/
    public void printAll() {
        Node<E> r = this.root();
        LinkedList<Node<E>> nodes = new LinkedList<>();
        nodes.addLast(r);
        
        int i = 1;
            
        while (!nodes.isEmpty()) {
            MyTree.Node<E> current = nodes.removeFirst();
            System.out.println(i + "---------" + current);
            i++;
            if (current.numChildren() == 0) continue;
            for (Node<E> n: current.children()) {
                nodes.addLast(n);
                //System.out.println("-----------------" + n); 
            }
        }
    }
    
    
    /**return an iterable collection of all nodes of tree*/
    public Iterable<Node<E>> positions() {
        return new PositionIterable();
    }
    
    /*implementation of position iterator*/
    private class PositionIterable implements Iterable<Node<E>> {
        public Iterator<Node<E>> iterator() {
            return new PositionIterator();
        }
    }
    
    private class PositionIterator implements Iterator<Node<E>> {
        int count = 0;
        Node<E> current = root();
        
        /**returns true if there are nodes present in sequence that has yet not returned by the iterator*/
        public boolean hasNext() {
            return count < size;
        }
        
        /**returns the next node in the sequence, throw an exception if there are no more nodes*/
        public Node<E> next() {
            //System.out.println("-------next() method for positionIterator is called--------, current = " + current);
            if (count > size) {
                throw new IllegalStateException("there are no more nodes");
            }

            return current;
        }
    }
    
    /**return an iterable collection of all elements in tree*/
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
    
    
    private class ElementIterator implements Iterator<E> {
        PositionIterator allNodes = new PositionIterator();
        
        /**returns true if there are nodes present in sequence that has yet not returned by the iterator*/
        public boolean hasNext() {
            return allNodes.hasNext();
        }
        
        /**returns the next node in the sequence, throw an exception if there are no more nodes*/
        public E next() {
            return allNodes.next().getKey();
        }
    }   
}
