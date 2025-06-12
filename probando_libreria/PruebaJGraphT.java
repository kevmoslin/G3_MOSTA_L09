package probando_libreria;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class PruebaJGraphT {
    public static void main(String[] args) {
        Graph<String, DefaultWeightedEdge> mapaRutas = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        mapaRutas.addVertex("Lima");
        mapaRutas.addVertex("Arequipa");
        mapaRutas.addVertex("Ancash");
        mapaRutas.addVertex("Trujillo");

        mapaRutas.setEdgeWeight(mapaRutas.addEdge("Lima", "Ancash"), 1100);
        mapaRutas.setEdgeWeight(mapaRutas.addEdge("Lima", "Arequipa"), 1000);
        mapaRutas.setEdgeWeight(mapaRutas.addEdge("Arequipa", "Ancash"), 500);
        mapaRutas.setEdgeWeight(mapaRutas.addEdge("Trujillo", "Lima"), 560);

        
    }
}
