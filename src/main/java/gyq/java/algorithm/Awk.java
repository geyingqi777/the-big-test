package gyq.java.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 用java表示一下awk的处理流程
 *
 * @author geyingqi
 * @date 2019-07-01 20:06
 */
public class Awk {
    public static void main(String[] args) throws IOException {
        // TODO awk的四个命令部分
        String beginCommand = "";
        String patternCommand = "";
        String lineCommand = "";
        String endCommand = "";
        // 要读取的文件路径
        String filePath = "test.log";
        // TODO awk内置变量
        // 行数
        int NR = 0;
        // 每行分隔符
        String splitFlag = " ";

        // TODO 开始执行begin语句

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            NR++;
            // TODO 开始执行pattern语句
            boolean regexMatch = false;
            // 正则
            if (!regexMatch) {
                // 正则匹配不到,则执行下一行
                continue;
            }
            // 判断条件
            if (false) {

            }
            // 初始化变量
            int count = 0;
            // TODO 开始执行commands语句
            if (NR == 1) {
                System.out.println("这是第一行");
            }
        }
        // TODO 开始执行end语句
        System.out.println("总行数:" + NR);
    }


}
