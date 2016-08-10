package com.google.euler;

public class Problem15 {
	final static int n = 21;
	final static int nm = n*n;

	public static void main(String[] args) {
		Problem15 p15 = new Problem15();
		Node root = new Node(0);
		int count = 0;
		long[] numPaths = new long[nm];
		numPaths(numPaths);
		System.out.println("Number of paths : " + numPaths[nm-1]);
		//makeTree(0);
		//makeTree(root, root.getVal());
		//countPaths(root);
		//System.out.println("counter : "+counter2);
		

	}
	private static void numPaths(long[] numPaths){
		for(int i = 0; i < n; i++){
			numPaths[i] = 1;
			numPaths[n*i] = 1;
		}
		for(int i=1; i < n; i++){
			for(int j =1; j < n; j++){
				numPaths[j+i*n] = numPaths[j-1 +i*n]+numPaths[j+(i-1)*n];
			}
		}
	}
	private static int counter = 0;
	//private static void countPaths
	private static void countPaths(Node node){
		//if(node.getVal() != (nm-1)){
		Node down = node.getDown();
		Node right = node.getRight();
		System.out.println();
		System.out.println("node " + node.getVal());
		if(down != null){
			System.out.println("node down " + down.getVal());
			countPaths(node.getDown());
			if(down.getVal() == (nm-1)){
				counter++;
			}
		}
		if(right != null){
			System.out.print(" node right " + right.getVal());
			countPaths(node.getRight());
			if(right.getVal() == (nm-1)){
				counter++;
			}
		}
		
		//System.out.println();
		//}
		
			
		
	}
	private static int counter3 = 0;
	private static void makeTreeIter(int val){
		int iDown = downIndex(val);
		int iRight = rightIndex(val);
		while(iDown >0 && iRight>0){
			iDown = downIndex(iDown);
			iRight = rightIndex(iRight);
			int iDown2 = rightIndex(iDown);
			int iRight2 = downIndex(iRight);
		}
	}
	private static int counter2 = 0;
	private static void makeTree(int val){
		int iDown = downIndex(val);
		int iRight = rightIndex(val);
		if(iDown > 0){
			System.out.println("Added down node " + iDown + "   to  node " + val);
			if(iDown == (nm-1)){
				counter2++;
			}
			makeTree(iDown);
		}
		if(iRight > 0){
			if(iRight == (nm-1)){
				counter2++;
			}
			System.out.println("Added right node " + iRight + "   to  node " + val);
			makeTree(iRight);
		}
		
	}
	private static void makeTree(Node node, int val){
		int i =val;
		//if(counter2 <50){
		int iDown = downIndex(node);
		int iRight = rightIndex(node);
		//int iRight = node.right.getVal();
		//System.out.println(counter2);
		if(iDown > 0){
			System.out.println("Added down node " + iDown + "   to  node " + val);
			node.setDown(new Node(iDown));
			makeTree(node.getDown(),node.getDown().getVal());
		}
		if(iRight > 0){
			System.out.println("Added right node " + iRight + "   to  node " + val);
			node.setRight(new Node(iRight));
			makeTree(node.getRight(),node.getRight().getVal());
		}
		//}
		//counter2++;
		/*makeTree(node.right,val);
		
		
		int downVal = node.getLeft().getVal();
		int rightVal = node.getRight().getVal();
		while(downVal < 400 && rightVal < 400){
			
			i++;
		}*/
	}
	private static int downIndex(int val){
		int nextIndex = val+n;
		if(nextIndex<nm){
			return nextIndex;
		}else{
			return -1;
		}
	}
	
	private static int downIndex(Node node){

		int currentIndex = node.getVal();
		int nextIndex = currentIndex+n;
		if(nextIndex < nm)
			return nextIndex;
		else
			return -1;
	}
	private static int rightIndex(int val){
		int nextIndex = val +1;
		if(nextIndex < nm && val%n != (n-1))
			return nextIndex;
		else
			return -1;
		
	}
	
	private static int rightIndex(Node node){
		int currentIndex = node.getVal();
		int nextIndex = currentIndex+1;
		if(nextIndex < nm && currentIndex%n != (n-1))
			return nextIndex;
		else
			return -1;
	}

}
class Node{
	private int val = 0;
	private Node down = null;
	private Node right = null;
	Node(int val){
		if(val > 0)
			this.val = val;
	}
	Node(int val, Node down, Node right){
		this.setVal(val);
		this.setDown(down);
		this.setRight(right);
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getDown() {
		return down;
	}
	public void setDown(Node down) {
		this.down = down;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}