/* Example use of an expression evaluator.
 * Reads an expression from the first command line argument,
 * converts the expression from infix to postfix, and evaluates
 * the expression in postfix form.
 */

public class Calculator {

  public static void main(String[] args)
    throws ExpressionFormatException
  {
    Expression e1 = new Expression( args[0] );
    System.out.println("Infix: "+ e1 );
    System.out.println("Postfix: "+ e1.toPostfix() );
    System.out.println("Answer: "+ e1.toPostfix().evaluateAsPostfix() );
  }

}
