package 面试算法.网易提前批;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/7/22 8:15
 */
public class demo1 {

    public HashMap<Integer, Node> map;
    int[][] res;
    int index = 0;

    public int[][] invert_tree(int[][] node_data_list) {
        map = new HashMap<>();
        res = new int[node_data_list.length][node_data_list[0].length];
        buildTree(node_data_list);
        Node parent = map.get(0);
        dfs(parent.childs, 0);
        return res;
    }

    public void dfs(ArrayList<Node> nodes, int parent) {
        if (nodes == null) {
            return;
        }
        /*for (Node node: nodes) {
            res[index++] = new int[]{node.value,parent};
            dfs(node.childs,node.value);
        }*/
        for (int i = nodes.size() - 1; i >= 0; i--) {
            Node node = nodes.get(i);
            res[index++] = new int[]{node.value, parent};
            dfs(node.childs, node.value);
        }
    }

    public void buildTree(int[][] node_data_list) {
        for (int[] node : node_data_list) {
            int child = node[0];
            int parent = node[1];
            Node childNode = map.get(child) == null ? new Node(new ArrayList<>(), child) : map.get(child);
            Node parentNode = map.get(parent) == null ? new Node(new ArrayList<>(), parent) : map.get(parent);
            parentNode.childs.add(childNode);
            map.put(parent, parentNode);
            map.put(child, childNode);
        }
    }

    private class Node {
        private ArrayList<Node> childs;
        int value;

        public Node(ArrayList<Node> childs, int value) {
            this.childs = childs;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 0}, {2, 1}, {3, 1}
        };

    }


}
