package graph2;

public class Main {
    public static void main(String[] args) {
        GraphListEdge<String, Integer> grafo = new GraphListEdge<>();

        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");

        System.out.println("¿Existe el vertice A? " + grafo.searchVertex("A"));
        System.out.println("¿Existe el vertice E? " + grafo.searchVertex("E"));

        System.out.println("¿Existe el arista A-B? " + grafo.searchEdge("A", "B"));
        System.out.println("¿Existe el arista C-D? " + grafo.searchEdge("C", "D"));

        System.out.println("Recorrido BFS desde A: ");
        grafo.bfs("A");
    }
}
