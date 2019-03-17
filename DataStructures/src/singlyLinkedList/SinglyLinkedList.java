package singlyLinkedList;

public class SinglyLinkedList {
	
private ListNode head;

private static class ListNode
{
	private int data;
	private ListNode next;
	

	public ListNode(int i)
	{
		this.data=i;
		this.next=null;
	}

} 
public void display()
{
	ListNode current=head;
	while(current!=null)
	{
		System.out.print(current.data+" --> ");
		current=current.next;
	}
	System.out.println("null");
}
public int count()
{	int count=0;
	ListNode current=head;
	while(current!=null)
	{
		count=count+1;
		current=current.next;
	}
	return count;
}
public void addBeginning(int newnode) {
	
	ListNode newNode=new ListNode(newnode);
	newNode.next=head;
	head=newNode;

}
public void insertLast(int value) 
{
	ListNode newNode=new ListNode(value);
	if (head==null) {
		head=newNode;
	}
	else {
		ListNode Current=head;
		while (Current.next!=null)
		{
			Current=Current.next;
		}
		Current.next=newNode;
	}
}
public boolean find(int value) {
	ListNode Current=head;
	while(Current!=null) {
		if(Current.data==value)
		{
			return true;
		}
		Current=Current.next;
	}
	return false;
}

public ListNode reverse(ListNode head)
{
	ListNode current=head;
	ListNode previous=null;
	ListNode next=null;
	while (current!=null) {
		next=current.next;
		current.next=previous;
		previous=current;
		current=next;
	}
	return previous;
}
public ListNode Middle(ListNode head)
{	if(head==null)
	{
	 return head;
	}
	ListNode slowPtr=head;
	ListNode fastPtr=head;
	while(fastPtr!=null && fastPtr.next!=null) {
		slowPtr=slowPtr.next;
		fastPtr=fastPtr.next.next;
	}
	return slowPtr;
	
}
public ListNode deleteduplicatesSorted(ListNode head)
{
	if (head==null)
	{
		return null;
	}
	ListNode current=head;
	while(current!=null && current.next!=null)
	{
		if (current.data==current.next.data)
		{
			current.next=current.next.next;
		}
		else
		{
			current=current.next;
		}
	}
	
	return current;
}
public ListNode addnodeascending(int m,ListNode head) {
	ListNode n=new ListNode(m);
	if (head==null)
	{
		head=n;
	}
	if(n.data==0)
	{
	n.next=head;
	head=n;
		
	}

	ListNode current=head;
	while(current!=null)
	{
		if (current.next.data>n.data)
		{	ListNode temp= current.next;
			current.next=n;
			n.next=temp;
			return current;
			
		}
		current=current.next;
	}
	return current;
			
}
public ListNode getNode(int n,ListNode head)
{
	if(head==null)
	{
		return null;
	}
	
	ListNode firstPtr=head;
	ListNode secondPtr=head;
	int count=0;
	while (count<n)

	{
		if(firstPtr==null) {
			throw new IllegalArgumentException("n is greater than the number of elements");
		}
		firstPtr=firstPtr.next;
		count ++;
	}
	while (firstPtr!=null)
	{
		firstPtr=firstPtr.next;
		secondPtr=secondPtr.next;
	}
	return secondPtr;
}
public void deleteKey(int key) {
	ListNode current=head;
	ListNode temp=head;
	if(current!=null && current.data==key) {
		head=current.next;
		return;
	}
	while(current!=null && current.data!=key) {
		temp=current;
		current=current.next;
	}
	if (current==null) {
		return;
	}
	temp.next=current.next;
	
	return;
}
public boolean loopPresent()
{
	ListNode slowPtr=head;
	ListNode fastPtr=head;
	while(fastPtr!=null && fastPtr.next!=null) {
		fastPtr=fastPtr.next.next;
		slowPtr=slowPtr.next;
		if (fastPtr==slowPtr) {
			return true;
		}
		
	}
	return false;
	
}
public static void main(String[] args) {
	SinglyLinkedList sll= new SinglyLinkedList();
	sll.head= new ListNode(1);
	ListNode second=new ListNode(1);
	ListNode third=new ListNode(2);
	ListNode forth=new ListNode(3);
	
	sll.head.next=second;
	second.next=third;
	third.next=forth;
	//forth.next=second;
	if(!sll.loopPresent()) {
		sll.display();
	}
	else
	System.out.println("Looping present");
	/*
	sll.display();
	//System.out.println(sll.count());
	sll.insertLast(4);
	sll.insertLast(5);
	sll.addBeginning(1);
	sll.insertLast(6);
	sll.insertLast(6);
	sll.addBeginning(1
			);
	
	sll.display();
	if(sll.find(89)) {
		System.out.println("Value Found");
	}
	else
	{
		System.out.println("Value Not Found");
	}
	
	ListNode reversed=sll.reverse(sll.head);
	sll.head=reversed;
	sll.display();
	
	System.out.println(sll.Middle(sll.head).data);
	
	ListNode nthvalue=sll.getNode(5,sll.head);
	System.out.println("the Fifth value is "+nthvalue.data);
	reversed=sll.reverse(sll.head);
	sll.head=reversed;
	sll.display();
	sll.deleteduplicatesSorted(sll.head);
	sll.display();
	sll.addnodeascending(0, sll.head);
	sll.display();
	sll.deleteKey(3);

	sll.display();

*/
	
}

}
