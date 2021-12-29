package StaticTest;

/**
 * static 关键字的使用
 * 
 * 1. static : 静态的
 * 2. static 可以用来修饰：属性、方法、代码块、内部类
 * 
 * 3. 使用static修饰属性：称为 静态变量（类变量）
 * 3.1 属性，按是否使用static修饰，分为：静态属性 、 非静态属性（实例变量）
 * * 实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值修改
 * * 静态变量：当创建多个类的对象时，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致所有对象的调用此静态变量时，会显示修改过的变量。
 * 
 * 3.2 static修饰属性的其它说明：
 * * (1) 静态变量随着类的加载而加载，可以通过 “类名.静态变量” 的方式进行调用。
 * * (2) 静态变量的加载早于对象的创建。
 * * (3) 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在于方法区的静态域中（内存中的静态区）。
 * * (4) * * * 类变量 * * 静态变量
 * * * * 类 * * yes * * * no
 * * * * 对象 * yes * * * yes
 * *
 * 
 * 4. 使用static修饰方法：
 */
public class StaticTest {
    public static void main(String[] args) {
        Person.nation = "CHN"; // 静态属性可以通过类名直接进行调用，因为所有实例化对象共享同一份内存，且当类加载时静态对象也会自动加载
        System.out.println("Person.nation = " + Person.nation); // Person.nation = CHN

        Person p1 = new Person();
        p1.name = "孙悟空";
        p1.age = 999;
        p1.id = 001;
        System.out.println("p1.nation = " + p1.nation + ", Person.nation = " + Person.nation);
        // 输出： p1.nation = CHN, Person.nation = CHN

        Person p2 = new Person();
        p2.name = "猪八戒";
        p2.age = 888;
        p2.id = 002;
        p2.nation = "China";
        System.out.println("p1.nation = " + p2.nation + ", p1.nation = " + p1.nation);
        // 输出：p1.nation = China, p1.nation = China

    }
}

class Person {
    String name;
    int age;
    long id;

    static String nation; // 静态属性，国家

    public void test() {

    };
}
