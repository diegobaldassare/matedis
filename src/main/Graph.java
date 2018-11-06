package main;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 11/08/2018
 */
public interface Graph<T> {

    void addEdge(Edge<T> edge);

    void addVertex(T vertex);

    void removeVertex(T vertex);

    void removeEdge(Edge<T> edge);

    boolean hasEdge(Edge<T> edge);

    int edgesAmount();

    T getVertex(int index);

    int order();

    List<Edge<T>> getAdjList(T vertex);

    void print();
}