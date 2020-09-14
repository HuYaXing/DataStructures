package √Ê ‘À„∑®.TX;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/9/6 21:01
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue() - o2.getValue();
        });
        PriorityQueue<Pair> queue1 = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });
        Map<String, Integer> map = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
            queue1.add(new Pair(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < K; i++) {
            Pair pair = queue.poll();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        for (int i = 0; i < K; i++) {
            Pair pair = queue1.poll();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

}

class Pair {
    String key;
    int value;

    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

}