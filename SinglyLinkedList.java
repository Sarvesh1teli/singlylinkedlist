package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedListCisco {
	
	static ListNode head ;
	static RandomPtrNode randomPtrHead;
	
	public static void main(String[] args) {
		
		//ListNode listNode = new ListNode(10);
		insertFrontEndOp_2(50);
		insertFrontEndOp_2(40);
		insertFrontEndOp_2(30);
		insertFrontEndOp_2(20);
		insertFrontEndOp_2(10);
		
		insertRearEndOp_1(60);
		insertRearEndOp_1(70);
		insertRearEndOp_1(80);
		insertRearEndOp_1(90);
		insertRearEndOp_1(100);
		
		System.out.println("Elements are :");
		display(head);
		System.out.println();
		System.out.println();
		
		System.out.println("3.Find the Middle element");
		findMiddelElement_3();
		System.out.println();
		
		
		boolean iscycle = isCyclic_4();
		System.out.println("4.Is clyclic:"+iscycle);
		System.out.println();
		
		int k=3;
		System.out.println("5.findTheNthElement_5 k="+k);
		findTheNthElement_5(k);
		System.out.println();
		
		
		
		System.out.println("6.Reverse elements are :");
		reverseTheLinkedList_6();
		display(head);
		System.out.println();
		
		System.out.println();
		System.out.println("7.swapAlternateNode_7");
		ListNode listnode =  swapAlternateNode_7();
		display(listnode);
		System.out.println();
		
		System.out.println("8.dispalyDataInReverseOrder using Backing...");
		dispalyDataInReverseOrder_8(head);
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(9);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(0);
		ListNode node6 = new ListNode(1);
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		System.out.println("9.Adding two lists...");
		System.out.println("list1 elemnts are...");
		
		display(l1);
		System.out.println();
		System.out.println("List2 elemnts are...");
		display(node4);
		System.out.println();
		
		System.out.println("Merged elements are:");
		ListNode addTwoList = addTwoLinkedList_9(l1,node4);
		display(addTwoList);
		System.out.println();
		
		
		RandomPtrNode r1 = new RandomPtrNode(10);
		RandomPtrNode r2 = new RandomPtrNode(20);
		RandomPtrNode r3 = new RandomPtrNode(30);
		RandomPtrNode r4 = new RandomPtrNode(40);
		RandomPtrNode r5 = new RandomPtrNode(50);
		RandomPtrNode r6 = new RandomPtrNode(60);
		
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		r4.next = r5;
		r5.next = r6;
		r6.next = null;
		r1.setRadom(r4);
		r5.setRadom(r1);
		
		r2.setRadom(r6);
		 r3.setRadom(r5);
		randomPtrHead = r1;
		System.out.println();
		displayRandom(randomPtrHead);
		
		System.out.println("Cloned elements are:");
		RandomPtrNode res = cloneLinkedList_11();
		displayRandom(res);
	}
	
	private static void displayRandom(RandomPtrNode head) {
		
		RandomPtrNode temp = randomPtrHead;
		
		if(temp==null) {
			System.out.println("Empty list..");
			return;
		}
		//System.out.println("SinglyLinkedList Elements are: ");
		while (temp !=null) {
			System.out.println(temp.getData()+" random:"+(temp.getRadom()==null?null:temp.getRadom().data));
			temp = temp.getNext();
		}
	}
	
	private static void display(ListNode head) {
		ListNode temp = head;
		
		if(temp==null) {
			System.out.println("Empty list..");
			return;
		}
		//System.out.println("SinglyLinkedList Elements are: ");
		while (temp !=null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}
	
	private static void insertRearEndOp_1(int data) {
		
		ListNode temp = new ListNode(data);
		if(head == null) {
			head = temp;
			return;
		}
		ListNode cur = head;
		ListNode prev = null;
		while(cur != null) {
			prev = cur;
			cur=cur.getNext();
		}
		prev.setNext(temp);
		
		
	}
	private static  void insertFrontEndOp_2(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}
	private static  void findMiddelElement_3() {
		ListNode ptr1 = head;
		ListNode ptr2 = head.next;
		
		while(ptr2 != null && ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		System.out.println("Middle elements is:"+ptr1.data);
		
	}
	private static  boolean isCyclic_4() {
		ListNode ptr1 = head;
		ListNode ptr2 = head.next;
		
		while(ptr2 != null && ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
			if(ptr1==ptr2) {
				return true;
			}
		}
		return false;
		
	}
	
	private static  void findTheNthElement_5(int k) {
		ListNode temp = head;
		
		for(int i=0;i<k;i++) {
			temp=temp.next;
		}
		ListNode cur = head;
		while(temp != null) {
			cur=cur.next;
			temp=temp.next;
		}
		System.out.println(cur.data);
	}
	
	private static  void reverseTheLinkedList_6() {
		ListNode cur = head;
		ListNode prev = null;
		ListNode p2 = head.next;
		
		while(cur !=null) {
			cur.next = prev;
			prev = cur;
			cur = p2;
			if(p2 != null) {
				p2 = p2.next;
			}
		}
		head = prev;

	}
	
	private static ListNode swapAlternateNode_7() {
		
		ListNode cur = head;
		ListNode ahead = head.next;
		
		if(cur.next==null) {
			return cur;
		}
		ListNode prev  = null;
		
		while(cur != null && cur.next != null) {
			ListNode p1 = cur;
			ListNode p2 = cur.next;
			
			p1.next = p2.next;
			p2.next = p1;
			
			if(prev!=null) {
				prev.next = p2;
			}
			prev = cur;
			cur = cur.next;
		}
		return ahead;
	}
	
	private static  void dispalyDataInReverseOrder_8(ListNode temp) {
		
		if(temp == null) {
			return;
		}
	   dispalyDataInReverseOrder_8(temp.next);
	   System.out.println(temp.data);
	}
	
	private static ListNode addTwoLinkedList_9(ListNode list1, ListNode list2) {
	
		int carry = 0;
		ListNode result = null;
		ListNode temp = null;
		ListNode prev = null;

		while (list1 != null || list2 != null) {
			int sum = carry + (list1 == null ? 0 : list1.data) + (list2 == null ? 0 : list2.data);
			carry = sum >= 10 ? 1 : 0;
			sum = sum % 10;
			temp = new ListNode(sum);

			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;

			if (list1 != null) {
				list1 = list1.next;
			}

			if (list2 != null) {
				list2 = list2.next;
			}
		}
		if(carry > 0) {
			prev .next = new ListNode(carry);
		}
		return result;
	}

	private static  void checkIspalindrome_10() {
		
	}
	
	private static  RandomPtrNode cloneLinkedList_11() {
		
		RandomPtrNode original = randomPtrHead;
		Map<RandomPtrNode,RandomPtrNode> map = new HashMap<>();
		
		while(original != null) {
			RandomPtrNode cloned = new RandomPtrNode(original.data);
			map.put(original, cloned);
			original = original.next;
		}
		
		RandomPtrNode current =randomPtrHead ;
		RandomPtrNode cloned = null;
		RandomPtrNode prev = null;
		RandomPtrNode newhead = null;
		while(current != null) {
			cloned = map.get(current);
			cloned.radom = map.get(current).getRadom();
			
			if(prev == null) {
				prev = cloned;
				newhead = cloned;
			}else {
				prev.next = cloned;
				prev = cloned;
				
			}
			current = current.next;
			
		}
		return newhead;
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
	 int data;
	 RandomPtrNode next;
	 RandomPtrNode radom;
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

/*
Elements are :
10 20 30 40 50 60 70 80 90 100 

3.Find the Middle element
Middle elements is:50

4.Is clyclic:false

5.findTheNthElement_5 k=3
80

6.Reverse elements are :
100 90 80 70 60 50 40 30 20 10 

7.swapAlternateNode_7
90 100 70 80 50 60 30 40 10 20 
8.dispalyDataInReverseOrder using Backing...
20
10
40
30
60
50
80
70
100
9.Adding two lists...
list1 elemnts are...
1 1 9 
List2 elemnts are...
1 0 1 
Merged elements are:
2 1 0 1 

10 random:40
20 random:60
30 random:50
40 random:null
50 random:10
60 random:null
Cloned elements are:
10 random:40
20 random:60
30 random:50
40 random:null
50 random:10
60 random:null
*/
