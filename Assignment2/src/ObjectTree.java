/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 */
public class ObjectTree {
    
    private ObjectNode root;
    
    
    /*constructs an empty tree*/
    public ObjectTree(){
//        root = new ObjectNode(null, null, null, null, null, null);
    }
    
    /*returns the root of the tree*/
    public ObjectNode root(){
        return this.root;
    }
    
    /**updates the root of the tree*/
    public void setRoot(ObjectNode r){
        this.root = r;
    }
    
    
    /*returns a node with bin capacity b stored in tree with root x*/
    public ObjectNode search(ObjectNode x, int b){
        if(x != null && x.getObjectId() != b){
            if(x.getObjectId() < b){
                return search(x.getRightChild(), b);
            }
            else{
                return search(x.getLeftChild(), b);
            }
        }
        else{
            return x;
        }
    }
    
    
    /**finds the height of the tree with root at x*/
    public int height(ObjectNode w){        
        if(w == null){            
            return 0;
        }
        else{
            return 1 + Math.max(height(w.getLeftChild()), height(w.getRightChild()));
        }           
              
    }
    
    
    
    /**inserts a node z in my bin tree comparing the capacities*/
    public void insertObject(ObjectNode z){
        //System.out.println("entered in insertbin method");
        if(this.root() == null){
            root = z;            
        }
        else{            
            ObjectNode x = this.root();
            ObjectNode y = x.getParent();
            while(x != null){
                y = x;
                if(x.getObjectId() <= z.getObjectId()){                    
                    x = x.getRightChild();
                }
                else{                    
                    x = x.getLeftChild();
                }
            }
            if(y.getObjectId() <= z.getObjectId()){                
                y.setRightChild(z);
            }
            else{
                y.setLeftChild(z);
            }
            z.setParent(y);
            
            check(y);
            
        }
        
    }
    
    /**inserts a new node z with bin id i, bin capacity c*/
    public void insertObject(int i, int c){
        ObjectNode z = new ObjectNode(null, null, null, i, c, null);
        this.insertObject(z);
    }    
    
    /**checks and rotate the nodes such that the tree follow AVL tree property */
    public void check(ObjectNode z){         
        ObjectNode x;
        ObjectNode y;        
        while(z != null){            
            int a = 0;
            int b = 0; 
            a = height(z.getLeftChild());                               
            b = height(z.getRightChild());
            int c = a-b;
            if(c != 1 && c != 0 && c != -1){
                if(a > b){
                    y = z.getLeftChild();
                    if(height(y.getLeftChild()) >= height(y.getRightChild())){                        
                        x = y.getLeftChild();
                    }
                    else{                        
                        x = y.getRightChild();
                    }
                }
                else{
                    y = z.getRightChild();
                    if(height(y.getLeftChild()) > height(y.getRightChild())){                        
                        x = y.getLeftChild();
                    }
                    else{                        
                        x = y.getRightChild();
                    }
                }
                ObjectNode temp = rotation(z, y, x);                            
                z = temp;                               
            }
            z = z.getParent();
        }        
    }   
    
    /**rotates the nodes z,y,x so that they follow AVL tree property*/
    public ObjectNode rotation(ObjectNode z, ObjectNode y, ObjectNode x){        
        if(y == z.getRightChild() && x == y.getRightChild()){            
            return singleRotation(z, y, x);
        }
        else if(y == z.getLeftChild() && x == y.getLeftChild()){            
            return singleRotation(z, y, x);
        }
        else if(y == z.getRightChild() && x == y.getLeftChild()){            
            return doubleRotation(z, y, x);                                    
        }
        else{            
            return doubleRotation(z, y, x);
        }        
    }
    
