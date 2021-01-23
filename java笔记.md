	###### *************************************************************************内存分析贯通始终******************************************************************************

```java
1.Code segment(存放代码)；Data segment(储存静态变量和字符串常量)；Stack(储存局部变量)；Heap(储存new出来的东西).
```

```java
2.成员变量(整体括号内的变量)；局部变量(局部括号内的变量).
```

```java
3.类型大小：boolean(判断True / Fauls)、(无法加入大小判断)
///byte,char,short<<int<<long<<float<<double
```

```java
4.整型自动化为int；浮点型自动化为double；
```

```java
5.小类型转大类型自动转换，大类型转小类型需要加入强制转换符;   
(如：char a; int b; char a = (char) b;)
```

```java
6.break指令直接跳出整个for循环；
  continue指令只跳出单条循环.
```

```java
7.do...while语句要在while后加;    (强制执行一次);
  而while不需要;
```

```java
8.类与对象的定义;
   (类：具有同一类特征事物的抽象);
   (对象：这类特征事物的特殊的实例)
```

```java
9.类与对象的关系：关联、继承、聚合(聚集、组合)、实现、多态;
```

```java
10.面向对象的思想：
      问题域里的对象/类;
      类与类之间有什么属性/方法;
      类与类之间的关系(继承、多态);
```

```java
11.class -- 类;    new -- 引用;    构造方法;
     (new的概念：Stack内存中一小块区域指向Heap内存中一大块区域);   
     (构造方法：和类同名，没有返回值，甚至没有void);
```

```java
12.方法的重载(Overlord)：方法名称相同，但方法定义的参数之间的类型或个数不同;    
     (构造方法也可以使用重载);
     (例：'public void Method(int n) {}'    与    'public void Method(String s) {}');    
     (例：'A(int n, int i) {}'    与    'A(double a, double b) {}');
```

```java
13.this关键字：引用自己类中的成员变量并指向自身;    
     (在类中有private时，通常会采用get/set访问器来获取与设置参数);
     (new出新的对象时，通常会出现this指向局部变量自身);
```

```java
14.static关键字：static的成员变量均是静态变量，属于所有的类;    (处于Data segment中);
     (不需要new一个新对象去访问，可采用 '类名.静态变量/静态方法' 直接访问变量的值或方法);
```

```java
15.package & import 语句：
​   1.package：解决各个类重名的问题;    
       约定俗成的起包名方法:将域名倒过来(例：com.misaki.www);    
​      (注意：要引用某个package文件时，要将classpath的路径设置在package文件最外部处，如设置在com的上一个文件夹中);
​   2.import：解决引入package中类的便捷方法;    (即不用在方法前增加package域名的前置);
​   3.可引用jar包，并放置在package包最外层文件的文件夹中，这样可以使import更好寻找classpath路径;
​   4.classpath中无法包含两个同名的类，可采用ip前先写 ' .; ' 来从前往后寻找class文件，从而有先后顺序能够正确发现要找的类;
```

```java
16.访问控制：private、default(无前置控制时启用)、protected、public;
     1.private：修饰成员变量，私有，只能自己的类访问;
     2.default：同一个包中其他类均可访问，即子类无法访问;
     3.protected：除自己类能访问，继承后子类均可访问;
     4.public：所有类均可访问，可任意修改;
     5.权限大小：private<<default<<protected<<public;    (所有关键字均可修饰内部类);
```

```java
17.继承类(extends)中，子类调用父类方法时，
   若没有Super(xxx)，则优先考虑子类重载。
   若子类已重载方法，则需要调用父类方法，并要将父类放至方法内部的第一位，若无写Super(xxx)，则系统自动补全Super()；
   若父类方法中无构造无参方法，则系统会报错;  (构造方法相同为重载，子父类相同为重写，重写要注意大小写，最好Copy);
     (注意：若父类中有private变量，则子类只有该private的拥有权，并没有使用权);
```

