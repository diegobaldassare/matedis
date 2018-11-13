package main;

import java.util.List;

import static main.GraphApplication.randomGraph;

/**
 * Created by Diego Baldassare on 2018-11-11.
 */
public class Main {

    public static void main(String[] args) {

        // create random graph
        Graph<Integer> graph = randomGraph();
        graph.print();

        GraphApplication<Integer> graphApplication = new GraphApplication<>();

        System.out.println("Flat Search path: " + graphApplication.flatSearch(graph));
        System.out.println("Depth First Search path: " + GraphApplication.BFS(graph));
        System.out.println("Breadth Search path: " + GraphApplication.DFS(graph));
    }
}
