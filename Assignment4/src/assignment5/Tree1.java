/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.ArrayList;
/**
 *
 * @author Vipin
 */
public class Tree1 {
    
    SuffixTreeNode root;
    String T;
    SuffixTreeNode x ;
    SuffixTreeNode y ;
    SuffixTreeNode z;
    int p=0;
    int n;
    int m;
    ArrayList<String> list = new ArrayList<>();
    
    public Tree1(String s){
        root = new SuffixTreeNode(null, null, null, -1, -1);               
        T = s;
    }
    
    
    
    /**returns the root of the tree*/
    public SuffixTreeNode getRoot(){
        return root;
    }
    
    /**searches a string s and prints the startIndex and endIndex*/
    public  void search(String s){
        int i = 1;
        int j =1;
        if(s.charAt(0) == T.charAt(x.getStartIndex())){
            //System.out.println("1");
            int c = s.length();
            //System.out.println("c:" + c);
            int b = x.getEndIndex()-x.getStartIndex()+1;
            //System.out.println("b:" + b);
            if(c <= b){
                //System.out.println("2");
                int l =1;
                while(l<c){
                    //System.out.println("3");
                    if(s.charAt(l) == T.charAt(x.getStartIndex() + l) || s.charAt(l) == '?'){
                        //System.out.println("4");
                        l++;
                    }
                    else{
                        //System.out.println("5");
                        break;
                    }
                }
                if(l == c){
                    //System.out.println("6");
                    if(x.getEndIndex() == T.length()-1){
                        int m = x.getStartIndex() + l;
                        int q = x.getStartIndex();
                        int n = 0;
                        while(x.getParent() != root){
                            x = x.getParent();
                            n = n + (x.getEndIndex() - x.getStartIndex() + 1);
                        }
                        //int n = x.getStartIndex();
                        n = q - n;
                        System.out.println(n + " " + (m - 1));
                        //list.add(n + " " + (m - 1));
                        
                    }
                    else{
                        //System.out.println("1");
                        int m = x.getStartIndex() + l;
                        SuffixTreeNode d = x;
                        int q = x.getStartIndex();
                        int e = x.getEndIndex() - x.getStartIndex() + 1;
                        int n = 0;
                        while(x.getParent() != root){
                            x = x.getParent();
                            n = n + (x.getEndIndex() - x.getStartIndex() + 1);
                        }
                        d = d.getLeftChild();
                        int r = d.getStartIndex() - e;
                        while(d.getRightSibling() != null){
                            //r = d.getStartIndex() - e;
                            System.out.println(r - n + " " + (r + l - 1));
                            //list.add(r - n + " " + (r + l - 1));
                            d = d.getRightSibling();
                            r = d.getStartIndex() - e;
                        }
                        System.out.println(r - n + " " + (r + l - 1));
                        //list.add(r - n + " " + (r + l - 1));
                    }
                }
            }
            else{
                //System.out.println("7");
                int l =1;
                while(l<b){
                    //System.out.println("8");
                    if(s.charAt(l) == T.charAt(x.getStartIndex() + l) || s.charAt(l) == '?'){
                        l++;
                    }
                    else{
                        //System.out.println("9");
                        System.out.println(x.getStartIndex() + " " + (x.getStartIndex()+l));
                        //list.add(x.getStartIndex() + " " + (x.getStartIndex()+l));
                        break;
                    }
                }
                if(l == b){
                    //System.out.println("10");
                    //System.out.println(x.getStartIndex() + " " + (x.getStartIndex()+l - 1));
                    s = s.substring(l, s.length());
                    //System.out.println("s:" + s);
                    x = x.getLeftChild();
                    //System.out.println("x:" + x.getStartIndex() + x.getEndIndex());
                    search(s);
                }
            }
        }
        else if(s.charAt(0) == '?'){
            //System.out.println("1");
            //System.out.println("s: " + s);
            //System.out.println("x: " + x.getStartIndex() + " " + x.getEndIndex());
            int u = x.getEndIndex() - x.getStartIndex() + 1;
            //System.out.println("u: " + u);
            int v = s.length();
            //System.out.println("v: " + v);
            if(v <= u){
                //System.out.println("555555");
                int f =1;
                while(f < v){
                    //System.out.println("2");
                    if(T.charAt(x.getStartIndex() + f) == s.charAt(f)){
                        f++;
                    }
                    else{
                        break;
                    }
                }
                if(f == v){
                    //System.out.println("3");
                    //System.out.println("f: " + f);                    
                    if(x.getEndIndex() == T.length()-1){
                        //System.out.println("3");
                        int m = x.getStartIndex() + f;
                        //System.out.println("m: " + m);
                        SuffixTreeNode temp = x;
                        int q = x.getStartIndex();
                        //System.out.println("q: " + q);
                        int n = 0;
                        //System.out.println("x: " + x.getStartIndex() + " " + x.getEndIndex());
                        //System.out.println("xparent: " + x.getParent().getStartIndex() + " " + x.getParent().getEndIndex());
                        while(x.getParent() != root){
                            //System.out.println("1212");
                            x = x.getParent();
                            n = n + (x.getEndIndex() - x.getStartIndex() + 1);
                        }
                        //System.out.println("n: " + n);
                        //int n = x.getStartIndex();
                        n = q - n;
                        //System.out.println("n: " + n);
                        System.out.println(n + " " + (m - 1));
                        //list.add(n + " " + (m - 1));
                        x = temp;
                    }
                    else{
                        //System.out.println("4");
                        int m = x.getStartIndex() + f;
                        SuffixTreeNode temp = x;
                        SuffixTreeNode d = x;
                        int q = x.getStartIndex();
                        int e = x.getEndIndex() - x.getStartIndex() + 1;
                        int n = 0;
                        while(x.getParent() != root){
                            x = x.getParent();
                            n = n + (x.getEndIndex() - x.getStartIndex() + 1);
                        }
                        d = d.getLeftChild();
                        int r = d.getStartIndex() - e;
                        while(d.getRightSibling() != null){
                            //r = d.getStartIndex() - e;
                            System.out.println(r - n + " " + (r + f - 1));
                           // list.add(r - n + " " + (r + f - 1));
                            d = d.getRightSibling();
                            r = d.getStartIndex() - e;
                        }
                        System.out.println(r - n + " " + (r + f - 1));
                        //list.add(r - n + " " + (r + f - 1));
                        x = temp;  
                    }
                }
                if(x.getRightSibling() != null){
                    x = x.getRightSibling();
                    search(s);
                }
            }
            else{
                //System.out.println("5");
                int f = 1;
                while(f < u){
                    //System.out.println("5");
                    if(T.charAt(x.getStartIndex() + f) == s.charAt(f)){
                        f++;
                    }
                    else{
                        break;
                    }
                }
                if(f == u){
                    //System.out.println("6");
                    SuffixTreeNode temp = x;
                    //System.out.println("temp: " + temp.getStartIndex() + " " + temp.getEndIndex());
                    //System.out.println("x: " + x.getStartIndex() + " " + x.getEndIndex());
                    String temp1 = s;
                    //System.out.println("temp1: " + temp1);
                    //System.out.println("s: " + s);
                    s = s.substring(f, s.length());
                    //System.out.println("s: " + s);
                    x = x.getLeftChild();
                    //System.out.println("x: " + x.getStartIndex() + " " + x.getEndIndex());
                    search(s);
                    if(temp.getRightSibling() != null){
                        x = temp.getRightSibling();
                        //System.out.println("x: " + x.getStartIndex() + " " + x.getEndIndex());
                        search(temp1);
                    }
                }
                else{
                    //System.out.println("7");
                    if(x.getRightSibling() != null){
                        x = x.getRightSibling();
                        search(s);
                    }
                }
            }
        }
        else{
            if(x.getRightSibling() == null){
                //System.out.println(s + " is not present");
                return;
            }
            else{
                //System.out.println("11");
                //System.out.println("x: " + x.getStartIndex() + " " + x.getEndIndex());
                x = x.getRightSibling();
                search(s);
            }
        }
        //return list;
    }
        
    
    /**inserts an new String with startIndex s and endIndex e*/
    public  void insert(int s, int e){
//        if(y != null){
//            System.out.println("y: " + y.getStartIndex() + " " + y.getEndIndex());
//            System.out.println("s: " + s);
//            System.out.println("e: " + e);
//        }
        //int o = 1;
        //int i = 1;
        SuffixTreeNode newest;
        if(root.getLeftChild() == null){
            SuffixTreeNode newest3 = new SuffixTreeNode(root, null, null, s, e);
            root.setLeftChild(newest3);
            y = root.getLeftChild();
            x = y;
            //System.out.println("y0,7: " + y.getStartIndex() + " " + y.getEndIndex());
            //System.out.println("y0,7: " + root.getLeftChild().getStartIndex() + " " + root.getLeftChild().getEndIndex());
        }
        else{
            if(T.charAt(y.getStartIndex()) == T.charAt(s)){
                int j = e-s+1;
                int k =y.getEndIndex() - y.getStartIndex() + 1;
                if(j <= k){
                    int i = 1;
                    while(i < j){
                        if(T.charAt(y.getStartIndex()+i) == T.charAt(s+i)){
                            //System.out.println("1");
                            i++;
                        }
                        else{
                            //System.out.println("2");
                            //break the node upto i and make two child nodes of that
                            if(T.charAt(y.getStartIndex()+i) < T.charAt(s+i)){
                                //System.out.println("3");
                                newest = new SuffixTreeNode(y, null, null, y.getStartIndex()+i, y.getEndIndex());
                                SuffixTreeNode newest1 = new SuffixTreeNode(y, null, null, s + i, e);
                                y.setEndIndex(y.getStartIndex()+i-1);
                                newest.setRightSibling(newest1);
                                SuffixTreeNode p = y.getLeftChild();
                                //System.out.println("y4,7: " + y.getStartIndex() + " " + y.getEndIndex());
                                //System.out.println("y4,7: " + y.getLeftChild().getStartIndex() + " " + y.getLeftChild().getEndIndex());
                                //System.out.println("y4,7: " + y.getLeftChild().getRightSibling().getStartIndex() + " " + y.getLeftChild().getRightSibling().getEndIndex());
                                if(p != null){
                                    //System.out.println("4");
                                    newest.setLeftChild(p);
                                    while(p.getRightSibling() != null){
                                        //System.out.println("5");
                                        p.setParent(newest);
                                        p = p.getRightSibling();
                                    }
                                    p.setParent(newest);
                                }
                                y.setLeftChild(newest);
                                //System.out.println("5");
                                //System.out.println("y4,7: " + y.getLeftChild().getStartIndex() + " " + y.getLeftChild().getEndIndex());
                                //System.out.println("y4,7: " + y.getLeftChild().getRightSibling().getStartIndex() + " " + y.getLeftChild().getRightSibling().getEndIndex());
                                y = root.getLeftChild();
                                x = y;
                                break;
                            }
                            else{
                                //System.out.println("6");
                                newest = new SuffixTreeNode(y, null, null, y.getStartIndex()+i, y.getEndIndex());
                                SuffixTreeNode newest1 = new SuffixTreeNode(y, null, null, s + i, e);
                                y.setEndIndex(y.getStartIndex()+i-1);
                                newest1.setRightSibling(newest);
                                SuffixTreeNode p = y.getLeftChild();
                                if(p != null){
                                    //System.out.println("7");
                                    newest.setLeftChild(p);
                                    while(p.getRightSibling() != null){
                                        //System.out.println("3");
                                        p.setParent(newest);
                                        p = p.getRightSibling();
                                    }
                                    p.setParent(newest);
                                }
                                y.setLeftChild(newest1);
                                y = root.getLeftChild();
                                x = y;
                                break;
                            }
                        }
                    }
                    
                }
                else{
                    int o = 1;
                    while(o<k){
                        if(T.charAt(y.getStartIndex()+o) == T.charAt(s+o)){
                            //System.out.println("1");
                            o++;
                        }
                        else{
                            //System.out.println("2");
                            //break the node upto i and make two child nodes of that
                            if(T.charAt(y.getStartIndex()+o) < T.charAt(s+o)){
                                //System.out.println("3");
                                newest = new SuffixTreeNode(y, null, null, y.getStartIndex()+o, y.getEndIndex());
                                SuffixTreeNode newest1 = new SuffixTreeNode(y, null, null, s + o, e);
                                y.setEndIndex(y.getStartIndex()+o-1);
                                newest.setRightSibling(newest1);
                                SuffixTreeNode p = y.getLeftChild();
                                if(p != null){
                                    //System.out.println("4");
                                    newest.setLeftChild(p);
                                    while(p.getRightSibling() != null){
                                        //System.out.println("5");
                                        p.setParent(newest);
                                        p = p.getRightSibling();
                                    }
                                    p.setParent(newest);
                                }
                                y.setLeftChild(newest);
                                y = root.getLeftChild();
                                x = y;
                                break;
                            }
                            else{
                                //System.out.println("5");
                                newest = new SuffixTreeNode(y, null, null, y.getStartIndex()+o, y.getEndIndex());
                                SuffixTreeNode newest1 = new SuffixTreeNode(y, null, null, s + o, e);
                                y.setEndIndex(y.getStartIndex()+o-1);
                                newest1.setRightSibling(newest);
                                SuffixTreeNode p = y.getLeftChild();
                                if(p != null){
                                    //System.out.println("6");
                                    newest.setLeftChild(p);
                                    while(p.getRightSibling() != null){
                                        //System.out.println("6");
                                        p.setParent(newest);
                                        p = p.getRightSibling();
                                    }
                                    p.setParent(newest);
                                }
                                y.setLeftChild(newest1);
                                y = root.getLeftChild();
                                x = y;
                                break;
                            }                           
                        }
                    }
                    if(o==k){
                        //System.out.println("7");
                        //insert(with the length j-k and go to leftchild);
                        y = y.getLeftChild();
                        insert(s + k, e);
                    }
                }
            }
            else if(T.charAt(y.getStartIndex()) < T.charAt(s)){
                if(y.getRightSibling() != null){
                    //System.out.println("8");
                    z = y;
                    y = y.getRightSibling();
                    //System.out.println("z15,37:" + z.getStartIndex() + " " + z.getEndIndex());
                    //System.out.println("y15,37:" + y.getStartIndex() + " " + y.getEndIndex());
                    insert(s, e);
                }
                else{
                    //System.out.println("9");
                    newest = new SuffixTreeNode(y.getParent(), null, null, s, e);
                    y.setRightSibling(newest);
                    y = root.getLeftChild();
                    x = y;
                    //System.out.println("y2,7: " + y.getStartIndex() + " " + y.getEndIndex());
                    //System.out.println("y2,7: " + y.getRightSibling().getStartIndex() + " " + y.getRightSibling().getEndIndex());
                    //System.out.println("y2,7: " + y.getRightSibling().getRightSibling().getStartIndex() + " " + y.getRightSibling().getRightSibling().getEndIndex());
                }
            }
            else{
                if(y == y.getParent().getLeftChild()){
                    //System.out.println("10");
                    //System.out.println("y0,7: " + root.getLeftChild().getStartIndex() + " " + root.getLeftChild().getEndIndex());
                    newest = new SuffixTreeNode(y.getParent(), y, null, s, e);
                    //root.setLeftChild(newest);
                    y.getParent().setLeftChild(newest);
                    y = root.getLeftChild();
                    x = y;
                    //System.out.println("y1,7: " + y.getStartIndex() + " " + y.getEndIndex());
                    //System.out.println("y1,7: " + root.getLeftChild().getStartIndex() + " " + root.getLeftChild().getEndIndex());
                    //System.out.println("y1,7: " + y.getRightSibling().getStartIndex() + " " + y.getRightSibling().getEndIndex());
                    
                }
                else{
                    //System.out.println("11");
                    newest = new SuffixTreeNode(y.getParent(), y, null, s, e);
                    z.setRightSibling(newest);
                    y = root.getLeftChild();
                    x = y;
//                    System.out.println("y3,7: " + y.getStartIndex() + " " + y.getEndIndex());
//                    System.out.println("y3,7: " + y.getRightSibling().getStartIndex() + " " + y.getRightSibling().getEndIndex());
//                    System.out.println("y3,7: " + y.getRightSibling().getRightSibling().getStartIndex() + " " + y.getRightSibling().getRightSibling().getEndIndex());
//                    System.out.println("y3,7: " + y.getRightSibling().getRightSibling().getRightSibling().getStartIndex() + " " + y.getRightSibling().getRightSibling().getRightSibling().getEndIndex());
                }
            }
        }
    }
    
    public void print(){
        SuffixTreeNode b = root.getLeftChild();
        while(b.getRightSibling() != null){
            System.out.println(b.getStartIndex() + " " + b.getEndIndex());
            b = b.getRightSibling();
        }
        System.out.println(b.getStartIndex() + " " + b.getEndIndex());
    }
    
}
