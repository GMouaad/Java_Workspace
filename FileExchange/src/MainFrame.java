/**
 * Filename : MainFrame.java
 * Description : GUI class, Main Frame , Main function.
 * Author : Mouaad Gssair
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel MainContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 720, 485);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("File Exchange");
		MainContent = new MainContent(this);
		MainContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainContent.setLayout(new BorderLayout(0, 0));
		setContentPane(MainContent);
		setVisible(true);
	}

}
