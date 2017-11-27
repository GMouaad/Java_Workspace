/**
 * Filename : MainContent.java
 * Description : Subclasse of JPanel, contains all the content of the Frame.
 * Author : Mouaad Gssair
 * Imm.Nummer : 294618
 * 
*/

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainContent extends JPanel {

	private static int counter=0;
	private static GenericTest[] genericTestArray =  new GenericTest[10];
	private static GenericTest actualTest;
	/**
	 * Create the panel.
	 */
	public MainContent() 
	{
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 700, 22);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnTest = new JMenu("Test");
		menuBar.add(mnTest);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnTest.add(mntmNew);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mnTest.add(mntmEdit);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnTest.add(mntmPrint);
		
		JMenu mnMeasurement = new JMenu("Measurement");
		menuBar.add(mnMeasurement);
		
		JMenuItem mntmRead = new JMenuItem("Read");
		mnMeasurement.add(mntmRead);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnMeasurement.add(mntmLoad);
		
		JMenuItem mntmSaveData = new JMenuItem("Save Data");
		mnMeasurement.add(mntmSaveData);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JButton btnStartTest = new JButton("Start Test");
		btnStartTest.setBounds(6, 83, 117, 29);
		add(btnStartTest);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(6, 124, 117, 29);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(16, 165, 107, 27);
		add(comboBox);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(6, 298, 117, 29);
		add(btnExit);

	}
	public GenericTest getactualTest(){
		return actualTest;
	}
}
