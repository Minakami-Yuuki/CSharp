import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

class LT {
 
	public char[] op = {'+','-','*','/','(',')'};
	public String[] strOp = {"+","-","*","/","(",")"};
	
	//�ж���ֵ
	public boolean isDigit(char c){
		if(c>='0'&&c<='9'){
			return true;
		}
		return false;
	}
	
	//�ж��ַ�
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
			// �����ʽ��"9+(3-1)*3+10/2" ���
			
			c = str.charAt(i);
			
			//�ж��Ƿ�Ϊ 0-9 �����֣�������sb��
			if(isDigit(c)){
				sb.append(c);
			}
			//�ж��Ƿ�Ϊ����������ţ��������ǰ������ַ���list��
			//����ٽ�sb���
			if(isOp(c)){
				if(sb.toString().length()>0){
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c+"");
			}
		}
		//�ж��Ƿ�Ϊ����9�����֣�������list��
		if(sb.toString().length()>0){
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
		//�õ����ս����
		//9, +, (, 3, -, 1, ), *, 3, +, 10, /, 2
	}
	
	//��ǿforѭ��������ӡlist
	public void printList(List<String> list){
		for(String o:list){
			System.out.print(o+" ");
		}
	}
	/*
	 * ��׺���ʽת��Ϊ��׺���ʽ
	 * 1.�����������
	 * 2.���������ȼ���ȫ����ջ
	 * 3.���ȫ����ջ
	 */
	public List<String> InfixToPostfix(List<String> list){  //����list��Ϊ����
		List<String> Postfixlist = new ArrayList<String>();//��ź�׺���ʽ
		Stack<String> stack = new Stack<String>();//�ݴ������
		//stack.push('#');
		for(int i=0;i<list.size();i++){
			//9, +, (, 3, -, 1, ), *, 3, +, 10, /, 2
			
			String s = list.get(i);
			
			//���ж϶����Ƿ�Ϊ������ȼ��� ������
			//������ֱ����ջ
			if(s.equals("(")){
				stack.push(s);
			}
			
			//���ж��Ƿ�Ϊ�ڶ����ȼ��� * / ��
			//������ֱ����ջ
			else if(s.equals("*")||s.equals("/")){
				stack.push(s);
			}
			
			//���ж��Ƿ�Ϊ������ȼ��� + - ��
			//�������ж�ջ���Ƿ��������
			    //��������������֮������з������
			        //�����׺���ʽ�����  ����ջ
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
				//�������� ������ ��ֱ����ջ
				else{
					stack.push(s);
				}
			}
			
			//������������ȼ��� ������
			//������ǰλ�ö�ȡ֮ǰ�����з���ֱ�������Ŵ�
			//����������׺���ʽ������
			//����Ƴ�ջ�е�������
			else if(s.equals(")")){
				while(!(stack.peek().equals("("))){
					Postfixlist.add(stack.pop());
				}
				stack.pop();
			}
			
			//��ֵ����ֱ�ӽ����׺���ʽ����
			else{
				Postfixlist.add(s);
			}
			
			//����ȡ��ջ�����
			//ջ�л��������ַ�
			//��ȫ�����պ���ǰ��˳������׺���ʽ������
			if(i==list.size()-1){
				while(!stack.empty()){
					Postfixlist.add(stack.pop());
				}
			}
		}
		return Postfixlist;
	}
	/*
	 * ��׺���ʽ����
	 */
	public int doCal(List<String> list2){  //����list2��Ϊ����
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<list2.size();i++){
			//�����׺���ʽ���м���
			// 9 3 1 - 3 * + 10 2 / +  
			
			String s = list2.get(i);
			
			int t = 0;
			
			//������ֵ������ֱ����ջ
			if(!isOp(s)){
			    t = Integer.parseInt(s);
				stack.push(t);
			}
			
			//�����������
			//�����ǰ������ֵ��������
			//��������ٽ������ջ����
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
		
		//��󽫽����ջ��
		return stack.pop();
	}
}

public class SStack {
 
	public static void main(String[] args) {
		LT lt = new LT();
		
		//���������������
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//String str = "9+(3-1)*3+10/2";
		List<String> list = lt.Work(str);  //ʹ��Work�����ó���׺���ʽ
		
		//System.out.print("����׺���ʽ��ִ�ӡ��" + list + " ");
		//System.out.println();
		
		List<String> list2 = lt.InfixToPostfix(list);  //����׺���ʽ�����Ϊ��׺���ʽ
		
		System.out.println("ԭʽΪ��"+str);
		System.out.print("��׺���ʽΪ��");
		
		lt.printList(list2);
		System.out.println();
		
		System.out.println("������Ϊ��"+lt.doCal(list2));  //�����׺���ʽ�������ֵ
	}
}