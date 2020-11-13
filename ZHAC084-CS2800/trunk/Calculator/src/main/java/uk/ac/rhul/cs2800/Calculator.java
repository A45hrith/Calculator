package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 * 
 *This interface calculator is designed for the implementation of both postfix and infix.
 */
public interface Calculator {

  /**
   * @param what
   * @throws InvalidExpression
   * @throws EmptyStack
   * @throws BadType 
   */
  public float evaluate(String what) throws InvalidExpression, EmptyStack, BadType;

}
