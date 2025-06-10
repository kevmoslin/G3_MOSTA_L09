package graph;

import java.util.ListLinked;

public class Vertex<E> {
    private E data;
    protected ListLinked<Edge<E>> listAdj;
}
