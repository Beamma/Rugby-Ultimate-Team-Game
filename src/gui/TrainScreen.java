package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.Athlete;
import rugby.GameEnviroment;

import javax.swing.SwingConstants;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TrainScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JLabel trainingLabel;
	private JButton trainButton;


	
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
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(231, 412, 90, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		trainingLabel = new JLabel("training", SwingConstants.CENTER);
		trainingLabel.setBounds(231, 14, 90, 46);
		frame.getContentPane().add(trainingLabel);
		
	
		DefaultListModel<Athlete> reserveModelList = new DefaultListModel<Athlete>();
		reserveModelList.addAll(enviroment.club.players);
		reserveModelList.addAll(enviroment.getTeam());
		
		JList<Athlete> reserveList = new JList<Athlete>();
		reserveList.setBounds(164, 132, 233, 204);
		frame.getContentPane().add(reserveList);
		reserveList.setModel(reserveModelList);
		
		trainButton = new JButton("Train a Player in your team");
		trainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete trainedUser = reserveList.getSelectedValue();			
				if (trainedUser != null) {
					trainedUser.trainAll();
					trainedUser.updateRating();
					JOptionPane.showMessageDialog(frame, trainedUser.getName() + " trained");
					goHome();
				}else {
					JOptionPane.showMessageDialog(frame,"please select a plyaer");
				}
			}
		});
		
		trainButton.setBounds(164, 358, 233, 23);
		frame.getContentPane().add(trainButton);
		


		
	}
}