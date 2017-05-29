package com.wiky.arr;

import java.util.Iterator;

class MyStack<Item> implements Iterable<Item>{//�̳пɵ����ӿ�
	private Item[] arr=(Item[])new Object[1];
	private int N;
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void newSize(int n){
		int m=2*n;
		//���ܴ���һ�����͵����飬���ǿ���ǿ������ת��
		@SuppressWarnings("unchecked")
		Item[] t=(Item[])new Object[m];
		for(int i=0;i<n;i++){
			t[i]=arr[i];
		}
		arr=(Item[])new Object[m];
		arr=t;
	}
	public void push(Item a){
      	/*if(arr.length==N){
      		newSize(arr.length);
      	}else{//������ϸ�else�ͻᵼ����չ�ռ�ʱ�������Ǹ�Ԫ����
      		arr[N]=a;
      		N++;
      	}*/
		if(arr.length==N)
      		newSize(arr.length);
      	arr[N]=a;
      	N++;
	}
	public Item pop(){
	    if(N!=0){
		Item a=arr[--N];
		arr[N]=null;
		//��N--�ٴ����µĿռ�
		if(arr.length/4==N)
			//newSize--arr.length/2������N/2
			newSize(arr.length/2);
		
		return a;
	    }else{
	    	return null;
	    }
		
	}
	public Iterator iterator(){
		return new Iterator(){

			int i=N;
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
public class StatckTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MyStack<Integer> arr=new MyStack<Integer>();
       arr.push(1);
       arr.push(2);
       arr.push(3);
       
       System.out.println(arr.pop());
       System.out.println(arr.pop());
       System.out.println(arr.pop());
       System.out.println(arr.pop());
	}

}
