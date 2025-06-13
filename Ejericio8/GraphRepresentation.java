package Ejericio8;

import java.util.HashMap;
import java.util.Map;

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

    public String adjacencyListRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<E> v : graph.listVertex) {
            sb.append(v.getData()).append(": ");
            for (Edge<E> edge : v.listAdj) {
                sb.append(edge.getRefDest().getData()).append(", ");
            }
            if (!v.listAdj.isEmpty()) {
                sb.setLength(sb.length() - 2); // Quitar ", " final
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String adjacencyMatrixRepresentation() {
        int size = graph.listVertex.size();
        int[][] matrix = new int[size][size];
        Map<E, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            indexMap.put(graph.listVertex.get(i).getData(), i);
        }

        for (Vertex<E> v : graph.listVertex) {
            int i = indexMap.get(v.getData());
            for (Edge<E> edge : v.listAdj) {
                int j = indexMap.get(edge.getRefDest().getData());
                matrix[i][j] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Matriz de Adyacencia:\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
