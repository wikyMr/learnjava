package com.wiky.arr;

import java.util.Iterator;

class MyQueue<Item> implements Iterable<Item>{//继承可迭代接口
	private Item[] arr=(Item[])new Object[1];
	private int N;
	private int count;
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void newSize(int n){
		int m=2*n;
		@SuppressWarnings("unchecked")
		Item[] t=(Item[])new Object[m];
		for(int i=0;i<n;i++){
			t[i]=arr[i];
		}
		arr=(Item[])new Object[m];
		arr=t;
	}
	public void push(Item a){
		if(arr.length==N)
      		newSize(arr.length);
      	arr[N]=a;
      	N++;
	}
	public Item pop(){
	    if(N!=count){
		Item a=arr[count];
		arr[count]=null;
		count++;

		return a;
	    }else{
	    	return null;
	    }
		
	}
	public Iterator iterator(){
		return new Iterator(){

			int i=count;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return i!=0;
			}

			@Override
			public Object next() {
				// TODO Auto-generated method stub
				Item t=arr[i];
				i--;
				return t;
			}
			
		};
	}
}
public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MyQueue<Integer> arr=new MyQueue<Integer>();
       arr.push(1);
       arr.push(2);
       arr.push(3);
       
       System.out.println(arr.pop());
       System.out.println(arr.pop());
       System.out.println(arr.pop());
       System.out.println(arr.pop());
	}

}
