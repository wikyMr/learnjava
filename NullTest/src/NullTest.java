import java.util.*;


public class NullTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      @SuppressWarnings("rawtypes")
	Map numCount=new HashMap<>();
      int[] nums={1,2,0,6,3,4,0,2,0,3,2};
      for(int i:nums){
    	  //int count=(int) numCount.get(i);
    	  //numCount.put(i, count++);//count自动装箱会装换成null
      }
      Object obj=new Object();
      //Integer i=null;
      //System.out.println(i++);
      
      String a="mm";
      char c='蕊';
      System.out.println(""+c);
     Object object=new Object();
    
      
	}

}
