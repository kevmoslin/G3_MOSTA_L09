package Ejericio8;

import java.util.*;

public class GraphListEdge<V, E> {
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V info){
        if (!searchVertex(info)) {
            VertexObj<V, E> newVertex = new VertexObj<>(info, secVertex.size());
            secVertex.add(newVertex);
        }
    }

    public void insertEdge(V v1, V v2){
        if (searchEdge(v1, v2)) {
            return;
        }

        VertexObj<V, E> vert1 = getVertex(v1);
        VertexObj<V, E> vert2 = getVertex(v2);

        if (vert1 != null && vert2 != null) {
            EdgeObj<V, E> newEdge = new EdgeObj<>(vert1, vert2, null, secEdge.size());
            secEdge.add(newEdge);
        }
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
        VertexObj<V, E> start = getVertex(startInfo);
        if (start == null) {
            return;
        }

        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.println(current.info);

            for (EdgeObj<V, E> edge : secEdge){
                VertexObj<V, E> neighbor = null;
                if (edge.endVertex1.equals(current)) {
                    neighbor = edge.endVertex2;
                } else if (edge.endVertex2.equals(current)) {
                    neighbor = edge.endVertex1;
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    private VertexObj<V, E> getVertex(V info){
        for (VertexObj<V, E> v : secVertex){
            if (v.info.equals(info)) {
                return v;
            }
        }
        return null;
    }

}
