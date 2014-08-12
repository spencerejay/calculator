import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
	public static final int WIDTH = 250;
	public static final int HEIGHT = 210;
	
	private JTextField inputOutputField;
	private double firstSum = 0;
	private double secondSum = 0;
	private double firstMinus = 0;
	private double secondMinus = 0;
	private double firstTimes = 0;
	private double secondTimes = 0;
	private double firstDivide = 0;
	private double secondDivide = 0;

	private String memo1;
	private String memo2;
	private int tabs = 0;
	private JButton equalsButton;
	
	public static void main(String[] args)
	{
		Calculator guiAdder = new Calculator();
		guiAdder.setVisible(true);
	}
	
	public Calculator()
	{
		setTitle("Calculator");
		addWindowListener(new WindowDestroyer());
		setSize(WIDTH, HEIGHT);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		
		inputOutputField = new JTextField("",15);
		inputOutputField.setBackground(Color.WHITE);
		textPanel.add(inputOutputField);
		contentPane.add(textPanel, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		
		JPanel mathPanel = new JPanel();
		mathPanel.setLayout(new FlowLayout());
		
		JButton addButton = new JButton("+");
		addButton.addActionListener(this);
		JButton minusButton = new JButton("-");
		minusButton.addActionListener(this);
		JButton timesButton = new JButton("*");
		timesButton.addActionListener(this);
		JButton divideButton = new JButton("/");
		divideButton.addActionListener(this);
		mathPanel.add(addButton);
		mathPanel.add(minusButton);
		mathPanel.add(timesButton);
		mathPanel.add(divideButton);
		buttonPanel.add(mathPanel,BorderLayout.NORTH);
		
		JPanel mathPanel2 = new JPanel();
		mathPanel2.setLayout(new FlowLayout());
		equalsButton = new JButton("=");
		equalsButton.addActionListener(this);
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		mathPanel2.add(equalsButton);
		equalsButton.setEnabled(false);
		mathPanel2.add(clearButton);
		buttonPanel.add(mathPanel2, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.CENTER);
		
		JPanel memoPanel = new JPanel();
		memoPanel.setLayout(new BorderLayout());
		
		JPanel savePanel1 = new JPanel();
		savePanel1.setLayout(new FlowLayout());
		JButton saveButton1 = new JButton("Save Memo 1");
		saveButton1.addActionListener(this);
		savePanel1.add(saveButton1);
		JButton saveButton2 = new JButton("Save Memo 2");
		saveButton2.addActionListener(this);
		savePanel1.add(saveButton2);
		memoPanel.add(savePanel1,BorderLayout.NORTH);
		
		JPanel getPanel = new JPanel();
		getPanel.setLayout(new FlowLayout());
		JButton getButton1 = new JButton("Get Memo 1");
		getButton1.addActionListener(this);
		getPanel.add(getButton1);
		JButton getButton2 = new JButton("Get Memo 2");
		getButton2.addActionListener(this);
		getPanel.add(getButton2);
		memoPanel.add(getPanel, BorderLayout.CENTER);
		contentPane.add(memoPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("+"))
		{
			firstSum = stringToDouble(inputOutputField.getText());
			tabs = 1;
			inputOutputField.setText("");
			equalsButton.setEnabled(true);
			inputOutputField.requestFocus();
			validate();
		}
		else if(e.getActionCommand().equals("-"))
		{
			firstMinus = stringToDouble(inputOutputField.getText());
			tabs = 2;
			inputOutputField.setText("");
			equalsButton.setEnabled(true);
			inputOutputField.requestFocus();
			validate();
		}
		else if(e.getActionCommand().equals("*"))
		{
			firstTimes = stringToDouble(inputOutputField.getText());
			tabs = 3;
			inputOutputField.setText("");
			equalsButton.setEnabled(true);
			inputOutputField.requestFocus();
			validate();
		}
		else if(e.getActionCommand().equals("/"))
		{
			firstDivide = stringToDouble(inputOutputField.getText());
			tabs = 4;
			inputOutputField.setText("");
			equalsButton.setEnabled(true);
			inputOutputField.requestFocus();
			validate();
		}
		else if(e.getActionCommand().equals("="))
		{
			if(inputOutputField.getText().equals(""))
			{
				inputOutputField.setText("Error in user entry");
			}
			else if(tabs == 1)
			{
				secondSum = stringToDouble(inputOutputField.getText());
				inputOutputField.setText(Double.toString(firstSum+secondSum));
				equalsButton.setEnabled(false);
				validate();
			}
			else if(tabs == 2)
			{
				secondMinus = stringToDouble(inputOutputField.getText());
				inputOutputField.setText(Double.toString(firstMinus-secondMinus));
				equalsButton.setEnabled(true);
				validate();

			}
			else if(tabs == 3)
			{
				secondTimes = stringToDouble(inputOutputField.getText());
				inputOutputField.setText(Double.toString(firstTimes*secondTimes));
				equalsButton.setEnabled(true);
				validate();

			}
			else if(tabs == 4)
			{
				secondDivide = stringToDouble(inputOutputField.getText());
				inputOutputField.setText(Double.toString(firstDivide/secondDivide));
				equalsButton.setEnabled(true);
				validate();
				}
			
		}
		else if(e.getActionCommand().equals("Clear"))
		{
			inputOutputField.setText("");
		}
		else if(e.getActionCommand().equals("Save Memo 1"))
		{
			memo1 = inputOutputField.getText();
		}
		else if(e.getActionCommand().equals("Save Memo 2"))
		{
			memo2 = inputOutputField.getText();
		}
		else if(e.getActionCommand().equals("Get Memo 1"))
		{
			inputOutputField.setText(memo1);
		}
		else if(e.getActionCommand().equals("Get Memo 2"))
		{
			inputOutputField.setText(memo2);
		}
	}
	
	private static double stringToDouble(String stringObject)
	{
		return Double.parseDouble(stringObject.trim());
	}
}