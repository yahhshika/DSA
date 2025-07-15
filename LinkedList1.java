package GitsPushed;

// import java.util.LinkedList;

public class LinkedList1 {
    static class Node {
        int data;
        Node next; 
        Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        if(head == null){
            head = tail = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head; 
        head = newNode;
        size++;
        return;
    }
    public void printLL(){
        Node temp = head; 
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addLast( int data){
        if(head == null){
            head = tail = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        size++;
        tail.next = newNode;
        // newNode.next = null;
        tail = newNode;
        return;
    }
    public void deleteFirst(){
        if(head == null){
            return;
        }
        size--;
        head = head.next;
        return;
    }
    public void deleteLast(){
        //size 0 or 1(head is tail)
        if(head == null || head.next == null){
            size = 0;
            return;
        }
        Node temp = head; 
        while(temp.next.next !=null){
            temp = temp.next; 
        }
        size--;
        temp.next = null;
        return; 
        
    }
    public void addInMiddle(int data, int ind){
        if(ind == 0){
            addFirst(data);
            return;
        }
        if(ind == size){
            addLast(data);
            return;
        }
        if(ind>size){
            return; 
        }
        int counter = 0;
        Node temp = head;
        while(ind-1 != counter){
            counter++;
            temp  = temp.next;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
        return;

    }

    public int iterativeSearch(int data){
        if(head == null){
            return -1;
        }
        if(head.data == data){
            return 0;
        }
        Node temp = head; 
        int counter = 0;
        int ind  = -1;
        while(temp!=null && temp.data != data){
            temp = temp.next;
            counter++;
            if(temp!= null && temp.data ==data){
                ind = counter;
                break;
            }
        }
        return ind;
    }
    public int recursiveSearch(int data, Node head, int counter){
        if(head == null){
            return -1;
        }
        if(head.data == data){
            return counter;
        }
        return recursiveSearch(data, head.next, counter+1);
        
    }

    public static void main(String[] args) {
        LinkedList1 ll = new LinkedList1();
        // ll.head = new Node(0)
        ll.addFirst(5);
        ll.addFirst(7);
        ll.addFirst(18);
        ll.addLast(21);
        ll.addLast(33);
        // ll.addLast(9);
        // ll.addLast(9);
        // ll.addLast(14);
        // ll.addLast(14);
        ll.printLL();
        // head = ll.deleteFirst(head);
        // ll.deleteLast();
        // ll.deleteLast();
        // ll.deleteLast();
        ll.addInMiddle(100, 2);
        ll.addInMiddle(101, 6);
        ll.printLL();
        System.out.println(ll.iterativeSearch(7));
        System.out.println(ll.recursiveSearch(7, head, 0));
        System.out.println(size);
        

    }
    
}