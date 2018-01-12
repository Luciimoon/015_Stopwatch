package stopwatch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Stopwatch extends JFrame {
	private static final long serialVersionUID = 1L;

	long startTime;
	long stopTime;
	double elapsedTime;
	boolean timeStarted = false;
	String runner1;
	String runner2;
	String runner3;
	String runner4;
	String runner5;
	String runner6;
	String runner7;

	JButton startButton = new JButton();
	JLabel startLabel = new JLabel();
	JTextField startTextField = new JTextField();

	JButton stopButton = new JButton();
	JLabel stopLabel = new JLabel();
	JTextField stopTextField = new JTextField();

	JButton exitButton = new JButton();

	JLabel elapsedLabel = new JLabel();
	JTextField elapsedTextField = new JTextField();

	JButton stopButton1 = new JButton();
	JLabel stopLabel1 = new JLabel();
	JTextField stopTextField1 = new JTextField();
	JLabel elapsedLabel1 = new JLabel();
	JTextField elapsedTextField1 = new JTextField();

	public Stopwatch(String title) {

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 2; i++) {
			
			
		runner1 = JOptionPane.showInputDialog("Enter runner " + (i+1) + " name");
		}

		// Create and set up the content pane.
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints = new GridBagConstraints();

		// Create and set up the components
		startButton.setText("Start Timing");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		getContentPane().add(startButton, gridConstraints);

		// Add an Action Listener to detect and respond to clicks
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}

		});

		startLabel.setText("  Start System Time  ");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		getContentPane().add(startLabel, gridConstraints);

		startTextField.setText("");
		startTextField.setColumns(20);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		getContentPane().add(startTextField, gridConstraints);

		stopButton.setText("Stop Timing");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		getContentPane().add(stopButton, gridConstraints);

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopButtonActionPerformed(e);
			}

		});

		stopLabel.setText(runner1);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		getContentPane().add(stopLabel, gridConstraints);

		stopTextField.setText("");
		stopTextField.setColumns(20);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 1;
		getContentPane().add(stopTextField, gridConstraints);

		exitButton.setText("Close ALL Watches");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		getContentPane().add(exitButton, gridConstraints);

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
			}

		});

		elapsedLabel.setText("  Elapsed Time Seconds  ");
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 1;
		getContentPane().add(elapsedLabel, gridConstraints);

		// second line
		stopButton1.setText("Stop Timing");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		getContentPane().add(stopButton1, gridConstraints);

		stopButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop1ButtonActionPerformed(e);
			}

		});

		stopLabel1.setText(runner2);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		getContentPane().add(stopLabel1, gridConstraints);

		stopTextField1.setText("");
		stopTextField1.setColumns(20);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 2;
		getContentPane().add(stopTextField1, gridConstraints);

		elapsedLabel1.setText("  Elapsed Time Seconds  ");
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 2;
		getContentPane().add(elapsedLabel1, gridConstraints);

		elapsedTextField1.setText("");
		elapsedTextField1.setColumns(20);
		gridConstraints.gridx = 4;
		gridConstraints.gridy = 2;
		getContentPane().add(elapsedTextField1, gridConstraints);

		elapsedTextField.setText("");
		elapsedTextField.setColumns(20);
		gridConstraints.gridx = 4;
		gridConstraints.gridy = 1;
		getContentPane().add(elapsedTextField, gridConstraints);

		// Make the window visible, and set the size to either a fixed size, or
		// have it packed tight
		setLocationRelativeTo(null);
		pack();

	} // end of constructor

	private void startButtonActionPerformed(ActionEvent e) {
		startTime = System.currentTimeMillis();

		Date startDate = new Date();
		startTextField.setText(startDate.toString());
		stopTextField.setText("");
		elapsedTextField.setText("");
		timeStarted = true;

	}

	private void stopButtonActionPerformed(ActionEvent e) {
		if (timeStarted) {
			stopTime = System.currentTimeMillis();
			Date stopDate = new Date();
			stopTextField.setText(stopDate.toString());
			elapsedTime = (stopTime - startTime) / 1000.0;
			elapsedTextField.setText(String.valueOf(elapsedTime));
		} else {
			return;
		}

	}

	protected void stop1ButtonActionPerformed(ActionEvent e) {
		if (timeStarted) {
			stopTime = System.currentTimeMillis();
			Date stopDate = new Date();
			stopTextField.setText(stopDate.toString());
			elapsedTime = (stopTime - startTime) / 1000.0;
			elapsedTextField1.setText(String.valueOf(elapsedTime));
		} else {
			return;
		}

	}

	private void exitButtonActionPerformed(ActionEvent e) {
		System.exit(0);

	}

} // end of class