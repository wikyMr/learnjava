import java.util.Stack;


public class LispTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String a="(add 2 3)";
	     String b="(add 1 (sub -2  -2))";
		 String c="(not (or T F))";
	     String d="(and (gt 2 3) (gt 2 3))";
	     String e="(gt (add 5 3) (sub 5 3))";
	     String f="(lt (sub (add 2 3) (or T F)) (add 2 3))";
	     System.out.println(lispCheck(a));
	     System.out.println(lispCheck(b));
	      System.out.println(lispCheck(c));
	     System.out.println(lispCheck(d));
	     System.out.println(lispCheck(e));
	     System.out.println(lispCheck(f));
	}
	public static String operteNum(String nstr){
		if(nstr.equals("T")||nstr.equals("F")){
			return "T";
		}else{
			return "error";
		}
		
	}
	
	public static String operteNum(String o,String n1str,String n2str){
		Integer n1,n2;
		if(o.equals("add")||o.equals("sub")){
		  try{
			n1=Integer.parseInt(n1str);
			n2=Integer.parseInt(n2str);
		   }catch(NumberFormatException e){
			return "error";
		   }
		  return String.valueOf(n1+n2);
		    }else if(o.equals("gt")||o.equals("lt")||o.equals("equ")){
			     try{
					n1=Integer.parseInt(n1str);
					n2=Integer.parseInt(n2str);
				   }catch(NumberFormatException e){
					   return "error";
				   }
				  return "T";
				  }else if(o.equals("and")||o.equals("or")){
					if((n1str.equals("T")||n1str.equals("F"))&&(n2str.equals("T")||n2str.equals("F"))){
						return "T";
					}else{
						return "error";
					}
				}else{
					return "error";
				}
		
	}
	public static String lispCheck(String lisp){
		String replace=lisp.replaceAll("[ ]+", ",");//将空格的多次出现全部替换成1次逗号出现
		//System.out.println("No nsp:"+replace);
		int count=0;
		StringBuffer numberstr = new StringBuffer();
		StringBuffer operatorstr = new StringBuffer();
		//数字栈需要变为String类型，需要存放e
		Stack<String> operators=new Stack<String>();
		Stack<String> nums=new Stack<String>();
		for(int i=0;i<replace.length();){
			char ch=replace.charAt(i);
			if(ch=='('){
				int k=0;
				for(k=i+1;replace.charAt(k)!=','&&replace.charAt(k)!=')';k++){
					char temp=replace.charAt(k);
					operatorstr.append(""+temp);
				}
				operators.push(operatorstr.toString());
				//System.out.println("operator:"+operatorstr);
				operatorstr=new StringBuffer("");
				i+=(k-i);
				count++;
			}else if((replace.charAt(i)=='-')||
					(replace.charAt(i)>='0'&&replace.charAt(i)<='9'
					||replace.charAt(i)=='T')||
					(replace.charAt(i)=='F')){//是数字类型或boolean类型
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
				   //Not操作符需要pop一个操作数
				   if(!o.equals("not")){
				        String n2str=nums.pop();
				        String n1str=nums.pop();
						   //注意出栈的顺序，先出栈的为第一个操作数
						   String opresult=operteNum(o,n1str,n2str);
						   nums.push(opresult);
						   count--;
				   }else{
					   String nstr=nums.pop();
				        //System.out.println(o);
						   //注意出栈的顺序，先出栈的为第一个操作数
						String opresult=operteNum(nstr);
						nums.push(opresult);
						count--;
				   }
				}
				i++;
			}else{
				i++;
			}
		}
		if(nums.peek().equals("T")||nums.peek().equals("F")){
			return "bool";
		}else{
			try{
				Integer t=Integer.parseInt(nums.peek());
				return "int";
			}catch(NumberFormatException e){
				   return "error";
			 }
		}
		
	}
}
