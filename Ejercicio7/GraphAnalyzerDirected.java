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

    public int getOutDegree(E data) {
        Vertex<E> vertex = graph.getVertex(data); // Usamos getVertex
        if (vertex == null) return -1;
        return vertex.listAdj.size();
    }

    public boolean isDirectedPath() {
        int startNodes = 0, endNodes = 0;
        for (Vertex<E> v : graph.listVertex) {
            int out = getOutDegree(v.getData());
            int in = getInDegree(v.getData());
            if (out - in == 1) startNodes++;
            else if (in - out == 1) endNodes++;
            else if (in != out) return false;
        }
        return (startNodes == 1 && endNodes == 1) || (startNodes == 0 && endNodes == 0);
    }

    public boolean isDirectedCycle() {
        for (Vertex<E> v : graph.listVertex) {
            if (getInDegree(v.getData()) != getOutDegree(v.getData())) return false;
        }
        return true;
    }
}
