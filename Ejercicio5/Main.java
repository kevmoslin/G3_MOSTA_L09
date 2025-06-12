package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();

        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertEdge("A", "B");
        grafo.insertEdge("B", "C");
    }
}
