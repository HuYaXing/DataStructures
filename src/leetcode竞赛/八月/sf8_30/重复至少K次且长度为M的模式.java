package leetcode����.����.sf8_30;

import java.util.HashSet;

/**
 * @Author HYStar
 * @Date 2020/8/30 11:09
 */
public class �ظ�����K���ҳ���ΪM��ģʽ {


    public static void main(String[] args) {
        �ظ�����K���ҳ���ΪM��ģʽ main = new �ظ�����K���ҳ���ΪM��ģʽ();
        int[] arr = {3,2,1,3,3,2,1,3,3,1,2,3,3,2,1,3,2,1,1};
        System.out.println(main.containsPattern(arr, 1, 2));
    }

    /**
     * ����m�ظ�k��
     *
     * @param arr
     * @param m
     * @param k
     * @return
     */
    public boolean containsPattern(int[] arr, int m, int k) {

        for (int i = 0; i < arr.length - m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + m; j++) {
                sb.append(arr[j]);
            }
            String str = sb.toString();
            int flag = 1;
            if (flag == k) {
                return true;
            }
            boolean a = true;
            for (int j = i + m; j <= arr.length - m; j += m) {
                for (int l = 0; l < m; l++) {
                    if (arr[j + l] != str.charAt(l) - '0') {
                        a = false;
                        break;
                    }
                }
                if (a) {
                    flag++;
                }
                if (flag == k) {
                    return true;
                }
            }
        }
        return false;
    }

}
