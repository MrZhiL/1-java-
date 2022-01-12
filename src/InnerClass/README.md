## 类的内部成员之五 - 内部类

- 当一个事物的内部，还有一个部分需要一个完整的结构进行描述，而这个内部的完整的结构又只为外部事物提供服务，那么整个内部的完整结构最好使用内部类。

- 在Java中，允许一个类的定义位于另一个类的内部，**前者称为内部类，后者称为外部类**。

- Inner class 一般用在定义它的类或语句块之内，在外部引用它时必须给出完成的名称。

  `Inner class的名字不能与包含它的外部类类名相同`

- **分类**：

  - 成员内部类：static成员内部类和非static成员内部类
  - 局部内部类：（不谈修饰符）、匿名内部类、方法、代码块和构造器内

### 1. 成员内部类

1. 一方面，作为外部类的成员：
   - 可以调用外部类的结构
   - 可以被static修饰
   - 可以被4中不同的权限修饰符修饰
2. 另一方面，作为一个类：
   - 类内可以定义属性、方法、构造器等
   - 可以用final修饰，表示此类不可以被继承（如果没有被final修饰，则可以被继承）
   - 可以被abstract修饰，此时就不可以实例化对象

3. 总结：**关注如下的三个问题**：
   1. 如何实例化成员内部类的对象

   2. 如何在成员内部类中区分调用外部类的结构

   3. 开发中，局部内部类的使用

      1. 直接在方法中定义局部类并使用
      2. 返回一个实现了xxx接口的类的对象

      ```java
      public class InnerClassTest2 {
          // 1. 内部类的调用，开发中很少使用
          public void method() {
              class AA {
      
              }
          }
      
          // 2. 返回一个实现了xxx接口的类的对象
          public Comparable getCioComparable() {
              // 实现一个创建Comparable接口的类：局部内部类
              // 方式1：创建内部类
              // class MyComparable implements Comparable {
      
              // @Override
              // public int compareTo(Object o) {
              // // TODO Auto-generated method stub
              // return 0;
              // }
              // }
      
              // return new MyComparable();
      
              // 方式2：创建内部内部类
              return new Comparable() {
                  @Override
                  public int compareTo(Object o) {
                      // TODO Auto-generated method stub
                      return 0;
                  }
              };
          }
      }
      ```

      