
/**
 * @author Ali Ghanem
 *
 */
public class Student {

	private String firstName;
	private String lastName;
	private String ID;
	private double quiz1;
	private double quiz2;
	private double project;
	private double midtermGrade;
	private double finalGrade;
	private double average;
	private String letterGrade;

	public Student() {

	}

	public Student(String firstName, String lastName, String iD, double quiz1, double quiz2, double project,
			double midtermGrade, double finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		ID = iD;
		this.quiz1 = quiz1;
		this.quiz2 = quiz2;
		this.project = project;
		this.midtermGrade = midtermGrade;
		this.finalGrade = finalGrade;
		average = generateAverage();
		letterGrade = generateLetterGrade();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public double getQuiz1() {
		return quiz1;
	}

	public void setQuiz1(double quiz1) {
		this.quiz1 = quiz1;
	}

	public double getQuiz2() {
		return quiz2;
	}

	public void setQuiz2(double quiz2) {
		this.quiz2 = quiz2;
	}

	public double getProject() {
		return project;
	}

	public void setProject(double project) {
		this.project = project;
	}

	public double getMidterm() {
		return midtermGrade;
	}

	public void setMidterm(double midterm) {
		this.midtermGrade = midterm;
	}

	public double getFinall() {
		return finalGrade;
	}

	public void setFinall(double finall) {
		this.finalGrade = finall;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public double generateAverage() {
		double average = (quiz1 + quiz2 + project + midtermGrade + finalGrade)
				/ 5.0;
		return (Math.round(average * 100) / 100.0);
	}

	public String generateLetterGrade() {
		if (average >= 0 && average < 30) {
			return "F";
		} else if (average >= 30 && average < 50) {
			return "D";
		} else if (average >= 50 && average < 60) {
			return "D+";
		} else if (average >= 60 && average < 65) {
			return "C-";
		} else if (average >= 65 && average < 70) {
			return "C";
		} else if (average >= 70 && average < 75) {
			return "C+";
		} else if (average >= 75 && average < 80) {
			return "B-";
		} else if (average >= 80 && average < 85) {
			return "B";
		} else if (average >= 85 && average < 90) {
			return "B+";
		} else if (average >= 90 && average < 95) {
			return "A-";
		} else {
			return "A";
		}
	}
}
