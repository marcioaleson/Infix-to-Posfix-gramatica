package infixtoprefix;

public class InfixToPostfix extends Stack {

    public InfixToPostfix(int x) {
        super(x);
    }

    /**
     *@return postfixString value
     */
   
    public String InToPost(String infixString) {
        String postfixString = " ";

        for (int index = 0; index < infixString.length(); ++index) {
            char chValue = infixString.charAt(index);
            if (chValue == '(') {
                push('(');
            } else if (chValue == ')') {
                Character oper = peek();
                while (!(oper.equals('(')) && !(isEmpty())) {
                    postfixString += oper.charValue();
                    pop();
                    oper = peek();
                }
                pop();
            } else if (chValue == '+' || chValue == '-') {
                //Stack is empty
                if (isEmpty()) {
                    push(chValue);
                    //current Stack is not empty
                } else {
                    Character oper = peek();
                    while (!(isEmpty() || oper.equals(new Character('(')) || oper.equals(new Character(')')))) {
                        pop();
                        postfixString += oper.charValue();
                    }
                    push(chValue);
                }
            } else if (chValue == '*' || chValue == '/') {
                if (isEmpty()) {
                    push(chValue);
                } else {
                    Character oper = peek();
                    while (!oper.equals(new Character('+')) && !oper.equals(new Character('-')) && !isEmpty()) {
                        pop();
                        postfixString += oper.charValue();
                    }
                    push(chValue);
                }
            } else {
                postfixString += chValue;
            }
        }
        while (!isEmpty()) {
            Character oper = peek();
            if (!oper.equals(new Character('('))) {
                pop();
                postfixString += oper.charValue();
            }
        }
        return postfixString;
    }
}