package BlockTest;

/**
 * @Description: 代码块测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/02
 * @node: 代码块测试，具体的注释在 README.md
 *        1. 代码块作用：用来初始化类、对象
 * 
 *        2. 代码块如果有修饰的话，只能使用static
 * 
 *        3. 分类：静态代码块 vs 非静态代码块
 ** 
 *        代码块通过一组花括号实现**
 */

public class BlockTest {
    public static void main(String[] args) {
        String desc1 = Person.desc; // 会输出hello, static block-1; hello static block-2
        String desc2 = Person.desc; // 会输出hello, static block-1; hello static block-2

        Person p1 = new Person("jason", 21);
        Person p2 = new Person("kiek", 19);

        System.out.println(p1.toString()); // [name = kiek, age = 19]
        System.out.println(p2.toString()); // [name = kiek, age = 19]

        Person p3 = new Person();
        System.out.println(p3.toString()); // [name = non-static-2, age = 22]
    }
}

class Person {
    private int age;
    private String name;

    static String desc;

    // 1. 构造方法
    Person() {

    }

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    // 2. 属性的get and set
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void show() {
        System.out.println("public void show()");
    }

    public static void info() {
        System.out.println("public static void info()");
    }

    @Override
    public String toString() {
        return "[name = " + this.name + ", age = " + this.age + "]";
    }

    // 3. 静态代码块
    static {
        desc = "block-1"; // 静态代码块中可以调用静态属性和方法
        System.out.println("hello, static block-1");
    }

    static {
        desc = "block-2";
        System.out.println("hello, static block-2");
    }

    // 4. 非静态代码块, 可以初始化所有属性（静态和非静态方法、属性）
    {
        age = 11;
        name = "non-static-1";
        System.out.println("hello, non-static block-1");
    }

    {
        age = 22;
        name = "non-static-2";
        System.out.println("hello, non-static block-2");
    }
}