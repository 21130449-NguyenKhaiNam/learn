package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
	/*
	 * 
	 */
	 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	     Map<Integer, Integer> map  = new HashMap<Integer, Integer>();
	     for (int i = 0; i < nums.length - 1;) {
			map.put(nums[i], i);
			if(map.containsKey(nums[++i])) {
				if(Math.abs(map.get(nums[i]) - i) <= k && Math.abs(map.get(nums[i]) - nums[--i]) <= t) return true;
			}
		}
	     return false;
	    }
}
