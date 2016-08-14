package ex1707;

import ex1625.Cache;

import java.util.*;

public class Ex1707 {


    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>(Arrays.asList(
                new Node("John", 15),
                new Node("Jon", 12),
                new Node("Chris", 13),
                new Node("Kris", 4),
                new Node("Christopher", 19)
        ));

        nodes.get(0).addSynonym(nodes.get(1));
        nodes.get(1).addSynonym(nodes.get(0));
        nodes.get(2).addSynonym(nodes.get(3));
        nodes.get(3).addSynonym(nodes.get(2));
        nodes.get(4).addSynonym(nodes.get(2));
        nodes.get(2).addSynonym(nodes.get(4));

        System.out.println(countFrequencies(nodes));
    }

    private static Collection<Node> countFrequencies(Collection<Node> nodes) {
        Collection<Node> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        for (Node n : nodes)
            if (!n.visited){
                n.visited=true;
                queue.add(n);
                int sum =0;
                while(!queue.isEmpty()){
                    Node actual = queue.poll();
                    actual.visited = true;
                    sum += actual.count;
                    actual.synonyms.stream().filter(nn -> !nn.visited).forEach(nn -> {
                        nn.visited = true;
                        queue.add(nn);
                    });
                }
                result.add(new Node(n.name, sum));
            }
        return result;
    }
}
