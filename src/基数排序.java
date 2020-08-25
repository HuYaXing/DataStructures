import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/7 10:48
 */
public class 基数排序 {

    public static void main(String[] args) {
        int[] nums = {53, 3, 542, 748, 14, 214};
        radixSort(nums);
    }

    public static void radixSort(int[] arr) {

        //得到最大数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //定义一个二维数组(每个桶是一个一维数组)
        //空间换时间
        int[][] bucket = new int[10][arr.length];

        //记录每个桶实际存放的数据个数(定义一个一维数组)
        int[] bucketElementCounts = new int[10];


        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第i轮（针对个位数）
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素个位
                int digitOfElement = arr[j] / n % 10;
                //放入对应的桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序放入原来的数组
            int index = 0;
            //遍历每一个桶，将数据放入数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //判断桶中是否有数据
                if (bucketElementCounts[k] != 0) {
                    //循环第K个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入数组
                        arr[index] = bucket[k][l];
                        index++;
                    }
                    bucketElementCounts[k] = 0;
                }
            }
            System.out.println("第" + i + 1 + "轮：" + Arrays.toString(arr));
        }
    }
}
