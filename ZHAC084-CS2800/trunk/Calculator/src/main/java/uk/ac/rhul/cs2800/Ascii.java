package uk.ac.rhul.cs2800;

import java.util.Scanner;
import java.util.function.Consumer;

public class Ascii implements GuiViewInterface {
  private String question;//hold the expression inputted by the user
  
  public static volatile Ascii instance = null;//static volatile change
  
  Observer calc;
  Consumer<OpType> changeType = null; //creates a consumer to be used to chack for exp type.
  CalcModel clcMod  = new CalcModel();
  
  /**This method is used to handle interctions through cmd line.
   * Throws @InvalidExpression if the expression is not valid
   * Throws @BadType if is it anything except numbers and operators
   * Thrwos @EmptyStack if its not balanced expresion
   */
  public void menu() throws InvalidExpression, BadType, EmptyStack {
    Scanner s = new Scanner(System.in);//Takes the user input
    boolean finished = false;//if user finished then use this to check
    help();//Calls the method to print out some helpful info 

    // The order of these checks is critical because hasNext blocks
    while (!finished && s.hasNext()) { //Check that there's input and user hasn't fnished
      String t = s.nextLine();//takes the line

      switch (t.charAt(0)) { //checks the first character to determine execution
        case 'C':
          System.out.println("26");
          //if (calc != null) { //This return null each time, despite observer being assigned one
          System.out.println("28");
          calc.tell();//Tells the observer
          //System.out.println(Cm.evaluate(getQuestion(),Isinfix));
          //}
          break;
        case 'I'://To change expresiion type to infix
          if (changeType != null) {
            changeType.accept(OpType.INFIX);//sets the type
          }
          break;
        case 'P'://To chang the type to postfix
          if (changeType != null) {
            changeType.accept(OpType.POSTFIX);//consumer will change the type
          }
          break;   
        case 'Q':
          System.out.println("Bye");// if user wishes to quit
          finished = true;
          break;
        default:
          question = t;//by defualt whatever input is set to question
          System.out.println("Question set to: " + question);
          //help();
      }
    }
    System.out.println(question);
    s.close();//scanner closed
  }

  //The help info
  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("Please enter type first, followed by expression and finally 'C'!!!");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  P - to change to postfix");
    System.out.println("  I - to change to infix");
    System.out.println("  C - to calculate");
    System.out.println("  Q - to exit");
  }

  
  /**Adds the observer for menu view. initiated from CalcController
  * @param obs takes the observer initiated from CalcController
  * @see GuiViewInterface#addCalcObserver(Observer)
  */
  public void addCalcObserver(Observer obs) {
    System.out.println("Line 72 from ASCII view");
    calc = obs;//No longer will it be null
    //obs.tell();
    System.out.println("SDFSAD");
  }

  //Adds the type infix, postfix
  
  public void addTypeObserver(Consumer<OpType> l) {
    changeType = l;
  }

  //Returns the question, call will be made from calcontroller
  
  public String getQuestion() {
    return question;
  }
  //This will print the answer to the cmd line
  
  public void setAnswer(String a) {
    System.out.println("Answer: " + a);
  }
  

}
