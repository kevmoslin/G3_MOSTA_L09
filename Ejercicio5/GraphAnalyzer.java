package Ejercicio5;

public class GraphAnalyzer<E> {
    private GraphLink<E> graph;

    public GraphAnalyzer(GraphLink<E> graph) {
        this.graph = graph;
    }

    public int grado(E vertexData){
        for (Vertex<E> v : graph.listVertex){
            if (v.getData().equals(vertexData)) {
                return v.listAdj.size();
            }
        }
        return -1;
    }
}
