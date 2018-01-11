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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditTestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private String testName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditTestDialog dialog = new EditTestDialog("defaultName");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTestName()
	{
		return testName;
	}
	
	/**
	 * Create the dialog.
	 */
	public EditTestDialog(String oldName) {
		setBounds(100, 100, 350, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTestName = new JLabel("Test Name :");
			lblTestName.setBounds(52, 56, 75, 16);
			contentPanel.add(lblTestName);
		}
		{
			textField = new JTextField(oldName);
			textField.setBounds(153, 51, 130, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