```java
18.Object()：通用父类;
    1.toString()关键词：    (具体查看:TesttoString.java);
        打印 println("xxx" + 非字符串)；时，会自动将非字符串转换为字符串，即会自动引用Object()公用父类中的toString()方法，将字符串自动转换为：
        getclass().getname() + '@' +Interget.toHexString(hashCode());           
        (自动获取类名 + @ + 类名所对应的哈希编码);  
        (可通过子类重写:public String toString()方法return所需打印的文字);
    2.equals()关键词：    (具体查看:Testequals.java);
        一般来说，一个类里面具有相同返回值的对象无法直接相等，即虽然返回值相等，但内存里的ip地址不相同，无法返回同一个ip;
        可重写公用父类Object()里的equals()方法实现 "自定义相同"                       
        (可通过子类重写:public boolean equals(Object obj)方法构造自定义判断);   
    3.compare()关键词：
        一般来说，采用 'a[i].compare(a[j]) + > (<) + 0' 方法判断两个引用变量(数组)的大小;
        (注意：基础类型无法使用.equals()与.compare()运算符，而引用类型无法直接使用> = <等比较类型符号);
```

```java
19.对象转型(casting):    (具体查看:Testcasting.java)
    1.父类的引用类型变量可以直接指向子类的对象   
        (即子类覆盖父类，子类可引用(除private)父类中的所有引用类型变量);
    2.父类的引用无法访问子类对象新增加的成员;
        (即父类无法引用子类新增的在父类范围之外的成员);
    3.可以引用变量 'instanceof' 来判断 该引用类型的变量(父类) 所指向的 对象 是否属于 该引用类型的 类或子类;
        (如:if(a instanceof b) {return true;}   即若b是a的类或子类，输出true.)  (instanceof也可进行相同变量的判断)  (Boolean类型);
    4.父类引用指向子类对象 称为向上转型(upcasting);   子类引用指向父类对象 称为向下转型(downcasting);
        (即向上转型(upcasting)为小转大，子类对象转为父类对象对象，使该子类对象能作为父类对象来使用);
        (即向下转型(downcasting)为大转小，父类对象转为子类对象，使该父类对象加入强制转换符后变为子类对象，作为子类对象来使用);
```

```java
20.多态 == 动态绑定 == 迟绑定;    (具体查看:TestPloymoph.java)
    1.定义:在代码执行过程期间(java xxx) (而并非是编译过程期间(javac xxx))，判断引用对象的实际类型，并根据其实际类型调用相应方法.
        (不跟随主类对象的判断，而根据new出来的对象进行调用方法);
        (常搭配接口interface使用);
    2.三个必要：①.要有继承(extends);    
               ②.要有子类与父类之间的重写(OverWrite);   
                ③.父类引用指向子类对象;
    3.多态的实现让程序的扩展性大幅度提升，可以更好的调用方法对不同类别进行分类，也可以更好的调用方法获取不同的信息.
```

```java
21.抽象类(abstract);    (具体查看:Testabstract.java)
    1.定义:用 'abstract' 来修饰一个类或一个方法时，该类和方法被称为抽象类和抽象方法.
    2.含有抽象方法的类必须被声明为抽象类，抽象类必须被继承，内部方法必须被重写.
    3.抽象类无法被实例化.    (无法使用Heap内存new方法);
    4.抽象方法只需声明，不需要实现.    
        (即重写部分可直接写 'public abstract + (类型) + (方法)' );
    5.继承了抽象父类的子类必须引用父类的所有抽象引用，不然必须将子类也定义为抽象类;
        (即抽象类的构造只是为了子类的继承与重写，结果的输出只与子类有关，与父类无关);
```

```java
22.Final关键字;
    1.写了final的值无法被改变:包括final的成员变量和final的形参;
        (final int i = 9;无法被改变);    (public void m(final int i = 9));
    2.写了final的方法无法被重写;    (子类无法重写的唯一方法);
    3.写了final的类无法被继承;    (保护父类);
```

```java
23.接口(interface);    (具体查看:Valuable.java)
    1.接口是抽象类(abstract)和常量值(static)和终值(final)定义的集合;
    2.从本质上看，接口只是一种特殊的抽象类，而这种抽象类中只包含了常量和方法的定义，并没有变量和方法的实现;
         (例: 
        public interface Runner {
	    public static final int id = 1;
	    public void Start();
	    public void Run();
	    public void Stop();    }  )
    3.接口可以多重实现;    (即多个无关类可实现同一个接口，一个类也可以实现多个无关的接口);
    4.接口类的所有属性都默认为 'public static final + (声明) + (常量)'，并且都是抽象类 'abstract';
    5.接口也能够继承其他的接口，添加其他新接口的新的属性与方法;    (与继承类相似，接口与实现类也存在着多态性);
       (普通类继承: class -- extends);   
       (抽象 -- class 类继承: abstract -- extends);  
       (接口 -- 接口 类继承: interface -- extends);    
       (接口 -- class 类继承: interface -- implements);
    6.<?> 或 <? extends T> 和 <? super T>;    (?继承父类T) 和 (?返回父类T);
       (?代表所有的声明均可以使用);    (T代表声明中某一种特定的声明);
```

