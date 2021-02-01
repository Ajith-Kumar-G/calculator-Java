package calculator;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.text.AttributedString;
import javax.swing.JLayeredPane;

public class calculator implements ActionListener {

	private JFrame frmComcalculator;
	private JTextField textField;
	public double ans=0.0;
	String inText[]=new String[50];
	int inTop=-1;
	JButton btn[]=new JButton[10];
	boolean toggledOnce=true,pointTriggred=false,numberEnded=true,operatorEnabled=true,shiftEnabled=false,enabled10E=false,powerEnabled=false,status=false;
	private JTextField textField_1;
	private JButton operationBtn_8_1;
	private JPanel bottomPanel;
	private JPanel panel_2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frmComcalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calculator() {
		initialize();
	}

	private void initialize() {
		frmComcalculator = new JFrame();
		frmComcalculator.setResizable(false);
		frmComcalculator.getContentPane().setBackground(new Color(145, 76, 15));
		frmComcalculator.setTitle("ComCalculator");
		frmComcalculator.setBounds(100, 100, 300, 450);
		frmComcalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComcalculator.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(10, 29, 266, 63);
		frmComcalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setMargin(new Insets(2, 4, 2, 2));
		textField.setBorder(UIManager.getBorder("ToolTip.border"));
		textField.setEditable(false);
		textField.setFont(new Font("Digital-7", Font.PLAIN, 27));
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBackground(SystemColor.text);
		textField.setDisabledTextColor(SystemColor.text);
		textField.setBounds(10, 12, 202, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JToggleButton statusButton = new JToggleButton("<html>OFF</html>");
		statusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottomPanel.setEnabled(status);
				textField.setEnabled(status);
				textField_1.setEnabled(status);
				status=!status;
				if(status)
				{
					statusButton.setText("<html>ON</html>");
					frmComcalculator.getContentPane().remove(bottomPanel);
					frmComcalculator.getContentPane().add(panel_2);
				}
				else
				{
					statusButton.setText("<html>OFF</html>");
					frmComcalculator.getContentPane().add(bottomPanel);

				}
				operationBtn_8_1.doClick();
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setMargin(new Insets(0, 0, 0, 0));
		textField_1.setBorder(null);
		textField_1.setBounds(12, 15, 196, 10);
		panel.add(textField_1);
		textField_1.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_1.setBackground(SystemColor.text);
		textField_1.setFont(new Font("Digital-7", Font.PLAIN, 11));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		statusButton.setBackground(new Color(0, 153, 0));
		statusButton.setMargin(new Insets(2, 5, 2, 5));
		statusButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 8));
		statusButton.setBounds(222, 35, 36, 20);
		panel.add(statusButton);
		
