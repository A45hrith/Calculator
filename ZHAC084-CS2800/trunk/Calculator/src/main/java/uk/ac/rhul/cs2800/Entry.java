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
  public Entry(String str) {
    this.str = str;
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
  
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(number);
    result = prime * result + ((other == null) ? 0 : other.hashCode());
    result = prime * result + ((str == null) ? 0 : str.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  /* Method used to check no duplicates object exists
   * 
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    if (Float.floatToIntBits(number) != Float.floatToIntBits(other.number)) {
      return false;
    }
    if (this.other != other.other) {
      return false;
    }
    if (str == null) {
      if (other.str != null) {
        return false;
      }
    } else if (!str.equals(other.str)) {
      return false;
    }
    if (type != other.type) {
      return false;
    }
    return true;
  }
  
}
