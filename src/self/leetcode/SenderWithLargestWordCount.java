package self.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        TreeMap<Integer, String> treeM = new TreeMap<>();
        int max = 0;
        for (String s : senders) {
            treeMap.put(s, 0);
        }

        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            int length = words.length;
            int curLen = treeMap.get(senders[i]);
            curLen += length;
            max = Math.max(max, curLen);
            treeMap.put(senders[i], curLen);
        }

        for (Map.Entry<String, Integer> map: treeMap.entrySet()){
            String k = map.getKey();
            int v = map.getValue();
            treeM.put(v, k);
        }

        return treeM.get(max);
    }

    public static void main(String[] args) {
        String[] messages = {"How is leetcode for everyone","Leetcode is useful for practice"};
        String[] senders = {"Bob","Charlie"};
        System.out.println(new SenderWithLargestWordCount().largestWordCount(messages, senders));
    }
}
