package 算法训练1_16;

/**
 * @Author HYStar
 * @Date 2020/1/16 16:10
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(height));
    }

    /**
     * 暴力破解法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    public static int maxArea1(int[] height) {
        int r = 0;
        int f = height.length - 1;
        int res = 0;

        while (r < f) {
            res = Math.max(Math.min(height[r], height[f]) * (f - r), res);
            if (height[r] <= height[f]) {
                r++;
            } else {
                f--;
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

}
