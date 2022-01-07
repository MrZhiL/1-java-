package Abstract.AbstractTest3;

/**
 * @Description: 抽象类和抽象方法测试案例-3: SalariedEmployee类的实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/07
 * @node: 编写一个工资系统，实现不同类型员工（多态）的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 *        3. 定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：
 *        - private成员变量monthlySalary;
 *        - 实现父类的抽象方法earnings()，该方法返回monthlySalary值；
 *        - toStriing() 方法输出员工类型信息及员工的name，number，birthday。
 */
public class SalariedEmployee extends Employee {
    private double monthlySalary; // 月工资

    public SalariedEmployee() {

    }

    public SalariedEmployee(double monthlySalary) {
        super();
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double earnings() {
        return this.monthlySalary;
    }

    @Override
    public String toString() {
        // 重写toString方法，输出员工类型信息及员工的name、number、birthday
        return "SalariedEmployee[" + super.toString() + "]";
    }
}