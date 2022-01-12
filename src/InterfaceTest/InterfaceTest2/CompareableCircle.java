package InterfaceTest.InterfaceTest2;

/**
 * @Description: 使用接口比较两个类的大小
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 13:01
 * @node:
 *        定义一个CompareableCircle类，继承Circle类并且实现CompareObject接口。
 *        在CompareableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 */
public class CompareableCircle extends Circle implements Comparable {

    public CompareableCircle() {
        super();
    }

    public CompareableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        CompareableCircle c = (CompareableCircle) o;

        if (this == c) {
            return 0;
        }

        if (o instanceof CompareableCircle) {

            // // 方法一：直接比较
            // if (this.getRadius() > c.getRadius()) {
            // return 1;
            // } else if (this.getRadius() < c.getRadius()) {
            // return -1;
            // } else {
            // return 0;
            // }

            // 方法二：通过Double包装类中的compareTo() 方法
            return this.getRadius().compareTo(c.getRadius());
        } else {
            throw new RuntimeException("输入类型不匹配;");
        }

    }
}
