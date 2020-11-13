package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 * 
 *This class is defined to use a stack of symbols for the shunting algorithm.
 */
public class OpStack {
  
  public Stack op_stack;
  private Symbol pop_symbol;
  private Symbol top_symbol;
  
  public OpStack() {
    op_stack = new Stack();
  }

  /**
   * This method is defined to push the operator into the stack.
   * @param plus is the symbol value
   */
  public void push(Symbol plus) {
    Entry val = new Entry(plus);
    op_stack.push(val);
  }

  /**
   * This method is defined to pop the Op from the stack.
   * @return the top value of the stack.
   * @throws BadType
   * @throws EmptyStack if the stack is empty.
   */
  public Object pop() throws BadType, EmptyStack {
    pop_symbol = op_stack.pop().getSymbol();
    return (pop_symbol);
  }

  public boolean isEmpty() {
    return (op_stack.isEmpty());
  }
  
  /**
   * this method is defined to give the top value in the stack
   * @return the top value
   * @throws BadType
   * @throws EmptyStack if the stack is empty
   */
  public Symbol top() throws BadType, EmptyStack {
    top_symbol = op_stack.top().getSymbol();
    return (top_symbol);
  }
}