```java
24.异常(excption);    (具体查看:TestEX.java)
     1.异常是Java提供的用于处理程序 '运行中' 错误的一种机制;  
         (例：除0溢出，数组下标越界，所读取的文件不存在);    (编译能够通过，但运行出现错误);
     2.抛出(throw)：Java程序运行中出现异常时，可生成一个异常类对象，该对象封装信息交给Java系统，该过程称为抛出异常;
     3.捕获(catch)：当Java系统收到异常对象时，会寻找能够处理这一异常的代码，并将当前的异常对象交给其处理，该过程称为捕获异常;
         (调用catch() {} 方法时，应先从小类Exception开始调用，再转向大类Exception，否则会失去调用对象，无法编译);
     4.(try {} --- catch (Exception + (自定义名称)) {})：两者必须一起使用;   
         (try用于测试可能会出错的程序代码；catch用于出现该类异常后，该如何处理);  
         (若出现错误，则系统自动初始化Exception后的形参变量，可以在catch(Exception + (自定义名称)) {}中自定义执行的代码);
         (注意：try {}中抛出的语句从上到下若出现了首要的错误，则会直接跳到catch(Exception + (自定义名称) {}) 中执行命令，而try {}中剩下的语句并不会被执行，而是直接执行 finnally{} )；
     5.((自定义名称) + .printStackTrace())：该代码可以返回所有的关联错误的ip，有助于程序的修改;
         (例：java.lang.ArithmeticException: / by zero
         at TestEX.main(TestEX.java:6)  );
     6.异常抛出类型(Throwable)：主要分两大类：1.Error;    2.Exception;         (异常类型需要查.api文档)
         ①Error：称为程序错误，由Java虚拟机生成并抛出，包含了动态连接失败，虚拟机错误等，程序并不对其作出处理;
         ②Exception：分为两小类：1.IOException;    2.Runtime Exception;
             ①IOException：必须要被throws抛出并处理的异常;
             ②Runtime Exception：可以被省略的多次出现的小异常;    (一般来说是代码运算出错，采用修改代码修正，而不采用try...catch...finally处理);
     7.Finally关键字：为异常处理提供了一个统一的出口，使得在控制流程转换到程序的其他部分时，能够对该流程状态做出统一的管理; 
         (即无论try中所指定的程序块是否throw出excption被catch捕获执行，finally内部的代码必定会被执行);
         (一般来说，finally主要处理对资源的清理工作，如：关闭打开的文件，删除临时文件等);
     8.异常文件的捕获和处理：因Java的机制，Exception会沿着顺序寻找，只要找到具体的try {}、catch() {}捕获和处理便停止;  
     9.使用自定义的异常：    (具体查看TestThrows.java)
         ①、可通过继承java.lang.Exception(或 Runtime Exception)父类来自定义自己的异常类;    
         ②、在方法内部适当的位置，生成自定义的实例，并用throw抛出;    
            (例：if(num < 0) {throw new MyException();});
         ③、在方法的声明部分上用throws语句声明可能抛出的异常类型，交给调用该方法的调用者解决;             
            (例：public void Test throws MyException {});
            (throws：在方法声明处抛出自己的自定义的Exception类;    throw：在方法内部初始化自定义Exception类中的参数);
     10.声明并抛出异常：在重写自定义异常方法时要求所抛出的异常类型需要与自定义异常类型一致(相同)  或  不抛出异常;
```

