class Solution {
    List<List<Integer>> ans = new  ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    
      f(0,nums,new ArrayList<>());
      return ans;
        
    }
    public void  f(int idx, int[] arr,ArrayList<Integer> list){

        if(idx==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        //take
        
        list.add(arr[idx]);
        f(idx+1,arr,list);

        //backtrack

        list.remove(list.size()-1);

        while (idx + 1 < arr.length && arr[idx] == arr[idx + 1]) {
           idx++;  
         }  // dup handling 


        //not take

        f(idx+1,arr,list);

    }
                 
    
} // same as strivver pattern q ( one of the three templates he thaught )