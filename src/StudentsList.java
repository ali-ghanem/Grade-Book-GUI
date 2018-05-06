
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ali Ghanem
 *
 */
public class StudentsList {

	Random rand = new Random();
	private ArrayList<Student> studentsList = new ArrayList<Student>();

	public StudentsList() {
		// readFile();
	}

	public ArrayList<Student> getList() {
		return studentsList;
	}

	/**
	 * generate random double number between 0 and 100 then round it to two decimal
	 * places.
	 * 
	 * @return
	 */
	public double generateRandomDoubleNumber() {
		double number = rand.nextDouble() * 100.0;
		return Math.round(number * 100.0) / 100.0;
	}

	public String generateRandomName() {
		int limit = rand.nextInt(6) + 3;
		String name = "";
		for (int i = 0; i < limit; i++) {
			char character = (char) (rand.nextInt(26) + 'a');
			name += character;
		}
		return name;
	}

	public String generateID() {
		String id = generateNumber();
		while (idExist(id)) {
			id = generateNumber();
		}
		return id;
	}

	public String generateNumber() {
		String result = "";
		for (int i = 1; i <= 11; i++) {
			int number = rand.nextInt(10);
			result += number;
		}
		return result;
	}

	public boolean idExist(String id) {
		for (int i = 0; i < studentsList.size(); i++) {
			if (id.equals(studentsList.get(i).getID())) {
				return true;
			}
		}
		return false;
	}

	public double generateAverage(Student std) {
		double average = (std.getQuiz1() + std.getQuiz2() + std.getProject() + std.getMidterm() + std.getFinall())
				/ 5.0;
		return (Math.round(average * 100) / 100.0);
	}

	public String generateLetterGrade(Student std) {
		double average = std.getAverage();
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

	public void generateRandomStudents(int limit) {
		for (int i = 0; i < limit; i++) {
			Student std = new Student();
			std.setFirstName(generateRandomName().substring(0, 1).toUpperCase() + generateRandomName().substring(1));
			std.setLastName(generateRandomName().toUpperCase());
			std.setID(generateID());
			std.setQuiz1(generateRandomDoubleNumber());
			std.setQuiz2(generateRandomDoubleNumber());
			std.setProject(generateRandomDoubleNumber());
			std.setMidterm(generateRandomDoubleNumber());
			std.setFinall(generateRandomDoubleNumber());
			std.setAverage(generateAverage(std));
			std.setLetterGrade(generateLetterGrade(std));
			studentsList.add(std);
		}
	}

	/**
	 * readFile method for reading the "Student.txt" file which has 800 random
	 * students informations then it will add the students values to the array list.
	 */
	public void readFile() {
		try {
			Scanner s = new Scanner(new File("Student.txt"));

			while (s.hasNext()) {
				Student st = new Student();
				st.setFirstName(s.next());
				st.setLastName(s.next());
				st.setID(s.next());
				st.setQuiz1(Double.parseDouble(s.next()));
				st.setQuiz2(Double.parseDouble(s.next()));
				st.setProject(Double.parseDouble(s.next()));
				st.setMidterm(Double.parseDouble(s.next()));
				st.setFinall(Double.parseDouble(s.next()));
				st.setAverage(Double.parseDouble(s.next()));
				st.setLetterGrade(s.next());
				studentsList.add(st);

			}
			s.close();
		} catch (Exception e) {
			System.out.println("File not found.");
		}
	}
}