package À„∑®—µ¡∑;

/**
 * @Author HYStar
 * @Date 2019/11/30 16:25
 */
public class Test {

    public static void main(String[] args) {
//        for (int i = 97; i < 97 + 26; i++) {
//            System.out.println((char) i);
//        }
        int a = 0;
        for (int i = 2; i < 150; i++) {
            if(a == 26){
                break;
            }
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
                a++;
            }
        }
    }
    
}