```java
25.数组;    (具体查看:TestVar3.java);
     1.定义：数组可看成是多个同类型的数据的组合，并对这些数据进行统一管理;
     2.数组的变量属于引用类型，数组也可看成是对象，数组中的每个元素相当于该对象的成员变量;
     3.数组中的元素可以是任何数据类型，包括基本类型和引用类型;
     4.一维数组; 
       ①.声明方法：type var[]  或  type[] var;    
         (例：int a1[];    double b[];    Person[] p1;    String s1[];)
       ②.非法构造：Java语言中无法像C语言一样构造数组，即如：int a[5];  是会发生编译错误的非法构造;
         (正确方法应是：{ int s[];  s = new int[5];  for(int i = 0; i < 5; i++) { s[i] = i; }});
         (注意：元素为引用数据类型的数组中的每一个元素都需要实例化;  即这些元素一一对应着引用类型里的每一个实例;)
     5.一维数组的初始化;
       ①.动态初始化：数组定义与为数组元素分配空间和赋值的操作分开进行;    
         (即：int a[]; a = new int[3]; a[0]=3; a[1]=9; a[2]=8;)
         (即：数组先定义，再分配空间，再对数组元素进行赋值);
       ②.静态初始化：在定义数组的同时就进行了数组元素的分配空间和赋值;   
         (即：int a[] = {3, 9, 8};)
         (即隐藏了在定义数组时对该数组的分配空间的步骤，直接赋值);
       ③.默认初始化：数组是引用类型，其元素相当于成员变量，按照成员变量的规则将被隐式初始化; 
         (即：int a[] = new int [5]; System.out.println(a[3]);   
         打印结果为0，因为a[]数组只被分配了空间，而里面的元素并未被赋值，默认初始化);
       ④.元素的引用;    (具体查看:TestArray.java);
         1.定义并使用new运算符分配空间之后，才能够引用数组中的各个元素，即 arrayname[index];
           (index为元素下标，可以是整型常量也可以是整型表达式，如：a[3], b[i], c[6*i]); 
           (index的范围从0开始到n-1);
         2.每个数组都有一个属性length指明其长度;    
           (例：a.length的值为数组a的长度);    
           (可直接代替数组的最大元素下标);
         (public static void main(String[] args){}  中的 'String[] args' 也是一个数组，可以采用在cmd中输入命令行参数，即在 'java TestArray' 后面加上参数，所加入的所有参数均可被打印出来);
     6.二维数组; 
       ①.可看成以数组为元素的数组;    
         (例：int a[][] = {{1, 2}, {3, 4, 5, 6}, {7, 8, 9}};);
       ②.Java中多维数组的声明和初始化应满足从高维到低维的顺序进行;    
         (即：int a[][]= new int[3][];   
              a[0] = new int [2];   
              a[1] = new int [4];   
              a[2] = new int [3];)
         (即：int b[][] = new int[][4] 是非法的);
     7.二维数组的初始化;
       ①.静态初始化：int a[][] = {{1, 2}, {3, 4, 5, 6}, {7, 8, 9}};
         (//非法初始化：int b[3][2] = {{1, 2}, {3, 4}, {5, 6}};    即java程序中不能自行定义数组的个数，而是应该java自行确定);
       ②.动态初始化：
         1.int a[][] = new int[3][5];    (规定a[][]的外部数组有三个，而每个外部数组中又含有五个元素);
         2.int b[][] = new int[3][];    b[0] = new int[2];    b[1] = new int[4];    b[2] = new int[3];
         (定义二维数组只能先定外部数组，即int a[3][]，而内部数组需要第二次分别定义);
       ③.二维数组中a.length表示外部数组中数组的总个数，而a[i].length表示在内部数组i中元素的总个数;
     8.数组的拷贝;    (具体查看:IntArray.java);
       ①.代码方法：
         1.System.arraycopy(原数组, 原数组复制起始位置, 新数组, 新数组复制起始位置, 要复制原数组的长度);
         2.Arrays.copyOf(原数组, 要复制原数组的长度);
           (注意：若原数组的复制长度超出新数组的长度，则系统会报错: IndexOutOfBoundsException);
           (特殊:二维数组的前后数组长度需要一一对应，不然会发生报错);
```

```java
练习题：
     1.组合排序：
       (具体查看:TestArgs.java);          (实例简单cmd计算器);
       (具体查看:NumSort.java);           (简化效率选择排序);    
       (具体查看:NumSort2.java);          (冒泡排序);
       (具体查看:BubbleSort.java);        (冒泡排序);   
       (具体查看:BubbleSort2.java);       (简化效率选择排序);
       (具体查看:Count3Quit.java);        (数三退一 -- 算法方法);
       (具体查看:Count3Quit2.java);       (数三退一  -- 面向对象方法);
       (具体查看:TestArray2.java);        (二维数组简单输入输出);
     2.搜索：
       (具体查看:TestSearch.java);        (冒泡排序+二分法查找);
```

