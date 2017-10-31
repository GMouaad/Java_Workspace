import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class BloodPressureMeasurement {

	private JFrame frame;
	public MainContent MainContent;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					BloodPressureMeasurement window = new BloodPressureMeasurement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BloodPressureMeasurement() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainContent = (MainContent) new JPanel();
		frame.getContentPane().add(MainContent, BorderLayout.CENTER);
		MainContent.setLayout(null);
		
		JButton btnStart = new JButton("Start Test");
		btnStart.setBounds(6, 43, 130, 29);
		MainContent.add(btnStart);
		
		JButton btnReadMeasuerement = new JButton("Read Measuerement");
		btnReadMeasuerement.setBounds(6, 84, 130, 29);
		MainContent.add(btnReadMeasuerement);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(6, 168, 130, 29);
		MainContent.add(btnExit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(6, 129, 130, 27);
		MainContent.add(comboBox);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu testMenu = new JMenu("Test");
		menuBar.add(testMenu);
		
		JMenuItem mntmNewTest = new JMenuItem("New Test");
		testMenu.add(mntmNewTest);
		
		JMenuItem mntmStartTest = new JMenuItem("Start Test");
		testMenu.add(mntmStartTest);
		
		JMenuItem mntmEditTest = new JMenuItem("Edit Test");
		testMenu.add(mntmEditTest);
		
		JMenuItem mntmPrint = new JMenuItem("Print ");
		testMenu.add(mntmPrint);
		
		JMenu measurementMenu = new JMenu("Measurement");
		menuBar.add(measurementMenu);
		
		JMenuItem mntmReadMeasurements = new JMenuItem("Read Measurements");
		measurementMenu.add(mntmReadMeasurements);
		
		JMenuItem mntmLoadData = new JMenuItem("Load Data");
		measurementMenu.add(mntmLoadData);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
	}
}
