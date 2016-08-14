package ex1707;

import java.util.ArrayList;
import java.util.Collection;

public class Node {
    public String name;
    public int count;
    public Collection<Node> synonyms;
    public boolean visited;

    public Node(String name, int count) {
        this.name = name;
        this.count = count;
        this.synonyms = new ArrayList<>();
    }

    public void addSynonym(Node node) {
        synonyms.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
