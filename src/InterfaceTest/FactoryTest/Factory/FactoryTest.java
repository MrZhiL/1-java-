package InterfaceTest.FactoryTest.Factory;

/**
 * @Description: 工厂模式测试 - 2.工厂模式
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/11 11:30
 * @node: 工厂模式测试
 */

public class FactoryTest {
    public static void main(String[] args) {
        Car a = new AudiFactory().getCar();
        a.run();
        System.err.println("*******************");

        Car b = new BYDFactory().getCar();
        b.run();
    }
}
