/* Sheetal Parikh
 * Programming Assignment 1 - Question 2
 * Turing Machine
 * Main
 */

package turing_machine;

import java.util.ArrayList;

/**
 *
 * @author SheetalParikh
 */
public class Turing_Machine {

    private String input;                                           //tape - user input
    private Tape inputTape;                         
    private ArrayList<Transition> function;
    private char startState;                                        //state the header starts
    private char currentState;                                      //the state currently the header points

    public Turing_Machine(String input, char startState) {
           inputTape = new Tape(input);
           function = new ArrayList<>();
           this.startState = startState;
           this.input = input;
    }
    
    public void addTransition(Transition transition) {              //adding new states to the machine    
           function.add(transition);
    }

    public void start() {                                           //the header will keep moving until we reach halting state
        currentState = startState;
        Transition currentTrans = null;
        do {
                if (currentTrans != null)
                    currentState = currentTrans.getNextState();
                currentTrans = checkTransition(currentState);
        } while (currentTrans != null);            
    
        if (currentState == 'z')                                    //once the header halts and is at state Z we are at the accepted state
            System.out.println(input + ": Accepted");
        else
            System.out.println(input + ": Rejected");              //once the header halts and is at any other state we are at a rejected state
    }
    
    public Transition checkTransition(char state) {                //checking the transition function at each state to determine how to move head
        Transition transition = null;
        for (Transition fx: function) {
            if(fx.getCurrentState() == state) {
                if(fx.getReadSymbol() == inputTape.getCurrent()) {
                    transition = fx;
                    System.out.println(transition);
                    inputTape.setCurrent(transition.getWriteSymbol());
                    if (transition.getDirection() == 'L')           //head moves left if symbol at current state dictates left
                        inputTape.Left();
                    else if (transition.getDirection() == 'R')      //head moves right if symbol at current state dictates right
                        inputTape.Right();
                    break;
                }
            }
        }
        
        return transition;
    }
    
       
       //*************************************************************************************//
    
   public static void main(String[] args) {
    
       Turing_Machine machine = new Turing_Machine("11*_10$", 'a');       //input binary in format ("input", 'starting state')
       
       //b.Addition (works on the type of binary numbers and the format listed below)
       //   format1: 1010@1010&$ (alternating numbers added to each other with @ as the + and ending with &$)  
       //   format2: 111111111111@111111111111&$ 
       //            (series of 1's added to each other of same size with @ as the + and ending with &$)                                             
       
       //c. subtraction (works on the type of binary numbers and the format listed below)
       //     format:  input form A-B = AcB ; answer is before he c 
       //               examples: 01c011, 011111c000100, etc.
       
       //d. multiplication (works on the type of binary numbers and format listed below)
       //     format: 10000***_10000$ or 11*_10$  
       
       //*************************************************************************************//
       
       //transitions for the turing machine
       //start at state 'a'
       //('current state', 'next state', symbol read, symbol written, direction)
       // # represents blank symbol
       // x = reject state 
       // z = accept state

       machine.addTransition(new Transition( 'a', 'a', '@', '@', 'R'));    //for addition
       machine.addTransition(new Transition( 'a', 'a', '&', '0', 'R'));    // for addition
       machine.addTransition(new Transition( 'a', 'b', '$', '#', 'L'));    // for addition
       machine.addTransition(new Transition( 'a', 'b', '_', '_', 'R'));    // for multiplication
       machine.addTransition(new Transition( 'a', 'a', '*', '0', 'R'));    // for multiplication
       machine.addTransition(new Transition( 'a', 'a', 'c', 'c', 'R'));    // for subtraction
       machine.addTransition(new Transition( 'a', 'a', 'c', 'c', 'R'));    // for subtraction 
      // machine.addRule(new Transition( 'a', 'a', '1', '0', 'R'));  // for subtraction - add or remove for other operations
      // machine.addRule(new Transition( 'a', 'a', '0', '1', 'R'));  // for subtraction - add or remove for other operations
       machine.addTransition(new Transition( 'a', 'a', '0', '0', 'R'));    //remove for subtraction
       machine.addTransition(new Transition( 'a', 'a', '1', '1', 'R'));    //remove for subtraction
       machine.addTransition(new Transition( 'a', 'b', '#', '#', 'L'));
       machine.addTransition(new Transition( 'b', 'c', '0', '#', 'L'));
       machine.addTransition(new Transition( 'b', 'd', '1', '#', 'L'));
       machine.addTransition(new Transition( 'b', 'x', '#', '#', 'L'));
       machine.addTransition(new Transition( 'c', 'z', '0', '#', 'L'));
       machine.addTransition(new Transition( 'c', 'x', '#', '#', 'L'));
       machine.addTransition(new Transition( 'c', 'x', '1', '#', 'L'));
       machine.addTransition(new Transition( 'd', 'x', '0', '#', 'L'));
       machine.addTransition(new Transition( 'd', 'x', '1', '#', 'L'));
       machine.addTransition(new Transition( 'd', 'x', '#', '#', 'L'));
       
       machine.start();
   }
   
       
} //end program
      
