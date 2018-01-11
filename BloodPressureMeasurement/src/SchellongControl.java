/**
 * @Filename : SchellongControl.java
 * Description : Subclasse of TestControl(JDialog).
 * @author : Mouaad Gssair
 * Imm.Nummer : 294618
 * 
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchellongControl extends TestControl {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SchellongControl dialog = new SchellongControl();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stateMachine()
	{
		switch(State)
		{
			case 1 : lblLabelText.setText("Lay down (30 seconds !) ");
					setTimer(30000);
					// State will be increased in the setTimer() Function 
					break;
			case 2 : lblLabelText.setText("Stand up (30 seconds !) ");
					setTimer(30000);
					// State will be increased in the setTimer() Function 
					break;
			case 3 : closeDialog();
			default : lblLabelText.setText("Error. Please Reset!");
			
		}
	}
	
	public void showDialog()
	{
		setModal(true);
		setVisible(true);
	}
	
	/**
	 * Create the dialog.
	 */
	public SchellongControl() {
		super();
	}

}
