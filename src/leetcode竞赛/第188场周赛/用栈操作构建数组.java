package leetcode竞赛.第188场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/10 10:34
 */
public class 用栈操作构建数组 {

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        if (target.length == 0) {
            return res;
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (target[index] == i) {
                res.add("Push");
                index++;
            }else {
                res.add("Push");
                res.add("Pop");
            }
            if (index == target.length){
                return res;
            }
        }
        return res;
    }

}
