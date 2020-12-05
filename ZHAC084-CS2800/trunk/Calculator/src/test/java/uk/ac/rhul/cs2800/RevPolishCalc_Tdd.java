package uk.ac.rhul.cs2800;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Aashrith Karise
 * 
 *This test class is created to perform tests for the main reverse polish class.
 */
public class RevPolishCalc_Tdd {
  private Calculator calc;
  private static final  float rnd = 0.01f;
 
  @Before
  public final void Initial() throws Exception {
    calc = new RevPolishCalc();
  }
  
  /**
   * This method is also designed to test an invlaid expression when passed.
   * @throws InvalidExpression when invalid value is passed
   * @throws EmptyStack when the stack is empty
   * @throws BadType 
   */
  @Test
  public final void One_Num() throws InvalidExpression, EmptyStack, BadType {
    assertEquals("Trying an integer", 0, calc.evaluate("0"), rnd);
    assertEquals("Trying an integer", 5, calc.evaluate("5"), rnd);
  }
  
  /**Tests an invalid expression.
   * @throws InvalidExpression since its not valid
   * @throws EmptyStack if stack out of elements
   * @throws BadType 
   */
  public final void Two_Num() throws InvalidExpression, EmptyStack, BadType {
    try {
      //This should throw an invalid experession error
      assertEquals("Checking for invalid expression",calc.evaluate("0 0"),InvalidExpression.class);
    } catch (final InvalidExpression e) {
      fail("The expression is not a valid expression" + e);
    }
  }
  
  
  /**
   * This method tests the calculation of a postfix expression.
   * @throws InvalidExpression when invalid value is passed
   * @throws EmptyStack when the stack is empty
   * @throws BadType 
   */
  @Test
  public void One_Test() throws InvalidExpression, EmptyStack, BadType {
    String test = "5 6 7 + *";
    float value = calc.evaluate(test);
    System.out.println(calc.evaluate(test));
    assertTrue("Simple expression calculation",value == 65.0);
    
  }
  
  /**
   * This method tests tests to evaluate a complex expression and verifies if the outpus is correst or not.
   * @throws InvalidExpression when invalid value is passed
   * @throws EmptyStack when the stack is empty
   * @throws BadType 
   */
  @Test
  public void Two_Test() throws InvalidExpression, EmptyStack, BadType {
    String test = "3 3 + 6 2 / + 7 - 4 / 9 *";
    float value = calc.evaluate(test);
    System.out.println(calc.evaluate(test));
    assertTrue(" Complex expression calculation",value == 4.5);
  }
  

}