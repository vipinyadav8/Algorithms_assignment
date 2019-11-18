/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Vipin Yadav
 */
public class Assignment2 {
    private static MySearchTree employeeSearchTree = new MySearchTree();
            
    private static MyTree<String> employees = new MyTree<>("CEO");
    private static BufferedReader br;
    
    private static MyTree.Node<String> node1;      //node for new employee
    private static MySearchTree.Node node2;
   
    
    public static void main(String[] args) {
        employeeSearchTree.treeInsert(employees.root());
        
        try { 
            br = new BufferedReader(new FileReader("test_case1.txt"));
            int n = new Integer(br.readLine().trim());
            System.out.println("n = " + n);
            
            MyTree.Node<String> current = employees.root();
            
            if (current == null) {throw new IllegalStateException("wrong");};
            
            
            for (int i = 0; i < n - 1; i++) {
               
                String[] s = br.readLine().split(" ");
                //System.out.println("employee and boss = " + Arrays.toString(s));
                
                String employee = s[0];
                String boss = s[1];
                
//                System.out.println("employee = " + employee + ", boss = " + boss);
                
                     
                while (!current.getKey().equals(boss)) {        //if current name is not equal to boss name
                    if (current.hasLeftChild()) {
                        current = current.getLeftChild();
                        continue;
                    }
                    if (current.hasRightSibling()) {
                        current = current.getRightSibling();
                    } else {
                        while((!current.hasRightSibling()) && (current != employees.root())) {
                            current = current.getParent();    
                        }
                        
                        if (current.hasRightSibling()) {
                            current = current.getRightSibling();
                            if (current.hasLeftChild()) {
                                current = current.getLeftChild();
                            }
                        }
                        if (current == employees.root()) {
                            while (current.hasLeftChild()) {
                                current = current.getLeftChild();
                            }
                        }
                    }
                }
                node1 = new MyTree.Node<>(employee, current, null, null);      //node for new employee
                node2 = new MySearchTree.Node(node1);
                
                employees.addChild(node1, current);
                employeeSearchTree.treeInsert(node2);
                
                //System.out.println("-------printing the whole tree------");
                //employees.printAll();
            }
            
            int numQuery = new Integer(br.readLine().trim());
            System.out.println("--------queries---------");
            for (int j = 0; j < numQuery; j++) {
               
                String[] command = br.readLine().split(" ");
                
                int query = new Integer(command[0]);
                
                if (query == 0) {
                    System.out.println("addEmployee(command[1], command[2]);");
                    addEmployee(command[1], command[2]);
                } else if (query == 1) {
                    System.out.println("deleteEmployee(command[1], command[2]);");
                    deleteEmployee(command[1], command[2]);
                } else if (query == 2) {
                    System.out.println("lowestCommonBoss(command[1], command[2]);");
                    lowestCommonBoss(command[1], command[2]);
                } else if (query == 3) {
                    System.out.println("printEmployees();");
                    printEmployees();
                }
                
            }
            
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex2) {
            ex2.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        

        
        
//        printEmployees();
    }
    
    
    /** S1 and S2 are names of two persons working in the company. 
     * This operation prints the name of the employee A who is a boss of both S1 and S2,
     * and among all such persons has the largest level.
     * In other words, we want to find the common boss who is lowest in the hierarchy in the company.
     */
    public static void lowestCommonBoss(String s1, String s2) {
        //System.out.println("-------------lowestCommonBoss(String s1, String s2)----------- with s1 = " + s1 + ", s2 = " + s2);
        MySearchTree.Node employee1NodeBST = employeeSearchTree.treeSearch(s1);       //employee1 node in BST with key = s1
        MySearchTree.Node employee2NodeBST = employeeSearchTree.treeSearch(s2);       //employee2 node in BST with key = s2
//        System.out.println("----------employee1NodeBST = " + employee1NodeBST + ", employee2NodeBST = " + employee2NodeBST + "------");
       
        MyTree.Node<String> employee1NodeMT = employee1NodeBST.getNode();                   //employee1 node in main tree
        MyTree.Node<String> employee2NodeMT = employee2NodeBST.getNode();                   //employee2 node in main tree
//        System.out.println("----------employee1NodeMT = " + employee1NodeMT + ", employee2NodeMT = " + employee2NodeMT + "------");
        
        int a = employee1NodeMT.depth();
        int b = employee2NodeMT.depth();
        
        if(b > a){
            int c = b - a;
            for(int i=0; i<c; i++){
                employee2NodeMT = employee2NodeMT.getParent();
            }
        }
        else {
            int d = a - b;
            for(int i=0; i<d; i++){
                employee1NodeMT = employee1NodeMT.getParent();
            }
        }
        while(employee1NodeMT.getParent() != employee2NodeMT.getParent()){
            employee1NodeMT = employee1NodeMT.getParent();
            employee2NodeMT = employee2NodeMT.getParent();
        }
        System.out.println(employee1NodeMT.getParent());
    }
    
    /**We want to remove an employee whose name is S1.
     * S2 is the name of another employee in the company who is at the same level as S1.
     * When we remove S1, all the persons working under S will now work under S2.*/
    public static void deleteEmployee(String s1, String s2) {
        MySearchTree.Node employee1NodeBST = employeeSearchTree.treeSearch(s1);       //employee1 node in BST with key = s1
        MySearchTree.Node employee2NodeBST = employeeSearchTree.treeSearch(s2);       //employee2 node in BST with key = s2
        
        MyTree.Node<String> employee1NodeMT = employee1NodeBST.getNode();                   //employee1 node in main tree
        MyTree.Node<String> employee2NodeMT = employee2NodeBST.getNode();                   //employee2 node in main tree
        
        employees.remove(employee1NodeMT, employee2NodeMT);
    }
    
    /**It prints the name of all employees in the company*/
    public static void printEmployees() {
        /*the printAll method is defined in MyTree class*/
        employees.printAll();
    }
    
    /*adds a new employee e who will work under employee b(b for boss)*/
    public static void addEmployee(String e, String b){
        //System.out.println("------addEmployeee() is called with e = " + e + ", b = " + b);
        MySearchTree.Node bossNodeBST = employeeSearchTree.treeSearch(b);       //node in BST with key = b
        if (bossNodeBST == null) {
            throw new IllegalStateException("error in add Employee, bossNodeBST = " + b);
        }
        MyTree.Node<String> bossNodeMT = bossNodeBST.getNode();                   //node in main tree
        
        MyTree.Node<String> employeeNodeMT = new MyTree.Node<>(e, bossNodeMT, null, null);   //new MyTree node for employee
        
        employees.addChild(employeeNodeMT, bossNodeMT);
        employeeSearchTree.treeInsert(employeeNodeMT);
    }
    
    //extra method for printing binary search tree
    private static void printBST() {
        System.out.println("-----------printing BST-------");
        
        MySearchTree.Node r2 = employeeSearchTree.root;
        LinkedList<MySearchTree.Node> nodes2 = new LinkedList<>();
        System.out.println("root = " + r2);
        nodes2.addLast(r2);
        int i = 1;
        while (!nodes2.isEmpty()) {
            MySearchTree.Node current2 = nodes2.removeFirst();
            System.out.println(i + "---------" + current2);
            i++;
            if (current2.hasLeftChild()) nodes2.addLast(current2.getLeftChild());
            
            if (current2.hasRightChild()) nodes2.addLast(current2.getRightChild());           
        }
        
    }
}
