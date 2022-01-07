package Abstract.AbstractTest3;

/**
 * @Description: 抽象类和抽象方法测试案例-3: HourlyEmployee类的实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/07
 * @node: 编写一个工资系统，实现不同类型员工（多态）的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 *        4. 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
 *        - private成员变量wage和hour；
 *        - 实现父类的抽象方法earnings()，该方法返回wage*hour值；
 *        - toString()方法输出员工类型信息及员工的name, number, birthday。
 */
public class HourlyEmployee extends SalariedEmployee {
    private int wage; // 每小时的工资
    private int hour; // 月工作的小时数

    public HourlyEmployee() {
        super();
    }

    public HourlyEmployee(int wage, int hour) {
        super();
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        // 重写toString方法，输出员工类型信息及员工的name、number、birthday
        return "HourlyEmployee[" + super.toString();
    }
}
