class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder(); // revise string builder

        for (int i = 0; i < s.length(); i++) { 
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') { // once revise Ascii conerstions
                str.append(ch);
            }
            else if (ch >= 'A' && ch <= 'Z') { 
                str.append((char)(ch + 32));
            }
            else if (ch>='0' && ch<='9'){
                str.append(ch);
            }


        }

        int left = 0;
        int right = str.length() - 1;

        while (left <= right) { // 2 pointer apprach

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
} 