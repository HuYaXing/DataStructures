package ��ת�㷨����.����.ָ����ײ;

/**
 * @Author HYStar
 * @Date 2020/4/9 21:57
 */
public class ʢ���ˮ������ {

    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            if (height[start] > height[end]) {
                max = Math.max((end - start) * height[end], max);
                end--;
            } else {
                max = Math.max((end - start) * height[start], max);
                start++;
            }
        }

        return max;

    }

}
