import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MainFrame extends JFrame implements ActionListener {

	private StudentsList stdList;
	private Chart chart;
	private JTabbedPane tab;
	private JPanel list, menuPanel;
	private JScrollPane sc;
	private JTable table;
	// columnNames are the names of columns in the table
	private String[] columnNames = { "NAME", "LAST NAME", "ID", "QUIZ1", "QUIZ2", "PROJECT", "MIDTERM", "FINAL",
			"AVERAGE", "GRADE" };
	private DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
	private JMenuBar menus;
	private JMenu menuStudent, menuSort, menuFilter;
	private JMenuItem mAdd, mRemove, mRemoveAll, mSortLastName, mSortId, mSortAverage, mFilter, mRemoveFilter;

	public MainFrame() {

		stdList = new StudentsList();
		chart = new Chart(stdList);
		getTableData();

		setLayout(new BorderLayout());

		// =================Menus============================================ //

		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(0, 1));

		menus = new JMenuBar();

		menuStudent = new JMenu("Student");
		menuSort = new JMenu("Sort");
		menuFilter = new JMenu("Filter");

		mAdd = new JMenuItem("Add student");
		mAdd.addActionListener(this);
		mRemove = new JMenuItem("Remove student");
		mRemove.addActionListener(this);
		mRemoveAll = new JMenuItem("Remove all students");
		mRemoveAll.addActionListener(this);
		mSortLastName = new JMenuItem("Sort by last name");
		mSortLastName.addActionListener(this);
		mSortId = new JMenuItem("Sort by ID");
		mSortId.addActionListener(this);
		mSortAverage = new JMenuItem("Sort by average");
		mSortAverage.addActionListener(this);
		mFilter = new JMenuItem("Filter by letter grade");
		mFilter.addActionListener(this);
		mRemoveFilter = new JMenuItem("Remove filter");
		mRemoveFilter.addActionListener(this);

		menuStudent.add(mAdd);
		menuStudent.add(mRemove);
		menuStudent.add(mRemoveAll);
		menuSort.add(mSortLastName);
		menuSort.add(mSortId);
		menuSort.add(mSortAverage);
		menuFilter.add(mFilter);
		menuFilter.add(mRemoveFilter);

		menus.add(menuStudent);
		menus.add(menuSort);
		menus.add(menuFilter);

		menuPanel.add(menus);
		add(menuPanel, BorderLayout.NORTH);

		// =================Tabs============================================= //

		table = new JTable(tableModel);
		sc = new JScrollPane(table);
		// table row sorter will sort a specific column
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		list = new JPanel();
		list.setLayout(new BorderLayout());
		list.add(sc);
		tab = new JTabbedPane();
		tab.addTab("List", list);
		tab.addTab("Chart", chart);

		// ================================================================== //

		add(tab);
		setTitle("Grade Book");
		setVisible(true);
		setSize(1024, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * getData: it will take the values of each student from the array list then it
	 * will add it to array for using it as a row in the table model
	 */
	public void getTableData() {
		for (int i = 0; i < stdList.getList().size(); i++) {
			String firstName = stdList.getList().get(i).getFirstName();
			String lastName = stdList.getList().get(i).getLastName();
			String id = stdList.getList().get(i).getID();
			double quiz1 = stdList.getList().get(i).getQuiz1();
			double quiz2 = stdList.getList().get(i).getQuiz2();
			double project = stdList.getList().get(i).getProject();
			double midterm = stdList.getList().get(i).getMidterm();
			double finall = stdList.getList().get(i).getFinall();
			double avreage = stdList.getList().get(i).getAverage();
			String letterGrades = stdList.getList().get(i).getLetterGrade();
			Object[] data = { firstName, lastName, id, quiz1, quiz2, project, midterm, finall, avreage, letterGrades };

			tableModel.addRow(data);
		}

	}

	/**
	 * filter: it will delete all the rows from the table then,it will take a string
	 * (the input letter from the user) then it will search for the students who
	 * have the same letter grade in the array list, and added to the table
	 * 
	 * @param letterGrade
	 */
	public void filter(String letterGrade) {
		tableModel.setRowCount(0);
		for (int i = 0; i < stdList.getList().size(); i++) {
			if (stdList.getList().get(i).getLetterGrade().equals(letterGrade)) {
				String firstName = stdList.getList().get(i).getFirstName();
				String lastName = stdList.getList().get(i).getLastName();
				String id = stdList.getList().get(i).getID();
				double quiz1 = stdList.getList().get(i).getQuiz1();
				double quiz2 = stdList.getList().get(i).getQuiz2();
				double project = stdList.getList().get(i).getProject();
				double midterm = stdList.getList().get(i).getMidterm();
				double finall = stdList.getList().get(i).getFinall();
				double avreage = stdList.getList().get(i).getAverage();
				String letterGrades = stdList.getList().get(i).getLetterGrade();
				Object[] data = { firstName, lastName, id, quiz1, quiz2, project, midterm, finall, avreage,
						letterGrades };

				tableModel.addRow(data);
			}
		}
	}

	/**
	 * deleteStudent: it will take a string which represent the id of a student it
	 * will search in the array list for a student who have the same id and it will
	 * delete it then it will return a message for telling the user that the student
	 * is deleted, and if the id does not match any student's id so it will return a
	 * message which say that there is no such student.
	 * 
	 * @param id
	 * @return message
	 */
	public String deleteStudent(String id) {
		String message = "No such student is found.";
		for (int i = 0; i < stdList.getList().size(); i++) {
			if (stdList.getList().get(i).getID().equals(id)) {
				stdList.getList().remove(i);
				tableModel.removeRow(i);
				message = "Student is deleted.";
			}
		}
		return message;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ===============================
		// Configure add menu //
		// ===============================

		if (e.getSource().equals(mAdd)) {
			String stringLimit = JOptionPane.showInputDialog(this, "Hom many students do you to add?");

			// convert the input string to integer
			int limit = Integer.parseInt(stringLimit);

			/*
			 * delete all the rows in the table model in order to avoid taking the same
			 * students more than one time
			 */
			tableModel.setRowCount(0);

			// generate the same number of students to the array list
			stdList.generateRandomStudents(limit);

			// add the students information to the table
			getTableData();

			// update the chart:
			chart.getInfo(stdList);

			JOptionPane.showMessageDialog(this,
					limit + " students are added. Total number of students is " + stdList.getList().size());
		}

		// ===============================
		// Configure remove menu //
		// ===============================

		else if (e.getSource().equals(mRemove)) {
			// get the id from user
			String id = JOptionPane.showInputDialog(this,
					"Enter the ID of the student you want to remove from the list");

			// search for it and return the result:
			JOptionPane.showMessageDialog(this, deleteStudent(id));

			// update the chart:
			chart.getInfo(stdList);
		}

		// ===============================
		// Configure remove all menu //
		// ===============================

		else if (e.getSource().equals(mRemoveAll)) {
			// clear the array list
			stdList.getList().clear();

			// delete all the rows in the table
			tableModel.setRowCount(0);

			// update the chart:
			chart.getInfo(stdList);

			JOptionPane.showMessageDialog(this, "Student list is cleared.");
		}

		/**
		 * for sorting i use the method "toggleSortOrder" this method will sort a
		 * specific column in ascending order by default, but if it is already sorted in
		 * ascending it will sort it in descending order and vice versa.
		 */
		else if (e.getSource().equals(mSortLastName)) {
			table.getRowSorter().toggleSortOrder(1);
		} else if (e.getSource().equals(mSortId)) {
			table.getRowSorter().toggleSortOrder(2);
		} else if (e.getSource().equals(mSortAverage)) {
			table.getRowSorter().toggleSortOrder(8);
		}

		// ===============================
		// Configure filter menu //
		// ===============================

		else if (e.getSource().equals(mFilter)) {
			String grade = JOptionPane.showInputDialog(this, "Which grade do you want to filter?");
			// taking a string from the user and convert it to upper case
			// because all the letter grades are in the upper case
			filter(grade.toUpperCase());

		}

		// ===============================
		// Configure remove filter menu//
		// ===============================

		else {
			// delete rows from the table
			tableModel.setRowCount(0);
			// add all students in the array list to the table
			getTableData();
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
