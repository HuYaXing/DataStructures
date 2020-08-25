package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2019/11/22 20:59
 */
public class Graph {

    //�洢���㼯��
    private ArrayList<String> vertexList;
    //�ڽӾ���
    private int[][] edges;
    //�ߵ���Ŀ
    private int numOfEdges;

    //��������boolean[],��¼�ڵ��Ƿ񱻷���
    private boolean[] isVisited;

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        for (String value : vertexValue) {
            graph.insertVertex(value);
        }
        //��ӱ�,ABȨ��Ϊ1
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
        System.out.println("������ȱ���");
        graph.dfs();
    }

    //������
    public Graph(int n) {
        //��ʼ��vertexList
        edges = new int[n][n];
        isVisited = new boolean[n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
    }

    /**
     * �õ���һ���ڽӽڵ���±�w
     * ������ڷ��ض�Ӧ�±꣬�����ڷ���-1
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

    //����ǰһ���ڽӽڵ���±�����ȡ��һ���ڽӽڵ�
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //������ȱ����㷨,��һ��i=0
    public void dfs(boolean[] isVisited, int i) {
        //�������Ƿ��ʸýڵ�
        System.out.println(getValueByIndex(i) + "->");
        //���ʹ��Ľڵ����ó��Ѿ����ʹ�
        isVisited[i] = true;
        //���ҽڵ�i�ĵ�һ���ڽӽڵ�
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //���w�Ѿ������ʹ���
            w = getNextNeighbor(i, w);
        }
    }

    //��dfs�������أ��������еĽڵ㣬������dfs
    public void dfs() {
        //�������нڵ㣬����dfs[����]
        for (int i = 0; i < getNumOfEdges(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    //���ؽڵ�ĸ���
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //�õ��ߵĸ���
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //���ؽڵ�i���±꣩�Ķ�Ӧ������
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //����v1��v2��Ȩֵ
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //��ʾͼ��Ӧ�ľ���
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //������
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //��ӱ�,v1��v2��ʾ����±�,weight��ʾȨֵ
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
