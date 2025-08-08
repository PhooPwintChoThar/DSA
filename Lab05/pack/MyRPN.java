package Lab05.pack;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_671755 {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        MyStack671755<Double> stack = new MyStack671755<>();
        StringTokenizer tokenizer = new StringTokenizer(rpn);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        return  -1.111111;
                }
            }
        }

        return stack.pop();
    }
}
