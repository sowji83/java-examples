
public class LinkList<T> {
	private ListNode<T> head = null;
	private ListNode<T> current = null;
	private int count = 0;
	
	public void append(ListNode<T> node) {
		if(node == null) return;
		if(current == null) {
			head = node;
			current = head;			
		}
		else {
			current.next = node;
			current = node;
		}
		count++;
	}
	
	public void prepend(ListNode<T> node) {
		if(head != null) { 
			node.next = head;			
		}
		head = node;
		if(current == null) {
			current = head;
		}
		count++;
	}
	
	public ListNode<T> removeFront() {
		ListNode<T> t = head;
		if(t == null) return t;
		if(current == head) {
			current = t.next;
		}
		head = t.next;
		t.next = null;
		return t;
	}
	
	public ListNode<T> removeTail(){
		
	}
	
	public void print() {
		ListNode<T> t = head;
		while(t != null) {
			System.out.print(t.value.toString() + ", ");
			t = t.next;
		}
		System.out.println();
	}
	
}
