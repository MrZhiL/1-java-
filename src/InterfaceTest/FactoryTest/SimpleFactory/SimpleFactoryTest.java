package InterfaceTest.FactoryTest.SimpleFactory;

/**
 * @Description: 工厂模式测试 - 2.简单工厂模式
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/11 11:00
 * @node: 简单工厂模式测试
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Car byd = CarFactory.getCar("BYD");
        byd.run();

        Car audi = CarFactory.getCar("Audi");
        audi.run();
    }
}

// 3. 简单工厂模式
class CarFactory {
    // method1:
    public static Car getCar(String name) {
        if (name.equals("Audi")) {
            return new Audi();
        } else if (name.equals("BYD")) {
            return new BYD();
        } else {
            return null;
        }
    }

    // method2:
    public static Car getAudi() {
        return new Audi();
    }

    public static Car getBYD() {
        return new BYD();
    }
}