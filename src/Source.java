import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Source {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		MyPanel1 myPanel = new MyPanel1();
		myPanel.setBounds(10, 11, 375, 177);
		frame.getContentPane().add(myPanel);
		*/
		
		House house = new House();
		house.setBounds(10, 11, 375, 177);
		house.setVisible(false);
		frame.getContentPane().add(house);
		
		
		Pattern pattern = new Pattern();
		pattern.setBounds(10, 11, 375, 177);
		frame.getContentPane().add(pattern);
		
		
		JButton btnNewButton_1 = new JButton("House");
		btnNewButton_1.setBounds(215, 199, 170, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Pattern");
		btnNewButton_1_1.setBounds(10, 199, 170, 23);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{		
				house.setVisible(true);
				pattern.setVisible(true);
			}				
		});
		
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{		
				pattern.setVisible(true);
				house.setVisible(false);
			}				
		});
		
		frame.getContentPane().add(btnNewButton_1_1);
		frame.setVisible(true);
	}
}
