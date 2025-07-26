package pack;

public class MyLinkedList_671755 {

    protected Node head;

    protected class Node{
        int data;
        Node next;

        Node (int data){
            this.data=data;
            this.next=null;
        }

        
    }

    public MyLinkedList_671755(){
        this.head=null;
    }

    public int size(){
        int count=0;
        Node current=head;
        while (current != null){
            count++;
            current=current.next;
        }
        return count;
    }

    public void add (int d){
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insert(int d ){
        Node newNode = new Node(d);
        if (head == null || head.data >= d) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < d) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int find ( int d){
        Node current=head;
        int index=0;
        while(current != null){

            if(current.data==d){
                return index;
            }
            current=current.next;
            index++;
        }

        return -1;
    }

    public void delete(int d){
        Node current=head;
        Node prevNode=null;

        while (current != null && current.data != d){
            prevNode=current;
            current=current.next;
        
    
        }

        if (current==null){
            return ;
        }

        if (prevNode==null){
            head=current.next;
        }else{
            prevNode.next=current.next;
        }
    }

    public int getAt(int index){
        Node current=head;
        int count=0;
        while (current != null){
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }
        return -1; 

    }

    public void setAt(int index, int d){
        Node current=head;
        int count=0;
        while(current!=null){
            if(count==index){
                current.data=d;
                return;
            }
            current=current.next;
            count++;
        }
    }

    public void  add(int [] data){
        for(int d=data.length-1; d>=0; d--){
            add(data[d]);
        }
    }

    public void insert(int [] data){
        for(int d:data){
            insert(d);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }
}

