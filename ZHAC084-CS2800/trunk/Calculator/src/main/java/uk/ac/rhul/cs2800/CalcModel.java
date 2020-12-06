package uk.ac.rhul.cs2800;

/**
 * CalcModel will evaluate if expression is infix or postfix.
 * @author Aashrith Karise
 *
 */
public class CalcModel {

  private Calculator revPolish = new RevPolishCalc();
  private Calculator standard = new StandardCalc();
  private float calcAns;

  /**This method is used to handle the call from CalcController.
   * Throws @InvalidExpression if the expression is not valid
   * Throws @BadType if is it anything except numbers and operators
   * Thrwos @EmptyStack if its not balanced expresion
   * @throws BadType 
   */
  public float evaluate(String expr, boolean infix) throws InvalidExpression, EmptyStack, BadType {
    // This can validate the type
    if (infix) {
      // Process to standard calc
      calcAns = standard.evaluate(expr);//calls standard calculator

    } else { // if post-fix
      calcAns = revPolish.evaluate(expr);//calls revpolish to calculate expression

    }

    return (calcAns);//returns the answer to calCotnroller to dispaly it
  }

}
