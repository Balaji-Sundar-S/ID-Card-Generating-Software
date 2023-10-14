package id_card_generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Selection_Page_1 implements ActionListener{
	
	JFrame frame = new JFrame("Selection");
	JButton button1 = new JButton("BACK");
	JButton button2 = new JButton("SUBMIT");
	@SuppressWarnings("rawtypes")
	JComboBox combobox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Selection_Page_1(){
		
		String[] options = {"Select", "Student", "Staff", "Non-Teaching Staff"};
		
		combobox = new JComboBox(options);
		combobox.addActionListener(this);
		combobox.setBackground(new Color (224, 224, 224));
		combobox.setBounds(84, 75, 220, 50);
		combobox.setFont(new Font("Cambria", Font.PLAIN, 22));
		combobox.setForeground(new Color(51, 0, 25));
		combobox.setEditable(false);
		
		button2.setBounds(100, 200, 180, 60);
		button2.setBackground(new Color(204, 255, 204));
		button2.setForeground(new Color(51, 0, 25));
		button2.setFocusable(false);
		button2.setFont(new Font("Cambria", Font.PLAIN, 26));
		button2.addActionListener(this);
		
		button1.setBounds(100, 300, 180, 60);
		button1.setBackground(new Color(204, 255, 204));
		button1.setForeground(new Color(51, 0, 25));
		button1.setFocusable(false);
		button1.setFont(new Font("Cambria", Font.PLAIN, 26));
		button1.addActionListener(this);
		
		frame.setSize(420, 420);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 51, 51));
		frame.add(combobox);
		frame.add(button1);
		frame.add(button2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String item = (String) combobox.getSelectedItem();
		
		if (e.getSource() == button1) {
			
			frame.dispose();
			new Home_Page();
		} else if (item == "Select" && e.getSource() == button2) {
			
			JOptionPane.showMessageDialog(frame, "Choose any Option");
		} else if (e.getSource() == button2 && item == "Student") {
			
			frame.dispose();
			new Student();
		} else if (e.getSource() == button2 && item == "Staff") {
			
			frame.dispose();
			new Staff();
		}
	}
}