/**
 * Projekt : BloodPressureMeasurement
 * Filename : EditTestDialog.java
 * Beschreibung :
 * @author : Mouaad Gssair
 * Imm.Nummer : 294618
 * Verlauf : Jan 8, 2018
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private String testName,selectedTest;
	private ButtonGroup testType_ButtonGroup;
	private JRadioButton rdbtnSchellongTest,rdbtnFitnessTest;
	private boolean result;

	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NewTestDialog dialog = new NewTestDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public boolean showDialog()
	{
		setModal(true);
		setVisible(true);
		return result;
	}
	public String getTestName()
	{
		return testName;
	}
	public String getSelectedTest()
	{
		return selectedTest;
	}

	/**
	 * Create the dialog.
	 */
	public NewTestDialog() {
		//super(parent , "New Test");
		setBounds(100, 100, 400, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTestName = new JLabel("Test Name :");
			lblTestName.setBounds(45, 48, 75, 16);
			contentPanel.add(lblTestName);
		}
		{
			textField = new JTextField(testName);
			textField.setBounds(148, 43, 180, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblTestType = new JLabel("Test Type  :");
			lblTestType.setBounds(45, 76, 75, 16);
			contentPanel.add(lblTestType);
		}
		
		rdbtnFitnessTest = new JRadioButton("Fitness Test");
		rdbtnFitnessTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedTest = "F";
				//rdbtnSchellongTest.setSelected(false);
			}
		});
		rdbtnFitnessTest.setSelected(true);
		rdbtnFitnessTest.setBounds(148, 72, 116, 23);
		contentPanel.add(rdbtnFitnessTest);
		
		rdbtnSchellongTest = new JRadioButton("Schellong Test");
		rdbtnSchellongTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedTest = "S";
				//rdbtnFitnessTest.setSelected(false);
			}
		});
		rdbtnSchellongTest.setBounds(253, 72, 141, 23);
		contentPanel.add(rdbtnSchellongTest);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText() != "" )
						{
							testName = textField.getText();
							if(rdbtnFitnessTest.isSelected())
							{
								selectedTest = "F";
							}
							else
								selectedTest = "S";
							result=true;
							dispose();
							setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null,"Please enter a name for the Test");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						result = false;
						dispose();
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		testType_ButtonGroup = new ButtonGroup();
        testType_ButtonGroup.add(rdbtnFitnessTest);
        testType_ButtonGroup.add(rdbtnSchellongTest);
	}
}