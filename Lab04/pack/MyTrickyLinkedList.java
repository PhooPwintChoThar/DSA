package pack;

public class MyTrickyLinkedList extends MyLinkedList_671755 {

    public MyTrickyLinkedList(){
        super();
    }

    public void q1_rotate_counter_clockwise(int k) {
        if (head == null || k <= 0) return;
        
        // Get the size of the list
        int size = size();
        if (size <= 1) return;
        
        // Normalize k to avoid unnecessary rotations
        k = k % size;
        if (k == 0) return;
        
        // Find the new tail (k-1 from head) and new head (k from head)
        Node newTail = head;
        for (int i = 0; i < k - 1; i++) {
            newTail = newTail.next;
        }
        
        Node newHead = newTail.next;
        
        // Find the current tail
        Node currentTail = head;
        while (currentTail.next != null) {
            currentTail = currentTail.next;
        }
        
        // Perform the rotation
        newTail.next = null;  // Break the list
        currentTail.next = head;  // Connect old tail to old head
        head = newHead;  // Update head
    }

    public void q2_reverse() {
        if (head == null || head.next == null) return;
        
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
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
                // Don't move current, check again
            } else {
                current = current.next;
            }
        }
    }

    public void q4_increment_digits() {
        if (head == null) return;
        
        // Reverse the list to process from least significant digit
        q2_reverse();
        
        Node current = head;
        int carry = 1;  // We want to add 1
        
        while (current != null && carry > 0) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            
            if (carry == 0) break;
            
            // If we're at the last node and still have carry
            if (current.next == null && carry > 0) {
                Node newNode = new Node(carry);
                current.next = newNode;
                carry = 0;
            }
            
            current = current.next;
        }
        
        // Reverse back to original order
        q2_reverse();
    }

    public boolean q5_isPalindrome() {
        if (head == null || head.next == null) return true;
        
        // Find the middle of the list
        Node slow = head;
        Node fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half
        Node secondHalf = reverseList(slow.next);
        slow.next = null;  // Break the connection
        
        // Compare the two halves
        Node firstHalf = head;
        boolean isPalin = true;
        
        while (secondHalf != null && firstHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        // Restore the list (optional, but good practice)
        secondHalf = reverseList(secondHalf);
        slow.next = secondHalf;
        
        return isPalin;
    }
    
    // Helper method for reversing a portion of the list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
