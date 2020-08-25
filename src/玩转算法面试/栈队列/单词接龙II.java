package ��ת�㷨����.ջ����;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/24 9:38
 */
public class ���ʽ���II {

    public static void main(String[] args) {

    }

    int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);
        //temp �������浱ǰ��·��
        findLaddersHelper(beginWord, endWord, wordList, temp, ans);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord, List<String> wordList,
                                   ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            if (min > temp.size()) {
                ans.clear();
                min = temp.size();
                ans.add(new ArrayList<>(temp));
            } else if (min == temp.size()) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (temp.size() >= min) {
            return;
        }

        Set<String> dict = new HashSet<>(wordList);
        List<String> neighbors = getNext(beginWord, dict);

        for (String neighbor : neighbors) {
            if (temp.contains(neighbor)) {
                continue;
            }
            temp.add(neighbor);
            findLaddersHelper(neighbor, endWord, wordList, temp, ans);
            //����
            temp.remove(temp.size() - 1);
        }
    }

    private List<String> getNext(String cur, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c < 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) {
                    res.add(next);
                }
                chars[i] = old;
            }
        }
        return res;
    }

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // ��������н������ʣ�ֱ�ӽ�������Ȼ��߻������ѭ��
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0; j < size; j++) {
                List<String> p = queue.poll();
                //�õ���ǰ·����ĩβ����
                String temp = p.get(p.size() - 1);
                // һ���Եõ����е���һ���Ľڵ�
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors) {
                    //ֻ����֮ǰû�г��ֹ��ĵ���
                    if (!visited.contains(neighbor)) {
                        //�����������
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<>(p));
                            p.remove(p.size() - 1);
                        }
                        //���뵱ǰ����
                        p.add(neighbor);
                        queue.offer(new ArrayList<>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}
