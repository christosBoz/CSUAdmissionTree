

public class newStudent{
	public String name;
	private double studentSAT;
	private double studentGPA;
	private boolean hasDiploma;
	private int points;
	
	public newStudent(String name, double newSAT, double newGPA, boolean diplomaCheck) {
		this.name = name;
		this.studentSAT = newSAT;
		this.studentGPA = newGPA;
		this.hasDiploma = diplomaCheck;
	}
	
	public newStudent() {
		this.studentSAT = 0;
		this.studentGPA = 0;
		this.hasDiploma = false;
	}
	
	public double getSAT() {
		return this.studentSAT;
	}
	
	public double getGPA() {
		return this.studentGPA;
		
	}
	
	public void setGPA(double newGpa) {
		this.studentGPA = newGpa;
	}
	
	public boolean hasDiploma() {
		return this.hasDiploma;
	}
	
	public void addPoints(int pointsToAdd) {
		points+= pointsToAdd;
	}
	
	public int getPoints() {
		return this.points;
	}
	
}
