/**
 * @Filename : FitnessControl.java
 * Description : Subclasse of TestControl(JDialog).
 * @author : Mouaad Gssair
 * Imm.Nummer : 294618
 * 
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FitnessControl extends TestControl {

	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FitnessControl dialog = new FitnessControl();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void stateMachine()
	{
		switch(State)
		{
			case 1 : lblLabelText.setText("10 Jumping jacks");
					State++;
					break;
			case 2 : lblLabelText.setText("20 Squats");
					State++;
					break;
			case 3 : lblLabelText.setText("20 Push-ups");
					State++;
					break;
			case 4 : lblLabelText.setText("Elbow Plank (60 Seconds) ");
					setTimer(60000);
					// State will be increased in the setTimer() Function 
					break;
			case 5 : closeDialog();
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
	public FitnessControl() {
		super();
	}

}
