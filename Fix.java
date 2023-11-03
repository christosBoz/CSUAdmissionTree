public class Fix{
    public static void main(String[] args) {
        TreeNode root = new TreeNode("Root");
        TreeNode student = new TreeNode("Student");
        TreeNode transfer = new TreeNode("Transfer");

        TreeNode sat = new TreeNode("SAT");
        TreeNode highSATRange = new TreeNode("high, 1400+", 1400, 5);
        TreeNode avgSATRange = new TreeNode("average, 1050+", 1050, 4);
        TreeNode lowSATRange = new TreeNode("low, -1050", 1049, 3);

        TreeNode gpa = new TreeNode("GPA");
        TreeNode lowGpaRange = new TreeNode("low/2.5-3.0", 2.5, 3);
        TreeNode midGpaRange = new TreeNode("mid/3.0-3.5", 3.0, 4);
        TreeNode highGpaRange = new TreeNode("high/3.5-4.0", 3.5, 5);

        TreeNode units = new TreeNode("Units");
        TreeNode highUnitPercentage = new TreeNode(90, "90%+", 5);
        TreeNode midUnitPercentage = new TreeNode(80, "90%+", 4);
        TreeNode lowUnitPercentage = new TreeNode(70, "90%+", 3);

        // Establish parent-child relationships
        root.addChild(student);
        root.addChild(transfer);

        student.addChild(sat);
        student.addChild(gpa);

        sat.addChild(lowSATRange);
        sat.addChild(avgSATRange);
        sat.addChild(highSATRange);

        gpa.addChild(lowGpaRange);
        gpa.addChild(midGpaRange);
        gpa.addChild(highGpaRange);

        transfer.addChild(gpa);
        transfer.addChild(units);

        units.addChild(highUnitPercentage);
        units.addChild(midUnitPercentage);
        units.addChild(lowUnitPercentage);

        // Call the printTree method to print the tree
        printTree(root, "");

        

    }
    public static void printTree(TreeNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.getName());
            for (TreeNode child : node.getChildren()) {
                printTree(child, indent + "  ");
            }
        }
    }










}