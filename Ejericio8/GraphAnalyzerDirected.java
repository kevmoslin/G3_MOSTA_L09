package Ejericio8;

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

    public boolean isDirectedWheel() {
        int n = graph.listVertex.size();
        for (Vertex<E> center : graph.listVertex) {
            int out = getOutDegree(center.getData());
            int in = getInDegree(center.getData());
            if (out == n - 1 && in == 0) {
                int cycleCount = 0;
                for (Vertex<E> other : graph.listVertex) {
                    if (!other.equals(center)) {
                        int degOut = getOutDegree(other.getData());
                        int degIn = getInDegree(other.getData());
                        if (degIn == 1 && degOut == 1) cycleCount++;
                    }
                }
                return cycleCount == n - 1;
            }
        }
        return false;
    }

    public String identifyGraphTypeDirected() {
        if (isDirectedCycle()) return "Ciclo dirigido";
        if (isDirectedPath()) return "Camino dirigido";
        if (isDirectedWheel()) return "Rueda dirigida";
        return "Tipo desconocido";
    }
}
