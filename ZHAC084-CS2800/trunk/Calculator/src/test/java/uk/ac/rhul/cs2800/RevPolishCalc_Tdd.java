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
  /**
   * The object to be tested of type calculator.
   */
  private Calculator calc;
  
  private static final  float rnd = 0.01f;
 
  @Before //This test initilises the object and checks that there's no errors
  public final void setUp() throws Exception {
    calc = new RevPolishCalc();
  }
  
  /** Tests a single number.
   * @throws EmptyStack EmptyStack if stack out of elements.
   * @throws InvalidExpression InvalidExpression since its not valid.
   */
  @Test
  public final void singleNumber() throws InvalidExpression, EmptyStack {
    try {
      assertEquals("Trying an integer", 0, calc.evaluate("0"), rnd);
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
    try {
      assertEquals("Trying an integer", 5, calc.evaluate("5"), rnd);
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
  
  /**Tests an invalid expression.
   * @throws InvalidExpression since its not valid
   * @throws EmptyStack if stack out of elements
   */
  public final void twoNums() throws InvalidExpression, EmptyStack {
    try {
      //This should throw an invalid experession error
      try {
        assertEquals("Checking for invalid expression",calc.evaluate("0 0"),InvalidExpression.class);
      } catch (EmptyStack e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (BadType e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (final InvalidExpression e) {
      fail("The expression is not a valid expression" + e);
    }
  }
  
  
  /**Tests a basic postfix expression.
   * @throws InvalidExpression since its not valid
   * @throws EmptyStack if stack out of elements
   */
  
  @Test//Easier test with simple expression
  public void testOne() throws InvalidExpression, EmptyStack {
    //fail("Not yet implemented");

    String test = "4 5 7 + -";
    float value = 0;
    try {
      value = calc.evaluate(test);
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
    try {
      System.out.println(calc.evaluate(test));
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
    assertTrue("Simple expression calculation",value == -8.0);
    
  }
  
  /**Tests a complex postfix equation and checks the value.
   * @throws InvalidExpression since its not valid
   * @throws EmptyStack   if stack out of elements.
   */
  
  
  @Test//Complex expression to calculate. Answer should be 1.5.
  public void testTwo() throws InvalidExpression, EmptyStack {
    String test = "5 8 + 2 4 / 9 * - 7 -";
    float value = 0;
    try {
      value = calc.evaluate(test);
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
    try {
      System.out.println(calc.evaluate(test));
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
    assertTrue(" Complex expression calculation",value == 1.5);
    //Both test passess so testing for Revpolish completed.
  }
}