package Ejercicio5;

public class GraphAnalyzer<E> {
    private GraphLink<E> graph;

    public GraphAnalyzer(GraphLink<E> graph) {
        this.graph = graph;
    }

    public int grado(E vertexData){
        for (Vertex<E> v : graph.listVertex){
            if (v.getData().equals(vertexData)) {
                return v.listAdj.size();
            }
        }
        return -1;
    }

    public boolean camino(){
        int contadorGrado = 0;
        for (Vertex<E> v : graph.listVertex){
            int grado = v.listAdj.size();
            if (grado == 1) {
                contadorGrado++;
            } else if (grado != 2) {
                return false;
            }
        }
        return contadorGrado == 2;
    }

    public boolean ciclo(){

    }

    public boolean rueda(){

    }

    public boolean completo(){

    }
}
