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
        new Awk().runAwk();
    }

    private void runAwk() throws IOException {
        // TODO awk的四个命令部分
        String beginCommand = "";
        String patternCommand = "";
        String actionCommand = "";
        String endCommand = "";
        Map<String, String> patternActionMap = Maps.newHashMap();
        // 要读取的文件路径
        String filePath = "test.log";
        // TODO awk内置变量
        // 行数
        int NR = 0;
        // 每行分隔符
        String splitFlag = " ";

        // TODO 开始执行begin语句
        runBegin(beginCommand);
        // 设置一个自定义值
        int total = 0;

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            // 按分隔符分隔数据
            String[] split = readLine.split(splitFlag);
            // 内置变量,如行数的增加
            NR++;
            for (Map.Entry<String, String> entry : patternActionMap.entrySet()) {
                String pattern = entry.getKey();
                String action = entry.getValue();
                // TODO 开始执行pattern语句
                boolean patternResult = false;
                // TODO 开始执行commands语句
                if (patternResult) {
                    if (NR == 1) {
                        System.out.println("这是第一行");
                    }
                    total += NR;
                }
            }
        }
        // TODO 开始执行end语句
        {
            System.out.println("总行数:" + NR);
            System.out.println("total:" + total);
        }
    }


    private void runBegin(String command) {
        System.out.println("执行begin语句块");
    }

    private void runPattern(String command) {
        System.out.println("执行pattern语句块");
    }

    private void runAction(String command) {
        System.out.println("执行action语句块");
    }

    private void runEnd(String command) {
        System.out.println("执行end语句块");
    }


}
