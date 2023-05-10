package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.Font;

public class SetupScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		int button_count = 1;
		for(int i = 0; i < button_count; ++i){
            button[i] = new Button( "" + i );
            button[i].setSize(50, 50);
        }
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("enter team name:");
		lblNewLabel.setBounds(61, 87, 100, 22);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(190, 88, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("choose diff");
		lblNewLabel_1.setBounds(372, 91, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSlider slider = new JSlider();
		slider.setMinimum(1);
		slider.setMaximum(3);
		slider.setBounds(528, 91, 200, 26);
		frame.getContentPane().add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("easy");
		lblNewLabel_2.setBounds(528, 80, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("med");
		lblNewLabel_3.setBounds(612, 80, 39, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("hard");
		lblNewLabel_4.setBounds(699, 80, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSlider slider_1 = new JSlider();
		slider_1.setPaintLabels(true);
		slider_1.setPaintTicks(true);
		slider_1.setMajorTickSpacing(5);
		slider_1.setMinimum(5);
		slider_1.setMaximum(15);
		slider_1.setBounds(391, 146, 200, 52);
		frame.getContentPane().add(slider_1);
		
		JLabel lblNewLabel_6 = new JLabel("how many weeks");
		lblNewLabel_6.setBounds(182, 166, 187, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("team setup");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(347, 25, 100, 35);
		frame.getContentPane().add(lblNewLabel_5);
		
	}
}
