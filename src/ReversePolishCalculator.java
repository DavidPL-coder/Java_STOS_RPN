public class ReversePolishCalculator {
    public int calculate(String expression) {
        if (expression == null || expression.trim().isEmpty())
            throw new IllegalArgumentException("Expression is null or empty");

        Stack stack = new Stack();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(token);
            } else if (isOperator(token)) {
                if (stack.getSize() < 2)
                    throw new IllegalArgumentException("Not enough numbers in expression");

                int b = parseInt(stack.pop());
                int a = parseInt(stack.pop());
                int result = applyOperator(a, b, token);
                stack.push(String.valueOf(result));
            } else {
                throw new IllegalArgumentException("Invalid operator in expression");
            }
        }

        if (stack.getSize() != 1)
            throw new IllegalArgumentException("Not enough operators in expression so stack has more than one number after calculating");

        return parseInt(stack.pop());
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("The given number outside the range of type int");
        }
    }

    private int applyOperator(int a, int b, String operator) {
        try {
            switch (operator) {
                case "+":
                    return Math.addExact(a, b);
                case "-":
                    return Math.subtractExact(a, b);
                case "*":
                    return Math.multiplyExact(a, b);
                case "/":
                    if (b == 0)
                        throw new IllegalArgumentException("Cannot divide by zero");

                    return a / b;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (ArithmeticException ex) {
            throw new ArithmeticException("The calculated values are outside the range of the Int type");
        }
    }
}