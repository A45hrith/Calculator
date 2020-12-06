package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 * 
 * This is the main Symbol enumeration class holding all the required symols involved in calculations
 *
 */
public enum Symbol {

  Plus('+'),
  Minus('-'),
  Times('*'),
  Divide('/'),
  Left_Bracket('('),
  Right_Bracket(')'),
  Invalid('$');
  
  /**
   * Creating a public primitive type - char for the above symbols
   */
  public char calculation;

  Symbol(char calc) {
    this.calculation = calc;
  }
  
  /**
   * @return a string which is converted from char.
   */
  public char toChar() {
    return (this.calculation);
  }
  
  public String toString() {
    return (Character.toString(calculation));
  }
}
