package leetcode竞赛.周赛185;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/19 10:54
 */
public class 点菜展示表 {

    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        List<String> o = new ArrayList<>();
        o.add("David");
        o.add("3");
        o.add("Ceviche");
        orders.add(o);

        o = new ArrayList<>();
        o.add("Corina");
        o.add("10");
        o.add("Beef Burrito");
        orders.add(o);

        o = new ArrayList<>();
        o.add("David");
        o.add("3");
        o.add("Fried Chicken");
        orders.add(o);

        o = new ArrayList<>();
        o.add("Carla");
        o.add("5");
        o.add("Water");
        orders.add(o);

        o = new ArrayList<>();
        o.add("Carla");
        o.add("5");
        o.add("Ceviche");
        orders.add(o);

        o = new ArrayList<>();
        o.add("Rous");
        o.add("3");
        o.add("Ceviche");
        orders.add(o);

        System.out.println(displayTable(orders));
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Map<Integer, Map<String, Integer>> mapMap = new HashMap<>();
        for (List<String> order : orders) {
            String dishName = order.get(2);
            if (!list.contains(dishName)) {
                list.add(dishName);
            }

            String tableNum = order.get(1);
            Map<String, Integer> map = mapMap.containsKey(Integer.parseInt(tableNum)) ?
                    mapMap.get(Integer.parseInt(tableNum)) : new HashMap<>();
            map.put(dishName, map.getOrDefault(dishName, 0) + 1);
            mapMap.put(Integer.parseInt(tableNum), map);
        }
        Collections.sort(list);
        List<String> dishNames = new ArrayList<>();

        dishNames.add("Table");
        dishNames.addAll(list);
        res.add(dishNames);

        Integer[] keys = mapMap.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);

        for (Integer table : keys) {
            List<String> stringList = new ArrayList<>();
            Map<String, Integer> map = mapMap.get(table);
            stringList.add(String.valueOf(table));
            for (int i = 1; i < dishNames.size(); i++) {
                if (map.containsKey(dishNames.get(i))) {
                    stringList.add(String.valueOf(map.get(dishNames.get(i))));
                } else {
                    stringList.add("0");
                }
            }
            res.add(stringList);
        }

        return res;
    }
}
