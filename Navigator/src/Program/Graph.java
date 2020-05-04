package Program;

import java.util.*;

public class Graph {
    //  Each node maps to a list of all his neighbors
    private Set<Node> node;
    private boolean directed;
    private Node[] nodes;

     Graph(boolean directed, int n) {
        this.directed = directed;
        nodes = new Node[n];
        node = new HashSet<>();
    }

    void generateNode() {
        for (int id = 0; id < nodes.length; id++) {
            nodes[id] = new Node(id);
            nodes[id].unvisited();
        }
        node.addAll(Arrays.asList(nodes));
    }

    void generateGraph() {
        int twoNode = 0;
        while (twoNode < 2) {
            for (Node node : nodes) {
                Node end = nodes[randomNode(nodes.length)];
                while (hasEdge(node, end) || node.equals(end)) {
                    end = nodes[randomNode(nodes.length)];
                    checkVisitedNode(node, end);
                }
                addEdge(node, end, (int) (Math.random() * 10 + 1));
                end.visit();
            }
            twoNode++;
            resetVisitedNode();
        }
    }

    public void addEdge(Node source, Node destination, double weight) {
        // Since we're using a Set, it will only add the nodes
        // if they don't already exist in our graph
        node.add(source);
        node.add(destination);

        // We're using addEdgeHelper to make sure we don't have duplicate edges
        addEdgeHelper(source, destination, weight);
        if (!directed && source != destination) {
            addEdgeHelper(destination, source, weight);
        }
    }

    private void addEdgeHelper(Node a, Node b, double weight) {
        // Go through all the edges and see whether that edge has
        // already been added
        for (Edge edge : a.getEdges()) {
            if (edge.source == a && edge.getDestination() == b) {
                // Update the value in case it's a different one now
                edge.setWeight(weight);
                return;
            }
        }
        // If it hasn't been added already (we haven't returned
        // from the for loop), add the edge
        a.getEdges().add(new Edge(a, b, weight));
    }

    public boolean hasEdge(Node source, Node destination) {
        LinkedList<Edge> edges = source.getEdges();
        for (Edge edge : edges) {
            // Again relying on the fact that all classes share the
            // exact same NodeWeighted object
            if (edge.getDestination() == destination) {
                return true;
            }
        }
        return false;
    }

    int randomNode(int a) {
        Random random = new Random();
        int b = random.nextInt(a);
        while (nodes[b].isVisited()) {
            b = random.nextInt(a);
            if (!nodes[b].isVisited()) {
                break;
            }
        }
        return b;
    }

    void checkVisitedNode(Node a, Node b) {
        if (!nodes[nodes.length - 1].isVisited()) {
            nodes[random()].unvisited();
        } else if (hasEdge(a, b))
            nodes[random()].unvisited();
    }

    //
    int random() {
        return (int) (Math.random() * nodes.length);
    }

    //
//
    void resetVisitedNode() {
        for (Node node : nodes) {
            node.unvisited();
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public Set<Node> getNode() {
        return node;
    }
}
