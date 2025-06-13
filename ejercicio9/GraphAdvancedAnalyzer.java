package ejercicio9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GraphAdvancedAnalyzer<E> {
    private GraphLink<E> graph;

    public GraphAdvancedAnalyzer(GraphLink<E> graph) {
        this.graph = graph;
    }

    public boolean isIsomorphic(GraphLink<E> other) {
        if (this.graph.listVertex.size() != other.listVertex.size()) return false;
        if (this.graph.countEdges() != other.countEdges()) return false;
        ArrayList<Integer> degreesThis = new ArrayList<>();
        ArrayList<Integer> degreesOther = new ArrayList<>();

        for (Vertex<E> v : this.graph.listVertex) {
            degreesThis.add(v.listAdj.size());
        }
        for (Vertex<E> v : other.listVertex) {
            degreesOther.add(v.listAdj.size());
        }
        Collections.sort(degreesThis);
        Collections.sort(degreesOther);
        return degreesThis.equals(degreesOther);
    }

    public boolean isPlanar() {
        int v = graph.listVertex.size();
        int e = graph.countEdges();
        return e <= 3 * v - 6;
    }

    public boolean isConexo() {
        if (graph.listVertex.isEmpty()) return false;
        Set<Vertex<E>> visited = new HashSet<>();
        dfs(graph.listVertex.get(0), visited);
        return visited.size() == graph.listVertex.size();
    }

    private void dfs(Vertex<E> vertex, Set<Vertex<E>> visited) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        for (Edge<E> edge : vertex.listAdj) {
            Vertex<E> dest = edge.getRefDest();
            dfs(dest, visited);
        }
    }

    public boolean isSelfComplementary() {
        int n = graph.listVertex.size();
        int expectedEdges = (n * (n - 1)) / 4;
        return graph.countEdges() == expectedEdges;
    }
}
