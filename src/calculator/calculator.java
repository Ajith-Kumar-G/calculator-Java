package calculator;

import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class calculator implements ActionListener {

	private JFrame frmComcalculator;
	private JTextField textField;
	public double ans=0.0;
	String inText[]=new String[50];
	int inTop=-1;
	JButton btn[]=new JButton[10];
	boolean toggledOnce=false,pointTriggred=false,numberEnded=true;
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
		frmComcalculator.setTitle("ComCalculator");
		frmComcalculator.setBounds(100, 100, 300, 450);
		frmComcalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComcalculator.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 23, 266, 60);
		frmComcalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		textField.setDisabledTextColor(SystemColor.text);
		textField.setBounds(10, 12, 202, 43);
		panel.add(textField);
		textField.setColumns(10);
		
		JToggleButton statusButton = new JToggleButton("OFF");
		statusButton.setMargin(new Insets(2, 5, 2, 5));
		statusButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 8));
		statusButton.setBounds(222, 20, 36, 28);
		panel.add(statusButton);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(20, 89, 241, 300);
		frmComcalculator.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JPanel numberPanel = new JPanel();
		numberPanel.setBounds(10, 96, 143, 194);
		bottomPanel.add(numberPanel);
		numberPanel.setLayout(new GridLayout(4, 3, 1, 1));
		
		for(int i=0;i<10;i++)
		{
			btn[i] = new JButton(""+i);
			btn[i].setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
			btn[i].addActionListener((ActionListener) this);
			btn[i].setMargin(new Insets(2, 4, 2, 4));
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
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"E");
				inText[++inTop]="E";
				numberEnded=true;
			}
		});
		btnNewButton_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnNewButton_12.setMargin(new Insets(2, 4, 2, 4));
		numberPanel.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton(".");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+".");
				pointTriggred=true;
				inText[inTop]=inText[inTop]+".";
			}
		});
		btnNewButton_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnNewButton_11.setMargin(new Insets(2, 4, 2, 4));
		numberPanel.add(btnNewButton_11);
		
		JPanel normalOperation = new JPanel();
		normalOperation.setBounds(163, 97, 68, 162);
		bottomPanel.add(normalOperation);
		normalOperation.setLayout(new GridLayout(5, 2, 0, 0));
		
		JButton operationBtn_0 = new JButton("x");
		operationBtn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"x");
				inText[++inTop]="x";
				numberEnded=true;
			}
		});
		normalOperation.add(operationBtn_0);
		operationBtn_0.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_0.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		JButton operationBtn_1 = new JButton("/");
		operationBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"/");
				inText[++inTop]="/";
				numberEnded=true;
			}
		});
		operationBtn_1.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_1);
		
		JButton operationBtn_2 = new JButton("+");
		operationBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"+");
				inText[++inTop]="+";
				numberEnded=true;
					//System.out.printf("%d: %s",inTop,inText[inTop]);
			}
		});
		operationBtn_2.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_2);
		
		JButton operationBtn_3 = new JButton("-");
		operationBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"-");
				inText[++inTop]="-";
				numberEnded=true;
			}
		});
		operationBtn_3.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_3);
		
		JButton operationBtn_4 = new JButton("(");
		operationBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"(");
				inText[++inTop]="(";
				numberEnded=true;
			}
		});
		operationBtn_4.setMargin(new Insets(2, 2, 2, 2));
		operationBtn_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		normalOperation.add(operationBtn_4);
		
		JButton operationBtn_5 = new JButton(")");
		operationBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+")");
				inText[++inTop]=")";
				numberEnded=true;
			}
		});
		operationBtn_5.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_5);
		
		JButton operationBtn_6 = new JButton("Mod");
		operationBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"M");
				inText[++inTop]="M";
				numberEnded=true;
			}
		});
		operationBtn_6.setMargin(new Insets(2, 2, 2, 2));
		operationBtn_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		normalOperation.add(operationBtn_6);
		
		JButton operationBtn_7 = new JButton("^");
		operationBtn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"^");
				inText[++inTop]="^";
				numberEnded=true;
			}
		});
		operationBtn_7.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_7);
		
		JButton operationBtn_8 = new JButton("C");
		operationBtn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				inText=new String[50];
				inText[0]="\0";
				inTop=-1;
				numberEnded=true;
				ans=0.0;
				
			}
		});
		operationBtn_8.setMargin(new Insets(2, 4, 2, 4));
		operationBtn_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_8);
		
		JButton operationBtn_9 = new JButton("Ans");
		operationBtn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toggledOnce)
				{
					textField.setText("Ans");
					toggledOnce=!toggledOnce;
				}
				else
					textField.setText(textField.getText()+"Ans");
				inText[++inTop]="A";
				numberEnded=true;
			}
		});
		operationBtn_9.setMargin(new Insets(2, 2, 2, 2));
		operationBtn_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		normalOperation.add(operationBtn_9);
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inText[++inTop]="\0";
				if(inputChecking(inText))
				{
					ans=solve(toPrefix());					
					textField.setText(""+ans);	
					toggledOnce=!toggledOnce;
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
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(10, 10, 221, 76);
		bottomPanel.add(panel_1);
	}
	public void actionPerformed(ActionEvent e)
	{
		int i;
		for(i=0;i<10;i++)
		{	
		if(e.getSource()==btn[i])
			{
				textField.setText(textField.getText()+i);
				if(pointTriggred)
					inText[inTop]=inText[inTop]+i;
				else
				{
					 if(!numberEnded)
						 inText[inTop]=inText[inTop]+i;
					 else
					inText[++inTop]=""+i;
				}
				numberEnded=false;
			}
		}
		//System.out.printf(" %d: %s ",inTop,inText[inTop]);
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
		for(int l=0;l<outI;l++)
			System.out.printf("\n %s",outText[l]);
		return outText;
	}
	public int priority(String inText2)
	{
		switch(inText2)
	    {
	    case "+":
	    case "-":
	    case "M":
	    case "E": return 1;
	    case "x":
	    case "/": return 2;
	    case "^": return 3;
	    default:  return 0;
	    }
	}
	public boolean inputChecking(String[] inText2)
	{
		int operators=0,operand=0,brackets=0;
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
		String[] opeString= {"+","-","/","x","M","^"};
			for(int j=0;j<6;j++)
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
		            }
		            outPut[++top]=n3;
		        }
		    }
		return outPut[top];
	}
}
