package StaticTest;

/**
 * @Description: static 关键字的应用
 * 
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2021/12/29
 * 
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("c1.id = " + c1.getId() + ", Circle.total = " + Circle.getTotal()); // 1001, 1

        Circle c2 = new Circle();
        System.out.println("c2.id = " + c2.getId() + ", Circle.total = " + Circle.getTotal()); // 1002, 2

        Circle c3 = new Circle();
        System.out.println("c3.id = " + c3.getId() + ", Circle.total = " + Circle.getTotal()); // 1003, 3
    }

}

/**
 * Circle 类，其中包括一个radius, id, total
 * id 表示Circle的编号，每次创建的时候自动赋值
 * total 用来记录一共创建的Circle实例化对象的数量，自动记录
 * 因为total需要自动记录数量，所以可以声明为静态的
 */
class Circle {
    private double radius;
    private int id;

    private static int total = 0; // 用来统计总的Circle类的实例化对象
    private static int init = 1001; // 用来记录编号

    public Circle() {
        id = init++; // 赋值后，将init自增一
        ++total; // 每次实例化对象，都将total自增一
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return this.id;
    }

    public static int getTotal() {
        return total;
    }
}