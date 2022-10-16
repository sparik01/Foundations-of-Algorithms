/* Sheetal Parikh
 * Programming Assignment 1 - Question 2
 * Turing Machine
 */
package turing_machine;

import java.util.Stack;

/**
 *
 * @author SheetalParikh
 */
public class Tape {
    private Stack<Character> leftTape;                  // left side of tape
    private Stack<Character> rightTape;                 // right side of tape
    private char current;                               // active value


    
    public Tape(String input) {                         //creating tape for user input  
        leftTape = new Stack <>();
        rightTape = new Stack <>();
        rightTape.push('#');
        
    for (int i = input.length() - 1; i >= 0 ; i--) {
            rightTape.push(input.charAt(i));
        }
        current = rightTape.pop();
    }
    
                                                        
    public void Left() {                            // head moves left one position and add # for more space
        rightTape.push(current);
        if (leftTape.isEmpty()) 
            leftTape.push('#');                         
        current = leftTape.pop();       
    }
    
    
    public void Right() {                           // head moves right one position and add # for more space
        leftTape.push(current);
        if (rightTape.isEmpty()) 
            rightTape.push('#');  
        current = rightTape.pop();
    }
    
    
    public Character getCurrent(){                      //getting symbol from current position
        return current;
    }

    public void setCurrent(char nextChar){
        this.current = nextChar;
        
    }
   
}
