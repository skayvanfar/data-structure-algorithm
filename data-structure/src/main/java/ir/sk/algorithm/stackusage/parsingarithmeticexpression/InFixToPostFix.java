package ir.sk.algorithm.stackusage.parsingarithmeticexpression;

import ir.sk.datastructure.stack.Stack;

/**
 * infix to postfix conversion
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class InFixToPostFix {

    private Stack theStack;
    private String input;
    private String output = "";

    public InFixToPostFix(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new Stack(stackSize);
    }

    public String doTrans() // do translation to postfix
    {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            System.out.println("For " + ch);
            theStack.display(); // *diagnostic*
            switch (ch) {
                case '+': // it’s + or -
                case '-':
                    gotOper(ch, 1); // go pop operators
                    break; // (precedence 1)
                case '*': // it’s * or /
                case '/':
                    gotOper(ch, 2); // go pop operators
                    break; // (precedence 2)
                case '(': // it’s a left paren
                    theStack.push(ch); // push it
                    break;
                case ')': // it’s a right paren
                    gotParen(ch); // go pop operators
                    break;
                default: // must be an operand
                    output = output + ch; // write it to output
                    break;
            } // end switch
        } // end for
        while (!theStack.isEmpty()) // pop remaining opers
        {
            System.out.println("While");
            theStack.display(); // *diagnostic*
            output = output + theStack.pop(); // write to output
        }
        System.out.println("End");
        theStack.display(); // *diagnostic*
        return output; // return postfix
    } // end doTrans()

    //--------------------------------------------------------------
    public void gotOper(char opThis, int prec1) { // got operator from input
        while (!theStack.isEmpty()) {
            char opTop = (char) theStack.pop();
            if (opTop == '(') // if it’s a ‘(‘
            {
                theStack.push(opTop); // restore ‘(‘
                break;
            } else // it’s an operator
            {
                int prec2; // precedence of new op
                if (opTop == '+' || opTop == '-') // find new op prec
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) // if prec of new op less
                { // than prec of old
                    theStack.push(opTop); // save newly-popped op
                    break;
                } else // prec of new not less
                    output = output + opTop; // than prec of old
            } // end else (it’s an operator)
        } // end while
        theStack.push(opThis); // push new operator
    } // end gotOp()

    //--------------------------------------------------------------
    public void gotParen(char ch) { // got right paren from input
        while (!theStack.isEmpty()) {
            char chx = (char) theStack.pop();
            if (chx == '(') // if popped ‘(‘
                break; // we’re done
            else // if popped operator
                output = output + chx; // output it
        } // end while
    } // end popOps()
}
