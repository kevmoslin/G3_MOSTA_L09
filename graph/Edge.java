package graph;

public class Edge<E> {
    private Vertex<E> refDest;
    private int weigth;

    public Edge(Vertex<E> refDest){
        this(refDest,-1);
    }

    public Edge(Vertex<E> refDest, int weigth){
        this.refDest = refDest;
        this.weigth = weigth;
    }

    
}
