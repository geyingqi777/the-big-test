package gyq.java.designpattern.proxy.staticproxy;

/**
 * 学生代理类，也实现了Person接口，保存一个学生实体，这样既可以代理学生产生行为
 * 
 */
public class StudentsProxy implements Person {
	// 被代理的学生
	Student stu;

	public StudentsProxy(Person stu) {
		// 只代理学生对象
		if (stu.getClass() == Student.class) {
			this.stu = (Student) stu;
		}
	}

	// 代理上交班费，调用被代理学生的上交班费行为
	public void giveMoney() {
		System.out.println("代理中间商帮忙收费");
		stu.giveMoney();
		System.out.println("中间商赚差价");
	}
}