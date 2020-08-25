package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2019/11/22 20:59
 */
public class Graph {

    //存储顶点集合
    private ArrayList<String> vertexList;
    //邻接矩阵
    private int[][] edges;
    //边的数目
    private int numOfEdges;

    //定义数组boolean[],记录节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        for (String value : vertexValue) {
            graph.insertVertex(value);
        }
        //添加边,AB权重为1
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
        System.out.println("深度优先遍历");
        graph.dfs();
    }

    //构造器
    public Graph(int n) {
        //初始化vertexList
        edges = new int[n][n];
        isVisited = new boolean[n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
    }

    /**
     * 得到第一个邻接节点的下标w
     * 如果存在返回对应下标，不存在返回-1
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历算法,第一次i=0
    public void dfs(boolean[] isVisited, int i) {
        //首先我们访问该节点
        System.out.println(getValueByIndex(i) + "->");
        //访问过的节点设置成已经访问过
        isVisited[i] = true;
        //查找节点i的第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w已经被访问过了
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，遍历所有的节点，并进行dfs
    public void dfs() {
        //遍历所有节点，进行dfs[回溯]
        for (int i = 0; i < getNumOfEdges(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回节点i（下标）的对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边,v1，v2表示点的下标,weight表示权值
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
