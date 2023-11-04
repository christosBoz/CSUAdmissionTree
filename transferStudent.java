
public class transferStudent {
	public String name;
	private double studentGPA;
	private int studentUnits;
	private int points;
	
	public transferStudent(String name, double newGPA, int newUnits) {
		this.name = name;
		this.studentGPA = newGPA;
		this.studentUnits = newUnits;
	}
	
	public double getGPA() {
		return this.studentGPA;
	}
	
	public int getUnits() {
		return this.studentUnits;
	}
	
	public void addPoints(int pointsToAdd) {
		points+= pointsToAdd;
	}
	
	public int getPoints() {
		return this.points;
	}
}
