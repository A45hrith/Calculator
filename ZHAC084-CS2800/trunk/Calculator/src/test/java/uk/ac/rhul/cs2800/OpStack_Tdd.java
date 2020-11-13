package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This class if defined to verify the working of main OpStack class.
 */
class OpStack_Tdd {

  @Test
  void test() throws EmptyStack, BadType{
    OpStack init = new OpStack();
    init.push(Symbol.Plus);
    init.push(Symbol.Plus);
    assertEquals("Checking equality",init.pop(),init.pop());
    assertTrue("Checking Empty",init.isEmpty()==true);
  }

}
