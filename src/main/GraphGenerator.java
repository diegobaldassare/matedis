package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Diego Baldassare on 2018-11-13.
 */
public class GraphGenerator<T> {

    /**
     * Permite cargar datos (lista de vertices y de aristas) de tipo T a un grafo
     *
     * @param graph  al que se agregan los datos
     * @param edges  a agregar al grafo
     * @param vertex a agregar al grafo
     */
    public void chargeData(Graph<T> graph, List<Edge<T>> edges, List<T> vertex) {
        vertex.forEach(graph::addVertex);
        edges.forEach(graph::addEdge);
    }

    /**
     * Crea un grafo de manera aleatoria
     *
     * @return un grafo aleatorio
     */
    public static Graph<Integer> randomGraph() {
        final int order = new Random().nextInt(10);
        final Graph<Integer> graph = new UndirectedGraph<>(order);

        final List<Integer> randomVertexes = createRandomVertex(order);
        final List<Edge<Integer>> randomEdges = connectVertexesRandom(randomVertexes);
        randomVertexes.forEach(graph::addVertex);
        randomEdges.forEach(graph::addEdge);
        return graph;
    }

    /**
     * Permite crear una lista de vertices de tipo integer de forma aleatoria.
     *
     * @param amount de vertices
     * @return una lista de vertices
     */
    private static List<Integer> createRandomVertex(int amount) {
        final List<Integer> vertexes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            vertexes.add(i);
        }
        return vertexes;
    }

    /**
     * Permite conectar (crear aristas) dado una lista de vértices.
     *
     * @param vertexes a conectar
     * @return una lista de vértices de tipo integer
     */
    private static List<Edge<Integer>> connectVertexesRandom(List<Integer> vertexes) {
        final List<Edge<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < vertexes.size(); i++) {
            for (int j = i + 1; j < vertexes.size() - 1; j++) {
                final int probability = new Random().nextInt(2);
                if (probability == 0) edges.add(new Edge<>(vertexes.get(i), vertexes.get(j)));
            }
        }
        return edges;
    }

    public static Graph<Integer> exampleA() {
        final Graph<Integer> example = new UndirectedGraph<>(7);
        example.addVertex(0);
        example.addVertex(1);
        example.addVertex(2);
        example.addVertex(3);
        example.addVertex(4);
        example.addVertex(5);
        example.addVertex(6);
        example.addEdge(new Edge<>(0, 1));
        example.addEdge(new Edge<>(0, 2));
        example.addEdge(new Edge<>(1, 3));
        example.addEdge(new Edge<>(1, 4));
        example.addEdge(new Edge<>(2, 5));
        example.addEdge(new Edge<>(2, 6));
        return example;
    }

    public static Graph<Integer> exampleB() {
        final Graph<Integer> example = new UndirectedGraph<>(7);
        example.addVertex(0);
        example.addVertex(1);
        example.addVertex(2);
        example.addVertex(3);
        example.addEdge(new Edge<>(0, 1));
        example.addEdge(new Edge<>(0, 2));
        example.addEdge(new Edge<>(1, 2));
        example.addEdge(new Edge<>(2, 3));
        return example;
    }
}
