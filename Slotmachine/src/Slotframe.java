import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class Slotframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slotframe frame = new Slotframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Slotframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		wheelpanel panel = new wheelpanel();
		panel.setBounds(10, 11, 100, 100);
		contentPane.add(panel);
		
		wheelpanel panel_1 = new wheelpanel();
		panel_1.setBounds(230, 11, 100, 100);
		contentPane.add(panel_1);
		
		wheelpanel panel_2 = new wheelpanel();
		panel_2.setBounds(120, 11, 100, 100);
		contentPane.add(panel_2);
		
		JButton btnRoll = new JButton("ROLL");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.push();
				panel_1.push();
				panel_2.push();
			}
		});
		btnRoll.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnRoll.setBounds(10, 260, 320, 100);
		contentPane.add(btnRoll);
		
		JLabel lblNewLabel = new JLabel("YOU WON");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 122, 320, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblScore = new JLabel("Score: 0");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblScore.setBounds(89, 183, 162, 50);
		contentPane.add(lblScore);
	}
}
