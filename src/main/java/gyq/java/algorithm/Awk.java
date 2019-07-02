package gyq.java.algorithm;

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
public class Awk {
    public static void main(String[] args) throws IOException {
        String beginCommand = "";
        Map<String, String> patternActionMap = Maps.newHashMap();
        String endCommand = "";
        String filePath = "";
        new Awk().runAwk(filePath, beginCommand, patternActionMap, endCommand);
    }

    /**
     * 模拟表示awk处理流程
     *
     * @param filePath         输入文件路径
     * @param beginCommand     begin命令块
     * @param patternActionMap pattern{action}命令块
     * @param endCommand       end命令块
     * @throws IOException
     */
    private void runAwk(String filePath, String beginCommand, Map<String, String> patternActionMap, String endCommand) throws IOException {
        // TODO awk内置变量
        // 行数
        int NR = 0;
        // 每行分隔符
        String splitFlag = " ";

        // TODO 开始执行begin语句
        runBegin(beginCommand);
        // 例如: 设置一个自定义值
        int total = 0;

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            // 内置变量
            String $0 = readLine;
            // 按分隔符分隔数据
            String[] split = readLine.split(splitFlag);
            // 内置变量,如行数的增加
            NR++;
            // 内置变量,字段数
            int NF = split.length;
            for (Map.Entry<String, String> entry : patternActionMap.entrySet()) {
                String pattern = entry.getKey();
                String action = entry.getValue();
                // TODO 开始执行pattern语句
                boolean patternResult = runPattern(pattern);
                // TODO 开始执行commands语句
                if (patternResult) {
                    runAction(action);
                    // 例如: 打印第一行第一列信息
                    if (NR == 1) {
                        System.out.println(split[0]);
                    }
                    total += NR;
                }
            }
        }
        // TODO 开始执行end语句
        runEnd(endCommand);
        // 例如: 打印计数
        System.out.println("total:" + total);
    }


    private void runBegin(String command) {
        System.out.println("执行begin语句块");
    }

    private boolean runPattern(String command) {
        System.out.println("执行pattern语句块");
        return true;
    }

    private void runAction(String command) {
        System.out.println("执行action语句块");
    }

    private void runEnd(String command) {
        System.out.println("执行end语句块");
    }


}
