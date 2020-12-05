package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 *
 *This class is built to provide stack of numeric values for reverse polish evaluation.
 */
public class NumStack {
  
  public Stack num_stk;//type of stack so uses arraylist
  private float poptop;
  public float push;
  
  /**Creates an object of stack.
   */
  
  public NumStack() {
    this.num_stk = new Stack();
  }
  
  /**This method will push the number onto the stack.
   * @param i is the float value
   */

  public void push(float i) {
    num_stk.push(new Entry(i)); 
  }
  
  /**This method will pop elements from stack.
   * @return the popped element from the stack
   * @throws EmptyStack if no element on stack, means wrong expression
   */

  public float pop() throws EmptyStack{
    try {
      poptop = num_stk.pop().getValue();
    } catch (BadType e) {
      e.printStackTrace();
    }
    return (poptop);   
  }
  
  public boolean isEmpty() {    
    return (num_stk.isEmpty());
  }
}
