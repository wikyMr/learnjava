import java.util.Stack;

import javax.print.DocFlavor.STRING;


public class LispTest1 {

	//实现Lisp语言到C格式的转换
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String a="(add 2 3)";
     String b="(add 1 (mul -2 -2))";
     String c="(add (mul 2 2) (mul 2 2))";
     String d="(add (mul (mul 2 2) (mul 2 2)) (mul 2 2))";
     System.out.println(Integer.parseInt("-1"));
     System.out.println(lisp2C(a));
     System.out.println(lisp2C(b));
      System.out.println(lisp2C(c));
     System.out.println(lisp2C(d));
   
	}
	
	public static String lisp2C(String lisp){
		String replace=lisp.replaceAll("[ ]+", ",");
		System.out.println("No nsp:"+replace);
		String result="";
		int count=0;
		for(int i=0;i<replace.length();i++){
			char c=replace.charAt(i);
			if(c=='('){//遇到左括号记录括号的个数
				count++;
			}else if((c==',')&&(count!=0)){//遇到逗号就把左边的括号放入结果字符串里面
			      result+="(";	
			      count--;
			}else{//依次放入结果字符串里面
				result+=c;
			}
			
		}
		return result;
		
	}

   
}
