package com.wiky.list;

import java.util.Iterator;

class MyStack<Item>{
	private Node first;
	private int N;
	private class Node{
		Node next;
		Item value;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(Item t){
		Node oldfirst=first;
		first=new Node();
		first.value=t;
		first.next=oldfirst;
		N++;
			
	}
	public Item pop(){
		Node t=first;
		first=first.next;
		N--;
		return t.value;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterator<Item> iterator(){
		return new Iterator(){
           private Node current=first;
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
public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MyStack<Integer> it=new MyStack<Integer>();
       it.push(1);
       it.push(2);
       it.push(3);
       it.push(4);
       
       System.out.println(it.pop());
       System.out.println(it.size());
	}

}
