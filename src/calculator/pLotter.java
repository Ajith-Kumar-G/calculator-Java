package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class pLotter extends JFrame {
	int root[][]={{57,24},{633,24},{633,283},{57,283}};
	int midY=153,midX=345;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pLotter frame = new pLotter();
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
	public pLotter() {
		setTitle("GraphPlotter:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 459);
	}
	public void paint(Graphics g)
	{
		Graphics scale=g.create(0,0,500,200);
		scale.setColor(Color.BLACK);
		scale.drawLine(0, 0, 100, 100);
		scale.drawLine(midX, 24, midX,283);
	}
}
