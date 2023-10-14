package id_card_generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import com.mysql.cj.xdevapi.Statement;

public class Staff {
	
	String[] options1 = {"CSE", "AIDS", "ECE", "MECH"};
	String[] options2 = {"'B+' ve", "'O+' ve", "'A+' ve", "'AB+' ve", "'B-' ve", "'O-' ve", 
			"'A-' ve", "'AB-' ve", "'A1B+' ve", "'A1B-' ve", "'A2B+' ve", "'A2B-' ve"};
	
	JFrame frame = new JFrame("Staff");
	
	JTextField tf_name = new JTextField();
	JTextField tf_roll = new JTextField();
	JTextField tf_desig = new JTextField();
	JTextField tf_mobile = new JTextField();
	JTextField tf_contact = new JTextField();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox cb_branch = new JComboBox(options1);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox cb_bg = new JComboBox(options2);
	
	JLabel label_head = new JLabel("STAFF DETAILS");
	JLabel label_name = new JLabel("Full Name :");
	JLabel label_roll = new JLabel("Staff Code :");
	JLabel label_desig = new JLabel("Designation :");
	JLabel label_branch = new JLabel("Department :");
	JLabel label_dob = new JLabel("DOB :");
	JLabel label_mobile = new JLabel("Mobile No :");
	JLabel label_emergency = new JLabel("Emergency :");
	JLabel label_contact = new JLabel("Contact");
	JLabel label_bg = new JLabel("Blood Group :");
	JLabel label_image = new JLabel("Upload Image :");
	JLabel label_address = new JLabel("Address :");
	
	JTextArea textarea = new JTextArea();
	
	JButton button_back = new JButton("BACK");
	JButton button_display = new JButton("DISPLAY");
	JButton button_browse = new JButton("BROWSE");
	
	JDatePickerImpl datepicker;
	SqlDateModel model = new SqlDateModel();
	Properties p = new Properties();
	
	Connection connection = null;
	@SuppressWarnings("rawtypes")
	Statement stmt = null;
	
	String s;
	String filepath;
	JFileChooser filechooser;
	int r, c;
	File file;
	
