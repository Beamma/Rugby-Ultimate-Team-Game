package rugby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class InventoryScreen {
	
	private JFrame frame;
	private GameEnviroment enviroment;
	/**
	 * Launch the application.
	 * @return 
	 */
	
	public InventoryScreen(GameEnviroment enviroment) {
		this.enviroment = enviroment;
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
	
	public void goItem(Item item) {
		enviroment.closeInventoryScreen(this, item);
	}
	
	public void refreshWindow() {
		enviroment.refreshInventoryScreen(this);
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		JButton btnNewButton = new JButton("View team:");
		btnNewButton.setBounds(215, 403, 132, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goTeam();
			}
		});
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(btnNewButton);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(enviroment.club.players);
		athleteListModel.addAll(enviroment.getTeam());
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setBounds(10, 11, 77, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Athletes", SwingConstants.CENTER);
		lblNewLabel.setBounds(68, 67, 149, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JList<Athlete> athleteStats = new JList<Athlete>();
		athleteStats.setBounds(68, 80, 149, 292);
		frame.getContentPane().add(athleteStats);
		athleteStats.setModel(athleteListModel);
		
		
		JList<Athlete> athletes = new JList<Athlete>(athleteListModel);
		frame.getContentPane().add(athleteStats);
		
		
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		itemListModel.addAll(enviroment.club.items);
		
		JList<Item> list = new JList<Item>(itemListModel);
		list.setBounds(346, 80, 149, 293);
		frame.getContentPane().add(list);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Owened items", SwingConstants.CENTER);
		lblNewLabel_1.setBounds(346, 67, 149, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Use item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item useItem = list.getSelectedValue();
				if (useItem != null) {
					goItem(useItem);
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a item from list");
				}
			}
		});
		btnNewButton_2.setBounds(406, 403, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sell athlete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = athleteStats.getSelectedValue();
				if (athlete1 != null) {
					enviroment.addMoney(athlete1.sellPrice);
					if (enviroment.club.players.contains(athlete1)) {
						enviroment.club.removePlayer(athlete1);
					}else {
						enviroment.club.team.removePlayer(athlete1);
					}
					JOptionPane.showMessageDialog(frame, athlete1.name + " sold for " + String.valueOf(athlete1.sellPrice));
					refreshWindow();
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from list");
				}
			}
		});
		btnNewButton_3.setBounds(68, 403, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		
		athletes.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		athletes.setBackground(new Color(153, 50, 204));
	}
}
