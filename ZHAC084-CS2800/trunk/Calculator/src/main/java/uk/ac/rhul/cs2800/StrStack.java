package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 * 
 *This class is created to reverse an expression as required by the shunting algorithm for evaluation.
 */
public class StrStack {
  
//public Stack StrStack;//check if class stack or of api collection
  
  public Stack stack_str;//type of stack so uses arraylist
  private String pop_str;//May check the type of it either class.string or enum.string
  
  public StrStack() {
    this.stack_str = new Stack();
  }

  /**
   * This method is defined to push the string into the main Stack.
   * @param string is the value which will be pushed.
   */
  public void push(String string) {//Simple process here
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
//This will get the size of the stack at anypoint

  /**
   * This method is defined to pop the val from stack
   * @return the element in stack
   * @throws EmptyStack if the stack is empty.
   */
  public Object pop() throws EmptyStack{
    pop_str = stack_str.pop().getString();
    return(pop_str);
  }
//This method checks if stack is empty

}
