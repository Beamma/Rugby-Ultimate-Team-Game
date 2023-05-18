package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;

public class MarketPlaceScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;

	/**
	 * Launch the application.
	 * @return 
	 */
	
	public MarketPlaceScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		enviroment.closeMarketPlaceScreen(this);
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("got home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		Athlete ed = GameEnviroment.generatePlayer();
		btnNewButton_1.setBounds(231, 350, 139, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("market");
		lblNewLabel.setBounds(203, 62, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		DefaultListModel<Athlete> athleteMarketModel = new DefaultListModel<Athlete>();
		athleteMarketModel.addAll(enviroment.market.playersForSale);
		
		JList<Athlete> listAthleteMarket = new JList<Athlete>();
		listAthleteMarket.setBounds(48, 105, 126, 252);
		frame.getContentPane().add(listAthleteMarket);
		listAthleteMarket.setModel(athleteMarketModel);
		
		JButton btnNewButton = new JButton("buy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athleteBuy = listAthleteMarket.getSelectedValue();
				enviroment.club.addPlayer(athleteBuy);
			}
		});
		btnNewButton.setBounds(70, 370, 89, 23);
		frame.getContentPane().add(btnNewButton);

	}
}
