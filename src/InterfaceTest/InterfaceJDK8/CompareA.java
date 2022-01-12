package InterfaceTest.InterfaceJDK8;

/**
 * @Description: JDK8及其以后的新特性
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
public interface CompareA {
    int k = 10;

    // 1. 静态方法
    public static void method1() {
        System.out.println("CompareA : public static method1(){} - 接口中的静态方法");
    }

    // 2. 默认方法
    public default void method2() {
        System.out.println("CompareA : public default method2(){} - 接口中的默认方法");
    }

    // 3. 默认方法
    default void method3() {
        System.out.println("CompareA : default method3(){} - 接口中的默认方法");
    }
}
