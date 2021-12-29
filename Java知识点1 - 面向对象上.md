### Java

# 一、Java 知识

## 1. JRE and JDK

1.  **JRE (Java Runtim Environment)**

     JRE 是Java程序运行时环境，包括JVM和运行时所需要的核心类库，我们想要运行一个已有的Java程序，那么只需要安装JRE即可。

2.  **JDK (Java Development Kit)**

     是Java程序开发工具包，**包括JRE**和开发人员使用的工具。

     其中的开发工具包括：编译工具（**javac.exe**）和 运行工具（**Java.exe**）。

     我们想要开发一个全新的Java程序，那么必须安装JDK。

![image-20211202112716534](D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211202112716534-16384241438062.png)

## 2. 常用DOS命令

| 操作               | 说明                             |
| ------------------ | -------------------------------- |
| 盘符名称           | 盘符切换。E: 回车，表示切换到E盘 |
| dir                | 查看当前路径下的内容             |
| cd 目录            | 进入单级目录                     |
| cd ..              | 回退到上一级目录                 |
| cd 目录1\目录2\... | 进入多级目录。cd itheima\JavaSE  |
| cd \               | 回退到盘符目录                   |
| cls                | 清屏                             |
| exit               | 退出命令提示符窗口               |



## 3. HelloWorld案例

1. 代码的编写(Helloworld.java)

   ```java
   public class HelloWorld {
       public staic void main(String[] args) {
           System.out.println("Hello World!");
       }
   }
   ```

2. 编译

   - cd 到java的目录

   - 使用javac命令进行编译：javac Helloworld.java，此时会生成 Helloworld.class

3. 运行

   java Helloworld

## 4. Bug 的解决

1. 具备识别 BUG 的能力（多看）

2. 具备分析 BUG 的能力（多思考，多查阅资料）

3. 具备解决 BUG 的 能力（多尝试、多总结）

   

# 二、基础知识

## 2.1  基础语法

### 1. 注释

注释分类：

- 单行注释： // 注释信息
- 多行注释： /* 注释信息 */
- 文档注释： /** 注释信息 */

### 2. 关键字

- 关键字：就是被 Java 语言赋予了特定含义的单词
- 关键字特定：关键字的字母**全部小写**

### 3. 常量

| 常量类型   | 说明                 | 举例                    | 输出           |
| ---------- | -------------------- | ----------------------- | -------------- |
| 字符串常量 | 用双括号括起来的内容 | "HelloWorld", "mr.zhi"  | 可打印         |
| 整数常量   | 不带小数的数字       | 666, -88                | 可打印         |
| 小数常量   | 带小数的数字         | 13.14，-5.21            | 可打印         |
| 字符常量   | 用单括号括起来的内容 | 'A'，'0',  '我'         | 可打印         |
| 布尔常量   | 布尔值，表示真假     | 只有两个值：true, false | 可打印         |
| 空常量     | 一个特殊的值，空值   | null                    | 不可以直接输出 |

note：空常量不可以直接输出，因为编译无法通过

### 4. 数据类型

1. 基本数据类型：
   - 数值型：整数(byte、short、int、long)、浮点数(float、double)、字符(char，**占用2字节**)
   - 非数值型：布尔(boolean)
2. 引用数据类型：
   - 类(class)
   - 接口(interface)
   - 数组([])

![image-20211202134848593](D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211202134848593-16384241357351-16407554065061.png)



### 5. 变量

注意事项：

1. 当定义long类型时，为了防止整数过大，需要在右侧加 'L' : long l = 1000000000L;
2. java中浮点数默认为double类型的，如果要改变为float，需要在最后加 f : float f = 13.14f;

### 6. 标识符

1. 标识符定义规则：
   - 由**数字、字母、下划线**和**美元符号($)**组成；
   - 不能以数字开头
   - 不能是关键字
   - 区分大小写

2. 常见命名约定

   **小驼峰命名法：方法、变量**

   1. 标识符是一个单词的时候， 首字母小写：name（小驼峰法）
   2. 标识符由多个单词 组成的时候，第一个单词的 首字母小写，其他单词的首字母大小：firstName （小驼峰法）

   **大驼峰命名法：类 **

   1. 标识符是一个单词的时候， 首字母大写：Student
   2. 标识符由多个单词 组成的时候，第一个单词的 首字母大写，其他单词的首字母大小：GoodStudent

### 7. 类型转换

1. 自动类型转换

   把一个表示数据范围小的数值或者变量赋值给另一个表示数据范围大的变量   : double b = 10;

   byte ---> short  --->

   ​								int ---> long ---> float ---> double

   ​			   char  --->

2. 强制类型转换

   把一个表示数据范围大的数值或者变量赋值给另一个表示数据范围小的变量 

   格式：目标数据类型  变量名 = (目标数据类型)值或者变量

   范例：int k = (int) 88.88;



## 2.2 运算符

1. 算数表达式中包括多个基本数据类型的值的时候，整个算数表达式的**类型**会自动进行提升。

   提升规则：

   - byte类型，short类型和char类型将被提升至 int 类型

   - 整个表达式的类型自动提升到表达式中最高等级操作数同样的类型

     等级顺序：byte,short,char -> int -> long -> float -> double

2. 字符串的 “+” 操作

   - 当 “+” 操作符中出现字符串时，这个 ”+“ 是**字符串连接符**，而不是算数运算。example : “hello" + 666

   - 当 ”+“ 操作中，如果出现了字符串，就是连接运算符，否则就是算数运算符。当连续进行 ”+“ 操作时，从左到右依次执行

   ```java
   System.out.println("hello world!");
   System.out.println(666 + "Hello"); 			// 666Hello
   System.out.println("Hello" + 6 + 7 + 8);    // Hello678
   System.out.println(1 + 99 + "hello"); 		// 100hello
   ```

3. 赋值运算符（=）

4. 关系运算符 (==, !=)

5. 逻辑运算符 

   与：&

   或：|

   异或： ^  

   非：!

   短路逻辑运算符（&&, ||）

6. 三目运算符



## 2.3 数据输入

1. 引入头部包
2. Scanner 使用的基本步骤
   - 导入包：import java.util.Scanner;
   - 创建对象：Scanner sc = new Scanner(System.in);
   - 接收数据：int i = sc.nextInt();

## 2.4 switch语句

格式说明：

- 表达式：取值为byte、short、int、char、JDK5以后可以是枚举、JDK以后可以是 String
- case : 后面跟的是要和表达式进行比较的值
- break : 表示中断，结束的意思，用来结束switch语句。
- default : 表示所有情况都不匹配的时候，就执行该语句和if语句的else类型。

## 2.5 Random

作用：产生一个随机数；

使用步骤：

- 导包： import java.util.Random;
- 创建对象：Random r = new Random();   // new Random() 为固定格式，不可以改变
- 获取随机数：int number = r.nextInt(10); // 获取数据的范围，[0, 10)

## 2.6 数组

1. 格式一： 数据类型[] 变量名， int[] arr;

   定义了一个int类型的数组，数组名是arr

