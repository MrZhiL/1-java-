package StaticTest;

/**
 * @Description: 饿汉式单例设计模式 - 实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2021/12/30
 * @node: 有两种单例设计模式：饿汉式（创建静态对象的时候便初始化）和懒汉式（创建静态对象时不初始化）
 */

public class SingletonTest1 {
    public static void main(String[] args) {
        // 单例设计模式中，只能实例化一个对象，因此bank1和bank2是相同的，且具有相同的地址
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2); // true
    }
}

// 饿汉式单例设计模式
class Bank {
    // 1. 将构造函数私有化
    private Bank() {

    }

    // 2. 在内部创建类的对象（必须为静态属性）
    private static Bank instance = new Bank();

    // 3. 创建静态方法，返回2中创建的实例化对象
    public static Bank getInstance() {
        return instance;
    }
}
