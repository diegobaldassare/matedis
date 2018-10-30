package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 11/08/2018
 */
public class UndirectedGraph<T> implements Graph<T> {

    private final List<T> v;
    private boolean[][] a;
    private int n;          // Vertexes amount in a
    private int alpha;      // Edges amount in a

    public UndirectedGraph(int capacity) {
        v = new ArrayList<>(capacity);
        a = new boolean[capacity][capacity];
        n = 0;
        alpha = 0;
    }

    public UndirectedGraph() {
        v = new ArrayList<>(10);
        a = new boolean[10][10];
        n = 0;
        alpha = 0;
    }

    @Override
    public void addEdge(int v, int w) {
        if (a.length == n) grow(a);
        if (!hasEdge(v, w)) {
            a[v][w] = a[w][v] = true;
            alpha++;
        }
    }

    @Override
    public void addVertex(T x) {
        v.add(n, x);
        n++;
    }

    @Override
    public void removeVertex(int v) {
        if (n == 0) return;

        for (int i = 0; i < n; i++) {
            for (int j = v; j < n - 1; j++) {
                a[i][j] = a[i][j + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = v; j < n - 1; j++) {
                a[j][i] = a[j + 1][i];
            }
        }
        n--;
    }

    @Override
    public void removeEdge(int v, int w) {
        if (hasEdge(v, w)) {
            a[v][w] = a[w][v] = false;
            alpha--;
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return a[v][w];
    }

    @Override
    public int edgesAmount() {
        return alpha;
    }

    @Override
    public T getVertex(int v) {
        return this.v.get(v);
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public List<Integer> getAdjList(int v) {
        final List<Integer> adj = new ArrayList<>(a.length);
        for (int i = 0; i < n; i++)
            if (a[i][v]) adj.add(i);
        return adj;
    }

    private void grow(boolean[][] graph) {
        final int capacity = graph.length * 2;
        final boolean[][] aux = new boolean[capacity][capacity];
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph.length; j++)
                aux[i][j] = graph[i][j];
    }
}
