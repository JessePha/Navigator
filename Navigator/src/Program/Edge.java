package Program;

public class Edge implements Comparable<Edge> {
    Node source;
    private Node destination;
    private double weight;

    Edge(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Node getDestination() {
        return destination;
    }

    @Override
    public int compareTo(Edge edge) {
        if (this.weight > edge.weight) {
            return 1;
        }
        else return -1;
    }
}
