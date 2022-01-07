package Abstract.AbstractTest3;

/**
 * @Description: 抽象类和抽象方法测试案例-3: MyDate 类的实现
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/07
 * @node: 编写一个工资系统，实现不同类型员工（多态）的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 *        2. MyDate 类包含：
 *        - private 成员变量，year，month，day；
 *        - toDateString() 返回日期对应的字符串：xxxx年xx月xx日
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        super();
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return this.year + "年" + this.month + "月" + this.day + "日";
    }
}
