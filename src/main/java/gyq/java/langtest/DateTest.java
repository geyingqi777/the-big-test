package gyq.java.langtest;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * @author Asa
 * @version 创建时间：2016年9月18日 下午3:42:52
 */
public class DateTest {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		System.out.println("时间：" + new Date(1526471508026L).toString());
		System.out.println(1478078416400L + 40000);
		System.out.println(new Date(1478078416400L + 40000).toString());

		long long20160930 = 1475182800000L;// 这20160930天5点整的时间戳
		long long2016093012 = 1475208000000L;

		long base = 1475055000000l;// 测试先以20160928173000的时间戳作为基准,测试部署之前改一下
		int hourGap = (int) ((System.currentTimeMillis() - base) / DateUtils.MILLIS_PER_MINUTE / 10);
		System.out.println(hourGap);
		System.out.println(Integer.MAX_VALUE);

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.MONTH));
		int actualMaximum = calendar.getActualMaximum(Calendar.SECOND);
		System.out.println(actualMaximum);
		System.out.println(actualMaximum - now);

		System.out.println(System.currentTimeMillis() - 3600 * 1000 * 24);

		DateTest test = new DateTest();
		test.invokeTest();
		System.out.println(Integer.MAX_VALUE / 1000 / 24 / 3600);
		int expireTime = 3600 * 24 * 30;
		System.out.println(expireTime);

	}

	public final void invokeTest() {
		System.out.println("test");
	}
}
