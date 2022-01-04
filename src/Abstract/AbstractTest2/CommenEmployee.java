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
 * 
 *        3. 使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性方法
 */
public class CommenEmployee extends Employee {
    @Override
    public void work() {
        System.out.println("员工在车间进行生产!");
    }
}
