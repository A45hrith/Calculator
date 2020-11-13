package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 *
 *As the reverse polish evaluation only uses a stack of numeric values, this class is defined to to build the main NumStack class.
 */
class NumStack_Tdd {

  @Test
  void test() throws EmptyStack{
    NumStack init = new NumStack();
    init.push(12348);
    init.push(1359);
    init.push(123678);
    assertFalse("Checking Empty", init.pop()==init.pop());
  }

}
