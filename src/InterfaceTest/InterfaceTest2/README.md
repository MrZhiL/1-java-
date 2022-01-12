## 接口练习

- 定义一个接口来实现两个对象的比较

  ```java
  interface CompareObject {
  	public int compareTo(Object o); // 如返回值为0，代表相等；若为正数，代表当前对象大；若为复数，代表当前对象小
  }
  ```

- 定义一个Circle类，声明radius属性，提供get和set方法

- 定义一个CompareableCircle类，继承Circle类并且实现CompareObject接口。在CompareableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。

- 定义一个测试类InterfaceTest，创建两个CompareableCircle对象，调用compareTo方法比较两个类的半径大小。

- 思考：参照上述做法定义矩形类Rectangle和CompareableRectangle类，在CompareableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。