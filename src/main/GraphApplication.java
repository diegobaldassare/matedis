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

        // Marcamos el nodo como visitado y lo agregamos a la cola (si es que el grado tiene vertices)
        if (graph.order() != 0) {
            visited[graph.getVertex(start)] = true;
            queue.add(graph.getVertex(start));
        }

        while (queue.size() != 0) {

            // Desencolamos el primer vertice y lo agregamos al path
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

    public void fleury(Graph<Integer> graph, int start) {

        // Recur for all the vertices adjacent to this vertex

        for (int i = 0; i < graph.getAdjacentList(start).size(); i++) {
            Integer v = graph.getAdjacentList(start).get(i);
            // If edge u-v is a valid next edge
            if (isValidNextEdge(graph, start, v)) {
                System.out.print(start + "-" + v + " ");

                // This edge is used so remove it now
                graph.removeEdge(new Edge<>(start, v));
                fleury(graph, v);
            }
        }
    }

    private boolean isValidNextEdge(Graph<Integer> graph, Integer u, Integer v) {
        // The edge u-v is valid in one of the
        // following two cases:

        // 1) If v is the only adjacent vertex of u
        // ie size of adjacent vertex list is 1
        if (graph.getAdjacentList(u).size() == 1) {
            return true;
        }

        // 2) If there are multiple adjacents, then
        // u-v is not a bridge Do following steps
        // to check if u-v is a bridge
        // 2.a) count of vertices reachable from u
        boolean[] isVisited = new boolean[graph.order()];
        int count1 = dfsCount(graph, u, isVisited);

        // 2.b) Remove edge (u, v) and after removing
        //  the edge, count vertices reachable from u
        graph.removeEdge(new Edge<>(u, v));
        isVisited = new boolean[graph.order()];
        int count2 = dfsCount(graph, u, isVisited);

        // 2.c) Add the edge back to the graph
        graph.addEdge(new Edge<>(u, v));
        return count1 <= count2;
    }

    private int dfsCount(Graph<Integer> graph, Integer v, boolean[] isVisited) {
        // Mark the current node as visited
        isVisited[v] = true;
        int count = 1;
        // Recur for all vertices adjacent to this vertex
        for (int adj : graph.getAdjacentList(v)) {
            if (!isVisited[adj]) {
                count = count + dfsCount(graph, adj, isVisited);
            }
        }
        return count;
    }
}