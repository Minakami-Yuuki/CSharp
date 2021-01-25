	2020.1.22 Start.

```c#
代码基本格式：
	namespace Test_C_Sharp
    //命名空间
{
    class Program
    //类名
    {
        static void Main(string[] args)
        //主方法
        {
            Console.WriteLine("Hello World?");
            //主要输入内容
        }
     }
}
```

```c#
1.基本输入输出：
	Console.WriteLine();	//打印（自动换行）
	Console.Write();		//打印（不自动换行）
	Console.ReadLine();		//读取控制台输入（无论长短）
	Console.ReadKey();		//读取键盘输入（若键盘输入任意字符即结束任务）
```

```c#
2.基本数据类型：
	1.全整形：（可取任意正负数包括0）
		①.sbyte		//范围 -128 ~ 127
		②.short		//范围 -32768 ~ 32767
		③.int		//范围 -21亿 ~ 21亿多
		④.long		//范围 -9百万兆 ~ 9百万兆之间
	2.非负整形（可取任意正数包括0）
		①.byte		//范围 0 ~ 255
		②.ushort	//范围 0 ~ 65535
		③.uint		//范围 0 ~ 42亿多
		④.ulong		//范围 0 ~ 18百万兆之间
	3.浮点数（默认为double）
		①.float		//范围 从左到右有效数字7/8位
					//赋值时需要加上f或F  
    				//例：float f = 0.12345678f;
		②.double	//范围 从左到右有效数字15/17位
    				//例：double d = 0.12345678901234567;
		③.decimal	//范围 从左到右有效数字27/28位
    				//赋值时需要加上m或M
    				//例：decimal de = 0.1234567890123456789012345678m;
					//由于不确定因素太多 不建议使用
	4.特殊类型（判断+字符）
		①.bool		//布尔类型  判断正确与否  只能输出true 或 false
		②.char		//字符类型	只能存储单个字符或单个汉字
		③.string	//字符串类型	可存储无限长字符或数字
	//常用：int / float / bool / string
	  折叠代码：
		#region 折叠代码块
        //此处可以填写任意代码或文字
        //在代码编译过后将自动隐藏此区域不会被编译出来
        //采取 #region + Tab + #endregion 打开
        #endregion
```

```c#
3.基础数据类型所占内存：
    	方法：采用siezeof()方法进行计算所占内存
		例：int charSize = sizeof(int);
		   Console.WriteLine(charSize);
	1.整形：
		①.byte(sbyte)	//所占内存为1
        ②.short(ushort)	//所占内存为2
        ③.int(uint)		//所占内存为4
        ④.long(ulong)	//所占内存为8
	2.浮点数：
        ①.float			//所占内存为4
        ②.double		//所占内存为8
        ③.decimal		//所占内存为16
	3.特殊字符：
        ①.bool			//所占内存为1
        ②.char			//所占内存为2(或1)
        ③.string		//由于string没有指定范围限制 所以无法使用sizeof()方法来测定其内存大小
```

```c#
4.命名规则：
    1.不能重名
    2.不能以数字开头
    3.不能使用程序关键字命名 (如：char, int)
    4.不能有特殊符号 (下划线_除外)
    5.驼峰命名法：(针对变量)
    	首字母小写 单词分割处大写 (如: myAtk, myDef)
    6.帕斯卡命名法：(针对函数 类名)
    	首字母大写 单词分割初大写 (如: Main, System)
```

```c#
5.常量使用：(const)
    定义：const 变量类型 变量名 =初始值;
	与变量的区别：
        1.必须初始化  (即: const string myName = "ch";  等号部分无法去除)
        2.不能被修改  (即: 后续无法对常量进行二次赋值)
        3.作用：可以用来申明一些常用不变的变量  (如: Pi) (可用于游戏制作中固定数值定义)
```

```c#
6.转义字符：(一般采用 \+字符 表示)
    1.单引号''：\''  (例：string str = "\'ch\'";	打印为:'ch')
    2.双引号""：\""  (例：str = "\"ch\"";		打印为:"ch")
    3.斜杠\：\\	(例：str = "\\ch\\";	打印为：\ch\)
    4.制表符Tab：\t	(空4个空格)
    5.光标退格：\b	(例：str = "c\bch";	打印为:ch)
    6.空字符：\0	(例：str = "c\0h";	打印为:ch)
    7.警报音：\a	(例：str = "\a";	打印为:控制台输出后发出警报音)
```

```c#
7.隐式转换：
	1.同类型转换：(大类型转小类型)
		①.long ——> int ——> short ——> sbyte
		②.ulong ——> uint ——> ushort ——> byte
		③.double ——> float (注：decimal无法和double float相互转换)
	2.不同类型转换：
		①.不同类型整形转换：
			1.整形转换：
				①.无符号无法装载有符号 (即：ulong ≠> int)
				②.有符号可以装载无符号 (要求：大范围转小范围)
					long ——> uint ushort byte
			2.浮点转换：
				①.浮点数可以装载整形数
			3.特殊转换：
				①.bool类型无法和任意类型转换 
				②.char类型可以转换为整形和浮点型 默认转换为ASCII码
				③.string类型无法和任意类型转换
			(bool和string类型无法转换原因：没有对应转换类型和无法确定真实范围)
```

```c#
8.显示转换：
	1.括号强转：(常用于小范围转大范围) (bool 和 string 类型不适用)
		例： sbyte sb = 0;
			int i = (int) sb;	//打印为0
		(缺点：精度缺失 无法进行四舍五入计算)
	2.Parse法：(常用于字符串转数值或字符)
		例： int i = int.parse("123456");	//打印为123456
			 char c = char.parse("A");	//打印为A
		(缺点：会出现超出范围转换而报错)
	3.Convert.To法：(常用于各类不同类型之间相互转换)
        例： int i = Convert.Toint32("12");	//打印为12
			 i = Convert.Toint32(false);	//打印为0
			 i = Convert.Toint32(true);		//打印为1
			 sbyte sb = Convert.Tosbyte("1");	//打印为1
			 short s = Convert.Toint16("1");	//打印为1
			 long l = Convert.Toint64("1");		//打印为1
			 float f = Convert.ToSingle("13.2");	//打印为13.2
			 double b = Convert.ToDouble("13.1");	//打印为13.1
			 decimal de = Convert.ToDecimal("13.0");	//打印为13.0
			 bool bo = Convert.ToBoolean("true");	//打印为true
			 char c = Convert.ToChar("A");	//打印为A
			(注意：Convert.To后面接各类型的格式均不同)
			(其浮点数转整数类型可以进行四舍五入)
	4.toString()法：(常用于其他类型转字符串类型)
        例： string str = true.toString();	//打印为true
			 (打印时若进行字符串拼接 则system会自动调用.toString()方法)
```
