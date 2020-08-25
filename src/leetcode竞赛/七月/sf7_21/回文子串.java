package leetcode����.����.sf7_21;

/**
 * @Author HYStar
 * @Date 2020/7/22 8:27
 */
public class �����Ӵ� {

    public static void main(String[] args) {
        �����Ӵ� main = new �����Ӵ�();

        System.out.println(main.countSubstrings1("aaa"));

    }

    /**
     * ������չ
     *
     * @param S
     * @return
     */
    public int countSubstrings(String S) {
        int N = S.length();
        int ans = 0;
        for (int center = 0; center < 2 * N - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }

        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.substring(i, i + 1);
        }
        ret += "#$";
        return ret;
    }

    public int countSubstrings1(String s) {
        int res = 0;
        String T = preProcess(s);
        int length = T.length();
        int[] p = new int[length];
        int C = 0, R = 0;

        for (int i = 1; i < length - 1; i++) {
            int i_mirror = C - (i - C);
            int diff = R - i;

            //��ǰi��C��R֮�䣬�������û��ĵĶԳ�����
            if (diff >= 0) {
                //i�ĶԳƵ�Ļ��ĳ�����C�Ĵ���ķ�Χ�ڲ�
                if (p[i_mirror] < diff) {
                    p[i] = p[i_mirror];
                } else {
                    p[i] = diff;
                    //i���Ļ��ĳ�����Χ��
                    while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1)) {
                        p[i]++;
                    }
                    C = i;
                    R = i + p[i];
                }
            } else {
                p[i] = 0;
                while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1)) {
                    p[i]++;
                }
                C = i;
                R = i + p[i];
            }
            res += (p[i] + 1) / 2;
        }
        return res;
    }

    public int countSubstrings2(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c : S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right) {
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            }
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1]) {
                Z[i]++;
            }
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v : Z) {
            ans += (v + 1) / 2;
        }
        return ans;
    }

}
