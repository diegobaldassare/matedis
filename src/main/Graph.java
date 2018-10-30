package main;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 11/08/2018
 */
public interface Graph<T> {

    void addEdge(int v, int w);

    void addVertex(T x);

    void removeVertex(int v);

    void removeEdge(int v, int w);

    boolean hasEdge(int v, int w);

    int edgesAmount();

    T getVertex(int v);

    int order();

    List<Integer> getAdjList(int v);
}
