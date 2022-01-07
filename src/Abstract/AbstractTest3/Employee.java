package Abstract.AbstractTest3;

/**
 * @Description: 抽象类和抽象方法测试案例-3: Employee类的实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/07
 * @node: 编写一个工资系统，实现不同类型员工（多态）的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 *        1. 定义一个Employee类，该类包含：
 *        - private 成员变量：name, number, birthday, 其中birthday为MyDate类的对象；
 *        - abstract方法earnings();
 *        - toString() 方法输出对象的name,number,birthday。
 */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee() {
        super();
    }

    public Employee(String name, int number, MyDate birthday) {
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    // 定义抽象方法
    public abstract double earnings();

    // 重写toString()方法，输出对象的name，number，birthday
    @Override
    public String toString() {
        // 因为birthday为MyDate类型，因此需要重写MyDate中的toString方法，并且需要调用该方法（否则会输出birthday的地址）
        return "name: " + this.name + ", number: " + this.number + "birthday:" + birthday.toString();
    }
}
