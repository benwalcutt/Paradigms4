import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

class myautocomplete extends JTextField implements KeyListener {
	JFrame frame;
	JPanel panel;
	JTextField main_field;
	TreeMap<String, Integer> tm;
	String test_key;
	
	public myautocomplete() throws FileNotFoundException{
		frame = new JFrame("Auto Complete");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.add(panel);
		
		main_field = new JTextField();
		main_field.addKeyListener(this);
		Dimension main_dim = new Dimension(100, 20);
		main_field.setPreferredSize(main_dim);
		panel.add(main_field);
		
		tm = new TreeMap<String, Integer>();

		Scanner s = new Scanner(new File("lexicon.txt"));
		while (s.hasNextLine()) {
			String word = s.nextLine();
			tm.put(word, 1);
		}
		test_key = "";
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		myautocomplete AC = new myautocomplete();
	} 
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	public void keyTyped(KeyEvent e) {
		String return_key;
		String i;
		Character input_char;
		int divide;
		
		input_char = null;
		
		input_char = e.getKeyChar();
		
		if (input_char == 8) {
			this.main_field.replaceSelection("");
			this.test_key = this.main_field.getText();
			e.consume();
		}
		else if (input_char == 10 || input_char == 12) {
			this.test_key = this.main_field.getText();
			this.main_field.setCaretPosition(test_key.length());
			e.consume();
		}
		else {
		this.main_field.replaceSelection(input_char.toString());
		test_key = test_key.concat(input_char.toString());

		if (this.main_field.isFocusOwner() == true) {
			return_key = tm.ceilingKey(test_key);
			if (return_key.contains(test_key)) {
				divide = test_key.length();
				
				return_key = return_key.substring(divide);
				i = test_key.substring(0);
				i = i.concat(return_key);
				this.main_field.setText(i);

				this.main_field.setCaretPosition(divide);
				this.main_field.select(divide, i.length());
				
			}
			else {
			}
		}
			e.consume();
		
		}
	}
	}

