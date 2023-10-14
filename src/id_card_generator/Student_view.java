package id_card_generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Student_view implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel label1 = new JLabel("STUDENT DETAILS");
	JLabel label2 = new JLabel("Roll No :");
	JButton button1 = new JButton("BACK");
	JButton button2 = new JButton("DISPLAY");
	JTextField textfield1 = new JTextField();
	
	Student_view(){
		
		textfield1.setBounds(100, 100, 220, 30);
		textfield1.setFont(new Font("Cambria", Font.PLAIN, 20));
		textfield1.setBackground(Color.black);
		textfield1.setForeground(Color.green);
		textfield1.setCaretColor(Color.red);
		
		label1.setBounds(105, 5, 200, 40);
		label1.setFont(new Font("Cambria", Font.BOLD, 20));
		label1.setBackground(new Color(0, 0, 26));
		
		label2.setBounds(10, 100, 100, 30);
		label2.setFont(new Font("Cambria", Font.BOLD, 20));
		label2.setBackground(new Color(0, 0, 26));
		
		button1.setBounds(100, 300, 180, 60);
		button1.setBackground(new Color(204, 255, 204));
		button1.setForeground(new Color(51, 0, 25));
		button1.setFocusable(false);
		button1.setFont(new Font("Cambria", Font.PLAIN, 26));
		button1.addActionListener(this);
		
		button2.setBounds(100, 200, 180, 60);
		button2.setBackground(new Color(204, 255, 204));
		button2.setForeground(new Color(51, 0, 25));
		button2.setFocusable(false);
		button2.setFont(new Font("Cambria", Font.PLAIN, 26));
		button2.addActionListener(this);
		
		frame.setSize(420, 420);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 51, 51));
		frame.setLayout(null);
		frame.add(button1);
		frame.add(button2);
		frame.add(label1);
		frame.add(label2);
		frame.add(textfield1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button1) {
			
			frame.dispose();
			new Selection_Page_2();
		}
	}
}
