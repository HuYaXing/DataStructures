package 玩转算法面试.栈队列;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/23 10:15
 */
public class 单词接龙 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(ladderLength(beginWord, endWord, wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(beginWord, 1));

        int size = wordList.size();
        boolean[] flag = new boolean[size];

        while (!queue.isEmpty()) {
            String s = queue.peek().v1;
            int num = queue.peek().v2;
            queue.remove();

            if (s.equals(endWord)) {
                return num;
            }

            for (int i = 0; i < size; i++) {
                if (isString(s, wordList.get(i)) && !flag[i]) {
                    queue.add(new Pair1(wordList.get(i), num + 1));
                    flag[i] = true;
                }
            }
        }
        return 0;
    }

    public static boolean isString(String beginWord, String word) {
        int count = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        // 因为所有单词的长度都是一样的
        int L = beginWord.length();

        // 字典，用来保存可以形成的单词的组合
        // 从任何给定的词。一次换一个字母
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // 键是通用词
                        // 值是具有相同中间泛型单词的单词列表。
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // 以确保我们不会重复处理相同的单词。
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // 表示当前单词的中间词
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // 下一个状态是所有处于相同中间状态的单词。
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // 如果我们找到了我们要找的东西
                    // i.e. the end word - 我们可以带着答案回来.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // 否则，将其添加到BFS队列。也标志着它的访问
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 双向广度优先搜索
     */
    private int L = 0;
    private Map<String, List<String>> allComboDict = new HashMap<>();

    private int visitWordNode(
            Queue<Pair<String, Integer>> Q,
            Map<String, Integer> visited,
            Map<String, Integer> othersVisited) {

        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < this.L; i++) {

            // 表示当前单词的中间词
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

            // 下一个状态是所有处于相同中间状态的单词。
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                // 如果我们找到了我们要找的东西
                // i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 因为所有单词的长度都是一样的。
        this.L = beginWord.length();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // 键是通用词
                        // 值是具有相同中间泛型单词的单词列表。
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations =
                                this.allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        this.allComboDict.put(newWord, transformations);
                    }
                });

        // 双向BFS的队列
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // 以确保我们不会重复处理相同的单词。
        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

            // 离开始单词只有一跳
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }

            // 离结束词还有一跳
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }

        return 0;
    }

}

class Pair1 {
    String v1;

    int v2;

    public Pair1(String v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}