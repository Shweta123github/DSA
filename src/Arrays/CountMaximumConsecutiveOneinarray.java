package Arrays;
//optimal  --->tc-->n sc-->1
public class CountMaximumConsecutiveOneinarray {

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int n=nums.length;
            int count=0;
            int maxonescount=0;
            for(int i=0;i<n;i++){
                if(nums[i]==1){
                    count++;
                }else{
                    count=0;
                }
                maxonescount=Math.max(count,maxonescount);
            }
            return maxonescount;
        }
    }
}

//485
//nums = [1,1,0,1,1,1]
//output=3