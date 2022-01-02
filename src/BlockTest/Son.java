package BlockTest;

public class Son extends Father {
    static {
        System.out.println("4444444444");
    }

    {
        System.out.println("5555555555");
    }

    public Son() {
        System.out.println("6666666666");
    }

    public static void main(String[] args) {
        // note: 由远及近，静态先行。
        // 因为main为类中的静态方法，因此需要首先调用该类的静态块，该类继承于Father，
        // 因此需要先调用Father中的静态块然后再Son类的静态块
        System.out.println("7777777777");
        System.out.println("********************");
        new Son();
        System.out.println("********************");
        new Son();
        System.out.println("********************");
        new Father();

        /**
         * output:
         * 1111111111
         * 4444444444
         * 7777777777
         ********************
         * 2222222222
         * 3333333333
         * 5555555555
         * 6666666666
         ********************
         * 2222222222
         * 3333333333
         * 5555555555
         * 6666666666
         ********************
         * 2222222222
         * 3333333333
         */
    }
}

class Father {
    static {
        System.out.println("1111111111");
    }

    {
        System.out.println("2222222222");
    }

    public Father() {
        System.out.println("3333333333");
    }
}
