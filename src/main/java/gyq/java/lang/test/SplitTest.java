package gyq.java.lang.test;

import java.util.LinkedList;
import java.util.List;

public class SplitTest {
	public static void main(String[] args) {
		String string = "844424939256072,844424938184061,844424939069967,844424939304205,844424939276034,844424930310922,844424939295749,844424939259014,844424939255046,844424939288326,844424939298205,844424939092113,844424935991876,844424939280937,844424938940064,844424939296558,844424939299758,844424936405498,844424939256366,844424938911533,844424935562237,844424939116327,844424939282489,844424939104698,844424939214010,844424939239345,844424939225522,844424939004735,844424937290837,844424935026932,844424938412988,844424939058760,844424939181252,844424939297350,844424939302488,844424939267679,844424938984543,844424939289171,844424938995679,844424939299412,844424937042871,844424938996314,844424936614016,844424939280363,844424932889164,844424931690226,844424939260015,844424938495120,844424939243367,844424939299559,844424938913769,844424933399618,844424939302139,844424939202813,844424939070960,844424939173878,844424935968676";
		String[] strings = string.split(",");
		System.out.println(strings.length);
		for (String string2 : strings) {
			if (string2.equals("88888")) {
				System.out.println(string2);
			}
		}
		String nullString = ",222,";
		// System.out.println(nullString.split(",").length);
		// System.out.println("++"+nullString.split(",")[0]+"--");
		List<String> list = new LinkedList<>();
		list.add("1=1");
		list.add("4=38627");
		list.add("5=24377");
		list.add("6=33306");
		list.add("7=17306");
		list.add("8=9374");
		list.add("9=7809");
		list.add("10=6126");
		list.add("11=5065");
		list.add("12=4833");
		list.add("13=4488");
		list.add("14=4271");
		list.add("15=4640");
		list.add("16=4649");
		list.add("17=4889");
		list.add("18=4671");
		list.add("19=4312");
		list.add("20=3191");
		list.add("21=2802");
		list.add("22=2066");
		list.add("23=1393");
		list.add("24=932");
		list.add("25=585");
		list.add("26=487");
		list.add("27=307");
		list.add("28=225");
		list.add("29=146");
		list.add("30=79");
		list.add("31=42");
		list.add("32=18");
		list.add("33=15");
		list.add("34=9");
		list.add("35=5");
		list.add("36=4");
		list.add("37=1");
		list.add("38=1");
		list.add("39=3");
		list.add("40=1");
		list.add("42=1");
		list.add("52=1");
		list.add("55=1");
		int count = 0;
		for (String s : list) {
			String[] split = s.split("=");
			count += Integer.parseInt(split[1]);
		}
		System.out.println(count);
	}
}
