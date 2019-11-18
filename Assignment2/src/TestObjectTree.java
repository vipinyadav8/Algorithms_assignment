/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 */
public class TestObjectTree {
    static ObjectTree objects = new ObjectTree();
    public static void main(String[] args){
        
        for(int i = 0; i < 120; i++){
            objects.insertObject(i, 0);
        }
        
        inOrder(objects.root());
        System.out.print(objects.root() + " ");
    }
    
    public static void inOrder(ObjectNode o){
        
        if(o == null)
            return;
        inOrder(o.getLeftChild());
        System.out.print(o.getObjectId() + " ");
        inOrder(o.getRightChild());
    }
    
}
