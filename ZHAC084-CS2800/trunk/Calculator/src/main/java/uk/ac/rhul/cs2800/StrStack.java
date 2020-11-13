package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 * 
 *This class is created to reverse an expression as required by the shunting algorithm for evaluation.
 */
public class StrStack {
  
  public Stack stack_str;
  private String pop_str;
  
  public StrStack() {
    this.stack_str = new Stack();
  }

  /**
   * This method is defined to push the string into the main Stack.
   * @param string is the value which will be pushed.
   */
  public void push(String string) {
    Entry val = new Entry(string);
    stack_str.push(val);
    
  }

  /**
   * This method is defined to verify if the stack is empty or not.
   * @return if the stack is empty or not
   */
  public boolean isEmpty() {
    return(stack_str.isEmpty());
  }

  /**
   * This method is defined to pop the val from stack
   * @return the element in stack
   * @throws EmptyStack if the stack is empty.
   */
  public Object pop() throws EmptyStack{
    pop_str = stack_str.pop().getString();
    return(pop_str);
  }

}
