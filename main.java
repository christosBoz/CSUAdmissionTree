import java.util.Scanner;


public class main {
	
	public static void addChildSAT(TreeNode nodeToAddTo) {
		TreeNode highSATRange = new TreeNode("high, 1400+", 1400, 5);
		TreeNode avgSATRange = new TreeNode("average, 1050+", 1050, 4);
		TreeNode lowSATRange = new TreeNode("low, -1050", 1049, 3);
		
		nodeToAddTo.addChild(lowSATRange);
		nodeToAddTo.addChild(avgSATRange);
		nodeToAddTo.addChild(highSATRange);
	}
	
	public static void addChildUnitPercentage(TreeNode nodeToAddTo) {
		TreeNode highUnitPercentage = new TreeNode(90, "90%+", 5);
		TreeNode midUnitPercentage = new TreeNode(80, "90%+", 4);
		TreeNode lowUnitPercentage = new TreeNode(70, "90%+", 3);
		
		nodeToAddTo.addChild(highUnitPercentage);
		nodeToAddTo.addChild(midUnitPercentage);
		nodeToAddTo.addChild(lowUnitPercentage);
	}
	
	public static void addLeftGPARootChildren(TreeNode nodeToAddTo) {
		TreeNode lowGpaRange = new TreeNode("low/2.5-3.0", 2.5, 3);
		TreeNode midGpaRange = new TreeNode("mid/3.0-3.5", 3.0, 4);
		TreeNode highGpaRange = new TreeNode("high/3.5-4.0", 3.5, 5);
		
		nodeToAddTo.addChild(lowGpaRange);
		nodeToAddTo.addChild(midGpaRange);
		nodeToAddTo.addChild(highGpaRange);
		addChildSAT(nodeToAddTo);
		
	}
	
	public static void addRightGPARootChildren(TreeNode nodeToAddTo) {
		TreeNode lowGpaRange = new TreeNode("low/2.5-3.0", 2.5, 3);
		TreeNode midGpaRange = new TreeNode("mid/3.0-3.5", 3.0, 4);
		TreeNode highGpaRange = new TreeNode("high/3.5-4.0", 3.5, 5);
		
		nodeToAddTo.addChild(lowGpaRange);
		nodeToAddTo.addChild(midGpaRange);
		nodeToAddTo.addChild(highGpaRange);
		addChildUnitPercentage(nodeToAddTo);
		
	}
	
	


public static void main(String args[] ) {
	
	Scanner scanner = new Scanner(System.in);
	
	TreeNode root = new TreeNode("CSUS Admissions Root");
	TreeNode leftGPARoot = new TreeNode("leftGPARoot");
	TreeNode rightGPARoot = new TreeNode("rightGPARoot");
	
	root.addChild(leftGPARoot);
	root.addChild(rightGPARoot);
	addLeftGPARootChildren(leftGPARoot);
	addRightGPARootChildren(rightGPARoot);
	
	
	
	TreeNode currentNode = root;
	System.out.println(root.getChildren());
	
	
	System.out.print("Welcome to CSU Computer Science Admissions. Are you a new student or"
			+ " an upcoming transfer?");

	
	
	
	
	
	
	
	
	
	}

}