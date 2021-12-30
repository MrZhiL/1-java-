package StaticTest;

/**
 * @Description: 懒汉式单例设计模式 - 实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.2
 * @data: 2021/12/30
 * @node: 有两种单例设计模式：饿汉式（创建静态对象的时候便初始化）和懒汉式（创建静态对象时不初始化）
 */

public class SiingletonTest2 {
    public static void main(String[] args) {
        Order ord1 = Order.getInstance();
        Order ord2 = Order.getInstance();

        System.out.println(ord1 == ord2); // true
    }
}

// 懒汉式单例设计模式
class Order {
    private Order() {

    }

    // 2. 在内部创建类的对象（必须为静态属性, 不初始化）
    private static Order instance = null;

    // 3. 创建静态方法，返回2中创建的实例化对象
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}