package uk.ac.rhul.cs2800;

/**
 * @author Aashrith Karise
 *
 *This class is built to provide stack of numeric values for reverse polish evaluation.
 */
public class NumStack {
  
  public Stack num_stk;
  private float poptop;
  public float push;
  
  public NumStack() {
    this.num_stk = new Stack();
  }

  public void push(float i) {
    num_stk.push(new Entry(i));
    
  }

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
