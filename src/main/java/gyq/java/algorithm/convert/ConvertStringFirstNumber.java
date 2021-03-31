package gyq.java.algorithm.convert;

/**
 * 从一个字符串中,找到第一个出现的正数数值
 *
 * @author geyingqi
 * @date 2021/3/30 7:27 下午
 */
public class ConvertStringFirstNumber {
    public static void main(String[] args) {
        System.out.println(convert("-1111"));
    }

    private static long convert(String string) {
        char[] chars = string.toCharArray();
        long result = 0;
        boolean begin = false;
        for (char aChar : chars) {
            int i = aChar - '0';
            if (0 <= i && i <= 9) {
                if (i > 0) {
                    // 开始
                    begin = true;
                }
                // 前一位*10 + 当前的就是最新的数字大小
                result = result * 10 + i;
            } else {
                // 非数字
                if (begin) {
                    break;
                }
            }
        }
        return result;
    }
}
