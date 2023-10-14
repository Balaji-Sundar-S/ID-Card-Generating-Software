package id_card_generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Home_Page implements ActionListener{
	
	JFrame frame = new JFrame("Home");
	JButton button1 = new JButton("CREATE");
	JButton button2 = new JButton("VIEW");
	
	Home_Page(){
		
		button1.setBounds(89, 75, 200, 60);
		button1.setFont(new Font("Cambria", Font.PLAIN, 28));
		button1.setBackground(new Color(204, 255, 204));
		button1.setForeground(new Color(51, 0, 25));
		button1.setBorder(BorderFactory.createEtchedBorder());
		button1.setFocusable(false);
		button1.addActionListener(this);
		
		button2.setBounds(89, 180, 200, 60);
		button2.setFont(new Font("Cambria", Font.PLAIN, 28));
		button2.setBackground(new Color(204, 255, 204));
		button2.setForeground(new Color(51, 0, 25));
		button2.setBorder(BorderFactory.createEtchedBorder());
		button2.setFocusable(false);
		button2.addActionListener(this);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 51, 51));
		frame.setLayout(null);
		frame.add(button1);
		frame.add(button2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button1) {
			
			frame.dispose();
			new Selection_Page_1();
		}
		else if (e.getSource() == button2){
			
			frame.dispose();
			new Selection_Page_2();
		}
	}
}