package gyq.java.algorithm.simpleawk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * 用java表示一下awk的处理流程
 *
 * @author geyingqi
 * @date 2019-07-01 20:06
 */
public class SimpleAwk {
    public static void main(String[] args) throws IOException {
        // 输入内容
        String filePath = "";
        // begin部分参数
        Begin begin = context -> {
            System.out.println("这是begin命令块,上下文参数为" + JSON.toJSONString(context));
            return true;
        };
        // pattern action部分参数
        Map<Pattern, Action> patternActionMap = Maps.newHashMap();
        Pattern pattern = context -> {
            System.out.println("这是pattern命令块");
            return true;
        };
        Action action = context -> {
            System.out.println("这是action命令块");
            return true;
        };
        // end部分参数
        End end = context -> {
            System.out.println("这是end命令块,上下文参数为" + JSON.toJSONString(context));
            return true;
        };
        new SimpleAwk().awkRun(filePath, begin, patternActionMap, end);
    }

    /**
     * 模拟表示awk处理流程
     *
     * @param filePath         输入文件路径
     * @param begin            begin命令块
     * @param patternActionMap pattern{action}命令块
     * @param end              end命令块
     * @throws IOException
     */
    private void awkRun(String filePath, Begin begin, Map<Pattern, Action> patternActionMap, End end) throws IOException {
        Map<String, String> context = Maps.newHashMap();
        // awk内置变量,例如:行数
        int NR = 0;
        // 每行分隔符
        String splitFlag = " ";

        // TODO 开始执行begin语句
        begin.run(context);

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            // 内置变量,例如:字段数
            String $0 = readLine;
            // 按分隔符分隔数据
            String[] split = readLine.split(splitFlag);
            // 行数增加
            NR++;
            // 内置变量,字段数
            int NF = split.length;
            for (Map.Entry<Pattern, Action> entry : patternActionMap.entrySet()) {
                Pattern pattern = entry.getKey();
                Action action = entry.getValue();
                // TODO 开始执行pattern语句
                boolean patternResult = pattern.run(context);
                // TODO 开始执行commands语句
                if (patternResult) {
                    action.run(context);
                }
            }
        }
        // TODO 开始执行end语句
        end.run(context);
    }

    /**
     * 命令
     */
    interface Command {
        /**
         * 命令执行
         *
         * @param context 上下文参数
         * @return
         */
        boolean run(Map<String, String> context);
    }

    /**
     * BEGIN命令块
     */
    interface Begin extends Command {
    }

    /**
     * END命令块
     */
    interface End extends Command {
    }

    /**
     * PATTERN命令块
     */
    interface Pattern extends Command {
    }

    /**
     * ACTION命令块
     */
    interface Action extends Command {
    }

}
