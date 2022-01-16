# Java - 异常处理

## 1. 复习

1. abstract 抽象类

   - abstract修饰类：抽象类

     - 此类不能实例化对象
     - 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
     - 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作--->抽象的使用前提，继承性。

   - abstract修饰方法：抽象方法

     - 抽象方法只方法的声明，没有方法体。
     - 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的。
     - 若子类重写了父类中的所有抽象方法后，此子类可实例化；

     若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰。

   - 注意点：

     - abstract 不能用来修饰：属性、构造器等结构

     - abstract 不能用来修饰私方法、静态方法、final方法、final修饰的类

2. interface接口

   一个注意点：

   在局部内部类的方法中（比如，show），如果调用局部内部类所声明的方法（比如method）中的局部变量（比如num），则要求**此局部变量需要声明为final的**。

   此时传递的num为一个副本，无法进行修改原版的num。

   

   - jdk 7及之前版本：要求此局部变量显式的声明为final的。
   - jdk 8及以后的版本：可以省略final的声明。

   

## 2. 异常处理

异常内容：

1. 异常概述与异常体系结构
2. 常见异常
3. 异常处理机制一：try-catch-finally
4. 异常处理机制二：throws
5. 手动抛出异常：thros
6. 用户自定义异常类



## 3. 异常概述与异常体系结构

在使用计算机语言进行项目开发的过程中，即使程序员吧代码写的尽善尽美，在系统的运行过程中仍然会遇到一些问题，因为很多问题不是靠代码能够避免的而，比如：**客户输入数据的格式，读取文件是否存在，网络是否始终通畅**等等。



- 异常：在Java语言中，将程序执行中发生的不正常情况称为”异常“（开发过程中的语法错误和逻辑错误不是异常）。
- Java程序在执行过程中所发生的异常时间可分为两类：
  - **Error**：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如: **StackOverflowError** 和 **OOM**。一般不编写针对性的代码进行处理。
  - **Exception**：其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如：
    - **空指针返回**
    - **试图读取不存在的文件**
    - **网络连接中断**
    - **数组角标越界**

- 对于这些错误，一般有**两种解决方法**：一是遇到错误就终止程序的运行；另一种方法是由程序员在编写程序时，就考虑到错误的检测、错误消息的提示，以及错误的处理。
- 捕获错误最理想的是在**编译期间** ，但有的错误只有在**运行时**才会发生。比如：**除数为0，数组下标越界等**
  - 分类：**编译时异常** 和 **运行时异常**



### 1. 异常体系结构

java.lang.Throwable

​	|----------- java.lang.Error: 一般不编写针对性的代码进行处理

​	|------------java.lang.Exception: 可以进行异常的处理

​			|-------------------编译时异常（checked）：IOException（FileNotFoundException）、ClassNotFoundException

​			|-------------------运行时异常（unchecked）: NullPointException、ArrayIndexOutofBoundException、ClassCastException、NumberFormatException、InputMismatchException、InputMisatchException、ArithmeticException



面试题：常见的异常有哪些？举例说明。

```java
package RunExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description: 异常测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/14 15:01
 * @node: 异常体系结构
 * 
 *        java.lang.Throwable
 * 
 *        ​|----------- java.lang.Error: 一般不编写针对性的代码进行处理
 * 
 *        ​|------------java.lang.Exception: 可以进行异常的处理
 * 
 *        |-------------------编译时异常（checked）：IOException（FileNotFoundException）、ClassNotFoundException
 * 
 *        ​|-------------------运行时异常（unchecked, RunExceptionTest）:
 *        NullPointException、ArrayIndexOutofBoundException、ClassCastException、
 *        NumberFormatException、InputMismatchException、ArithmeticException
 */

public class ExceptionTest {
    public static void main(String[] args) {

        /** 一 、 运行时异常 */
        {
            // 1.1. NullPointException 异常
            int[] arr = null;
            // System.out.println(arr[1]); // Exception : java.lang.NullPointException

            // 1.2. ArrayIndexOutofBoundException 异常
            arr = new int[3];
            // System.out.println(arr[3]); // Exception :
            // java.lang.ArrayIndexOutOfBoundsException

            // 1.3. StringIndexOutOfBoundsException 异常
            if (false) {
                String str = new String("abc");
                System.out.println(str.charAt(4));
            }

            // 1.4. ClassCastException 异常
            if (false) {
                Object obj = new Date();
                String str = (String) obj; // Exception : java.lang.ClassCastException
            }

            // 1.5. NumberFormatException 异常
            if (false) {
                String str = "123";
                Integer in = Integer.parseInt(str);
                System.out.println("in = " + in);

                str = "abc";
                in = Integer.parseInt(str); // Exception : java.lanag.NumberFormatException
                System.out.println("in = " + in);
            }

            // 1.6. InputMismatchException 异常
            if (false) {
                Scanner sc = new Scanner(System.in);
                int k = sc.nextInt(); // 如果此时输入不是整数，则会报 java.util.InputMismatchException 异常
                System.out.println("k = " + k);
                sc.close();
            }

            // 1.7. ArithmeticException 异常
            if (false) {
                int a = 10;
                int b = 0; // 分母为0，报 java.lang.ArithmeticException 的异常
                System.out.println(a + " / " + b + " = " + (a / b));
            }
        }

        /** 二、编译时异常 */
        {
            // 2.1 IOException（FileNotFoundException） 异常
            if (false) {
                File file = new File("hello.txt");
                FileInputStream fis = new FileInputStream("file"); // java.io.FileInputStream.FileInputStream(File file)
                                                                   // throws FileNotFoundExceptio
                int data = fis.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = fis.read();
                }

                fis.close();
            }
        }
    }
}

```



