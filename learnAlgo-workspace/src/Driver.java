import java.util.Iterator;

class Driver {
    public static void iteratorTraversal() {
		// Build the tree
		// Leaves: d, e, g
		BinaryTree<String> dTree = new BinaryTree<String>("d");
		BinaryTree<String> eTree = new BinaryTree<String>("e");
		BinaryTree<String> gTree = new BinaryTree<String>("g");

		BinaryTree<String> bTree = new BinaryTree<String>("b", dTree, eTree);
		BinaryTree<String> fTree = new BinaryTree<String>("f", null, gTree);
		BinaryTree<String> cTree = new BinaryTree<String>("c", fTree, null);
		BinaryTree<String> aTree = new BinaryTree<String>("a", bTree, cTree);

		System.out.println("Inorder traversal of tree rooted at A using Iterator");
	
		Iterator<String> iter = aTree.getInorderIterator();
	
		while(iter.hasNext()) {
			String s = iter.next();
			// Process s if needed
			System.out.println("String: " + s);
		}
		System.out.println("Preorder traversal of tree rooted at A using Iterator");
	
		Iterator<String> iter2 = aTree.getPreorderIterator();
	
		while(iter2.hasNext()) {
			String s = iter2.next();
			// Process s if needed
			System.out.println("String: " + s);
		}
	
    }
    public static void expressionTree() {
		ExpressionTree aTree = new ExpressionTree("a");
		ExpressionTree bTree = new ExpressionTree("b");
		ExpressionTree cTree = new ExpressionTree("c");
		ExpressionTree timesTree = new ExpressionTree();
		timesTree.setTree("*",aTree, bTree);
		ExpressionTree plusTree = new ExpressionTree();
		plusTree.setTree("+", timesTree, cTree);

		System.out.println(" (a*b) + c = " + plusTree.evaluate());
	
    }
    public static void main(String [] args) {
		// D, F, G and H are leaves
		BinaryTree<String> dTree = new BinaryTree<String>("D");
		BinaryTree<String> fTree = new BinaryTree<String>();
		fTree.setTree("F");
		BinaryTree<String> gTree = new BinaryTree<String>("G");
		BinaryTree<String> hTree = new BinaryTree<String>("H");
		BinaryTree<String> eTree = new BinaryTree<String>();
		// E has F and G as left and right children
		eTree.setTree("E", fTree, gTree);
		// B has D and E as children
		BinaryTree<String> bTree = new BinaryTree<String>("B", dTree, eTree);
		// C has H as right child
		BinaryTreeInterface<String> cTree = new BinaryTree<String>("C", null, hTree);
		// A has B and C as children 
		BinaryTreeInterface<String> aTree = new BinaryTree<String>();
		aTree.setTree("A", bTree, cTree);
		// display root, height, number of nodes
		System.out.println("Tree rooted at A:");
		System.out.println("Root of tree contains " + aTree.getRootData());
		System.out.println("Height of tree is " + aTree.getHeight());
		System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");
		System.out.println();
		// display root, height, number of nodes
		System.out.println("Tree rooted at B:");
		System.out.println("Root of tree contains " + bTree.getRootData());
		System.out.println("Height of tree is " + bTree.getHeight());
		System.out.println("Tree has " + bTree.getNumberOfNodes() + " nodes");

		// Inorder traversal of tree rooted at A
		System.out.println("Inorder traversal of tree rooted at A");
		aTree.inorderTraversal();

    	
		iteratorTraversal();
		expressionTree();
    }
}
