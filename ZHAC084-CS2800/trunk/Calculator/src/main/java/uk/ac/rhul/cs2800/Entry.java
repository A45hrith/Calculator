package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 * 
 *This is the main Entry class which is well defined for setters and getters of different types.
 */
public class Entry {
  
  public float number;
  public Symbol other;
  public String str;
  public Type type;

  /**
   * Verifying if the data type of the integer entered in the calculation is float or not.
   * @param val is passed to confirm the data type.
   */
  public Entry(float val) {
    this.number = val;
    this.type = Type.Number;
  }
  
  /**
   * Verifying if the data type of the symbol entered in the calculation.
   * @param sign is passed to confirm the data type.
   */
  public Entry(Symbol sign) {
    this.other = sign;
    this.type = Type.Symbol;
  }
  
  /**
   * Verifying if there's any other string involved.
   * @param words are passed for confirmation.
   */
  public Entry(String words) {
    this.str = words;
    this.type = Type.String;
  }

  public Type getType() {
    return(type);
    
  }

  /**
   * This method verifies the data type of the integer passed.
   * @return the the data type of the integer involved in calculation
   * @throws BadType if the data type of the entered integer is incorrect.
   */
  public float getValue() throws BadType{
    if (this.type == Type.Number) {
      return (number);
    } else {
      throw new BadType();
    }
  }

  /**
   * This method verifies the data type of the symbol involved in calculation.
   * @return the data type of the symbol
   * @throws BadType if the data type is inappropriate.
   */
  public Symbol getSymbol() throws BadType{
    if (type != Type.Symbol) {
      throw new BadType();
    } else {
      return (this.other);
    }
  }
  
  public String getString() {
    return(str);
  }
  
}
