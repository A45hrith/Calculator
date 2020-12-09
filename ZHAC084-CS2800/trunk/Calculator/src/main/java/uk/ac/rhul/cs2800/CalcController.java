package uk.ac.rhul.cs2800;

import java.awt.EventQueue;

public class CalcController {
  
  CalcModel model = new CalcModel();//creates calcmodel object
  GuiView view = new GuiView();//creates guiview object to deal with interactions in GUI.
  Ascii asci = new Ascii();  //For menu line interactions.
  private boolean isInfix = true;//One's value can be used to determine the expression type

  /**The constructor will handle all observer activities.
   * @param v of type guiinterface that will be passed in to it
   */
  public CalcController(GuiViewInterface v) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        if (System.console() == null) { //to check if it's a console or gui
          System.out.println("I am a gui");
          try {
            //view = (GuiView) v;
            view = GuiView.getInstance();//gets the instance of it
            v.addCalcObserver(null);
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          System.out.println("I am nt a gui");
          //This will run programs run by cmd line
          asci.addCalcObserver(null);
          try {
            asci.menu();
          } catch (InvalidExpression e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (BadType e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (EmptyStack e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        } 
      }
    });
  }

  
  /**This method is usde to calcualte the answer to the expression.
   * Throws @InvalidExpression if the expression is not valid
   * Throws @BadType if is it anything except numbers and operators
   * Thrwos @EmptyStack if its not balanced expresion
   */
  public void calculate() throws InvalidExpression, BadType, EmptyStack {
    if (System.console() != null) { //if it's  not null then console is running
      System.out.println("Console's running");
      //Below line will calculate the answer by making call to calcmodel.
      asci.setAnswer(Float.toString(model.evaluate(asci.getQuestion(), isInfix)));
    } else {
      //calculates if it's gui and makes call to the guiview
      String str = Float.toString(model.evaluate(view.getExpression(), isInfix));
      view.setAnswer(str);//Sets the answer
    }

    
  }

}
