
class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        // Start recursion from index 0 with an empty StringBuilder
        f(0, digits, new StringBuilder());

        return ans;
    }

    public void f(int idx, String digits, StringBuilder sb) {

        // BASE CASE:
        // If we have processed all digits,
        // current combination is complete.
        if (idx == digits.length()) {

            // StringBuilder -> String before storing in List
            ans.add(sb.toString());

            return;
        }

        // Take the current digit
        char x = digits.charAt(idx);

        // This will contain the letters mapped to the current digit
        String str = "";

        // Find letters corresponding to the current digit
        switch (x) {

            case '2':
                str = "abc";
                break;

            case '3':
                str = "def";
                break;

            case '4':
                str = "ghi";
                break;

            case '5':
                str = "jkl";
                break;

            case '6':
                str = "mno";
                break;

            case '7':
                str = "pqrs";
                break;

            case '8':
                str = "tuv";
                break;

            case '9':
                str = "wxyz";
                break;
        }

        // Try every possible letter for the current digit
        for (int i = 0; i < str.length(); i++) {

            // CHOOSE:
            // Add one letter to the current combination
            sb.append(str.charAt(i));

            // RECURSE:
            // Move to the next digit
            f(idx + 1, digits, sb);

            // BACKTRACK:
            // Remove the last added letter so that
            // we can try the next possible letter
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

