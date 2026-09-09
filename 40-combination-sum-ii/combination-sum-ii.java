class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        f(0,candidates,0,new ArrayList<>(),target);
        return ans; 
    }
    
    public void f(int idx,int[] arr,int sum,ArrayList<Integer> list,int target){

        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        // if( sum > target ) return  // no need that break will handle this // if that break line not witten then we can write this // but writing break is more efficient // understand by  rec tree why so 
        
        for(int i =idx;i<arr.length;i++){

            if(i>idx && arr[i]==arr[i-1]) continue;
            if(sum+arr[i]>target) break ; // return can also be written here //
            
            list.add(arr[i]);
            sum+=arr[i];

            f(i+1,arr,sum,list,target);

            list.remove(list.size()-1);
            sum-=arr[i];


        }


    }


}