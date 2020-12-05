package uk.ac.rhul.cs2800;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This class is created to test the main Stack class whichrepresents the entries.
 */
public class Stack_Tdd {

  private Stack stack1 = new Stack();

  @Before
  public void setup() {
    new Stack();
  }

  @Test
  public void testEmpty() {
    new Stack();
    assertTrue(stack1.isEmpty());
  }

  @Test
  public void testStackSize() {
    //Test below fails as size() method is not created
    assertTrue("Check for an empty stack",stack1.size() == 0);
    //size method created in class Stack
    //Test passes with a hard coded value of 0.
    assertTrue("Check for an empty stack",stack1.size() == 0);
  }
  /** Test below is used to check the pop() method and array IndexOutOfBound.
   * @throws BadType error if an equality is performed with differnt data types
   * @throws EmptyStack is thrown, if a pop() or top() is used at empty stack
   */
  
  @Test
  public void testStackPop() throws BadType, EmptyStack {
    //push method created in class stack
    Entry value = new Entry(5);
    stack1.push(value);//Test passes
    //Test passes with hardcoded value of 5.
    assertTrue("To check if popped value equals",stack1.pop().getValue() == 5);
    stack1.push(value);//Test passes
    //Test failed. Added validity checks to ensure it handles index <0.
    assertTrue("Check to see it fails at index=-1",stack1.pop().getValue() == 5);
  }
  /** Test below is used to improve the top() and toString() method.
   * @throws BadType error if an equality is performed with differnt data types
   * @throws EmptyStack is thrown, if a pop() or top() is used at empty stack
   */
  
  @Test
  public void testStackTop() throws BadType, EmptyStack {
    assertTrue("Stack is empty",stack1.size() == 0);//Initial check to see stack is empty
    Entry value2 = new Entry(5);
    Entry value3 = new Entry(6);
    stack1.push(value2);//First value pushed to the stack
    stack1.push(value3);// value pushed. Added new top() method (seek value) to class Stack.
    System.out.println(stack1.toString());
    System.out.println(stack1.top().getValue());//Printed to check it works right
    assertFalse("Compare stack values",stack1.top().getValue() != stack1.top().getValue());
    //58--> Checked to see that values don't equal and the method doesnt pops.
    assertTrue("Check top and popped values",stack1.top().getValue() == stack1.pop().getValue());
    //59--> Similar test, done to check top() and pop() methods.


  }
}
