package singlyLinkedList;

public class CircularSinglyLinkedList {
	
	private ListNode last=null;
	
	public static class ListNode
	{
		
		private int data;
		private ListNode next;
		
		public ListNode(int data) 
		{
			this.data=data;
			this.next=null;
			
		}
	}
	public boolean isEmpty()
	{
		return last==null;
	}
	public boolean justOne() 
	{
		return last.next==last;
	}
	public void addEmpty(int i) 
	{
		
		ListNode newnode=new ListNode(i);
		newnode.next=newnode;
		last=newnode;
		
	}
	public void addtoList(int i) 
	{
		
		if(isEmpty())
		{
			addEmpty(i);
		}
		else 
		{
			ListNode newnode=new ListNode(i);
			newnode.next=last.next;
			last.next=newnode;
			last=newnode;
		}
	}
	public void singleDelete(int data) 
	{
		
		if(last.next==last &&last.data==data)
		{
			
			last=null;
		}
		
	}
	public void fullDelete(int data)
	{
		
		if(isEmpty()) 
		{
			return;
		}
		
		else if(justOne()) 
		{
				singleDelete(data);
		}
		else
		{
			ListNode current=last.next;
			if(current.data==data)
			{
				last.next=current.next;
				current.next=null;
				return;
			}
			current=current.next;
			ListNode temp=last.next;
			while (current.data!=data && current!= last.next) 
			{
				temp=current;
				current=current.next;
			}
			if (current==last.next) 
			{
				return;
			}
			else {
				temp.next=current.next;
				current.next=null;
				last=temp;
				return;
				}
		}
	}
	public void print() 
	{
		if (isEmpty()) 
		{
			System.out.println("Empty list");
		}
		else if(last.next==last) 
		{
			System.out.println(" ->"+last.data+"--");
			System.out.println("|    "
					+ " |");
			System.out.println("|_____|");
		}
		else
		{
			ListNode current=last.next;
			System.out.print("-->");
			while (current!=last)
			{
				System.out.print(current.data+" --> ");
				current=current.next;
			}
			System.out.println(last.data+" -->");
		}
	}
	
	public static void main(String[] args) {
		
		CircularSinglyLinkedList cll=new CircularSinglyLinkedList();
		//cll.last=new ListNode(10);
		cll.print();
		cll.addtoList(10);
		cll.print();
		cll.addtoList(22);
		cll.addtoList(27);
		cll.addtoList(22);
		cll.addtoList(27);
		cll.print();
		cll.fullDelete(27);
		cll.print();
		cll.fullDelete(22);
		cll.print();
		cll.fullDelete(10);
		cll.print();
	}
	
	
}
