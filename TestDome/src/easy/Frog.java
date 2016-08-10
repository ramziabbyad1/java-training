package easy;

import java.util.HashMap;
import java.util.Map;

public class Frog {
    private static Map<Integer, Integer> cache = new HashMap<>();
    public static int numberOfWays(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        else {
            int ways = numberOfWays(n-1) + numberOfWays(n-2);
            cache.put(n, ways);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(4));
    }
}
