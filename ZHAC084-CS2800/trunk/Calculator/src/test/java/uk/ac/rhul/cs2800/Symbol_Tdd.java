package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
    assertTrue(Symbol.Plus.toString().equals("+"));;
    assertTrue(Symbol.Minus.toString().equals("-"));
    assertTrue(Symbol.Times.toString().equals("*"));
    assertTrue(Symbol.Divide.toString().equals("/"));
    assertFalse(Symbol.Divide.toString().equals(Symbol.Invalid.toString()));
  }
}
