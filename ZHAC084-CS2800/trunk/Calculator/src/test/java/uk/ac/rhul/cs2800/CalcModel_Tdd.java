package uk.ac.rhul.cs2800;

/**
 * This test will perform infix and postfix tests.
 * @author Aashrith Karise
 */

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CalcModel_Tdd {

  private CalcModel calcmod = new CalcModel();
  
  /**Sets up the object.
   * @throws java.lang.Exception if any errors creating object.
   */
  @Before //This test initilises the object and checks that there's no errors
  public final void setUp() throws Exception {
    calcmod = new CalcModel();
  }
  
  /**Tests a infix equation and checks the value.
   * @throws InvalidExpression since its not valid
   * @throws EmptyStack   if stack out of elements.
   */
  
  @Test
  void infixTest() throws InvalidExpression, EmptyStack {
    float answer = 0;
    try {
      answer = calcmod.evaluate("2 + 2", true);
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
    assertTrue("Check infix expression",answer == 4.0);
  }
  
  /**Tests a postfix equation and checks the value.
   * @throws InvalidExpression since its not valid
   * @throws EmptyStack   if stack out of elements.
   */
  
  @Test
  void postfixTest() throws InvalidExpression, EmptyStack {
    float answer = 0;
    try {
      answer = calcmod.evaluate("2 2 -", false);
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
    assertTrue("Check postfix expression",answer == 0);
  }

}
