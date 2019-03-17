
public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	public int length;
	
	public static class ListNode{
		private int data;
		private ListNode previous;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			
		}
	}
	public DoublyLinkedList(){
		this.head=null;
		this.tail=null;
		length=0;
		
	}
	public boolean isEmpty() {
		return length==0; //return head==null;
	}
	
	public int getLength()
	{
		return length;
	}
	public void printElementsForward() {
		if (head==null) {
			return;
		}
		ListNode current=head;
		System.out.print("null <--> ");
		while (current!=null) {
			System.out.print(current.data+" <--> ");
			current=current.next;
		}
		System.out.println("null");
	}
	public void printElementsBackwards() {
		if (tail==null) {
			return;
		}
		ListNode current=tail;
		System.out.print("null <--> ");
		while (current!=null) {
			System.out.print(current.data+" <--> ");
			current=current.previous;
		}
		System.out.println("null");
	}
	
	public void addHead(int data) {
		ListNode newnode= new ListNode(data);
		System.out.println(isEmpty());
		if (isEmpty()) {
			tail=newnode;
		}
		else 
		{
			head.previous=newnode;
		}
		newnode.next=head;
		head=newnode;
		length++;
			
	}
	public void addTail(int data) {
		ListNode newnode=new ListNode(data);
		if (isEmpty()) {
			head=newnode;
		}
		else {
			tail.next=newnode;
		}
		newnode.previous=tail;
		tail=newnode;
		length++;
	}
	public void deleteHead() {
		ListNode temp=head;
		if(isEmpty()) {
			return ;
		}
		else if (head==tail)
		{	temp.next=null;
			temp.previous=null;
			head=null;
			tail=null;
		}
		else {
			head.next.previous=null;
			head=head.next;
			temp.next=null;
			length--;
		}
	}
	public void deleteTail() {
		ListNode temp=tail;
		if (isEmpty()) 
		{
			return;
		}
		else if(head==tail) {
			head=null;
			tail=null;
		}
		else
		{
			tail.previous.next=null;
			tail=tail.previous;
			temp.previous=null;
		}	
	}
	
	public void deleteElement(int data)
	{	ListNode temp=head;
		ListNode current=head;
		int count=0;
		if(isEmpty()) {
			return;
		}
		else if (head==tail && head.data==data) {
			head=null;
			tail=null;
		}
		else if(head.data==data) {
			deleteHead();
		}
		else if(tail.data==data) {
			deleteTail();
		}
		else{
			while(current!=null)
			{
				System.out.println(count);
				count++;
				if (current.data==data) 
				{
					current.previous.next=current.next;
					current.next.previous=current.previous;
					current=current.next;
					temp.next=null;
					temp.previous=null;
					length--;
					
				}
				else {
					
					current=current.next;
				}
				temp=temp.next;
				
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		DoublyLinkedList dll=new DoublyLinkedList();

		//dll.printElementsBackwards();
		dll.addHead(5);
		dll.addHead(4);
		dll.addHead(3);
		//dll.addTail(6);
		//dll.addTail(7);
		dll.printElementsForward();
		
		//dll.deleteHead();
		//dll.deleteTail();
		dll.deleteElement(5);
		dll.printElementsForward();
		//System.out.println(dll.tail.previous.data);;
	}

}