```java
                           需要经常查询api文档;

26.字符串相关类型(String)：    (具体查看:TestString.java);    (具体查看:TestCheak.java);
  1.String关键字：java.lang.String 类代表不可变的字符序列，主要用于储存字符串类型变量;
  2.主要方法有：

​   ①.String(String original)：创建一个String对象为original的拷贝;
​   ②.String(char[] value)：用一个字符数组创建一个String对象;
​   ③.String(char[] value, int offset, int count)：用一个字符数组从第offset的位置截取count个字符组成一个新的String;
​   ④.public char charAt(int index)：返回字符串中第index个字符;
​   ⑤.public int length()：返回字符串的长度;
​     (.length 修饰数组类型;    .length() 修饰字符串类型);
​   ⑥.public int indexOf(String str)：返回字符串中出现str的第一个位置;
​   ⑦.public int indexOf(String str, int fromIndex)：返回字符串中从fromIndex出现str的第一个位置;
​   ⑧.public boolean equalsIgnoreCase(String another)：比较String字符串与another是否一样(忽略大小写);
​   ⑨.public String replace(char oldChar, char newChar)：在字符串中用oldChar替换newChar;
​   ⑩.public String toUpperCase()：返回一个字符串为该字符串的全大写形式;
​   ⑪.public String toLowerCase()：返回一个字符串为该字符串的全小写形式;
​   ⑫.public String substring(int beginIndex, int endIndex)：返回该字符串从beginIndex到endIndex之间的子字符串;
​   ⑬.public String trim()：返回该字符串去除开头和结尾的空格后的字符串;

(Main) ⑭.静态重载(强制转换类型)：public static String valueOf(Object obj)：可将基础类型数据转换为字符串;    
         (多采用替换数值为字符串计算长度);
         (该方法有重写，有继承，且括号内为父类的引用并指向了子类对象，即方法中使用了多态);
    ⑮.public String[] split(String regex)：可将一个字符串按照指定的分隔符分隔，返回分隔后的几组字符串;

  3.StringBuffer关键字：    (具体查看:TestStringBuffer.java);
    相对于String的对字符串的不可变动，sBuf可以任意改变所定义的字符串，其他功能于String差不多;
    ①.(变量名) + .append(内容)：将append(内容)中的 '内容' 添加到变量之后;
    ②.(变量名) + .delete(初位置, 末位置)：将变量中初位置和末位置之间(包括初末位置)的字符串全部清除;
    ③.(变量名) + .insert(任意位置, 所添加的内容)：可以将内容添加到变量的任意位置;    (注意：内容包括数字和上文已经定义过的字符串);
    ④.(变量名) + .reverse()：将变量完全倒叙排列;
    
  4.StringBuilder关键字：
    ①.(变量名) + .append(内容)：将append(内容)中的'内容'添加到变量之后;
    ②.(变量名) + .toString()：返回对象中的所有字符串；
    ③.(变量名) + .setCharAt(int i, char c)：将第i个位置更换为c；
    ④.(变量名) + .insert(int offset, String str)：再offset-1处插入'str'字符类型;
    ⑤.(变量名) + .delete(int startIndex, int endIndex)：删除起始位置(包含)到结尾位置(不含)之间的字符串    
      (与StringBuffer中的delete定义有所区别);

  5.基础数据类型包装类：    (具体查看:TestArr1.java);
    1.包装类：这些类封装了一个相应的基本数据类型数据值，并提供了一系列操作;
​      (如Integer、Double、Character等等);
       ①. parse()是SimpleDateFomat里面的方法;
          rseInt()或parsefloat()顾名思义;    比如说int.parseInteger(String s)就是把String类型转化为int类型;
          如 String a= "123";
             int b = Integer.parseInt(a);
             即b就等于123;

​      ②.ValueOf()方法比如说 Integer.valueOf() 是把String类型转化为Integer类型
​         (注意：是Integer类型，而不是int类型，int类型是表示数字的简单类型，Integer类型是一个引用的复杂类型)
​         如：String a= "123";
​             Integer c =Integer.valueOf(a);
​             Integer类型可以用intValue方法转化为int类型
​             int b =c.intValue(c);
​             即b等于123;

​      ③.toString()可以把一个引用类型转化为String字符串类型;
​          下面举个例子与2相反，把Integer转化为String类型：
​           Integer a = new Integer(123);
​           String b =a.toString();
​           即b等于123;

  6.Math & File：
​   1.Math：可在java.lang.Math中对其进行引用，其中提供了一系列的静态方法用于科学计算，其方法参数和返回值类型一般为double;

​       例：abs() (绝对值);  sqrt() (平方根);  pow(double a, double b) (a的b次幂);  log() (以e为底的对数);  exp e() (以e为底的指数); random() (返回0.0到1.0之间的一个随机数);  long round(double a) (double型的数据a转换为long型，并进行四舍五入);  toDegrees(double angrad) (弧度转换为角度);  toRadians(double angdeg) (角度转换为弧度);

​   2.File：可在java.io.File中对其进行引用，其中主要代表系统的文件名(路径和文件名);
​                 (一般来说是不存在的数据类型);
​        File类常见的构造方法:    (具体查看:TestFile.java);
​     ①.public File(String pathname);    以pathname为路径创建File对象，若path是相对路径，则默认的当前路径在系统属性user.dir中储存;
​     ②.public File(String parent, String child);    以parent为父类路径，child为子类路径创建File对象;
​     ③.String separator储存了当前系统的路径分隔符：'/' ; 
​   3.递归列出目录结构：    (具体查看:FileList.java);

​  7.Enum枚举类型：    (具体查看:TestEnum.java);
​     ①.只能够取特定值之一，无法选取特定值之外的任何值;
​     ②.使用enum关键字可以引用java.lang.Enum中的枚举方法;
```

