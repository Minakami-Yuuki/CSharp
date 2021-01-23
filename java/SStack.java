import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

class LT {
 
	public char[] op = {'+','-','*','/','(',')'};
	public String[] strOp = {"+","-","*","/","(",")"};
	
	//判断数值
	public boolean isDigit(char c){
		if(c>='0'&&c<='9'){
			return true;
		}
		return false;
	}
	
	//判断字符
	public boolean isOp(char c){
		for(int i=0;i<op.length;i++){
			if(op[i]==c){
				return true;
			}
		}
		return false;
	}
	
	public boolean isOp(String s){
		for(int i=0;i<strOp.length;i++){
			if(strOp[i].equals(s)){
				return true;
			}
		}
		return false;
	}
	
	public List<String> Work(String str){
		List<String> list = new ArrayList<String>();
		char c;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			// 将表达式："9+(3-1)*3+10/2" 拆分
			
			c = str.charAt(i);
			
			//判断是否为 0-9 的数字，并加入sb中
			if(isDigit(c)){
				sb.append(c);
			}
			//判断是否为运算符或括号，并将其和前面的数字放入list中
			//最后再将sb清空
			if(isOp(c)){
				if(sb.toString().length()>0){
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c+"");
			}
		}
		//判断是否为大于9的数字，并加入list中
		if(sb.toString().length()>0){
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
		//得到最终结果：
		//9, +, (, 3, -, 1, ), *, 3, +, 10, /, 2
	}
	
	//增强for循环遍历打印list
	public void printList(List<String> list){
		for(String o:list){
			System.out.print(o+" ");
		}
	}
	/*
	 * 中缀表达式转化为后缀表达式
	 * 1.遇到数字输出
	 * 2.遇到高优先级的全部出栈
	 * 3.最后全部出栈
	 */
	public List<String> InfixToPostfix(List<String> list){  //放入list作为变量
		List<String> Postfixlist = new ArrayList<String>();//存放后缀表达式
		Stack<String> stack = new Stack<String>();//暂存操作符
		//stack.push('#');
		for(int i=0;i<list.size();i++){
			//9, +, (, 3, -, 1, ), *, 3, +, 10, /, 2
			
			String s = list.get(i);
			
			//先判断读入是否为最高优先级的 左括号
			//若是则直接入栈
			if(s.equals("(")){
				stack.push(s);
			}
			
			//再判断是否为第二优先级的 * / 号
			//若是则直接入栈
			else if(s.equals("*")||s.equals("/")){
				stack.push(s);
			}
			
			//再判断是否为最低优先级的 + - 号
			//若是则判断栈内是否存在括号
			    //若存在则将左括号之后的所有符号提出
			        //存入后缀表达式数组后  再入栈
			else if(s.equals("+")||s.equals("-")){
				if(!stack.empty()){
					while(!(stack.peek().equals("("))){
						Postfixlist.add(stack.pop());
						if(stack.empty()){
							break;
						}
					}
					stack.push(s);
				}
				//若不存在 左括号 则直接入栈
				else{
					stack.push(s);
				}
			}
			
			//若出现最高优先级的 右括号
			//则往当前位置读取之前的所有符号直到左括号处
			//并将其放入后缀表达式数组中
			//最后移除栈中的左括号
			else if(s.equals(")")){
				while(!(stack.peek().equals("("))){
					Postfixlist.add(stack.pop());
				}
				stack.pop();
			}
			
			//数值类型直接进入后缀表达式数组
			else{
				Postfixlist.add(s);
			}
			
			//若读取到栈的最后
			//栈中还存在着字符
			//则全部按照后至前的顺序进入后缀表达式数组中
			if(i==list.size()-1){
				while(!stack.empty()){
					Postfixlist.add(stack.pop());
				}
			}
		}
		return Postfixlist;
	}
	/*
	 * 后缀表达式计算
	 */
	public int doCal(List<String> list2){  //放入list2作为变量
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<list2.size();i++){
			//导入后缀表达式进行计算
			// 9 3 1 - 3 * + 10 2 / +  
			
			String s = list2.get(i);
			
			int t = 0;
			
			//若是数值类型则直接入栈
			if(!isOp(s)){
			    t = Integer.parseInt(s);
				stack.push(t);
			}
			
			//若遇到运算符
			//则调用前两个数值进行运算
			//运算完毕再将结果入栈保存
			else{
				if(s.equals("+")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2+a1;
					stack.push(v);
				}
				else if(s.equals("-")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2-a1;
					stack.push(v);
				}
				else if(s.equals("*")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2*a1;
					stack.push(v);
				}
				else if(s.equals("/")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2/a1;
					stack.push(v);
				}
			}
		}
		
		//最后将结果出栈；
		return stack.pop();
	}
}

public class SStack {
 
	public static void main(String[] args) {
		LT lt = new LT();
		
		//采用自行输入计算
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//String str = "9+(3-1)*3+10/2";
		List<String> list = lt.Work(str);  //使用Work方法得出中缀表达式
		
		//System.out.print("将中缀表达式拆分打印：" + list + " ");
		//System.out.println();
		
		List<String> list2 = lt.InfixToPostfix(list);  //将中缀表达式导入变为后缀表达式
		
		System.out.println("原式为："+str);
		System.out.print("后缀表达式为：");
		
		lt.printList(list2);
		System.out.println();
		
		System.out.println("计算结果为："+lt.doCal(list2));  //放入后缀表达式计算出数值
	}
}