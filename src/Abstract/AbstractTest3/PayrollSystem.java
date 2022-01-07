package Abstract.AbstractTest3;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Description: 抽象类和抽象方法测试案例-3: mian函数的实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/07
 * @node: 编写一个工资系统，实现不同类型员工（多态）的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 *        5.定义PayrollSystem类，创建Employee变量数组并初始化，该数组存各类雇员对象的引用。
 *        利用循环结构遍历数组元素，输出各个对象的类型name,number, birthday，
 *        以及该对象生日。当键盘输入本月月份时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
    public static void main(String[] args) {
        // // 1. 方式1, 手动输入
        // Scanner sc = new Scanner(System.in);
        // System.err.println("请输入当月的月份: ");
        // int month = sc.nextInt();
        // sc.nextLine();

        // 2. 方式2
        Calendar calendar = Calendar.getInstance();
        int month2 = calendar.get(Calendar.MONTH); // 获取当前月的月份，一月份为0

        Employee[] emps = new Employee[4]; // 此时不会报错
        // emps[0] = new Employee; // error，不可以实例化抽象类对象

        emps[0] = new SalariedEmployee("John", 1001, new MyDate(2000, 10, 8), 10000);
        emps[1] = new SalariedEmployee("Jack", 1002, new MyDate(1998, 8, 18), 9999);

        emps[2] = new HourlyEmployee("Aiekn", 1003, new MyDate(2002, 1, 15), 55, 200);
        emps[3] = new HourlyEmployee("Aiekn", 1003, new MyDate(1997, 7, 8), 60, 200);

        for (int i = 0; i < emps.length; ++i) {
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月薪为：" + salary);

            if (month2 + 1 == emps[i].getBirthday().getMonth()) {
                System.err.println("生日快乐，奖励100元!");
            }
        }
    }
}
