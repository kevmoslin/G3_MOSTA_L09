package Ejercicio7;

import graph.*;
import java.util.*;


public class GraphAnalyzerDirected<E> {
    private GraphLink<E> graph;

    public GraphAnalyzerDirected(GraphLink<E> graph) {
        this.graph = graph;
    }

    public int getInDegree(E data) {
        Vertex<E> target = graph.getVertex(data);
        if (target == null) return -1;
        int inDegree = 0;
        for (Vertex<E> vertex : graph.listVertex) {
            for (Edge<E> edge : vertex.listAdj) {
                if (edge.getRefDest().equals(target)) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }
}
