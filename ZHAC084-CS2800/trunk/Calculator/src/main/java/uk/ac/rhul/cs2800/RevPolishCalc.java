package uk.ac.rhul.cs2800;
import java.util.Scanner;
/** Class executes if exp is postfix or and infix (converted to postfix through algorithm).
 * @author Aashrith Karise
 *
 */

public class RevPolishCalc implements Calculator {

private NumStack stak = new NumStack();
  
  /**This method is used to evaluate a postfix expression.
   * Throws @InvalidExpression if the expression is not valid
   * Throws @BadType if is it anything except numbers and operators
   * Thrwos @EmptyStack if its not balanced expresion
   */
  
  public float evaluate(String what) throws InvalidExpression, EmptyStack {
    //Holds the string
    String str = " ";

    Scanner strVal = new Scanner(what);  // Reading from System.in
    try {
      while (strVal.hasNext()) {
        
        if (strVal.hasNext(".*\\d+.*")) { //To check if the string is digits or chars     
          stak.push((float) Double.parseDouble(str = strVal.next()));
        } else {
          String val = strVal.next();//Pops the elements froms stack from operation
          float num1 = stak.pop();
          float num2 = stak.pop();
  
          if (val.equals("+")) {
            stak.push(num2 + num1);//Adds the 2 numbers
          }
          if (val.equals("-")) {
            stak.push(num2 - num1);
          }
          if (val.equals("*")) {
            stak.push(num2 * num1);//Multiplies them
          }
          if (val.equals("/")) {
            stak.push(num2 / num1);
          }        
          //counter=-2;               
        }
      } 
    } catch (Exception e) {
      System.out.println("Invalid expression encountered");
      throw new InvalidExpression();
    }
    strVal.close();
    return stak.pop(); // Returns the only value of the stack left the final answer.
  }
  
  /**This will check if the operator is valid.
   * @param ch checks if the operator equals
   * @return if any of them are true. Validtes to ensure no errors.
   */
  public  boolean isOp(String ch) {
    return (ch.equals("+") || ch.equals("-") || ch.equals("*") 
        || ch.equals("/") || ch.equals("^") || ch.equals("(") || ch.equals(")"));
  }
}
