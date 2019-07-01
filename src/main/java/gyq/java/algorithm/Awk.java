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
        // awk的四个命令部分
        String beginCommand = "";
        String patternCommand = "";
        String lineCommand = "";
        String endCommand = "";
        // 要读取的文件路径
        String filePath = "test.log";

        // TODO 开始执行begin语句

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            // TODO 开始执行pattern语句

            // TODO 开始执行commands语句

        }
        // TODO 开始执行end语句

    }

}