		operationBtn_8_1 = new JButton("AC");
		operationBtn_8_1.setBackground(new Color(0, 153, 0));
		operationBtn_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=true;
				operatorEnabled=true;
				powerEnabled=false;
				enabled10E=false;
				textField.setText("");
				inText=new String[50];
				inText[0]="\0";
				inTop=-1;
				numberEnded=true;
				ans=0.0;
				
			}
		});
		operationBtn_8_1.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_8_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		operationBtn_8_1.setBounds(222, 10, 36, 22);
		panel.add(operationBtn_8_1);
		
		bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(37, 230, 204));
		bottomPanel.setBounds(20, 98, 241, 300);
		frmComcalculator.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JPanel numberPanel = new JPanel();
		numberPanel.setBackground(new Color(255, 204, 102));
		numberPanel.setBounds(10, 96, 143, 194);
		bottomPanel.add(numberPanel);
		numberPanel.setLayout(new GridLayout(4, 3, 1, 1));
		
		for(int i=0;i<10;i++)
		{
			btn[i] = new JButton(""+i);
			btn[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
			btn[i].addActionListener((ActionListener) this);
			btn[i].setMargin(new Insets(2, 4, 2, 4));
			btn[i].setBackground(new Color(137, 214, 28));
		}
		numberPanel.add(btn[7]);
		numberPanel.add(btn[8]);
		numberPanel.add(btn[9]);
		numberPanel.add(btn[4]);
		numberPanel.add(btn[5]);
		numberPanel.add(btn[6]);
		numberPanel.add(btn[1]);
		numberPanel.add(btn[2]);
		numberPanel.add(btn[3]);
		numberPanel.add(btn[0]);
		
		
		JButton btnNewButton_12 = new JButton("x10^");
		btnNewButton_12.setBackground(new Color(105, 209, 67));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"x10");
				for(int sI=inTop;sI<textField.getText().length()+5;sI++)
					textField_1.setText(textField_1.getText()+" ");
			
				inText[++inTop]="E";
				powerEnabled=true;
				enabled10E=true;
				numberEnded=true;
			}
		});
		btnNewButton_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnNewButton_12.setMargin(new Insets(2, 4, 2, 4));
		numberPanel.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton(".");
		btnNewButton_11.setBackground(new Color(105, 209, 67));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+".");
				textField_1.setText(textField_1.getText()+" ");
				pointTriggred=true;
				inText[inTop]=inText[inTop]+".";
			}
		});
		btnNewButton_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnNewButton_11.setMargin(new Insets(2, 4, 2, 4));
		numberPanel.add(btnNewButton_11);
		
		JPanel normalOperation = new JPanel();
		normalOperation.setBorder(new CompoundBorder());
		normalOperation.setBackground(new Color(0, 153, 153));
		normalOperation.setBounds(163, 97, 68, 162);
		bottomPanel.add(normalOperation);
		normalOperation.setLayout(new GridLayout(5, 2, 0, 0));
		
		JButton operationBtn_0 = new JButton("x");
		operationBtn_0.setBackground(new Color(204, 204, 255));
		operationBtn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=false;
				textField.setText(textField.getText()+"x");
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]="x";
				numberEnded=true;
				 enabled10E=false;
				 powerEnabled=false;
			}
		});
		normalOperation.add(operationBtn_0);
		operationBtn_0.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_0.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		JButton operationBtn_1 = new JButton("/");
		operationBtn_1.setBackground(new Color(204, 204, 255));
		operationBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=false;
				textField.setText(textField.getText()+"/");
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]="/";
				numberEnded=true;
				 enabled10E=false;
				 powerEnabled=false;
			}
		});
		operationBtn_1.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_1);
		
		JButton operationBtn_2 = new JButton("+");
		operationBtn_2.setBackground(new Color(204, 204, 255));
		operationBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inText[inTop].equals("("))
					operatorEnabled=true;
				toggledOnce=false;
				textField.setText(textField.getText()+"+");
				for(int sI=inTop;sI<textField.getText().length();sI++)
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]="+"; 
				numberEnded=true;
				powerEnabled=false;
				 enabled10E=false;
				
					//System.out.printf("%d: %s",inTop,inText[inTop]);
			}
		});
		operationBtn_2.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_2);
		
		JButton operationBtn_3 = new JButton("-");
		operationBtn_3.setBackground(new Color(204, 204, 255));
		operationBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inTop!=-1 && (inText[inTop].equals("(") || enabled10E ))
					operatorEnabled=true;
				toggledOnce=false;
				if(enabled10E )
				{
					textField.setText(textField.getText()+"");
					textField_1.setText(textField_1.getText()+"-");
				}
				else
				{
					textField.setText(textField.getText()+"-");
					textField_1.setText(textField_1.getText()+" ");
				}
				inText[++inTop]="-";
				numberEnded=true;
				powerEnabled=false;
				enabled10E=false;
				
			}
		});
		operationBtn_3.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_3);
		
		JButton operationBtn_4 = new JButton("(");
		operationBtn_4.setBackground(new Color(204, 204, 255));
		operationBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=false;
				textField.setText(textField.getText()+"(");
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]="(";
				numberEnded=true;
				powerEnabled=false;
				 enabled10E=false;
			}
		});
		operationBtn_4.setMargin(new Insets(2, 2, 2, 2));
		operationBtn_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		normalOperation.add(operationBtn_4);
		
		JButton operationBtn_5 = new JButton(")");
		operationBtn_5.setBackground(new Color(204, 204, 255));
		operationBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=false;
				textField.setText(textField.getText()+")");
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]=")";
				numberEnded=true;
				powerEnabled=false;
				enabled10E=false;
			}
		});
		operationBtn_5.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_5);
		
		JButton operationBtn_6 = new JButton("Mod");
		operationBtn_6.setBackground(new Color(204, 204, 255));
		operationBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=false;
				textField.setText(textField.getText()+"M");
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]="M";
				numberEnded=true;
				powerEnabled=false;
				enabled10E=false;
			}
		});
		operationBtn_6.setMargin(new Insets(2, 2, 2, 2));
		operationBtn_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		normalOperation.add(operationBtn_6);
		
		JButton operationBtn_7 = new JButton("^");
		operationBtn_7.setBackground(new Color(204, 204, 255));
		operationBtn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=false;
				textField.setText(textField.getText()+"^");
				textField_1.setText(textField_1.getText()+" ");
				inText[++inTop]="^";
				numberEnded=true;
				powerEnabled=true;
			}
		});
		operationBtn_7.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_7);
		
		JButton operationBtn_8 = new JButton("C");
		operationBtn_8.setBackground(new Color(255, 153, 153));
		operationBtn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=true;
				operatorEnabled=true;
				powerEnabled=false;
				enabled10E=false;
				textField.setText("");
				textField_1.setText("");
				inText=new String[50];
				inText[0]="\0";
				inTop=-1;
				numberEnded=true;
			}
		});
		operationBtn_8.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_8);
		
		JButton operationBtn_9 = new JButton("Ans");
		operationBtn_9.setBackground(new Color(255, 153, 153));
		operationBtn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorEnabled=false;
				if(toggledOnce)
				{
					textField.setText("Ans");
					toggledOnce=false;
				}
				else
					textField.setText(textField.getText()+"Ans");
				inText[++inTop]=" "+ans;
				numberEnded=true;
				textField_1.setText(textField_1.getText()+" ");
			//	System.out.printf(" %d: %s ",inTop,inText[inTop]);
			}
		});
		operationBtn_9.setMargin(new Insets(2, 2, 2, 2));
		operationBtn_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_9);
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggledOnce=true;
				inText[++inTop]="\0";
				if(inputChecking(inText))
				{
					ans=solve(toPrefix());					
					textField.setText(""+ans);	
					toggledOnce=false;
				}
				else
					textField.setText("Syntax Error");
				inText=new String[50];
				inText[0]="\0";
				pointTriggred=false;				
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnNewButton.setMargin(new Insets(2, 4, 2, 4));
		btnNewButton.setBounds(163, 263, 68, 27);
		bottomPanel.add(btnNewButton);	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("PopupMenu.border"));
		panel_1.setBackground(new Color(200, 207, 19));
		panel_1.setBounds(10, 10, 221, 82);
		bottomPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 6, 2, 2));
		
		JButton inBuiltOperation = new JButton("ln");
		inBuiltOperation.setAlignmentX(0.5f);
		inBuiltOperation.setBackground(new Color(227, 124, 54));
		inBuiltOperation.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation);
		
		JButton btnE = new JButton("e^");
		btnE.setAlignmentX(0.5f);
		btnE.setBackground(new Color(227, 124, 54));
		btnE.setMargin(new Insets(4, 4, 4, 4));
		btnE.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(btnE);
		
		JButton btnTan = new JButton("sin");
		btnTan.setAlignmentX(0.5f);
		btnTan.setBackground(new Color(227, 124, 54));
		btnTan.setMargin(new Insets(4, 4, 4, 4));
		btnTan.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(btnTan);
		
		JButton inBuiltOperation_2 = new JButton("cos");
		inBuiltOperation_2.setAlignmentX(0.5f);
		inBuiltOperation_2.setBackground(new Color(227, 124, 54));
		inBuiltOperation_2.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_2);
		
		JButton inBuiltOperation_4 = new JButton("tan");
		inBuiltOperation_4.setAlignmentX(0.5f);
		inBuiltOperation_4.setBackground(new Color(227, 124, 54));
		inBuiltOperation_4.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_4);
		
		JButton inBuiltOperation_5 = new JButton("");
		inBuiltOperation_5.setAlignmentX(0.5f);
		inBuiltOperation_5.setBackground(new Color(227, 124, 54));
		inBuiltOperation_5.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_5);
		
		JButton inBuiltOperation_6 = new JButton("");
		inBuiltOperation_6.setAlignmentX(0.5f);
		inBuiltOperation_6.setBackground(new Color(227, 124, 54));
		inBuiltOperation_6.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_6);
		
		JButton inBuiltOperation_7 = new JButton("");
		inBuiltOperation_7.setAlignmentX(0.5f);
		inBuiltOperation_7.setBackground(new Color(227, 124, 54));
		inBuiltOperation_7.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_7);
		
		JButton inBuiltOperation_3 = new JButton("");
		inBuiltOperation_3.setAlignmentX(0.5f);
		inBuiltOperation_3.setBackground(new Color(227, 124, 54));
		inBuiltOperation_3.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_3);
		
		JButton inBuiltOperation_12 = new JButton("");
		inBuiltOperation_12.setAlignmentX(0.5f);
		inBuiltOperation_12.setBackground(new Color(227, 124, 54));
		inBuiltOperation_12.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_12);
		
		JButton inBuiltOperation_13 = new JButton("");
		inBuiltOperation_13.setAlignmentX(0.5f);
		inBuiltOperation_13.setBackground(new Color(227, 124, 54));
		inBuiltOperation_13.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_13.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_13);
		
		JButton inBuiltOperation_11 = new JButton("");
		inBuiltOperation_11.setAlignmentX(0.5f);
		inBuiltOperation_11.setBackground(new Color(227, 124, 54));
		inBuiltOperation_11.setMargin(new Insets(4, 4, 4, 4));
		inBuiltOperation_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		panel_1.add(inBuiltOperation_11);
		
		JButton btnNewButton_1 = new JButton("~Graph");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	graphPlotter graphPlot = new graphPlotter();
			//	graphPlot.setTitle("Graph Plotter");
				//graphPlot.setVisible(true);
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(255, 248, 220));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(201, 3, 75, 23);
		frmComcalculator.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setMargin(new Insets(2, 4, 2, 4));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		
		JButton operationBtn_8_1_1 = new JButton("SHIFT");
		operationBtn_8_1_1.setEnabled(false);
		operationBtn_8_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shiftEnabled=!shiftEnabled;
			}
		});
		operationBtn_8_1_1.setBounds(new Rectangle(2, 2, 2, 2));
		operationBtn_8_1_1.setBorder(UIManager.getBorder("CheckBox.border"));
		operationBtn_8_1_1.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_8_1_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 10));
		operationBtn_8_1_1.setBounds(10, 5, 47, 22);
		frmComcalculator.getContentPane().add(operationBtn_8_1_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 255, 102));
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 94, 266, 309);
		frmComcalculator.getContentPane().add(panel_2);
	}
	public void actionPerformed(ActionEvent e)
	{
		int i;
		for(i=0;i<10;i++)
		{	
		if(e.getSource()==btn[i])
			{
			if(powerEnabled || enabled10E || (operatorEnabled && textField_1.getText().endsWith("-")))
			{
				textField.setText(textField.getText()+" ");
				textField_1.setText(textField_1.getText()+i);
			}
			else
			{	
				textField.setText(textField.getText()+i);
				for(int sI=inTop;sI<textField.getText().length();sI++)
					textField_1.setText(textField_1.getText()+" ");
			}
				if(pointTriggred)
					inText[inTop]=inText[inTop]+i;
				else
				{
					 if(!numberEnded)
						 inText[inTop]=inText[inTop]+i;
					 else
					 {
						 if(operatorEnabled && inTop!=-1)
							 inText[inTop]=inText[inTop]+i;
						 else
							 inText[++inTop]=""+i;
					 }
				
				}
				numberEnded=false;
				operatorEnabled=false;
				pointTriggred=false;
				enabled10E=false;
			}
		}
		//System.out.printf(" %d: %s ",inTop,inText[inTop]);
		//System.out.printf(" state of 10POW: %b and power: %b ",enabled10E,powerEnabled);
	}
	public String[] toPrefix()
	{
		String outText[]=new String[50];
		int outI=0;
		String stack[]=new String[50];
		int top=-1;
		for(int i=0;inText[i]!="\0";i++)
		{
			switch(inText[i])
			{
				case "(": 	stack[++top]="(";
							break;
				case ")":   while(stack[top]!="(")
							outText[outI++]=stack[top--];
							top--;
							break;
				case "+":
				case "-":
				case "/":
				case "x":
				case "M":
				case "E":
				case "^": 		if(top!=-1)
								while(priority(stack[top])>=priority(inText[i]))
							{
								outText[outI++]=stack[top--];
								if(top==-1)
								break;
							}
							stack[++top]=inText[i];
							break;
				default:  	outText[outI++]=inText[i];			
						
			}
		}
		while(top!=-1)
        {
			outText[outI++]=stack[top--];
        }
		outText[outI++]="\0";
	//	for(int l=0;l<outI;l++)
		//	System.out.printf("\n %s",outText[l]);
			
		return outText;
	}
	public int priority(String inText2)
	{
		switch(inText2)
	    {
	    case "+":
	    case "-":
	    case "M": return 1;
	    case "x":
	    case "/": return 2;
	    case "^":
	    case "E":return 3;
	    default:  return 0;
	    }
	}
	public boolean inputChecking(String[] inText2)
	{
		int operators=0,operand=0,brackets=0;
		//for(int l=0;inText2[l]!="\0";l++)
			//System.out.printf("  %s",inText2[l]);
	    for(int i=0;inText2[i]!="\0";i++)
	    {
	       switch(inText2[i])
	        {
	            case "(" :  brackets++;

	                        break;
	            case ")" :  brackets--;
	                        break;
	            case "+":

	            case "-":

	            case "x":

	            case "^":

	            case "/": 
	            	
	            case "E": 
	            	
	            case "M":
	            
	            			operators++;
	                        break;
	            default:  operand++;
	        }
	    }

	    if((++operators)==operand && brackets==0)
	    return true;
	    else
	    return false;
	}
	public boolean checkIFOperand(String strings)
	{
		String[] opeString= {"+","-","/","x","M","^","E"};
			for(int j=0;j<7;j++)
				if(strings.equals(opeString[j]))
					return false;
		return true;
	}
	public double solve(String[] strings)
	{
		int i,top=-1;
		double n1,n2,n3=0;
		double outPut[]=new double[50];
		for(i=0;strings[i]!="\0";i++)
		    {
		        if(checkIFOperand(strings[i]))
		        {
		        	outPut[++top]=Double.parseDouble(strings[i]);
		        }
		        else
		        {
		            n2 = outPut[top--];
		            n1 = outPut[top--];
		            switch(strings[i])
		            {
		            case "+":
		            {
		                n3 = n1 + n2;
		                break;
		            }
		            case "-":
		            {
		                n3 = n1 - n2;
		                break;
		            }
		            case "x":
		            {
		                n3 = n1 * n2;
		                break;
		            }
		            case "/":
		            {
		                n3 = n1 / n2;
		                break;
		            }
		            case "M":
		            {
		                n3 = n1 % n2;
		                break;
		            }
		            case "^":
		            {
		                n3 = Math.pow(n1,n2);
		                break;
		            }
		            case "E":
		            {
		                n3 = n1*Math.pow(10,n2);
		                break;
		            }
		            }
		            outPut[++top]=n3;
		        }
		    }
		return outPut[top];
	}
}