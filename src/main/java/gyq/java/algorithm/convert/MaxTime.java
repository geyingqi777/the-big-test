package gyq.java.algorithm.convert;

public class MaxTime {

    private static int[] maxValue = new int[4];

    public static void main(String[] args) {

        int[] numbers = new int[4];
        int[] resolved = new int[4];
        int[] current = new int[4];
        max(current, resolved, numbers);
        System.out.println(maxValue);
    }

    private static void max(int[] current, int[] resolved, int[] numbers) {
        if (!valid(current)) {
            // 不合法,退出
            return;
        }
        // 找到最大的
        if (true) {
            // TODO: 2021/4/1 条件当resolved所有位都是1,表示四个数字都处理了,比较大小,找到最大的 
            maxValue = current;
        }
        // 得到当前值
        for (int i = 0; i < numbers.length; i++) {
            if (resolved[i] == 1) {
                continue;
            }
            // 选择
            current[i] = numbers[i];
            resolved[i] = 1;
            // 递归子树
            max(current, resolved, numbers);
            // 退出时取消选择
            resolved[i] = 0;
            current[i] = 0;
        }
    }

    private static boolean valid(int[] current) {
        // 前2位在0-23之间

        // 后2位在0-59之间

        return false;
    }
}