package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This class if defined to verify the working of main OpStack class.
 */
class OpStack_Tdd {

  @Test
  void test() throws EmptyStack, BadType{
    OpStack obj = new OpStack();
    obj.push(Symbol.Plus);
    obj.push(Symbol.Plus);
    assertEquals("Checking if popped values are equal",obj.pop(),obj.pop());
    assertTrue("Checking if Stack is Empty",obj.isEmpty()==true);
  }

}
