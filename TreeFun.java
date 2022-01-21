// Why do we need to include anything to do with the Comparable class?!?
// Because we have a generic tree, if we want to be able to insert elements
// in a particular order, we have to be able to compare values in the data
// field of our TreeNode object. So we must override the compareTo method AND
// do so wrt our type parameter T.

public class TreeFun<T extends Comparable<T>> {
	
	// INSTANCE VARIABLES
	
	TreeNode<T> root;
	
	// CONSTRUCTORS
	
	TreeFun(T route){
		root.data = route;
		root.leftChild = null;
		root.rightChild = null;
	}
	
	TreeFun(){
		root = null;
	}
	
	/**
	 * This is the private inner class of Tree Node
	 * @param <T>
	 */
	private static class TreeNode<T> {
		
		// INSTANCE VARIABLES
		
        T data;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;
        
        // CONSTRUCTORS
        
        TreeNode(T data){
            this.data = data;
        }
        
        TreeNode(T data, TreeNode<T> lChild, TreeNode<T> rChild){
            this.data = data;
     	    this.leftChild = lChild;
            this.rightChild = rChild;
        }
        
        // METHODS
        
        private T getData() {
        	return this.data;
        }
        
        private TreeNode<T> getRightChild(){
        	return this.rightChild;
        }
        
        private TreeNode<T> getLeftChild(){
        	return this.leftChild;
        }
        
        private void setRightChild(TreeNode<T> rChild) {
        	rightChild = rChild;
        }
        
        private void setLeftChild(TreeNode<T> lChild) {
        	leftChild = lChild;
        }
    }
	
	// METHODS
	
	public TreeNode<T> getRoot(){
		return root;
	}
	
	// Add a custom compare method for objects of type T
	public int compare(T elt1, T elt2) {
		return elt1.compareTo(elt2);
	}

	/** 
	   Inserts the given data into the binary tree. 
	   Uses a recursive helper. 
	   Author @NickParlante
	  (Generics by SLR)

	  */ 
	  public void insert(T data) { 
	    root = insert(root, data); 
	  } 
	 

	  /** 
	   Recursive insert -- given a tree node reference, recurse down and 
	   insert the given data into the tree. Returns the new 
	   node reference (the standard way to communicate a changed reference 
	   back to the caller).
	   Author @NickParlante 
	   (Generics and OOP-ified by SLR)
	  */ 
	  private TreeNode<T> insert(TreeNode<T> tNode, T data) { 
	    if (tNode==null) { 
	      tNode = new TreeNode<T>(data); 
	    } 
	    else { 
	      // This is performing an insertion into the tree based on values of the data field
	      if (compare(data,tNode.getData()) < 0) { 
	        tNode.setLeftChild(insert(tNode.getLeftChild(), data)); 
	      } 
	      else { 
	        tNode.setRightChild(insert(tNode.getRightChild(), data)); 
	      } 
	    }

	    return(tNode); // in any case, return the new reference to the caller 
	  } 
	 
	
	  
	  // FILL IN THIS CODE HERE
	  
	  public int levelCount(TreeNode<T> tNode, int level) {
			
			 if (tNode == null)
			 {
				return 0;
			 }
			 else{
				 if(tNode.getLeftChild() != null)
				 {
					tNode = tNode.getLeftChild();
					levelCount(tNode, level++);
				 }
				 else if(tNode.getRightChild() != null)
				 {
					tNode = tNode.getRightChild();
					levelCount(tNode, level++);
				 }
			 }
			 return level;
			/* Answer
			
			if (tNode == null || level < 0)
			{
			   return 0;
			}
			if (level == 0)
			{
				return 1;
			}
			else{
				return levelCount(tNode.getRightChild(), level-1) + levelCount(tNode.getLeftChild, level -1)
			}


			*/
	     }
	  
     
	  /** 
	   * 
	   * Prints the tree node values in the "inorder" order. 
	   * Uses a private recursive helper to do the traversal. 
	   * 
	   */ 
	 public void printTree() { 
	  printTree(root); 
	  System.out.println(); 
	 }
	 
	 private void printTree(TreeNode<T> tNode) { 
	  if (tNode == null) return;

	  // left child, tree node itself, right child 
	  printTree(tNode.getLeftChild()); 
	  System.out.print(tNode.getData() + "  "); 
	  printTree(tNode.getRightChild()); 
	 } 
	  
}
