package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * A Standard calc expression that will be converted to postfix to be evaluated.
 * @author Aashrith Karise
 *
 */

public class StandardCalc implements Calculator {

  //Reversing expression method doesn't work as intended so
  // So removed that and implemented it without it
  
  
  private OpStack stakOp = new OpStack();//object of operator stack
  private StrStack stakStr = new StrStack();//object of string stack 
  private RevPolishCalc rpCalc = new RevPolishCalc(); //To call the evaluate function
  /**This is the evaluate method for infix expresion.
   * Throws @InvalidExpression if the expression is not valid
   * Throws @BadType if is it anything except numbers and operators
   * Thrwos @EmptyStack if its not balanced expresion
   * @throws BadType 
   */
  
  public float evaluate(String what) throws InvalidExpression, EmptyStack, BadType {
    
    if (what.length() == 0) {
      throw new InvalidExpression();//if length is 0
    }
    @SuppressWarnings("resource")
    Scanner whatScnr = new Scanner(what);
    

    //Shunting Algorithm starts below
    String tempString;
    String stringVal = " ";//Hold the appended string

    while (whatScnr.hasNext()) { 
      
      tempString = whatScnr.next();
      
      if (tempString.length() > 0 && Character.isDigit(tempString.charAt(0))) { //2 digits or more
        stringVal += " " + tempString + " ";//number appended
        
      } else { //If it's a character
        char tempChar = tempString.charAt(0);
  
        if (tempChar == '(') { //left bracket added to stack       
          stakOp.push(getSymbolValue(tempChar));
        } else if (tempChar == ')') { //Pops and add it to string,if value in stack precedes this
          while (!stakOp.isEmpty() && stakOp.top() != Symbol.Left_Bracket) {
            stringVal +=  " " + ((Symbol) stakOp.pop()).toChar() + " ";
          }
          if (stakOp.isEmpty()) {
            return (404);
          } else {
            stakOp.pop();//pops right bracket after all operators have been popped
          }    
        } else {
          while (!stakOp.isEmpty() && (precedence(tempChar) <= precedence(stakOp.top().toChar()))) {
            stringVal += " " + ((Symbol) stakOp.pop()).toChar();
          }    
          stakOp.push(getSymbolValue(tempChar));
        }    
      }
            
    }
    
    
    //Add the remainders in the stack to the string, which should now be the postfix
    while (!stakOp.isEmpty()) {
      stringVal += " " + ((Symbol) stakOp.pop()).toChar();
    }
    float finalAnswer = rpCalc.evaluate(stringVal);    
    whatScnr.close();
    return (finalAnswer);
  }

 
  /**This method will check the symbol if they exist in the enum class.
   * 
   * @param c will check the symbol
   * @return
   */
  
  public Symbol getSymbolValue(char c) {
    
    //Each case is checked with enum class to check symbols exist
    switch (c) {
      case '(':
        return (Symbol.Left_Bracket);
      case ')':
        return (Symbol.Right_Bracket);
      case '*':
        return (Symbol.Times);
      case '/':
        return (Symbol.Divide);
      case '+':
        return (Symbol.Plus);
      case '-':
        return (Symbol.Minus);
      default:
        break;
        
    }    
    return (Symbol.Invalid);
  }
  /**This method will check for character value (by bidmas).
   * 
   * @param c is the character precdence to check
   * @return will give the value of character
   */
  
  public int precedence(char c) {
    switch (c) {
      case '-':
        return 4;
      case '+':
        return 5;
      case '*':
        return 3;
      case '/':
        return 2;
      case '^':
        return 1;
      default:
        break;
    }
    return -1;
  }
}