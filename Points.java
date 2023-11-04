import java.util.*;
public class Points{
    public static void main(String[] args) {
        TreeNode root = createTree();
        List<Object> studentsAndTransfers = new ArrayList<>();
        
        

        // Call to print the tree
        printTree(root, "");



        newStudent Jake = new newStudent("Jake", 1100, 3.6, true);
        newStudent Alex = new newStudent("Alex", 950, 2.3, true);
        /*newStudent Martin = new newStudent(1100, 3.6, true);
        newStudent Sam = new newStudent(1100, 3.6, true);
        newStudent Luca = new newStudent(1100, 3.6, true);
        */
        transferStudent Paul = new transferStudent("Paul", 2.2, 55);
        transferStudent Annie = new transferStudent("Annie", 4.0, 70);
       /*  transferStudent Zach = new transferStudent(2.2, 55);
        transferStudent Sarah = new transferStudent(2.2, 55);
        transferStudent Molly = new transferStudent(2.2, 55);
        */
        studentsAndTransfers.add(Jake);
        studentsAndTransfers.add(Alex);
        studentsAndTransfers.add(Paul);
        studentsAndTransfers.add(Annie);

        // Calculate points for each student and transfer
        calculatePointsStudent(root, Jake);
        calculatePointsTransfer(root, Paul);
        calculatePointsStudent(root, Alex);
        calculatePointsTransfer(root, Annie);
        
        studentsAndTransfers.sort(new PointsComparator());

        // Print the sorted list
        for (Object obj : studentsAndTransfers) {
            if (obj instanceof newStudent) {
                newStudent student = (newStudent) obj;
                System.out.println("Student: " + student.name + ", Points: " + student.getPoints());
            } else if (obj instanceof transferStudent) {
                transferStudent transfer = (transferStudent) obj;
                System.out.println("Transfer: " + transfer.name + ", Points: " + transfer.getPoints());
            }
        }

    
    }

  

    public static TreeNode createTree() {
            TreeNode root = new TreeNode("Root");
            TreeNode student = new TreeNode("Student");
            TreeNode transfer = new TreeNode("Transfer");
        
            TreeNode sat = new TreeNode("SAT");
            TreeNode highSATRange = new TreeNode("high, 1400+", 1400, 5);
            TreeNode avgSATRange = new TreeNode("average, 1050+", 1050, 4);
            TreeNode lowSATRange = new TreeNode("low, -1050", 1049, 3);
        
            TreeNode gpa = new TreeNode("GPA");
            TreeNode lowGpaRange = new TreeNode("low/2.5-3.0", 2.5, 3);
            TreeNode midGpaRange = new TreeNode("mid/3.0-3.5", 3.5, 4);
            TreeNode highGpaRange = new TreeNode("high/3.5-4.0", 4.0, 5);
        
            TreeNode units = new TreeNode("Units");
            TreeNode highUnitPercentage = new TreeNode(80, "<=80", 5);
            TreeNode midUnitPercentage = new TreeNode(60, "<=60", 4);
            TreeNode lowUnitPercentage = new TreeNode(40, "<=40", 3);
        
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
        
            return root; // Return the root of the tree
        }

    public static void calculatePointsStudent(TreeNode node, newStudent student) {
        if (node != null) {
            int points = student.getPoints();
            node = node.getChild(0); //1 transfer 0 student
            TreeNode holder = node;
            
            
            
            // Calculate points for the node based on your criteria (you can customize this part)
            if (node.getName().equals("Student")) {
                points += calculatePointsForSAT(node, student);
                node = holder.getChild(1);
            }if (node.getName().equals("GPA")) {
                points += calculatePointsForGPA(node, student);
            } 
            
            student.addPoints(points);
            
        }
    }
    public static void calculatePointsTransfer(TreeNode node, transferStudent Transfer) {
        if (node != null) {
            int points = Transfer.getPoints();
            node = node.getChild(1); //1 transfer 0 student
            TreeNode holder = node;
            
            
            
            // Calculate points for the node based on your criteria (you can customize this part)
            if (node.getName().equals("Transfer")) {
                points += calculatePointsForGPA(node, Transfer);
                node = holder.getChild(1);
            }if (node.getName().equals("Units")) {
                points += calculatePointsForUnits(node, Transfer);
            } 
            
            Transfer.addPoints(points);
            
        }
    }

    public static int calculatePointsForSAT(TreeNode node, newStudent student) {
        node = node.getChild(0);
        // Customize the calculation based on your criteria
        int points = 0;
        for(TreeNode childNode : node.getChildren()){
            if (student.getSAT() <= childNode.getChildSAT()) {
            points += childNode.getPoints();
            break;
        }
        }
        
        return points;
    }

    public static int calculatePointsForGPA(TreeNode node, newStudent student) {
        // Customize the calculation based on your criteria
        int points = 0;
        for(TreeNode childNode : node.getChildren()){
            if (student.getGPA() <= childNode.getChildGPA()) {
            points += childNode.getPoints();
            break;
        }
        }
        return points;
    }

    public static int calculatePointsForGPA(TreeNode node, transferStudent transfer) {
        // Customize the calculation based on your criteria
        node = node.getChild(0);
        int points = 0;
        for(TreeNode childNode : node.getChildren()){
            if (transfer.getGPA() <= childNode.getChildGPA()) {
            points += childNode.getPoints();
            break;
        }
        }
        return points;
    }

    public static int calculatePointsForUnits(TreeNode node, transferStudent transfer) {
        // Customize the calculation based on your criteria
        int points = 0;
        // Example criteria
        for(TreeNode childNode : node.getChildren()){
            if (transfer.getUnits() <= childNode.getChildUnits()) {
            points += childNode.getPoints();
            break;
        }
        }
        
        return points;
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