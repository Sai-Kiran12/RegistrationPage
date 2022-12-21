package LoginDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginDatabase extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDatabase frame = new LoginDatabase();
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
	public LoginDatabase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 101, 90, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(44, 167, 90, 35);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(44, 232, 90, 35);
		contentPane.add(lblEmail);
		
		JLabel lblMobileNumber = new JLabel("Mobile No");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobileNumber.setBounds(44, 306, 90, 35);
		contentPane.add(lblMobileNumber);
		
		t1 = new JTextField();
		t1.setBounds(245, 103, 138, 35);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(245, 232, 138, 35);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(245, 293, 138, 35);
		contentPane.add(t4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = t1.getText();
				String n2 = t2.getText();
				String n3 = t3.getText();
				String n4 = t4.getText();
				
				try {
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","root");
					String q="Insert into ligin_details values('"+n+"','"+n2+"','"+n3+"','"+n4+"')";
					Statement st = con.createStatement();
					st.executeUpdate(q);
					JOptionPane.showMessageDialog(btnNewButton, "Done");
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(276, 407, 99, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Registration");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(262, 26, 138, 35);
		contentPane.add(lblNewLabel_1);
		
		t2 = new JPasswordField();
		t2.setBounds(245, 177, 138, 35);
		contentPane.add(t2);
	}
}