	@SuppressWarnings("serial")
	Staff(){
		
		connection = sql_database_connector.staffConnector();
		
		label_head.setBounds(200, 5, 200, 40);
		label_head.setFont(new Font("Cambria", Font.BOLD, 20));
		label_head.setBackground(Color.white);
		label_head.setForeground(Color.white);
		
		label_name.setBounds(8, 60, 100, 30);
		label_name.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_name.setBackground(new Color(0, 0, 26));
		
		label_desig.setBounds(8, 110, 120, 30);
		label_desig.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_desig.setBackground(new Color(0, 0, 26));
		
		label_roll.setBounds(8, 160, 100, 30);
		label_roll.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_roll.setBackground(new Color(0, 0, 26));
		
		label_branch.setBounds(8, 210, 120, 30);
		label_branch.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_branch.setBackground(new Color(0, 0, 26));
		
		label_dob.setBounds(8, 260, 80, 30);
		label_dob.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_dob.setBackground(new Color(0, 0, 26));
		
		label_mobile.setBounds(8, 500, 100, 30);
		label_mobile.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_mobile.setBackground(new Color(0, 0, 26));
		
		label_emergency.setBounds(8, 550, 174, 30);
		label_emergency.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_emergency.setBackground(new Color(0, 0, 26));
		
		label_contact.setBounds(32, 574, 174, 30);
		label_contact.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_contact.setBackground(new Color(0, 0, 26));
		
		label_bg.setBounds(8, 624, 174, 30);
		label_bg.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_bg.setBackground(new Color(0, 0, 26));
		
		label_image.setBounds(8, 674, 174, 30);
		label_image.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_image.setBackground(new Color(0, 0, 26));
		
		label_address.setBounds(8, 310, 174, 30);
		label_address.setFont(new Font("Cambria", Font.PLAIN, 20));
		label_address.setBackground(new Color(0, 0, 26));
		
		tf_name.setBounds(150, 60, 280, 30);
		tf_name.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_name.setBackground(Color.black);
		tf_name.setForeground(Color.green);
		tf_name.setCaretColor(Color.red);
		
		tf_desig.setBounds(150, 110, 200, 30);
		tf_desig.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_desig.setBackground(Color.black);
		tf_desig.setForeground(Color.green);
		tf_desig.setCaretColor(Color.RED);
		
		tf_roll.setBounds(150, 160, 200, 30);
		tf_roll.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_roll.setBackground(Color.black);
		tf_roll.setForeground(Color.green);
		tf_roll.setCaretColor(Color.RED);
		
		cb_branch.setBounds(150, 210, 100, 30);
		cb_branch.setBackground(Color.black);
		cb_branch.setForeground(Color.green);
		cb_branch.setFont(new Font("Cambria", Font.PLAIN, 16));
		
		tf_mobile.setBounds(150, 500, 200, 30);
		tf_mobile.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_mobile.setBackground(Color.black);
		tf_mobile.setForeground(Color.green);
		tf_mobile.setCaretColor(Color.RED);
		
		tf_contact.setBounds(150, 550, 200, 35);
		tf_contact.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_contact.setBackground(Color.black);
		tf_contact.setForeground(Color.green);
		tf_contact.setCaretColor(Color.RED);
		
		cb_bg.setBounds(150, 624, 100, 30);
		cb_bg.setBackground(Color.black);
		cb_bg.setForeground(Color.green);
		cb_bg.setFont(new Font("Cambria", Font.PLAIN, 16));
		
		button_back.setBounds(10, 760, 180, 60);
		button_back.setBackground(new Color(204, 255, 204));
		button_back.setForeground(new Color(51, 0, 25));
		button_back.setFocusable(false);
		button_back.setFont(new Font("Cambria", Font.PLAIN, 26));
		button_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Selection_Page_1();
			}	
		});
		
		button_browse.setBounds(150, 674, 110, 30);
		button_browse.setBackground(new Color(204, 255, 204));
		button_browse.setForeground(new Color (51, 0, 25));
		button_browse.setFocusable(false);
		button_browse.setFont(new Font("Cambria", Font.PLAIN, 16));
		button_browse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE,", "jpg", "png");
				filechooser.addChoosableFileFilter(filter);
				int r = filechooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					
					c = JFileChooser.APPROVE_OPTION;
					file = filechooser.getSelectedFile();
					filepath = file.getAbsolutePath();
					s = filepath;
					
				} else if (filechooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION) {
					
					System.out.println("No Data");
				}
			}
		});
		
		button_display.setBounds(380, 760, 180, 60);
		button_display.setBackground(new Color(204, 255, 204));
		button_display.setForeground(new Color(51, 0, 25));
		button_display.setFocusable(false);
		button_display.setFont(new Font("Cambria", Font.PLAIN, 26));
		button_display.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				try {
					
					if (tf_roll.getText().equals("")) {
						
						JOptionPane.showMessageDialog(frame, "Enter staff code");
					} else {
						
						int a = Integer.parseInt(tf_roll.getText());
						
						String query = "insert into details (Name, Designation, Staff_code, Branch, DOB, Address, Mobile, Emergency_Contact, Blood_Group, Image) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement pstmt = connection.prepareStatement(query);
						InputStream is = new FileInputStream(new File(s));
						pstmt.setString(1, tf_name.getText());
						pstmt.setString(2, tf_desig.getText());
						pstmt.setInt(3, a);
						pstmt.setString(4, (String) cb_branch.getSelectedItem());
						pstmt.setDate(5, model.getValue());
						pstmt.setString(6, textarea.getText());
						pstmt.setString(7, tf_mobile.getText());
						pstmt.setString(8, tf_contact.getText());
						pstmt.setString(9, (String) cb_bg.getSelectedItem());
						pstmt.setBlob(10, is);
						
						pstmt.executeUpdate();
						
						connection.close();
						
						JOptionPane.showMessageDialog(frame, "your record has been successfully added");
					}
				} catch(Exception e1) {
					
					if (file == null) {
						
						JOptionPane.showMessageDialog(frame, "Insert your image");
					} else {
					
						e1.printStackTrace();
					}
				}
			} 
		});
		
		textarea.setBounds(150, 310, 350, 160);
		textarea.setBackground(Color.black);
		textarea.setCaretColor(Color.red);
		textarea.setForeground(Color.white);
		textarea.setFont(new Font("Cambria", Font.PLAIN, 20));
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		
		p.put("text.day", "Day");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl panel = new JDatePanelImpl(model, p);
		datepicker = new JDatePickerImpl(panel, new AbstractFormatter() {
			
			@Override
			public Object stringToValue(String text) throws ParseException {
				
				return null;
			}

			@Override
			public String valueToString(Object value) throws ParseException {
				
				if (value != null) {
					
					Calendar cal = (Calendar) value;
					SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy");
					String strdate = format.format(cal.getTime());
					return strdate;
				}
				
				return "";	
			}		
		});
		datepicker.setBounds(150, 260, 150, 30);
		model.setSelected(true);
		
		frame.setVisible(true);
		frame.setSize(600, 900);
		frame.getContentPane().setBackground(new Color(255, 51, 51));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.add(button_back);
		frame.add(button_display);
		frame.add(label_head);
		frame.add(label_name);
		frame.add(tf_name);
		frame.add(label_roll);
		frame.add(tf_roll);
		frame.add(label_branch);
		frame.add(cb_branch);
		frame.add(label_dob);
		frame.add(label_mobile);
		frame.add(tf_mobile);
		frame.add(label_emergency);
		frame.add(tf_contact);
		frame.add(label_contact);
		frame.add(label_bg);
		frame.add(label_image);
		frame.add(button_browse);
		frame.add(textarea);
		frame.add(label_address);
		frame.add(cb_bg);
		frame.add(datepicker);
		frame.add(label_desig);
		frame.add(tf_desig);
	}
}