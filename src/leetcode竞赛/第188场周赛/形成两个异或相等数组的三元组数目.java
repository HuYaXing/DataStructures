package leetcode竞赛.第188场周赛;

/**
 * @Author HYStar
 * @Date 2020/5/10 10:40
 */
public class 形成两个异或相等数组的三元组数目 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};

//        System.out.println(2 == (3 ^ 1));

        System.out.println(countTriplets(arr));
    }

    public static int countTriplets(int[] arr) {
        int res = 0;
        for (int index = 0; index < arr.length - 1; index++) {
            int a = arr[index];
            for (int i = index; i < arr.length - 1; i++) {
                if (i > index) {
                    a = a ^ arr[i];
                }
                int b = arr[i + 1];
                if (a == b) {
                    res++;
                }
                for (int j = i + 2; j < arr.length; j++) {
                    b = b ^ arr[j];
                    if (a == b) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

}
