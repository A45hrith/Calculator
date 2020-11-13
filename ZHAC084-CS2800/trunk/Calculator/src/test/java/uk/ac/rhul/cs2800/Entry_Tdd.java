package uk.ac.rhul.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Aashrith Karise
 * 
 *This class is created to see all the entry types being entered in the main Entry class during calculation.
 */
class Entry_Tdd {
  
  
  /**
   * This test is initiated to verify if objects can be created or not.
   * @throws Exception if an object of different data type is being created.
   */
  @Before
  void initial() throws Exception{
    Entry number = new Entry(5);
    Entry plus = new Entry(Symbol.Plus);
    Entry minus = new Entry(Symbol.Minus);
  }
  

  /**
   * This test is initiated to test different types.
   */
  @Test
  void Types_test() {
    Entry number = new Entry(2);
    number.getType();
    assertEquals("Types of numbers",number.getType(),Type.Number);
  }


  /**
   * This test is initiated to verify the the data types of the integers entered into the main Entry class.
   * @throws BadType if the data type entered is different.
   */
  @Test
  void number_test() throws BadType{
    Entry number1 = new Entry(5);
    assertTrue("1st number returns",number1.getValue()==5);
    Entry number2 = new Entry('1');
    assertFalse("Different data type returns",number2.getValue()=='+');
    assertFalse("Equal values",number1.getValue()==number2.getValue());
  }
  
  /**
   * This test is initiated to verify the data types of the symbol entered for calculation.
   * @throws BadType if the symbol type is invalid or unknown.
   */
  @Test
  void symbol_test() throws BadType{
    Entry symbol1 = new Entry(Symbol.Plus);
    assertTrue("addition",symbol1.getSymbol() == Symbol.Plus);
    Entry symbol2 = new Entry(Symbol.Times);
    assertFalse("times",symbol2.getSymbol()==Symbol.Minus);
  }

}
