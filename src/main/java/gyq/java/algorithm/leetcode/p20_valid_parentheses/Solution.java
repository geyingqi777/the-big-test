package gyq.java.algorithm.leetcode.p20_valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/valid-parentheses/
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 括号对应关系的配置
     */
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    public boolean isValid(String s) {
        // 题目入参说明
        // 1 <= s.length <= 104 
        // s 仅由括号 '()[]{}' 组成
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character value = map.get(c);
            if (value != null) {
                // 这个时候是左括号
                stack.push(c);
            } else {
                // 遇到右括号,栈为空,无效
                if (stack.size() == 0) {
                    return false;
                }
                // 这个时候是右括号
                Character pop = stack.pop();
                // 得到当前栈顶的左括号对应的右括号
                Character right = map.get(pop);
                if (!Objects.equals(right, c)) {
                    // 如果和当前右括号不相同,就是无效的
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
