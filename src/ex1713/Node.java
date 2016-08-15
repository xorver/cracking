package ex1713;

import java.util.HashMap;
import java.util.Map;

public class Node {
    boolean isTerminal;
    public Map<Character, Node> children = new HashMap<>();

    public Node(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }
}
