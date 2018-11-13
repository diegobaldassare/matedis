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
        if (!hasEdge(edge) &&
            (vertexes.contains(edge.getVertex1()) ||
             vertexes.contains(edge.getVertex2()))) {
                edges.add(edge);
        }
    }

    @Override
    public void addVertex(T vertex) {
        if (!vertexes.contains(vertex)) {
            vertexes.add(vertex);
        }
    }

    @Override
    public void removeVertex(T vertex) {
        edges.removeAll(getAdjList(vertex));
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
        return vertexes.size();
    }

    @Override
    public List<Edge<T>> getAdjList(T vertex) {
        final List<Edge<T>> adj = new ArrayList<>();
        for (Edge<T> edge : edges) {
            if (edge.getVertex1().equals(vertex) || edge.getVertex2().equals(vertex))
                adj.add(edge);
        }
        return adj;
    }

    public int getVertexDegree(T vertex) {
        return getAdjList(vertex).size();
    }

    public void print() {
        if (vertexes.size() > 0) {
            System.out.print("Vertexes: {");
            for (int i = 0; i < vertexes.size()-1; i++) {
                System.out.print(vertexes.get(i) + ", ");
            }
            System.out.print(vertexes.get(vertexes.size()-1) + "}");
        } else {
            System.out.println("Vertex is empty");
        }

        if (edges.size() > 0) {
            System.out.print("\nEdges: {");
            for (int i = 0; i < edges.size()-1; i++) {
                System.out.print("(" + edges.get(i).getVertex1() + ", " + edges.get(i).getVertex2() + "), ");
            }
            System.out.print("(" + edges.get(edges.size()-1).getVertex1() + ", " + edges.get(edges.size()-1).getVertex2() + ")}");
        } else {
            System.out.println("\nEdges is empty");
        }
    }
}