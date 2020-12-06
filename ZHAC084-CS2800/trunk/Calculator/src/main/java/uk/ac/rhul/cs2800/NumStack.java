package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 *
 *This class is built to provide stack of numeric values for reverse polish evaluation.
 */
public class NumStack {
  
  public Stack numStack;//type of stack so uses arraylist
  private float popNum;
  public float push;
  
  /**Creates an object of stack.
   */
  
  public NumStack() {
    this.numStack = new Stack();
  }
  
  /**This method will push the number onto the stack.
   * @param i is the float value
   */

  public void push(float i) {
    numStack.push(new Entry(i)); 
  }
  
  /**This method will pop elements from stack.
   * @return the popped element from the stack
   * @throws EmptyStack if no element on stack, means wrong expression
   */

  public float pop() throws EmptyStack{
    try {
      popNum = numStack.pop().getValue();
    } catch (BadType e) {
      e.printStackTrace();
    }
    return (popNum);   
  }
  
  public boolean isEmpty() {    
    return (numStack.isEmpty());
  }
}
