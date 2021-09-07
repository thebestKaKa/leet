package algorithms;

import algs4.Stack;

public class Evaluation {
    //算数表达式求值
    public static int evaluation(String s){
        Stack<Character> opt = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(');
            else if (cur == '+') opt.push(cur);
            else if (cur == '-') opt.push(cur);
            else if (cur == '*') opt.push(cur);
            else if (cur == '/') opt.push(cur);
            else if (cur == ')'){
                char operation = opt.pop();
                int a = val.pop();
                int b = val.pop();
                if (operation == '+') val.push(a + b);
                else if (operation == '-') val.push(a - b);
                else if (operation == '*') val.push(a * b);
                else if (operation == '/') val.push(a / b);
            }
            else val.push(Integer.parseInt(String.valueOf(cur)));
        }
        return val.pop();
    }

    public static void main(String[] args) {
        String s = "(1+((2+3)*(4*5)))";
        System.out.println(evaluation(s));
    }
}
