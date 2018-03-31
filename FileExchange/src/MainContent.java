/**
 * Filename : MainContent.java
 * Description : GUI class, Main Content
 * Author : Mouaad Gssair
 */
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import javafx.stage.FileChooser;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MainContent extends JPanel {

	//HOST Components
    String SFTPHOST;
    int SFTPPORT = 22;
    String SFTPUSER;
    String SFTPPASS;
    String SFTPWORKINGDIR;

    //SFTP_Channel Compenents
    Session session = null;
    Channel channel = null;
    ChannelSftp channelSftp = null;

	//UI Components
	private String filePath;
	private File selectedFile;
	private JFrame frameInstance;
	private JTextField hostTxtField;
	private JTextField portTxtField;
	private JTextField userTxtField;
	private JPasswordField passwordField;
	private JTextField txtFilePath;
	private JTextField destinationPath;
	
	
	/**
	 * Create the panel.
	 */
	public MainContent(JFrame frameInstance) {
		setLayout(null);
		this.frameInstance = frameInstance;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 22);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO : change link to a URL Hyperlink , see docm. https://binfalse.de/2011/01/03/adding-a-hyperlink-to-java-swing-gui/
				JOptionPane.showMessageDialog(null,"\t\t\t File Exchange \n\n"
						+ "Software developped by Mouaad Gssair \n"
						+ "This Software is an Open-Source Software available in GitHub :\n"
						+ "https://github.com/GMouaad/Java_Workspace/tree/master/FileExchange\n"
						+ "For any other Informations, please contact Mgsair@gmail.com\n");
			}
		});
		mnHelp.add(mntmAbout);
		
		JLabel lblHost = new JLabel("Host :");
		lblHost.setBounds(40, 81, 61, 16);
		add(lblHost);
		
		JLabel lblPort = new JLabel("Port :");
		lblPort.setBounds(40, 109, 61, 16);
		add(lblPort);
		
		JLabel lblUser = new JLabel("User :");
		lblUser.setBounds(40, 137, 61, 16);
		add(lblUser);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(40, 165, 80, 16);
		add(lblPassword);
		
		hostTxtField = new JTextField();
		hostTxtField.setBounds(113, 76, 130, 26);
		add(hostTxtField);
		hostTxtField.setColumns(10);
		
		portTxtField = new JTextField();
		portTxtField.setBounds(113, 104, 130, 26);
		add(portTxtField);
		portTxtField.setColumns(10);
		
		userTxtField = new JTextField();
		userTxtField.setBounds(113, 132, 130, 26);
		add(userTxtField);
		userTxtField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 160, 130, 26);
		add(passwordField);
		
		JLabel lblFile = new JLabel("File :");
		lblFile.setBounds(300, 81, 61, 16);
		add(lblFile);
		
		JLabel lblPath = new JLabel("Path :");
		lblPath.setBounds(300, 109, 61, 16);
		add(lblPath);
		
		txtFilePath = new JTextField();
		txtFilePath.setText("");
		txtFilePath.setBounds(355, 76, 130, 26);
		add(txtFilePath);
		txtFilePath.setColumns(10);
		
		destinationPath = new JTextField();
		destinationPath.setBounds(355, 104, 130, 26);
		add(destinationPath);
		destinationPath.setColumns(10);
		
		JButton btnSelectFile = new JButton("Select File");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile();
				
			}

			
		});
		btnSelectFile.setBounds(483, 76, 117, 29);
		add(btnSelectFile);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendFile();
			}
		});
		btnSend.setBounds(355, 140, 117, 29);
		add(btnSend);
		
		JLabel lblUpload = new JLabel("Upload");
		lblUpload.setBounds(263, 34, 61, 16);
		add(lblUpload);
		
		JLabel lblDownload = new JLabel("Download");
		lblDownload.setBounds(251, 206, 80, 16);
		add(lblDownload);
		
		
	}
	protected void sendFile() {
		
		if((hostTxtField.getText() != "") && (passwordField.getText() != "") && (userTxtField.getText() != "") && (destinationPath.getText() != ""))
		{
			SFTPUSER = userTxtField.getText();
			SFTPHOST = hostTxtField.getText();
			SFTPPORT = Integer.parseInt(portTxtField.getText());
			SFTPPASS = String.valueOf(passwordField.getPassword());
			SFTPWORKINGDIR = destinationPath.getText();
			try {
	            JSch jsch = new JSch();
	            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
	            session.setPassword(SFTPPASS);
	            java.util.Properties config = new java.util.Properties();
	            config.put("StrictHostKeyChecking", "no");
	            session.setConfig(config);
	            session.connect();
	            channel = session.openChannel("sftp");
	            channel.connect();
	            channelSftp = (ChannelSftp) channel;
	            channelSftp.cd(SFTPWORKINGDIR);
	            FileInputStream fis = new FileInputStream(selectedFile);
	            channelSftp.put(fis, selectedFile.getName());
	            fis.close();
	            System.out.println("File transfered");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            System.out.println(ex.getMessage());
	        }
		}
		
	}
	public void selectFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open Resource File");
		fileChooser.showOpenDialog(frameInstance);
		selectedFile = fileChooser.getSelectedFile();
		if(selectedFile != null)
		{
			filePath = selectedFile.getAbsolutePath();
			txtFilePath.setText(filePath);
			System.out.println("File selected");
		}
		else
		{
			System.out.println("No File selected");
		}
		
		
	}
	
}
