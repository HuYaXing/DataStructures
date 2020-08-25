package sf3_18;

/**
 * @Author HYStar
 * @Date 2020/3/19 9:39
 */
public class 最大三角形面积 {

    public static void main(String[] args) {

    }

    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res = Math.max(res, area(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}
