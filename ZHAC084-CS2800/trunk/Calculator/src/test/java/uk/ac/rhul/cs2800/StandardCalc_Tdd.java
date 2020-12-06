package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**This tdd test is for infix expression and tests is done to ensure it works right.
 * @author Aashrith Karise
 *
 */

class StandardCalc_Tdd {

private Calculator calculator;
  
  //The value by which the answer can differ
  private static final float valDiff = 0.01f;
  
  @BeforeEach //This test initilises the object and checks that there's no errors
  public final void setUp() throws Exception {
    calculator = new StandardCalc();
  }
  
  /**It will check the bases check (empty expression) and the errow thrown.
   * 
   * @throws EmptyStack if stack out of elements.
   * @throws BadType 
   */
  @Test//Checks that thrown error is invalidexpression
  public final void testEmpty() throws EmptyStack, BadType {
    try {
      calculator.evaluate("");
    } catch (InvalidExpression e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (EmptyStack e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (BadType e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  
  /**This will check to see a digit.
   * @throws EmptyStack if stack out of elements.
   * @throws BadType 
   */
  @Test
  public final void singleNum() throws EmptyStack, BadType {
    final float onenum = 9;
    final String onenumStr = String.valueOf(onenum);
    try {
      assertTrue("Trying an integer", onenum == calculator.evaluate(onenumStr));
    } catch (final InvalidExpression e) {
      fail("Could not see " + onenumStr + "as a valid expression: " + e);
    }
  }
  
  /**This will test to see if an arbitrary number can be evaluated.
   * 
   * @throws EmptyStack  if stack out of elements.
   * @throws Exception 
   */
  @Test
  public final void twoDigit() throws EmptyStack, Exception {
    final float what = 52;
    final String whatStr = String.valueOf(what);
    try {          
      assertTrue("Trying an integer", what == calculator.evaluate(whatStr));
    } catch (final InvalidExpression e) {
      fail("Could not see " + whatStr + "as a valid expression: " + e);
    }
  }
  

  /**
   * This test invloves the use of brackets and use of other symbols.
   * @throws EmptyStack if wrong expression has been passed
   * @throws BadType 
   */

  @Test//Simple expression test
  public void testOne() throws InvalidExpression, EmptyStack, BadType {
    String what = "( 53 + 2 ) - 43"; 
    String onenum = "( 3 + 5 ) * 8";
    assertTrue("Check the answer of the expression",calculator.evaluate(what) == 12.0);
    assertTrue("Check the answer of the expression",calculator.evaluate(onenum) == 64.0);
  }
  
  /**
   * This final test is all about the most complicated expression evaluation.
   * @throws EmptyStack if runs out of stack, in otherwords, invalid expression input.
   * @throws BadType 
   */
 
  @Test
  public void testTwo() throws InvalidExpression, EmptyStack, BadType {
    String what = "( 2 * 4 ) + 5 - 6"; 
    assertFalse("Complex expression test", calculator.evaluate(what) == 10.0);
    assertEquals("Simple expression", 5, calculator.evaluate("3 + 2"),valDiff);
    assertEquals(" Multiple brackets", 9, calculator.evaluate(" 3 + 2 + 4"),valDiff);
    assertEquals("Complicated expression", 15,calculator.evaluate("( 3 + 2 ) * ( 2 + 1 )"),valDiff);
  }
}
