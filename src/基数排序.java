import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/7 10:48
 */
public class �������� {

    public static void main(String[] args) {
        int[] nums = {53, 3, 542, 748, 14, 214};
        radixSort(nums);
    }

    public static void radixSort(int[] arr) {

        //�õ��������λ��
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //����һ����ά����(ÿ��Ͱ��һ��һά����)
        //�ռ任ʱ��
        int[][] bucket = new int[10][arr.length];

        //��¼ÿ��Ͱʵ�ʴ�ŵ����ݸ���(����һ��һά����)
        int[] bucketElementCounts = new int[10];


        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //��i�֣���Ը�λ����
            for (int j = 0; j < arr.length; j++) {
                //ȡ��ÿ��Ԫ�ظ�λ
                int digitOfElement = arr[j] / n % 10;
                //�����Ӧ��Ͱ
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //�������Ͱ��˳�����ԭ��������
            int index = 0;
            //����ÿһ��Ͱ�������ݷ�������
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //�ж�Ͱ���Ƿ�������
                if (bucketElementCounts[k] != 0) {
                    //ѭ����K��Ͱ
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //ȡ��Ԫ�ط�������
                        arr[index] = bucket[k][l];
                        index++;
                    }
                    bucketElementCounts[k] = 0;
                }
            }
            System.out.println("��" + i + 1 + "�֣�" + Arrays.toString(arr));
        }
    }
}
