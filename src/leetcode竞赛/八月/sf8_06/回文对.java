package leetcode竞赛.八月.sf8_06;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/6 16:47
 */
public class 回文对 {

    List<Node> tree = new ArrayList<>();

//    public List<List<Integer>> palindromePairs(String[] words) {
//
//    }

}

class Node {
    int[] ch = new int[26];
    int flag;

    public Node(){
        flag = -1;
    }
}