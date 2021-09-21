package khtn.network;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Client {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void setBtnConnect(JButton btnConnect) {
		this.btnConnect = btnConnect;
	}

	private JTextField txtConnect;
	private JButton btnConnect;
	public JButton getBtnConnect() {
		return btnConnect;
	}
	public JTextField getTxtConnect() {
		return txtConnect;
	}

	public void setTxtConnect(JTextField txtConnect) {
		this.txtConnect = txtConnect;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtConnect = new JTextField();
		txtConnect.setText("Nh\u1EADp IP");
		txtConnect.setToolTipText("Nh\u1EADp IP");
		txtConnect.setBounds(10, 11, 315, 20);
		txtConnect.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtConnect.getText().equals("Nhập IP")) {
					txtConnect.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtConnect.getText().isEmpty()) {
					txtConnect.setText("Nhập IP");
				}
			}
		});
		frame.getContentPane().add(txtConnect);
		txtConnect.setColumns(10);

		btnConnect = new JButton("K\u1EBFt n\u1ED1i");
		btnConnect.setBounds(335, 10, 89, 23);
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientSocket cs = new ClientSocket();
				cs.setHostName(txtConnect.getText());
				cs.sendCmd("Connect");
			};
		});
		frame.getContentPane().add(btnConnect);

		JButton btnProcesses = new JButton("<html>Process<br/>Running</html>");
		btnProcesses.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnProcesses.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProcesses.setBounds(10, 42, 89, 208);
		frame.getContentPane().add(btnProcesses);

		JButton btnAppRunning = new JButton("App Running");
		btnAppRunning.setBounds(109, 42, 216, 41);
		frame.getContentPane().add(btnAppRunning);

		JButton btnKeystroke = new JButton("<html><center>Key<br>stroke</center></html>");
		btnKeystroke.setBounds(335, 42, 89, 120);
		frame.getContentPane().add(btnKeystroke);

		JButton btnShutDown = new JButton("T\u1EAFt m\u00E1y");
		btnShutDown.setBounds(109, 94, 98, 68);
		frame.getContentPane().add(btnShutDown);

		JButton btnScreenShot = new JButton("<html><center>Ch\u1EE5p<br>m\u00E0n<br>h\u00ECnh</center></html>");
		btnScreenShot.setBounds(227, 94, 98, 68);
		frame.getContentPane().add(btnScreenShot);

		JButton btnEditRegistry = new JButton("S\u1EEDa registry");
		btnEditRegistry.setBounds(109, 173, 216, 77);
		btnEditRegistry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					EditRegistry window = new EditRegistry();
					window.getFrame().setVisible(true);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnEditRegistry);

		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.setBounds(335, 173, 89, 77);
		frame.getContentPane().add(btnExit);
	}
}
