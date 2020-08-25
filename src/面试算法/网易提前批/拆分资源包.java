package 面试算法.网易提前批;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/7/21 20:06
 */

public class 拆分资源包 {
    public int split_package(String[] filenames, String[][] relations) {
        // write code here
        UF uf = new UF(filenames);
        for (String[] strings : relations) {
            uf.unionElements(strings[0], strings[1]);
        }
        return uf.count;
    }

    private class UF {
        int count;
        private HashMap<String, String> parent = new HashMap<>();
        private HashMap<String, Integer> size = new HashMap<>();

        public UF(String[] filenames) {
            for (int i = 0; i < filenames.length; i++) {
                parent.put(filenames[i], filenames[i]);
                size.put(filenames[i], 1);
            }
            count = filenames.length;
        }

        private String find(String str) {
            while (!str.equals(parent.get(str))) {
                String p = parent.get(parent.get(str));
                parent.put(str, p);
                str = p;
            }
            return str;
        }

        public void unionElements(String p, String q) {
            String pRoot = find(p);
            String qRoot = find(q);
            if (pRoot.equals(qRoot)) {
                return;
            }
            int pSize = size.get(pRoot);
            int qSize = size.get(qRoot);
            count--;
            if (pSize > qSize) {
                parent.put(qRoot, pRoot);
                size.put(pRoot, pSize + qSize);
            } else {
                parent.put(pRoot, qRoot);
                size.put(qRoot, pSize + qSize);
            }
        }
    }
}
