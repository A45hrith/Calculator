package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This test class verifies the the working of the main StrStack class.
 */
class StrStack_Tdd {

  @Test
  void test() throws EmptyStack {
    StrStack init = new StrStack();
    init.push("99");
    init.push("2435679");
    assertFalse("Verifying equality",init.pop() == init.pop());
    assertTrue("Checking if empty",init.isEmpty() == true);
  }

}