![image-20200918151558391](E:\Game\Epic!\Epic Games\Typora\typora-user-images\image-20200918151558391.png)

```java
27.容器(Contains)：Java API所提供的一系列类的实例，用于程序中存放对象;

​    知识点: 一个图    (上图);
            一个类    (Collections);
            三个知识点    (1.增强for循环;    
                         2.泛型Generic;
                         3.打包 / 解包:Auto-Boxing / Unboxing;)
            六个接口    (1.Collection;  
                        2.Set;  
                        3.List;  
                        4.Map;
                        5.Iterator;
                        6.Comparable;)
       
     API：位于java.util包内;
​        ①.Collection：将一个个对象分别装入容器; (一个)     
​             1.子接口 Set：容器内对象没有顺序，并且无法重复;   (具体查看:TestSet.java);
                (即相同元素只会出现一次);
                (Set容器类：HashSet，TreeSet);    
​               (重复概念：对象间互相.equals());  
​             2.子接口 List：容器内对象有顺序，并且可以重复;   (具体查看:TestList.java);
​               (List容器类：ArrayList，LinkedList);
                (List容器中的元素都对应着一个整数型的序号记载其在容器中的位置(有序性)，可通过序号存取容器中的元素);
                (类 java.util.Collections 提供了一些静态方法实现了基于List容器的一些常用算法;    如：
​               void sort (List)    //对List容器内的元素排列  (一般是从小到大);
​               
                void shuffle (List)    //对List容器内的对象进行随机排列;
​               
                void reverse (List)    //对List容器内的对象进行逆序排列;
​               
                void fill (List, Object)    //用一个特定的对象重写整个List容器;
​               
                void copy (List dest, List src)    
                  //将src List容器的内容拷贝到dest List容器中;
​               
                int binarySearch (List, Object)    
                  //对于已排好顺序的List容器，采用折半查找方法查找特定对象; );
                
​             3.方法常用Boolean类判断容器内是否包含对象;    
                (用.equal()进行判断);
                (利用了多态);
​             4.容器类对象在调用remove、contains方法时，需要比较对象是否相等，这将涉及到equals和hashCode方法;    
                对于自定义类型，需要重写equals和hashCode方法实现对象相等原则;
                
​                (例：
                    public boolean equals (Object obj) {
​                     if (obj instanceof Name) {
​                       Name name = (Name) obj;
​                       return 
  (firstName.equals(name.firstName)    &&    (lastName.equals(name.lastName));
​                     }
​                   return super.equals(obj);
​                   }
​                   public int hashCode() {
​                     return firstName.hashCode();
​                   })

​              5.Iterator接口：称作迭代器;    (具体查看:TestContains.java);
                 (利用了多态);   
​                 具有方法：
​                 1.boolean hasNext();    //判断游标右边是否有元素存在;
​                 
                  2.Object next();    //返回游标右边的元素并将游标移动到下一个位置;
​                 
                  3.void remove();    
                  //在执行完next之后，删除游标左边的元素(通常放在最后，因为只能执行一次); 
​              6.Comparable接口：    (具体查看:TestComparable.java);
​                 1.所有可"排序"的类都实现了java.lang.Comparable接口;
​                 2.Comparable接口中只有一个方法: 
                    public int compareTo (Object obj);
​                 3. ①.该方法返回值为0：this == obj;
​                    ②.该方法返回值为正数：this > object;
​                    ③.该方法返回值为负数：this < object;
​                 4.实现了Comparable接口的类通过实现compareTo方法从而确定类中对象的排序方式;               
​              7.增强for循环(不推荐使用)：能够简单遍历并读出其中的内容;    (具体查看:TestFor.java);
​                 缺点：①.在数组中，无法方便的访问下标值; 
​                      ②.在集合中，虽然在内部也是调用Iterator方法读取元素，但无法像Iterator方法一样方便的删除集合中特定的内容;

​        ②.Map：将一对对的对象分别装入容器; (两个)    (具体查看:TestMap.java);
​             1.实现Map接口的类用来存储 '键(Key) -- 值(Value)' 对;
​             2.接口实现类有：HashMap、TreeMap;
​             3.Map类中储存的 键--值对 通过键来标识，所以键值无法重复;
​             4.常用方法：
​                 ①.Object put (Object key, Object value);    //成对存放键--值对;

​                 ②.Object get (Object key);    //输出键所对应的值;

​                 ③.Object remove (Object key);    //移除键所对应的值;

​                 ④.boolean containsKey (Object value);    
                    //确认对象中是否包含某个key值;

​                 ⑤.boolean containsValue (Object key);    
                    //确认对象中是否包含某个value值;

​                 ⑥.int size();    //    计算对象中有几个键--值对;

​                 ⑦.boolean isEmpty();    //确认对象中键--值对是否为空;

​                 ⑧.void putAll (Map t);    //将Map t中的所有键--值对添加至另一个对象中去;    (随机排序);

​                 ⑨.void clear();    //清空对象中的键--值对;

​                      (定义了存储 "键(Key)--值(Value)映射对" 的方法);

​             5.Auto-boxing / unboxing：在合适的时机自动打包、解包;    (应用了泛型);
                (jdk1.5.0之后采用);
​                 ①.自动将基础类型转换为对象;    (具体查看:TestArgsWords.java);
​                 ②.自动将对象转换为基础类型;

​        ③.数据结构*：衡量标准：读的效率和改的效率;
​             1.Array读快写慢;    
                (集合排序，可快速找到元素具体位置，但修改元素需要Copy);
​             2.Linked写快读慢;    
                (传递序列，可快速修改元素，但寻找序列元素需要一个一个接着找);
​             3.Hash读写均一般;    
                (最常用);

​        ④.泛型(Generic)：    
​             (具体查看:BasicGeneric.java);    
              (具体查看:TestMap.java);
              (具体查看:TestArgsWorlds.java);
​             1.定义：因为装入集合的类型均被当成Object对待，失去了自己的实际类型，进而在集合中取出时需要转型，导致效率低，容易产生错误;    所以在定义集合时应同时定义集合中对象的类型，即为泛型;       
​             2.可以在定义Collection接口时指定泛型类型，也可在循环时用Iterator指定泛型类型;
​             3.增强程序的可读性与稳定性;
```

