package graph;

import java.util.*;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V info){

    }

    public void insertEdge(V v1, V v2){

    }

    public boolean searchVertex(V info){

    }

    public boolean searchEdge(V v1, V v2){

    }

    public void bfs(V startInfo){

    }

    private VertexObj<V, E> getVertex(V info){
        for (VertexObj<V, E> v : secVertex){
            if (v.info.equals(info)) {
                return v;
            }
        }
    }

}
