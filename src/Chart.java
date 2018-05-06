
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Ali Ghanem
 *
 */
public class Chart extends JPanel {

	// These variables represent the height of each rectangle:
	private int quiz1 = 0;
	private int quiz2 = 0;
	private int project = 0;
	private int midterm = 0;
	private int finall = 0;
	private int average = 0;
	private JLabel qu1, qu2, pro, mid, fin, avg;

	public Chart(StudentsList stdList) {

		getInfo(stdList);

		// ============================== //
		setLayout(null);

		qu1 = new JLabel("Quiz 1");
		qu1.setSize(50, 50);
		qu1.setLocation(50, 600);
		add(qu1);

		qu2 = new JLabel("Quiz 2");
		qu2.setSize(50, 50);
		qu2.setLocation(220, 600);
		add(qu2);

		pro = new JLabel("Project");
		pro.setSize(50, 50);
		pro.setLocation(390, 600);
		add(pro);

		mid = new JLabel("Midterm");
		mid.setSize(50, 50);
		mid.setLocation(560, 600);
		add(mid);

		fin = new JLabel("Final");
		fin.setSize(50, 50);
		fin.setLocation(730, 600);
		add(fin);

		avg = new JLabel("Average");
		avg.setSize(50, 50);
		avg.setLocation(900, 600);
		add(avg);

		setSize(1024, 800);
		setVisible(true);
	}

	/**
	 * paint method will draw tow lines which represent the x,y coordinates and it
	 * will draw five rectangle for quiz1,quiz2,project,midterm,final,average and
	 * the height of these rectangles will be set according to the averages of the
	 * grades. I multiply the height by 6 to be bigger and clearer, but it will not
	 * change the different ratios between all the rectangles.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(10, 0, 10, 600);
		g.drawLine(10, 600, 1024, 600);
		g.fillRect(50, 600 - quiz1 * 6, 30, quiz1 * 6);
		g.fillRect(220, 600 - quiz2 * 6, 30, quiz2 * 6);
		g.fillRect(390, 600 - project * 6, 30, project * 6);
		g.fillRect(560, 600 - midterm * 6, 30, midterm * 6);
		g.fillRect(730, 600 - finall * 6, 30, finall * 6);
		g.fillRect(900, 600 - average * 6, 30, average * 6);
	}

	public void getInfo(StudentsList stdList) {
		quiz1 = 0;
		quiz2 = 0;
		project = 0;
		midterm = 0;
		finall = 0;
		average = 0;
		int size = stdList.getList().size();

		if (size != 0) {
			for (int i = 0; i < size; i++) {
				quiz1 += stdList.getList().get(i).getQuiz1();
				quiz2 += stdList.getList().get(i).getQuiz2();
				project += stdList.getList().get(i).getProject();
				midterm += stdList.getList().get(i).getMidterm();
				finall += stdList.getList().get(i).getFinall();
				average += stdList.getList().get(i).getAverage();
			}

			quiz1 /= size;
			quiz2 /= size;
			project /= size;
			midterm /= size;
			finall /= size;
			average /= size;
		}

		repaint();

	}
}