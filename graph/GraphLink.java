package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import listlinked.ListLinked;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data){
        if (!searchVertex(data)) {
            listVertex.add(new Vertex<E>(data));
        }
    }

    public void insertEdge(E verOri, E verDes){
        Vertex<E> vOri = null;
        Vertex<E> vDes = null;

        for (Vertex<E> v : listVertex) {
            if (v.getData().equals(verOri)) {
                vOri = v;
            }
            if (v.getData().equals(verDes)) {
                vDes = v;
            }
        }

        if (vOri == null || vDes == null) return;

        if (!vOri.listAdj.contains(new Edge<E>(vDes))) {
            vOri.listAdj.add(new Edge<E>(vDes));
        }

        if (!vDes.listAdj.contains(new Edge<E>(vOri))) {
            vDes.listAdj.add(new Edge<E>(vOri));
        }
    }

    public boolean searchVertex(E data){
        for (Vertex<E> v : listVertex){
            if (v.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchEdge(E v, E z){
        Vertex<E> v1 = null;
        Vertex<E> v2 = null;

        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(v)){
                v1 = vertex;
            }
            if (vertex.getData().equals(z)) {
                v2 = vertex;
            }
        }

        if (v1 == null || v2 == null) return false;

        return v1.listAdj.contains(new Edge<E>(v2));
    }

    public void removeVertex(E data){
        Vertex<E> v = null;

        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                v = vertex;
                break;
            }
        }

        if (v == null) return;

        for (Vertex<E> u : listVertex) {
            u.listAdj.remove(new Edge<E>(v));
        }

        listVertex.remove(v);
    }

    public void removeEdge(E v, E z){
        Vertex<E> v1 = null;
        Vertex<E> v2 = null;

        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(v)) v1 = vertex;
            if (vertex.getData().equals(z)) v2 = vertex;
        }

        if (v1 == null || v2 == null) return;

        v1.listAdj.remove(new Edge<E>(v2));
        v2.listAdj.remove(new Edge<E>(v1));
    }

    public void dfs(E start){
        Vertex<E> origin = null;

        for (Vertex<E> v : listVertex){
            if (v.getData().equals(start)) {
                origin = v;
                break;
            }
        }

        if (origin == null) {
            return;
        }

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsRecursive(origin, visited); 
    }
    
    private void dfsRecursive(Vertex<E> current, ListLinked<Vertex<E>> visited){
        visited.add(current);
        System.out.println(current.getData() + " ");

        for (Edge<E> edge : current.listAdj){
            Vertex<E> neighbor = edge.getRefDest();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void bfs(E start){
        Vertex<E> origin = searchVertex(start);
        if (origin == null) {
            return;
        }

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        visited.add(origin);
        queue.offer(origin);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.println(current.getData() + " ");

            for (Edge<E> edge : current.listAdj){
                Vertex<E> neighbor = edge.getRefDest();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    public ArrayList<E> bfsPath(E start, E end){

    }

    public void insertEdgeWeight(E v, E z, int w){

    }

    public ArrayList<E> shortPath(E start, E end){

    }

    public boolean isConexo(){

    }

    public Stack<E> dijkstra(E start, E end){

    }

    public String toString(){
        return this.listVertex.toString();
    }
}
