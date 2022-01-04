package Abstract.AbstractTest2;

/**
 * @Description: 抽象类和抽象方法案例
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/04
 * @node:
 *        1. 编写一个Employee类，声明为抽象类。包含如下三个属性：name, id, salary;
 *        提供必要的构造器和抽象方法：work()
 * 
 *        2. 对于Manager类来说，他即是员工，还具有奖金(bonus)的属性
 */
abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, int id, double salary) {
        super();
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}
