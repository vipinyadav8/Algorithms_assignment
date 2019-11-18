///**does the single rotation with given x,y,z nodes*/
//    public BinNode singleRotate(BinNode z, BinNode y, BinNode x){
//        if(z == this.root){
//            //System.out.println("entered in single rotation and here z is the root node");
//            y.setParent(null);
//            if(y == z.getLeftChild()){
//                if(y.getRightChild() != null){
//                    z.setLeftChild(y.getRightChild());
//                    y.getRightChild().setParent(z);
//                }
//                y.setRightChild(z);
//                z.setParent(y);
//            }
//            else{
//                if(y.getLeftChild() != null){
//                    z.setRightChild(y.getLeftChild());
//                    y.getLeftChild().setParent(z);
//                }
//                y.setLeftChild(z);
//                z.setParent(y);
//            }        
//            this.root = y;
//            System.out.println("root of the tree after rotation" + this.root);
//            //System.out.println("value of left node after single rotation with root z:" + y.getLeftChild().getBinCapacity());
//            //System.out.println("value of right node after single rotation with root z:" + y.getRightChild().getBinCapacity());
//            return y;            
//        }
//        else{
//            //System.out.println("entered in single rotation method and z is not a root node");
//            y.setParent(z.getParent());
//            if(z == z.getParent().getRightChild())
//                z.getParent().setRightChild(y);
//            else
//                z.getParent().setLeftChild(y);
//            if(x == y.getLeftChild()){
//                if(y.getRightChild() != null){
//                    z.setLeftChild(y.getRightChild());
//                    y.getRightChild().setParent(z);
//                }                
//                y.setRightChild(z);
//                z.setParent(y);
//            }
//            else{
//                if(y.getLeftChild() != null){
//                    z.setRightChild(y.getLeftChild());
//                    y.getLeftChild().setParent(z);                    
//                }                
//                y.setLeftChild(z);
//                z.setParent(y);
//            }            
//            System.out.println("root of the tree after rotation" + this.root);
//            //System.out.println("check:" + y.getBinCapacity());
//            //System.out.println("value of left node after single rotation:" + y.getLeftChild().getBinCapacity());
//            //System.out.println("value of right node after single rotation:" + y.getRightChild().getBinCapacity());
//            return y;
//        }        
//    }/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Vipin
// */
//public class extra {
//    
//}




//***************************************************************************************************************
//if(x.getParent() != null && x == x.getParent().getLeftChild()){
//            if(x.getLeftChild() != null){
//                x.getLeftChild().setParent(x.getParent());
//                x.getParent().setLeftChild(x.getLeftChild());
//            }
//            else{
//                x.getRightChild().setParent(x.getParent());
//                x.getParent().setLeftChild(x.getRightChild());
//            }
//        }
//        else if(x.getParent() != null && x == x.getParent().getRightChild()){
//            if(x.getLeftChild() != null){
//                x.getLeftChild().setParent(x.getParent());
//                x.getParent().setRightChild(x.getLeftChild());
//            }
//            else{
//                x.getRightChild().setParent(x.getParent());
//                x.getParent().setRightChild(x.getRightChild());
//            }
//        }        
//        else{
//            if(x.getLeftChild() != null){
//                this.root = x.getLeftChild();
//                x.getLeftChild().setParent(null);
//                x.setLeftChild(null);
//            }
//        }





//--------------------------------------------delete two child( else statement in deleteBin method)-------------------
//
//y = predecessor(x);
//            w = y.getParent();
//            if(y.getLeftChild() == null && y.getRightChild() == null){
//                if(x == this.root)
//                    this.root = y;
//                if(y.getParent() == x){
//                    y.setRightChild(x.getRightChild());
//                    x.getRightChild().setParent(y);
//                    x.setLeftChild(null);
//                    y.setParent(null);
//                    if(x.getParent() != null && x == x.getParent().getLeftChild()){
//                        x.getParent().setLeftChild(y);
//                        y.setParent(x.getParent());
//                    }
//                    else if(x.getParent() != null && x == x.getParent().getRightChild()){
//                        x.getParent().setRightChild(y);
//                        y.setParent(x.getParent());
//                    }
//                }
//                else{                    
//                    deleteZeroChild(y);
//                    replace(y, x);                    
//                }                
//            }
//            else{
//                z = successor(x);
//                w = z.getParent();
//                if(this.root == x)
//                    this.root = z;
//                if(z.getParent() == x){
//                    z.setLeftChild(x.getLeftChild());
//                    x.getLeftChild().setParent(z);
//                    z.setParent(null);
//                    x.setRightChild(null);
//                    if(x.getParent() != null && x == x.getParent().getLeftChild()){
//                        x.getParent().setLeftChild(z);
//                        z.setParent(x.getParent());
//                    }
//                    else if(x.getParent() != null && x == x.getParent().getRightChild()){
//                        x.getParent().setRightChild(z);
//                        z.setParent(x.getParent());
//                    }
//                }
//                else{
//                    if(z.getLeftChild() == null && z.getRightChild() == null){
//                        deleteZeroChild(z);
//                        replace(z, x);
//                    }
//                    else{
//                        deleteOneChild(z);
//                        replace(z, x);
//                    }
//                }
//                
//            }  


//----------------------------------replace----------------------------------------------------------
//
//z.setParent(x.getParent());
//        if(x.getLeftChild() != null){
//            z.setLeftChild(x.getLeftChild());
//            x.getLeftChild().setParent(z);
//        }
//        if(x.getRightChild() != null){
//            z.setRightChild(x.getRightChild());
//            x.getRightChild().setParent(z);
//        }        
//        if(x.getParent()!= null && x == x.getParent().getLeftChild())
//            x.getParent().setLeftChild(z);
//        else if(x.getParent() != null && x == x.getParent().getRightChild())
//            x.getParent().setRightChild(z);
//        else{
//            
//        }



//-------------------------------------delete if else statements------------------------
//
//if(x == root && x != y.getParent()){
//                temp1 = deleteObject(y.getObjectId());            
//                replaceRoot(temp1, x);
//                root = y;
//            }
//            else if(x == root && x == y.getParent()){
//                temp1 = deleteObject(y.getObjectId());
//                temp2 = x.getRightChild();
//                System.out.println("x : " + x);
//                System.out.println("y : " + y);
//                System.out.println("temp1 : " + temp1);
//                System.out.println("temp2 : " + temp2);
//                x.setRightChild(null);
//                temp2.setParent(null);
//                temp2.setParent(temp1);
//                temp1.setRightChild(temp2);
//                check(temp1);
//            }
//            else{
//                temp1 = deleteObject(y.getObjectId());            
//                replace(temp1, x);
//            }