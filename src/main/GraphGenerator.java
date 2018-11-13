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

    public static Graph<Character> exampleA() {
        final Graph<Character> example = new UndirectedGraph<>(7);
        example.addVertex('A');
        example.addVertex('B');
        example.addVertex('C');
        example.addVertex('D');
        example.addVertex('E');
        example.addVertex('F');
        example.addVertex('G');
        example.addEdge(new Edge<Character>('A', 'B'));
        example.addEdge(new Edge<Character>('A', 'D'));
        example.addEdge(new Edge<Character>('B', 'E'));
        example.addEdge(new Edge<Character>('C', 'D'));
        example.addEdge(new Edge<Character>('D', 'F'));
        example.addEdge(new Edge<Character>('D', 'G'));
        example.addEdge(new Edge<Character>('E', 'F'));
        example.addEdge(new Edge<Character>('E', 'G'));
        return example;
    }
}
