import java.util.*;

public class Points{
    private static List<Object> studentsAndTransfers = new ArrayList<>();
    private static TreeNode root = createTree();


    public static void main(String[] args) {

    
        //printTree(root, "");
        //newStudent test = new newStudent("Matt", 1200, 2.5, true);
        //calculatePointsStudent(root, test);

        

        getInfo();
        studentsAndTransfers.sort(new PointsComparator()); 

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

    public static void getInfo(){
        Scanner in = new Scanner(System.in);
        boolean continueLoop = true;
        Boolean diploma = true;
        while(continueLoop == true){

            System.out.println("Welcome to CSU Admissions! Are you a new Student or Transfer");
            String student_info = in.nextLine();

            if(student_info.equalsIgnoreCase("student")){
                System.out.println("Do you have a diploma? Enter Y/N");
                String checkDiploma = in.nextLine();
                if(checkDiploma.equalsIgnoreCase("N")){
                    System.out.println("Sorry you are not eligible");
                    System.out.println("Press N to add a new applicant , or type any other character to exit ");
                    String response = in.nextLine();
                    if(response.equalsIgnoreCase("N")){
                        continue;
                    }
                    else{
                        break;
                    }
                           
                }

                System.out.println("Enter your first name: ");
                String student_name = in.nextLine();
                System.out.println("Enter your SAT score: ");
                double score = in.nextDouble();
                System.out.println("Enter your GPA: ");
                double GPA = in.nextDouble();
                newStudent student = new newStudent(student_name, score, GPA, diploma);
                studentsAndTransfers.add(student);
                calculatePointsStudent(root, student);
                in.nextLine();
                System.out.println("Press N to add a new applicant , or type any other character to continue ");
                String response = in.nextLine();
                if(!response.equalsIgnoreCase("n")){
                    continueLoop = false;
                }
            }

            if(student_info.equalsIgnoreCase("transfer")){

                System.out.println("Enter your first name: ");
                String student_name = in.nextLine();
                System.out.println("Enter your GPA: ");
                double GPA = in.nextDouble();
                System.out.println("Enter the number of Units you are transfering with: ");
                int unit_count = in.nextInt();
                transferStudent transfer = new transferStudent(student_name, GPA, unit_count);
                studentsAndTransfers.add(transfer);
                calculatePointsTransfer(root, transfer);
                in.nextLine();
                System.out.println("Enter N to add a new applicant, or type any other charachter to continue: ");
                String response = in.nextLine();
                if(!response.equalsIgnoreCase("N")){
                    continueLoop = false;
                }
            }         
    }


    }


  

    public static TreeNode createTree() {
            TreeNode root = new TreeNode("Root");
            TreeNode student = new TreeNode("Student");
            TreeNode transfer = new TreeNode("Transfer");
        
            TreeNode sat = new TreeNode("SAT");
            TreeNode highSATRange = new TreeNode("high, 1300+", 1800, 5);
            TreeNode avgSATRange = new TreeNode("average, <=1200", 1200, 4);
            TreeNode lowSATRange = new TreeNode("low, <=1049", 1049, 3);
        
            TreeNode gpa = new TreeNode("GPA");
            TreeNode lowGpaRange = new TreeNode("low/0-2.5", 2.5, 3);
            TreeNode midGpaRange = new TreeNode("mid/2.6-3.5", 3.5, 4);
            TreeNode highGpaRange = new TreeNode("high/3.6-4.0", 4.0, 5);
        
            TreeNode units = new TreeNode("Units");
            TreeNode highUnitPercentage = new TreeNode(80, "<=80", 5);
            TreeNode midUnitPercentage = new TreeNode(60, "<=60", 4);
            TreeNode lowUnitPercentage = new TreeNode(40, "<=40", 3);
        
            
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
        
            return root; 
        }

    public static void calculatePointsStudent(TreeNode node, newStudent student) {
        if (node != null) {
            int points = student.getPoints();
            node = node.getChild(0); //1 transfer 0 student
            TreeNode holder = node;
            
            
    
            if (node.getName().equals("Student")) {
                points += calculatePointsForSAT(node, student);
                node = holder.getChild(1);

            }

            if (node.getName().equals("GPA")) {
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
            
            

            if (node.getName().equals("Transfer")) {
                points += calculatePointsForGPA(node, Transfer);
                node = holder.getChild(1);
            }
            
            if (node.getName().equals("Units")) {
                points += calculatePointsForUnits(node, Transfer);
            } 
            
            Transfer.addPoints(points);
            
        }
    }

    public static int calculatePointsForSAT(TreeNode node, newStudent student) {
        node = node.getChild(0);

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
   
        int points = 0;

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