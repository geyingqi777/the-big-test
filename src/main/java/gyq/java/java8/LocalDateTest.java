package gyq.java.java8;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author geyingqi
 * @date 2019-06-14 10:49
 */
public class LocalDateTest {
    public static void main(String[] args) {
        // 该list是按照期数升序排序的
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        LocalDateTime tomorrow0 = LocalDateTime.of(tomorrow.toLocalDate(), LocalTime.MIN);
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int hour1 = now.getHour();
        System.out.println(tomorrow0);
    }
}
