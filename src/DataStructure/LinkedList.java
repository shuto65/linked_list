package DataStructure;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList{
	public class Node{
		int d;
		Node next;
		public Node(int d, Node next){
			this.d = d;
			this.next = next;
		}
		
		public int getItem(){
			return this.d;
		}
		
		@Override
		public boolean equals(Object obj){
			if(this == obj){
				return true;
			}
			if(!(obj instanceof Node)){
				return false;
			}
			Node node = (Node)obj; 
			if(this.d == node.d){
				return true;
			}
			return false;	  
		}
		
		@Override
		public int hashCode(){
			return this.d;
		}
		
		
	}
	
	private int size=0;
	private Node head = null;
	
	/**
	 * �R���X�g���N�^�D�����ɓn���ꂽelements�̐��������X�g�̖����ɃA�y���h
	 * @param elements
	 */
	public LinkedList(int... nums){
		for(int num: nums){
			this.appendTail(num);
		}
	}
	
	/**
	 * ���X�g�̐擪��element��ǉ�
	 * @param element
	 * @return
	 */
	public LinkedList addHead(int d){
		if(this.head == null){
			this.head = new Node(d, null);
		}
		else{
			this.head = new Node(d, this.head);
		}
		size++;
		return this;
	}
	
	/**
	 * ���X�g�̖�����element��ǉ�
	 * @param element
	 * @return
	 */
	public LinkedList appendTail(int d){
		return add(size, d);
	}
	
	/**
	 * ���X�g�̖�����index�Ԗڂ��Z����ΐ^��Ԃ�
	 * @param index
	 * @return
	 */
	private boolean isIndexInBound(int index){
		return 0 <= index && index <= size;
	}
	
	/**
	 * ���X�g��index�ԖڂɃm�[�h��ǉ�
	 * @param index
	 * @param element
	 * @return
	 */
	public LinkedList add(int index, int d){
		if(!isIndexInBound(index)){
			throw new IndexOutOfBoundsException();
		}
		if(index == 0){
			return this.addHead(d);
		}
		
		Node prevNode = findNode(index - 1);
		prevNode.next = new Node(d, prevNode.next);
		size++;
		
		return this;
	}
	
	private void link(){
		
	}
	
	public Node findNode(int index){
		if(!isIndexInBound(index)){
			throw new IndexOutOfBoundsException();
		}
		Node current = head;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}
	

	
	public int size(){
		return size;
	}

	public Node getHead(){
		return this.head;
	}
	
	public LinkedList removeTail(){
		return removeNode(size - 1);
	}
	
	public LinkedList removeNode(int index){
		if(head == null){
			return this;
		}
		if(!isIndexInBound(index)){
			throw new IndexOutOfBoundsException();
		}
		if(size == 0){
			return removeHead();
		}
		
		Node prevNode = this.findNode(index-1);
		Node node = prevNode.next;
		relink(prevNode, node);
		unlink(node);
		
		return this;
	}
	
	public LinkedList removeHead(){
		Node second = head.next;
		unlink(head);
		head = second;
		size--;
		return this;
	}
	
	private void relink(Node node, Node nextNode){
		node.next = nextNode.next;
	}
	
	private void unlink(Node node){
		node.d = 0;
		node.next = null;
	}
	
	
	public LinkedList dedup(){
		if(head == null){
			return this;
		}
		HashSet<Node> hset = new HashSet<Node>();
			
		Node prev = head;
		Node current = prev.next;
		
		hset.add(head);
		
		while(current != null){
			if(hset.contains(current)){
				prev.next = current.next;
				size--;
			}else{
				hset.add(current);
			
			}	
			prev = prev.next;
			current = current.next;				
		}
		
		return this;
		
	}	
	/**
	 * ��2-2 �𓚁D�����C���X�^���X�����v������
	 * @param index
	 * @return
	 */
	public Node getXthFromTail(int index){
		if(!isIndexInBound(index)){
			throw new IndexOutOfBoundsException();
		}
		
		Node node1 = this.head;
		Node node2 = node1;
		
		for(int k = 0; k < index - 1; k ++){
			node2 = node2.next;
		}
		
		while(node2.next != null){
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return node1;
		
	}
	
	
	
	
	/**
	 * ��2-2 �ċA�ŉ����Ă݂���
	 *
	 */
	public class Counter{
		int val=0;
	}
	public Node getXthFromTailRecursive(Node head, int index, Counter c){
		if(!isIndexInBound(index)){
			throw new IndexOutOfBoundsException();
		}
		if(head == null){
			return null;
		}
		
		Node node = getXthFromTailRecursive(head.next, index, c);
		
		if(c.val < index){
			c.val += 1;
			return head;
		}
		return node;
		
	}
	}
