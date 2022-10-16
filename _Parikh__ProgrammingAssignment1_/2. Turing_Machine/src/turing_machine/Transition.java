/* Sheetal Parikh
 * Programming Assignment 1 - Question 2
 * Turing Machine
 */
package turing_machine;

/**
 *
 * @author SheetalParikh
 */
public class Transition {
    private char currentState;              //current state
    private char nextState;                 //state head transitions to
    private char readSymbol;             //reading the current symbol
    private char writeSymbol;            //overwriting the current symbol
    private char direction;                 //direction the head moves
    
    //getting values for the various transitions
    public Transition(char currentState, char nextState, char readSymbol, char writeSymbol, char direction) {
        this.currentState = currentState;
        this.nextState = nextState;
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
    }
    
    public char getCurrentState() {
        return currentState;
    }
    
    public void setCurrentState(char currentState) {
        this.currentState = currentState;
    }
    
    public char getNextState() {
        return nextState;
    }
    
    public void setNextState(char nextState) {
        this.nextState = nextState;
    }
    
    public char getReadSymbol() {
        return readSymbol;
    }
    
    public void setReadSymbol(char readSymbol) {
        this.readSymbol = readSymbol;
    }
    
    public char getWriteSymbol() {
        return writeSymbol;
    }
    
    public void setWriteSymbol(char writeSymbol) {
        this.writeSymbol = writeSymbol;
    }
    
    public char getDirection() {
        return direction;
    }
    
    public void setDirection(char direction){
        this.direction = direction;
    }

    //Displaying Current State, Current Symbol, Next State, What overwrites current position, and direction head moves 
    @Override
    public String toString() {
        return "Current State: " + currentState + " Read:" + readSymbol + " Next State: " + 
                nextState + " Write:" + writeSymbol + " Direction: " + getDirection();
    }
}