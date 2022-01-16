package RunExceptionTest;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 异常处理过程：子类重写父类中的方法规则
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/16 08:25
 * @node: 子类重写父类中的方法规则
 *        1. 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 *        2. 如果父类中没有抛异常，则子类一定不可以抛出异常
 */
public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest o = new OverrideTest();
        o.display(new SubClass());
    }

    public void display(SuperClass s) {
        try {
            s.method1();
        } catch (IOException e) {
            // 如果子类throws的异常大于父类throws的异常，则此时无法通过catch语句处理
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class SuperClass {
    // 1. 此时父类抛出了IOException异常
    public void method1() throws IOException {

    }
}

class SubClass extends SuperClass {
    // 2. 子类重写父类中的方法，此时子类throws的异常必须不大于父类抛出的异常，否则上层无法处理该异常
    public void method1() throws FileNotFoundException {

    }
}
