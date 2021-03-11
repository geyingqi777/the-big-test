package gyq.java.algorithm.leetcode.p71_simplify_path;

import java.util.ArrayList;
import java.util.List;

/**
 * 简化路径
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/simplify-path/
 */
public class Solution {
    /**
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * <p>
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
     * <p>
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："/home/"
     * <p>
     * 输出："/home"
     * <p>
     * 解释：注意，最后一个目录名后面没有斜杠。
     * <p>
     * 示例 2：
     * <p>
     * 输入："/../"
     * <p>
     * 输出："/"
     * <p>
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     * <p>
     * 示例 3：
     * <p>
     * 输入："/home//foo/"
     * <p>
     * 输出："/home/foo"
     * <p>
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * <p>
     * 示例 4：
     * <p>
     * 输入："/a/./b/../../c/"
     * <p>
     * 输出："/c"
     * <p>
     * 示例 5：
     * <p>
     * 输入："/a/../../b/../c//.//"
     * <p>
     * 输出："/c"
     * <p>
     * 示例 6：
     * <p>
     * 输入："/a//b////c/d//././/.."
     * <p>
     * 输出："/a/b/c"
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        // 思路: 用正则替换, 这里需要用到正则语法里面的零宽断言
        // /. 当前路径,替换成"/", 这里用了负向零宽断言
        // (?!exp):零宽度负预测先行断言，断言此位置的后面不能匹配表达式exp
        path = path.replaceAll("\\/\\.(?!([\\.]|[^\\/]))", "/");
        // /..在路径行首,直接换成/
        path = path.replaceAll("^\\/\\.\\.(?!([\\.]|[^\\/]))", "/");
        // 多个/////,替换成一个/
        path = path.replaceAll("\\/+", "\\/");
        int lengthBefore = path.length();
        while (true) {
            // 循环逐个替换
            // /..上一级目录, 连到上一级的路径替换成"/"
            path = path.replaceFirst("\\/[^\\/]+\\/\\.\\.(?!([\\.]|[^\\/]))", "/");
            // 多个/////,替换成一个/
            path = path.replaceAll("\\/+", "\\/");
            int length = path.length();
            if (lengthBefore == length) {
                // 没有可换的了
                break;
            } else {
                lengthBefore = length;
            }
        }
        // 执行完上面循环之后,还是可能出现 /..在路径行首,直接换成/
        // 例如 /a/../../b/../c/
        path = path.replaceAll("^\\/\\.\\.(?!([\\.]|[^\\/]))", "/");
        // 多个/////,替换成一个/
        path = path.replaceAll("\\/+", "\\/");
        int length = path.length();
        // 去掉最后的/
        if (length > 1 && path.charAt(length - 1) == '/') {
            path = path.substring(0, length - 1);
        }
        return path;
    }

    /**
     * 利用栈的方式
     *
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        // 思路: 利用栈的思想
        String[] strings = path.split("\\/");
        List<String> list = new ArrayList<>(strings.length);
        for (String string : strings) {
            if (string.equals(".") || string.equals("")) {
                // 不变
            } else if (string.equals("..")) {
                // 删掉最后一个
                int size = list.size();
                if (size > 0) {
                    list.remove(size - 1);
                }
            } else {
                // 加到最后一个
                list.add(string);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        // String result = "";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (!s.equals("")) {
                stringBuilder.append(s).append("/");
                // result = result + s + "/";
            }
        }
        int length = stringBuilder.length();
        // int length = result.length();
        if (length == 0) {
            // 这种情况, 要么是/ 要么是.
            if (path.charAt(0) == '/') {
                return "/";
            } else {
                return ".";
            }
            // return path.substring(0, 1);
        } else {
            // 删除最后的/, 首位插上/
            String s = stringBuilder.deleteCharAt(length - 1).insert(0, "/").toString();
            // String s = "/" + result.substring(0, length - 1);
            return s;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "./a////.//b/c/../d////";
        s = "/../";
        s = "/a//b////c/d//././/..";
        s = "/abc/...";
        s = "/..hidden";
        s = "/a/../../b/../c//.//";
        s = "/home/../../..";
        s = "/a/./b/../../c/";
        s = "/.././em/jl///../.././../E/";
        String simplifyPath = solution.simplifyPath(s);
        System.out.println(simplifyPath);
    }
}
