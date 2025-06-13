package Ejericio8;

public class GraphRepresentation<E> {
    private GraphLink<E> graph;

    public GraphRepresentation(GraphLink<E> graph) {
        this.graph = graph;
    }

    public String formalRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices:\n");
        for (Vertex<E> v : graph.listVertex) {
            sb.append(v.getData()).append("\n");
        }
        sb.append("Aristas:\n");
        for (Vertex<E> v : graph.listVertex) {
            for (Edge<E> edge : v.listAdj) {
                sb.append(v.getData()).append(" -> ").append(edge.getRefDest().getData()).append("\n");
            }
        }
        return sb.toString();
    }
}
