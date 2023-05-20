package rugby;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.GameEnviroment;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;

public class TrainScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JTextField random;
	private JTextField textField;
	private JLabel lblNewLabel;
	private Item item;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JButton btnNewButton_1;
	private JList list;

	
	public TrainScreen(GameEnviroment enviroment){
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeTrainScreen(this);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(231, 412, 90, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		lblNewLabel = new JLabel("training", SwingConstants.CENTER);
		lblNewLabel.setBounds(231, 14, 90, 46);
		frame.getContentPane().add(lblNewLabel);
		
	
		DefaultListModel<Athlete> reserveModelList = new DefaultListModel<Athlete>();
		reserveModelList.addAll(enviroment.club.players);
		reserveModelList.addAll(enviroment.getTeam());
		
		JList<Athlete> reserveList = new JList<Athlete>();
		reserveList.setBounds(164, 132, 233, 204);
		frame.getContentPane().add(reserveList);
		reserveList.setModel(reserveModelList);
		
		btnNewButton_1 = new JButton("Train a Player in your team");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete trainedUser = reserveList.getSelectedValue();			
				if (trainedUser != null) {
					trainedUser.trainAll();
					JOptionPane.showMessageDialog(frame, trainedUser.name + " trained");
					goHome();
				}else {
					JOptionPane.showMessageDialog(frame,"please select a item");
				}
			}
		});
		
		btnNewButton_1.setBounds(164, 358, 233, 23);
		frame.getContentPane().add(btnNewButton_1);
		


		
	}
}