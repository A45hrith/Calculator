package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 *This test ensures that the type enums are created and are working.
 */
class Type_Tdd {
  /**
   * Running test to verify each enum in Type
   */
  @Test
  public void testType() {
    assertTrue("Check Number",Type.Number !=null);
    assertFalse("Check Number",Type.String ==null);
  }
}
