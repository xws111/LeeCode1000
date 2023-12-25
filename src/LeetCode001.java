import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1.两数之和
 * 本题使用哈希法，哈希表可以将将时间复杂度降低到O(1)
 */


public class LeetCode001 {
    public int[] twoSum(int[] nums, int target) {
        //创建哈希表
        Map<Integer, Integer> hashtable = new HashMap<>();
        //查找target-nums[i]是否存在于哈希表，存在则返回下标，否则将nums[i]放入哈希表
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{i, hashtable.get(target - nums[i])};
            }
            hashtable.put(nums[i], i);
        }
        //没有查找到，返回空数组
        return null;
    }
}
