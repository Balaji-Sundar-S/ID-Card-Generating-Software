package college_ID_card_Generator;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Setting_ID_Card {
	
	JFrame frame = new JFrame ("Setting-Up ID");
	JPanel panel1 = new JPanel (new BorderLayout());
	JPanel panel2 = new JPanel (new BorderLayout());
	JPanel panel_ins[][] = new JPanel[4][4];
	JPanel panel_ins1[][] = new JPanel[4][4];
	JLabel label_ins_Name[][] = new JLabel[4][4];
	JLabel label_ins_name[][] = new JLabel[4][4];
	JLabel label_ins_logo[][] = new JLabel[4][4];
	JLabel label_ins_img[][] = new JLabel[4][4];
	JLabel label_ins_SID[][] = new JLabel[4][4];
	JLabel label_ins_Roll[][] = new JLabel[4][4];
	JLabel label_ins_roll[][] = new JLabel[4][4];
	JLabel label_ins_Branch[][] = new JLabel[4][4];
	JLabel label_ins_branch[][] = new JLabel[4][4];
	JLabel label_ins_Dob[][] = new JLabel[4][4];
	JLabel label_ins_dob[][] = new JLabel[4][4];
	JLabel label_ins_Bg[][] = new JLabel[4][4];
	JLabel label_ins_bg[][] = new JLabel[4][4];
	JLabel label_ins_Addr[][] = new JLabel[4][4];
	JTextArea ta_ins_addr[][] = new JTextArea[4][4];
	JLabel label_ins_Mobile[][] = new JLabel[4][4];
	JLabel label_ins_mobile[][] = new JLabel[4][4];
	JLabel label_ins_Ec[][] = new JLabel[4][4];
	JLabel label_ins_C[][] = new JLabel[4][4];
	JLabel label_ins_ec[][] = new JLabel[4][4];
	Border border = BorderFactory.createLineBorder(Color.black, 2);
	JMenuBar mb;
	JMenu file, check;
	JMenuItem mi, mi2;
	
	int row, col, roll;
	String name, dob, bg, addr, mob, ec;
	
	Connection connection = null;
	java.sql.Statement stmt = null;
	java.sql.Statement stmt1 = null;
	java.sql.Statement stmt_check = null;
	ResultSet rs;
	
	public void aas() {
		
		connection = Sql_database_connector.Connector();
		ImageIcon image = new ImageIcon("ritlogo_new.png");
		
		int x = 30, y = 20;
			
		try {
		
			stmt = connection.createStatement();
			rs=stmt.executeQuery("select Name, Roll, Branch, image from details");
				
			for (row = 0; row<4; row++) {
						
				for (col = 0; col<4; col++) {
						
					while (rs.next()) {
							
						String name = rs.getString("Name");
						String roll = rs.getString("Roll");
						String branch = rs.getString("Branch");
						
						byte[] img = rs.getBytes("Image");
						ImageIcon photo = new ImageIcon(img);
						Image im = photo.getImage();
						Image imge = im.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
						ImageIcon newimg = new ImageIcon(imge);
							
						panel_ins[row][col] = new JPanel();
						panel_ins[row][col].setBounds(x, y, 200, 300);
						panel_ins[row][col].setBorder(border);
						panel_ins[row][col].setBackground(new Color (255, 255, 255));
						
						label_ins_logo[row][col] = new JLabel();
						label_ins_logo[row][col].setBounds(15, 15, 170, 60);
						label_ins_logo[row][col].setIcon(image);
							
						label_ins_SID[row][col] = new JLabel("STUDENT IDENTITY CARD");
						label_ins_SID[row][col].setBounds(20, 45, 155, 90);
							
						label_ins_img[row][col] = new JLabel();
						label_ins_img[row][col].setBounds(55, 105, 90, 90);
						label_ins_img[row][col].setIcon(newimg);
								
						label_ins_Name[row][col] = new JLabel();
						label_ins_Name[row][col].setBounds(20, 205, 60, 20);
						label_ins_Name[row][col].setText("Name     :");
								
						label_ins_name[row][col] = new JLabel();
						label_ins_name[row][col].setBounds(90, 205, 100, 20);
						label_ins_name[row][col].setText(name);
							
						label_ins_Roll[row][col] = new JLabel();
						label_ins_Roll[row][col].setBounds(20, 230, 60, 20);
						label_ins_Roll[row][col].setText("Roll No.  :");
							
						label_ins_roll[row][col] = new JLabel();
						label_ins_roll[row][col].setBounds(90, 230, 100, 20);
						label_ins_roll[row][col].setText(roll);
							
						label_ins_Branch[row][col] = new JLabel();
						label_ins_Branch[row][col].setBounds(20, 255, 60, 20);
						label_ins_Branch[row][col].setText("Branch  :");
							
						label_ins_branch[row][col] = new JLabel();
						label_ins_branch[row][col].setBounds(90, 255, 40, 20);
						label_ins_branch[row][col].setText(branch);
								
						panel_ins[row][col].setLayout(null);
						panel_ins[row][col].add(label_ins_SID[row][col]);
						panel_ins[row][col].add(label_ins_img[row][col]);
						panel_ins[row][col].add(label_ins_Name[row][col]);
						panel_ins[row][col].add(label_ins_name[row][col]);
						panel_ins[row][col].add(label_ins_Roll[row][col]);
						panel_ins[row][col].add(label_ins_roll[row][col]);							panel_ins[row][col].add(label_ins_Branch[row][col]);
						panel_ins[row][col].add(label_ins_branch[row][col]);
						panel_ins[row][col].add(label_ins_logo[row][col]);
								
						panel1.add(panel_ins[row][col]);
								
						x+=230;
						break;
					}
				}
				x=30;
				y+=320;
			}
				
			int x1 = 30, y1 = 20;
				
			stmt1 = connection.createStatement();
			ResultSet rs1=stmt1.executeQuery("select DOB, Blood_group, address, mobile, emergency_contact from details");
			
			for (row = 0; row<4; row++) {
					
				for (col = 0; col<4; col++) {
						
					while (rs1.next()) {
							
						String dob = rs1.getString("DOB");
						String bg = rs1.getString("Blood_Group");
				    	String addr = rs1.getString("Address");
						String mob = rs1.getString("Mobile");
						String ec = rs1.getString("Emergency_Contact");
							
						panel_ins1[row][col] = new JPanel();
						panel_ins1[row][col].setBounds(x1, y1, 200, 300);
						panel_ins1[row][col].setBorder(border);
						panel_ins1[row][col].setBackground(new Color (255, 255, 255));
														
						label_ins_Dob[row][col] = new JLabel();
						label_ins_Dob[row][col].setBounds(20, 35, 85, 20);
						label_ins_Dob[row][col].setText("DOB                :");
								
						label_ins_dob[row][col] = new JLabel();
						label_ins_dob[row][col].setBounds(110, 35, 100, 20);
						label_ins_dob[row][col].setText(dob);
							
						label_ins_Bg[row][col] = new JLabel();
						label_ins_Bg[row][col].setBounds(20, 65, 80, 20);
						label_ins_Bg[row][col].setText("Blood Group :");
							
						label_ins_bg[row][col] = new JLabel();
						label_ins_bg[row][col].setBounds(110, 65, 100, 20);
						label_ins_bg[row][col].setText(bg);
							
						label_ins_Addr[row][col] = new JLabel();
						label_ins_Addr[row][col].setBounds(20, 95, 80, 20);
						label_ins_Addr[row][col].setText("Address :");
							
						ta_ins_addr[row][col] = new JTextArea();
						ta_ins_addr[row][col].setBounds(20, 115, 150, 50);
						ta_ins_addr[row][col].setLineWrap(true);
						ta_ins_addr[row][col].setWrapStyleWord(true);
						ta_ins_addr[row][col].setText(addr);
							
						label_ins_Mobile[row][col] = new JLabel();
						label_ins_Mobile[row][col].setBounds(20, 170, 80, 20);
						label_ins_Mobile[row][col].setText("Mobile No. :");
							
						label_ins_mobile[row][col] = new JLabel();
						label_ins_mobile[row][col].setBounds(110, 170, 100, 20);
						label_ins_mobile[row][col].setText(mob);
							
						label_ins_Ec[row][col] = new JLabel();
						label_ins_Ec[row][col].setBounds(20, 200, 80, 20);
						label_ins_Ec[row][col].setText("Emergency  :");
						
						label_ins_C[row][col] = new JLabel();
						label_ins_C[row][col].setBounds(20, 215, 80, 20);
						label_ins_C[row][col].setText("Contact");
							
						label_ins_ec[row][col] = new JLabel();
						label_ins_ec[row][col].setBounds(110, 200, 100, 20);
						label_ins_ec[row][col].setText(ec);
														
						panel_ins1[row][col].setLayout(null);
						panel_ins1[row][col].add(label_ins_Dob[row][col]);
						panel_ins1[row][col].add(label_ins_dob[row][col]);
						panel_ins1[row][col].add(label_ins_Bg[row][col]);							panel_ins1[row][col].add(label_ins_bg[row][col]);
						panel_ins1[row][col].add(label_ins_Addr[row][col]);
						panel_ins1[row][col].add(ta_ins_addr[row][col]);
						panel_ins1[row][col].add(label_ins_Mobile[row][col]);
						panel_ins1[row][col].add(label_ins_mobile[row][col]);
						panel_ins1[row][col].add(label_ins_Ec[row][col]);
						panel_ins1[row][col].add(label_ins_C[row][col]);
						panel_ins1[row][col].add(label_ins_ec[row][col]);
									
						panel2.add(panel_ins1[row][col]);
							
						x1+=230;
						break;
					}
				}
				x1=30;
				y1+=320;
			}
			
		} catch (Exception e) {
				
			e.printStackTrace();
		}
			
		panel1.setBounds(40, 30, 998, 1420);
		panel1.setBorder(border);
		panel1.setBackground(new Color (0, 245, 255));
		panel1.setLayout(null);
			
		panel2.setBounds(40, 1460, 998, 1420);
		panel2.setBorder(border);
		panel2.setBackground(new Color (0, 245, 255));
		panel2.setLayout(null);
			
		mb = new JMenuBar();
		mb.setBounds(5, 5, 45, 25);
		mb.setBackground(Color.cyan);
		file = new JMenu("File");
		mi = new JMenuItem("Print");
		mb.add(file);
		file.add(mi);
		mi.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
					
				try {
						
					savess(panel1, "FrontSide.png");
					savess(panel2, "BackSide.png");
					JOptionPane.showMessageDialog(null, "Image saved successfully");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		frame.setSize(1100, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(mb);	
	}
	
	public static BufferedImage getss(Component comp) {
		
		BufferedImage image = new BufferedImage (comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_RGB);
		comp.paint(image.getGraphics());
		
		return image;
	}
	
	public static void savess(Component comp, String filename) throws Exception{
		
		BufferedImage img = getss(comp);
		ImageIO.write(img, "png", new File (filename));
	}
}