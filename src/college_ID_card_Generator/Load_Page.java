package college_ID_card_Generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Load_Page {
	
	JFrame frame = new JFrame ("Loading Page");
	JButton button = new JButton("LOAD");
	
	public void bbb() {
		
		button.setBounds(100, 130, 160, 60);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setFocusable(false);
		button.setFont(new Font ("cambria", Font.BOLD, 28));
		button.setBackground(Color.CYAN);
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Setting_ID_Card o2 = new Setting_ID_Card();
				frame.dispose();
				o2.aas();
			}
		});
		
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color (188, 254, 200));
		frame.setLayout(null);
		frame.add(button);
	}
}