    /**does the single rotation with given x,y,z nodes*/
    public ObjectNode singleRotation(ObjectNode z, ObjectNode y, ObjectNode x){
        if(z == this.root){
            root = y;
        }
        if(y == z.getRightChild()){
            ObjectNode temp = z.getParent();
            ObjectNode temp1 = y.getLeftChild();
            z.setParent(null);
            z.setRightChild(null);
            y.setParent(null);
            y.setLeftChild(null);
            if(temp1 != null){
                temp1.setParent(null);
                temp1.setParent(z);
                z.setRightChild(temp1);
            }
            y.setLeftChild(z);
            z.setParent(y);
            if(temp != null && temp.getLeftChild() == z){
                temp.setLeftChild(null);
                temp.setLeftChild(y);
                y.setParent(temp);
            }
            else if(temp != null && temp.getRightChild() == z){
                temp.setRightChild(null);
                temp.setRightChild(y);
                y.setParent(temp);
            }
            else{
                
            }
        }
        else{
            ObjectNode temp2 = z.getParent();
            ObjectNode temp3 = y.getRightChild();
            z.setParent(null);
            z.setLeftChild(null);
            y.setParent(null);
            y.setRightChild(null);
            if(temp3 != null){
                temp3.setParent(null);
                temp3.setParent(z);
                z.setLeftChild(temp3);
            }
            y.setRightChild(z);
            z.setParent(y);
            if(temp2 != null && temp2.getLeftChild() == z){
                temp2.setLeftChild(null);
                temp2.setLeftChild(y);
                y.setParent(temp2);
            }
            else if(temp2 != null && temp2.getRightChild() == z){
                temp2.setRightChild(null);
                temp2.setRightChild(y);
                y.setParent(temp2);
            }
            else{
                
            }
        }
        return y;
    }
    
    
    
    /**does the double rotation of given x,y,z nodes*/
    public ObjectNode doubleRotation(ObjectNode z, ObjectNode y, ObjectNode x){
        if(x == y.getLeftChild())
            singleRotation(y, x, x.getLeftChild());
        else
            singleRotation(y, x, x.getRightChild());
        singleRotation(z, x, y);
        return x;
    }
    
    /*finds the minimum value stored in tree*/
    public ObjectNode treeMinimum(ObjectNode p){
        while(p.getLeftChild() != null){
            p = p.getLeftChild();
        }
        return p;
    }
    
    /*finds the maximum value stored in tree*/
    public ObjectNode treeMaximum(ObjectNode p){
        while(p.getRightChild() != null){
            p = p.getRightChild();
        }
        return p;
    }
    
    /*finds the successor of position p*/
    public ObjectNode successor(ObjectNode p){
        if(p.getRightChild() != null){
            return treeMinimum(p.getRightChild());
        }
        else{
            while(p.getParent().getRightChild() == p && p.getParent() != null){
                p = p.getParent();
            }
            return p.getParent();
        }
    }
    
    /*finds the predecessor of position p*/
    public ObjectNode predecessor(ObjectNode p){
        if(p.getLeftChild() != null){
            return treeMaximum(p.getLeftChild());
        }
        else{
            while(p.getParent().getLeftChild() == p && p.getParent() != null){
                p = p.getParent();
            }
            return p.getParent();
        }
    }
    
    /**deletes a node from the tree with given capacity*/
    public ObjectNode deleteObject(int c){        
        ObjectNode x = search(this.root(), c);
        ObjectNode temp = x;
        ObjectNode y;
        ObjectNode z;        
        ObjectNode w;
        if(x.getLeftChild() == null && x.getRightChild() == null){            
            w = x.getParent();
            deleteZeroChild(x);
            check(w);
        }
        else if(x.getLeftChild() != null && x.getRightChild() == null){            
            w = x.getParent();
            deleteOneChild(x);
            check(w);
        }
        else if(x.getLeftChild() == null && x.getRightChild() != null){            
            w = x.getParent();
            deleteOneChild(x);
            check(w);
        }
        else{
            y = successor(x);
            ObjectNode temp1; 
            ObjectNode temp2;
            w = y.getParent();       
            if(x == root && x != y.getParent()){
                temp1 = deleteObject(y.getObjectId());            
                replaceRoot(temp1, x);
                root = y;
                check(w);
            }
            else if(x == root && x == y.getParent()){
                temp1 = deleteObject(y.getObjectId());
                temp2 = x.getRightChild();
                x.setRightChild(null);
                temp2.setParent(null);
                temp2.setParent(temp1);
                temp1.setRightChild(temp2);
                check(temp1);
            }
            else if(x != root && x != y.getParent()){
                temp1 = deleteObject(y.getObjectId());            
                replace(temp1, x);
                check(w);
            }
            else if(x != root && x == y.getParent()){
                temp1 = deleteObject(y.getObjectId());            
                replaceChild(temp1, x);
                check(w);
            }
            else{
                
            }
        }
        
        return temp;
    }
    
