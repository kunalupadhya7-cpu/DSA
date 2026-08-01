
class Solution {
    public ListNode removeNodes(ListNode head) {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> ans = new ArrayDeque<>();

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        head = prev;

        stack.push(head.val);
        ans.push(head.val);

        curr = head.next;

        while (curr != null) {

            while (!stack.isEmpty() && stack.peek() <= curr.val) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                ans.push(curr.val);

            }

            stack.push(curr.val);

            curr = curr.next;

        }

        ListNode dummy = new ListNode(-1);
        curr = dummy;

        while (!ans.isEmpty()) {

            ListNode node = new ListNode(ans.pop());

            curr.next = node;

            curr = curr.next;

        }

        return dummy.next;

    }
}