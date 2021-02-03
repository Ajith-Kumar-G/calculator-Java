package calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class graphPlot extends JFrame {

	private JFrame frmGraphplotter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphPlot window = new graphPlot();
					window.frmGraphplotter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public graphPlot() {
		initialize();
	}

	private void initialize() {
		frmGraphplotter = new JFrame();
		frmGraphplotter.setTitle("GraphPlotter");
		frmGraphplotter.setBounds(100, 100, 740, 460);
		frmGraphplotter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGraphplotter.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(57, 24, 576, 259);
		frmGraphplotter.getContentPane().add(panel);
		panel.setLayout(null);
		
		int root[][]={{57,24},{633,24},{633,283},{57,283}};
		int midY=153,midX=345;
		
		JLabel lblNewLabel = new JLabel("Equation: ");
		lblNewLabel.setBounds(60, 315, 65, 22);
		frmGraphplotter.getContentPane().add(lblNewLabel);
		repaint();
	}
		public void paint(Graphics g)
		{
			Graphics scale=g.create(57,24,576,259);
			scale.setColor(Color.RED);
			scale.drawLine(57, 153, 633, 153);
		}
}
