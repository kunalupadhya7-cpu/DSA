class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(); 

        for (int i = 0; i < s.length(); i++) { 
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') { 
                sb.append(ch);
            }
            else if (ch >= 'A' && ch <= 'Z') { 
                sb.append((char)(ch + 32));
            }
            else if (ch>='0' && ch<='9'){
                sb.append(ch);
            }


        }
       
        String str = sb.toString();
        
        return f(str,0,str.length()-1);
    
        
    

    }

    public static boolean f(String str,int left,int right){

       if(left>=right){
            return true;
        }

        if(str.charAt(left)!=str.charAt(right)){
            return false;
        }
        

        return f(str,left+1,right-1);

    }
} 