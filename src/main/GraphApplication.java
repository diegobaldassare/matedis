package main;

import java.util.*;

/**
 * Author: Froschauer Brian, Baldassare diego, De Luca Bruno
 * Date: 11/08/2018
 */
public class GraphApplication<T> {

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