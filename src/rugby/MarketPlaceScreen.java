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
		
		JButton btnNewButton = new JButton("buy athlete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athleteBuy = listAthleteMarket.getSelectedValue();
				if (athleteBuy.buyPrice > enviroment.money) {
					JOptionPane.showMessageDialog(frame, "You Do Not Have Enough Money To Preform This Action");
				}else if (enviroment.club.team.addPlayer(athleteBuy) == false){
					System.out.println("buy");
					enviroment.club.addPlayer(athleteBuy);
					enviroment.minusMoney(athleteBuy.buyPrice);
					JOptionPane.showMessageDialog(frame, "Purchase Succesfull");
				}
			}
		});
		
		btnNewButton.setBounds(70, 370, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		DefaultListModel<Item> itemMarketModel = new DefaultListModel<Item>();
		itemMarketModel.addAll(enviroment.market.itemsForSale);
		
		JList<Item> list = new JList<Item>();
		list.setBounds(395, 105, 126, 252);
		frame.getContentPane().add(list);
		list.setModel(itemMarketModel);
		
		JButton btnNewButton_2 = new JButton("buy item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item itemBuy = list.getSelectedValue();
				enviroment.club.addItem(itemBuy);
			}
		});
		btnNewButton_2.setBounds(419, 370, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

	}
}
