package ir.sk.algorithm.stackusage.parsingarithmeticexpression;

import ir.sk.datastructure.stack.ArrayStack;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class ParsePostFix {

    private ArrayStack theArrayStack;
    private String input;

    public ParsePostFix(String s) {
        input = s;
    }

    public int doParse() {
        theArrayStack = new ArrayStack(20); // make new stack
        char ch;
        int j;
        int num1, num2, interAns;
        for (j = 0; j < input.length(); j++) // for each char,
        {
            ch = input.charAt(j); // read from input
            System.out.println("For " + ch);
            theArrayStack.display(); // *diagnostic*
            if (ch >= '0' && ch <= '9') // if it’s a number
                theArrayStack.push((int) (ch - '0')); // push it
            else // it’s an operator
            {
                num2 = theArrayStack.pop(); // pop operands
                num1 = theArrayStack.pop();
                switch (ch) // do arithmetic
                {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                } // end switch
                theArrayStack.push(interAns); // push result
            } // end else
        } // end for
        interAns = theArrayStack.pop(); // get answer
        return interAns;
    }
}
