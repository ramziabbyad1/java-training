import java.util.HashMap;
import java.util.Map;


public class MaxSubArrLenSum {
	public static int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length, sum = 0, maxSubLen = 0;
        //Using a hash map to store the sum of all the values before and include nums[i]
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < length; i++) {
            sum += nums[i];
            if(sum == k) {
                maxSubLen = Math.max(maxSubLen, i + 1);
            } else if(map.containsKey(sum - k)) {
                maxSubLen = Math.max(maxSubLen, i - map.get(sum - k));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxSubLen;
    }

	public static void main(String[] args) {
		int[] nums = {1,-1,5,-2,3};
		int k = -3;
		int ans = maxSubArrayLen(nums, 8);
		System.out.println("ans = "+ans);
	}

}
