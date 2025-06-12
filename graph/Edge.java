package graph;

public class Edge<E> {
    private Vertex<E> refDest;
    private int weigth;

    public Vertex<E> getRefDest(){
        return this.refDest;
    }

    public Edge(Vertex<E> refDest){
        this(refDest,-1);
    }

    public Edge(Vertex<E> refDest, int weigth){
        this.refDest = refDest;
        this.weigth = weigth;
    }

    public boolean equals(Object o){
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>)o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }

    public String toString(){
        if (this.weigth > -1) return refDest.getData() + " [" + this.weigth + "], ";
        else return refDest.getData() + " ,";
    }
}
