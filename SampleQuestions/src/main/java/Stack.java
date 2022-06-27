
public class Stack<T> {
	private ListNode<T> head = null;
	
	public void push(ListNode<T> obj) {
		if(obj == null) return;
		if(head == null) {
			head = obj;
		}
		else {
			obj.next = head;
			head = obj;
		}
	}	
	public ListNode<T> pop(){
		ListNode<T> ret = head;
		if(head != null) {
			head = head.next;
		}
		return ret;
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
