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
		
		System.out.print("selection start TOP: ");
				System.out.println(this.main_field.getSelectionStart());
				System.out.print("selection end TOP: ");
				System.out.println(this.main_field.getSelectionEnd());
				System.out.println("----------");
				System.out.println(e);
				System.out.println("----------");
		if (e.getKeyChar() != 8) {
		
		//this.test_key = this.main_field.getText();
		input_char = e.getKeyChar();
		this.main_field.replaceSelection(input_char.toString());
		test_key = test_key.concat(input_char.toString());
		
		if (this.main_field.isFocusOwner() == true) {
			return_key = tm.ceilingKey(test_key);
			if (return_key.contains(test_key)) {
				divide = test_key.length();
				System.out.print("return key: ");
				System.out.println(return_key);
				System.out.print("test key: ");
				
				System.out.println(test_key);
				System.out.print("divide: ");
				System.out.println(divide);
				
				return_key = return_key.substring(divide);
				i = test_key.substring(0);
				i = i.concat(return_key);
				this.main_field.setText(i);
				System.out.print("i: ");
				System.out.println(i);
				this.main_field.setCaretPosition(divide);
				this.main_field.select(divide, i.length());
				System.out.print("selection start: ");
				System.out.println(this.main_field.getSelectionStart());
				System.out.print("selection end: ");
				System.out.println(this.main_field.getSelectionEnd());
				
			}
			else {
				System.out.println("");
			}
		}
			e.consume();
		
		}
		else {
			if (this.main_field.getSelectionEnd() == this.main_field.getSelectionStart()) {
				System.out.print("selection start BS: ");
				System.out.println(this.main_field.getSelectionStart());
				System.out.print("selection end BS: ");
				System.out.println(this.main_field.getSelectionEnd());
				test_key = test_key.substring(0, test_key.length() - 1);
				System.out.print("test_key BS: ");
				System.out.println(test_key);
			}
		}
		input_char = null;
	}

}