##  4. 异常处理机制一：try-catch-finally

在编写程序时，经常要**在可能出现错误的地方加上检测的代码**，如进行x/y运算时，要**检测分母为0，数据为空，输入的不是数字而是字符**等。过多的if-else分支会导致程序的代码加长、臃肿、可读性差。因此采用**异常处理机制**。

Java采用的异常处理机制，是将异常处理的程序代码集中在一起，与正常的程序代码分开，使得程序简洁、优雅，并易于维护。

异常处理过程：抓抛模型

- 过程一：“抛”：
  - 程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。并将此对象抛出。
  - 一旦抛出对象以后，其后的代码便不再执行。

- 过程二：“抓”
  - 可以理解为异常的处理方式：1）try-catch-finally 2) throws

### 4.1 try-catch-finally 的使用

```java
try {
	// 1. 可能出现异常的代码
} catch(异常类型1 变量名1){
	// 2.1 对出现异常的代码的处理
} catch(异常类型2 变量名2){
	// 2.2 对出现异常的代码的处理
} catch(异常类型3 变量名3){
	// 2.3 对出现异常的代码的处理
} ... 
finally {
	// 3. 将一定会执行的代码放在这里
}
```



说明：

1. finally是可选的

2. 使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象的类型，去catch中进行匹配。

3. 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。**一旦处理完成后，会跳出当前的try-catch结构**（在没有写final的情况下），然后继续执行剩下的代码。

4. catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓。

   **catch中的异常类型如果满足子父类要求，则要求子类一定声明在父类的上面。否则会报错。**

5. 常用的异常对象处理的方法：

   1. String getMessage();
   2. printStackTrace(); // 打印堆栈信息

6. 在try结构中声明的变量，当出了try结构追偿吧，就不可以再调用了。

   可以将变量声明在try外面，但是在try的语句块中赋值。

- 体会1：使用try-catch-finally处理编译时异常，使得程序在编译时不再报错，但是运行时仍可能报错。

​		   相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。

- 体会2：开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally。针对编译时异常，我们一定要考虑异常的处理。

```java
package RunExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 异常处理过程一：try-catch-finally
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/14 15:01
 * @node: try-catch-finally
 */
public class ExceptionTest1TryCatch {
    public static void main(String[] args) {
        // 1. try-catch 异常测试1
        {
            String str = "123";
            str = "abc";
            try {
                int num = Integer.parseInt(str);
                System.out.println("str转换成功，num = " + num);

            } catch (NumberFormatException e) {
                // 在catch中的常用方法 1. String getMessage() 2. printStackTrace()
                // System.out.println(e);
                // System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("数值转换失败，请检查输入是否正确！");
            } catch (NullPointerException e) {
                System.out.println("出现空指针异常，请检查变量初始化！");
            } catch (Exception e) { // 因为Exception处于高层，因此需要放在后面
                System.out.println("出现异常");
            }

            System.out.println("str = " + str);
        }

        // 2. 对编译异常进行try-catch处理
        {
            // 将编译时异常进行try-catch处理，此时可以使得编译不再进行报错
            try {
                File file = new File("hello.txt");
                FileInputStream fis = new FileInputStream("file"); //

                // throws FileNotFoundExceptio
                int data = fis.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = fis.read();
                }

                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

```



### 4.2 try-catch-finally 中finally的作用

1. finally为可选的
2. finally中声明的代码是一定会被执行的，即使catch中又出现异常了，try中又return语句，catch中有return语句等情况。
3. 什么情况下会把代码写到finally之中：
   - 像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源释放。此时的资源当中，就需要声明在finally中。



## 5. 异常处理的方式二：throws + 异常处理

1. `throws + 异常类型` 写在方法声明处。指明此方法执行时，可能会抛出异常类型。

   一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类对象，此对象满足throws异常类型时，就会被抛出。

   此时异常代码后面的代码，就不会再被执行。

2. 体会：

   1. try-catch-finally: 真正的将异常给处理掉了
   2. throws的方式只是将异常抛给了方法的调用者，并没有真正的将异常处理掉。

## 6. 子类重写的规则之一：

1. 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
2.  如果父类中没有抛异常，则子类一定不可以抛出异常



## 7. 开发中选择那种方式进行异常处理？

