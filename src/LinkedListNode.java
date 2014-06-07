
public class LinkedListNode {
	int d;
	LinkedListNode head = null;
	LinkedListNode next = null;
	
	LinkedListNode(int d){
		this.d = d;
	}
	
	public void appendTail(int d){
		if(head == null){
			head = new LinkedListNode(d);
			return;
		}
		LinkedListNode node = this;
		
		
		while(node.next != null){
			node = node.next;
		}
		this.next = new LinkedListNode(d);	
	}
	
	public void printList(){
		
	}
	
	public void dedup(){
	}
	
}
