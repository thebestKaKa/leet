package leet1_100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leet20 {
    public static boolean isValid(String s) {
        //判断括号合法性
        Map<Character,Character> map = new HashMap<Character, Character>(){{
            put('{','}'); put('[',']'); put('(',')'); put('?','?');
        }};

        LinkedList<Character> stack = new LinkedList<>(){{
            add('?');
        }};
        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.addLast(c);
            }
            else if(c!=map.get(stack.removeLast())){
                return false;
            }
        }
        return stack.size()==1;
    }

    public static void main(String[] args) {
        System.out.print(isValid("({)}"));
        System.out.print(isValid("(())"));
        System.out.print(isValid("([]]"));
    }
}
