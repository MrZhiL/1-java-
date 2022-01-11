package InterfaceTest.FactoryTest;

import javax.sound.midi.SysexMessage;

/**
 * @Description: 工厂模式测试 - 1.无工厂模式
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/11 11:00
 * @node: 无工厂模式测试
 */
public class NoFactoryTest {
    public static void main(String[] args) {
        Audi audi = new Audi();
        audi.run();
        System.err.println("**************************");

        BYD byd = new BYD();
        byd.run();
    }
}

interface car {
    public void run();
}

// 1. audi
class Audi implements car {
    @Override
    public void run() {
        System.err.println("奥迪车在跑");
    }
}

// 2. BYD
class BYD implements car {
    @Override
    public void run() {
        System.err.println("比亚迪车在跑");
    }
}