2. 格式二： 数据类型    变量名[], int  arr[];

   定义了一个int类型的变量，变量名是arr数组

3. 动态初始化：初始化时只制定数组长度，由系统为数组分配初始值

   格式：数据类型[] 变量名 = new 数据类型[数组长度];

   范例：int[] arr = new int[3];

4. 静态初始化：初始化时指定每个元素的初始值，由系统决定数组长度

   格式1：数据类型[] 变量名 = new 数据类型[] {data1, date2, date3, ...};

   格式2：数据类型[] 变量名 = {data1, data2, data3, ...}；

5. 数组操作的两个小问题：
   - 索引越界
   - 空指针异常
   - null，空置 
   
6. 二维数组

   ```java
   int[][] arr = new int[4][4];
   System.out.println(arr[0]); // 会输出arr[0]的地址
   System.out.println(arr[1]); // 会输出arr[1]的地址
   System.out.println(arr[2]); // 会输出arr[2]的地址
   System.out.println(arr[0][0]);
   
   int[][] arr2 = new int[4][0];	// 如果不指定第二维度的大小，则默认为空，此时
   System.out.println(arr2[0]); // 会输出arr[0]的地址，为null
   System.out.println(arr2[1]); // 会输出arr[1]的地址，为null
   System.out.println(arr2[2]); // 会输出arr[2]的地址，为null
   System.out.println(arr[0][0]);	// error: 因为arr[0] = null，因此不可以方法
   ```

   

## 2.7 方法 （相当于C/C++ 中的函数）

方法（method）是将具有独立功能的代码块组成一个整体，使其具有特殊功能的代码集；

注意：

- 方法必须先创建才可以使用，该过程称为方法定义；
- 方法创建后并不是直接运行的，需要手动使用后才创建，该过程称为方法调用

1. 方法定义

   格式：

   ```java
   public static void 方法名() {
   	// 方法体
   }
   ```

   ```java
   public staticc void isEventNumber() {
   	// 方法体
   }
   ```

   

2. 方法调用

   ```
   格式： 方法名();
   案例： isEventNumber();
   ```

3. 注意事项
   - 方法不能嵌套定义
   - void 表示无返回值 ，可以省略return，也可以单独书写return, 后面不加数据。

4. 方法重载 （相当于C++ 中的函数重载）
5. 方法的参数传递



## 2.8 package 和 import

1. packet关键字的使用

   - 为了更好的实现项目中类的 管理，提供包的概念

   - 使用package声明或接口所属的包，声明在源文件的首行

   - 包，属于标识符，遵循标识符的命名规则、规范（xxxyyyzzz）、“见名知意”

   - 每"."一次，就代表一层文件目录

     ```
     package com.mrzhi.array;	// 表示在com/mrzhi/array的第三层
     ```

   - **同一个包下，不能命名同名的接口、类；不同的包下，可以命名相同的接口、类**

     | JDK中常用的包 | 介绍                                                         |
     | ------------- | ------------------------------------------------------------ |
     | java.long     | 包含一些Java语言的核心类，如String、Math、Integer、System和Thread，提供常用功能 |
     | java.net      | 包含执行与网络相关的操作类和接口                             |
     | java.io       | 包含能提供多种输入/输出功能的类                              |
     | java.util     | 包含一些使用工具类 ，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数。 |
     | java.text     | 包含一些Java格式化相关的类                                   |
     | java.sql      | 包含了Java进行JDBC数据库编程的相关类/接口                    |
     | java.awt      | 包含了构成抽象窗口工具集（abstract window toolkits）的多个类，这些类被用来构建和管理应用程序的图形用户界面（GUI） |

     

2. import 关键字的使用

   import: 为了导入包

   - 在源文件中显式的使用Import结构导入指定包下的类、接口；

   - 声明在包的声明和类的声明之间

   - 如果需要导入多个结构，则并列写出即可

   - 可以使用"xxx. *"的方式，表示可以导入xxx包下的所有结构

   - 如果使用的类或者接口是java.lang包下的，则可以省略import结构

   - 如果使用的类或者接口是本包下定义的，则可以省略import结构

   - 如果在源文件中，使用了不同包下的同名类，则必须至少有一个类需要以 **全类名** 的方式显示

     ``` java
     com.mrzhi.exer3.Account acct1 = new com.mrzhi.exer3.Account(1000,3000,23.2);	// 全类名的方式显示
     ```

   - 使用“xxx.*"方式表明可以调用xxx包下的所有结构。但是如果使用的是xxx子包下的结构，则仍需要显式导入

   - import static ：导入指定**类或接口中**的静态结构: 属性或方法

     ```java
     import static java.long.System.*; 	// 不可以以System结尾，必须指定System中的结构
     import static java.long.Math.*;
     
     out.println("HelloWorld");	// 相当于System.out.println("Helloworld");因为上面导入了静态结构，所以可以直接使用
     long k = round(123.321);		// 相当于 int k = Math.round(123.321);
     
     ```

     



# 三、面向对象基础

### question：

#### 1. 构造器的作用是什么？使用中有哪些注意点（>=3条）

作用：
① 创建对象。
② 初始化成员变量。

注意点：
①构造器=构造方法
② 构造方法的方法名要与类名一致。
③ 构造方法无返回类型。
④ 不能使用private修饰，会导致外部无法创建对象
⑤ 可以多个构造器，构成重载
⑥ 构造方法不能继承，可以使用super关键字调用

#### 2. 关于类的属性的赋值，有几种赋值的方式。谈谈赋值的先后顺序

① 默认初始化、

② 显示初始化

③ 构造器中初始化

④ 对象\方法 或 对象\属性给属性赋值

#### 3. this关键字可以用来调用哪些结构，简单说明一下其作用。

调用结构：属性、方法、构造器

作用：

#### 4. Java中目前学习涉及到的四种权限修饰符都有什么？并说明其各自的范围权限。

1. private: Java语言中对访问权限限制的最窄的修饰符，一般称之为“私有的”。被其修饰的属性以及方法只能被该类的对象访问，其子类不能访问，更不能允许跨包访问。
2. default：即不加任何访问修饰符，通常称为“默认访问权限“或者“包访问权限”。该模式下，只允许在同一个包中进行访问。
3. protected: 介于public 和 private 之间的一种访问修饰符，一般称之为“保护访问权限”。被其修饰的属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。
4. public： Java语言中访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且允许跨包访问。



这里需要注意的是，所谓的访问，可以分为两种不同方式：第一，通过对象实例访问；第二，直接访问。

比如说，某父类protected权限的成员，子类是可以直接访问的，换一种说话是子类其实继承了父类的除了private成员外的所有成员，包括protected成员，所以与其说是子类访问了父类的protected成员，不如说子类访问了自己的从父类继承来的protected成员。另一方面，如果该子类与父类不在同一个包里，那么通过父类的对象实例是不能访问父类的protected成员的。

