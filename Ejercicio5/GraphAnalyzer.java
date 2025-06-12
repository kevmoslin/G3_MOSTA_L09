package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

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
        for (Vertex<E> v : graph.listVertex){
            if (v.listAdj.size() != 2) {
                return false;
            }
        }
        return true;
    }

    public boolean rueda(){
        int n = graph.listVertex.size();
        int centerCount = 0;
        int contadorRuedas = 0;

        for (Vertex<E> v : graph.listVertex){
            int grado = v.listAdj.size();
            if (grado == n -1) {
                centerCount++;
            } else if (grado == 3) {
                contadorRuedas++;
            } else{
                return false;
            }
        }

        return centerCount == 1 && contadorRuedas == n-1;
    }

    public boolean completo(){
        int n = graph.listVertex.size();
        for (Vertex<E> v : graph.listVertex){
            if (v.listAdj.size() != n - 1) {
                return false;
            }
        }
        return true;
    }

    public String identificandoGrafo(){
        if (completo()) return "Completo (K" + graph.listVertex.size() + ")";
        if (rueda())    return "Rueda (W" + graph.listVertex.size() + ")";
        if (ciclo())    return "Ciclo (C" + graph.listVertex.size() + ")";
        if (camino())     return "Camino (P" + graph.listVertex.size() + ")";
        return "Desconocido";
    }

    public String representacionFormal(){
        StringBuilder sb = new StringBuilder();
        sb.append("V = {");
        for (int i = 0; i < graph.listVertex.size(); i++) {
            sb.append(graph.listVertex.get(i).getData());
            if (i < graph.listVertex.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}\nE = {");
        List<String> aristas = new ArrayList<>();
        for (Vertex<E> v : graph.listVertex) {
            for (Edge<E> e : v.listAdj) {
                Vertex<E> dest = e.getRefDest();
                String a = "{" + v.getData() + "," + dest.getData() + "}";
                String aInversa = "{" + dest.getData() + "," + v.getData() + "}";
                if (!aristas.contains(aInversa)) {
                    aristas.add(a);
                }
            }
        }
        sb.append(String.join(", ", aristas)).append("}");
        return sb.toString();
    }

    public String representacionListaAdyacencia(){
        StringBuilder sb = new StringBuilder();
        for (Vertex<E> v : graph.listVertex) {
            sb.append(v.getData()).append(": ");
            List<String> adyacentes = new ArrayList<>();
            for (Edge<E> e : v.listAdj) {
                adyacentes.add(e.getRefDest().getData().toString());
            }
            sb.append(String.join(", ", adyacentes)).append("\n");
        }
        return sb.toString();
    }

    public String representacionMatrizAdyacencia(){

    }
}
