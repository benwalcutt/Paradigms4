# Paradigms4
Create an auto complete text field

Auto-completion

  Make a backup copy of your previous assignment.


  Make a class that extends javax.swing.JTextField. You might call it "AutoCompleteTextField", or something like that. The idea is that a user could type a few letters into this field, and it will helpfully auto-complete whatever word the user appears to be typing. (We will not implement a pop-up window or a pull-down menu. The suggested completion of the user's word will appear in the same JTextfield where the user is typing.)


  Make a simply GUI program to present your auto-completing text field. Make your auto-completing text field lazy-load the lexicon into a static TreeSet<String> data structure. (So, if you were to make multiple auto-completing text fields, the lexicon would only be loaded one time. If you were to never instantatiate an auto-completing text field, the lexicon would never be loaded.)


  Make your AutoCompleteTextField class implement the KeyListener interface, so you can write special code for handling keys that are typed. In the constructor, call addKeyListener, to tell the event pump to send key events to it.


  When the user presses a key, if it is backspace, make it behave the way backspace is supposed to. (If some text is selected, that text should be deleted. If no text is selected, the cursor should back up one character and delete that character. In most cases, you won't need to write any code for this--just return, and it should do the right thing.) If the user has pressed any other key, find the first word in the lexicon that matches the text that has been entered so far (including the keys the user previously typed, and the key the just just pressed). If there is a match, replace the current text with the full word, and select the portion of text that the user did not type, such that the next character the user types will replace the suggested completion of the word. (You may assume that the user will only enter one word at-a-time into the auto-completing text field. You don't need to complete sentences.)
