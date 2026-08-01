class Solution {

    class Pair {
        char ch;
        int cnt;

        Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {

        Deque<Pair> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek().ch == ch) {

                stack.peek().cnt++;

                if (stack.peek().cnt == k) {
                    stack.pop();
                }

            } else {
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {

            Pair top = stack.removeLast();

            for (int i = 0; i < top.cnt; i++) {
                ans.append(top.ch);
            }
        }

        return ans.toString();
    }
}