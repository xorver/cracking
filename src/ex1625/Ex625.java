package ex1625;

public class Ex625 {


    public static void main(String[] args) {
        Cache cache = new Cache(5);
        cache.put(0, "a");
        cache.put(1, "b");
        cache.put(2, "c");
        cache.put(3, "d");
        cache.put(4, "e");
        cache.get(0);
        cache.get(1);
        cache.put(6, "f");
        System.out.println(cache);
    }
}
