package main;

import java.util.*;

/**
 * Author: brianfroschauer
 * Date: 06/11/2018
 */
public class GraphApplication<T extends Comparable> {

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

    public List<T> flatSearch(Graph<T> graph) {
        final List<T> path = new ArrayList<>();
        for (int i = 0; i < graph.order(); i++) {
            path.add(graph.getVertex(i)); // procesar = imprimir recorrido
        }
        return path;
    }

    public List<Integer> dfs(Graph<Integer> graph, int start) {
        // Mark all the vertices as not visited (By default set as false)
        final List<Integer> path = new ArrayList<>();
        boolean visited[] = new boolean[graph.order()];

        // Create a queue for BFS
        Stack<Integer> stack = new Stack<>();

        // Mark the current node as visited and enqueue it
        if (graph.order() != 0) {
            visited[graph.getVertex(start)] = true;
            stack.add(graph.getVertex(start));
        }

        while (stack.size() != 0) {

            // Dequeue a vertex from queue and print it
            Integer vertex = stack.pop();
            path.add(vertex);

            // Get all adjacent vertices of the dequeued vertex
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (Edge<Integer> edge : graph.getAdjacentEdges(vertex)) {
                final int v1 = edge.getVertex1();
                if (!visited[v1]) {
                    visited[v1] = true;
                    stack.add(v1);
                }

                final int v2 = edge.getVertex2();
                if (!visited[v2]) {
                    visited[v2] = true;
                    stack.add(v2);
                }
            }
        }
        return path;
    }

    public List<Integer> bfs(Graph<Integer> graph, int start) {
        // Mark all the vertices as not visited
        final List<Integer> path = new ArrayList<>();
        boolean visited[] = new boolean[graph.order()];

        // Create a queue for BFS
        final LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it (if graph has vertex)
        if (graph.order() != 0) {
            visited[graph.getVertex(start)] = true;
            queue.add(graph.getVertex(start));
        }

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            Integer vertex = queue.poll();
            path.add(vertex);

            // Get all adjacent vertices of the dequeued vertex
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (Edge<Integer> edge : graph.getAdjacentEdges(vertex)) {
                final int v1 = edge.getVertex1();
                if (!visited[v1]) {
                    visited[v1] = true;
                    queue.add(v1);
                }

                final int v2 = edge.getVertex2();
                if (!visited[v2]) {
                    visited[v2] = true;
                    queue.add(v2);
                }
            }
        }
        return path;
    }
}