[Java四种访问权限限制_Snail_gogo的博客-CSDN博客_java的四种访问权限](https://blog.csdn.net/Snail_gogo/article/details/80462408)

| 权限      | 类内 | 同包 | 不同包子类 | 不同包非子类 |
| :-------- | :--- | :--- | :--------- | :----------- |
| private   | √    | ×    | ×          | ×            |
| default   | √    | √    | ×          | ×            |
| protected | √    | √    | √          | ×            |
| public    | √    | √    | √          | √            |



#### 5. 创建Circle类，提供私有的radius属性，提供相应的get和set方法 ，提供求圆面积的方法。

## 3.1 类

### 3.3.1 类和对象

类：类是对现实生活中一类具有共同属性和行为的事物的抽象。

类的特点：

- 类是对象的数据类型；
- 类是具有相同属性和行为的一组对象的就集合.

对象的属性：

- 属性：对象具有的各种特征，每个对象的每个属性都拥有特定的值。

对象的行为：对象能够执行的操作。

类和对象的关系：

- 类：类是对现实生活中一类具有共同属性和行为的事物的抽象；
- 对象：是能够看得到的真实存在的实体。

### 3.3.2 类的定义

类的重要性：是Java程序的基本组成单位。

类是什么：是对现实生活中一类具有共同属性和行为的事物的抽象，确定对象将会拥有的属性和行为。



类的组成：属性和行为

- 属性：在 类中 通过**成员变量**来体现（类中方法外的变量）
- 行为：在 类中 通过**成员方法**来体现（和前面的方法相比去掉static关键字即可）

类的定义：

- 定义类
- 编写类的成员变量
- 编写类的成员方法

```java
public class 类名 {
	// 成员变量 
	变量1的数据类型 变量1;
	变量2的数据类型 变量2;
	.....
	// 成员方法啊
	方法1;
	方法2;
	.....
}
```



### 3.3.3 对象的使用

创建对象：

- 格式：类名 对象名 = new 类名();

- 范例：Phone p = new Phone();

使用对象：

1. 使用成员变量
   - 格式：对象名.变量名
   - 范例：p.brand
2. 使用成员对象
   - 格式：对象名.方法名()
   - 范例：p.call()

3.3.4 类中的成员和局部变量的区别

| 区别           | 成员变量                                   | 局部变量                                         |
| -------------- | ------------------------------------------ | ------------------------------------------------ |
| 类中位置不同   | 类中方法外                                 | 类中的方法内或者方法声明上                       |
| 内存中位置不同 | 堆区                                       | 栈区                                             |
| 生命周期不同   | 随着对象的存在而存在，随着对象的消失而消失 | 随着方法的调用而存在，随着方法的调用完毕也消失   |
| 初始化值不同   | 有默认的初始化值                           | 没有默认的初始化值，**必须先定义**，赋值才能使用 |

## 3.3 封装 （OPP特征之一）

### 3.3.1 private 关键字

- 是一个权限修饰符；
- 可以修饰成员（成员变量和成员方法）；
- 作用是保护成员不被别的类所使用，被private修饰的 成员只能在本类中才能访问。

针对private修饰的成员变量，如果需要看被其他类使用，可以提供相应的操作：

- 提供 “get变量名()” 方法，用于获取成员变量的值，方法用public修饰；
- 提供 “set变量名(参数)" 方法，用于设置成员变量的值，方法用public修饰。

### 3.3.2 this 关键字

1. this 修饰的变量用于指代成员变量
   - 方法的形参如果与成员变量同名，不带this修饰的变量指的是 形参，而不是成员变量
   - 方法的形参没有与成员变量同名，不带this修饰的变量指的是 成员变量
2. 什么时候使用this：
   - 解决局部变量隐藏成员变量
   - 返回类自身
3. this： 代表所在类的对象引用（方法被那个对象调用，this就代表哪个对象）

<img src="D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211204153246626-16407554175382.png" alt="image-20211204153246626" style="zoom:67%;" />

![image-20211204153422788](D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211204153422788-16407552768441.png)



### 3.3.3 封装

封装是面向对象三大特征之一（封装、继承、多态），是面向对象编程语言对客观世界的模拟，客观世界里成员变量都是隐藏在对象内部中，外界是无法直接操作的。

封装原则：将类的某些信息隐藏在类内部，不允许外部程序直接访问，而是通过该类提供的方法来实现对隐藏信息的操作和访问。

成员变量 private，提供对应的 getXxx() / SetXxx() 方法。

封装优点：通过方法来控制成员变量的操作，提高了代码的安全性。把代码用方法进行控制，提高了代码的复用性。

### 3.3.4 构造方法

构造方法是一种特殊的方法：

作用：创建对象

功能：主要是完成对象数据的初始化

```java
public class 类名 {
	修饰符 类名(参数) {	// 修饰符一般为 public
	}
}
```

**注意事项**：

1. 构造方法的创建

   - 如果没有定义构造方法，系统将给出一个默认的无参构造方法
   - 如果定义了构造方法，则系统将不再提供默认的构造方法

2. 构造方法的重载

   - 如果自定义了带参数的构造方法，还要使用无参构造方法，就必须再写一个无参构造方法

3. 推荐的使用方法：

   无论是否使用，都书写无参构造方法

### 3.3.5 标准类制作

1. 成员变量：使用private修饰
2. 构造方法：
   - 提供一个无参构造方法；
   - 提供一个带多个参数的构造方法。
3. 成员方法：
   - 提供没一个成员变量对应的setXxx()/getXxx()；
   - 提供一个显示对象信息的show();
4. 创建对象并为其成员变量赋值的两种方式



## 3.4 API

###  3.4.1 API概述

API（Application Prograamming Interface）：应用程序编程接口

Java API : 指的就是JDK中提供的各种功能的Java类，这些类将底层的实现封装了起来，我们不需要关心这些类是如何实现的，只需要学校这些类如何使用即可，我们可以通过帮助文档来学习这些API如果使用。



## 3.5 String

概述：String 类在java.lang包下，所以使用的时候不需要导包

String类代表字符串，Java程序中的所有字符串文字（例如“abd"）都被实现为此类的实例，也就是说，Java程序中的所有的双引号字符串，都是String类的对象。



1. 字符串的特点：

- 字符串不可变，它们的值在创建后不能被更改
- 虽然`String`的值是不可变的，但是它们可以被共享
- 字符串效果上相当于字符串数组（char[]），但是底层原理是字节数组（byte[]）(JDK8及以前为字符数组，JDK9及以后为字节数组 )

```java
// 不适用构造方法，直接赋值的方式来创建对象
String str = "helloWorld!";
System.out.println(str);
str = "this is a test!";
System.out.println(str);

// public String(String str);
str = new String("helloworld");
System.out.println(str);

// public String(char[] chs); // 根据字符数组的内容，来创建字符串对象
char[] chs = { 'a', 'b', 'c' };
str = new String(chs);
System.out.println(str);

// public String(byte[] chs); // 根据字节数组的内容，来创建字符串对象
byte[] bys = { 97, 98, 99 };
str = new String(bys);
System.out.println(str);
```

2. String对象的特点

   1. 通过`new`创建的字符串对象，每一次new都会申请一个内存空间，虽然内容相同，但是地址值不同。

      ```java
      char[] chs = {'a', 'b', 'c'};
      String s1 = new String(chs);
      String s2 = new String(chs);
      ```

      上面的代码中，JVM会首先创建一个字符数组，然后每一次new的时候都会有一个新的地址，只不过s1和s2参考的字符串内容是相同的。

   2. 以 `“ ”` 方式给出的字符串，只要字符序列相同（顺序和大小写），无论在程序代码中出现几次，JVM都只会创建一个String对象，并在字符串池中维护。

      ```java
      String s3 = "abd";
      String s4 = "abd";
      ```

      在上面的代码中，针对第一行代码，JVM会建立一个String对象放在字符串池中，并给s3参考；第二行则让s4直接参考字符串池中的String对象，也就是说它们本质上是同一个对象。

      ```java
      // public String(char[] chs); // 根据字符数组的内容，来创建字符串对象
      char[] chs = { 'a', 'b', 'c' };
      String str3 = new String(chs);
      String str4 = new String(chs);
      System.out.println("str3 == str4 ? " + (str3 == str4));	// 输出false
      
      String str5 = "abc";
      String str6 = "abc";
      System.out.println("str5 == str6 ? " + (str5 == str6));	// 输出true
      ```

      

<img src="D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211205104212295-16386724212371-16407554253603.png" alt="image-20211205104212295" style="zoom:67%;" />

​	

### 		3.5.1 String 类型比较

​				使用 == 做比较

- 基本类型：比较的是**数据值**是否相同；		

- 引用类型：比较的是**地址值**是否相同。

  字符串是对象，它比较内容是否相同，是通过一个方法来实现的，这个方法叫：equals();

  `public boolean equals(Object anObjcet):` 将此字符串与制定对象进行比较。由于我们比较的是字符串对象，所以参数直接传递一个字符串。

```Java
public class StringDemo01 {
    public static void main(String[] args) {
        // 使用构造方法得到对象
        char chs[] = { 'a', 'b', 'c' };
        String s1 = new String(chs);
        String s2 = new String(chs);

        // 直接赋值方式得到对象
        String s3 = "abc";
        String s4 = "abc";

        // 比较字符串对象地址是否相同
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("-------------");

        // 比较字符串内容是否相同
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }
}
```

```
输出：
false
false
true
-------------
true
true
true
```

### 3.5.2 String方法（帮助文档中）

| 方法名                                 | 说明                             |
| -------------------------------------- | -------------------------------- |
| public boolean equals(Object anObject) | 比较字符串的内容，严格区分大小写 |
| public char charAt(int index);         | 返回指定索引处的char值           |
| public int length();                   | 返回此字符串的长度               |



## 3.6 StringBuilder

### 3.6.1 StringBuilder概述

```
String str = "hello";	// 
str += "world";			// 此时会重新构建一个helloworld的字符串，位于动态区，然后将其赋值给str。
```

note：如果对字符串进行拼接操作，每次拼接，都会构建一个新的String对象，即耗时，又浪费内存空间，而这种操作还不可避免。那么有没有一种比较好的方法可以解决这个问题呢？Java中提供了StringBuilder类来解决这个问题。



StringBuilder 是一个可变的字符串类，我们可以把它看成是一个容器。

这里的可变指的是 StringBuilder 对象中的内容是可变的。



String 和 StringBuilder 的区别：

- String：内容是不可变的
- StringBuilder: 内容是可变的



### 3.6.2 StringBuilder 构造方法

| 方法名                           | 说明                                        |
| -------------------------------- | ------------------------------------------- |
| public StringBuilder()           | 创建一个 空白可变字符串对象，不含有任何字符 |
| public StringBuilder(String str) | 根据字符串的内容，来创建可变字符串对象      |



## 3.7 继承性（OPP特征之二）

关键字：extends （java中不支持多继承，或菱形继承）

```java
class A extends B {}
// A: 子类、派生类、subClass
// B: 父类、超类、基类、superClass
```

### 1 优点：

1. 减少了代码的冗余，提高了代码的复用性
2. 便于功能的扩展
3. 为之后多态性的使用，提供了前提。

体现：一旦子类A继承父类B之后 ，子类A中就获取了父类B中声明的所有的属性和方法。特别地，父类中声明的private的属性或方法，子类继承父类后，仍然认为获取了父类中私有的结构。只是因为封装性的影响，使得子类不能直接调用父类的结构而已。

note:  **Java 只支持单继承和多层继承，不允许多重继承。**

- 一个子类只能有一个父类；

- 一个父类可以派生出多个子类

  ```java
  class SubDemo extends Demo{} // ok
  class SubDemo extends Demo1, Demo2, ... // error
  ```

  <img src="D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211211101628982-16392133078152-16407554335834.png" alt="image-20211211101628982" style="zoom:67%;" />

### 2 Oject类

顶层类（父类）

1. 如果我们没有显示的声明一个类的父类的话，则此类继承与 `java.lang.Object` 类
2. 所有的java类 (除java.lang.Object类之外) 都会直接或者间接的继承与java.lang.Object类
3. 意味着，所有的java类都具有java.lang.Object类声明的功能。



## 3.8 方法的重写

定义：在子类中可以根据需要对从父类中继承来的方法进行改改造，也称为方法的重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。

要求：

- 子类重写的方法必须和父类被重写的方法具有相同的 **方法名称、参数列表** 
- 子类重写的方法的返回值类型 **不能大于** 父类被重写方法的返回值类型
  - 父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
  - 父类被重写的方法的返回值类型是A类型，则子类重写的方法的返回值类型可以是A类型或A的子类类型
  - 父类被重写的方法的返回值类型 如果是基本数据类型， 则子类重写的方法的返回值类型必须是相同的基本是数据类型
- 子类重写的方法使用的访问权限 **不能小于** 父类被重写的方法的访问权限
  - 子类不能重写父类中声明为private权限的方法
- 子类方法抛出的异常不能大于父类中被重写方法的异常

注意：子类与父类中同名同参数的方法必须同时声明为非static的（即为重写），或者同时声明为static的（不是重写）。因为static方法是属于类的，子类无法覆盖父类的方法。

注意：在不同包的子类中，不能调用Order类中声明为private和缺省权限的属性、方法

​		   不同包下的普通类（非子类）要使用Order类，不可以调用声明为private、缺省、protected权限的属性、方法



## 3.9 四种访问权限修饰符

1. private: Java语言中对访问权限限制的最窄的修饰符，一般称之为“私有的”。被其修饰的属性以及方法只能被该类的对象访问，其子类不能访问，更不能允许跨包访问。
2. default：即不加任何访问修饰符，通常称为“默认访问权限“或者“包访问权限”。该模式下，只允许在同一个包中进行访问。
3. protected: 介于public 和 private 之间的一种访问修饰符，一般称之为“保护访问权限”。被其修饰的属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。
4. public： Java语言中访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且允许跨包访问。



这里需要注意的是，所谓的访问，可以分为两种不同方式：第一，通过对象实例访问；第二，直接访问。

比如说，某父类protected权限的成员，子类是可以直接访问的，换一种说话是子类其实继承了父类的除了private成员外的所有成员，包括protected成员，所以与其说是子类访问了父类的protected成员，不如说子类访问了自己的从父类继承来的protected成员。另一方面，如果该子类与父类不在同一个包里，那么通过父类的象实例是不能访问父类的protected成员的。

[Java四种访问权限限制_Snail_gogo的博客-CSDN博客_java的四种访问权限](https://blog.csdn.net/Snail_gogo/article/details/80462408)

| 权限      | 类内 | 同包 | 不同包子类 | 不同包非子类 |
| :-------- | :--- | :--- | :--------- | :----------- |
| private   | √    | ×    | ×          | ×            |
| default   | √    | √    | ×          | ×            |
| protected | √    | √    | √          | ×            |
| public    | √    | √    | √          | √            |



对于class的权限修饰只可以用 public和default(缺省)

- public类可以在任意地方被修饰
- default类只可以被同一个包内部的类访问



## 3.10 super 关键字

1. super：可以理解为父类的属性

2. super 可以 用来调用：属性、方法、构造器

3. super 的使用：

   - 3.1 我们可以 在子类的 方法或构造器中，通过使用"super.属性"或“super.方法" 的方式， 显式访问父类中声明的属性或方法 。

     但是，通常情况下，我们习惯省略“super"

   - 3.2 特殊情况：当子类和父类中定义了 同名的属性时，我们要想在子类中调用父类中声明的属性，则必须 显式 的使用”super.属性“的方式，表明调用的是父类中的声明属性。

   ```Java
   System.out.println("id = " + this.id);	// 打印子类中的id
   System.out.println("id = " + super.id);	// 打印父类中的id
   this.func();	// 先从子类中寻找func()函数，如果找到则直接调用，如果没有找到则去父类中寻找
   super.func();	// 直接从父类中寻找，如果没有找到则去父类的父类中寻找
   ```

   - 3.3 特殊情况：当 子类重写了父类中的方法以后 ，我们想在子类的方法中调用父类中被重写的方法时，则必须 显式 的使用”super.方法“的方式，表明调用的是父类中的声明方法。

4. super调用构造器

   - 4.1 我们可以在子类的构造器中显式的使用“super(参数列表)”的方式，调用父类中声明的指定的构造器

   - 4.2 “super(参数列表)” 的使用，**必须声明在子类构造器的 首行！！**

   - 4.3 我们在类的构造器中，针对于”this(形参列表)“或“super(参数列表)”只能二选一，不能同时出现。

     ```java
     public Student(String major, String name, int age) {
         super(name, age); // 必须放在首行，不可以放在后面
         // this(); // this()也必须放在首行，因此不可以和super一起使用
         this.major = major;
     }
     ```

   - 4.4 在构造器的首行，如果没有显式的声明”this(形参列表)“或“super(参数列表)”，则默认调用的是父类中空参的构造器：super()
   - 4.5 在类的多个构造器中，至少有一个类的构造器中使用了“super(形参列表)”，调用父类中的构造器

## 3.11 子类对象的实例化过程

1. 从结果来看：（继承性）

   子类继承父类后，就获取了父类中声明的属性或方法；

   创建子类的对象，在堆空间中，就会加载所有 父类中声明的属性

2. 从过程上来看：

   当我们通过子类的构造器创建子类对象时，我们一定会直接或间接的调用其父类的构造器，进而调用父类的父类的构造器，直到调用了Java.lang,Object类中空参的构造器为止。正因为加载过所有的父类的结果，所以才可以看到内存中有父类中的结构，子类对象才可以考虑进行调用。

3. 明确：虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象。



## 3.12 多态性（OOP特征之三）

### 多态属于运行时行为--（动态绑定 ）

1. 多态性，是面向对象中最重要的概念，在Java中的体现：

   **对象的多态性：父类的引用指向子类的对象。**

   - 可以直接应用在抽象类和接口上

2. Java引用变量由两个类型：编译时类型和运行时类型。编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给变量该的对象决定。简称：编译时，看左边；运行时，看右边。

   - ​	**若编译时类型和运行时类型不一致，就出现了对象的多态性（Polymorphism）**

   - ​	**多态情况下，“看左边”：看的是父类的引用**（父类中不具备子类特有的方法）

​					   **”看右边”：看的是子类对象**（实际运行的是子类重写父类的方法）

3. 多态的使用：虚拟方法调用

   有了对象的多态性以后，我们在编译器，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。

4. 多态性的使用前提：

   - 必须有类的继承关系；

   - 要有方法的重写。

5. **对象的多态性，只适用于方法，不适用于属性（此时 名称和运行都看左边）**

6. 虚拟方法调用：

   1. 正常的方法调用

      ```Java
      Person p = new Person();
      p.getInfo();
      Student e = new Student();
      e.getInfo;
      ```

   2. **虚拟方法调用（多态情况下）**

      子类中定义了与父类同名同参数的方法，在多态的情况下，将此时父类 的方法 称为虚拟方法，父类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译器是无法确定的。

      ```java
      Person p = new Student();
      p.getInfo();	// 调用 Student类的getInfo()方法
      ```
      
      note：有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致编译后 ，只能调用父类中声明的属性和方法。子类特有的属性和方法不能使用。
      
      **如何才能调用子类特有的属性和方法？** 进行强制类型转换，将父类转换为子类的类型
      
      

7. 编译时类型和运行时类型

   编译是时p为Person类型，而方法的调用是在运行时确定的，所以调用的是Student类的getInfo()方法 。---**动态绑定**

8. 重载和重写的区别：

   从编译和 运行的角度看：

   重载，是指允许存在多个同名方法，而这些方法的参数不同。编译器根据方法不同的参数表，对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了不同的方法。**它们调用地址在编译期就 绑定了。**Java的重载是可以包括父类和子类的，即子类可以重载父类的同名不同参数的方法。

   所以：对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，这称为**“早绑定“或”静态绑定“**。

   

   而对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要的调用的具体方法，这称为**“晚绑定”或“动态绑定”**。

   引用 Bruce Eckel的一句话，“不要犯傻，如果它不是晚绑定，它就不是多态。”

9. 代码演示

   ```java
   /**
    * @Description: 多态的使用
    *               需要父类的引用指向子类的对象
    * @author : mr.zhi(zhilx1997@sina.com)
    * @version: v1.1
    * @data: 2021/12/15 19:40
    */
   
   /*
    输出：
           狗吃骨头
           汪汪汪
           name = Animal
           ***********************
           猫吃老鼠
           喵喵喵
           name = Animal
           ***********************
           动物吃饭
           动物会叫
           name = Animal
           ***********************
   */
   public class plotMult {
   
       public static void main(String[] args) {
           plotMult test = new plotMult();
   
           test.func(new Dog());
           System.out.println("***********************");
           test.func(new Cat());
           System.out.println("***********************");
           test.func(new Animal());
           System.out.println("***********************");
   
       }
   
       public void func(Animal animal) {
           animal.eat();
           animal.shout();
           System.out.println("name = " + animal.name);
       }
   }
   
   class Animal {
       public void eat() {
           System.out.println("动物吃饭");
       }
   
       public void shout() {
           System.out.println("动物会叫");
       }
   
       String name = "Animal";
   }
   
   class Dog extends Animal {
       public void eat() {
           System.out.println("狗吃骨头");
       }
   
       public void shout() {
           System.out.println("汪汪汪");
       }
   
       String name = "Dog";
   }
   
   class Cat extends Animal {
       public void eat() {
           System.out.println("猫吃老鼠");
       }
   
       public void shout() {
           System.out.println("喵喵喵");
       }
   
       String name = "Cat";
   }
   ```





##  3.13 每日一问

### 	1. 什么是多态性？什么是虚拟方法调用？

​		对象的多态性：父类的引用指向子类的对象

​		虚拟方法的调用：父类的引用调用子类的方法（运行时才确定）

### 	2. 一个类可以有几个父类（一个）？一个父类可以有几个子类（多个）？子类能获取直接父类的父类中的结构吗（可以）？子类能否获取父类中private权限的属性或方法（可以）？

### 	3. 方法的重写（overridee/overwrite）的具体规则有哪些

​		重写：形参列表相同；权限修饰符号不能 小于父类中的权限；不能大于父类的返回值类型 ；抛出的异常

### 	4. super调用构造器，有哪些具体的注意点

​		this(形参列表)：本类重载的其它的构造器

​		super(形参列表)：调用父类中指定的构造器 (也是默认选项)

### 	5. 在下面的代码结构中，使用关键字：this，super；方法的重写；继承

​			

| Circle(圆)                                                   |
| ------------------------------------------------------------ |
| -radius:double                                               |
| Circle(): 构造器，将radius属性初始化为1<br />+setRadius(double radius): void<br />+getRadius():double<br />+findArea():double  计算圆的面积 |

| Cylinder(圆柱)                                               |
| ------------------------------------------------------------ |
| -length:double                                               |
| Cylinder(): 构造器，将length属性初始化为1<br />+setLength(double length): void<br />+getLength():double<br />+findVolume():double  计算圆柱体积<br />findArea():double 计算圆柱的表面积 |



## 3.14 向下转型的使用

子类中定义了与父类同名同参数的方法，在多态的情况下，将此时父类 的方法 称为虚拟方法，父类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译器是无法确定的。

```java
Person p = new Student();
p.getInfo();	// 调用 Student类的getInfo()方法

Student s2 = (Student)p;	// 向下类型转换
s2.study();		// 此时可以调用子类特有的属性和方法
```

note：有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致编译后 ，只能调用父类中声明的属性和方法。子类特有的属性和方法不能使用。

**如何才能调用子类特有的属性和方法？** 进行强制类型转换，将父类转换为子类的类型，此时也可称为向下转型。

<img src="D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211219150313638-16398974220281-16407554426125.png" alt="image-20211219150313638" style="zoom:67%;" />

note: 

- 使用强转时，可能出现ClassCastException的异常
- 使用instanceof关键字可以避免异常

### 1. instanceof

a instanceof A : 判断对象a是否为A的示例，如果是，则返回true；如果不是，则返回false.

使用情景：为了避免在向下转型之前时出现ClassCastException的异常，我们在向下转型之前，先进行instanceeof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。

如果a instanceof A返回true，则a instanceof B 也返回true，则B为A的父类。

```java
// a instanceof A : 判断对象a是否为A的示例，如果是，则返回true；如果不是，则返回false
if (p instanceof Woman) {
	Woman w1 = (Woman)p2;
	w1.goShoppint();
	System.out.println("Woman");
}
```



### 2. 常见问题：

1. 编译时通过，运行时不通过

   ```java
   Person p3 = new Woman();
   Man m3 = (Man)p3;		// 向下类型转换错误，运行时会报错
   
   Person p4 = new Person();
   Man m4 = (Man)p4;		// 运行时错误
   ```

   

2. 编译通过，运行时也通过

   ```java
   Object obj = new Woman();
   Person p = (Person)obj;
   ```

3. 编译不通过

   ```java
   Man m5 = new Woman();	// 编译错误
   String str = new Date();
   ```

4. Person p = s; // 判断p==s?

   ```java
   Student s2 = new Student();
   Person p2 = s2;
   // == ：对于引用数据类型来讲，比较的是两个引用数据类型变量的地址值是否相同，即下面判断的是p2和s2的地址值是否相同
   System.out.println("p2 == s2 ? " + (p2 == s2));	// true
   System.out.println("id = " + s2.id);	// 打印Studen中的id
   System.out.println("id = " + p2.id);	// 打印Person中的id
   ```

   

### 3. 多态代码 

```java
public class InterviewTest1 {
    public static void main(String[] args) {
        Base base = new Sub();
        base.add(1, 2, 3);	// 调用Sub的add(int a, int[] arr)

        Base base2 = new Base();
        base2.add(1, 2, 3, 4, 5, 6);// 调用Base的add(int a, int... arr)

        Sub s3 = new Sub();
        s3.add(1, 2, 3);	// 调用 Sub 的add(int a, int b, int c);
    }
}

class Base {
    public void add(int a, int... arr) {
        System.out.println("base");
        print(arr);
    }

    public void print(int... arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}

class Sub extends Base {
    @Override
    public void add(int a, int[] arr) {
        System.out.println("Sub1");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public void add(int a, int b, int c) {
        System.out.println("Sub2");
    }
}

```

输出：

```
Sub1
2, 3,
base
2, 3, 4, 5, 6,
```



## 3.15 Object类的使用

- Object类是所有Java类的根父类

- 如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类

- 此时Object类中的功能（属性、方法）具有通用性

  - 属性；无
  - 方法：equals() / toString() / getClass() / hashCode() / clone() / finalize() / wait() / notify() 、 notifyAll()
  - Object类中只声明了一个空参的构造器

  ```java
  public class Person {
  	// ...
  }
  // 等价于
  public class Person extends Object {
  	// ...
  }
  ```

- 例如：

  ```java
  method(Object obj) {...} // 可以接收任何类作为其参数
  Person p = new Person();
  method(p);
  ```

  ```java
  // 测试
  public class ObjectTest {
      public static void main(String[] args) {
          Order ord = new Order();
          System.out.println(ord.getClass() + " extends " + ord.getClass().getSuperclass());
      }
  }
  
  class Order {
  
  }
  
  ------------输出------------
  class Order extends class java.lang.Object
  ```

  

## 3.16 垃圾回收机制

垃圾回收机制只回收jVM堆内存里的对象空间

对于其他物理连接，比如数据库连接、输入流输出流、Socket连接无能为力

现在的JVM有多种垃圾回收实现算法，表现各异。

垃圾回收发生具有不可预知性，程序无法精确控制垃圾回收机制执行。

可以 将对象的引用变量设置为null，暗示垃圾回收机制可以回收该对象。

程序员可以通过 System.gc() 或者 Runtime.getRuntime().gc() 来通知系统进行垃圾回收，会有一些效果，但是系统是否进行垃圾回收仍然不确定。

垃圾回收机制回收任何对象之前，总会先调用它的finalize方法（如果覆盖该方法，让一个新的引用百度重新引用该对象，则会重新激活该对象）

**永远 不要主动调用 某个对象的finalize方法，应该交给垃圾回收机制调用。**



## 3.17 面试题：== 和 equals 的区别

1. == 既可以比较基本类型也可以比较引用类型。对于基本类型就是比较值（不一定需要类型相同），对于引用类型就是比较内存的地址
2. equals 的话，它是属于java.lang.Object类里面的方法，如果该方法没有被重写过默认也是==； 我们可以看到String 等类的equals 方法是被重写过的，而且String 类在日常开发中使用的比较多，久而久之，就形成了equals是比较值的错误观点。
3. 具体要看自定义类里面有没有重写Object的equals方法来判断。
4. 通常情况下，重写equals方法，会比较类中的相应属性是否被都相等。

```java
public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j); // true
        System.out.println(i == j); // true (因为有类型提升，会把i提升为double类型)

        boolean b = true;
        // System.out.println(i == b); // error, int != double

        char c = 10;
        System.out.println(i == c); // true
    
    	char c1 = 'A';
    	char c2 = 65;
	    System.out.println(c1= c2); // true
    
    	Customer cust1 = new Customer("Tom", 21);
        Customer cust2 = new Customer("Tom", 21);
        Customer cust3 = cust1;
        System.out.println(cust1 == cust2); // false
        System.out.println(cust1.equals(cust2)); // false，此时调用的是Object中的equals()方法，与==相同
        System.out.println("*************************************");
        System.out.println(cust1 == cust3); // true
        System.out.println(cust1.equals(cust3)); // true

        String str1 = new String("hello");
        String str2 = new String("hello");
        String str3 = "hello";
        String str4 = "hello";
        System.out.println("str1 == str2      ? " + (str1 == str2)); // false
        System.out.println("str1.equals(str2) ? " + str1.equals(str2)); // true, 此时调用的是java.lang.String中的equals()函数

        System.out.println("str3 == str4      ? " + (str3 == str4)); // true
        System.out.println("str3.equals(str4) ? " + str3.equals(str4)); // true
        System.out.println("str1 == str4      ? " + (str1 == str4)); // false
        System.out.println("str1.equals(str4) ? " + str1.equals(str4)); // true
    
	    Date data1 = new Date(32432525324L);	
        Date data2 = new Date(32432525324L);
        System.out.println("data1.equals(data2) ? " + data1.equals(data2)); // true
    }
```



equals:

1. 是一个方法，只能适用于引用数据类型

2. Object类中equals()的定义：

   ```java
   public boolean equals(Object obj) {
   	return (this == obj);
   }
   ```

   说明：Object类中定义的equals()和 == 的作用是相同的，不比较两个对象的地址是否是相同的，即两个引用是否指向同一个地址

3. 像String、Date、File、包装类等都重写了Object类中的equals()方法，此时比较的不是两个引用的地址是否相同，比较的是两个对象的"实体内容(属性)"是否相同

4. String类中equals()的定义：

   ```java
   public boolean equals(Object anObject) {
       if (this == anObject) {
           return true;
       }
       if (anObject instanceof String) {
           String aString = (String)anObject;
           if (coder() == aString.coder()) {
               return isLatin1() ? StringLatin1.equals(value, aString.value)
                                 : StringUTF16.equals(value, aString.value);
           }
       }
       return false;
   }
   ```



## 3.18 自定义类重写equals() 方法

通常情况下，我们自定义的类如果要使用equals()的话，也通常是比较两个对象的“实体内容"是否相同。

那么，我们就需要对Object类中的equals() 进行重写



重写equals()方法的 原则

1. 对称性：如果x.equals(y) 返回的是 “true"，那么“y.equals(x)"也应该返回的是”true"
2. 自反性：x.equals(x)必须返回的是“true”
3. 传递性：对于任何非空引用值x ， y和z ，如果x.equals(y)回报true个y.equals(z)回报true ，然后x.equals(z)应该返回true 
4. 一致性：对于任何非空引用值`x`和`y`  ，多次调用`x.equals(y)`始终返回`true`或始终返回`false`  ，前提是未修改对象上的`equals`比较中使用的信息。 
5. 对于任何非空的参考值`x` ，  `x.equals(null)`应该返回`false` 



```java
package exer2;

import java.lang.Object;

public class Customer {
    private String name;
    private int age;

    public Customer() {

    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    // 重写的原则：比较两个对象的实体内容是否相同(即，name和age是否相同)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Customer) {
            Customer cust = (Customer) obj;
            // 比较两个对象的属性是否相同，因为name为String类型，因此需要使用 equals函数，而不能直接使用==（==会比较地址）
            return cust.name.equals(this.name) && cust.age == this.age;
        }

        return false;
    }
}

```



## 3.20 单元测试方法

Java中的JUnit单元测试，步骤：

1. 选中当前工程 - 右键选择： build path - add libraries - Junit4 - 下一步

2. 创建Java类，进行单元测试

   此时Java类要求：1）此类是public的，2）此类提供公共的无参的构造器

3. 此类中声明单元测试方法：

   单元测试方法的权限为：public, 无返回值, 无形参 `public void testXXX() {}`

4. 此单元测试方法上需要声明注释，@Test，并在单元测试类中导入：`imprt org.junit.Test`
5. 声明好单元测试方法后，就可以在方法体内测试相关的代码
6. 写完代码以后，双机左键单元测试方法名，右键：run as - JUint Test



note: （在Eclipse中）

1. 如果执行结果没有任何异常：则显示为绿条
2. 如果执行结果出现异常：显示红条

```java
import org.junit.Test;

public class JUnitTest {
	@Test
	public void testEquals() {
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1.equals(s2));
	}
}
```



## 3.21 包装类(Wrapper)的使用

- 针对八种基本数据类型定义相应的引用类型——包装类（封装类）

- 有了类的特点，就可以调用类中的方法，Java才是真正的面向对象

  <img src="D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211228163642130-16407554532396.png" alt="image-20211228163642130" style="zoom:67%;" />

  **JDK 5.0 的新特性，自动装箱与自动拆箱**

  ```java
  public void test3() {
  	int num1 = 10;
  	method(num1);	// 10，此时会自动进行装箱和拆箱
      
      Integer in1 = num2; // 自动装箱
  }
  
  public void method(Object obj) {
  	System.out.println(obj);
  }
  ```

  

<img src="D:\Program Files (x86)\JavaProject\Java知识点1 - 面向对象上.assets\image-20211228165104833-16407554551687.png" alt="image-20211228165104833" style="zoom:67%;" />

### 1. 基本类型与包装类的转换

```java
package exer3;

/**
 * 包装类的使用：
 * 1. java提供了8种基本类型对应的包装类，使得基本数据类型的变量具有类的特征；
 * 2. 掌握：基本数据类型、包装类、String三者之间的相互转换
 */

public class WraperTest {
    public static void main(String[] args) {
        WraperTest w1 = new WraperTest();
        w1.testBasicTypetoWrapType();
        w1.testWrapTypetoBasicType();
    }

    // 1. 基本数据类型-> 包装类
    public void testBasicTypetoWrapType() {
        int num1 = 10;
        
        //Integer num2 = new Integer(num1);   // 新版本中已经不建议这么使用了
        Integer num2 = Integer.valueOf(num1); // 现在的安全使用方式
        Integer num22 = num1;				  // 自动装箱
        System.out.println(num2.toString());  // 10
        
        // Integer num3 = new Integer("123"); // 如果写字符串，则必须严格按照数字来写，不可以加上字符或.
        Integer num3 = Integer.valueOf("123");// 现在的安全使用方式
        System.out.println(num3); // 123
        System.out.println(num3.toString()); // 123
        
        Order order = new Order();
        System.out.println(order.isMale); // false
        System.out.println(order.isFemale); // null
    }
    class Order {
        boolean isMale;
        Boolean isFemale;
    }
    
    // 2. 包装类 转换为 基本数据类型, 调用 包装类的xxxValue() / 自动转换
    public void testWrapTypetoBasicType() {
        Integer in1 = Integer.valueOf(111);
        int i1 = in1.intValue();	// 手动拆箱
        int i2 = in1;				// 自动拆箱
        System.out.println(i1);
        System.out.println(i2);
    }
}
```



### 2. 基本数据类型包装类与String类型的转换

1. 基本数据类型 -> String类型

   - 方式1，通过连接运算
   - 方式2，调用String的valueOf(Xxx xxx)方法

2. String类型 -> 基本数据类型、包装类

   - 调用包装类的`parseXxx()`函数，如 `Integer.parseInt(String s);`， 这是String类->基本数据类型
   - `Integer in1 = Integer.valueOf(String s);` 这是包装类的调用，String类 -> 包装类

   

```java
// 3. 基本数据类型 -> String类型，调用String重载的valueOf(xxx xxx)
    public void testBasicTypetoString() {
        int num1 = 111;
        boolean b1 = true;
        boolean b2 = false;

        // 方式1，通过连接运算
        String s1 = num1 + ""; // 方式1，通过后缀空字符串来将其转换为String类型
        String s2 = b1 + ""; // "true"
        String s3 = b2 + ""; // "false"
        System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", s3 = " + s3);

        // 方式2，调用String的valueOf(Xxx xxx)方法
        float f1 = 12.32f;
        double d1 = Double.valueOf(12.421);

        String s4 = String.valueOf(f1); // "12.32"
        String s5 = String.valueOf(d1); // "12.421"
        System.out.println("s4 = " + s4 + ", s5 = " + s5);
    }

// 4. String 类型 -> 基本数据类型、封装类
    public void testStringTypetoBasic() {
        String str1 = "123";

        // error
        // int num1 = (int)str1;
        // Integer in1 = (Integer)str1;

        int num2 = Integer.parseInt(str1); // 123， 注意，str1中不可以出现字母或小数点.，只能为数字
        Integer in2 = Integer.valueOf(str1); // 123
        int num3 = new Integer(str1); // 不推荐这种写法，推荐使用Integer.valueOf(String s);
        System.out.println("num2 = " + num2 + ", in2 = " + in2);

        String str2 = "true";
        String str3 = "true1";

        boolean b1 = Boolean.parseBoolean(str2); // true
        boolean b2 = Boolean.parseBoolean(str3); // false
        System.out.println("b1 = " + b1 + ", b2 = " + b2);
    }
```



### 3. 包装类常见面试题

#### 3.1 如下两个题目输出结果是否相同？分别为什么

#### 3.2 Integer in1 = 128; Integer in2 = 128; in1 == in2 ？是否 为真

1. 在三母运算符中，x ? a : b; 此时a和b需要类型统一，因此上面的例子中，会自动扩展为Double类型

2. Integer 中定义了一个IntegerCache，其中包括了cache[]数组存储了-128 - +127之间的数值，此时如果赋值-128 - +127则直接从缓存中读取

   因此使用自动装箱的时候，如果Integer in1 = Integer.valueOf(num1); 如果num1 属于 [-128  +127]，则直接从该缓冲区中调用，因此此时输出为true

```java
public void test2() {
	Object o1 = true ? Integer.valueOf(1) : Double.valueOf(2.0);
	/**  
	* 在三母运算符中，x ? a : b; 此时a和b需要类型统一，因此上面的例子中，会自动扩展为Double类型
	*/
    
	Object o2;
	if (true) {
	o2 = Integer.valueOf(1);
	} else {
	o2 = Double.valueOf(2.0);
	}

	System.out.println("o1 = " + o1);   // 1.0
	System.out.println("o2 = " + o2);   // 1
}

public void test3() {
    Integer int1 = new Integer(1);
    Integer int2 = new Integer(1);
    System.out.println("int1 == int2 ? " + (int1 == int2)); // false, 此时比较的是b1和b2的地址值，因此返回false
    
    Integer int3 = Integer.valueOf(1);	// 填入-128 - +127均为true，>=128为false
    Integer int4 = Integer.valueOf(1);
    System.out.println("int3 == int4 ? " + (int3 == int4)); // true
    
    // Integer内部定义了IntegerCache结构，其中的Cache[]保存了-128~+127中的数值。
    // 如果我们使用自动装箱的方式，给Integer赋值的范围在-128~+127范围时，可以直接使用数组中的元素，不用再去new了
    Integer int5 = Integer.valueOf(128); // 填入-128 - +127均为true，>=128为false
    Integer int6 = Integer.valueOf(128);
    System.out.println("int5 == int6 ? " + (int5 == int6)); // false
    
    Double b1 = 10.0;
    Double b2 = 10.0;
    Integer in1 = 128;	// 因为128 > -127, 超出Cache缓存，因此调用new重新创建
    Integer in2 = 128;	// 填入-128 - +127均为true，>=128为false
    Integer in3 = 1;	// 填入-128 - +127均为true，>=128为false
    Integer in4 = 1;

    System.out.println("in3 == in4 ? " + (in3 == in4)); 	// true
    System.out.println("b1 == b2 ? " + (b1 == b2));			// false,
    System.out.println("b1.equals(b2) ? " + b1.equals(b2)); // true
    System.out.println("in1 == in2 ? " + (in1 == in2));		// false
    System.out.println("in1.equals(in2) ? " + in1.equals(in2)); // true
}

```

