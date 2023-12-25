import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 方法一：排序
 * 将每个字符串按照字典序排序，排序后相同的必然是字母异位词
 * 1、创建一个HashMap，键为排序后的字符串，值为未排序的字符串集合
 * 2、遍历字符串，将每个字符串排序后加入到Map中
 * 3、返回结果
 * 方法二：计数
 * 字母异位词中，每个字符出现的次数必然是相同的
 * 1、记录每个字母出现的次数
 * 2、遍历字符串，将字母及出现的次数拼接，作为哈希表的键，值为字符串集合
 * 3、返回结果
 */

public class LeetCode002 {

    //方法一
    public static List<List<String>> groupAnagrams01(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //方法二
    public static List<List<String>> groupAnagrams02(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char)'a' + i);
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams02(strs);
    }

}
