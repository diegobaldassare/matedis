package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 11/08/2018
 */
public class UndirectedGraph<T> implements Graph<T> {

    private final List<T> vertexes;
    private final List<Edge<T>> edges;

    public UndirectedGraph(int capacity) {
        vertexes = new ArrayList<>(capacity);
        edges = new ArrayList<>();
    }

    @Override
    public void addEdge(Edge<T> edge) {
        if (!hasEdge(edge)) {
            edges.add(edge);
        }
    }

    @Override
    public void addVertex(T vertex) {
        vertexes.add(vertex);
    }

    @Override
    public void removeVertex(T vertex) {
        vertexes.remove(vertex);
    }

    @Override
    public void removeEdge(Edge<T> edge) {
        edges.remove(edge);
    }

    @Override
    public boolean hasEdge(Edge<T> edge) {
        for (Edge<T> e : edges) {
            if (e.equals(edge)) return true;
        }
        return false;
    }

    @Override
    public int edgesAmount() {
        return edges.size();
    }

    @Override
    public T getVertex(int index) {
        return vertexes.get(index);
    }

    @Override
    public int order() {
        return edges.size();
    }

    @Override
    public List<Edge<T>> getAdjList(T vertex) {
        final List<Edge<T>> adj = new ArrayList<>();
        edges.forEach(edge -> {
            if (edge.getVertex1().equals(vertex) || edge.getVertex2().equals(vertex))
                adj.add(edge);
        });
        return adj;
    }
}