1. 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果子类重写的方法中有异常，必须使用try-catch-finally方式处理。
2. 在执行方法a时，先后又调用了另外的几个方法，这几个方法时递进关系执行的。我们建议这几个方法使用throws的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理。



## 8. 手动抛出异常

关于异常对象的产生：系统自动生成的异常对象；手动的生成一个异常对象，并抛出（**throw**）

```java
package RunExceptionTest;

/**
 * @Description: 手动抛出异常测试
 * @author : mr.zhi(zhilx1997@sina.com)
 * @version: v1.1
 * @data: 2022/01/16 08:55
 * @node: 手动抛出异常：
 *        1. 关于异常对象的产生：系统自动生成的异常对象；
 *        2. 手动的生成一个异常对象，并抛出（**throw**）
 */
public class ExceptionThrowTest {
    public static void main(String[] args) {
        try {
            Person p = new Person();
            p.Register(-11);
            System.out.println(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Person {
    private int id;

    public void Register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            // 1. 通过打印来通知用户
            System.out.println("输入ID需要为正整数！");

            // 2. 通过throw进行异常的抛出，运行时异常可以不进行处理
            // throw new RuntimeException("throw: 输入ID需要为正整数！");

            // 3. 通过thros进行异常的抛出，非运行时异常必须进行try-catch的处理
            throw new Exception("throw: 输入ID需要为正整数！");
        }
    }

    @Override
    public String toString() {
        return "Person[id = " + id + "]";
    }
}

```



## 9. 用户自定义异常类

1. 需要继承与现有的异常结构：RuntimeException、Exception

2. 提供一个全局常量 `serialVersionUID`，每个异常类有一个唯一的并且不同的UID。

3.  提供重载的构造器

   ```java
   package RunExceptionTest;
   
   /**
    * @Description: 自定义异常类
    * @author : mr.zhi(zhilx1997@sina.com)
    * @version: v1.1
    * @data: 2022/01/16 09:10
    * @node: 自定义异常类注意事项：
    *        1. 需要继承与现有的异常结构：RuntimeException、Exception
    *        2. 提供一个全局常量 `serialVersionUID`，每个异常类有一个唯一的并且不同的UID。
    *        3. 提供重载的构造器
    */
   
   // 1. 需要继承与现有的异常结构：RuntimeException、Exception
   public class MyExceptionClass extends RuntimeException {
       // 2. 提供一个全局常量 `serialVersionUID`，每个异常类有一个唯一的并且不同的UID。
       static final long serialVersionUID = -7034897190745766939L;
   
       // 3. 提供重载的构造器
       public MyExceptionClass() {
   
       }
   
       public MyExceptionClass(String msg) {
           super(msg);
       }
   }
   
   ```

   

## 10. 异常的处理联系

1. 异常的基本处理

   ```java
   package RunExceptionTest;
   
   /**
    * @Description: 异常测试1
    * @author : mr.zhi(zhilx1997@sina.com)
    * @version: v1.1
    * @data: 2022/01/16 09:25
    * @node: 异常联系：基本使用
    */
   public class ReturnExceptionDemo {
       // 1. 创建异常1
       static void method1() {
           try {
               System.out.println("Input Method A");
               // 在抛出异常前会先处理finally语句块中的代码，因此“用A方法的finally”会优先运行
               throw new RuntimeException("制作异常");
           } finally {
               System.out.println("用A方法的finally");
           }
       }
   
       // 2. 创建method2
       static void method2() {
           try {
               System.out.println("Input Method B");
               return;
           } finally {
               System.out.println("用B方法处理异常");
           }
       }
   
       public static void main(String[] args) {
           try {
               method1();
           } catch (RuntimeException e) {
               System.out.println(e.getMessage());
           }
   
           System.out.println("-----------------------------");
   
           method2();
       }
   }
   
   -------------------输出-----------------
   Input Method A
   用A方法的finally
   制作异常
   -----------------------------
   Input Method B
   用B方法处理异常
   ```

   

2. 练习

   ```
   1. 编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
      对数据类型不一致（NumberFormatException）、缺少命令行参数  （ArrayIndexOutOfBoundException）、除0（ArighmeticException）及输入负数（EcDef自定义的异常）进行异常处理
   2. 提示：
   	(1) 在主类（EcmDef）中定义异常方法（ecm）完成两数相除功能。
   	(2) 在main() 方法中使用异常处理语句进行异常处理。
   	(3) 在程序中，自定义对应输入负数的异常类（EcDef）。
   	(4) 运行时接受参数 java EcmDef 20 10 // args[0] = "20", args[1] = "10"
   	(5) Integer类的static方法parseInt(String s)将s转换为对应的int值。
   ```

   

## 11. 总结 ：异常处理的5个关键字

<img src="D:\Program Files (x86)\JavaProject\1-Java基础部分\JavaProject3\JavaProject3\src\Execption - 异常处理\Java知识点3 - 异常处理.assets\image-20220116101323256.png" alt="image-20220116101323256" style="zoom:67%;" />

throw为生成一个异常对象

throws为抛出一个异常
