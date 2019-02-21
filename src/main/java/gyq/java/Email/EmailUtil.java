package gyq.java.Email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import gyq.java.util.IpAddressUtils;

/**
 * Created by ge_yi on 2019/2/21.
 */
public class EmailUtil {
	private static void sendWarnEmail(Throwable ex, String[] args) {
		try {
			Email email = new SimpleEmail();
			email.setCharset("UTF-8");
			email.setHostName("smtp.126.com");
			email.setSmtpPort(25);
			email.setAuthentication("discoverybay@126.com", "discoverybay-inc");
			email.setTLS(false);
			email.setFrom("discoverybay@126.com", "脚本监控");
			email.setSubject(IpAddressUtils.getLocalAddress() + " log服务器脚本执行错误");

			// 设置收件人，后端 2018年5月8日12:12:15
			email.addTo("asage@welove-inc.com");

			StringBuilder sb = new StringBuilder();
			sb.append("脚本执行错误\n");
			sb.append(ex.toString());
			sb.append("\nMessage:");
			sb.append(ex.getMessage());
			sb.append("\n\nargs:\n");
			int js = 0;
			for (String s : args) {
				sb.append(js++);
				sb.append(": [");
				sb.append(s);
				sb.append("]\n");
			}
			sb.append("\nStack:");
			for (StackTraceElement ste : ex.getStackTrace()) {
				sb.append("\n");
				sb.append(ste.getFileName());
				sb.append(":");
				sb.append(ste.getLineNumber());
				sb.append(" >>");
				sb.append(ste.getClassName());
				sb.append(" @ ");
				sb.append(ste.getMethodName());
			}
			email.setMsg(sb.toString());
			email.send();
			// 增加mattermost通知
			// MatterMostNotifyUtils.notifyMattermostDetail(email.getSubject(), null, sb.toString(), MatterMostChannelEnum.CHANNEL_SCRIPT_NOTIFY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sendWarnEmail(new Throwable(), args);
	}
}
