class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {

                stack.push(ch);
                continue;

            } // open bracket is pushed ,so we can compare it later with closed ones

            if (stack.isEmpty()){
                return false;
            } // if we encounter closed bracket and stack is empty means no open bracket was earlier there so false 

            if (ch == '}' && stack.peek() == '{') { // case 1 
                stack.pop();
                continue;

            }

            else if (ch == ']' && stack.peek() == '[') { // case 2 
                stack.pop();
                continue;

            }

            else if (ch == ')' && stack.peek() == '(') { // case 3
                stack.pop();
                continue;

            }

            else { // if three cases are wrong means open!= closed ,,so immedieate false 

                return false;
            }

        } 

        return stack.isEmpty(); // say all open and closed brackets are cancleed ,,,,and stack still have open brackets then stack is not empty --- false 

        //only true if stack is Empty means  no of (open=close)

    }
}