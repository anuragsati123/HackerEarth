/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();                 // Reading input from STDIN
        int i = 0;
        Tree tree = new Tree();
        String allNums = s.nextLine();
        String[] arr = allNums.split(" ");

        for (String str : arr) {
        	Node node = new Node();
        	node.keyVal = Integer.parseInt(str);
        	tree.insertValue(node);
		}

        System.out.println(tree.maxDepth(tree.getRootNode()));    // Writing output to STDOUT
        
    }
}

class Node {
    int keyVal;
    Node leftNode;
    Node rightNode;
}

class Tree {
    Node rootNode;
    public void insertValue(Node node){
        Node currentNode  = rootNode;
        while(true) {
        	if(currentNode == null) {
        		rootNode = node;
        		break;
        	}else if(node.keyVal<=currentNode.keyVal){
	            if(currentNode.leftNode == null) {
	            	currentNode.leftNode = node;
	            	break;
	            }else {
	            	currentNode = currentNode.leftNode;
	            }
	        }else {
	        	if(currentNode.rightNode == null) {
	            	currentNode.rightNode = node;
	            	break;
	            }else {
	            	currentNode = currentNode.rightNode;
	            }
	        }
        }
        
    }
    
    public int maxDepth(Node node) {
    	if(node==null) {
    		return 0;
    	}else {
    		int lDepth = maxDepth(node.leftNode);
    		int rDepth = maxDepth(node.rightNode);
    		
    		if(lDepth>rDepth) {
    			return ++lDepth;
    		}else {
    			return ++rDepth;
    		}
    	}
    }
    
    public Node getRootNode() {
    	return rootNode;
    }
}
