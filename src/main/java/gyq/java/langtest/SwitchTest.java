package gyq.java.langtest;

/**
 * 测试switch的语法特性
 */
public class SwitchTest {
	public static void main(String[] args) {
		String s = "a";
		switch (s) {
		case "a": // a分支
			System.out.println("匹配成功1");
		case "b": // b分支
			System.out.println("匹配成功2");

		case "c": // c分支
			System.out.println("匹配成功3");
			break;
		case "d": // d分支
			System.out.println("匹配成功4");
			break;
		default:
			break;
		}
		int a = 'a';
	}
}
