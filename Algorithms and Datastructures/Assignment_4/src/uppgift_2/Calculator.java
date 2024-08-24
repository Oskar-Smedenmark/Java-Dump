package uppgift_2;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

	private String buttonText[] = { "7", "8", "9", "^", "C", "4", "5", "6", "(", ")", "1", "2", "3", "*", "/", "0", "+",
			"-", "=" };
	private JButton[] buttons = new JButton[19];
	private JTextField expressionField;
	private String exp = "";

	public Calculator() {
		super("Calculator");
		setSize(320, 240);
		expressionField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(4, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonText[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		panel.add(new Label());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(expressionField, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "C") {
			exp = "";
			expressionField.setText(exp);
		} else if (e.getActionCommand() == "=") {
			expressionField.setText(""+evaluate(infixToPostfix(exp)));
		}

		else {
			exp = exp + e.getActionCommand();
			expressionField.setText(exp);
		}

	}

	public static void main(String[] arg) {

		Calculator calc = new Calculator();
		calc.setVisible(true);

	}

	/**
	 * Gives a postfix representation of the infix equation in exp
	 * @param exp equation with infix notation
	 * @return LinkedList with the entered equation in postfix notation
	 */
	public static LinkedList<String> infixToPostfix(String exp) {
		Stack<String> stack = new Stack<String>();
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < exp.length(); i++) {
			String s = exp.charAt(i) + "";
			if (s.equals("+")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);

			} else if (s.equals("-")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals("*")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);

			} else if (s.equals("/")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);

			} else if (s.equals("^")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);

			}

			else if (s.equals(")")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (!tkn.equals("("))
						list.add(tkn);
					else {
						break;
					}
				}

			} else if (s.equals("(")) {
				stack.push(s);
			} else
				list.add(s);
		}

		while (!stack.isEmpty()) { //Empty the stack if we're done but still have operators in the stack
			list.add(stack.pop());
		}
		return list;
	}

	/**
	 * Evaluates an equation in the postfix notation
	 * @param exp equation in postfix notation
	 * @return double with the result from said equation
	 */
	public static double evaluate(LinkedList<String> exp) {
	       Stack<Double> stack = new Stack<Double>();
	       while(!exp.isEmpty())
	       {
	    	   String tkn = exp.remove();
	    	   stack.push(cal(tkn, stack.pop(), stack.pop()));
	       }
	       return stack.pop();
	}
	
	/**
	 * Calculates the operator on tkn1 and tkn2. Operation order is tkn2 "operator" tkn1
	 * @param operator a token from an equation, either a operand or an operator
	 * @param tkn1 number 1
	 * @param tkn2 number 2
	 * @return result from the calculation
	 */
	public static double cal(String operator, double tkn1, double tkn2)
	{
		double res = 0;
		if(operator.equals("+"))
		{
			res = tkn2+tkn1;
		}
        else if (operator.equals("-"))
 	   	{
 	   		res = tkn2-tkn1;
 	   	}
        else if (operator.equals("*")) 
    	{
        	res = tkn2*tkn1;
    	}
        else if (operator.equals("/"))
        {
 		   	res = tkn2/tkn1;
        }
        else if (operator.equals("^"))
        {
 		   	res = Math.pow(tkn2,tkn1);
        }
        else res = Double.parseDouble(operator);
		return res;
	}

}
