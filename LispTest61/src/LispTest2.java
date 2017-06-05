import java.util.Stack;


public class LispTest2 {
    
	//实现计算结果
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String a="(add 2 3)";
	     String b="(add 1 (mul -2  -2))";
	     String c="(add (mul 2 2) (mul 2 2))";
	     String d="(add (mul (mul 2 2) (mul 2 2)) (mul 2 2))";
		 System.out.println(getResult(a));
	     System.out.println(getResult(b));
	    System.out.println(getResult(c));
	    System.out.println(getResult(d));
	}
	public static int getResult(String lisp){
		String replace=lisp.replaceAll("[ ]+", ",");//将空格的多次出现全部替换成1次逗号出现
		//System.out.println("No nsp:"+replace)
		int count=0;
		StringBuffer numberstr = new StringBuffer();
		Integer number;
		Stack<String> operators=new Stack<String>();
		Stack<Integer> nums=new Stack<Integer>();
		String operator="";
		for(int i=0;i<replace.length();){
			char ch=replace.charAt(i);
			if(ch=='('){//遇到左括号，接下来的操作符入栈
				operator=replace.substring(i+1,i+4);
				//System.out.println("operator:"+operator);
				operators.push(operator);
				count++;
				i+=3;
			}else if((replace.charAt(i)=='-')||(replace.charAt(i)>='0'&&replace.charAt(i)<='9')){//是数字类型
					int k=0;
					//把数字字符串提取出来
					for(k=i;replace.charAt(k)!=','&&replace.charAt(k)!=')';k++){
						char temp=replace.charAt(k);
						numberstr.append(""+temp);
					}
					//通过parseInt转化成数字
					//System.out.println("k:"+(k-i));
					//System.out.println("numberStr:"+numberstr);
					number=Integer.parseInt(numberstr.toString());
					//操作数字入栈
					nums.push(number);
					//System.out.println("number:"+number);
					numberstr=new StringBuffer("");
					i+=(k-i);
				}
			else if(ch==')'){//遇到右括号需要出栈并计算结果
				//System.out.println("count:"+count);
				if(count!=0){
				   String o=operators.pop().toLowerCase();
				   Integer n1=nums.pop();
				   Integer n2=nums.pop();
				   //注意出栈的顺序
				  if(o.equals("add")){nums.push(n2+n1);}
				  if(o.equals("sub")){nums.push(n2-n1);}
				  if(o.equals("mul")){nums.push(n2*n1);}
				  if(o.equals("div")){nums.push(n2/n1);}
				  if(o.equals("mod")){nums.push(n2%n1);}
				   count--;
				}
				i++;
			}else{
				i++;
			}
		}
		return nums.peek();
	}
}
