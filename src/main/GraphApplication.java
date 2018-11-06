package main;

import java.util.*;

/**
 * Author: brianfroschauer
 * Date: 06/11/2018
 */
public class GraphApplication<T> {

    /**
     * Permite cargar datos (lista de vertices y de aristas) de tipo T a un grafo
     * @param graph al que se agregan los datos
     * @param edges a agregar al grafo
     * @param vertex a agregar al grafo
     */
    public void chargeData(Graph<T> graph, List<Edge<T>> edges, List<T> vertex) {
        vertex.forEach(graph::addVertex);
        edges.forEach(graph::addEdge);
    }

    /**
     * Crea un grafo de manera aleatoria
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
     * @param vertexes a conectar
     * @return una lista de vértices de tipo integer
     */
    private static List<Edge<Integer>> connectVertexesRandom(List<Integer> vertexes) {
        final List<Edge<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < vertexes.size(); i++) {
            for (int j = i + 1; j < vertexes.size()-1; j++) {
                final int probability = new Random().nextInt(2);
                if (probability == 0) edges.add(new Edge<>(vertexes.get(i), vertexes.get(j)));
            }
        }
        return edges;
    }

    public static List<Integer> BFS(Graph<Integer> graph) {
        // Mark all the vertices as not visited (By default set as false)
        final List<Integer> path = new ArrayList<>();
        boolean visited[] = new boolean[graph.order()];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        if (graph.order() != 0) {
            visited[graph.getVertex(0)] = true;
            queue.add(graph.getVertex(0));
        }

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            Integer vertex = queue.poll();
            path.add(vertex);

            // Get all adjacent vertices of the dequeued vertex
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Edge<Integer> edge : graph.getAdjList(vertex)) {
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

   private static List<Integer> DFSUtil(int vertex, boolean[] visited, Graph<Integer> graph, List<Integer> path) {

        // Mark the current node as visited and print it
        visited[vertex] = true;
        path.add(vertex);
        // Recur for all the vertices adjacent to this vertex

       List<Edge<Integer>> adjList = graph.getAdjList(vertex);

       for (Edge<Integer> edge : adjList) {
           final int v1 = edge.getVertex1();
           if (!visited[v1]) DFSUtil(v1, visited, graph, path);

           final int v2 = edge.getVertex2();
           if (!visited[v2]) DFSUtil(v2, visited, graph, path);
       }
       return path;
    }

    public static List<Integer> DFS(Graph<Integer> graph) {
        // Mark all the vertices as not visited(set as false by default in java)
        if (graph.order() != 0) {
            final List<Integer> path = new ArrayList<>();
            final Integer vertex = graph.getVertex(0);
            boolean visited[] = new boolean[graph.order()];
            // Call the recursive helper function to print DFS
            return DFSUtil(vertex, visited, graph, path);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // create random graph
        Graph<Integer> graph = randomGraph();
        graph.print();

        System.out.println();

        // Print BFS
        List<Integer> bfs = BFS(graph);
        System.out.println("BFS Path: " + bfs);

        // Print DFS
        List<Integer> dfs = DFS(graph);
        System.out.println("DFS Path: " + dfs);

    }
}