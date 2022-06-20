import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolish {
    public static void main(String[] args) {
        String [] token = {"4","13","5","/","+"};
        System.out.println(evalRPN(token));
    }

    public static int eval(int first, int second , String operator){
        switch (operator){
            case "+":
                return first+second;
            case "-":
                return first-second;
            case "*":
                return first*second;
            case "/":
                return first/second;
        }
        return -1;
    }

    public static int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<String>(){{
           add("+");add("-");add("/");add("*");
        }};
        Stack<String> stack = new Stack<>();
        for (String token : tokens){
            if (operators.contains(token)){
                if (stack.isEmpty() || stack.size() == 1){
                    return -1;
                }else{
                    int second = Integer.parseInt(stack.pop());
                    int first = Integer.parseInt(stack.pop());
                    stack.add(eval(first, second, token) + "");
                }
            }else{
                stack.add(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
