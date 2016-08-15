package ex1712;

public class BiNode {
    public BiNode node1;
    public BiNode node2;
    public int data;

    public BiNode(BiNode node1, BiNode node2, int data) {
        this.node1 = node1;
        this.node2 = node2;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BiNode{" +data+'}';
    }
}
