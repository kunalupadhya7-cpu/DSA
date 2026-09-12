class Solution {
    
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        
        f(n,1,0,new StringBuilder("("));
        return ans;
        
    }

    public void f(int n,int opened,int closed, StringBuilder sb){
        
        if(opened>n) return ;
        if(closed-opened==1) return; 
    
       

        if(sb.length()==2*n) {
            ans.add(sb.toString());
            return;

        }

       sb.append("(");
       opened++;

       f(n,opened,closed,sb);

       sb.deleteCharAt(sb.length()-1);
       opened--;

       sb.append(")");
       closed++;

      f(n,opened,closed,sb);
      
      sb.deleteCharAt(sb.length()-1);
      closed--;

    }
}