    /**deletes a given node x which has zero child*/
    public void deleteZeroChild(ObjectNode x){          
        if(x == this.root)
            this.root = null;
        else{
            if(x.getParent()!= null && x == x.getParent().getLeftChild())
                x.getParent().setLeftChild(null);
            else if(x.getParent() != null && x == x.getParent().getRightChild())
                x.getParent().setRightChild(null);
            x.setParent(null);
        }
    }
    
    /**deletes a given node x which has 1 child*/
    public void deleteOneChild(ObjectNode x){         
        if(x == this.root){
            if(x.getLeftChild() != null){
                this.root = x.getLeftChild();
                x.getLeftChild().setParent(null);
                x.setLeftChild(null);
            }
            else{
                this.root = x.getRightChild();
                x.getRightChild().setParent(null);
                x.setRightChild(null);
            }
        }
        else{
            if(x == x.getParent().getLeftChild()){
                if(x.getLeftChild() != null){
                    x.getParent().setLeftChild(x.getLeftChild());
                    x.getLeftChild().setParent(x.getParent());
                    x.setParent(null);
                    x.setLeftChild(null);
                }
                else{
                    x.getParent().setLeftChild(x.getRightChild());
                    x.getRightChild().setParent(x.getParent());
                    x.setParent(null);
                    x.setRightChild(null);
                }
            }
            else{
                if(x.getRightChild() != null){
                    x.getParent().setRightChild(x.getRightChild());
                    x.getRightChild().setParent(x.getParent());
                    x.setParent(null);
                    x.setRightChild(null);
                }
                else{
                    x.getParent().setRightChild(x.getLeftChild());
                    x.getLeftChild().setParent(x.getParent());
                    x.setParent(null);
                    x.setLeftChild(null);
                }
            }
        }
    }
    
    /**replaces a given node x with node z*/
    public void replaceRootChild(ObjectNode z, ObjectNode x){        
        z.setLeftChild(null);
        z.setRightChild(null);
        z.setLeftChild(x.getLeftChild());
        x.getLeftChild().setParent(z);
        x.setLeftChild(null);
        x.setRightChild(null);
              
    }
    
    public void replaceRoot(ObjectNode z, ObjectNode x){
        z.setLeftChild(null);
        z.setRightChild(null);
        z.setLeftChild(x.getLeftChild());
        z.setRightChild(x.getRightChild());
        x.getLeftChild().setParent(z);
        x.getRightChild().setParent(z);
        x.setLeftChild(null);
        x.setRightChild(null);
    }
    
    public void replaceChild(ObjectNode z, ObjectNode x){        
        z.setLeftChild(null);
        z.setLeftChild(x.getLeftChild());
        z.setRightChild(null);
        x.getLeftChild().setParent(z);
        x.setLeftChild(null);
        x.setRightChild(null);
        if(x == x.getParent().getLeftChild()){
            z.setParent(x.getParent());
            x.getParent().setLeftChild(z);
        }
        else{
            z.setParent(x.getParent());
            x.getParent().setRightChild(z);
        }             
    }
    
    public void replace(ObjectNode z, ObjectNode x){
        z.setLeftChild(null);
        z.setRightChild(null);
        z.setLeftChild(x.getLeftChild());
        z.setRightChild(x.getRightChild());
        x.getLeftChild().setParent(z);
        x.getRightChild().setParent(z);
        x.setLeftChild(null);
        x.setRightChild(null);
        if(x == x.getParent().getLeftChild()){
            z.setParent(x.getParent());
            x.getParent().setLeftChild(z);
        }
        else{
            z.setParent(x.getParent());
            x.getParent().setRightChild(z);
        }
    }
}
