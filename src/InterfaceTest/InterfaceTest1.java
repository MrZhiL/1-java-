package InterfaceTest;

/**
 * @Description: Interface 接口测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/10
 * @node:
 *        1. 接口使用 interface 来定义
 * 
 *        2. Java中，接口和类是并列的两个结构
 * 
 *        3. 如何定义接口 ：定义接口中的成员
 * 
 *        1. JDK7 及以前：只能定义全局变量和抽象方法
 *        - 全局常量：public static final 的，但是书写时，可以省略不写。
 *        - 抽象方法：public abstract 的，但是书写时，可以省略不写。
 * 
 *        2. JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）
 * 
 *        4. 接口中不能定义构造器！！意味着接口不可以实例化。
 * 
 *        5. **Java开发中，接口通过让类去实现（implements）的方式来实现**
 *        - **如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化**
 *        - **如果实现的类中没有覆盖接口中的所有抽象方法，则此实现类仍为一个抽象类。**
 * 
 *        6. Java类可以实现多个接口 ---> 弥补了Java单继承性的局限性
 */

public class InterfaceTest1 {
    public static void main(String[] args) {
        // 1. 此时可以直接调用接口中的全局变量
        System.err.println(Flyable.MAX_SPEED); // 输出：79000
        System.err.println(Flyable.MIN_SPEED); // 输出：1

        Flyable.show(); // right, 可以调用接口中的静态方法
        // Flyable.fly(); // error, 不可以调用接口中的抽象方法

        // 2. 接口可以通过类来实现，只需要类实现接口中的方法即可
        Plane p = new Plane();
        p.fly();
        p.stop();
        System.err.println("*********************************");

        // 3. 类可以实现多个接口（从而可以弥补单继承的局限性）
        Bullet b = new Bullet();
        b.fly();
        b.attack();
        b.stop();
    }
}

// 1. 接口使用 interface 来定义
interface Flyable {
    /* 1.1 interface中可以定义全局变量 */
    public static final int MAX_SPEED = 79000; // 第一宇宙速度

    // public static final int MIN_SPEED = 1; // 最小速度
    // 书写时，可以省略 public static final
    int MIN_SPEED = 1; // 等价于 public static final int MIN_SPEED = 1;

    /* 1.2 interface中可以定义抽象方法 */
    public abstract void fly(); // right, 抽象方法不可以实现
    // public abstract void fly() {}; // error

    // public abstract void stop();
    // 书写时，可以省略 public abstract
    void stop(); // 等价于 public abstract void stop();

    /* 1.3 interface中可以定义静态方法，且可以直接被调用 */
    public static void show() {
        System.err.println("interface 中的静态方法");
    }

    /* 1.4 interface中不可以定义构造器 */
    // Flyable() { // error

    // }
}

// 2. Java开发中，接口通过让类去实现（implements）的方式来实现
class Plane implements Flyable {
    // 2.1 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
    @Override
    public void fly() {
        System.err.println("Plane can be fly");
    }

    @Override
    public void stop() {
        System.err.println("The plane will stop when the plane runs out of fuel");
    }
}

abstract class Kite implements Flyable {
    // 2.2 如果实现的类中没有覆盖接口中的所有抽象方法，则此实现类仍为一个抽象类
    public void fly() {
        System.err.println("Kite can be fly");
    }
}

// 3. Java类可以实现多个接口 ---> 弥补了Java单继承性的局限性
// 3.1 创建一个Attackable接口
interface Attackable {
    // 攻击接口
    void attack();
}

// 3.2 类可以实现多个接口
class Bullet implements Flyable, Attackable {
    @Override
    public void fly() {
        System.err.println("Bullet can be fly");
    }

    @Override
    public void stop() {
        System.err.println("The Bullet will stop when the Bullet runs out of Energy");
    }

    @Override
    public void attack() {
        System.err.println("Bullet can used to attack people");
    }
}