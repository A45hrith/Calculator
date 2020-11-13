package uk.ac.rhul.cs2800;
import java.util.Scanner;
/** Class executes if exp is postfix or and infix (converted to postfix through algorithm).
 * @author Aashrith Karise
 *
 */

public class RevPolishCalc implements Calculator {

  private NumStack stack = new NumStack();
  
  /**This method is used to evaluate a postfix expression.
   * Throws @InvalidExpression if the expression is not valid
   * Throws @BadType if is it anything except numbers and operators
   * Thrwos @EmptyStack if its not balanced expresion
   */
  
  public float evaluate(String what) throws InvalidExpression, EmptyStack {
    //Holds the string
    String str = " ";

    Scanner str_val = new Scanner(what);  
    try {
      while (str_val.hasNext()) {
        
        if (str_val.hasNext(".*\\d+.*")) {     
          stack.push((float) Double.parseDouble(str = str_val.next()));
        } else {
          String val = str_val.next();
          float num1 = stack.pop();
          float num2 = stack.pop();
  
          if (val.equals("+")) {
            stack.push(num2 + num1);
          }
          if (val.equals("-")) {
            stack.push(num2 - num1);
          }
          if (val.equals("*")) {
            stack.push(num2 * num1);
          }
          if (val.equals("/")) {
            stack.push(num2 / num1);
          }                     
        }
      } 
    } catch (Exception e) {
      System.out.println("Invalid expression encountered");
      throw new InvalidExpression();
    }
    str_val.close();
    return stack.pop(); 
  }
  
  /**This will check if the operator is valid.
   * @param sy checks if the operator equals
   * @return if any of them are true. Validtes to ensure no errors.
   */
  public  boolean Op_stack(String sy) {
    return (sy.equals("+") || sy.equals("-") || sy.equals("*") 
        || sy.equals("/") || sy.equals("^") || sy.equals("(") || sy.equals(")"));
  }
  
}
