package InterfaceTest.InterfaceTest2;

import javax.tools.Diagnostic;

/**
 * @Description: 使用接口比较两个类的大小
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 13:01
 * @node:
 *        interface CompareObject {
 *        public int compareTo(Object o); //
 *        如返回值为0，代表相等；若为正数，代表当前对象大；若为复数，代表当前对象小
 *        }
 */
public class Circle {
    private Double radius; // 声明为包装类，后面可以直接调用包装类中的CompareTo方法

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }
}
