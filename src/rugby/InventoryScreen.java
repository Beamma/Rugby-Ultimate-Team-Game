package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

public class InventoryScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;
	private ArrayList<Athlete> ownedAthletes = new ArrayList<>();

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public InventoryScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
		ownedAthletes.add(GameEnviroment.generatePlayer());
		ownedAthletes.add(GameEnviroment.generatePlayer());
		ownedAthletes.add(GameEnviroment.generatePlayer());
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeInventoryScreen(this, 1);
	}
	
	public void goTeam() {
		enviroment.closeInventoryScreen(this, 2);
	}
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		JButton btnNewButton_1 = new JButton("got home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(ownedAthletes);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("go to Team");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goTeam();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		
		JList<Athlete> athletes = new JList<Athlete>(athleteListModel);
		panel.add(athletes);
		
		athletes.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		athletes.setBackground(new Color(153, 50, 204));
	}
}
