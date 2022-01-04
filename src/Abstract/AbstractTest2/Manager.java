package Abstract.AbstractTest2;

/**
 * @Description: 抽象类和抽象方法案例
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/04
 * @node:
 *        2. 对于Manager类来说，他即是员工，还具有奖金(bonus)的属性
 */
class Manager extends Employee {
    private double bonus; // 奖金

    public Manager() {
        super();
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager 用来管理员工，来提高公司的效率");
    }
}
