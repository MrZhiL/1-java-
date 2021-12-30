package StaticTest;

/**
 * @Description: static 关键字的使用
 * 
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.2
 * @data: 2021/12/28
 * 
 * @descriped:
 *             1. static : 静态的
 *             2. static 可以用来修饰：属性、方法、代码块、内部类
 * 
 *             3. 使用static修饰属性：称为 静态变量（类变量）
 *             3.1 属性，按是否使用static修饰，分为：静态属性 、 非静态属性（实例变量）
 *             实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值修改
 *             静态变量：当创建多个类的对象时，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致所有对象的调用此静态变量时，会显示修改过的变量。
 *
 *             3.2 static修饰属性的其它说明：
 *             * (1) 静态变量随着类的加载而加载，可以通过 “类名.静态变量” 的方式进行调用。
 *             * (2) 静态变量的加载早于对象的创建。
 *             * (3) 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在于方法区的静态域中（内存中的静态区）。
 *             * (4) 类变量 静态变量
 *             * 类 yes no
 *             * 对象 yes yes
 *
 *             3.3 静态属性举例： System.out; Math.PI;
 *
 *             4. 使用static修饰方法：静态方法
 *             4.1 随着类的加载而加载，可以通过“类.静态方法”的方式进行调用
 *             4.2 静态方法 非静态方法
 *             * 类 yes no
 *             * 对象 yes yes
 *             4.3 在静态方法中，只能调用静态的方法或属性；对于非静态方法，既可以调用非静态的 ，也可以调用非静态的方法或属性
 *
 *             5. static注意点：
 *             5.1 在静态的方法内，不能使用this关键字、super关键字
 *             5.2 在静态方法中，只能调用静态的方法或属性；对于非静态方法
 *             5.3 对于非静态方法，既可以调用非静态的 ，也可以调用非静态的方法或属性
 *
 *             6.1 开发中，如何确定一个属性是否要声明为static？
 *             属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
 * 
 *             6.2 开发中，如何确定一个方法是否要声明为static？
 *             - 操作静态属性的方法，通常设置为static的
 *             - 工具类中的方法，习惯上声明为static的。比如，Math、Arrays、Collections
 */
public class StaticTest {
    public static void main(String[] args) {
        Person.nation = "CHN"; // 静态属性可以通过类名直接进行调用，因为所有实例化对象共享同一份内存，且当类加载时静态对象也会自动加载
        System.out.println("Person.nation W= " + Person.nation); // Person.nation = CHN

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
        p2.nation = "China"; // 建议使用 Person.nation，因为nation为静态变量
        System.out.println("p1.nation = " + p2.nation + ", p1.nation = " + p1.nation);
        // 输出：p1.nation = China, p1.nation = China

        System.out.println("********************************");
        p2.test01();
        System.out.println("********************************");
        Person.test02();
    }
}

class Person {
    String name;
    int age;
    long id;

    static String nation; // 静态属性，国家

    // 生成两个非静态方法，两个静态方法
    public void eat01() {
        System.out.println("public void eat01()");
    };

    public void eat02() {
        System.out.println("name = " + this.name + ", age = " + this.age + ", id = " + this.id);
        System.out.println("public void eat02()");
    }

    public static void show01() {
        System.out.println("public static void show01()");
    }

    public static void show02() {
        System.out.println("public static void show02()");
    }

    // 1. 非静态方法既可以调用静态属性、静态方法，也可以调用非静态属性、非静态方法
    // 因为每个实例化对象在内存中都会生成一份非静态属性，因此可以使用this区分开不同的实例化对象
    public void test01() {
        this.name = "孙悟空"; // right, 可以调用非静态属性
        this.eat02(); // right, 可以调用非静态方法
        show01(); // right, 可以调用静态方法，相当于Person.show01();
    }

    // 2. 静态方法只能调用静态属性、静态方法，不可以调用非静态方法、属性
    public static void test02() {
        // Person.name = "1"; // error, 不可以调用非静态属性
        // Person.eat01(); // error, 不可以调用非静态方法

        show01(); // right, 可以调用静态方法
        show02();
        Person.nation = "China"; // right，可以调用静态属性
    }
}