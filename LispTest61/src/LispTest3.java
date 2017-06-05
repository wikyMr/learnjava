import java.util.Stack;


public class LispTest3 {

	//实现除0检查
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String a1="(add 2 e)";
		    String b1="(add 1 (div -2  0))";
		    String c1="(add (mul 2 0) (mul 2 2))";
		    String d1="(add (div (mul 2 2) (mul 2 2)) (mul 2 0))";
		    System.out.println(getResultNoError(a1));
		    System.out.println(getResultNoError(b1));
		    System.out.println(getResultNoError(c1));
		    System.out.println(getResultNoError(d1));
	}
	//这个函数主要对操作的数字进行判断，若为e需要特殊处理，div与mov在第二个操作数为0时需要返回e
	public static String operteNum(String o,String n1str,String n2str){
		Integer n1,n2;
		if(n1str.equals("e")||n2str.equals("e")){
			return "e";
		}else {
			n1=Integer.parseInt(n1str);
			n2=Integer.parseInt(n2str);
		  if(o.equals("add")){ return String.valueOf((n1+n2));}
		  if(o.equals("sub")){ return String.valueOf((n1-n2));}
		  if(o.equals("mul")){return String.valueOf((n1*n2));}
		  if(o.equals("div")){
			  if(n2==0){
				  return "e";
			  }else{
				  return String.valueOf((n1/n2));
		  }
		  }
		  if(o.equals("mod")){
			  if(n2==0){
				  return "e";
			  }else{
				  return String.valueOf((n1%n2));
				  }
		  }
		  return "e";
		}
		
	}
	public static String getResultNoError(String lisp){
		String replace=lisp.replaceAll("[ ]+", ",");//将空格的多次出现全部替换成1次逗号出现
		//System.out.println("No nsp:"+replace);
		int result=0;
		int count=0;
		StringBuffer numberstr = new StringBuffer();
		Integer number;
		//数字栈需要变为String类型，需要存放e
		Stack<String> operators=new Stack<String>();
		Stack<String> nums=new Stack<String>();
		String operator="";
		for(int i=0;i<replace.length();){
			char ch=replace.charAt(i);
			if(ch=='('){
				operator=replace.substring(i+1,i+4);
				//System.out.println("operator:"+operator);
				operators.push(operator);
				count++;
				i+=3;
			}else if((replace.charAt(i)=='-')||
					(replace.charAt(i)>='0'&&replace.charAt(i)<='9')||
					(replace.charAt(i)=='e')){//是数字类型
					int k=0;
					for(k=i;replace.charAt(k)!=','&&replace.charAt(k)!=')';k++){
						char temp=replace.charAt(k);
						numberstr.append(""+temp);
					}
					nums.push(numberstr.toString());
					numberstr=new StringBuffer("");
					i+=(k-i);
				}
			else if(ch==')'){
				if(count!=0){
				   String o=operators.pop().toLowerCase();
				   String n2str=nums.pop();
				   String n1str=nums.pop();
				   //注意出栈的顺序，先出栈的为第一个操作数
				   String opresult=operteNum(o,n1str,n2str);
				   nums.push(opresult);
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
