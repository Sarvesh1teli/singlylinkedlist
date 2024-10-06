package com.linkedlist;


public class SinglyLinkedList {
	
	static ListNode head ;
	
	public static void main(String[] args) {
		
		ListNode listNode = new ListNode(10);
		display(head);
		
	}
	private static void display(ListNode head) {
		ListNode temp = head;
		
		if(temp==null) {
			System.out.println("Empty list..");
			return;
		}
		System.out.println("SinglyLinkedList Elements are: ");
		while (temp !=null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}
	
	private static void insertRearEndOp_1(int data) {
		
	}
	private static  void insertFrontEndOp_2(int data) {
		
	}
}

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}


class RandomPtrNode{
	private int data;
	private RandomPtrNode next;
	private RandomPtrNode radom;
	public RandomPtrNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public RandomPtrNode getNext() {
		return next;
	}
	public void setNext(RandomPtrNode next) {
		this.next = next;
	}
	public RandomPtrNode getRadom() {
		return radom;
	}
	public void setRadom(RandomPtrNode radom) {
		this.radom = radom;
	}
	
}
