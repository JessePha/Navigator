package Program;
public class Navigator {
    private Graph graph = new Graph(true, 10);
    private Dijkstra dijkstra = new Dijkstra(graph);
    private Printer printer = new Printer(graph);

    public void start() {
        graph.generateNode();
        graph.generateGraph();
        printer.print();
        dijkstra.DijkstraShortestPath(graph.getNodes()[0], graph.getNodes()[9]);
    }
}
