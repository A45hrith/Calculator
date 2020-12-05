package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This class is created to see all the entry types being entered in the main Entry class during calculation.
 */
class Entry_Tdd {
  
  /**First test is used to check if objects can be created.
   *@throws Exception if an error occurs while creating objects with differnt types.   
   */
  @Before 
  void setUp() throws Exception { 
    new Entry(5); 
    new Entry(Symbol.Plus);
    new Entry(Symbol.Minus);
  }
  /**Method created to test different types.
   */
  
  @Test
  void testTypes() {
    Entry num = new Entry(2);
    num.getType();//Tested and failed as there's no getType method in Entry
    //Error ecnocuntered during debugging, so had to print values before refactoring code
    System.out.println(num.getType());//Printed to see if it works as intended
    System.out.println(Type.Number);// Another check before comparing in assertequals.
    assertEquals("To check if the types are equal?",num.getType(),Type.Number);

  }
  /**Method below is used to test integer data type works right.
   * @throws BadType exception is thrown, if differnt types are compared.
   */

  @Test
  void testNumberValues() throws BadType {
    Entry num1 = new Entry(5);
    // Test Passed with hard coded value of 5
    assertTrue("Assessing method return", num1.getValue() == 5);
    Entry num2 = new Entry('3');// initialisation failed, so added validaton for just numbers
    // Failed, added exception and if statement to handle just numbers
    assertFalse("Different data type returns", num2.getValue() == '+');
    // Assertion returns true as expected
    assertFalse("Check if two values equal", num1.getValue() == num2.getValue());
  }
  /**Method below is used to check symbol type works right.
   * @throws BadType exception is thrown, if differnt types are compared.
   */

  @Test
  void testSymbolValues() throws BadType {
    Entry symbol1 = new Entry(Symbol.Times);// Test fails with no constructor accepting symbol
    // Constructor and getSymbol now active in class Entry
    assertTrue("Check symbols equal", symbol1.getSymbol() == Symbol.Times);
    Entry symbol2 = new Entry(Symbol.Plus);
    assertFalse("Assesses sign error", symbol2.getSymbol() == Symbol.Divide);//Error, Debugger- 
    //reports symbol2 cannot be resolved
    //By using Eclipse perspective tools, the error is resolved and test now passess
    

  }
}
