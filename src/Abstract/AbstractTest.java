package Abstract;

/**
 * @Description: 抽象类和抽象方法测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/04
 * @node: 抽象类和抽象方法测试，具体的注释在 README.md
 * 
 *        abstract 关键字的使用
 * 
 *        1. abstract 可以用来修饰的结构：类、方法
 * 
 *        2. abstract 修饰类：抽象类
 * 
 *        - 此类不能实例化 `abstract class Person {}`
 * 
 *        - 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
 *        - 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关工作。
 * 
 *        3. abstract 修饰方法：抽象方法
 * 
 *        - 抽象方法只有方法声明，没有方法体。如，`public abstract void eat();`
 *        - 包含抽象方法的类一定是一个抽象类。反之，抽象类中可以没有抽象方法。
 *        - **继承抽象类的子类必须重写父类中的抽象方法** / **将子类也标记为抽象类**
 *        - 若子类重写了父类中的所有的抽象方法，此子类方可实例化对象
 *        - 若子类没有重写父类中所有的抽象方法，则子类也必须标记为抽象类，需要使用 abstract
 * 
 * 
 */
public class AbstractTest {
    public static void main(String[] args) {
        // 1.1 抽象类不能实例化对象
        // Person p = new Person(); // error, 抽象类不能实例化对象
    }
}

// 1. 在class前加abstract，将其声明为抽象类
abstract class Person {
    private int age;
    private String name;

    // 1.2 抽象类中一定有构造器，便于子类实例化时调用
    Person() {

    }

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void eat() {
        System.out.println("Person will eat food!");
    }

}

class Student extends Person {
    Student() {
        super();
    }

    // 1.3 子类可以调用父类中构造器来初始化对象
    Student(String name, int age) {
        super(name, age);
    }
}

// 2. 如果存在抽象方法，则该类一定为抽象类，否则会报错
// class Person2 { // error, 必须将其也声明为抽象类
abstract class Person2 {
    private int age;
    private String name;

    Person2() {

    }

    Person2(String name, int age) {
        this.age = age;
        this.name = name;
    }

    // 2.1 如果将其声明为抽象方法，则必须将该类也声明为抽象类
    public abstract void eat();

    // public void eat() {
    // System.out.println("Person will eat food!");
    // }
}

// 2.2 如果父类中存在抽象方法，方法一：可以将其也声明为抽象类
abstract class Student2 extends Person2 {
    Student2() {
        super();
    }

    Student2(String name, int age) {
        super(name, age);
    }

    public abstract void show();
}

// 2.3 如果父类中存在抽象方案，方法二：子类重写父类（父类的父类）中的所有抽象方法
class Senior extends Student2 {
    @Override
    public void eat() {
        System.out.println("必须重写父类（包括父类的父类）中所有的抽象方法");
    }

    @Override
    public void show() {
        System.out.println("必须重写父类中所有的抽象方法");
    }
}
