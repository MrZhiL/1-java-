package InterfaceTest;

/**
 * @Description: Interface 接口测试案例1 - USB接口案例
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
 * 
 *        7. **接口和接口之间可以继承，也可以多继承**
 * 
 *        8. 接口的具体使用，可以体现多态性
 * 
 *        9. **接口：实际上可以看做是一种规范。**
 */

public class USBTest {
    public static void main(String[] args) {
        Computer.transferData(new Flash());
        System.err.println("***************************");
        Computer.transferData(new Printer());
    }
}

class Computer {
    public static void transferData(USB usb) {
        usb.start();
        System.err.println("开始传输数据");
        usb.stop();
    }
}

// 1. 定义USB接口，其中定义最大、最小的传输速率，尺寸等等
interface USB {
    String name = "USB";

    void start();

    void stop();
}

// 1.1 创建U盘类
class Flash implements USB {
    String name = "Flash";

    @Override
    public void start() {
        System.err.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.err.println("U盘停止工作");
    }
}

// 1.2 创建打印机类
class Printer implements USB {
    String name = "Printer";

    @Override
    public void start() {
        System.err.println("打印机开始工作");

    }

    @Override
    public void stop() {
        System.err.println("打印机停止工作");

    }

}