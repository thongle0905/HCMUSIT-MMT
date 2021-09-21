package khtn.network;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class EditRegistry {

	private JFrame frame;
	private JTextField textField;

	public JFrame getFrame() {
		return frame;
	}

	public EditRegistry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 430);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 280, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse...");
		btnBrowse.setBounds(300, 10, 124, 23);
		frame.getContentPane().add(btnBrowse);
		
		JTextArea txtAContent = new JTextArea();
		txtAContent.setBounds(10, 42, 280, 94);
		frame.getContentPane().add(txtAContent);
		
		JButton btnSendContent = new JButton("G\u1EEDi n\u1ED9i dung");
		btnSendContent.setBounds(300, 42, 124, 94);
		frame.getContentPane().add(btnSendContent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 414, 208);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("S\u1EEDa gi\u00E1 tr\u1ECB tr\u1EF1c ti\u1EBFp");
		lblNewLabel.setBounds(10, 147, 124, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
