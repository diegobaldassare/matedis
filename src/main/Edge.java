package main;

import java.util.Objects;

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

    /**
     * Defines that two edges are equal if they contain the same two vertex,
     * no matter in which order.
     * i.e. (1, 0) is equal to (0, 1)
     * @param o the other edge to be compared with
     * @return true if the other edge is equal to this, or false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return (vertex1.equals(edge.vertex1) && vertex2.equals(edge.vertex2)) ||
                (vertex1.equals(edge.vertex2) && vertex2.equals(edge.vertex1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex1, vertex2);
    }
}