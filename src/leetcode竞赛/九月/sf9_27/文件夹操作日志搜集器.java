package leetcode竞赛.九月.sf9_27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/27 上午10:32
 */
public class 文件夹操作日志搜集器 {

    public int minOperations(String[] logs) {
        int res = 0;
        for (int i = 0; i < logs.length; i++) {
            if ("../".equals(logs[i])) {
                res--;
                res = Math.max(res, 0);
            } else if (!"./".equals(logs[i])) {
                res++;
            }
        }
        return Math.max(res, 0);
    }

}
