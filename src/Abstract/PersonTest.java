package Abstract;

/**
 * @Description: 创建抽象类的匿名子类对象
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/05
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("*** 1 - 非抽象类的匿名对象   ******");
        new Student().eat(); // 非抽象类的匿名对象

        System.out.println("*** 3 - 非匿名的类非匿名的对象******");
        Student s = new Student();
        method(s); // 非匿名的类匿名的对象

        System.out.println("*** 4 - 非匿名的类匿名的对象  ******");
        method(new Student());

        System.out.println("*** 5 - 抽象类的匿名子类对象  ******");
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("new Person() will eat food!");
            }

            @Override
            public void breath() {
                System.out.println("new Person() will breath");
            }
        };

        method(p);

        System.out.println("*** 6 - 匿名子类的匿名子类对象 ******");
        method(new Person() {
            @Override
            public void eat() {
                System.out.println("匿名子类的匿名子类对象 will eat food!");
            }

            @Override
            public void breath() {
                System.out.println("匿名子类的匿名子类对象 will breath");
            }
        });
    }

    public static void method(Person p) {
        p.eat();
        p.breath();
    }
}
