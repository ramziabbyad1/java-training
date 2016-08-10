package hard;

import java.util.Objects;

public class BinarySearchTree {
	static class Node {
	    public int value;
	    public Node left, right;

	    public Node(int value, Node left, Node right) {
	        this.value = value;
	        this.left = left;
	        this.right = right;
	    }
	    public Object clone() throws CloneNotSupportedException {
	    	return super.clone();
	    }
	}
    public static boolean isValidBST(Node root) {
        //if(root.left == null && root.right == null) return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean isValidBST(Node node, int min, int max) {
        if (node == null) {return true;}
        else if (node.value > max || node.value < min){
        	return false;
        }
        return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value+1, max);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        Node n51 = new Node(5, n2, null);
        Node n5 = new Node(5, n51, null/*new Node(5, null, null)*/);
        System.out.println(isValidBST(n2));
        System.out.println(isValidBST(n5));
    }
}