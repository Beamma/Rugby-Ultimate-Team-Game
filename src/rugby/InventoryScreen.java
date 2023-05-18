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
import javax.swing.JScrollBar;

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
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 600, 500);
		
		JButton btnNewButton = new JButton("go to Team");
		btnNewButton.setBounds(240, 403, 87, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goTeam();
			}
		});
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(btnNewButton);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(enviroment.club.players);
		
		JButton btnNewButton_1 = new JButton("got home");
		btnNewButton_1.setBounds(87, 403, 77, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("reserve athletes");
		lblNewLabel.setBounds(99, 44, 120, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JList<Athlete> athleteStats = new JList<Athlete>();
		athleteStats.setBounds(87, 69, 120, 292);
		frame.getContentPane().add(athleteStats);
		athleteStats.setModel(athleteListModel);
		
		
		JList<Athlete> athletes = new JList<Athlete>(athleteListModel);
		frame.getContentPane().add(athleteStats);
		
		
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		itemListModel.addAll(enviroment.club.items);
		
		JList<Item> list = new JList<Item>(itemListModel);
		list.setBounds(372, 69, 120, 293);
		frame.getContentPane().add(list);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("owened itemns");
		lblNewLabel_1.setBounds(410, 44, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("use item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item useItem = list.getSelectedValue();
				goItem(useItem);
			}
		});
		btnNewButton_2.setBounds(384, 403, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		athletes.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		athletes.setBackground(new Color(153, 50, 204));
	}
}