```java
28.流(Stream)：    (均是面向程序而言);
​      1.流式输入(InputSteam)：从其他文件向程序传输内容;
​      2.流式输出(OutputSteam)：从程序向其他文件传输内容;
​      3.输入 / 输出 类：java.io;
​          ①.按数据流方向可分为：输入流、输出流;
​          ②.按处理的数据单位不同可分为：字节流、字符流;
```

![image-20200919103426657](E:\Game\Epic!\Epic Games\Typora\typora-user-images\image-20200919103426657.png)

```java
③.按功能不同可分为：节点流、处理流;    (从数据源中读取数据);
```

![image-20200919103538084](E:\Game\Epic!\Epic Games\Typora\typora-user-images\image-20200919103538084.png)

​     

```java
 4.方法：

​       ①.InputSteam：    
				(8bit为一单位);    
				(int类型向内输入字节);    
				(buffer为缓冲区);
​            1.int read () throws IOException;
​                //读取一个字节并以整数形式返回(0-255);
​                //若返回值为-1，则已到输入流末尾;                       
​            2.int read (byte[] buffer) throws IOException;
​                //读取一系列字节并存储到一个buffer数组，之后返回实际读取的字节数;
​                //若读取前已到输入流末尾则返回-1;
​            3.int read (byte[] buffer, int offset, int length) throws IOException;
​                //从offset位置，读取length个字节，并存储到一个字节数组buffer中，之后再返回所读取的字节数;
​                //若读取前已到输入流末尾则返回-1;
​            4.void close () throws IOException;
​                //关闭流并释放内存资源;
​            5.long skip (long n) throws IOException;
​                //跳过n个字节不读，并返回实际跳过的字节数;

​               ②.OutputSteam：    (8bit为一单位);    (void类型向外输出字节);
​            1.void write (int b) throws IOException;
​                //向输出流中写入一个字节数据，该字节数据为参数b的前8位;
​                  (与IntputStream大相径庭);
​            2.void flush () throws IOException;
​                //将输出流中的缓冲的数据全部写出到目的地;
​                //一般要写在 close() 结束方法前一个;

​               ③.Reader：    (16bit为一单位);    
​            1.int read (char[] cbuf) throws IOException;
​                //读取一系列字符并存储到一个charbuffer数组，之后返回实际读取的字符;
​            2.int read (char[] cbuf, int offset, int length) throws IOException;
​                //从offset位置，读取length个字节，并存储到一个字符数组charbuffer中，之后再返回所读取的字符数;

​               ④.Write：    (16bit为一单位);
​            1.void read (char[] cbuf) throws IOException;
​                //将一个字符类型的数组中的数据写入输出流;
​            2.void read (char[] cbuf, int offset, int length) throws IOException;
​                //将一个字符类型的数组从offset位置开始，将length个字符写入到输出流;
```



