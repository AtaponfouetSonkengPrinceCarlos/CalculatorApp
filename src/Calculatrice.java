import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
public class Calculatrice extends JFrame {
	JLabel screen = new JLabel("0");
	JPanel pan = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel container = new JPanel();
	LabelAns label = new LabelAns("hh");
	GridLayout gl2 = new GridLayout();
	GridLayout gl = new GridLayout();
	GridLayout gl1 = new GridLayout();
	Boutton1 plus = new Boutton1("+");
	Boutton1 minus = new Boutton1("-");
	Boutton1 div = new Boutton1("/");
	Boutton1 time = new Boutton1("*");
	Boutton one = new Boutton("1");
	Boutton two = new Boutton("2");
	Boutton tree = new Boutton("3");
	Boutton four = new Boutton("4");
	Boutton five = new Boutton("5");
	Boutton six = new Boutton("6");
	Boutton seven = new Boutton("7");
	Boutton eigth = new Boutton("8");
	Boutton nine = new Boutton("9");
	Boutton point = new Boutton(".");
	Boutton zero = new Boutton("0");
	Boutton equal = new Boutton("=");
	JLabel screen1 = new JLabel();
	private boolean clickoperator = false,update = true,delscreen1 = false;
	private Double chiffre1;
	private String operateur = "";
	String str = "";
	String str1 = "";
	private int counte = 0;
	Calculatrice() {
		this.setResizable(false);
		this.setTitle("calculatorbyAtaponfouet");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("Tohoma",Font.BOLD,25);
		Font f1 = new Font("Arial",Font.BOLD,17);
		screen1.setForeground(Color.gray);
		gl2.setColumns(1);gl2.setRows(2);
		pan2.setLayout(gl2);
		screen1.setPreferredSize(new Dimension(350, 50));screen1.setFont(f1);screen1.setHorizontalAlignment(JLabel.RIGHT);pan2.add(screen1);
		container.setLayout(new BorderLayout());
		screen.setPreferredSize(new Dimension(350, 50));screen.setFont(f);screen.setHorizontalAlignment(JLabel.RIGHT);pan2.add(screen);
		pan2.setBorder(BorderFactory.createLineBorder(Color.black));
		container.add(pan2, BorderLayout.NORTH);
		gl1.setColumns(1);gl1.setRows(5);
		JButton c = new JButton("c");
		c.setFont(f);c.setPreferredSize(new Dimension(100, 70));c.setForeground(Color.red);
		pan1.add(c);pan1.add(plus);	pan1.add(minus);pan1.add(div);pan1.add(time);pan1.setLayout(gl1);
		container.add(pan1, BorderLayout.EAST);
		gl.setColumns(3);gl.setRows(4);
		pan.setLayout(gl);pan.add(one);pan.add(two);pan.add(tree);pan.add(four);pan.add(five);pan.add(six);pan.add(seven);pan.add(eigth);pan.add(nine);pan.add(point);
		pan.add(zero);
		pan.add(equal);pan.setBorder(BorderFactory.createLineBorder(Color.black));
		c.addActionListener(new ResetListener());
		plus.addActionListener(new PlusListener());
		minus.addActionListener(new MinusListener());
		div.addActionListener(new DivListener());
		time.addActionListener(new TimeListener());
		one.addActionListener(new ChiffreListener());
		two.addActionListener(new ChiffreListener());
		tree.addActionListener(new ChiffreListener());
		four.addActionListener(new ChiffreListener());
		five.addActionListener(new ChiffreListener());
		six.addActionListener(new ChiffreListener());
		seven.addActionListener(new ChiffreListener());
		eigth.addActionListener(new ChiffreListener());
		nine.addActionListener(new ChiffreListener());
		point.addActionListener(new ChiffreListener());
		zero.addActionListener(new ChiffreListener());
		equal.addActionListener(new EgalListener());
		container.add(pan, BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true);
	}
	public void calcul()
	{
		if(operateur.equals("+"))
		{
			chiffre1 = chiffre1 + Double.valueOf(screen.getText());
			screen.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("-"))
		{
			chiffre1 = chiffre1 - Double.valueOf(screen.getText());
			screen.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("*"))
		{
			chiffre1 = chiffre1*Double.valueOf(screen.getText());
			screen.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("/"))
		{
			try
			{
			chiffre1 = (chiffre1)/Double.valueOf(screen.getText());
			screen.setText(String.valueOf(chiffre1));
			}
			catch(ArithmeticException e)
			{
				screen.setText("0.0");
			}
		}
	}
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			clickoperator = false;
			update = true;
			chiffre1 = 0.0;
			operateur = "";
			screen.setText("0");
			screen1.setText("");
			str1 = "";
			counte = 0;
		}
	}
	class PlusListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			if(clickoperator)
			{
			calcul();
			screen.setText(String.valueOf(chiffre1));
			}
			else
			{
			chiffre1 =
			Double.valueOf(screen.getText()).doubleValue();
			clickoperator = true;
			}
			operateur = "+";
			update = true;
				if(delscreen1)
				{
					str1 = screen.getText()+operateur;
					screen1.setText(str1);
					delscreen1 = false;
				}else{			
				str1 = str1+str+operateur;
				screen1.setText(str1);
				}
				minus.setEnabled(false);
				time.setEnabled(false);
				div.setEnabled(false);
				counte = 0;
		}
	}
	class MinusListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{ 
			if(clickoperator)
			{
			calcul();
			screen.setText(String.valueOf(chiffre1));
			System.out.println("Quand je clique 2 fois"+String.valueOf(chiffre1));
			}
			else
			{
			chiffre1 =
			Double.valueOf(screen.getText()).doubleValue();
			System.out.println("quand je clique sur moins 1 fois"+chiffre1);
			clickoperator = true;
			}
			operateur = "-";
			update = true;
				if(delscreen1)
				{
					str1 = screen.getText()+operateur;
					screen1.setText(str1);
					delscreen1 = false;
				}else{			
				str1 = str1+str+operateur;
				screen1.setText(str1);
				}
				plus.setEnabled(false);
				time.setEnabled(false);
				div.setEnabled(false);
				counte = 0;
		}
	}
	class DivListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(clickoperator)
			{
			calcul();
			screen.setText(String.valueOf(chiffre1));
			}
			else
			{
			chiffre1 =
			Double.valueOf(screen.getText()).doubleValue();
			clickoperator = true;
			}
			operateur = "/";
			update = true;
				if(delscreen1)
				{
					str1 = "("+screen.getText()+")"+operateur;
					screen1.setText(str1);
					delscreen1 = false;
				}else{			
				str1 = "("+str1+str+")"+operateur;
				screen1.setText(str1);
				}
				minus.setEnabled(false);
				time.setEnabled(false);
				plus.setEnabled(false);
				counte = 0;
		}
	}
	class TimeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(clickoperator)
			{
			calcul();
			screen.setText(String.valueOf(chiffre1));
			}
			else
			{
			chiffre1 =
			Double.valueOf(screen.getText()).doubleValue();
			clickoperator = true;
			}
			operateur ="*";
			update = true;
				if(delscreen1)
				{
					str1 = screen.getText()+operateur;
					screen1.setText(str1);
					delscreen1 = false;
				}else{			
				str1 = str1+str+operateur;
				screen1.setText(str1);
				}
				minus.setEnabled(false);
				plus.setEnabled(false);
				div.setEnabled(false);
				counte = 0;
		}
	}
	class EgalListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
		counte++;
		update = true;
		clickoperator = false;
		if(counte >=2)
		{
			System.out.println("==="+counte);
			str1 = screen.getText()+operateur+str+"=";
			screen1.setText(str1);
			if(operateur == "+") {
		chiffre1 = chiffre1 - Double.valueOf(screen.getText()) + Double.valueOf(str);
			}else {
			if(operateur == "-")
			{
				chiffre1 = chiffre1 + Double.valueOf(screen.getText())-Double.valueOf(str);
			}else {
				if(operateur == "/")
				{
					chiffre1 = (chiffre1/Double.valueOf(str))*Double.valueOf(screen.getText());
				}else {
					if(operateur == "*")
					{
						chiffre1 = ((chiffre1*Double.valueOf(str))/(Double.valueOf(screen.getText())));
					}
					}
				}
			}
		}else {
			str1 = str1+str+"=";
			screen1.setText(str1);
			delscreen1 = true;
		}
		calcul();
		}
	}
	class ChiffreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			minus.setEnabled(true);
			time.setEnabled(true);
			div.setEnabled(true);
			plus.setEnabled(true);
					str =((JButton)e.getSource()).getText();
					if(update)
					{
					update = false;
					}
					else
					{
					if(!screen.getText().equals("0") )
					{
						str = screen.getText() +str;
					}else
					{
						str = 0+str;
					}
					}
					screen.setText(str);
					System.out.println(str);
					if(delscreen1)
					{
						str1 = "";
						delscreen1 = false;
					}
					screen1.setText(str1+str);
					System.out.println("chiffre " +str1+str);
		}
	}
	}
