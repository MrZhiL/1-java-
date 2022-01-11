package InterfaceTest.FactoryTest.SimpleFactory;

/**
 * @Description: 工厂模式测试 - 2.简单工厂模式中Car接口的实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/11 11:00
 * @node: 简单工厂模式测试
 */
// Car接口的实现
interface Car {
    public void run();
}

// 1. audi
class Audi implements Car {
    @Override
    public void run() {
        System.err.println("奥迪车在跑");
    }
}

// 2. BYD
class BYD implements Car {
    @Override
    public void run() {
        System.err.println("比亚迪车在跑");
    }
}
