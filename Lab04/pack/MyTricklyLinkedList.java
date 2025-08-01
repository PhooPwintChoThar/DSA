package pack;

public class MyTrickyLinkedList extends MyLinkedList_671755 {

    public MyTrickyLinkedList(){
        super();
    }

    public void q1_rotate_clockwise(int k) {
        if (head == null || k <= 0) return;
        
        int size = size();
        k = k % size; // Handle k > size
        if (k == 0) return;
        
        
        Node current = head;
        for (int i = 1; i < size - k; i++) {
            current = current.next;
        }
        
    
        Node newHead = current.next;
        current.next = null;
        
        current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        
   
        current.next = head;
        head = newHead;
    }
    

    public void q1_rotate_counter_clockwise(int k) {
        if (head == null || k <= 0) return;
        
        int size = size();
        k = k % size;
        if (k == 0) return;
        
 
        q1_rotate_clockwise(size - k);
    }
    

    public void q2_reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public void q3_remove_dup() {
        if (head == null) return;
        
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    
    public void q4_increment_digits() {
        
        q2_reverse();
        
        Node current = head;
        int carry = 1;
        
        while (current != null && carry > 0) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            
            if (current.next == null && carry > 0) {
                // Need to add a new node for carry
                current.next = new Node(carry);
                carry = 0;
            }
            current = current.next;
        }

        q2_reverse();
    }
    

    

    public boolean q5_isPalindrome() {
        if (head == null || head.next == null) return true;
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
      
        Node secondHalf = slow;
        if (fast != null) {
            secondHalf = slow.next;
        }
   
        Node reversedSecondHalf = reverseList(secondHalf);
        

        boolean isPalindrome = compareLists(head, reversedSecondHalf);
        
      
        reverseList(reversedSecondHalf);
        
        return isPalindrome;
    }
    

    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
 
    private boolean compareLists(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true; 
    }
}
