class Solution {
    public ListNode removeNodes(ListNode head) {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> ans = new ArrayDeque<>();

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) { // rev LinkedList so we could traverse from back and do prevGreater algo

            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;

        }

        head = prev; // prev is the head of reversed list
        stack.push(head.val);
        ans.push(head.val);

        curr = head.next;

        while (curr != null) {

            while (!stack.isEmpty() && stack.peek() <= curr.val) {
                stack.pop();
            }

            if (stack.isEmpty()) { // matlab koi greater nahi he 
                ans.push(curr.val);
            }


            stack.push(curr.val);

            curr = curr.next;

        }  // prevGreater stack q with minor adjustments


         // answer is in stack now convert pop the ans and make Linked List of it 
        head = null;
        ListNode tail = null;

        while (!ans.isEmpty()) {   

            ListNode node = new ListNode(ans.pop());

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
         return head;
    }
}