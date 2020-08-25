package ��ת�㷨����.ջ����;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/21 9:54
 */
public class ��·�� {

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");

        List<String> res = new ArrayList<>();
        int jumCount = 0;

        for (int i = dirs.length - 1; i > 0; i--) {
            //��ǰĿ¼�Ϳ�����
            if ("".equals(dirs[i]) || ".".equals(dirs[i])) {
                continue;
            }
            if ("..".equals(dirs[i])) {
                jumCount++;
                continue;
            }
            if (jumCount > 0) {
                jumCount--;
                continue;
            }
            res.add(0, dirs[i]);
        }
        return "/" + String.join("/", res);
    }

}