```java
 5.字节流类型：
```

![image-20200919112516176](E:\Game\Epic!\Epic Games\Typora\typora-user-images\image-20200919112516176.png)

```java
       ①.例子：(1 bit为单位，则无法打印文字，即单文字是2 bit，无法读入);

​             1.TestFileInputStream.java;    (可以将文件读入程序，进行存盘并输出内存);    (Byte类型);

​             2.TestFileOutputStream.java;    (可以将程序写入文件，一般用于复制文件到另一个文件);

​             3.TestReader;    (用于将字符从文件搬运到程序);

​             4.TestWriter;    (用于将字符从程序搬运到文件);    (Char类型);

​             5.TestBufferStream1.java;    (内部有readLine()方法，常用);

​             6.TestBufferStream2.java;    (可引用方法Buffered() 中的readLine() 直接读取一行内容);

​             7.TestTransForm1.java;    (可引用方法Write() 将1 bit字节转换为2 bit字符);

​             8.TestTransForm2.java;    (引入 System.in 当作doc内部执行码);

​             9.TestDataStream.java;    (可引用方法ByteArray()中的 read+(声明类型)() 对字节进行转换);

​             10.TestPrintStream1.java;    (方法printwrite()无需抛异常和无需flush());

​             11.TestPrintStream2.java;    (可在命令行中读取不同文件并打印出来);

​             12.TestPrintStream3.java;    (系统日志);    (修改代码产生记录);

​             13.TestObjectIO.java;    (可以直接打印一个框架中所有Object元素);

​             ①.transient关键字：可以将一个元素透明化，使其无法被子类调用;    (透明化的)

​             ②.Serializable接口：标记性的无方法的空接口，引用给编译程序查看;    (可进行序列化的)

​             ③.Externalizable接口：Serializable接口的父类接口，有 readExternal(ObjectInut in) 和 writeExternal(ObjectOutput out) 两种方法，可以自行控制进行序列化的对象;

​             (一般来说java编译器能协助控制可序列化对象就使用Serializable接口，而不自行使用Externalizable接口);
```

