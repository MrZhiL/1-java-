练习：

1. 编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
   对数据类型不一致（NumberFormatException）、缺少命令行参数  （ArrayIndexOutOfBoundException）、除0（ArithmeticException）及输入负数（EcDef自定义的异常）进行异常处理
2. 提示：
	(1) 在主类（EcmDef）中定义异常方法（ecm）完成两数相除功能。
	(2) 在main() 方法中使用异常处理语句进行异常处理。
	(3) 在程序中，自定义对应输入负数的异常类（EcDef）。
	(4) 运行时接受参数 java EcmDef 20 10 // args[0] = "20", args[1] = "10"
	(5) Integer类的static方法parseInt(String s)将s转换为对应的int值。