package ��ת�㷨����.����;

/**
 * @Author HYStar
 * @Date 2020/4/7 9:53
 */
public class ���ֲ��� {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 9));
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            System.out.println(left);
            System.out.println(right);
            return -1;
        }

        //Ϊ�˷�ֹ�������,��left��right���ر���ʱ�����int���ܻ�Խ��
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target);
        } else {
            return binarySearch(arr, left, mid - 1, target);
        }
    }

}
