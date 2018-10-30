package main;

/**
 * Author: brianfroschauer
 * Date: 30/10/2018
 */
public class Edge<T> {

    private final T vertex1;
    private final T vertex2;

    public Edge(T vertex1, T vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public T getVertex1() {
        return vertex1;
    }

    public T getVertex2() {
        return vertex2;
    }

    public boolean equals(Edge<T> edge) {
        return !(!vertex1.equals(edge.vertex1) || !vertex1.equals(edge.vertex2));
    }
}