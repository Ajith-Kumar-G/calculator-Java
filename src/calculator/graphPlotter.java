package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class graphPlotter extends JFrame {
	private JTextField textField;
	private Canvas canvas;
	private 	String equation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphPlotter frame = new graphPlotter();
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
	public graphPlotter() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 580);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(23, 13, 836, 424);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(25, 25));
		canvas.setSize(new Dimension(25, 25));
		canvas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		canvas.setBounds(836, 420, -832, -415);
		panel.add(canvas);
		
		textField = new JTextField();
		textField.setBorder(UIManager.getBorder("TextField.border"));
		textField.setBounds(93, 450, 202, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Equation:");
		lblNewLabel.setToolTipText("Write the equation Here!");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(23, 459, 70, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Solve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation=textField.getText();
			
			}
		});
		btnNewButton.setFont(new Font("Bell MT", Font.PLAIN, 15));
		btnNewButton.setMargin(new Insets(2, 4, 2, 4));
		btnNewButton.setBounds(198, 495, 97, 25);
		getContentPane().add(btnNewButton);
	}
	
	
}
