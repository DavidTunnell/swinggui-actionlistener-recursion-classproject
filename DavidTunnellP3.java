package Recursion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DavidTunnellP3 extends JFrame {

	public String nameString, comboString;
	private int yearString;
	private boolean isEmployedBool, isStudentBool;
	private String[] comboOptions = { "Employed", "Unemployed" };

	private JTextField name = new JTextField();
	private JTextField yob = new JTextField();
	private JTextArea output = new JTextArea(5, 40);
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton student = new JRadioButton("Student");
	private JRadioButton nonStudent = new JRadioButton("Non-Student");
	private JComboBox employ = new JComboBox(comboOptions);
	private JButton computeButton = new JButton("OK");

	public DavidTunnellP3() {

		JPanel p1 = new JPanel(new GridLayout(5, 2));
		p1.add(new JLabel("Name:"));
		p1.add(name);
		p1.add(new JLabel("Year of Birth: "));
		p1.add(yob);

		buttonGroup.add(student);
		p1.add(student);
		buttonGroup.add(nonStudent);
		p1.add(nonStudent);
		p1.setBorder(new TitledBorder("Enter name and year of birth"));
		p1.add(employ);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p2.add(output);
		p2.setBorder(new TitledBorder(""));

		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(computeButton);

		// Add the panels to frame
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		// Add shortcut
		computeButton.setMnemonic('O');

		// Add tool tip
		computeButton
				.setToolTipText("Press for a personalized message once the form is completely filled in.");

		// Register listener
		computeButton.addActionListener(new ButtonListener());

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			nameString = name.getText();
			comboString = employ.getSelectedItem().toString();
			yearString = Integer.parseInt(yob.getText());
			studentBool();
			empBool();
			Person personObject = new Person(nameString, yearString,
					isStudentBool, isEmployedBool);
			output.setText(personObject.returnSentence());
		}
	}

	private void studentBool() {
		if (student.isSelected()) {
			isStudentBool = true;
		} else {
			isStudentBool = false;
		}
	}

	private void empBool() {
		if (comboString == "Employed") {
			isEmployedBool = true;
		} else {
			isEmployedBool = false;
		}
	}

	public static void main(String[] args) {
		DavidTunnellP3 frame = new DavidTunnellP3();
		frame.setSize(600, 333);
		frame.setTitle("Hello, Person!");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
