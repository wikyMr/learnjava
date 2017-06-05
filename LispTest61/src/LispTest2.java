import java.util.Stack;


public class LispTest2 {
    
	//ʵ�ּ�����
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
		String replace=lisp.replaceAll("[ ]+", ",");//���ո�Ķ�γ���ȫ���滻��1�ζ��ų���
		//System.out.println("No nsp:"+replace)
		int count=0;
		StringBuffer numberstr = new StringBuffer();
		Integer number;
		Stack<String> operators=new Stack<String>();
		Stack<Integer> nums=new Stack<Integer>();
		String operator="";
		for(int i=0;i<replace.length();){
			char ch=replace.charAt(i);
			if(ch=='('){//���������ţ��������Ĳ�������ջ
				operator=replace.substring(i+1,i+4);
				//System.out.println("operator:"+operator);
				operators.push(operator);
				count++;
				i+=3;
			}else if((replace.charAt(i)=='-')||(replace.charAt(i)>='0'&&replace.charAt(i)<='9')){//����������
					int k=0;
					//�������ַ�����ȡ����
					for(k=i;replace.charAt(k)!=','&&replace.charAt(k)!=')';k++){
						char temp=replace.charAt(k);
						numberstr.append(""+temp);
					}
					//ͨ��parseIntת��������
					//System.out.println("k:"+(k-i));
					//System.out.println("numberStr:"+numberstr);
					number=Integer.parseInt(numberstr.toString());
					//����������ջ
					nums.push(number);
					//System.out.println("number:"+number);
					numberstr=new StringBuffer("");
					i+=(k-i);
				}
			else if(ch==')'){//������������Ҫ��ջ��������
				//System.out.println("count:"+count);
				if(count!=0){
				   String o=operators.pop().toLowerCase();
				   Integer n1=nums.pop();
				   Integer n2=nums.pop();
				   //ע���ջ��˳��
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
