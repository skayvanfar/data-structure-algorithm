package ir.sk.algorithm.stack.parsingarithmeticexpression;

import ir.sk.datastructure.stack.ArrayStack;

/**
 * infix to postfix conversion
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class InFixToPostFix {

    private ArrayStack theArrayStack;
    private String input;
    private String output = "";

    public InFixToPostFix(String in) {
        input = in;
        int stackSize = input.length();
        theArrayStack = new ArrayStack(stackSize);
    }

    public String doTrans() // do translation to postfix
    {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            System.out.println("For " + ch);
            theArrayStack.display(); // *diagnostic*
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
                    theArrayStack.push(ch); // push it
                    break;
                case ')': // it’s a right paren
                    gotParen(ch); // go pop operators
                    break;
                default: // must be an operand
                    output = output + ch; // write it to output
                    break;
            } // end switch
        } // end for
        while (!theArrayStack.isEmpty()) // pop remaining opers
        {
            System.out.println("While");
            theArrayStack.display(); // *diagnostic*
            output = output + theArrayStack.pop(); // write to output
        }
        System.out.println("End");
        theArrayStack.display(); // *diagnostic*
        return output; // return postfix
    } // end doTrans()

    //--------------------------------------------------------------
    public void gotOper(char opThis, int prec1) { // got operator from input
        while (!theArrayStack.isEmpty()) {
            char opTop = (char) theArrayStack.pop();
            if (opTop == '(') // if it’s a ‘(‘
            {
                theArrayStack.push(opTop); // restore ‘(‘
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
                    theArrayStack.push(opTop); // save newly-popped op
                    break;
                } else // prec of new not less
                    output = output + opTop; // than prec of old
            } // end else (it’s an operator)
        } // end while
        theArrayStack.push(opThis); // push new operator
    } // end gotOp()

    //--------------------------------------------------------------
    public void gotParen(char ch) { // got right paren from input
        while (!theArrayStack.isEmpty()) {
            char chx = (char) theArrayStack.pop();
            if (chx == '(') // if popped ‘(‘
                break; // we’re done
            else // if popped operator
                output = output + chx; // output it
        } // end while
    } // end popOps()
}
