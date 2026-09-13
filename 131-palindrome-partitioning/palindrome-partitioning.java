class Solution {

    // Stores all valid palindrome partitions
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {

        // Start partitioning from index 0
        f(0, s, new ArrayList<>());
        return ans;

    }

    // Tries every possible substring starting from idx
    public void f(int idx, String s, ArrayList<String> list) {

        // Entire string is partitioned
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Try all possible cuts from idx
        for (int i = idx; i < s.length(); i++) {

            // Take substring from idx to i
            String part = s.substring(idx, i + 1);

            // Continue only if current part is palindrome
            if (isPalindrome(part, 0, part.length() - 1) == true) {

                list.add(part);

                // Recursively partition the remaining string
                f(i + 1, s, list);

                // Backtrack: remove the current part
                list.remove(list.size() - 1);

            }
        }
    }

    // Checks whether a string is palindrome using two pointers
    public boolean isPalindrome(String part, int left, int right) {

        while (left <= right) {

            if (part.charAt(left) != part.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
} // ek baar rec tree dekhna tab hi samaj ayega // normal vala tree + code vala