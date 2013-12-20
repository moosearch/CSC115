/* UVic CSc 115 Winter 2009 & Fall 2012- Assignment #4
 *Wesley Chow
 *V00727646
 *Program Description: Converts infix expressions to postfix expressions
 *and evaluates them as postfix. Uses very strict format.
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Represent a simple arithmetic expression consisting of integers an operators.
 * Support conversion from infix to postfix expression forms.
 * Support interpretation (i.e. compute the value) of infix expressions.
 */
public class Expression {

  // Operator "tokens" used by expressions:
  static final String PLUS   = "+";
  static final String MINUS  = "-";
  static final String TIMES  = "*";
  static final String DIVIDE = "/";
  static final String OPEN   = "(";
  static final String CLOSE  = ")";

  // The tokens held by this expression:
  private final List<String> tokens = new ArrayList<String>();

  /** Initialize an empty expression with no tokens. */
  public Expression() { }

  /** Initialize an expression by parsing tokens from a string of text. */
  public Expression(String text)
    throws ExpressionFormatException
  {
    this(new Scanner(text)); //: make a Scanner over text and transfer to the other constructor
  }

  /** Initialize an expression by reading from a scanner. */
  public Expression(Scanner input)
    throws ExpressionFormatException
  {
    while ( input.hasNext() ) {
      this.append(input.next());
    }
  }

  /** Add a new token to the end of this expression. */
  public void append(String token)
    throws ExpressionFormatException
  {
    token = token.trim(); //: remove any spaces, tabs, etc. at front or back

    if ( isOperator(token) || isBracket(token) || isValue(token) )
      tokens.add(token);
    else
      throw new ExpressionFormatException("invalid token: "+token);
  }

  /** Convert this expression to a single string of text. */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for ( String token : tokens ) {
      builder.append(token);
      builder.append(' ');
    }
    return builder.toString().trim();
  }

  /**
   * Assuming this expression is an infix expression, get an equivalent postfix expression.
   * NOTE: this expression is not modified!
   */
  public Expression toPostfix()
    throws ExpressionFormatException
  {
    // FIXME
      LinkedStack<String> storage = new LinkedStack<String>();
      Expression postfixExp = new Expression();
      //run through the whole string, size() is part of the ArrayList class
      for(int i=0; i<tokens.size();i++){

          String ch = tokens.get(i);

              //if token is operand (ie. a value)
              if(isValue(ch)){
                  postfixExp.append(ch);
                  //System.out.println("value "+ch);
              }//end if value

              //if token is an operator
              if(isOperator(ch)){
                  //System.out.println("operator "+ch);
                  while(storage.isEmpty()==false && storage.top().equals(OPEN)==false){
                      /*while stack!=empty and top item != "(", append
                      operators as long as "ch" has lower precedence;
                      while loop will terminate when either the mentioned
                      fails to satisfy or the while loop conditions fail*/
                      if(precedence(ch)<=precedence(storage.top()) ){
                          postfixExp.append(storage.pop());
                      }else{
                          break;
                      }
                  }
                  storage.push(ch);
              }//end if operator

              //if token is either a closed or open bracket
              if(isBracket(ch)){
                  //if open bracket
                  if(ch.equals(OPEN)){
                      //System.out.println("bracket "+ch);
                      storage.push(ch);
                  }else{ //if closed bracket
                          //System.out.println("value "+ch);
                          String checker ="";
                          if(storage.isEmpty()==false){
                              checker = storage.top();
                          }else{
                              throw new EmptyStackException("Empty Stack");
                          }
                          //time to pop stuff out of stack, add to expression
                          while(checker.equals(OPEN)==false){
                              if(storage.isEmpty()==false){
                                  postfixExp.append(storage.pop());
                                  try{
                                      checker = storage.top();
                                  }catch (NullPointerException e){
                                      System.out.println("Empty Stack");
                                  }
                              }else{
                                  throw new EmptyStackException("Stack is empty!");
                              }
                          }
                          storage.pop(); //pop off the OPEN bracket
                  }
              }//end if bracket

      }//end of for

      //pop remaining items off stack if there are any
      while(storage.isEmpty()==false){
          postfixExp.append(storage.pop());
      }
      return postfixExp;
  }

  /**
   * Assuming this expression is in postfix form, evaluate the expression.
   */
  public int evaluateAsPostfix()
    throws ExpressionFormatException
  {
      //initialise stack and a string for operations done with 2 operands
      LinkedStack<String> storage = new LinkedStack<String>();
      String result ="";
      for(int i=0; i<tokens.size();i++){
          String ch = tokens.get(i);
          //if ch is a number, push it into stack
          if(isValue(ch)){
              storage.push(ch);
              //System.out.println("pushing "+ch+" "+i+"th");
          //if ch isn't a number
          }else{
              //initialise variables
              String operand2 = "";
              String operand1 = "";
              int itemCount = 0;
              /*pop two things off one by one; if itemCount != 2, then
              there is something wrong w/ expression*/
              if(!storage.isEmpty()){
                  operand2 = storage.pop();
                  itemCount++;
              }
              if(!storage.isEmpty()){
                  operand1 = storage.pop();
                  itemCount++;
              }
              if(itemCount!=2){
                  String errorMsg = "Postfix expression is invalid.";
                  errorMsg+=" Check your infix expression again for any missing brackets.";
                  throw new ExpressionFormatException(errorMsg);
              }

              /*Use parseint from Integer class to convert operands, use conditions for
              each type of operation to calculate the new value, then convert back to string*/
              if(ch.equals(PLUS)){
                  int sum = Integer.parseInt(operand1)+Integer.parseInt(operand2);
                  result=Integer.toString(sum);
              }else if(ch.equals(MINUS)){
                  int difference = Integer.parseInt(operand1)-Integer.parseInt(operand2);
                  result=Integer.toString(difference);
              }else if(ch.equals(TIMES)){
                  int product = Integer.parseInt(operand1)*Integer.parseInt(operand2);
                  result=Integer.toString(product);
              }else if(ch.equals(DIVIDE)){
                  int quotient = Integer.parseInt(operand1)/Integer.parseInt(operand2);
                  Integer.toString(quotient);
              }else{
                  throw new ExpressionFormatException("Invalid symbol used in expression");
              }
              storage.push(result);

          }//end if/else statement
      }//end for
      int answer = Integer.parseInt(storage.pop());
      return answer;
  }

  /**
   * Determine the precedence of an operator.
   * @return 0 for + and -, 1 for * and /
   */
  static int precedence(String op) {
    if ( op.equals(PLUS) || op.equals(MINUS) )
      return 0;

    if ( op.equals(TIMES) || op.equals(DIVIDE) )
      return 1;

    throw new IllegalArgumentException("Not an operator: "+op);
  }

  /** Is the given token a valid operator? */
  public static boolean isOperator(String token) {
    return token.equals(PLUS) || token.equals(MINUS) || token.equals(TIMES) || token.equals(DIVIDE);
  }

  /** Is the given token an opening or closing bracket (parenthesis)? */
  public static boolean isBracket(String token) {
    return token.equals(OPEN) || token.equals(CLOSE);
  }

  /** Is the given token an integer value? */
  public static boolean isValue(String token) {
    try {
      Integer.parseInt(token);
      return true; //: success!
    }
    catch ( NumberFormatException ex ) { // => token was not a number!
      return false;
    }
  }
}
