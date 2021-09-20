package khtn.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;

public class ClientSocket {
	public static void main(String[] args) {
		String hostName = "127.0.0.1";
		int portNumber = 1234;
		Client c = new Client();
		c.getFrame().setVisible(true);
		JButton btnConnect = c.getBtnConnect();
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try (Socket echoSocket = new Socket(c.getTxtConnect().getText(), portNumber);
						PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
						BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
					String test = "test";
					out.println(test);
					System.out.println("echo: " + in.readLine());
//					while ((userInput = stdIn.readLine()) != null) {
//					}
				} catch (UnknownHostException e1) {
					System.err.println("Don't know about host " + hostName);
					System.exit(1);
				} catch (IOException e1) {
					System.err.println("Couldn't get I/O for the connection to " + hostName);
					System.exit(1);
				}
			}
		});
	}

}
