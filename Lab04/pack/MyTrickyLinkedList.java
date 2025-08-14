package Lab04.pack;

public class MyTricklyLinkedList  extends MyLinkedList{
    public void q1_rotate_counter_clockwise(int k){
        if (size()==0)
         return;
        k=k%size();
        if(k<=0 || head==null){
                return ;
        }

        Node current=head;
        for(int i=1; i<k; i++){
                current=current.next;
        }
        Node newHead=current.next;
        current.next=null;

        Node tail=newHead;
        while(tail.next!=null){
            tail=tail.next;
        }

        tail.next=head;
        head=newHead;
    }

    public void q1_rotate_clockwise(int k){
        q1_rotate_counter_clockwise(size()-k);

    }

    public void q2_reverse(){
        if(head==null || size()<=1)
            return;
        Node current=head;
        Node reversed=null;
        Node previous=null;

        while(current.next!=null){
            previous=current;
            current=current.next;
            previous.next=reversed;
            reversed=previous;
        }
        current.next=reversed;
        head=current;
    }

    public void q3_remove_dup(){
        Node current=head;
        while(current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }
            current=current.next;
        }
    }

    public void q4_add_one() {
        q2_reverse();
        //System.out.println(toString());
        Node current= head;
        int carry=1;
        while(current!=null){
            current.data+=carry;
            if(current.data>=10){
                carry=current.data/10;
                current.data=current.data%10;
                
            }else{
                carry=0;
                break;
            }
            current=current.next;
        }
            q2_reverse();
            //System.out.println(toString());
        if(carry==1){
            Node add=new Node(1);
            add.next=head;
            head=add;
        }
    }

    public boolean q5_isPalindrome() {
        if (head == null || head.next == null)
            return true;

        int mid = size() / 2;
        int count = 0;

        Node current = head;
        while (count < mid - 1) {
            current = current.next;
            count++;
        }

        Node temp = null; // middle node for odd length
        Node second;
        if (size() % 2 == 0) {
            second = current.next;
        } else {
            temp = current.next;
            second = current.next.next;
        }

        // Split list
        current.next = null;

        // Reverse second half and keep a copy for restoring
        Node reversedSecond = reverseList(second);

        // Compare
        Node first = head;
        Node checkSecond = reversedSecond;
        boolean isSame = true;
        while (first != null && checkSecond != null) {
            if (first.data != checkSecond.data) {
                isSame = false;
                break;
            }
            first = first.next;
            checkSecond = checkSecond.next;
        }

        // Restore the list
        Node restoredSecond = reverseList(reversedSecond);

        if (temp != null) {
            current.next = temp;
            temp.next = restoredSecond;
        } else {
            current.next = restoredSecond;
        }

        return isSame;
    }

    // Reverse helper
    private Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    
}
