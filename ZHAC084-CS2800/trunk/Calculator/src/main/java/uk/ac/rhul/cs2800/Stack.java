package uk.ac.rhul.cs2800;

import java.util.ArrayList;

/**
 * @author Aashrith Karise
 * 
 *This class is created to maintain the array of stack
 */
public class Stack {
  
  private int i = 0;
  private ArrayList<Entry> enter = new ArrayList<Entry>();

  /**
   * This method is defined to verify if the stack is empty.
   * @return
   */
  public boolean isEmpty() {
    return (i==0);
  }

  public int size() {
    return (this.i);
  }

  /**
   * This method is defined to push the elements into the stack.
   * @param digit is passed which is the value of the type of entity
   */
  public void push(Entry digit) {
    enter.add(i,digit);
    i++;
  }

  /**
   * This method is defined to pop the top element in the stack.
   * @return the top value of the stack
   * @throws EmptyStack if the index's value is less than 0
   */
  public Entry pop() throws EmptyStack{
    if (i > 0) {
      i--; 
      return (enter.remove(i));           
    } else if (i == 0) {
      System.out.println("Print check");
      return (enter.remove(i));
    } else {
      throw new EmptyStack();
    }
  }

  /**
   * This method is defined to give the top value of the stack
   * @return the top value in the stack
   * @throws EmptyStack if the index's value is less than 0
   */
  public Entry top() throws EmptyStack{
    if (i >= 0) {
      return (enter.get(i - 1));
    } else {
      throw new EmptyStack();
    }
  }

}
