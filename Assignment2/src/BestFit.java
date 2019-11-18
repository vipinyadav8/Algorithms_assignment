

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vipin
 */
public class BestFit {
    
    private static BinTree bins = new BinTree();
    private static BinIdTree bins1 = new BinIdTree();
    private static ObjectTree objects = new ObjectTree();
    private static BufferedReader br;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new FileReader("test_case4.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] command = line.split(" ");

            int query = new Integer(command[0]);
            int query1 = new Integer(command[1]);
            int query2;
            if (command.length == 2) 
                query2 = 0;
            else
                query2 = new Integer(command[2]);

            if (query == 1) {
                //System.out.println("add_bin(" + query1 + ", " + query2 + ")");
                add_bin(query1, query2);
            } else if (query == 2) {
                //System.out.println("add_object(" + query1 + ", " + query2 + ")");
                System.out.println(add_object(query1, query2));
            } else if (query == 3) {
                //System.out.println("delete_object(" + query1 + ")");
                System.out.println(delete_object(query1));
            } else if (query == 4) {
                //System.out.println("contents(" + query1 + ")");
                System.out.println(contents(query1));
            }
        }
    }
    
    /**inserts an bin with given id and capacity*/
    public static void add_bin(int bin_id, int capacity){
        bins.insertBin(bin_id, capacity);
        bins1.insertBin(bin_id, capacity);
    }
    
    
    /**adds an object and stores it according to best fit algorithm and returns the bin id
     * in which it has to be stored
     */
    public static int add_object(int object_id, int size){
        BinNode temp = bins.treeMaximum(bins.root());
        //System.out.println("maximum value of the bins tree   temp : " + temp.getBinId() + " , " + temp.getBinCapacity());
        BinNode temp1 = bins1.search(bins1.root(), temp.getBinId());  
        //System.out.println("bin id and capacity of node in bins1 tree   temp1: " + temp1.getBinId() + " , " + temp1.getBinCapacity());
        if(temp.getBinCapacity() < size){
            System.out.println("The object is too big");
        }
        else{
            ObjectNode z = new ObjectNode(null, null, null, object_id, size, temp);
            objects.insertObject(z);
            //System.out.println("id and size of the root of object tree : " + objects.root().getObjectId() + " , " + objects.root().getObjectSize());
            bins.deleteBin(temp.getBinId(), temp.getBinCapacity());         
            //System.out.println("id and size of the root of bin tree : " + bins.root().getBinId() + " , " + bins.root().getBinCapacity());
            temp.setBinCapacity((temp.getBinCapacity() - size));  
            //System.out.println("updated value of capacity of temp node  : " + temp.getBinId() + " , " + temp.getBinCapacity());
            temp1.setBinCapacity((temp1.getBinCapacity() - size));
            //System.out.println("updated value of capacity of temp1 node  : " + temp1.getBinId() + " , " + temp1.getBinCapacity());
            temp.storeObjectList(z);
            temp1.storeObjectList(z);
            bins.insertBin(temp);
        }
        return temp.getBinId();
//        System.out.println("added object to bin : " + temp.getBinId() + " , " + temp.getBinCapacity());
    }
    
    /**deletes the object and returns the bin id in which it was stored previously*/
    public static int delete_object(int object_id){
        ObjectNode temp3 = objects.search(objects.root(), object_id);
        //System.out.println("value of id and size of object node  : " + temp3.getObjectId() + " , " + temp3.getObjectSize());
        objects.deleteObject(object_id);
        BinNode temp4 = temp3.getBinNode();
        //System.out.println("id and capacity of node which id object.getBinNode  temp4  : " + temp4.getBinId() + " , " + temp4.getBinCapacity());
        BinNode temp2 = bins1.search(bins1.root(), temp4.getBinId());
        bins.deleteBin(temp4.getBinId(), temp4.getBinCapacity());
        temp4.setBinCapacity(temp4.getBinCapacity() + temp3.getObjectSize());
        //System.out.println("updated value of capacity of temp4 node  : " + temp4.getBinId() + " , " + temp4.getBinCapacity());
        temp2.setBinCapacity(temp2.getBinCapacity() + temp3.getObjectSize());
        //System.out.println("updated value of capacity of temp2 node which is in bin id tree  : " + temp2.getBinId() + " , " + temp2.getBinCapacity());
        temp4.deleteObjectList(temp3);
        temp2.deleteObjectList(temp3);
        bins.insertBin(temp4);
        return temp4.getBinId();
        //System.out.println("deleted object from bin : " + temp4.getBinId());
    }
    
    /**returns the objects stored in given bin id*/
    public static LinkedList<ObjectNode> contents(int bin_id){
        BinNode temp = bins1.search(bins1.root(), bin_id);
        //return temp.getObjectList();
        return temp.getObjectList();
        
    }
    
}
