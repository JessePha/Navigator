package Program;

import java.util.LinkedList;

public class Printer implements IPrint {
    Graph graph;
    Printer(Graph graph){
        this.graph = graph;
    }

    @Override
    public void print() {
        for (Node node : graph.getNode()) {
            LinkedList<Edge> edges = node.getEdges();

            if (edges.isEmpty()) {
                System.out.println("Station " + node.getID() + " has no edges.");
                continue;
            }
            System.out.print("\nStation " + node.getID() + " has edges to: ");

            for (Edge edge : edges) {
                System.out.print("\nStation " + edge.getDestination().getID() + "(" + edge.getWeight() + ")Km ");
            }
            System.out.println();
        }
    }
}
