package ex1712;

import utils.Pair;

public class Ex1712 {

    public static Pair<BiNode, BiNode> convert(BiNode node) {
        if(node == null)
            return null;

        Pair<BiNode,BiNode> begin = convert(node.node1);
        Pair<BiNode,BiNode> end = convert(node.node2);
        Pair<BiNode,BiNode> result = new Pair<>(node, node);
        node.node1 = null;
        node.node2 = null;
        if(begin != null){
            node.node1 = begin.second;
            result.first = begin.first;
            begin.second.node2 = node;
        }
        if(end != null){
            node.node2 = end.first;
            result.second = end.second;
            end.first.node1 = node;
        }

        return result;
    }

    public static void main(String[] args) {
        BiNode root = new BiNode(
                new BiNode(
                        new BiNode(null,null,1),
                        new BiNode(null,null,4),
                        3
                ),
                new BiNode(
                        new BiNode(null,null,6),
                        null,
                        8
                ),
                5
        );
        BiNode it = convert(root).first;
        while(it!=null){
            System.out.println(it);
            it = it.node2;
        }
    }

}
