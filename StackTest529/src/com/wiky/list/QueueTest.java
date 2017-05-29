package com.wiky.list;

import java.util.Iterator;

class MyQueue<Item>{
	private Node first;
    private Node last;
    private int N;
    class Node{
    	Item value;
    	Node next;
    }
    public int size(){
    	return N;
    }
    public boolean isEmpty(){
    	return N==0;
    }
    public void push(Item item){
    	/*//表头插入元素
    	if(first==null&&last==null)
    	{	first.value=item;
    	    last=first;
    	    last.next=null;
    	    first.next=null;
    	    N++;
    	}else{
    		Node t=new Node();
    		t.value=item;
    		t.next=first.next;
    		first.next=t;
    		
    	}*/
    	//在表尾插入元素
    	Node oldLast=last;
    	last=new Node();
    	last.value=item;
    	last.next=null;
    	if(isEmpty()) first=last;
    	else    oldLast.next=last;
    	N++;
    }
    //没有向前取址的指针就比较的麻烦，所以在表头删除元素会比较好
    public Item pop(){
    	if(!isEmpty()){
       Item t=first.value;
       first=first.next;
       N--;
       return t;
     }else{
    		return null;
    	}
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Iterator<Item> iterator(){
    	return new Iterator(){
           private Node  current=first;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current!=null;
			}

			@Override
			public Item next() {
				// TODO Auto-generated method stub
				Item t=current.value;
				current=current.next;
				return t;
			}
    		
    	};
    }
}
public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      MyQueue<Integer> mq=new MyQueue<Integer>();
      mq.push(1);
      mq.push(2);
      mq.push(3);
      mq.push(4);
      
     System.out.println(mq.pop());
     System.out.println(mq.pop());
     System.out.println(mq.pop());
     System.out.println(mq.pop());
     System.out.println(mq.pop());
      
	}

}
