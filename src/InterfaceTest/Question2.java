package InterfaceTest;

/**
 * @Description: 接口中的问题
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/12 12:35
 * @node: 2 - 接口中存在同名的方法
 */
public class Question2 {
    public static void main(String[] args) {
        new Ball("footable").play(); // 输出PingPang
    }
}

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    // Ball ball 等价于 public static final Ball ball, 因为ball为final修饰的，因此不可以修改
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {
    private String name;

    public Ball() {

    }

    public Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    // 此时play()函数相当于对Playable和Bounceable中的play()方法进行了重写（因为同名）
    public void play() {
        // ball = new Ball("Footable"); error, 因为ball在Rollable中定义的，为final修饰的，不可以更改
        System.out.println(ball.getName());
    }
}