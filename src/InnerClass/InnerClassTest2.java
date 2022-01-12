package InnerClass;

/**
 * @Description: 内部类测试1
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 15:30
 * @node: 开发中，局部内部类的使用
 * 
 *        1. 直接在方法中定义局部类并使用
 *        2. 返回一个实现了xxx接口的类的对象
 */
public class InnerClassTest2 {
    // 1. 内部类的调用，开发中很少使用
    public void method() {
        class AA {

        }
    }

    // 2. 返回一个实现了xxx接口的类的对象
    public Comparable getCioComparable() {
        // 实现一个创建Comparable接口的类：局部内部类
        // 方式1：创建内部类
        // class MyComparable implements Comparable {

        // @Override
        // public int compareTo(Object o) {
        // // TODO Auto-generated method stub
        // return 0;
        // }
        // }

        // return new MyComparable();

        // 方式2：创建内部内部类
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }
}