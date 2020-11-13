package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This class is created to test the main Stack class whichrepresents the entries.
 */
class Stack_Tdd {
  private Stack stack_main = new Stack();  

  @Before
  void test() {
    Stack stack_main = new Stack();
  }
  
  @Test
  public void Empty_test() {
    Stack stack_it = new Stack();
    assertTrue(stack_main.isEmpty());
  }
  
  @Test
  public void stack_pop() throws EmptyStack, BadType{
    Entry val = new Entry(5);
    stack_main.push(val);
    assertTrue("Checking Pop val", stack_main.pop().getValue() == 5);
    stack_main.push(val);
    assertTrue("checking at negative index",stack_main.pop().getValue() == 5);
  }
  
  @Test
  public void stack_top() throws EmptyStack, BadType{
    assertTrue("Empty",stack_main.size() == 0);
    Entry val1 = new Entry(5);
    Entry val2 = new Entry(6);
    stack_main.push(val1);
    stack_main.push(val2);
    assertTrue("Checking pop and top vals",stack_main.top().getValue() == stack_main.pop().getValue());
    assertFalse("Compare vals",stack_main.top().getValue() != stack_main.top().getValue());
  }
  
  @Test
  public void stack_size() {
    assertTrue("Testinf for empty stack",stack_main.size()==0);
  }

}
