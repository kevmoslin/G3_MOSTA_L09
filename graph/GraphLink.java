package graph;

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

    }

    public void removeEdge(E v, E z){

    }

    public void dfs(E start){

    }

    public String toString(){
        return this.listVertex.toString();
    }
}
