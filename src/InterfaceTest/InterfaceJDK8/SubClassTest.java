package InterfaceTest.InterfaceJDK8;

import javax.swing.ComboBoxEditor;

/**
 * @Description: JDK8及其以后的新特性Main函数测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 12:35
 * @node:
 *        - JDK7 及以前：只能定义全局变量和抽象方法
 *        -- 全局常量：public static final 的，但是书写时，可以省略不写。
 *        -- 抽象方法：public abstract 的，但是书写时，可以省略不写。
 * 
 *        - JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 */
public class SubClassTest {
    public static void main(String[] args) {
        SubClass1 sc = new SubClass1();
        // 知识点1 - 接口中定义的静态方法，只能通过接口来调用
        // sc.method1(); // error, 报没有定义method1()的异常
        CompareA.method1(); // right，静态方法只能通过接口来调用

        // 知识点2 - 通过实现类的对象，可以调用接口中的默认方法
        sc.method2(); // right

        // 知识点3 - 如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的而方法，
        // 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法（与变量不同，变量的调用必须声明调用的是接口中的还是类中的）。
        // ---> 类优先原则
        sc.method3(); // right

        System.out.println("**********************");
        sc.myMethod();
    }
}

class SubClass1 extends SuperClass implements CompareA, CompareB {
    public void method2() {
        System.out.println("SubClass : public void method2() - 重写接口中的默认方法method2");
    }

    @Override
    public void method3() {
        System.out.println("SubCLass1 - method3()");
    }

    public void myMethod() {
        // 1.1 调用自己重写的method3()
        method3();
        // 1.2 调用父类中的method3()
        super.method3();
        // 1.3 调用接口CompareA和CompareB中的method3()
        CompareA.super.method3();
        CompareB.super.method3();
    }
}

// 知识点4 -如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
// 那么在实现类没有重写此方法的情况下，会报错 ---> 接口冲突。
// （如果该实现类的父类中也有该方法则不会报错）
// class SubClass2 implements CompareA, CompareB {
// public void method2() {
// System.out.println("SubClass : public void method2() - 重写接口中的默认方法method2");
// }
// }