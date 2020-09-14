package leetcode竞赛.八月.sf8_27;

import java.util.*;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/8/27 下午1:01
 */
public class 重新安排行程 {

    public static void main(String[] args) {

    }

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String temp = map.get(curr).poll();
            dfs(temp);
        }
        itinerary.add(curr);
    }

}
