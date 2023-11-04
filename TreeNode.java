import java.util.*;
class TreeNode{
	
private int units;	
private int childSAT;
private int points;
private String name;
private double childGPA;
private List<TreeNode> children;

public TreeNode(String newName, double GPA, int pointValue) {
this.points = pointValue;
this.childGPA = GPA;
this.name = newName;
this.children = new ArrayList<>();
}

public TreeNode(String newName, int newSAT, int pointValue) {
	this.name = newName;
	this.childSAT = newSAT;
	this.points = pointValue;
	this.children = new ArrayList<>();
}

public TreeNode(int newUnits, String newName, int pointValue) {
	this.name = newName;
	this.units = newUnits;
	this.points = pointValue;
	this.children = new ArrayList<>();
}

public TreeNode(String name) {
this.name = name;
this.children = new ArrayList<>();
}



public void addChild(TreeNode child) {
children.add(child);
}
public String getName() {
return this.name;
}
public double getChildGPA() {
return childGPA;
}

public double getChildSAT(){
	return childSAT;
}

public double getChildUnits(){
	return units;
}

public List<TreeNode> getChildren() {
return children;
}
public TreeNode getChild(int childNumber) {
	return children.get(childNumber);
}
public int getPoints() {
	return this.points;
}
}

