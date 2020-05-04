package Program;

import java.util.LinkedList;

public class Node {
    private final int id;
    private boolean visited;
    private LinkedList<Edge> edges;

    Node(int id){
        this.id = id;
        edges = new LinkedList<>();
    }
    public LinkedList<Edge> getEdges() {
        return edges;
    }
    public int getID() {
        return id;
    }
    boolean isVisited() {
        return visited;
    }

    void visit() {
        visited = true;
    }

    void unvisited() {
        visited = false;
    }

}
