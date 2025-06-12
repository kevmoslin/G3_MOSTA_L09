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
        return getVertex(info) != null;
    }

    public boolean searchEdge(V v1, V v2){
        VertexObj<V, E> vert1 = getVertex(v1);
        VertexObj<V, E> vert2 = getVertex(v2);

        if (vert1 == null || vert2 == null) {
            return false;
        }

        for (EdgeObj<V, E> edge : secEdge){
            if ((edge.endVertex1.equals(vert1) && edge.endVertex2.equals(vert2)) || (edge.endVertex1.equals(vert2)) && (edge.endVertex2.equals(vert1))) {
                return true;
            }
        }

        return false;
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
