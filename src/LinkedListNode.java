
public class LinkedListNode {
	int d;
	LinkedListNode next = null;
	
	LinkedListNode(int d){
		this.d = d;
	}
	
	public void appendTail(int d){
		LinkedListNode node = this;
		
		while(node.next != null){
			node = node.next;
		}
		this.next = new LinkedListNode(d);
		
		
	}
	
}
