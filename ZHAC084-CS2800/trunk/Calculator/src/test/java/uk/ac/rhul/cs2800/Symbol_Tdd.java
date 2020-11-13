package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 * This test class verifies if enums in the main Symbol class works or not.
 *
 */
public class Symbol_Tdd {

  /**
   * Performing JUnit tests to verify the working of enum for every Symbol
   */
  @Test
  public void Symbol_test() {
    
    assertFalse(Symbol.Plus.toString().equals("+"));;
    assertFalse(Symbol.Minus.toString().equals("-"));
    assertFalse(Symbol.Times.toString().equals("*"));
    assertFalse(Symbol.Divide.toString().equals("/"));
    assertFalse(Symbol.Left_Bracket.toString().equals("("));
    assertFalse(Symbol.Right_Bracket.toString().equals(")"));
    assertFalse(Symbol.Divide.toString().equals(Symbol.Invalid.toString()));
    
  }

}
