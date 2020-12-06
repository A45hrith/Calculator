package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 *
 *As the reverse polish evaluation only uses a stack of numeric values, this class is defined to to build the main NumStack class.
 */
class NumStack_Tdd {

  @Test
  void test() throws EmptyStack{
    NumStack obj = new NumStack();
    obj.push(12348);
    obj.push(1359);
    obj.push(123678);
    assertFalse("Checking Empty", obj.pop()==obj.pop());
  }

}
