package gyq.java.lang.test;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDateTime;

/**
 * @author geyingqi
 * @date 2019-08-16 15:39
 */
public class JodaTimeLocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        int millisOfDay = now.getMillisOfDay();
        System.out.println(millisOfDay);
        System.out.println(DateTimeConstants.MILLIS_PER_DAY);
        int max = 999;
        double v = max * (double) millisOfDay / DateTimeConstants.MILLIS_PER_DAY;
        double v2 = max * millisOfDay / DateTimeConstants.MILLIS_PER_DAY;
        System.out.println(v);
        System.out.println(v2);
        // int freeInsOrderLeftCount = (int) (max - v);
        int freeInsOrderLeftCount = (int) (max - max * ((double) millisOfDay / DateTimeConstants.MILLIS_PER_DAY));
        System.out.println(freeInsOrderLeftCount);
    }
}
