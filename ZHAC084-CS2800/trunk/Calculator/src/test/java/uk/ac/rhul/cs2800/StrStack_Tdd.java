package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This test class verifies the the working of the main StrStack class.
 */
class StrStack_Tdd {

  @Test
  void test() throws EmptyStack {
    StrStack obj = new StrStack();
    obj.push("99");
    obj.push("2435679");
    assertFalse("Verifying equality",obj.pop() == obj.pop());
    assertTrue("Checking if empty",obj.isEmpty() == true);
  }

}
