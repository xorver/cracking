package ex1625;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private int capacity;
    private Map<Integer, Value> map = new HashMap<>();
    private Map<Integer, Integer> seqMap = new HashMap<>();
    int seq;
    int lowestSeq;

    public Cache(int capacity) {
        this.capacity = capacity;
    }

    public String get(int key) {
        Value value = map.get(key);
        if(value != null) {
            seq++;
            updateSeq(key, value, seq);
            return value.string;
        }
        return null;
    }

    public String put(int key, String string) {
        if(map.containsKey(key)) {
            Value value = map.get(key);
            seq++;
            updateSeq(key, value, seq);
            String oldString = value.string;
            value.string = string;
            normalize();
            return oldString;
        } else {
            seq++;
            Value value = new Value(string, seq);
            map.put(key, value);
            seqMap.put(seq, key);
            normalize();
            return null;
        }
    }

    private void normalize() {
        for(;lowestSeq<seq && map.size() > capacity; lowestSeq++) {
            Integer key = seqMap.get(lowestSeq);
            if(key != null) {
                map.remove(key);
                seqMap.remove(lowestSeq);
            }
        }
    }

    private void updateSeq(Integer key, Value value, int newSeq) {
        seqMap.remove(value.seq);
        value.seq = newSeq;
        seqMap.put(newSeq, key);
    }

    @Override
    public String toString() {
        return "Cache{" +
                "map=" + map +
                '}';
    }

    private class Value
    {
        public String string;
        public int seq;

        @Override
        public String toString() {
            return "Value{" +
                    "string='" + string + '\'' +
                    ", seq=" + seq +
                    '}';
        }

        public Value(String string, int seq) {
            this.string = string;
            this.seq = seq;

        }
    }

}
