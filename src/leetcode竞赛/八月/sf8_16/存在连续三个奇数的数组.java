package leetcode����.����.sf8_16;

/**
 * @Author HYStar
 * @Date 2020/8/16 10:32
 */
public class ���������������������� {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1){
                count++;
            }else {
                count = 0;
            }
            if (count == 3){
                return true;
            }
        }
        return false;
    }

}
