package com.wiky.main;

class A{
	void m1(){}
	
}
class B extends A{
	void m2(){}
}
class G extends B{
	
}

public class Test2 {

	public static void main(String[] args) {
 		// TODO Auto-generated method stub
      A[] as={new A(),new B(),new G()};
      for(A a:as){
    	  a.m1();
    	  if(a instanceof B||a instanceof G){
    		  
    	  }
      }
	}

}
