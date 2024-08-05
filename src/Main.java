import javax.swing.*; // for JPanel, button, frame...
import java.awt.*; // 
import java.awt.event.*; // paint

// the jframe has the textField as well as the delete and clear buttons,
// the jpanel has the number and operator keys 

public class Main implements ActionListener{

	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30); // since we want it all to be same font, I just declare a font rn and just input myFont later to make it easier for myself
	
	double num1 = 0, num2 = 0, result =0; ; // to represent the numbers being inputted and outputted
	char operator; // to represent the operator being used 
	
	
	//constructor
	Main(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);;
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(50,25,300,50); // (x,y,width,height)
		textField.setFont(myFont);
		textField.setEditable(false); // so that the user cant input keys and letters from their keyboard, but it will take input from the buttons on the frame
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		// easier way to add an actionListener and set the font for each of the buttons 
		for(int i = 0; i<9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50,430, 100, 50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10)); // rows, columns, x spacing, y spacing
	//	panel.setBackground(Color.gray); // just used it to see where the panel is
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		// building a simple calculator 
		
		Main calc = new Main();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//
		for(int i = 0; i < 10; i++) {
			if(e.getSource()==numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i))); // this is only for numberButtons, so doesnt work on operator buttons
			}
		}
		
		if(e.getSource()==decButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		if(e.getSource()==equButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result; // to continue if u want to use same number 
		}
		
		if(e.getSource()==clrButton) {
			textField.setText("");
		}
		
		if(e.getSource()==delButton) {
			String string = textField.getText();
			textField.setText("");
			
			// we use the for loop to iterate through the length of the textField but minus one when they delete
			for(int i = 0; i < string.length()-1; i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1; // we just multiply by -1 to make the value neg
			textField.setText(String.valueOf(temp));
		}
		
		
		
		
		
	}

}
